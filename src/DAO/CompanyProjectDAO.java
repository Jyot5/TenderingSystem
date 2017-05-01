package DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import VO.ApplyTenderVO;
import VO.CompanyProjectVO;

public class CompanyProjectDAO {

	public void insert(CompanyProjectVO cpVO){
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
		  session.save(cpVO);
		  tr.commit();
		  System.out.println("Done");
		  }catch(Exception e){
			  e.printStackTrace();
		  
		  }finally{
		  // Actual contact insertion will happen at this step
		 // session.flush();
		  //session.close();

		  }

	}  
	
	public List check(CompanyProjectVO cpVO){
		
		List ls = new ArrayList();
		Session session = null;

		try {
			System.out.println("inside check in cpdao");
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			Query q = session.createQuery("from CompanyProjectVO as t where t.tenderVO.tender_Id= '"+cpVO.getTenderVO().getTender_Id()+"'");
			ls = q.list();
			
			System.out.println("after list &&" + ls.size());
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
	
	
	public List search(CompanyProjectVO cpVO)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside search");
			Query q=session.createQuery("from CompanyProjectVO");
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
	
	public List search1(CompanyProjectVO cpVO)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside search");
			Query q=session.createQuery("from CompanyProjectVO as c where c.userVO.User_ID = '"+ cpVO.getUserVO().getUser_ID()+"'");
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
	

	
}
