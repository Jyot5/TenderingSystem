package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import VO.TenderVO;
import DAO.TenderDAO;
import VO.AreaVO;
import VO.CategoryVO;
import VO.SubCategoryVO;
import VO.TenderDescVO;
import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.SubCategoryDAO;
import DAO.TenderDescDAO;
/**
 * Servlet implementation class TenderController
 */
@WebServlet("/TenderController")
public class TenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		System.out.println("flag = " + flag);
		
		String mode=request.getParameter("mode");
		System.out.println("mode is ======== " + mode);
		
		if(mode!=null && mode.equals("dropDown"))
		{
			dropDown(request,response);
		}

		else if(flag!=null && flag.equals("delete"))
		{
			delete(request,response);
		}
		else if(flag!=null && flag.equals("search1"))
		{
			search1(request,response);
		}
		else if(flag!=null && flag.equals("search2"))
		{
			search2(request,response);
		}
		else if(flag!=null && flag.equals("searchg"))
		{
			searchg(request,response);
		}
		else if(flag!=null && flag.equals("searchk"))
		{
			searchk(request,response);
		}
		
		else if(flag!=null && flag.equals("searchu"))
		{
			searchu(request,response);
		}
		else if(flag!=null && flag.equals("loadp"))
		{
			loadp(request,response);
		}
		
		else
		{
		
		CategoryDAO catdao=new CategoryDAO();
		CategoryVO catvo=new CategoryVO();
		SubCategoryDAO subcatdao=new SubCategoryDAO();
		SubCategoryVO subcatvo=new SubCategoryVO();
		
		List ls=new ArrayList();
		List ls1=new ArrayList();

		System.out.println("before load");
		ls=catdao.load(catvo);
		ls1=subcatdao.load(subcatvo);
		
		System.out.println("session set");
		HttpSession session=request.getSession();
		session.setAttribute("Cat_list",ls);
		session.setAttribute("SubCat_list",ls1);
		
		System.out.println("load done");
		response.sendRedirect("Admin/Add_Tender.jsp");
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
		String Tender_Name=request.getParameter("tender_Name");
		String Tender_Description=request.getParameter("tender_Description");
		
		Long cat_ID=Long.parseLong(request.getParameter("Cat_ID"));
		Long subcat_ID=Long.parseLong(request.getParameter("SubCat_ID"));
		
		CategoryVO catvo=new CategoryVO();
		catvo.setCategory_ID(cat_ID);
		
		SubCategoryVO subcatvo=new SubCategoryVO();
		subcatvo.setSubCategory_ID(subcat_ID);
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Name(Tender_Name);
		tvo.setTender_Description(Tender_Description);
		
		tvo.setCategoryVO(catvo);
		tvo.setSubCategoryVO(subcatvo);
		
		TenderDAO TenderDAO=new TenderDAO();
		TenderDAO.insert(tvo);
	
				
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		System.out.println(" call delete");
		String id=request.getParameter("id");
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Id(Long.valueOf(id));
		
		
		
		TenderDAO aDAO = new TenderDAO();
		HttpSession session= request.getSession();
		
		if(!aDAO.delete(tvo))
		{
			session.setAttribute("deleteflag", "false");
		}
			
		search1(request, response);


	}
	
	protected void search1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TenderVO tVO = new TenderVO();
		
		TenderDAO tDAO = new TenderDAO();
		List ls=tDAO.search(tVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("search4",ls);
		System.out.println("after session set123");
		response.sendRedirect("Admin/Edit_Tender.jsp");

	}


protected void search2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TenderVO tVO = new TenderVO();
		
		TenderDAO tDAO = new TenderDAO();
		List ls=tDAO.search(tVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("search4",ls);
		System.out.println("after session set123");
		response.sendRedirect("Company/View_Tender.jsp");

	}

protected void searchg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderVO tVO = new TenderVO();
	
	TenderDAO tDAO = new TenderDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search4",ls);
	System.out.println("after session set123");
	response.sendRedirect("Government_Employee/View_Tender.jsp");

}


protected void searchk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderVO tVO = new TenderVO();
	
	TenderDAO tDAO = new TenderDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search4",ls);
	System.out.println("after session set123");
	response.sendRedirect("Government_Employee/Dashboard.jsp");

}

protected void searchu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderVO tVO = new TenderVO();
	
	TenderDAO tDAO = new TenderDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search4",ls);
	System.out.println("after session set123");
	response.sendRedirect("User/View_Tender.jsp");

}


void loadp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	TenderDAO tdao=new TenderDAO();
	TenderVO tvo=new TenderVO();
	List ls=new ArrayList();
	System.out.println("before load");
	ls=tdao.load(tvo);
	
	System.out.println("session set");
	HttpSession session=request.getSession();
	session.setAttribute("Tender_list",ls);
	
	System.out.println("load done");
	response.sendRedirect("Company/Post_WorkingReport.jsp");
	
	}
protected void dropDown(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Long Catid= Long.valueOf(request.getParameter("catID"));

	if (Catid == null) {
		Catid = 0L;
	}

	CategoryVO categoryvo=new CategoryVO();
	categoryvo.setCategory_ID(Catid);
	
	SubCategoryVO subcatvo=new SubCategoryVO();
	subcatvo.setCategoryVO(categoryvo);
	
	
	SubCategoryDAO subcatdao=new SubCategoryDAO();
	List subcatlist = subcatdao.getElementByID(subcatvo);
	
	
	String jsonString;

	if (!subcatlist.isEmpty()) {
		Iterator itr = subcatlist.iterator();
		SubCategoryVO subcatVO ;

		Map<String, String> scat = new LinkedHashMap<String, String>();

		scat.put("0", "Select Subcat");
		while (itr.hasNext()) {

			subcatVO = (SubCategoryVO) itr.next();
			scat.put("" + subcatVO.getSubCategory_ID() + "",subcatVO.getSubCategory_Name());

		}

		jsonString = new Gson().toJson(scat);
	} else {

		Map<String, String> reset = new LinkedHashMap<String, String>();
		reset.put("0", "Select Subcat");

		jsonString = new Gson().toJson(reset);
	}
System.out.println("hsajh==="+jsonString);
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(jsonString);

}

	
		}

