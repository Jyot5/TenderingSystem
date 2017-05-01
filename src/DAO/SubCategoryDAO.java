package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CategoryVO;
import VO.LinkVO;
import VO.SubCategoryVO;

public class SubCategoryDAO {
	public void insert(SubCategoryVO SubCatVO){
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
		  session.save(SubCatVO);
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
	public List load(SubCategoryVO subcategoryvo)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside load");
			Query q=session.createQuery("from SubCategoryVO");
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

	public List search(SubCategoryVO subcatvo)
	{
		
		List ls=new ArrayList();
		
		Session session=null;
		
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			session=sessionFactory.openSession();
			System.out.println("inside search");
			Query q=session.createQuery("from SubCategoryVO");
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
	
	public List edit(SubCategoryVO subcatvo) {

		List ls = new ArrayList();
		Session session = null;

		try {
			System.out.println("inside edit");
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			Query q = session.createQuery("from SubCategoryVO where subCategory_ID = '"+subcatvo.getSubCategory_ID()+"'");
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
	
	
	public void update(SubCategoryVO r){
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

	public Boolean delete(SubCategoryVO subcatvo){
		Session session = null;
		 

		  try{
		  // This step will read hibernate.cfg.xml 

		//and prepare hibernate for use
		  SessionFactory sessionFactory = new 

		Configuration().configure().buildSessionFactory();
		 session =sessionFactory.openSession();
		 Transaction te=session.beginTransaction();
		 System.out.println("selecting query");
		 
		 SubCategoryVO subcatvo1=(SubCategoryVO)session.get(SubCategoryVO.class, subcatvo.getSubCategory_ID());
		 session.delete(subcatvo1);
		 
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

	
	 public List getElementByID(SubCategoryVO subcatvo){
			
			Session session = null;
			List ls = null;
			
			
			try{
			  
			    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			    session =sessionFactory.openSession();
			
			    Transaction tr = session.beginTransaction();
			 
			    Query q = session.createQuery("from SubCategoryVO as a where a.categoryVO.category_ID='"+subcatvo.getCategoryVO().getCategory_ID()+"'");
			    ls = q.list();
			    System.out.println("list size ===" + ls.size());
			    tr.commit();
			 
			 }catch(Exception e){
				                 e.printStackTrace();
			  					}finally{
			  							
			  							session.close();
			  							
			  
			  							}
			  
			 return ls;
			
				
		}
	
	
}

