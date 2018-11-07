public class ElectronicsItem implements ItemElement {
    private int price;
    private String title;

    public ElectronicsItem(int cost, String title){
        this.price=cost;
        this.title =title;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int accept(ShoppingCardVisitor visitor) {
        return visitor.visit(this);
    }
}
