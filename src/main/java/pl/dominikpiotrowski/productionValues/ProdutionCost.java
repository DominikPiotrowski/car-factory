package pl.dominikpiotrowski.productionValues;

public enum ProdutionCost {
    CAR(1000), MOTORCYCLE(600), TRUCK(2000);

    private final long productionCost;

    ProdutionCost(final long value) {
        this.productionCost = value;
    }

    public long getProductionCostValue() {
        return productionCost;
    }

}
