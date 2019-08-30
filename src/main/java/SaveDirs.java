public class SaveDirs {
    private String imgUrl;
    private String urlToSave;

    SaveDirs(String imgUrl, String urlToSave) {
        this.imgUrl = imgUrl;
        this.urlToSave = urlToSave;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUrlToSave() {
        return urlToSave;
    }

    public void setUrlToSave(String urlToSave) {
        this.urlToSave = urlToSave;
    }
}
