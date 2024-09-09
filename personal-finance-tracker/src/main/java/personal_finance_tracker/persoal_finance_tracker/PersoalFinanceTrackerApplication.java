package personal_finance_tracker.persoal_finance_tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersoalFinanceTrackerApplication {

	private static final Logger logger = LoggerFactory.getLogger(PersoalFinanceTrackerApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Personal Finance Tracker Application...");
		SpringApplication.run(PersoalFinanceTrackerApplication.class, args);
		logger.info("Application Started Successfully");
	}

}
