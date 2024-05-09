/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.usecase.softtek.provider;

import domain.model.softtek.provider.Provider;
import domain.model.softtek.provider.gateways.ProviderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
/**
 *
 * @author edwar
 */
@RequiredArgsConstructor
public class ProviderUseCase {
    private final ProviderRepository providerRepository;
    
    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }
    
    public List<Provider> getProviders() {
        return providerRepository.providers();
    }
}
