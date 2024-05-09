/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.managedBeans.vehicle;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author edwar
 */
@ManagedBean
public class VehicleView {
    private int id;
    private String plate;
    private String brand;
    private String model;
    private String driverIdentification;
    private String driverName;
    private boolean status;
    private int provider;

    public VehicleView(int id, String plate, String brand, String model, String driverIdentification, String driverName, boolean status, int provider) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.driverIdentification = driverIdentification;
        this.driverName = driverName;
        this.status = status;
        this.provider = provider;
    }

    public VehicleView() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDriverIdentification() {
        return driverIdentification;
    }

    public void setDriverIdentification(String driverIdentification) {
        this.driverIdentification = driverIdentification;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "VehicleView{" + "id=" + id + ", plate=" + plate + ", brand=" + brand + ", model=" + model + ", driverIdentification=" + driverIdentification + ", driverName=" + driverName + ", status=" + status + ", provider=" + provider + '}';
    }
    
    
    
    
}
