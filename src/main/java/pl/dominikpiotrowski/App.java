package pl.dominikpiotrowski;

import pl.dominikpiotrowski.order.JsonOrder;
import pl.dominikpiotrowski.order.TestOrder;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        //items fixed in code, no threads:
        TestOrder testOrder = new TestOrder();
        testOrder.produceOrder();

        //implementation from json:
        JsonOrder jsonOrder = new JsonOrder();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        jsonOrder.read("C:\\Users\\piotr\\IdeaProjects\\car-factory\\src\\main\\Resources\\order.json");
        executorService.submit(jsonOrder);
        executorService.shutdown();
    }
}