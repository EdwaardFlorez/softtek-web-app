/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.managedBeans.util;

import domain.model.softtek.provider.Provider;
import infraestructure.managedBeans.provider.ProviderView;

/**
 *
 * @author edwar
 */
public class CodeBuilderMB {
    public Provider buildProviderModel(ProviderView providerView){
        Provider provider = new Provider();
        provider.setName(providerView.getName());
        provider.setIdentification(providerView.getIdentification());
        provider.setEmail(providerView.getEmail());

        return provider;
    }
    
    public ProviderView buildProviderView(Provider provider){
        ProviderView providerView = new ProviderView();
        providerView.setId(provider.getId());
        providerView.setName(provider.getName());
        providerView.setIdentification(provider.getIdentification());
        providerView.setEmail(provider.getEmail());
        providerView.setNumberOfVehicles(provider.getNumberOfVehicles());
        return providerView;
    }
}
