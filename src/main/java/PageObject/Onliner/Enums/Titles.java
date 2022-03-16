package PageObject.Onliner.Enums;

public enum Titles {
    MOBILE_TITLE("h1"),
    GAMING_CONSOLES_TITLE("h1");
    String titles;

    Titles(String titles) {
        this.titles = titles;
    }

    public String getTitles() {
        return titles;
    }
}
