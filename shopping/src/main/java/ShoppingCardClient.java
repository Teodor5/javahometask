public class ShoppingCardClient {

    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{new ElectronicsItem(20, "Nokia"),new ElectronicsItem(100, "Samsung"),
                new FoodItem(10,  "Banana"), new FoodItem(5, "Apple")};

        int total = calculatePrice(items);
        System.out.println("Total Cost = "+total);
    }

    private static int calculatePrice(ItemElement[] items) {
        ShoppingCardVisitor visitor = new Shopping();
        int sum=0;
        for(ItemElement item : items){
            sum = sum + item.accept(visitor);
        }
        return sum;
    }

}