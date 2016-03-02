package com.thoughtworks.jpetstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworks.jpetstore.domain.Account;
import com.thoughtworks.jpetstore.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/account/{userName}", method = RequestMethod.GET)
	public @ResponseBody Account query(@PathVariable String userName) {
		return accountService.getAccount(userName);
	}
}
