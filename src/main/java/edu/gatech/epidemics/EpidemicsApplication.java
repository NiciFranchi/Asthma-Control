package edu.gatech.epidemics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author atalati
 */
@SpringBootApplication
public class EpidemicsApplication implements CommandLineRunner
{
	@Autowired
	AppConfigBean appConfigBean;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SpringApplication app = new SpringApplication(EpidemicsApplication.class);
		app.run();
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println(appConfigBean.getDb_url());
	}
}
