package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AreaDAO;
import DAO.CityDAO;
import VO.AreaVO;
import VO.CityVO;

/**
 * Servlet implementation class CityController
 */
@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityController() {
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
			//delete(request,response);
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
		
				String  City_Name= request.getParameter("City_Name");
				String  City_desc= request.getParameter("CityDesc");
				
				CityVO CityVO = new CityVO();
				
				CityVO.setCity_Name(City_Name);
				CityVO.setCity_Description(City_desc);
				
				CityDAO CityDAO = new CityDAO();
				CityDAO.insert(CityVO);
	}

	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CityVO cVO = new CityVO();
		
		CityDAO cDAO = new CityDAO();
		List ls=cDAO.search(cVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("Admin/Search_City.jsp");
	
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside edit");
		List ls=null;
		String id=request.getParameter("id");
		
		
		CityVO CatVO = new CityVO();
		CityDAO CatDAO = new CityDAO();
		
		CatVO.setCity_ID(Long.valueOf(id));
		ls=CatDAO.edit(CatVO);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("edit",ls);
		
       	response.sendRedirect("Admin/Edit_City.jsp");
	
	}
	
	
	void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=request.getParameter("id");
		
		String  CatName= request.getParameter("City_Name");
		String CatDesc = request.getParameter("CityDesc");
	
		CityVO CatVO = new CityVO();
		CatVO.setCity_ID(Long.valueOf(id));
		CatVO.setCity_Name(CatName);
		CatVO.setCity_Description(CatDesc);
	
		CityDAO CatDAO = new CityDAO();
		CatDAO.update(CatVO);

}

	

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=request.getParameter("id");
		
		CityVO cVO = new CityVO();
		cVO.setCity_ID(Long.valueOf(id));
		
		CityDAO cDAO = new CityDAO();
		HttpSession session= request.getSession();
		
		if(!cDAO.delete(cVO))
		{
			session.setAttribute("deleteflag", "false");
		}
			
		search(request, response);


	}



	
}
