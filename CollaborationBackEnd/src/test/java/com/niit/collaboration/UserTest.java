/*package com.niit.collaboration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.model.User;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User userdetails = (User) context.getBean("user");
		
		userdetails.setId("3");
		userdetails.setName("Mughada Karodkar");
		userdetails.setAddress("Pune");
		userdetails.setPassword("1234");
		userdetails.setMobile("7896541235");
		userdetails.setEmail("AdiBavali@gmail.com");
		userdetails.setOnLine(true);
		userdetails.setRole("User_Student");
		//Save user Deatails
		if(userDAO.save(userdetails)==true)
		{
			System.out.println("UserDtails Added sucessfuly");
		}
		else
		{
			System.out.println("Not able to add userdetails");
		}
		//UserDetails delete operation
				userdetails.setId("2");
				if(userDAO.delete(userdetails)==true)
				{
					System.out.println("UserDtails deleted sucessfuly");
				}
				else
				{
					System.out.println("Not able to delete userdetails");
				}
				//User Details update
				userdetails.setId("1");
				userdetails.setName("Ravindra Dadahari Gaikwad");
				userdetails.setAddress("Vaijapur");
				userdetails.setPassword("1234");
				userdetails.setMobile("7896541235");
				userdetails.setEmail("gaikwadrd26@gmail.com");
				userdetails.setOnLine(true);
				userdetails.setRole("User_Alumini");
				if(userDAO.update(userdetails)==true)
				{
					System.out.println("UserDtails updated sucessfuly");
				}
				else
				{
					System.out.println("Not able to updated userdetails");
				}
	}

	

}

*/