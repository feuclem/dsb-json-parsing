package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Bonus;
import domain.Equipment;
import domain.FromTo;
import domain.PanoplieBonus;
import domain.Statistic;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class PanoplieBonusParser {

    public void handle() throws FileNotFoundException {
        Equipment[] el = new GsonBuilder().create().fromJson(new FileReader(getClass().getResource("/equipements.json").getPath()), Equipment[].class);
        List<Integer> setIdList = Arrays.stream(el).map(Equipment::getSetId).collect(Collectors.toList());

        setIdList.forEach(integer -> {
            if(integer != 0) {
                writeInFile(integer);
            }
        });
    }

    public void createAllJsonFile(List<Integer> setIdList) throws IOException {
        FileUtils.cleanDirectory(new File(getClass().getResource("/panoplies").getPath()));
        setIdList.forEach(id -> {
            File file = new File(getClass().getResource("/panoplies").getPath(), id + ".json");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void writeInFile(Integer id) {
        PanoplieBonus panoplieBonus = new PanoplieBonus();

        File pathFile = new File(getClass().getResource("/panoplies/" + id + ".json").getPath());
        if(pathFile.length() == 0) {
            System.out.println("PARSER LA PANOPLIE ID : " + id);
            Executor delayed = CompletableFuture.delayedExecutor(5L, TimeUnit.SECONDS);
            CompletableFuture.supplyAsync(() -> "izi", delayed)
                    .thenAccept(s -> {

                        try {
                            Document doc = Jsoup.connect("https://www.dofus.com/fr/mmorpg/encyclopedie/panoplies/" + id).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36").get();
                            Elements setBonusList = doc.select("body .ak-encyclo-detail-right .set-bonus-list");
                            List<Bonus> bonusList = new ArrayList<>(Collections.emptyList());
                            int numberOfItemInBonus = 2;
                            for (Element setBonus : setBonusList) {
                                List<Statistic> statisticList = new ArrayList<>(Collections.emptyList());

                                List<String> bonusHmtl = Arrays.asList(setBonus.select(".ak-title").html().split("\n"));
                                bonusHmtl.forEach(valueInHtml -> {
                                    if (valueInHtml.contains("Dommages Critiques")) {
                                        Statistic stat = new Statistic();
                                        stat.setDommagesCritiques(
                                                new FromTo(
                                                        valueInHtml.split(" ")[0],
                                                        valueInHtml.split(" ")[0]
                                                )
                                        );
                                        statisticList.add(stat);
                                    } else if (valueInHtml.contains("Puissance")) {
                                        Statistic stat = new Statistic();
                                        stat.setPuissance(
                                                new FromTo(
                                                        valueInHtml.split(" ")[0],
                                                        valueInHtml.split(" ")[0]
                                                )
                                        );
                                        statisticList.add(stat);
                                    } else if (valueInHtml.contains("PA")) {
                                        Statistic stat = new Statistic();
                                        stat.setPa(
                                                new FromTo(
                                                        valueInHtml.split(" ")[0],
                                                        valueInHtml.split(" ")[0]
                                                )
                                        );
                                        statisticList.add(stat);
                                    } else {
                                        Statistic stat = new Statistic();
                                        stat.setVitalite(
                                                new FromTo(
                                                        valueInHtml.split(" ")[0],
                                                        valueInHtml.split(" ")[0]
                                                )
                                        );
                                        statisticList.add(stat);
                                    }
                                });
                                Bonus bonus = new Bonus();
                                bonus.setNumber(numberOfItemInBonus);
                                bonus.setStats(statisticList);
                                bonusList.add(bonus);
                                panoplieBonus.setId(id);
                                panoplieBonus.setBonus(bonusList);
                                numberOfItemInBonus++;
                            }

                            Writer writer = new FileWriter(getClass().getResource("/panoplies/" + id + ".json").getPath());
                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            gson.toJson(panoplieBonus, writer);
                            writer.flush();
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    })
                    .join();
        } else {
            System.out.println("LA PANOPLIE ID : " + id + " EST DEJA PARSEE");
        }
    }
}
