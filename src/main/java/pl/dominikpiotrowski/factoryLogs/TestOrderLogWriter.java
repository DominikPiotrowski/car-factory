package pl.dominikpiotrowski.factoryLogs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TestOrderLogWriter implements Observer {

    @Override
    public void notify(Long cost, List vehiclesProduced) {
        if (cost != null) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                        "C:\\Users\\piotr\\IdeaProjects\\car-factory\\src\\main\\Resources\\testOrder.log",
                        true));
                bufferedWriter.write("Order produced on: " + new Date().toString()
                        + ", Cost of order:  " + cost
                        + ", Number of vehicles produced: " + vehiclesProduced.size()
                        + "\n");
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}