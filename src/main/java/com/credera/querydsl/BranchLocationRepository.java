package com.credera.querydsl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BranchLocationRepository extends CrudRepository<BranchLocation, Long> {

	//find by single field
    List<BranchLocation> findByBankName(String bankName);
    List<BranchLocation> findByBranchName(String branchName);
    List<BranchLocation> findByAddress(String address);
    List<BranchLocation> findByCity(String city);
    List<BranchLocation> findByState(String state);
    List<BranchLocation> findByZip(String zip);
    List<BranchLocation> findByCountry(String country);
    List<BranchLocation> findByPhoneNumber(String phoneNumber);
    
    
    //find by two fields (bank name AND others)
    //Note: This is a lot of methods, and this is just those with Bank name. 
    //Imagine what happens as we included all the fields and every combination
    List<BranchLocation> findByBankNameAndBranchName(String bankName, String branchName);
    List<BranchLocation> findByBankNameAndAddress(String bankName, String address);
    List<BranchLocation> findByBankNameAndCity(String bankName, String city);
    List<BranchLocation> findByBankNameAndState(String bankName, String state);
    List<BranchLocation> findByBankNameAndZip(String bankName, String zip);
    List<BranchLocation> findByBankNameAndCountry(String bankName, String country);
    List<BranchLocation> findByBankNameAndPhoneNumber(String bankName, String phoneNumber);
    // ...
    
    //find by three fields 
    // This list of method combinations is even larger than the last
    List<BranchLocation> findByBankNameAndBranchNameAndState(String bankName, String state, String zip);
    // ...
    
    //find by two fields (bank name OR others)
    //Note: This is even more methods, and once again this is just those with Bank name. 
    //Imagine what happens again as we include all the fields and every combiniation
    List<BranchLocation> findByBankNameOrBranchName(String bankName, String branchName);
    List<BranchLocation> findByBankNameOrAddress(String bankName, String address);
    List<BranchLocation> findByBankNameOrCity(String bankName, String city);
    List<BranchLocation> findByBankNameOrState(String bankName, String state);
    List<BranchLocation> findByBankNameOrZip(String bankName, String zip);
    List<BranchLocation> findByBankNameOrCountry(String bankName, String country);
    List<BranchLocation> findByBankNameOrPhoneNumber(String bankName, String phoneNumber);
    // ...
    
    //find by three fields 
    // This list of method combinations is even larger than the last
    List<BranchLocation> findByBankNameOrBranchNameOrState(String bankName, String state, String zip);
}
