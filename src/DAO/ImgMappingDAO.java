package DAO;



import VO.ImgMapping1VO;
import VO.ImgMappingVO;
import lscd.MyUtility;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ImgMappingDAO {

	public void insert(ImgMappingVO VO_obj){
		
		Session session = null;
		
		 try{
			  
			 session = MyUtility.getSession();// Static Method which makes only one object as method is static 
			  
			  Transaction t= session.beginTransaction();
			
			  session.save(VO_obj);
			  
			  t.commit();
			
			
	    }catch(Exception e){
			  System.out.println(e.getMessage());
			  
			  }finally{
			        
				      session.close();
			  
			          }
			  
			  
		
	}
	
public void insert1(ImgMapping1VO VO_obj){
		
		Session session = null;
		
		 try{
			  
			 session = MyUtility.getSession();// Static Method which makes only one object as method is static 
			  
			  Transaction t= session.beginTransaction();
			
			  session.save(VO_obj);
			  
			  t.commit();
			
			
	    }catch(Exception e){
			  System.out.println(e.getMessage());
			  
			  }finally{
			        
				      session.close();
			  
			          }
			  
			  
		
	}
	
	

}
