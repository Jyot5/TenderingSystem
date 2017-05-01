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
import DAO.WorkTypeDAO;
import VO.CategoryVO;
import VO.WorkTypeVO;

/**
 * Servlet implementation class WorkTypeController
 */
@WebServlet("/WorkTypeController")
public class WorkTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkTypeController() {
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
	
				String  WorkType_Name= request.getParameter("WorkType_Name");
				String WorkType_Desc = request.getParameter("WorkType_Description");
				
				WorkTypeVO WorkTypeVO = new WorkTypeVO();
				
				WorkTypeVO.setWorkType_Name(WorkType_Name);
				WorkTypeVO.setWorkType_Description(WorkType_Desc);
				
				WorkTypeDAO WorkTypeDAO = new WorkTypeDAO();
				WorkTypeDAO.insert(WorkTypeVO);
	}
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WorkTypeVO wtVO = new WorkTypeVO();
		
		WorkTypeDAO wtDAO = new WorkTypeDAO();
		List ls=wtDAO.search(wtVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("Admin/Search_WorkType.jsp");
	
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside edit");
		List ls=null;
		String id=request.getParameter("id");
		
		
		WorkTypeVO wtVO = new WorkTypeVO();
		WorkTypeDAO wtDAO = new WorkTypeDAO();
		
		wtVO.setWorkType_ID(Long.valueOf(id));
		ls=wtDAO.edit(wtVO);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("edit",ls);
		
       	response.sendRedirect("Admin/Edit_WorkType.jsp");
	
	}
	
	void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=request.getParameter("id");
		
		String  wtName= request.getParameter("WorkType_Name");
		String wtDesc = request.getParameter("WorkType_Description");
	
		WorkTypeVO wtVO = new WorkTypeVO();
		wtVO.setWorkType_ID(Long.valueOf(id));
		wtVO.setWorkType_Name(wtName);
		wtVO.setWorkType_Description(wtDesc);
	
		WorkTypeDAO wtDAO = new WorkTypeDAO();
		wtDAO.update(wtVO);

}
 
	void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("inside delete");
		
		String id=request.getParameter("id");
		
		
		WorkTypeVO wtVO = new WorkTypeVO();
		WorkTypeDAO wtDAO = new WorkTypeDAO();
		
		wtVO.setWorkType_ID(Long.valueOf(id));
		wtDAO.delete(wtVO);
       search(request, response);
		
		
	}
	
	
    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	WorkTypeDAO wtDAO=new WorkTypeDAO();
		List obj= wtDAO.showAll();
		
		HttpSession session = request.getSession();
		session.setAttribute("obj_all", obj);
		response.sendRedirect(request.getContextPath()+"/showWorkType.jsp");
	
	}
	}


