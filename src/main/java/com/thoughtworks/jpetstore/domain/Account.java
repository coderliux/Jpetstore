package com.thoughtworks.jpetstore.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {

  private static final long serialVersionUID = 8751282105532159742L;

  private String userName;
  private String password;
  private String email;
  private String firstName;
  private String lastName;
  private String status;
  private String address1;
  private String address2;
  private String city;
  private String state;
  private String zip;
  private String country;
  private String phone;
  private String favouriteCategoryId;
  private String languagePreference;
  private boolean listOption;
  private boolean bannerOption;
  private String bannerName;

}
