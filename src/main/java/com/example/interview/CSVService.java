package com.example.interview;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CSVService {

  private final RestTemplate restTemplate;
  private final String POST_ENDPOINT = "http://localhost:8080/customers/addCustomers";

  @Autowired
  public CSVService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public void postCustomers(String filePath){
    //String filePath = "src/main/resources/static/customers.csv";
    try (CSVReader csvReader = new CSVReader(new FileReader(filePath));) {
      String[] values = null;
      while ((values = csvReader.readNext()) != null) {
        Customer customer =   new Customer(Long.parseLong(values[0]),values[1],values[2],values[3],values[4],values[5],values[6],values[7]);
        restTemplate.postForEntity(POST_ENDPOINT,customer, Customer.class);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
