package com.mycompany.controller;

import com.mycompany.model.BranchLocation;
import com.mycompany.service.BranchLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/branch")
public class BranchLocationController {

    private final BranchLocationService branchLocationService;

    @Autowired
    public BranchLocationController(BranchLocationService branchLocationService) {
        this.branchLocationService = branchLocationService;
    }

    @RequestMapping(method= RequestMethod.POST)
    public BranchLocation createBranch(@RequestBody BranchLocation branchLocation)  {
        return branchLocationService.createBranch(branchLocation);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public BranchLocation getBranch(@PathVariable long id)  {
        return branchLocationService.getBranch(id);
    }


    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public BranchLocation updateBranch(@PathVariable long id, @RequestBody BranchLocation updatedBranchLocation) {
        return branchLocationService.updateBranch(id, updatedBranchLocation);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void deleteBranch(@PathVariable long id) {
        branchLocationService.deleteBranch(id);
    }
}
