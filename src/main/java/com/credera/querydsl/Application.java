package com.credera.querydsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class Application {
    
    public static void main(String[] args) {
    	
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        
        //setup repositories
        BranchLocationRepository branchRepository = context.getBean(BranchLocationRepository.class);
        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
        TransactionRepository transactionRepository = context.getBean(TransactionRepository.class);
        
        //seed some data
        new SeedData(context).seedData();
        
        // fetch all branch locations
        Iterable<BranchLocation> locations = branchRepository.findAll();
        System.out.println("Branch locations found with findAll():");
        System.out.println("-------------------------------");
        for (BranchLocation location : locations) {
            System.out.println(location);
        }
        System.out.println();

        // fetch all customers
        Iterable<Customer> customers = customerRepository.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println();
        
        // fetch all transactions
        Iterable<Transaction> transactions = transactionRepository.findAll();
        System.out.println("Transactions found with findAll():");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();
        
        // fetch all transctions for Bank of Texas
        QTransaction tr = QTransaction.transaction;
        transactions = transactionRepository.findAll(tr.branchLocation.bankName.eq("Bank of Texas"));
        System.out.println("Transactions found for \"Bank of Texas\" locations:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();
        
        
        // fetch all transctions over $10,000
        transactions = transactionRepository.findAll(tr.transactionAmount.gt(10000));
        System.out.println("Transactions found with amount over $10,000:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();
        
        // fetch all Alice's transactions
        transactions = transactionRepository.findAll(tr.customer.firstName.eq("Alice"));
        System.out.println("Transactions found for Alice:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();
        
        context.close();
    }

}
