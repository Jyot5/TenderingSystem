package Controller;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.ApplyTenderDAO;
import DAO.CompanyProjectDAO;
import DAO.TenderCriteriaDAO;
import DAO.TenderDescDAO;
import VO.ApplyTenderVO;
import VO.CompanyProjectVO;
import VO.CompanyVO;
import VO.GovtEmpVO;
import VO.TenderCriteriaVO;
import VO.TenderDescVO;
import VO.TenderVO;
import VO.UserVO;
import DAO.TenderDAO;

/**
 * Servlet implementation class ApplyTenderController
 */
@WebServlet("/ApplyTenderController")
public class ApplyTenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyTenderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		System.out.println("flag=" + flag);
		
		if(flag!=null && flag.equals("searchzz"))
		{
			searchzz(request,response);
		}
		else if(flag!=null && flag.equals("searchzzz"))
		{
			searchzzz(request,response);
		}
		else if(flag!=null && flag.equals("searchaa"))
		{
			searchaa(request,response);
		}
		else
		{
			TenderDAO tdao=new TenderDAO();
			TenderVO tvo=new TenderVO();
			List ls=new ArrayList();
			System.out.println("before load");
			ls=tdao.load(tvo);
			
			
			System.out.println("session set");
			HttpSession session=request.getSession();
			session.setAttribute("Tender_list",ls);
			
			System.out.println("load done");
			response.sendRedirect("Company/Apply_for_Tender.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		System.out.println("flag = " + flag);
		if(flag!=null && flag.equals("insert")){
		
		insert(request,response);
		}
		
	}
	
	
	void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		
		Long dno=Long.parseLong(request.getParameter("ddno"));
		Long amnt=Long.parseLong(request.getParameter("amount"));
		Long t_ID=Long.parseLong(request.getParameter("idt"));
		
		System.out.println("amoount ==" + amnt);
		
		HttpSession session=request.getSession();
		Long www=(Long)session.getAttribute("userID");
		System.out.println(www + "=applytndercntrl's userid for insert");
			
		UserVO uvo=new UserVO();
		uvo.setUser_ID(www);
		
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Id(t_ID);
		
		TenderDescVO tdvo=new TenderDescVO();
		tdvo.setTenderVO(tvo);
		TenderDescDAO tddao=new TenderDescDAO();
		List ww=null;
		ww=tddao.edit(tdvo);
		
		Iterator itr1 =  ww.iterator();
		
		TenderDescVO a11 = (TenderDescVO)itr1.next();
		
		Long x1 = a11.getMin_Amount();
		Long x2 = a11.getMax_Amount();
		
		System.out.println("minimum amount ==" + x1);
		System.out.println("maximum amount ==" + x2);
		
		if(amnt <= x1 || amnt >= x2)
		{
			ApplyTenderVO atvo=new ApplyTenderVO(); 
			atvo.setDd_NO(dno);	
			atvo.setAmount(amnt);
			atvo.setTenderVO(tvo);
			atvo.setUservo(uvo);
			
			
			try{
				SimpleDateFormat obj=new SimpleDateFormat("yyyy/mm/dd");
				Date d=obj.parse(request.getParameter("dddate"));
				atvo.setDd_Date(d);
				
			}
			catch(Exception e)
			{}
			
			ApplyTenderDAO atdao=new ApplyTenderDAO();
			atdao.insert(atvo);


		}	
		else
		{
			response.sendRedirect("Company/Apply_for_Tender6.jsp");
		}
	}

	void searchzz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ApplyTenderVO atvo=new ApplyTenderVO();
		ApplyTenderDAO atdao=new ApplyTenderDAO();
		
		List ls=null;
		ls=atdao.search(atvo);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("searchz",ls);
		System.out.println("after session set123");
		
		CompanyProjectVO cpvo=new CompanyProjectVO();
		CompanyProjectDAO cpdao= new CompanyProjectDAO();
		
		List ls1=null;
		ls1=cpdao.search(cpvo);
		
		HttpSession session1=request.getSession();
		
		session1.setAttribute("de", ls1);
		System.out.println("after session set in applytenderdao");
		
		response.sendRedirect("Admin/Dashboard.jsp");
		
		
		
	}
	
	void searchzzz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ApplyTenderVO atvo=new ApplyTenderVO();
		ApplyTenderDAO atdao=new ApplyTenderDAO();
		
		
		
		List ls=null;
		ls=atdao.search(atvo);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("searchz",ls);
		System.out.println("after session set123");
		
		CompanyProjectVO cpvo=new CompanyProjectVO();
		CompanyProjectDAO cpdao= new CompanyProjectDAO();
		
		List ls1=null;
		ls1=cpdao.search(cpvo);
		
		HttpSession session1=request.getSession();
		
		session1.setAttribute("de", ls1);
		System.out.println("after session set in applytenderdao");
		
		response.sendRedirect("Government_Employee/Dashboard.jsp");
		
	}
	
	
	void searchaa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CompanyProjectVO cpvo=new CompanyProjectVO();
		CompanyProjectDAO cpdao = new CompanyProjectDAO();
		
		
		
		HttpSession session=request.getSession();
		Long p=(Long)session.getAttribute("userID");
		
		UserVO uvo=new UserVO();
		uvo.setUser_ID(p);
		
		cpvo.setUserVO(uvo);
		
		List ls=null;
		ls=cpdao.search1(cpvo);
		
		
			HttpSession session1=request.getSession();
			session1.setAttribute("searchaa1",ls);
			System.out.println("after session set!");
			
			//response.sendRedirect("Company/Dashboard.jsp");
	
		
		
		ApplyTenderVO apvo=new ApplyTenderVO();
		ApplyTenderDAO apdao=new ApplyTenderDAO();
		apvo.setUservo(uvo);
		
		List ls1=null;
		ls1=apdao.search2(apvo);
		
		HttpSession session2=request.getSession();
		session2.setAttribute("searchaa2",ls1);
		System.out.println("after session set!");
		
		response.sendRedirect("Company/Dashboard.jsp");
	
		
	}
}
