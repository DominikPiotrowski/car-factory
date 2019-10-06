package pl.dominikpiotrowski.order;

import pl.dominikpiotrowski.productionValues.ProductionTime;
import pl.dominikpiotrowski.productionValues.ProdutionCost;
import pl.dominikpiotrowski.vehicles.VehicleType;

public class ItemOrdered {

    protected VehicleType vehicleType;
    protected ProdutionCost produtionCost;
    protected ProductionTime productionTime;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    protected void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ProdutionCost getProdutionCost() {
        return produtionCost;
    }

    public void setProdutionCost(ProdutionCost produtionCost) {
        this.produtionCost = produtionCost;
    }

    public ProductionTime getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(ProductionTime productionTime) {
        this.productionTime = productionTime;
    }
}
