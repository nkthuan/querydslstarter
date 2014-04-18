package com.credera.querydsl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BranchLocationRepository extends CrudRepository<BranchLocation, Long> {

    List<BranchLocation> findByBankName(String bankName);
    List<BranchLocation> findByBranchName(String branchName);
    List<BranchLocation> findByAddress(String address);
    List<BranchLocation> findByCity(String city);
    List<BranchLocation> findByState(String state);
    List<BranchLocation> findByZip(String zip);
    List<BranchLocation> findByCountry(String country);
    List<BranchLocation> findByPhoneNumber(String phoneNumber);
}
