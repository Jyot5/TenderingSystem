package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import VO.AreaVO;
import VO.CategoryVO;
import VO.StreetVO;

public class StreetDAO {
	public void insert(StreetVO StreetVO)
	{
		Session session = null;

		  try
		  {
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  session =sessionFactory.openSession();
			  Transaction tr=session.beginTransaction();
			  
		  	  System.out.println("Inserting Record");
		  
		  
		  	  session.save(StreetVO);
		  	  tr.commit();
		  	  System.out.println("Done");
		  }	
		  catch(Exception e)
		  {
		  	e.printStackTrace();
		  }
		  finally
		  {
		  session.flush();
		  session.close();
		  }
	}

public List load(StreetVO svo)
{
	
	List ls=new ArrayList();
	
	Session session=null;
	
	try
	{
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		System.out.println("inside load");
		Query q=session.createQuery("from StreetVO");
		ls=q.list();
		System.out.println("done" + ls.size());
	}
	catch (Exception e) {
		// TODO: handle exception
		
		e.printStackTrace();
	}
	finally
	{
		//session.flush();
		//session.close();
	}
	return ls;
}
public List search(StreetVO svo)
{
	
	List ls=new ArrayList();
	
	Session session=null;
	
	try
	{
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		System.out.println("inside search");
		Query q=session.createQuery("from StreetVO");
		ls=q.list();
		System.out.println("done" + ls.size());
	}
	catch (Exception e) {
		// TODO: handle exception
		
		e.printStackTrace();
	}
	finally
	{
		//session.flush();
		//session.close();
	}
	return ls;
}


public List edit(StreetVO svo) {

	List ls = new ArrayList();
	Session session = null;

	try {
		System.out.println("inside edit");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from StreetVO where street_ID = '"+svo.getStreet_ID()+"'");
		ls = q.list();
		
		tr.commit();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
              System.out.println("not done");
		
	} finally {
		session.flush();
		session.close();
	}
	return ls;
}


public void update(StreetVO svo){
	Session session = null;
	 

	  try{
	  // This step will read hibernate.cfg.xml 

	//and prepare hibernate for use
	  SessionFactory sessionFactory = new 

	Configuration().configure().buildSessionFactory();
	 session =sessionFactory.openSession();
	 Transaction tr=session.beginTransaction();
	  //Create new instance of Contact and set 

	//values in it by reading them from form object
	 System.out.println("updating Record");
	  session.saveOrUpdate(svo);
	 tr.commit();
	  System.out.println("Done");
	  }catch(Exception e){
		  e.printStackTrace();
	  
	  }finally{
	  // Actual contact insertion will happen at this step
	  session.flush();
	  session.close();
	  }
	  }

	  
		  
	  
	  public Boolean delete(StreetVO svo){
			Session session = null;
			 

			  try{
			  // This step will read hibernate.cfg.xml 

			//and prepare hibernate for use
			  SessionFactory sessionFactory = new 

			Configuration().configure().buildSessionFactory();
			 session =sessionFactory.openSession();
			 Transaction te=session.beginTransaction();
			 System.out.println("selecting query");
			 
			 StreetVO cvo=(StreetVO)session.get(StreetVO.class, svo.getStreet_ID());
			 session.delete(cvo);
			 
			 te.commit();
			//values in it by reading them from form object
			 
			  
			  
			  
			  }catch(Exception e){
				  

					String []s =e.getCause()!=null?e.getCause().toString().split(":"):null;
					
					if(s!=null && s[0].equals("java.sql.BatchUpdateException"))
					{
						return false;
						//System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhh");
					}
				 
			  
			  }finally{
			  // Actual contact insertion will happen at this step
			  //session.flush();
			  session.close();

			  }
			  return true;
	}


}



