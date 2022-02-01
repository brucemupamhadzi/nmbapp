package com.Springbootbackend.CMS.Services;

import org.springframework.stereotype.Service;
import com.Springbootbackend.CMS.Model.Branch;

import java.util.Optional;


@Service
public interface BranchServices {
    void createBranch(Branch branch);

    Optional<Branch> getBranch(Long id);

    Branch updateBranch(Branch branch);

    void deleteBranch(Long id);


}
