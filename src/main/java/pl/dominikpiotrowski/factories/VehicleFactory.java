package pl.dominikpiotrowski.factories;

import pl.dominikpiotrowski.order.ItemOrdered;
import pl.dominikpiotrowski.vehicles.*;

public class VehicleFactory {

    public Vehicle produce(ItemOrdered itemOrdered) {

        Vehicle vehicleToProduce = null;
        VehicleType type = itemOrdered.getVehicleType();

        if (type.equals(VehicleType.CAR)) {
            return new Car();
        }

        if (type.equals(VehicleType.MOTORCYCLE)) {
            return new Motorcycle();
        }

        if (type.equals(VehicleType.TRUCK)) {
            return new Truck();
        }
        return vehicleToProduce;
    }
}