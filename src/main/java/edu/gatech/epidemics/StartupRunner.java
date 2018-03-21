/**
 *
 */
package edu.gatech.epidemics;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.sql.DataSource;


/**
 * @author atalati
 */
public class StartupRunner implements CommandLineRunner {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private DataSource ds;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Datasource:" + ds.toString());
    }
}
