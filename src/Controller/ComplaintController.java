package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AreaDAO;
import DAO.ComplaintDAO;
import DAO.TenderDAO;
import VO.AreaVO;
import VO.ComplaintVO;
import VO.TenderVO;

/**
 * Servlet implementation class ComplaintController
 */
@WebServlet("/ComplaintController")
public class ComplaintController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		System.out.print(flag);
		if(flag!=null && flag.equals("search")){
			search(request, response);
		}
		else if(flag!=null && flag.equals("searcha")){
			searcha(request, response);
		}
		else if(flag!=null && flag.equals("searchg")){
			searchg(request, response);
		}
		else if(flag!=null && flag.equals("searchu")){
			searchu(request, response);
		}
		else if(flag!=null && flag.equals("loadc")){
			loadc(request, response);
		}
		else if(flag!=null && flag.equals("loadg")){
			loadg(request, response);
		}
		else if(flag!=null && flag.equals("loadu")){
			loadu(request, response);
		}
	}	
		void loadc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		TenderDAO tdao=new TenderDAO();
		TenderVO tvo=new TenderVO();
		List ls=new ArrayList();
		System.out.println("before load");
		ls=tdao.load(tvo);
		
		System.out.println("session set");
		HttpSession session=request.getSession();
		session.setAttribute("Tender_list",ls);
		
		System.out.println("load done");
		response.sendRedirect("Company/Post_Complaint.jsp");
		
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
		Long tid=Long.parseLong(request.getParameter("Tender_ID"));
		
		String subject=request.getParameter("subject");
		String complaint=request.getParameter("complaint");
		
		
		
		ComplaintVO cvo=new ComplaintVO(); 
	
		cvo.setSub(subject);
		cvo.setMsg(complaint);
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Id(tid);
		
		cvo.setTenderVO(tvo);
		
		
		ComplaintDAO atdao=new ComplaintDAO();
		atdao.insert(cvo);
		
				
		
	}
	
	
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	ComplaintVO aVO = new ComplaintVO();
		
		ComplaintDAO aDAO = new ComplaintDAO();
		List ls=aDAO.search(aVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("Company/View_Complaint.jsp");
	
	}


protected void searcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	ComplaintVO aVO = new ComplaintVO();
		
		ComplaintDAO aDAO = new ComplaintDAO();
		List ls=aDAO.search(aVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("Admin/Complaint.jsp");
	
	}

protected void searchg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	ComplaintVO aVO = new ComplaintVO();
		
		ComplaintDAO aDAO = new ComplaintDAO();
		List ls=aDAO.search(aVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("Government_Employee/View_Complaint.jsp");
	
	}

protected void searchu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	ComplaintVO aVO = new ComplaintVO();
		
		ComplaintDAO aDAO = new ComplaintDAO();
		List ls=aDAO.search(aVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("User/View_Complaint.jsp");
	
	}


void loadg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	TenderDAO tdao=new TenderDAO();
	TenderVO tvo=new TenderVO();
	List ls=new ArrayList();
	System.out.println("before load");
	ls=tdao.load(tvo);
	
	System.out.println("session set");
	HttpSession session=request.getSession();
	session.setAttribute("Tender_list",ls);
	
	System.out.println("load done");
	response.sendRedirect("Government_Employee/Post_Complaint.jsp");
	
	}
void loadu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	TenderDAO tdao=new TenderDAO();
	TenderVO tvo=new TenderVO();
	List ls=new ArrayList();
	System.out.println("before load");
	ls=tdao.load(tvo);
	
	System.out.println("session set");
	HttpSession session=request.getSession();
	session.setAttribute("Tender_list",ls);
	
	System.out.println("load done");
	response.sendRedirect("User/Post_Complaint.jsp");
	
	}


	}


