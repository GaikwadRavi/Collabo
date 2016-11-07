package com.niit.collaborationbackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Job;
import com.niit.collaborationbackend.model.JobApplication;

@Repository("JobDAO")
public class JobDAOImpl implements JobDAO {
	private SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean postJob(Job job) {
		
		try {
			sessionFactory.getCurrentSession().save(job);
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public boolean updateJobApplication(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().update(jobApplication);
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public JobApplication get(String userID, String jobID) {
		String hql = "from JobApplication where userId = '"+ userID+"' and jobID = '"+ jobID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication) query.list();
		
	}
	@Transactional
	public JobApplication getMyAppliedJobs(String userID) {
		String hql = "from job where id in (select job_id from JobApplication where userID = '"+ userID+"')";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication) query.list();
	}
	@Transactional
	public List<Job> getAllVacantJobs() {
		String hql = "from job where status = 'V' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
	@Transactional
	public boolean applyForJob(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().save(jobApplication);
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public List<Job> getAllJobs() {
		String hql = "from job";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
		

}
