package com.credera.querydsl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String accountNumber;
    
    private String accountType;
    
    protected Account() {
        
    }

    public Account(String accountNumber, String accountType) {
        super();
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Account[id=%d, accountNumber='%s', accountType='%s']",
            id, accountNumber, accountType);
    }
}
