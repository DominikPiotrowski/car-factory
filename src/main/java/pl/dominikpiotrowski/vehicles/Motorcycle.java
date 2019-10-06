package pl.dominikpiotrowski.vehicles;

import pl.dominikpiotrowski.builders.VehicleBuilder;
import pl.dominikpiotrowski.order.ItemOrdered;
import pl.dominikpiotrowski.productionValues.ProductionTime;
import pl.dominikpiotrowski.productionValues.ProdutionCost;

public class Motorcycle implements Vehicle {

    VehicleBuilder motocycleBuilder = new VehicleBuilder();

    ItemOrdered moto = motocycleBuilder
            .withProductionTime(ProductionTime.MOTORCYCLE)
            .withProductionCost(ProdutionCost.MOTORCYCLE)
            .build();
}