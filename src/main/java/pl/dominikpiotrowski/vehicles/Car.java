package pl.dominikpiotrowski.vehicles;

import pl.dominikpiotrowski.builders.VehicleBuilder;
import pl.dominikpiotrowski.order.ItemOrdered;
import pl.dominikpiotrowski.productionValues.ProductionTime;
import pl.dominikpiotrowski.productionValues.ProdutionCost;

public class Car implements Vehicle {

    VehicleBuilder carBuilder = new VehicleBuilder();

    ItemOrdered car = carBuilder
            .withProductionTime(ProductionTime.CAR)
            .withProductionCost(ProdutionCost.CAR)
            .build();
}