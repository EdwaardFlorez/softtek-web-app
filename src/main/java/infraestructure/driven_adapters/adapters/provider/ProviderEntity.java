/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.driven_adapters.adapters.provider;

import infraestructure.driven_adapters.adapters.vehicle.VehicleEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "provider")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
    @NamedQuery(name = "Provider.findAll", query = "SELECT p FROM Provider p")})
public class ProviderEntity implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerEntity")
    private List<VehicleEntity> vehicleList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "provider_id")
    private Integer providerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "provider_name")
    private String providerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "provider_identification")
    private String providerIdentification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "provider_vehicles")
    private int providerVehicles;

    public ProviderEntity(Integer providerId) {
        this.providerId = providerId;
    }

    public ProviderEntity(Integer providerId, String providerName, String providerIdentification, int providerVehicles) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.providerIdentification = providerIdentification;
        this.providerVehicles = providerVehicles;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderIdentification() {
        return providerIdentification;
    }

    public void setProviderIdentification(String providerIdentification) {
        this.providerIdentification = providerIdentification;
    }

    public int getProviderVehicles() {
        return providerVehicles;
    }

    public void setProviderVehicles(int providerVehicles) {
        this.providerVehicles = providerVehicles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providerId != null ? providerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProviderEntity)) {
            return false;
        }
        ProviderEntity other = (ProviderEntity) object;
        if ((this.providerId == null && other.providerId != null) || (this.providerId != null && !this.providerId.equals(other.providerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "infraestructure.driven_adapters.adapters.provider.Provider[ providerId=" + providerId + " ]";
    }

    public List<VehicleEntity> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<VehicleEntity> vehicleList) {
        this.vehicleList = vehicleList;
    }
    
}
