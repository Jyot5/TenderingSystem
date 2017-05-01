package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.GradeDAO;
import VO.CategoryVO;
import VO.GradeVO;

/**
 * Servlet implementation class GradeController
 */
@WebServlet("/GradeController")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeController() {
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
	
				String  GradeName= request.getParameter("GradeName");
				String GradeDesc = request.getParameter("GradeDesc");
				
				GradeVO GradeVO = new GradeVO();
				
				GradeVO.setGrade_Name(GradeName);
				GradeVO.setGrade_Description(GradeDesc);
				
				GradeDAO GradeDAO = new GradeDAO();
				GradeDAO.insert(GradeVO);
	}
	
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GradeVO gVO = new GradeVO();
		
		GradeDAO gDAO = new GradeDAO();
		List ls=gDAO.search(gVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("Admin/Search_Grade.jsp");
	
	}

	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside controller edit");
		List ls=null;
		String id=request.getParameter("id");
		
		
		
		
		String gname=request.getParameter("grade_Name");
		String description=request.getParameter("grade_Description");
		
		GradeVO gVO = new GradeVO();
		GradeDAO gDAO = new GradeDAO();
		
		gVO.setGrade_Description(description);
		gVO.setGrade_Name(gname);
		gVO.setGrade_ID(Long.valueOf(id));
		ls=gDAO.edit(gVO);
		
		System.out.println("before controller session");
		HttpSession session=request.getSession();
		session.setAttribute("edit",ls);
		System.out.println("after controller session");
       	response.sendRedirect("Admin/Edit_Grade.jsp");
	
	}
	
	void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=request.getParameter("id");
		System.out.println(Long.valueOf(id));
		
		String  gname= request.getParameter("GradeName");
		String gdesc = request.getParameter("GradeDesc");
		
		System.out.println(gname);
		System.out.print(gdesc);
		
		GradeVO gVO = new GradeVO();
		gVO.setGrade_ID(Long.valueOf(id));
		gVO.setGrade_Name(gname);
		gVO.setGrade_Description(gdesc);
	
		GradeDAO gDAO = new GradeDAO();
		gDAO.update(gVO);

}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=request.getParameter("id");
		
		GradeVO gVO = new GradeVO();
		gVO.setGrade_ID(Long.valueOf(id));
		
		GradeDAO gDAO = new GradeDAO();
		HttpSession session= request.getSession();
		
		if(!gDAO.delete(gVO))
		{
			session.setAttribute("deleteflag", "false");
		}
			
		search(request, response);
	

	}


	
	
}
