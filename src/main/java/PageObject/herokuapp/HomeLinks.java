package PageObject.herokuapp;

public enum HomeLinks {
    CONTEXT_MENU("Context Menu"),
    FILE_DOWNLOAD("File Download"),
    FILE_UPLOAD("File Upload"),
    FRAMES("Frames"),
    DYNAMIC_CONTROLS("Dynamic Controls");

    String link;

    public String getLink() {
        return link;
    }

    HomeLinks(String link) {
        this.link = link;
    }
}
