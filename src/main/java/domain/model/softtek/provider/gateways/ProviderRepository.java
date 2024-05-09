/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain.model.softtek.provider.gateways;

import domain.model.softtek.provider.Provider;
import java.util.List;

/**
 *
 * @author edwar
 */
public interface ProviderRepository {
    
    Provider save(Provider provider);
    
    Provider edit(Provider provider);
    
    List<Provider> providers();
    
    Provider findById(int id);
}
