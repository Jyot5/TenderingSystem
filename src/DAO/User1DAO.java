package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.User1VO;

public class User1DAO {

		public void insert(User1VO CatVO1){
			Session session = null;
			 

			  try{
			  // This step will read hibernate.cfg.xml 

			//and prepare hibernate for use
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			 session =sessionFactory.openSession();
			 Transaction tr=session.beginTransaction();
			  //Create new instance of Contact and set 

			//values in it by reading them from form object
			 System.out.println("Inserting Record");
			  session.save(CatVO1);
			  tr.commit();
			  System.out.println("Done");
			  }catch(Exception e){
				  e.printStackTrace();
			  
			  }finally{
			  // Actual contact insertion will happen at this step
			 //session.flush();
			 //session.close();

			  }
			  
			  }


	
	}
