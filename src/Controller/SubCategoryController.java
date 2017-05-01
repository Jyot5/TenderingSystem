package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.CategoryDAO;
import DAO.SubCategoryDAO;

import VO.CategoryVO;

import VO.SubCategoryVO;

/**
 * Servlet implementation class SubCategoryController
 */
@WebServlet("/SubCategoryController")
public class SubCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryController() {
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
		else if(flag!=null && flag.equals("edit"))
		{
			edit(request,response);
		}
		else if(flag!=null && flag.equals("delete"))
		{
			delete(request,response);
		}
		else
		{
		CategoryDAO catdao=new CategoryDAO();
		CategoryVO catvo=new CategoryVO();
		List ls=new ArrayList();
		System.out.println("before load");
		ls=catdao.load(catvo);
		
		System.out.println("session set");
		HttpSession session=request.getSession();
		session.setAttribute("Cat_list",ls);
		
		System.out.println("load done");
		response.sendRedirect("Admin/Add_SubCategory.jsp");

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
		else if(flag!=null && flag.equals("search"))
		{
			search(request,response);
		}
		else if(flag!=null && flag.equals("update"))
		{
			update(request,response);
		}
		else if(flag!=null && flag.equals("delete"))
		{
			delete(request,response);
		}

	}
	
	void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String SubCatName=request.getParameter("SubCatName");
		String SubCatDesc=request.getParameter("SubCatDesc");
		
		Long cat_ID=Long.parseLong(request.getParameter("Cat_ID"));
		
		CategoryVO catvo=new CategoryVO();
		catvo.setCategory_ID(cat_ID);
		
		SubCategoryVO subcatvo=new SubCategoryVO(); 
		
		subcatvo.setSubCategory_Name(SubCatName);	
		subcatvo.setSubCategory_Description(SubCatDesc);
		
		subcatvo.setCategoryVO(catvo);
		
		SubCategoryDAO subcatDAO=new SubCategoryDAO();
		subcatDAO.insert(subcatvo);
	
				
		
	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SubCategoryVO subcatVO = new SubCategoryVO();
		
		SubCategoryDAO subcatDAO = new SubCategoryDAO();
		List ls=subcatDAO.search(subcatVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("Admin/Search_SubCategory.jsp");
	
	}
	
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside edit");
		List ls=null;
		String id=request.getParameter("id");
				
		SubCategoryVO subcatVO = new SubCategoryVO();
		SubCategoryDAO subcatDAO = new SubCategoryDAO();
		
		subcatVO.setSubCategory_ID(Long.valueOf(id));
		ls=subcatDAO.edit(subcatVO);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("edit",ls);
		
		CategoryVO catvo=new CategoryVO();
		CategoryDAO catdao=new CategoryDAO();
		List ls1=catdao.load(catvo);
		
		
		session.setAttribute("edit1",ls1);
		
       	response.sendRedirect("Admin/Edit_SubCategory.jsp");
	
	}
	
	void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=request.getParameter("id");
		
		String  subCatName= request.getParameter("SubCatName");
		String subCatDesc = request.getParameter("SubCatDesc");
		String catid = request.getParameter("Cat_ID");
		
	
		CategoryVO cat =new CategoryVO();
		cat.setCategory_ID(Long.valueOf(catid));
		
		SubCategoryVO subcatVO = new SubCategoryVO();
		
		
		subcatVO.setSubCategory_ID(Long.valueOf(id));
		subcatVO.setSubCategory_Name(subCatName);
		subcatVO.setSubCategory_Description(subCatDesc);
		subcatVO.setCategoryVO(cat);
		
		SubCategoryDAO subcatDAO = new SubCategoryDAO();
		subcatDAO.update(subcatVO);

}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=request.getParameter("id");
		
		SubCategoryVO subcatVO = new SubCategoryVO();
		subcatVO.setSubCategory_ID(Long.valueOf(id));
		
		SubCategoryDAO subcatDAO = new SubCategoryDAO();
		HttpSession session= request.getSession();
		
		if(!subcatDAO.delete(subcatVO))
		{
			session.setAttribute("deleteflag", "false");
		}
			
		search(request, response);
	

	}
   	}
