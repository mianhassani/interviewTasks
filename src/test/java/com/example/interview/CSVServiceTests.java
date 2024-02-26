package com.example.interview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;

@SpringBootTest
public class CSVServiceTests {

  @Autowired
  CSVService csvService;

  @MockBean
  RestTemplate restTemplate;

  @Test
  public void make_a_post_request_with_correct_customer() {
    String filePath = "src/test/resources/static/testCustomers.csv";
    String uri = "http://localhost:8080/customers/addCustomers";
    csvService.postCustomers(filePath);
    verify(restTemplate, times(1)).postForEntity(
        eq(uri),
        argThat((Customer argument) -> argument.getCustomerName().equals("Test User")),
        eq(Customer.class));
  }
}
