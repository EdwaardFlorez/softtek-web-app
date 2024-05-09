/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.driven_adapters.adapters.provider;

import domain.model.softtek.provider.Provider;
import domain.model.softtek.provider.gateways.ProviderRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author edwar
 */
public class ProviderAdapter implements ProviderRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Provider save(Provider provider) {
        try {
            entityManager.persist(provider);
            System.out.println("Provider guardado correctamente");
        } catch (Exception e) {
            System.out.println("error provider!!!!: "+ e);
        }
        return provider;
    }

    @Override
    public Provider edit(Provider provider) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Provider> providers() {
        List<Provider> listProvider = null;
        try {
            Query query = entityManager.createNamedQuery("Provider.findAll");
            listProvider = query.getResultList();
        } catch (Exception e) {
            System.out.println("error provider!!!!: "+ e);
        }
        return listProvider;
    }

    @Override
    public Provider findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
