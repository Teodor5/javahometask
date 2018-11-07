public interface ShoppingCardVisitor {

    int visit(ElectronicsItem electronicsItem);
    int visit(FoodItem foodItem);
}