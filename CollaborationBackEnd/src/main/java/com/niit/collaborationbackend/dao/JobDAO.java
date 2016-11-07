package com.niit.collaborationbackend.dao;

import java.util.List;


import com.niit.collaborationbackend.model.Job;
import com.niit.collaborationbackend.model.JobApplication;

public interface JobDAO {
	public boolean postJob(Job job);
	
	public boolean updateJob(Job job);
	
	public List<Job> getAllVacantJobs();
	
	public List<Job> getAllJobs();
	
	public boolean applyForJob(JobApplication jobApplication);
	
	public boolean updateJobApplication(JobApplication jobApplication);
	
	public JobApplication get(String userID, String jobID);
	
	public JobApplication getMyAppliedJobs(String userID);
	

}
