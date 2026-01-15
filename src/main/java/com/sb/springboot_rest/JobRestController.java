package com.sb.springboot_rest;

import com.sb.springboot_rest.model.JobPost;
import com.sb.springboot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(path="jobPosts", produces = {"application/json"})
    public List<JobPost> viewAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{Id}")
    public JobPost viewJob(@PathVariable("Id") int postId){
        return service.getJob(postId);
    }

    @PostMapping(path="jobPost", consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public void updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable("id") int postId){
        service.deleteJob(postId);
        return "deleted";
    }

}
