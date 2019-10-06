package pl.dominikpiotrowski.factoryLogs;

import java.io.IOException;
import java.util.List;

public interface Observer {
    void notify(Long cost, List vehiclesProduced) throws IOException;
}