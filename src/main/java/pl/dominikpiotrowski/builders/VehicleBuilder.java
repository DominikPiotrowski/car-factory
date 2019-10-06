package pl.dominikpiotrowski.builders;

import pl.dominikpiotrowski.order.ItemOrdered;
import pl.dominikpiotrowski.productionValues.ProductionTime;
import pl.dominikpiotrowski.productionValues.ProdutionCost;

public class VehicleBuilder {
    private ItemOrdered itemOrdered;

    public VehicleBuilder() {
        this.itemOrdered = new ItemOrdered();
    }

    public VehicleBuilder withProductionTime(ProductionTime productionTime) {
        itemOrdered.setProductionTime(productionTime);
        return this;
    }

    public VehicleBuilder withProductionCost(ProdutionCost productionCost) {
        itemOrdered.setProdutionCost(productionCost);
        return this;
    }

    public ItemOrdered build() {
        return itemOrdered;
    }
}