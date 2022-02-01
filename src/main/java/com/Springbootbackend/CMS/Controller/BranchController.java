package com.Springbootbackend.CMS.Controller;



import com.Springbootbackend.CMS.Model.Branch;
import com.Springbootbackend.CMS.Services.BranchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {


    @Autowired
    BranchServices branchService;

    @PostMapping("branch/create")
    ResponseEntity<Branch> createBranch(@RequestBody Branch branch){
        branchService.createBranch(branch);
        return new ResponseEntity<Branch>(branch, HttpStatus.CREATED);
    }
    @PostMapping("branch/get")
    ResponseEntity<Branch> getBranch(@RequestBody String id){
        Branch branch = branchService.getBranch(Long.valueOf(id)).orElse(new Branch());
        if(branch.getId().toString().isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Branch>(branch, HttpStatus.CREATED);
    }
    @PostMapping("branch/update")
    ResponseEntity<Branch> updateBranch(@RequestBody Branch branch){
        Branch updatedBranch;
        if(branchService.updateBranch(branch).getId().toString().isEmpty())
            return new ResponseEntity<>(new Branch(), HttpStatus.NOT_FOUND);
        updatedBranch = branchService.updateBranch(branch);
        return new ResponseEntity<Branch>(updatedBranch, HttpStatus.OK);
    }
    @PostMapping("branch/delete")
    ResponseEntity<String> deleteBranch(@RequestBody String id){
        if(!branchService.getBranch(Long.valueOf(id)).isPresent()){
            return new ResponseEntity<>("Branch Not Found!",HttpStatus.NOT_FOUND);
        }
        branchService.deleteBranch(Long.valueOf(id));

        return new ResponseEntity<>("Branch with id " + id + " has been successfully deleted!", HttpStatus.OK);
    }
}
