package de.gedoplan.showcase.jnosql;

import jakarta.nosql.Settings;
import jakarta.nosql.keyvalue.BucketManager;
import jakarta.nosql.keyvalue.BucketManagerFactory;
import jakarta.nosql.keyvalue.KeyValueConfiguration;
import jakarta.nosql.mapping.Database;
import jakarta.nosql.mapping.DatabaseType;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.eclipse.jnosql.communication.redis.keyvalue.RedisConfiguration;
import org.eclipse.jnosql.communication.redis.keyvalue.RedisConfigurations;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@ApplicationScoped
public class BucketManagerProducer implements Serializable {

    private static final String BUCKET = "parts";

    private KeyValueConfiguration configuration;

    private BucketManagerFactory managerFactory;

    @PostConstruct
    public void init() {
        configuration = new RedisConfiguration();
        Map<String, Object> settings = new HashMap<>();
        settings.put("redis-instanceName", "redis");
        settings.put(RedisConfigurations.HOST.get(), "redis");
        managerFactory = configuration.get(Settings.of(settings));
    }

    @Produces
    @Database(DatabaseType.KEY_VALUE)
    public BucketManager getManager() {
        return managerFactory.getBucketManager(BUCKET);
    }

}
