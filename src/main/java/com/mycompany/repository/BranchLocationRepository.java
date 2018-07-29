package com.mycompany.repository;

import com.mycompany.model.BranchLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BranchLocationRepository extends JpaRepository<BranchLocation, Long>, QuerydslPredicateExecutor<BranchLocation> {
}
