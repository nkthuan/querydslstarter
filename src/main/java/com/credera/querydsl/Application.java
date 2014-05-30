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
        TransactionService transactionService = new TransactionService(context.getBean(TransactionRepository.class));
        
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
        
        //Simulate user authentication and save current user in thread local. 
        UserService.setCurrentUser("fwood");
        
        // fetch all transactions
        QTransaction tr = QTransaction.transaction;
        Iterable<Transaction> transactions = transactionService.findAll();
        System.out.println("Transactions found with findAll():");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();
        
        // fetch all transactions for Bank of Texas
        transactions = transactionService.findAll(tr.branchLocation.bankName.eq("Bank of Texas"));
        System.out.println("Transactions found for \"Bank of Texas\" locations:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();

        // fetch all transactions over $10,000
        transactions = transactionService.findAll(tr.transactionAmount.gt(10000));
        System.out.println("Transactions found with amount over $10,000:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();
        
        // fetch all Alice's transactions
        transactions = transactionService.findAll(tr.customer.username.eq("alain"));
        System.out.println("Transactions found for Alice:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();
        
        transactions = transactionService.findAll(tr.customer.account.custodialAccountHolder.firstName.eq("Alice"));
        System.out.println("Transactions found for Franks account number:");
        System.out.println("-------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println();
        
        context.close();
    }

}
