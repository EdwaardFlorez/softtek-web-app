/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.managedBeans.provider;

import domain.model.softtek.provider.Provider;
import domain.model.softtek.provider.gateways.ProviderRepository;
import domain.usecase.softtek.provider.ProviderUseCase;
import infraestructure.driven_adapters.adapters.provider.ProviderAdapter;
import infraestructure.managedBeans.util.CodeBuilderMB;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author edwar
 */
@ManagedBean
@SessionScoped
public class ProviderPresenter {
    private ProviderUseCase providerUseCase;
    private ProviderRepository providerRepository;
    private CodeBuilderMB codeBuilderMB;
    
    private List<ProviderView> providersView;
    
    private Logger logger = Logger.getLogger(getClass().getName());

    public ProviderPresenter(){
        providersView = new ArrayList<>();
        providerRepository = new ProviderAdapter();
        providerUseCase = new ProviderUseCase(providerRepository);
        codeBuilderMB = new CodeBuilderMB();
    }

    public List<ProviderView> getProviders() {
        return providersView;
    }

    public void setProviders(List<ProviderView> providers) {
        this.providersView = providers;
    }
    
    
    
    public void loadProviders() {
        List<Provider> providers;
        this.providersView.clear();
        logger.info("Loading students");
        try {
            // get all students from database
	    providers = providerUseCase.getProviders();
        
            for (Provider provider : providers) {
            ProviderView providerView = codeBuilderMB.buildProviderView(provider);
            providersView.add(providerView);
        }
        } catch (Exception e) {
            System.out.println("error desde provider presenter!!!!: "+ e);
        }
    }
    
    public String addProvider(ProviderView providerView){
        System.out.println("ENTRAAAA!!!!: ");
        logger.info("add students");
        Provider provider = codeBuilderMB.buildProviderModel(providerView);
        
        try {
            // add student to the database
            providerUseCase.saveProvider(provider);
        } catch (Exception e) {
            System.out.println("error desde provider presenter!!!!: "+ e);
        }
        
        return "list-providers?faces-redirect=true";
    }
    
}
