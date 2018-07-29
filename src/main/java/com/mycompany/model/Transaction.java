package com.mycompany.model;

import com.querydsl.core.annotations.QueryInit;

import javax.persistence.*;

@Entity(name = "transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @QueryInit("account.custodialAccountHolder")
    private Customer customer;
    
    @ManyToOne
    private BranchLocation branchLocation;
    
    private double transactionAmount;

    protected Transaction() {
        
    }

    public Transaction(Customer customer, BranchLocation branchLocation, double transactionAmount) {
        super();
        this.customer = customer;
        this.branchLocation = branchLocation;
        this.transactionAmount = transactionAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BranchLocation getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(BranchLocation branchLocation) {
        this.branchLocation = branchLocation;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return String.format(
                "Transaction[id=%d, customer='%s', account='%s', branchLocation='%s', transactionAccount='$%.2f']",
                id, 
                customer.getFirstName() + " " + customer.getLastName(),
                customer.getAccount(),
                branchLocation.getBankName() + " - " + branchLocation.getBranchName(),
                transactionAmount);
    }
}
