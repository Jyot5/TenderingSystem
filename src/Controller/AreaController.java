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

import VO.AreaVO;
import VO.CategoryVO;
import VO.CityVO;
import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;

/**
 * Servlet implementation class AreaController
 */
@WebServlet("/AreaController")
public class AreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaController() {
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
		
		CityDAO cdao=new CityDAO();
		CityVO cvo=new CityVO();
		List ls=new ArrayList();
		System.out.println("before load");
		ls=cdao.load(cvo);
		
		System.out.println("session set");
		HttpSession session=request.getSession();
		session.setAttribute("City_list",ls);
		
		System.out.println("load done");
		response.sendRedirect("Admin/Add_Area.jsp");
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
		else if(flag!=null && flag.equals("update"))
		{
			update(request,response);
		}
	}
	
	void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String Area_Name=request.getParameter("area_Name");
		String Area_desc=request.getParameter("AreaDesc");
		
		Long city_ID=Long.parseLong(request.getParameter("City_ID"));
		
		CityVO cvo=new CityVO();
		cvo.setCity_ID(city_ID);
		
		AreaVO avo=new AreaVO(); 
		
		avo.setArea_Name(Area_Name);	
		avo.setCityVO(cvo);
		avo.setArea_Desc(Area_desc);
		
		AreaDAO AreaDAO=new AreaDAO();
		AreaDAO.insert(avo);
	
				
		
	}
	
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AreaVO aVO = new AreaVO();
		
		AreaDAO aDAO = new AreaDAO();
		List ls=aDAO.search(aVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("Admin/Search_Area.jsp");
	
	}


protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("inside edit");
	List ls=null;
	String id=request.getParameter("id");
	
	
	//Long id=Long.parseLong(request.getParameter("se.category_ID"));
	//System.out.print(id);
	
	AreaVO aVO = new AreaVO();
	AreaDAO aDAO = new AreaDAO();
	
	
	aVO.setArea_ID(Long.valueOf(id));
	
	ls=aDAO.edit(aVO);
	
	
	HttpSession session=request.getSession();
	session.setAttribute("edit",ls);
	
	CityVO catvo=new CityVO();
	CityDAO catdao=new CityDAO();
	List ls1=catdao.load(catvo);
	
	
	session.setAttribute("edit1",ls1);
	
   	response.sendRedirect("Admin/Edit_Area.jsp");

}


void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	String id=request.getParameter("id");
	
	String  aname= request.getParameter("area_Name");
	String adesc = request.getParameter("AreaDesc");
	String cityid = request.getParameter("City_ID");
	
	
	System.out.println("name"+aname);
	System.out.println(adesc);
	System.out.println(Long.valueOf(id));
	
	CityVO cat =new CityVO();
	cat.setCity_ID(Long.valueOf(cityid));
	
	AreaVO aVO = new AreaVO();
	
	
	aVO.setArea_ID(Long.valueOf(id));
	aVO.setArea_Name(aname);
	aVO.setArea_Desc(adesc);
	aVO.setCityVO(cat);
	
	AreaDAO aDAO = new AreaDAO();
	aDAO.update(aVO);

}


protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	String id=request.getParameter("id");
	
	AreaVO aVO = new AreaVO();
	aVO.setArea_ID(Long.valueOf(id));
	
	AreaDAO aDAO = new AreaDAO();
	HttpSession session= request.getSession();
	
	if(!aDAO.delete(aVO))
	{
		session.setAttribute("deleteflag", "false");
	}
		
	search(request, response);


}


}
