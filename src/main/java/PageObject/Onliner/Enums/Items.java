package PageObject.Onliner.Enums;

public enum Items {
    FIRST_ITEM_CONSOLES(".schema-product__title");
    String items;

    Items(String items) {
        this.items = items;
    }

    public String getItems() {
        return items;
    }
}
