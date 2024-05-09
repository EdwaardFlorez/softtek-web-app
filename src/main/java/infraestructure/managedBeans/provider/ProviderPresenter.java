/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.managedBeans.provider;

import domain.model.softtek.provider.Provider;
import domain.usecase.softtek.provider.ProviderUseCase;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author edwar
 */
@ManagedBean
@ApplicationScoped
@AllArgsConstructor
@Data
public class ProviderPresenter {
    private final ProviderUseCase providerUseCase;
    
    private List<Provider> providers;
    
    public void loadProviders() {
        providers.clear();
        try {
            // get all students from database
	    providers = providerUseCase.getProviders();
        } catch (Exception e) {
            System.out.println("error desde provider presenter!!!!: "+ e);
        }
    }
    
}
