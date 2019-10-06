package pl.dominikpiotrowski.order;

import pl.dominikpiotrowski.factories.VehicleFactory;
import pl.dominikpiotrowski.factoryLogs.TestOrderLogWriter;
import pl.dominikpiotrowski.productionValues.ProdutionCost;
import pl.dominikpiotrowski.vehicles.Vehicle;
import pl.dominikpiotrowski.vehicles.VehicleType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrder {

    public void produceOrder() throws IOException {

        ItemOrdered testItemOrdered1 = new ItemOrdered();
        testItemOrdered1.setVehicleType(VehicleType.CAR);

        ItemOrdered testItemOrdered2 = new ItemOrdered();
        testItemOrdered2.setVehicleType(VehicleType.CAR);

        ItemOrdered testItemOrdered3 = new ItemOrdered();
        testItemOrdered3.setVehicleType(VehicleType.TRUCK);

        List<ItemOrdered> orderList = new ArrayList<>();
        orderList.add(testItemOrdered1);
        orderList.add(testItemOrdered2);
        orderList.add(testItemOrdered3);

        VehicleFactory factory = new VehicleFactory();
        List<Long> totalProductionTimeList = new ArrayList<>();

        for (ItemOrdered itemOrdered : orderList) {
            Vehicle created = factory.produce(itemOrdered);

            if (created.getClass().getName().equals("pl.dominikpiotrowski.vehicles.Truck")) {
                totalProductionTimeList.add(ProdutionCost.TRUCK.getProductionCostValue());

            } else if (created.getClass().getName().equals("pl.dominikpiotrowski.vehicles.Car")) {
                totalProductionTimeList.add(ProdutionCost.CAR.getProductionCostValue());

            } else if (created.getClass().getName().equals("pl.dominikpiotrowski.vehicles.Motorcycle")) {
                totalProductionTimeList.add(ProdutionCost.MOTORCYCLE.getProductionCostValue());
            }
        }
        long cost = 0;
        for (Long e : totalProductionTimeList) cost += e;
        System.out.println("Test order production cost: " + cost);

        notifyObserver(cost, orderList);
    }

    private void notifyObserver(Long cost, List orderList) {
        TestOrderLogWriter testOrderLogWriter = new TestOrderLogWriter();
        testOrderLogWriter.notify(cost, orderList);
    }
}