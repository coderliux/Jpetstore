package com.thoughtworks.jpetstore;

import com.thoughtworks.jpetstore.domain.Account;
import com.thoughtworks.jpetstore.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by coderliu on 3/4/16.
 */
@Component
public class AccountService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account queryAccount(String userName) {
        String sql = "SELECT\n" +
                "          ACCOUNT.USERID USERNAME,\n" +
                "          ACCOUNT.EMAIL,\n" +
                "          ACCOUNT.FIRSTNAME,\n" +
                "          ACCOUNT.LASTNAME,\n" +
                "          ACCOUNT.STATUS,\n" +
                "          ACCOUNT.ADDR1 AS address1,\n" +
                "          ACCOUNT.ADDR2 AS address2,\n" +
                "          ACCOUNT.CITY,\n" +
                "          ACCOUNT.STATE,\n" +
                "          ACCOUNT.ZIP,\n" +
                "          ACCOUNT.COUNTRY,\n" +
                "          ACCOUNT.PHONE\n" +
                "    FROM ACCOUNT\n" +
                "    WHERE ACCOUNT.USERID = '" + userName + "'";
        Account account = this.jdbcTemplate.queryForObject(sql, new AccountMapper());
        return account;
    }

    static final class AccountMapper implements RowMapper<Account> {
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setUserName(rs.getString("USERNAME"));
            account.setEmail(rs.getString("EMAIL"));
            return account;
        }
    }

}
