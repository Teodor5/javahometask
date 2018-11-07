public class Shopping implements ShoppingCardVisitor {


    public int visit(ElectronicsItem electronicsItem) {
        int cost = electronicsItem.getPrice();
        System.out.println(electronicsItem.getTitle() + " cost ="+cost);
        return cost;
    }


    public int visit(FoodItem foodItem) {
        int cost = foodItem.getPrice();
        System.out.println(foodItem.getTitle() + " cost = "+cost);
        return cost;
    }

}