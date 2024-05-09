/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.driven_adapters.adapters.provider;

import domain.model.softtek.provider.Provider;
import domain.model.softtek.provider.gateways.ProviderRepository;
import infraestructure.driven_adapters.config.ConexionJPA;
import infraestructure.driven_adapters.util.CodeBuilderAdapters;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author edwar
 */
public class ProviderAdapter implements ProviderRepository {
    
    private CodeBuilderAdapters codeBuilderAdapters;
    private EntityManager entityManager;
    
    public ProviderAdapter(){
        codeBuilderAdapters = new CodeBuilderAdapters();
    }

    @Override
    public Provider save(Provider provider) {
        ProviderEntity providerEntity = codeBuilderAdapters.toEntityProvider(provider);
        entityManager = ConexionJPA.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(providerEntity);
            entityManager.getTransaction().commit();
            System.out.println("Provider guardado correctamente");
         } catch(Exception e ){
            System.out.println("Error provider adapter: " + e.getMessage());
        }
        return provider;
    }

    @Override
    public Provider edit(Provider provider) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Provider> providers() {
        entityManager = ConexionJPA.createEntityManager();
        List<ProviderEntity> listProvider = new ArrayList<>();
        List<Provider> listProviderModel = new ArrayList<>();
        try {
            Query query = entityManager.createNamedQuery("Provider.findAll");
            listProvider = query.getResultList();
            
            for (ProviderEntity providerEntity : listProvider) {
                Provider providerModel = codeBuilderAdapters.toProviderModel(providerEntity);
                listProviderModel.add(providerModel);    
            }
        }catch(Exception e ){
            System.out.println("Error provider adapter: " + e.getMessage());
        }
        return listProviderModel;
    }

    @Override
    public Provider findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
