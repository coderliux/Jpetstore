package com.thoughtworks.jpetstore.persistence;

import com.thoughtworks.jpetstore.domain.Account;
import com.thoughtworks.jpetstore.domain.Student;

public interface AccountMapper {

  Account getAccountByUsername(String username);

  Student getStudentKlass(int id);

  void updateAccount(Account account);

}
