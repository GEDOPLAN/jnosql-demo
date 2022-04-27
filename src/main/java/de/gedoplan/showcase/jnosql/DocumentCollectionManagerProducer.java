package de.gedoplan.showcase.jnosql;

import jakarta.nosql.Settings;
import jakarta.nosql.document.DocumentCollectionManager;
import jakarta.nosql.document.DocumentCollectionManagerFactory;
import jakarta.nosql.mapping.Database;
import jakarta.nosql.mapping.DatabaseType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.eclipse.jnosql.communication.mongodb.document.MongoDBDocumentConfiguration;
import org.eclipse.jnosql.communication.mongodb.document.MongoDBDocumentConfigurations;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@ApplicationScoped
public class DocumentCollectionManagerProducer implements Serializable {

    public static final String CUSTOMER_COLLECTION = "customer";
    public static final String ORDER_COLLECTION = "order";
    
    private MongoDBDocumentConfiguration configuration;
    private DocumentCollectionManagerFactory managerFactory;
    
    @PostConstruct
    public void init() {
        configuration = new MongoDBDocumentConfiguration();
        Map<String, Object> settings = new HashMap<>();
        settings.put(MongoDBDocumentConfigurations.HOST.get(), "mongodb:27017");
        settings.put(MongoDBDocumentConfigurations.USER.get(), "root");
        settings.put(MongoDBDocumentConfigurations.PASSWORD.get(), "example");
        settings.put(MongoDBDocumentConfigurations.AUTHENTICATION_SOURCE.get(), "admin");
        managerFactory = configuration.get(Settings.of(settings));
    }
    
    @Produces
    @Database(value = DatabaseType.DOCUMENT, provider = DocumentCollectionManagerProducer.CUSTOMER_COLLECTION)
    public DocumentCollectionManager getCustomerManager() {
        return managerFactory.get(CUSTOMER_COLLECTION);
    }
    
    @Produces
    @Database(value = DatabaseType.DOCUMENT, provider = DocumentCollectionManagerProducer.ORDER_COLLECTION)
    public DocumentCollectionManager getOrderManager() {
        return managerFactory.get(ORDER_COLLECTION);
    }
    
}
