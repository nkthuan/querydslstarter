package com.mycompany.service;

import com.mycompany.exception.BranchNotFoundException;
import com.mycompany.exception.InvalidBranchException;
import com.mycompany.model.BranchLocation;
import com.mycompany.repository.BranchLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Throwable.class)
public class BranchLocationServiceImpl implements BranchLocationService {

    private final BranchLocationRepository repository;

    @Autowired
    public BranchLocationServiceImpl(BranchLocationRepository repository) {
        this.repository = repository;
    }


    @Override
    public BranchLocation createBranch(BranchLocation branchLocation)  {
        if (branchLocation.getId() > 0) {
            throw new InvalidBranchException("Please specify a new branch location");
        }
        return repository.save(branchLocation);
    }

    @Override
    public BranchLocation getBranch(long id)  {
        BranchLocation branchLocation = findOne(id);
        if (branchLocation == null) {
            throw new BranchNotFoundException("Invalid Branch Location Id");
        }
        return branchLocation;
    }

    @Override
    public BranchLocation updateBranch(long id, BranchLocation updatedBranchLocation) {
        BranchLocation toUpdate = findOne(id);

        if (toUpdate == null) {
            throw new BranchNotFoundException("Invalid Branch Location Id");
        }
        else if(updatedBranchLocation.getId() != id) {
            throw new InvalidBranchException("Branch Location Ids don't match");
        }

        toUpdate.copyFields(updatedBranchLocation);
        return repository.save(toUpdate);
    }

    @Override
    public void deleteBranch(long id) {
        if (findOne(id) == null) {
            throw new BranchNotFoundException("Invalid Branch Location Id");
        }

        repository.deleteById(id);
    }

    private BranchLocation findOne(long id) {
        return repository.findById(id).orElse(null);
    }
}
