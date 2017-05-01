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

import VO.TenderVO;
import VO.CategoryVO;
import VO.SubCategoryVO;
import VO.CityVO;
import VO.AreaVO;
import VO.StreetVO;
import DAO.CategoryDAO;
import DAO.SubCategoryDAO;
import DAO.CityDAO;
import DAO.AreaDAO;
import DAO.StreetDAO;
import DAO.TenderDAO;
import DAO.TenderDescDAO;
import VO.TenderDescVO;
/**
 * Servlet implementation class TenderDescController
 */
@WebServlet("/TenderDescController")
public class TenderDescController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenderDescController() {
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
		else if(flag!=null && flag.equals("search1"))
		{
			search1(request,response);
		}
		else if(flag!=null && flag.equals("update"))
		{
			update(request,response);
		}
		else if(flag!=null && flag.equals("delete"))
		{
			delete(request,response);
		}
		else if(flag!=null && flag.equals("search2"))
		{
			search2(request,response);
		}
		else if(flag!=null && flag.equals("search3"))
		{
			search3(request,response);
		}
		else if(flag!=null && flag.equals("search4"))
		{
			search4(request,response);
		}
		else if(flag!=null && flag.equals("searchg"))
		{
			searchg(request,response);
		}
		else if(flag!=null && flag.equals("searchg1"))
		{
			searchg1(request,response);
		}
		else
		{
		CategoryDAO catdao=new CategoryDAO();
		CategoryVO catvo=new CategoryVO();
		SubCategoryDAO subcatdao=new SubCategoryDAO();
		SubCategoryVO subcatvo=new SubCategoryVO();
		TenderVO tvo=new TenderVO();
		TenderDAO tdao=new TenderDAO();
		CityDAO cdao=new CityDAO();
		CityVO cvo=new CityVO();
		AreaDAO adao=new AreaDAO();
		AreaVO avo=new AreaVO();
		StreetVO svo=new StreetVO();
		StreetDAO sdao=new StreetDAO();
		
		List ls=new ArrayList();
		List ls1=new ArrayList();
		List ls2=new ArrayList();
		List ls3=new ArrayList();
		List ls4=new ArrayList();
		List ls5=new ArrayList();
		
		
		
		
		ls=catdao.load(catvo);
		ls1=subcatdao.load(subcatvo);
		ls2=tdao.load(tvo);
		ls3=cdao.load(cvo);
		ls4=adao.load(avo);
		ls5=sdao.load(svo);
		
		HttpSession session=request.getSession();
		session.setAttribute("Cat_list",ls);
		session.setAttribute("SubCat_list",ls1);
		session.setAttribute("tender_list",ls2);
		session.setAttribute("City_list",ls3);
		session.setAttribute("Area_list",ls4);
		session.setAttribute("Street_list",ls5);
		
		
		response.sendRedirect("Admin/Add_TenderDescription.jsp");
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
		else if(flag!=null && flag.equals("check")){
			
			check(request,response);}
		}

	


	void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("inside controller insert");
		String earnestMoney=request.getParameter("earnest_Money");
		String max_amt=request.getParameter("maxamt");
		String min_amt=request.getParameter("minamt");
		String year1=request.getParameter("year");
		String month1=request.getParameter("month");
		//String submission1=request.getParameter("submission");
		
		Long earnest_Money=Long.parseLong(earnestMoney);
		Long maxamt=Long.parseLong(max_amt);
		Long minamt=Long.parseLong(min_amt);
		Long year=Long.parseLong(year1);
		Long month=Long.parseLong(month1);
		
		
		
		
	/*	SimpleDateFormat d = new SimpleDateFormat();
		
	Date w = d.parse(s);
	*/
		Long cat_ID=Long.parseLong(request.getParameter("Cat_ID"));
		Long subcat_ID=Long.parseLong(request.getParameter("SubCat_ID"));
		Long tender_ID=Long.parseLong(request.getParameter("idt"));
		Long city_ID=Long.parseLong(request.getParameter("City_ID"));
		Long area_ID=Long.parseLong(request.getParameter("Area_ID"));
		Long street_ID=Long.parseLong(request.getParameter("Street_ID"));
		
		CategoryVO catvo=new CategoryVO();
		catvo.setCategory_ID(cat_ID);
		
		SubCategoryVO subcatvo=new SubCategoryVO();
		subcatvo.setSubCategory_ID(subcat_ID);
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Id(tender_ID);
		
		CityVO cvo=new CityVO();
		cvo.setCity_ID(city_ID);
		
		AreaVO avo=new AreaVO();
		avo.setArea_ID(area_ID);
		
		StreetVO svo=new StreetVO();
		svo.setStreet_ID(street_ID);
		
		TenderDescVO tdvo=new TenderDescVO();
		try{
			SimpleDateFormat obj=new SimpleDateFormat("yyyy/mm/dd");
			Date d=obj.parse(request.getParameter("submission"));
			tdvo.setSubmission(d);
			
		}
		catch(Exception e)
		{}
		
