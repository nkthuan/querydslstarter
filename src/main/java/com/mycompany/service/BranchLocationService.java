package com.mycompany.service;

import com.mycompany.model.BranchLocation;

public interface BranchLocationService {

    BranchLocation createBranch(BranchLocation branchLocation);

    BranchLocation getBranch(long id);

    BranchLocation updateBranch(long id, BranchLocation updatedBranchLocation);

    void deleteBranch(long id);
}
