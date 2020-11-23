package com.cg.tradingservice;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/** SpringBootApplication for TradingServiceApplication
 * 
 * @author Bhavani's, Akhil's, Kavya's
 *
 */
@SpringBootApplication
public class TradingServiceApplication implements ApplicationRunner{
	  private static final Logger logger = LogManager.getLogger(TradingServiceApplication.class);

	public static void main(String[] args) {
	
		SpringApplication.run(TradingServiceApplication.class, args);
	}
	
	 @Override
	    public void run(ApplicationArguments applicationArguments) throws Exception {
	       logger.info("Application Started");
	    }

}


