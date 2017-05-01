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

import VO.CategoryVO;
import VO.StreetVO;
import VO.AreaVO;
import VO.CityVO;
import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.StreetDAO;
 
/**
 * Servlet implementation class StreetController
 */
@WebServlet("/StreetController")
public class StreetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StreetController() {
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
		else if(flag!=null && flag.equals("update"))
		{
			update(request,response);
		}
		else if(flag!=null && flag.equals("delete"))
		{
			delete(request,response);
		}
		else
		{
		CityDAO cdao=new CityDAO();
		CityVO cvo=new CityVO();
		AreaDAO adao=new AreaDAO();
		AreaVO avo=new AreaVO();
		
		List ls=new ArrayList();
		List ls1=new ArrayList();

		System.out.println("before load");
		ls=cdao.load(cvo);
		ls1=adao.load(avo);
		
		System.out.println("session set");
		HttpSession session=request.getSession();
		session.setAttribute("City_list",ls);
		session.setAttribute("Area_list",ls1);
		
		System.out.println("load done");
		response.sendRedirect("Admin/Add_Street.jsp");}
		

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
		String Street_Name=request.getParameter("street_Name");
		String Street_desc=request.getParameter("StreetDesc");
		
		Long city_ID=Long.parseLong(request.getParameter("City_ID"));
		Long area_ID=Long.parseLong(request.getParameter("Area_ID"));
		
		CityVO cvo=new CityVO();
		cvo.setCity_ID(city_ID);
		
		 
		AreaVO avo=new AreaVO();
		avo.setArea_ID(area_ID);
		
		StreetVO svo=new StreetVO();
		svo.setStreet_Name(Street_Name);
		svo.setStreet_Desc(Street_desc);
		
		svo.setCityVO(cvo);
		svo.setAreaVO(avo);
		
		StreetDAO StreetDAO=new StreetDAO();
		StreetDAO.insert(svo);
	
				
		
	}
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		StreetVO sVO = new StreetVO();
		
		StreetDAO sDAO = new StreetDAO();
		List ls=sDAO.search(sVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		System.out.println("after search called");
		response.sendRedirect("Admin/Search_Street.jsp");
	
	}


protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("inside edit");
	List ls=null;
	String id=request.getParameter("id");
		
	StreetVO sVO = new StreetVO();
	StreetDAO sDAO = new StreetDAO();
	
	
	sVO.setStreet_ID(Long.valueOf(id));
	ls=sDAO.edit(sVO);
	
	
	HttpSession session=request.getSession();
	session.setAttribute("edit",ls);
	
	CityVO cityvo=new CityVO();
	CityDAO citydao=new CityDAO();
	List ls1=citydao.load(cityvo);
	
	AreaVO avo=new AreaVO();
	AreaDAO adao=new AreaDAO();
	List ls2=adao.load(avo);
	
	
	session.setAttribute("edit1",ls1);
	session.setAttribute("edit2",ls2);
	
   	response.sendRedirect("Admin/Edit_Street.jsp");

}


void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	System.out.println("inside update");
	String id=request.getParameter("id");
	
	String  sname= request.getParameter("street_Name");
	String sdesc = request.getParameter("StreetDesc");
	String areaid = request.getParameter("Area_ID");
	String cityid = request.getParameter("City_ID");
	
	
	System.out.println("name"+sname);
	System.out.println(sdesc);
	System.out.println(Long.valueOf(id));
	
	AreaVO avo =new AreaVO();
	avo.setArea_ID(Long.valueOf(areaid));
	
	CityVO cat =new CityVO();
	cat.setCity_ID(Long.valueOf(cityid));
	
	StreetVO sVO = new StreetVO();
	
	
	sVO.setStreet_ID(Long.valueOf(id));
	sVO.setStreet_Name(sname);
	sVO.setStreet_Desc(sdesc);
	sVO.setCityVO(cat);
	sVO.setAreaVO(avo);
	
	StreetDAO sDAO = new StreetDAO();
	sDAO.update(sVO);

}

protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	String id=request.getParameter("id");
	
	StreetVO sVO = new StreetVO();
	sVO.setStreet_ID(Long.valueOf(id));
	
	StreetDAO sDAO = new StreetDAO();
	HttpSession session= request.getSession();
	
	if(!sDAO.delete(sVO))
	{
		session.setAttribute("deleteflag", "false");
	}
		
	search(request, response);


}


}

