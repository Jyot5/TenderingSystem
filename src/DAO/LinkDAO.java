package DAO;
import VO.LinkVO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class LinkDAO {
	
public List getElementByLink(LinkVO linkVO){
		
		Session session = null;
		List temp = null;
		
		
		try{
		  
		    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		    session =sessionFactory.openSession();
		
		    Transaction tr = session.beginTransaction();
		 
		    Query q = session.createQuery("FROM LinkVO WHERE link = '"+linkVO.getLink()+"' ");
		    temp = q.list();
		
		    tr.commit();
		 
		 }catch(Exception e){
			                 e.printStackTrace();
		  					}finally{
		  							
		  							session.close();
		  
		  							}
		  
		System.out.println(temp);
		 return temp;
		
		
	}
	
	public void insert(LinkVO VO_obj){
		
		Session session = null;
		
		 try{
			  
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  session =sessionFactory.openSession();
			 
			  
			  Transaction t= session.beginTransaction();
			
			  session.save(VO_obj);
			  
			  t.commit();
			
			
	    }catch(Exception e){
			  e.printStackTrace();
			  
			  }finally{
			        
				      session.close();
			  
			          }
			  
			  
		
	}
	
	
	
  public List getElementByID(LinkVO VO_obj){
		
		Session session = null;
		List temp = null;
		
		
		try{
		  
		    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		    session =sessionFactory.openSession();
		
		    Transaction tr = session.beginTransaction();
		 
		    Query q = session.createQuery("FROM LinkVO WHERE linkID = '"+ VO_obj.getLinkID()+"'");
		    temp = q.list();
		
		    tr.commit();
		 
		 }catch(Exception e){
			                 e.printStackTrace();
		  					}finally{
		  							
		  							session.close();
		  
		  							}
		  
		 return temp;
		
			
	}
  
  public void update(LinkVO VO_obj){
	  
		Session session = null;
		
		  try{
		  
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  session =sessionFactory.openSession();
		
			  Transaction tr = session.beginTransaction();
		 
			  session.update(VO_obj);
		 
			  tr.commit();
		 
		  }catch(Exception e){
			  				e.printStackTrace();
		  					}finally{
		  						    session.close();
		  							}
		  
		}
	




}
