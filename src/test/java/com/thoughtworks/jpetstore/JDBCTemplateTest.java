package com.thoughtworks.jpetstore;

import com.thoughtworks.jpetstore.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by coderliu on 3/4/16.
 */
public class JDBCTemplateTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        Account account = accountService.queryAccount("google");
        System.out.println("account email= [" + account.getEmail() + "]");
    }


}
