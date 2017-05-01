package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ApplyTenderVO;
import VO.CompanyProjectVO;
import VO.TenderCriteriaVO;
import VO.TenderVO;

public class ApplyTenderDAO {
	
	public void insert(ApplyTenderVO atVO){
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
		  session.save(atVO);
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
		  public List checkk(ApplyTenderVO atVO) {

				List ls = new ArrayList();
				Session session = null;

				try {
					System.out.println("inside edit");
					SessionFactory sessionFactory = new Configuration().configure()
							.buildSessionFactory();
					session = sessionFactory.openSession();
					Transaction tr = session.beginTransaction();
					Query q = session.createQuery("from ApplyTenderVO as t where t.tenderVO.tender_Id= '"+ atVO.getTenderVO().getTender_Id()+"'");
					ls = q.list();
					
					System.out.println("done jjj" + ls.size());
					
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

		  
		  public List search(ApplyTenderVO atVO)
			{
				
				List ls=new ArrayList();
				
				Session session=null;
				
				try
				{
					SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
					session=sessionFactory.openSession();
					System.out.println("inside search");
					Query q=session.createQuery("from ApplyTenderVO");
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
		  
		  public List search2(ApplyTenderVO atVO)
			{
				
				List ls=new ArrayList();
				
				Session session=null;
				
				try
				{
					SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
					session=sessionFactory.openSession();
					System.out.println("inside search");
					Query q=session.createQuery("from ApplyTenderVO as c where c.uservo.User_ID = '"+ atVO.getUservo().getUser_ID()+"'");
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
			
			

	 public List find(ApplyTenderVO atVO)
		{
				
				List ls=new ArrayList();
				
				Session session=null;
				
				try
				{
					SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
					session=sessionFactory.openSession();
					System.out.println("inside search of applytenderDAO");
					Query q=session.createQuery("select min(c.amount),c.uservo,c.tenderVO from ApplyTenderVO as c where c.tenderVO.tender_Id="+atVO.getTenderVO().getTender_Id() +"group by c.tenderVO.tender_Id" );
					
				
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

