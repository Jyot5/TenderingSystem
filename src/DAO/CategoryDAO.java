package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import VO.CategoryVO;


public class CategoryDAO {
	public void insert(CategoryVO CatVO){
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
		  session.save(CatVO);
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
	public List load(CategoryVO catyvo)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside load");
			Query q=session.createQuery("from CategoryVO");
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
	public List search(CategoryVO catvo)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside search");
			Query q=session.createQuery("from CategoryVO");
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
	
	public List edit(CategoryVO catvo) {

		List ls = new ArrayList();
		Session session = null;

		try {
			System.out.println("inside edit");
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			Query q = session.createQuery("from CategoryVO where category_ID = '"+catvo.getCategory_ID()+"'");
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
	
	
	public void update(CategoryVO r){
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
		  session.saveOrUpdate(r);
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
	

	
	
	public Boolean delete(CategoryVO catvo){
		Session session = null;
		 

		  try{
		  // This step will read hibernate.cfg.xml 

		//and prepare hibernate for use
		  SessionFactory sessionFactory = new 

		Configuration().configure().buildSessionFactory();
		 session =sessionFactory.openSession();
		 Transaction te=session.beginTransaction();
		 System.out.println("selecting query");
		 
		 CategoryVO cvo=(CategoryVO)session.get(CategoryVO.class, catvo.getCategory_ID());
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
		  session.flush();
		  session.close();

		  }
		  return true;
}
}


