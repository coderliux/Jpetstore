package com.thoughtworks.jpetstore.persistence;

import com.thoughtworks.jpetstore.domain.Account;

public interface AccountMapper {

  Account getAccountByUsername(String username);

  void insertAccount(Account account);

  void updateAccount(Account account);

}
