public class FoodItem implements ItemElement {

    private int price;

    private String title;

    public FoodItem(int price, String title){
        this.price =price;
        this.title = title;
    }

    public int getPrice() {
        return price;
    }


    public String getTitle(){
        return this.title;
    }


    public int accept(ShoppingCardVisitor visitor) {
        return visitor.visit(this);
    }

}