package DAO;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CategoryVO;
import VO.GradeVO;
import VO.UserVO;

public class UserDAO {
	
	
		public List login(UserVO uv)
		{
			List l=null;
			Session session=null;
			try
			{	
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				 session =sessionFactory.openSession();
				l=new ArrayList();
				Query q=session.createQuery("from UserVO where first_Name like '"+uv.getFirst_Name()+"' and user_Password like '"+uv.getUser_Password()+"'");
				l=q.list();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return l;
			
		}

		
		
		public List search(UserVO gvo)
		{
			
			List ls=new ArrayList();
			
			Session session=null;
			
			try
			{
				SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
				session=sessionFactory.openSession();
				System.out.println("inside search");
				Query q=session.createQuery("from UserVO");
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
		
		public void insert(UserVO CatVO){
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

		
		public void update(UserVO r){
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
		




}
