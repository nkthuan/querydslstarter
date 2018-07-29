package com.mycompany.controller;

import com.mycompany.exception.BranchNotFoundException;
import com.mycompany.exception.InvalidBranchException;
import com.mycompany.model.BranchLocation;
import com.mycompany.repository.BranchLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/branch")
public class BranchLocationController {

    @Autowired
    private BranchLocationRepository repository;

    @RequestMapping(method= RequestMethod.POST)
    public BranchLocation createBranch(@RequestBody BranchLocation branchLocation)  {
        if(branchLocation.getId() > 0) {
            throw new InvalidBranchException("Please specify a new branch location");
        }
        return repository.save(branchLocation);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public BranchLocation getBranch(@PathVariable long id)  {
        BranchLocation branchLocation =  repository.findById(id).orElse(null);
        if(branchLocation == null) {
            throw new BranchNotFoundException("Invalid Branch Location Id");
        }
        return branchLocation;
    }


    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public BranchLocation updateBranch(@PathVariable long id, @RequestBody BranchLocation updatedBranchLocation) throws Exception {
        BranchLocation toUpdate = repository.findById(id).orElse(null);

        if(toUpdate == null) {
            throw new BranchNotFoundException("Invalid Branch Location Id");
        }
        else if(updatedBranchLocation.getId() != id) {
            throw new InvalidBranchException("Branch Location Ids don't match");
        }

        toUpdate.copyFields(updatedBranchLocation);
        return repository.save(toUpdate);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void deleteBranch(@PathVariable long id) throws Exception {
        if(repository.findById(id).orElse(null) == null) {
            throw new BranchNotFoundException("Invalid Branch Location Id");
        }

        repository.deleteById(id);
    }

}
