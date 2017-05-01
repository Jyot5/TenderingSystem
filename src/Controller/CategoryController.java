package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import VO.CategoryVO;
import DAO.CategoryDAO;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
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
		if(flag!=null && flag.equals("search"))
		{
			search(request,response);
		}
	else if(flag!=null && flag.equals("delete"))
	{
		delete(request,response);
	}
	else if(flag!=null && flag.equals("edit"))
	{
		edit(request, response);
	}
		
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String flag=request.getParameter("flag");
		System.out.println("flag = " + flag);
		if(flag!=null && flag.equals("insert"))
			{
				insert(request,response);
			}
		else if(flag!=null && flag.equals("search"))
			{
				search(request,response);
			}
		else if(flag!=null && flag.equals("delete"))
		{
			delete(request,response);
		}
		else if(flag!=null && flag.equals("edit"))
		{
			edit(request,response);
		}
		else if(flag!=null && flag.equals("update"))
		{
			update(request,response);
		}
	}
	
	
		void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			String  CatName= request.getParameter("CatName");
			String CatDesc = request.getParameter("CatDesc");
		
		CategoryVO CatVO = new CategoryVO();
		
		CatVO.setCategory_Name(CatName);
		CatVO.setCategory_Description(CatDesc);
		
		CategoryDAO CatDAO = new CategoryDAO();
		CatDAO.insert(CatVO);
	
	}
		
		
		protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			CategoryVO CatVO = new CategoryVO();
			
			CategoryDAO CatDAO = new CategoryDAO();
			List ls=CatDAO.search(CatVO);
			
			HttpSession session=request.getSession();
			session.setAttribute("search1",ls);
			response.sendRedirect("Admin/Search_Category.jsp");
		
		}


		
		
		protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("inside edit");
			List ls=null;
			String id=request.getParameter("id");
			
			
			CategoryVO CatVO = new CategoryVO();
			CategoryDAO CatDAO = new CategoryDAO();
			
			CatVO.setCategory_ID(Long.valueOf(id));
			ls=CatDAO.edit(CatVO);
			
			
			HttpSession session=request.getSession();
			session.setAttribute("edit",ls);
			
	       	response.sendRedirect("Admin/Edit_Category.jsp");
		
		}
		
		void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			String id=request.getParameter("id");
			
			String  CatName= request.getParameter("CatName");
			String CatDesc = request.getParameter("CatDesc");
		
			CategoryVO CatVO = new CategoryVO();
			CatVO.setCategory_ID(Long.valueOf(id));
			CatVO.setCategory_Name(CatName);
			CatVO.setCategory_Description(CatDesc);
		
			CategoryDAO CatDAO = new CategoryDAO();
			CatDAO.update(CatVO);
	
	}
		
		protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			String id=request.getParameter("id");
			
			CategoryVO CatVO = new CategoryVO();
			CatVO.setCategory_ID(Long.valueOf(id));
			
			CategoryDAO CatDAO = new CategoryDAO();
			HttpSession session= request.getSession();
			
			if(!CatDAO.delete(CatVO))
			{
				session.setAttribute("deleteflag", "false");
			}
				
			search(request, response);
		
	
		}


}

