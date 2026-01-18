package com.sb.springboot_rest.repo;

import com.sb.springboot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);



//    //method to save a jobpost object into arraylist
//    public void addJob(JobPost job) {
//       jobs.add(job);
//       System.out.println(jobs);
//    }
//
//    //method to return all JobPosts
//    public List<JobPost> getAllJobs(){
//        return jobs;
//    }
//
//    //method to return only 1 job
//    public JobPost getJob(int postId){
//        for(JobPost job : jobs){
//            if(job.getPostId() == postId){
//                return job;
//            }
//        }
//        return null;
//    }
//
//    //method to update jobPost
//    public void updateJob(JobPost jobPost){
//        for(JobPost job : jobs){
//            if(job.getPostId() == jobPost.getPostId()){
//                job.setPostDesc(jobPost.getPostDesc());
//                job.setPostProfile(jobPost.getPostProfile());
//                job.setReqExperience(jobPost.getReqExperience());
//                job.setPostTechStack(jobPost.getPostTechStack());
//            }
//        }
//    }
//
//    //method to delete jobPost
//    public void deleteJob(int postId){
//        for(JobPost job : jobs){
//            if(job.getPostId() == postId){
//                jobs.remove(job);
//            }
//        }
//    }
}