package edu.gatech.epidemics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author atalati
 */

@SpringBootApplication
public class EpidemicsApplication extends SpringBootServletInitializer implements CommandLineRunner {
    @Autowired
    AppConfigBean appConfigBean;

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EpidemicsApplication.class);
        app.run();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EpidemicsApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(appConfigBean.getDb_url());
    }
}
