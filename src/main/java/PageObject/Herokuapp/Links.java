package PageObject.Herokuapp;

public enum Links {
    CONTEXT_MENU("Context Menu"),
    FILE_UPLOAD("File Upload"),
    DYNAMIC_CONTROLS("Dynamic Controls");

    String link;

   Links(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
