package pl.dominikpiotrowski.productionValues;

public enum ProductionTime {
    CAR(10), MOTORCYCLE(5), TRUCK(15);

    private final long produtionTime;

    ProductionTime(final long value) {
        produtionTime = value;
    }

    public long getProdutionTimeValue() {
        return produtionTime;
    }
}