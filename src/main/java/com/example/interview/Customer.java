package com.example.interview;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

  @Id
  private Long customerRef;
  private String customerName;
  private String addressLineOne;
  private String addressLineTwo;
  private String town;
  private String county;
  private String country;
  private String postCode;

  public Customer() {
  }

  public Customer(Long customerRef, String customerName, String addressLineOne,
      String addressLineTwo, String town, String county, String country, String postCode) {
    this.customerRef = customerRef;
    this.customerName = customerName;
    this.addressLineOne = addressLineOne;
    this.addressLineTwo = addressLineTwo;
    this.town = town;
    this.county = county;
    this.country = country;
    this.postCode = postCode;
  }

  public Long getCustomerRef() {
    return customerRef;
  }

  public void setCustomerRef(Long customerRef) {
    this.customerRef = customerRef;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getAddressLineOne() {
    return addressLineOne;
  }

  public void setAddressLineOne(String addressLineOne) {
    this.addressLineOne = addressLineOne;
  }

  public String getAddressLineTwo() {
    return addressLineTwo;
  }

  public void setAddressLineTwo(String addressLineTwo) {
    this.addressLineTwo = addressLineTwo;
  }

  public String getTown() {
    return town;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "customerRef='" + customerRef + '\'' +
        ", customerName='" + customerName + '\'' +
        ", addressLineOne='" + addressLineOne + '\'' +
        ", addressLineTwo='" + addressLineTwo + '\'' +
        ", town='" + town + '\'' +
        ", county='" + county + '\'' +
        ", country='" + country + '\'' +
        ", postCode='" + postCode + '\'' +
        '}';
  }
}
