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

        BranchLocationRepository repository = context.getBean(BranchLocationRepository.class);

        // save a couple of branches
        repository.save(new BranchLocation("Bank of Texas", "Downtown Penn", "600 Penn Street", "Fort Worth", "TX", "76102", "USA", "817-255-2108"));
        repository.save(new BranchLocation("Bank of Texas", "Royal Lane", "2650 Royal Lane", "Dallas", "TX", "75229", "USA", "214-574-1277"));
        repository.save(new BranchLocation("Bank of Texas", "West University", "5500 Kirby", "Houston", "TX", "77005", "USA", "713-218-2259"));
        repository.save(new BranchLocation("Wells Fargo", "Church & Elm", "205 Church Street", "New Haven", "CT", "06510", "USA", "203-773-9037"));
        repository.save(new BranchLocation("Wells Fargo", "Whalley Norton", "388 Whalley Avenue", "New Haven", "CT", "06511", "USA", "203-777-7113"));
        repository.save(new BranchLocation("Wells Fargo", "University of New Haven", "300 Boston Post Road", "New Haven", "CT", "06516", "USA", "800-869-3557"));
        repository.save(new BranchLocation("Citibank", "Government Center", "100 Cambridge Street", "Boston", "MA", "02114", "USA", "617-849-7544"));

        // fetch all branch locations
        Iterable<BranchLocation> locations = repository.findAll();
        System.out.println("Branch locations found with findAll():");
        System.out.println("-------------------------------");
        for (BranchLocation location : locations) {
            System.out.println(location);
        }
        System.out.println();

        QBranchLocation bl = QBranchLocation.branchLocation;
        locations = repository.findAll(bl.bankName.eq("Bank of Texas"));
        System.out.println("Branch locations found with findByBankName(\"Bank of Texas\"):");
        System.out.println("-------------------------------");
        for (BranchLocation location : locations) {
            System.out.println(location);
        }
        System.out.println();

        locations = repository.findAll(bl.state.eq("CT"));
        System.out.println("Branch locations found with findByState(\"CT\"):");
        System.out.println("-------------------------------");
        for (BranchLocation location : locations) {
            System.out.println(location);
        }
        System.out.println();


        locations = repository.findAll(bl.bankName.eq("Citibank").and(bl.city.eq("Boston")));
        System.out.println("Branch locations found with findByBankNameAndCity(\"Citibank\", \"Boston\"):");
        System.out.println("-------------------------------");
        for (BranchLocation location : locations) {
            System.out.println(location);
        }
        System.out.println();

        locations = repository.findAll(bl.bankName.eq("Bank of Texas").and(bl.branchName.eq("Downtown Penn").and(bl.state.eq("TX"))));
        System.out.println("Branch locations found with findByBankNameAndBranchNameAndState(\"Bank of Texas\", \"Downtown Penn\", \"TX\")");
        System.out.println("-------------------------------");
        for (BranchLocation location : locations) {
            System.out.println(location);
        }
        System.out.println();

        locations = repository.findAll(bl.bankName.eq("Bank of Texas").or(bl.city.eq("New Haven")));
        System.out.println("Branch locations found with findByBankNameOrCity(\"Bank of Texas\", \"New Haven\"):");
        System.out.println("-------------------------------");
        for (BranchLocation location : locations) {
            System.out.println(location);
        }
        System.out.println();

        locations = repository.findAll(bl.bankName.eq("Wells Fargo").or(bl.branchName.eq("Royal Lane").or(bl.state.eq("MA"))));
        System.out.println("Branch locations found with findByBankNameOrBranchNameOrState(\"Wells Fargo\", \"Royal Lane\", \"MA\")");
        System.out.println("-------------------------------");
        for (BranchLocation location : locations) {
            System.out.println(location);
        }
        System.out.println();

        context.close();
    }

}
