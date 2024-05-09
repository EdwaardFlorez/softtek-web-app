/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain.model.softtek.vehicle.gateways;

import domain.model.softtek.vehicle.Vehicle;
import java.util.List;

/**
 *
 * @author edwar
 */
public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    
    Vehicle edit(Vehicle vehicle);
    
    List<Vehicle> vehicles();
    
    Vehicle findById(int id);
}
