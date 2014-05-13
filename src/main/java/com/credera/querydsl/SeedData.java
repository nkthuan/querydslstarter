package com.credera.querydsl;

import org.springframework.context.ConfigurableApplicationContext;

public class SeedData {
    
    private BranchLocationRepository branchRepository;
    private CustomerRepository customerRepository;
    private TransactionRepository transactionRepository;
    
    public SeedData(ConfigurableApplicationContext context ) {
        branchRepository = context.getBean(BranchLocationRepository.class);
        customerRepository = context.getBean(CustomerRepository.class);
        transactionRepository = context.getBean(TransactionRepository.class);
    }
    
    public void seedData() {
        // save a couple of branches
        BranchLocation bl1 = branchRepository.save(new BranchLocation("Bank of Texas", "Downtown Penn", "600 Penn Street", "Fort Worth", "TX", "76102", "USA", "817-255-2108"));
        branchRepository.save(new BranchLocation("Bank of Texas", "Royal Lane", "2650 Royal Lane", "Dallas", "TX", "75229", "USA", "214-574-1277"));
        branchRepository.save(new BranchLocation("Bank of Texas", "West University", "5500 Kirby", "Houston", "TX", "77005", "USA", "713-218-2259"));
        BranchLocation bl2 = branchRepository.save(new BranchLocation("Wells Fargo", "Church & Elm", "205 Church Street", "New Haven", "CT", "06510", "USA", "203-773-9037"));
        branchRepository.save(new BranchLocation("Wells Fargo", "Whalley Norton", "388 Whalley Avenue", "New Haven", "CT", "06511", "USA", "203-777-7113"));
        branchRepository.save(new BranchLocation("Wells Fargo", "University of New Haven", "300 Boston Post Road", "New Haven", "CT", "06516", "USA", "800-869-3557"));
        BranchLocation bl3 = branchRepository.save(new BranchLocation("Citibank", "Government Center", "100 Cambridge Street", "Boston", "MA", "02114", "USA", "617-849-7544"));
        
        //save some users
        Customer frank = customerRepository.save(new Customer("Frank", "Wood","583942302"));
        Customer alice = customerRepository.save(new Customer("Alice", "Lain","294032410"));
        Customer matt = customerRepository.save(new Customer("Matt", "Lean","034502102"));
        
        //save some transactions
        transactionRepository.save(new Transaction(frank, bl1 , 10457.83));
        transactionRepository.save(new Transaction(frank, bl1 , 582.43));
        transactionRepository.save(new Transaction(frank, bl2 , 926.01));
        
        transactionRepository.save(new Transaction(alice, bl1 , 70583.92));
        transactionRepository.save(new Transaction(alice, bl2 , 209.31));
        transactionRepository.save(new Transaction(alice, bl2 , 48.21));
        transactionRepository.save(new Transaction(alice, bl3 , 493.21));
        
        transactionRepository.save(new Transaction(matt, bl2 , 111021.53));
        transactionRepository.save(new Transaction(matt, bl3 , 72983.51));
        transactionRepository.save(new Transaction(matt, bl3 , 5924.21));
    }
}
