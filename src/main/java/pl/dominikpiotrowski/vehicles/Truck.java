package pl.dominikpiotrowski.vehicles;

import pl.dominikpiotrowski.builders.VehicleBuilder;
import pl.dominikpiotrowski.order.ItemOrdered;
import pl.dominikpiotrowski.productionValues.ProductionTime;
import pl.dominikpiotrowski.productionValues.ProdutionCost;

public class Truck implements Vehicle {

    VehicleBuilder truckBuilder = new VehicleBuilder();

    ItemOrdered truck = truckBuilder
            .withProductionTime(ProductionTime.TRUCK)
            .withProductionCost(ProdutionCost.TRUCK)
            .build();
}