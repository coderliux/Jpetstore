package com.thoughtworks.jpetstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.jpetstore.domain.Account;
import com.thoughtworks.jpetstore.persistence.AccountMapper;

@Service
public class AccountService {

  @Autowired
  private AccountMapper accountMapper;

  public Account getAccount(String username) {
    return accountMapper.getAccountByUsername(username);
  }

}
