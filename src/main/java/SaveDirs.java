public class SaveDirs {
    private String jsonPath;
    private String pathToSave;

    SaveDirs(String jsonPath, String pathToSave) {
        this.jsonPath = jsonPath;
        this.pathToSave = pathToSave;
    }

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public String getPathToSave() {
        return pathToSave;
    }

    public void setPathToSave(String pathToSave) {
        this.pathToSave = pathToSave;
    }
}
