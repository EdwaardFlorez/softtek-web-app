/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.driven_adapters.util;

import domain.model.softtek.provider.Provider;
import infraestructure.driven_adapters.adapters.provider.ProviderEntity;

/**
 *
 * @author edwar
 */
public class CodeBuilderAdapters {
    
    public CodeBuilderAdapters() {
    }
    
    public ProviderEntity toEntityProvider(Provider provider){
    	ProviderEntity providerEntity = new ProviderEntity();
    	providerEntity.setProviderName(provider.getName());
    	providerEntity.setProviderIdentification(provider.getIdentification());
    	providerEntity.setProviderEmail(provider.getEmail());
    	providerEntity.setProviderVehicles(provider.getNumberOfVehicles());
    	
        return providerEntity;
    }
    
    public Provider toProviderModel(ProviderEntity providerEntity){
        Provider providerModel = new Provider();
        providerModel.setId(providerEntity.getProviderId());
        providerModel.setName(providerEntity.getProviderName());
        providerModel.setIdentification(providerEntity.getProviderIdentification());
        providerModel.setEmail(providerEntity.getProviderEmail());
        providerModel.setNumberOfVehicles(providerEntity.getProviderVehicles());
        return providerModel;
    }

    
    
}
