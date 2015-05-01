package com.credera.querydsl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.credera.querydsl.BranchLocation;
import com.credera.querydsl.BranchLocationRepository;
import com.credera.querydsl.rest.exception.BranchNotFoundException;
import com.credera.querydsl.rest.exception.InvalidBranchException;


@RestController
@RequestMapping("/api/branch")
public class BranchLocationController {

    @Autowired
    private BranchLocationRepository repository;

    @RequestMapping(method=RequestMethod.POST)
    public BranchLocation createBranch(@RequestBody BranchLocation branchLocation)  {
        if(branchLocation.getId() > 0) {
            throw new InvalidBranchException("Please specify a new branch location");
        }
        return repository.save(branchLocation);
    }

    @RequestMapping(method=RequestMethod.GET, value="{id}")
    public BranchLocation getBranch(@PathVariable long id)  {
        BranchLocation branchLocation =  repository.findOne(id);
        if(branchLocation == null) {
            throw new BranchNotFoundException("Invalid Branch Location Id");
        }
        return branchLocation;
    }


    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public BranchLocation updateBranch(@PathVariable long id, @RequestBody BranchLocation updatedBranchLocation) throws Exception {
        BranchLocation toUpdate = repository.findOne(id);

        if(toUpdate == null) {
            throw new BranchNotFoundException("Invalid Branch Location Id");
        }
        else if(updatedBranchLocation.getId() != id) {
            throw new InvalidBranchException("Branch Location Ids don't match");
        }

        toUpdate.copyFields(updatedBranchLocation);
        return repository.save(toUpdate);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void deleteBranch(@PathVariable long id) throws Exception {
        if(repository.findOne(id) == null) {
            throw new BranchNotFoundException("Invalid Branch Location Id");
        }

        repository.delete(id);
    }

}
