package com.niit.collaborationbackend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.JobDAO;
import com.niit.collaborationbackend.model.BaseDomain;
import com.niit.collaborationbackend.model.Job;
import com.niit.collaborationbackend.model.JobApplication;

@RestController
public class JobController {
	@Autowired
	Job job;
	
	@Autowired
	BaseDomain baseDomain;
	
	@Autowired
	JobApplication jobApplication;
	
	@Autowired
	JobDAO jobDAO;
	
	@RequestMapping(value = "/getAllJobs")
	public ResponseEntity< List<Job>> getAllJobs()
	{
		List<Job> allJobs = jobDAO.getAllJobs();
		
		if(allJobs==null)
		{
			Job job = new Job();
			job.setErrorCode("404");
			job.setErrorMessage("No Jobs Available");
			allJobs.add(job);
		}
		return new ResponseEntity<List<Job>>(allJobs, HttpStatus.OK);
		
	}
	/*@RequestMapping(value = "/getAllJobs/", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllOpendJobs() {
		List<Job> jobs = jobDAO.getAllVacantJobs();
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
		
	}*/
	
	/*@RequestMapping(value = "/getMyAppliedJobs", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getMyAppliedJobs(HttpSession httpSession) {
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		
		List<Job> jobs = jobDAO.getMyAppliedJobs(loggedInUserID);
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}*/
	@RequestMapping(value = "/postAJob/", method = RequestMethod.POST)
	public ResponseEntity<BaseDomain> postAJob(@RequestBody Job job)
	{
		
		job.setStatus('V');
		if(jobDAO.postJob(job)==true)
		{
			baseDomain.setErrorCode("200");
			baseDomain.setErrorMessage("Successfuly posted the job");
		}
		else
		{
			baseDomain.setErrorCode("400");
			baseDomain.setErrorMessage("Not able posted the job");
		}
		return new ResponseEntity<BaseDomain>(baseDomain,HttpStatus.OK);
	}

}
