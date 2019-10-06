package pl.dominikpiotrowski.order;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.dominikpiotrowski.builders.VehicleBuilder;
import pl.dominikpiotrowski.factoryLogs.JsonOrderLogWriter;
import pl.dominikpiotrowski.productionValues.ProductionTime;
import pl.dominikpiotrowski.productionValues.ProdutionCost;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonOrder extends Thread {

    public List<ItemOrdered> read(String file) throws IOException, InterruptedException {

        List<ItemOrdered> vehicles = new ArrayList<>();

        try {
            byte[] orderJsonFile = Files.readAllBytes(Paths.get(file));
            String fileContents = new String(orderJsonFile, "UTF-8");

            JSONObject jsonObject = new JSONObject(fileContents);
            JSONArray orderArray = jsonObject.optJSONArray("order");

            for (Object orderObj : orderArray) {
                JSONObject temp = new JSONObject(orderObj.toString());
                String item = temp.getString("item");

                VehicleBuilder vehicleBuilder = new VehicleBuilder();

                if (item.equals("car")) {
                    Thread t1 = new Thread();
                    t1.start();
                    t1.sleep(10000);

                    ItemOrdered createCar = vehicleBuilder
                            .withProductionCost(ProdutionCost.CAR)
                            .withProductionTime(ProductionTime.CAR)
                            .build();
                    vehicles.add(createCar);

                } else if (item.equals("truck")) {
                    Thread t2 = new Thread();
                    t2.start();
                    t2.sleep(15000);

                    ItemOrdered createTruck = vehicleBuilder
                            .withProductionCost(ProdutionCost.TRUCK)
                            .withProductionTime(ProductionTime.TRUCK)
                            .build();
                    vehicles.add(createTruck);

                } else if (item.equals("motocycle")) {
                    Thread t3 = new Thread();
                    t3.start();
                    t3.sleep(5000);

                    ItemOrdered createMotocycle = vehicleBuilder
                            .withProductionCost(ProdutionCost.MOTORCYCLE)
                            .withProductionTime(ProductionTime.MOTORCYCLE)
                            .build();
                    vehicles.add(createMotocycle);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        long cost = 0;
        for (ItemOrdered itemOrdered : vehicles) cost += itemOrdered.produtionCost.getProductionCostValue();
        System.out.println("Json order production cost: " + cost);

        notifyObserver(cost, vehicles);

        return vehicles;
    }

    private void notifyObserver(Long cost, List orderList) throws IOException {
        JsonOrderLogWriter jsonOrderLogWriter = new JsonOrderLogWriter();
        jsonOrderLogWriter.notify(cost, orderList);
    }
}