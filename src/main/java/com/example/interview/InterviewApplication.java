package com.example.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class InterviewApplication implements CommandLineRunner {

	@Autowired
	CSVService csvService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(InterviewApplication.class, args);
		System.out.println(KataApp.add("1004,2"));
	}

	@Override
	public void run(String... args) throws Exception {
		//String filePathh = "src/main/resources/static/customers.csv";
		//csvService.postCustomers(filePathh);
		if (args.length > 0) {
			String filePath = args[0];
		//	String filePathh = "src/main/resources/static/customers.csv";
			csvService.postCustomers(filePath);
		} else {
			System.out.println("No file path provided.");
		}
	}
}
