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
    public ProviderEntity toEntityProvider(Provider provider){
        return ProviderEntity.builder()
                .providerName(provider.getName())
                .providerIdentification(provider.getIdentification())
                .providerVehicles(provider.getNumberOfVehicles())
                .build();
    }
}
