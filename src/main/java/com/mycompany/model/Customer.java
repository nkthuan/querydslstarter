package com.mycompany.model;

import javax.persistence.*;

@Entity(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    
    private String username;
    private String firstName;
    private String lastName;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
 
    protected Customer() {
        
    }
    
    public Customer(String username, String firstName, String lastName, Account account) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', account='%s']",
                id, firstName, lastName, account);
    }
}
