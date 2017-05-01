package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ApplyTenderVO;
import VO.AreaVO;
import VO.SubCategoryVO;
import VO.TenderDescVO;

public class TenderDescDAO {
	public void insert(TenderDescVO tdVO){
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
		  session.save(tdVO);
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
	public List search(TenderDescVO tenderdescvo)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside search");
			Query q=session.createQuery("from TenderDescVO");
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
	
	public List edit(TenderDescVO tvo) {

		List ls = new ArrayList();
		Session session = null;

		try {
			System.out.println("inside edit");
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			Query q = session.createQuery("from TenderDescVO as t where t.tenderVO.tender_Id= '"+tvo.getTenderVO().getTender_Id()+"'");
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
	
	public void update(TenderDescVO r){
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
		  session.flush();
		  session.close();
		  }
		  }


	public Boolean delete(TenderDescVO avo){
		Session session = null;
		 

		  try{
		  // This step will read hibernate.cfg.xml 

		//and prepare hibernate for use
		  SessionFactory sessionFactory = new 

		Configuration().configure().buildSessionFactory();
		 session =sessionFactory.openSession();
		 Transaction te=session.beginTransaction();
		 System.out.println("selecting query");
		 
		 TenderDescVO avo1=(TenderDescVO)session.get(TenderDescVO.class, avo.getTenderVO());
		 session.delete(avo1);
		 
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
		 // session.flush();
		  session.close();

		  }
		  return true;
}
	
	
	public Boolean check(TenderDescVO tcVO)
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
			Query q=session.createQuery("from TenderDescVO as t where t.tenderVO.tender_Id = "+i);
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
	
	public List bringdate(TenderDescVO tcVO)
	{
			
			List ls=new ArrayList();
			
			Session session=null;
			
			try
			{
				SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
				session=sessionFactory.openSession();
				System.out.println("inside search of applytenderDAO");
				Query q=session.createQuery("select c.submission,c.tenderVO from TenderDescVO c");
				
			
				ls=q.list();
				System.out.println("done &&&& list size===" + ls.size());
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





