package de.gedoplan.showcase.jnosql.repository;

import jakarta.nosql.Settings;
import jakarta.nosql.document.DocumentCollectionManager;
import jakarta.nosql.document.DocumentCollectionManagerFactory;
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

    private static final String COLLECTION = "customer";
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
    public DocumentCollectionManager getManager() {
        return managerFactory.get(COLLECTION);
    }
    
}
