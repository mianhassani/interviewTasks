package com.example.interview;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = Controller.class)
public class ControllerTests {

  @MockBean
  CustomerService customerService;

  @MockBean
  CSVService csvService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  Customer mockCustomer1 = new Customer(1234L, "TestUser1", "AddressLine1", "AddressLine2",
      "Some Town", "Some County", "England", "AB1 2CD");
  Customer mockCustomer2 = new Customer(5678L, "TestUser2", "AddressLine1", "AddressLine2",
      "Some Town", "Some County", "England", "EF1 2GH");

  @BeforeEach
  void initial_setup() {
    Mockito.when(customerService.getCustomers()).thenReturn(List.of(mockCustomer1, mockCustomer2));
  }

  @Test
  public void should_return_customers_as_expected() throws Exception {
    String url = "http://localhost:8080/customers";
    String resultString = mockMvc.perform(MockMvcRequestBuilders.get(url))
        .andReturn().getResponse().getContentAsString();
    List<Customer> customerList = objectMapper.readValue(resultString,
        new TypeReference<List<Customer>>() {
        });
    assertThat(customerList.get(0).getCustomerName()).isEqualTo("TestUser1");
    assertThat(customerList.get(1).getCustomerName()).isEqualTo("TestUser2");
  }

  @Test
  public void should_add_customers() throws Exception {
    String url = "http://localhost:8080/customers/addCustomers";
    String customerJson = objectMapper.writeValueAsString(mockCustomer1);
    mockMvc.perform(MockMvcRequestBuilders.post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(customerJson))
        .andExpect(status().isOk());
    verify(customerService, times(1)).addCustomer(argThat(customer-> customer.getCustomerName().equals(mockCustomer1.getCustomerName())));
  }
}
