package de.gedoplan.showcase.jnosql.service;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

/**
 *
 * @author Markus Pauer <markus.pauer@gedoplan.de>
 */
@JBossLog
@ApplicationScoped
public class InitService implements Serializable {

    @Inject
    PartService partService;

    void init(@Observes @Initialized(ApplicationScoped.class) Object obj) {
        log.info("Checking parts database ...");
        if (!partService.isInitialized()) {
            partService.initDB();
        }
    }

}