		tdvo.setEarnest_Money(earnest_Money);
		tdvo.setMonth(month);
		tdvo.setYear(year);
		tdvo.setMax_Amount(maxamt);
		tdvo.setMin_Amount(minamt);
		
		tdvo.setCategoryVO(catvo);
		tdvo.setSubCategoryVO(subcatvo);
		tdvo.setTenderVO(tvo);
		tdvo.setCityVO(cvo);
		tdvo.setAreaVO(avo);
		tdvo.setStreetVO(svo);
		
		TenderDescDAO tdao=new TenderDescDAO();
		tdao.insert(tdvo);
	
				
		
	}

	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TenderDescVO tVO = new TenderDescVO();
		
		TenderDescDAO tDAO = new TenderDescDAO();
		List ls=tDAO.search(tVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("search3",ls);
		System.out.println("after session set");
		response.sendRedirect("Admin/Search_Tender.jsp");
	
	}

protected void search1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderDescVO tVO = new TenderDescVO();
	
	TenderDescDAO tDAO = new TenderDescDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search4",ls);
	System.out.println("after session set");
	response.sendRedirect("Admin/Edit_Tender.jsp");

}


protected void search2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderDescVO tVO = new TenderDescVO();
	
	TenderDescDAO tDAO = new TenderDescDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search3",ls);
	System.out.println("after session set");
	response.sendRedirect("Company/View_Tender.jsp");

}




protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("inside edit");
	
	String id=request.getParameter("idt");
	
	TenderVO tevo=new TenderVO();
	tevo.setTender_Id(Long.valueOf(id));
	
		
	TenderDescVO tVO = new TenderDescVO();
	tVO.setTenderVO(tevo);
	TenderDescDAO tDAO = new TenderDescDAO();
	
	List ls=null;
	ls=tDAO.edit(tVO);
	
	
	HttpSession session=request.getSession();
	session.setAttribute("edit",ls);
	
	CategoryVO catvo=new CategoryVO();
	CategoryDAO catdao=new CategoryDAO();
	List ls1=catdao.load(catvo);
	session.setAttribute("edit1",ls1);
	
	SubCategoryVO svo=new SubCategoryVO();
	SubCategoryDAO sdao=new SubCategoryDAO();
	List ls2=sdao.load(svo);
	session.setAttribute("edit2",ls2);
	
	CityVO cityvo=new CityVO();
	CityDAO citydao=new CityDAO();
	List ls3=citydao.load(cityvo);
	session.setAttribute("edit3",ls3);

	AreaVO avo=new AreaVO();
	AreaDAO adao=new AreaDAO();
	List ls4=adao.load(avo);
	session.setAttribute("edit4",ls4);
	
	//TenderVO tevo=new TenderVO();
	TenderDAO tedao=new TenderDAO();
	List ls5=tedao.load(tevo);
	session.setAttribute("edit5",ls5);
	
	StreetVO stvo=new StreetVO();
	StreetDAO stdao = new StreetDAO();
	List ls6=stdao.load(stvo);
	session.setAttribute("edit6",ls6);
	
   	response.sendRedirect("Admin/Edit_Tender1.jsp");

}


void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{	
	
	System.out.println("inside controller  update");
	
	String id=request.getParameter("idt");
	System.out.println(id);
	
	String idu=request.getParameter("idu");
	
	String  maximumamt= request.getParameter("maxamt");
	String  minimumamt= request.getParameter("minamt");
	String earnest=request.getParameter("EM");
	String catid = request.getParameter("Cat_ID");
	String subcatid = request.getParameter("SubCat_ID");
	//String tenderid = request.getParameter("tender_Id");
	String cityid = request.getParameter("City_ID");
	String areaid = request.getParameter("Area_ID");
	String streetid = request.getParameter("Street_ID");
	String y1 = request.getParameter("year2");
	String m1 = request.getParameter("month2");
	
	CategoryVO cat =new CategoryVO();
	cat.setCategory_ID(Long.valueOf(catid));
	
	SubCategoryVO svo=new SubCategoryVO();
	svo.setSubCategory_ID(Long.valueOf(subcatid));
	
	TenderVO tvo=new TenderVO();
	tvo.setTender_Id(Long.valueOf(idu));
	
	CityVO cvo=new CityVO();
	cvo.setCity_ID(Long.valueOf(cityid));
	
	AreaVO avo=new AreaVO();
	avo.setArea_ID(Long.valueOf(areaid));
	
	StreetVO stvo=new StreetVO();
	stvo.setStreet_ID(Long.valueOf(streetid));
	
	TenderDescVO tdvo=new TenderDescVO();
	tdvo.setTenderVO(tvo);
	tdvo.setTenderDescId(Long.valueOf(id));
	
	tdvo.setEarnest_Money(Long.valueOf(earnest));
	tdvo.setYear(Long.valueOf(y1));
	tdvo.setMonth(Long.valueOf(m1));
	tdvo.setAreaVO(avo);
	tdvo.setCategoryVO(cat);
	tdvo.setSubCategoryVO(svo);
	tdvo.setCityVO(cvo);
	tdvo.setStreetVO(stvo);
	tdvo.setMax_Amount(Long.valueOf(maximumamt));
	tdvo.setMin_Amount(Long.valueOf(minimumamt));
	
	TenderDescDAO tdDAO=new TenderDescDAO();
	tdDAO.update(tdvo);

}

protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	String id=request.getParameter("id");
	
	TenderVO tvo=new TenderVO();
	tvo.setTender_Id(Long.valueOf(id));
	
	TenderDescVO tdVO = new TenderDescVO();
	tdVO.setTenderVO(tvo);
	
	TenderDescDAO aDAO = new TenderDescDAO();
	HttpSession session= request.getSession();
	
	if(!aDAO.delete(tdVO))
	{
		session.setAttribute("deleteflag", "false");
	}
		
	search1(request, response);


}



void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	String s1=request.getParameter("tender_Id");
	System.out.println("id = " + s1);
	
	//String v=request.getParameter("tn");
	//System.out.println(v);
	
	TenderDescVO tvo=new TenderDescVO();
	TenderDescDAO tdao=new TenderDescDAO();
	
	TenderDAO t1dao=new TenderDAO();
	TenderVO t1vo=new TenderVO();
	t1vo.setTender_Id((Long.valueOf(s1)));
	
	List r = t1dao.load1(t1vo);
	
	HttpSession d = request.getSession();
	d.setAttribute("tendername", r);
	System.out.println("tender  = " + r.size());
	
	
	tvo.setTenderVO(t1vo);
	
	if(tdao.check(tvo))
	{
		System.out.println("in if");
		
		
		
		HttpSession session=request.getSession();
		//session.setAttribute("edit",ls);
		
		
		
		List ls5=t1dao.load(t1vo);
		session.setAttribute("edit5",ls5);
		
		CategoryVO catvo=new CategoryVO();
		CategoryDAO catdao=new CategoryDAO();
		List ls1=catdao.load(catvo);
		session.setAttribute("edit1",ls1);
		
		SubCategoryVO svo=new SubCategoryVO();
		SubCategoryDAO sdao=new SubCategoryDAO();
		List ls2=sdao.load(svo);
		session.setAttribute("edit2",ls2);
		
		CityVO cityvo=new CityVO();
		CityDAO citydao=new CityDAO();
		List ls3=citydao.load(cityvo);
		session.setAttribute("edit3",ls3);

		AreaVO avo=new AreaVO();
		AreaDAO adao=new AreaDAO();
		List ls4=adao.load(avo);
		session.setAttribute("edit4",ls4);
		
		StreetVO stvo=new StreetVO();
		StreetDAO stdao = new StreetDAO();
		List ls6=stdao.load(stvo);
		session.setAttribute("edit6",ls6);

		
	
		response.sendRedirect("Admin/Add_TenderDescription1.jsp");
	}
	else
	{
		System.out.println("in else");
		
		
		List ls=null;
		ls=tdao.edit(tvo);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("edit",ls);
		
		
		List ls5=t1dao.load(t1vo);
		session.setAttribute("edit5",ls5);
		
		CategoryVO catvo=new CategoryVO();
		CategoryDAO catdao=new CategoryDAO();
		List ls1=catdao.load(catvo);
		session.setAttribute("edit1",ls1);
		
		SubCategoryVO svo=new SubCategoryVO();
		SubCategoryDAO sdao=new SubCategoryDAO();
		List ls2=sdao.load(svo);
		session.setAttribute("edit2",ls2);
		
		CityVO cityvo=new CityVO();
		CityDAO citydao=new CityDAO();
		List ls3=citydao.load(cityvo);
		session.setAttribute("edit3",ls3);

		AreaVO avo=new AreaVO();
		AreaDAO adao=new AreaDAO();
		List ls4=adao.load(avo);
		session.setAttribute("edit4",ls4);
		
		StreetVO stvo=new StreetVO();
		StreetDAO stdao = new StreetDAO();
		List ls6=stdao.load(stvo);
		session.setAttribute("edit6",ls6);

		
		response.sendRedirect("Admin/Edit_Tender1.jsp");		
	}

	
		
	}


protected void search3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderDescVO tVO = new TenderDescVO();
	
	TenderDescDAO tDAO = new TenderDescDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search3",ls);
	System.out.println("after session set for company search");
	response.sendRedirect("Company/Search_Tender.jsp");

}

protected void search4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderDescVO tVO = new TenderDescVO();
	
	TenderDescDAO tDAO = new TenderDescDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search3",ls);
	System.out.println("after session set");
	response.sendRedirect("Company/View_TenderDescription.jsp");

}
protected void searchg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderDescVO tVO = new TenderDescVO();
	
	TenderDescDAO tDAO = new TenderDescDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search3",ls);
	System.out.println("after session set");
	response.sendRedirect("Government_Employee/View_TenderDescription.jsp");

}


protected void searchg1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderDescVO tVO = new TenderDescVO();
	
	TenderDescDAO tDAO = new TenderDescDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search3",ls);
	System.out.println("after session set");
	response.sendRedirect("Government_Employee/Search_Tender.jsp");

}


	}


