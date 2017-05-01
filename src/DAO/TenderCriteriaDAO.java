package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.TenderCriteriaVO;
import VO.TenderDescVO;

public class TenderCriteriaDAO {
	public void insert(TenderCriteriaVO tcVO){
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
		  session.save(tcVO);
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

	public List search(TenderCriteriaVO tenderdescvo)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside search");
			Query q=session.createQuery("from TenderCriteriaVO");
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
	
	public Boolean check(TenderCriteriaVO tcVO)
	{
		
		Session session=null;
		List oo=new ArrayList();
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside daocheck");
		
			//String qu =";
			Long i = tcVO.getTenderVO().getTender_Id();
			System.out.println(tcVO.getTenderVO().getTender_Id() + "kkkkkk");
			Query q=session.createQuery("from TenderCriteriaVO as t where t.tenderVO.tender_Id = "+i);
			oo=q.list();
			System.out.println("done bbbbbbbbbbbbbbbbbbbbb" + oo.size());
		}
		catch (Exception e) {
			// TODO: handle exception
			/*System.out.println();
			String []s =e.getCause()!=null?e.getCause().toString().split(":"):null;
			
			if(s!=null && s[0].equals("java.lang.NullPointerException"))
			{
				return false;
			}*/
		//	e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
		if(oo.size()>0){
			return false;
		}
		else{
			return true;
		}
	}

	public List edit(TenderCriteriaVO tvo) {

		List ls = new ArrayList();
		Session session = null;

		try {
			System.out.println("inside edit");
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			Query q = session.createQuery("from TenderCriteriaVO as t where t.tenderVO.tender_Id= '"+tvo.getTenderVO().getTender_Id()+"'");
			ls = q.list();
			
			System.out.println("done jjjjjjjjjj" + ls.size());
			
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
	
	
	
	public void update(TenderCriteriaVO r){
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
		  session.update(r);
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
