/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.managedBeans.provider;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author edwar
 */
@ManagedBean
public class ProviderView {
    private int id;
    private String name;
    private String identification;
    private String email;
    private int numberOfVehicles;
    
    public ProviderView() {
        
    }

    public ProviderView(int id, String name, String identification, String email, int numberOfVehicles) {
        this.id = id;
        this.name = name;
        this.identification = identification;
        this.email = email;
        this.numberOfVehicles = numberOfVehicles;
    }
    
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getIdentification(){
        return identification;
    }
    
    public void setIdentification(String identification){
        this.identification = identification;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getNumberOfVehicles() {
	return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
	this.numberOfVehicles = numberOfVehicles;
    }

    @Override
    public String toString() {
        return "ProviderView{" + "id=" + id + ", name=" + name + ", identification=" + identification + ", email=" + email + ", numberOfVehicles=" + numberOfVehicles + '}';
    }
    
    
}
