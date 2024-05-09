/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.driven_adapters.adapters.vehicle;

import infraestructure.driven_adapters.adapters.provider.ProviderEntity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "vehicle")
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")})
public class VehicleEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vehicle_id")
    private Integer vehicleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "vehicle_plate")
    private String vehiclePlate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vehicle_brand")
    private String vehicleBrand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "vehicle_model")
    private String vehicleModel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "vehicle_driver_identification")
    private String vehicleDriverIdentification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vehicle_driver_name")
    private String vehicleDriverName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicle_status")
    private short vehicleStatus;
    @Lob
    @Size(max = 1073741824)
    @Column(name = "vehicle_shcedule")
    private String vehicleShcedule;
    @JoinColumn(name = "vehicle_provider", referencedColumnName = "provider_id")
    @ManyToOne(optional = false)
    private ProviderEntity providerEntity;

    public VehicleEntity() {
    }

    public VehicleEntity(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleEntity(Integer vehicleId, String vehiclePlate, String vehicleBrand, String vehicleModel, String vehicleDriverIdentification, String vehicleDriverName, short vehicleStatus) {
        this.vehicleId = vehicleId;
        this.vehiclePlate = vehiclePlate;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleDriverIdentification = vehicleDriverIdentification;
        this.vehicleDriverName = vehicleDriverName;
        this.vehicleStatus = vehicleStatus;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleDriverIdentification() {
        return vehicleDriverIdentification;
    }

    public void setVehicleDriverIdentification(String vehicleDriverIdentification) {
        this.vehicleDriverIdentification = vehicleDriverIdentification;
    }

    public String getVehicleDriverName() {
        return vehicleDriverName;
    }

    public void setVehicleDriverName(String vehicleDriverName) {
        this.vehicleDriverName = vehicleDriverName;
    }

    public short getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(short vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getVehicleShcedule() {
        return vehicleShcedule;
    }

    public void setVehicleShcedule(String vehicleShcedule) {
        this.vehicleShcedule = vehicleShcedule;
    }

    public ProviderEntity getProviderEntity() {
        return providerEntity;
    }

    public void setProviderEntity(ProviderEntity providerEntity) {
        this.providerEntity = providerEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleId != null ? vehicleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleEntity)) {
            return false;
        }
        VehicleEntity other = (VehicleEntity) object;
        if ((this.vehicleId == null && other.vehicleId != null) || (this.vehicleId != null && !this.vehicleId.equals(other.vehicleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "infraestructure.driven_adapters.adapters.vehicle.Vehicle[ vehicleId=" + vehicleId + " ]";
    }
    
}
