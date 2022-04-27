package de.gedoplan.showcase.jnosql.service;

import de.gedoplan.showcase.jnosql.model.Part;
import jakarta.nosql.mapping.Database;
import jakarta.nosql.mapping.DatabaseType;
import jakarta.nosql.mapping.keyvalue.KeyValueTemplate;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@JBossLog
@ApplicationScoped
public class PartService implements Serializable {

    private static final Part[] parts = {
        new Part("part1", 20.0),
        new Part("part2", 18.9)
    };

    @Inject
    @Database(DatabaseType.KEY_VALUE)
    private KeyValueTemplate template;

    public Optional<Part> getPartByKey(String key) {
        return template.get(key, Part.class);
    }
    
    public boolean isInitialized() {
        if (getPartByKey(parts[0].getName()).isPresent()) {
            return true;
        }
        return false;
    }
    
    public void initDB() {
        log.info("Init DB");
        Arrays.asList(parts).forEach(template::put);
    }

}
