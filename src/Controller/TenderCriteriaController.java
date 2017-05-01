package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import DAO.ApplyTenderDAO;
import DAO.CategoryDAO;
import DAO.CompanyDAO;
import DAO.GradeDAO;
import DAO.SubCategoryDAO;
import DAO.TenderDAO;
import DAO.TenderDescDAO;
import VO.ApplyTenderVO;
import VO.CategoryVO;
import VO.CompanyVO;
import VO.GradeVO;
import VO.SubCategoryVO;
import VO.TenderDescVO;
import VO.TenderVO;
import VO.TenderCriteriaVO;
import VO.UserVO;
import DAO.TenderCriteriaDAO;
/**
 * Servlet implementation class TenderCriteriaController
 */
@WebServlet("/TenderCriteriaController")
public class TenderCriteriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenderCriteriaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		System.out.print("flag=========" + flag);
		if(flag!=null && flag.equals("search"))
		{
			search(request,response);
		}
		if(flag!=null && flag.equals("searchg"))
		{
			searchg(request,response);
		}

		else
		{
		CategoryDAO catdao=new CategoryDAO();
		CategoryVO catvo=new CategoryVO();
		SubCategoryDAO subcatdao=new SubCategoryDAO();
		SubCategoryVO subcatvo=new SubCategoryVO();
		TenderVO tvo=new TenderVO();
		TenderDAO tdao=new TenderDAO();
		GradeVO gvo=new GradeVO();
		GradeDAO gdao=new GradeDAO();
		
		List ls=new ArrayList();
		List ls1=new ArrayList();
		List ls2=new ArrayList();
		List ls3=new ArrayList();
			
		
		ls=catdao.load(catvo);
		ls1=subcatdao.load(subcatvo);
		ls2=tdao.load(tvo);
		ls3=gdao.load(gvo);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("Cat_list",ls);
		session.setAttribute("SubCat_list",ls1);
		session.setAttribute("tender_list",ls2);
		session.setAttribute("Grade_list",ls3);

		
		
		response.sendRedirect("Admin/Add_TenderCriteria.jsp");
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

		else if(flag!=null && flag.equals("tccheck"))
		{
			tccheck(request,response);
		}
		}
	

	void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String minimumTurnover=request.getParameter("minimumTurnover");
		String individualWE=request.getParameter("individualWE");
		String partnershipWE=request.getParameter("partnershipWE");
		String minimumBankBalance=request.getParameter("minimumBankBalance");
		String description=request.getParameter("Descr");
		String min_amt=request.getParameter("minamount");
		
		
		Long minimum_Turnover=Long.parseLong(minimumTurnover);
		Long individual_WE=Long.parseLong(individualWE);
		Long partnership_WE=Long.parseLong(partnershipWE);
		Long minimum_BankBalance=Long.parseLong(minimumBankBalance);
		Long minamount=Long.parseLong(min_amt);
				
		
		Long tender_ID=Long.parseLong(request.getParameter("idt"));
		Long grade_ID=Long.parseLong(request.getParameter("grade_Id"));
		
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Id(tender_ID);
		
		GradeVO gvo=new GradeVO();
		gvo.setGrade_ID(grade_ID);
		
		
		TenderCriteriaVO tcvo=new TenderCriteriaVO();
		tcvo.setDescription(description);
		tcvo.setMinimumTurnover(minimum_Turnover);
		tcvo.setIndividualWE(individual_WE);
		tcvo.setPartnershipWE(partnership_WE);
		tcvo.setMinimumBankBalance(minimum_BankBalance);
		
		
		tcvo.setTenderVO(tvo);
		tcvo.setGradeVO(gvo);
		
		TenderCriteriaDAO tcdao=new TenderCriteriaDAO();
		tcdao.insert(tcvo);
	
	}
	
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside controller search");
		TenderCriteriaVO tVO = new TenderCriteriaVO();
		
		TenderCriteriaDAO tDAO = new TenderCriteriaDAO();
		List ls=tDAO.search(tVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("search3",ls);
		System.out.println("after session set");
		response.sendRedirect("Company/View_TenderCriteria.jsp");
	
	}

protected void searchg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	TenderCriteriaVO tVO = new TenderCriteriaVO();
	
	TenderCriteriaDAO tDAO = new TenderCriteriaDAO();
	List ls=tDAO.search(tVO);
	
	HttpSession session=request.getSession();
	
	session.setAttribute("search3",ls);
	System.out.println("after session set");
	response.sendRedirect("Government_Employee/View_TenderCriteria.jsp");

}

void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	String s1=request.getParameter("tender_Id");
	System.out.println("id = " + s1);
	
	//String v=request.getParameter("tn");
	//System.out.println(v);
	
	TenderCriteriaVO tcVO = new TenderCriteriaVO();
	TenderCriteriaDAO tcDAO = new TenderCriteriaDAO();
	
	TenderDAO t1dao=new TenderDAO();
	TenderVO t1vo=new TenderVO();
	t1vo.setTender_Id((Long.valueOf(s1)));
	
	List r = t1dao.load1(t1vo);
	System.out.println(r);
	HttpSession d = request.getSession();
	d.setAttribute("tendername", r);
	System.out.println("tender  = " + r.size());
	
	
	tcVO.setTenderVO(t1vo);
	
	if(tcDAO.check(tcVO))
	{
		System.out.println("in if");
		HttpSession session=request.getSession();
			
		GradeVO gvo=new GradeVO();
		GradeDAO gdao= new GradeDAO();
		List ls11=gdao.load(gvo);
		System.out.println(ls11);
		
		session.setAttribute("edit11",ls11);
		System.out.println("edit11 session is set");
				
		response.sendRedirect("Admin/Add_TenderCriteria1.jsp");
	}
	else
	{
		System.out.println("in else");
		
		
		List ls=null;
		ls=tcDAO.edit(tcVO);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("edit",ls);
		
		GradeVO gvo=new GradeVO();
		GradeDAO gdao= new GradeDAO();
		List ls11=gdao.load(gvo);
		session.setAttribute("edit11",ls11);
					
		response.sendRedirect("Admin/Edit_TenderCriteria.jsp");		
	}

	
		
	}

void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{	
	
	System.out.println("inside controller  update");
	
	String id=request.getParameter("idt");
	System.out.println(id);
	
	String idu=request.getParameter("idu");
	String indiwe=request.getParameter("individualWE");
	String partwe=request.getParameter("partnershipWE");
	String minbb=request.getParameter("minimumBankBalance");
	String descr=request.getParameter("Description");
	String minto=request.getParameter("minimumturnover");

	
	
	String gid = request.getParameter("grade_ID");
	
	GradeVO gvo= new GradeVO();
	gvo.setGrade_ID(Long.valueOf(gid));
			
	TenderVO tvo=new TenderVO();
	tvo.setTender_Id(Long.valueOf(idu));
	
	TenderCriteriaVO tcvo=new TenderCriteriaVO();
	tcvo.setDescription(descr);
	tcvo.setGradeVO(gvo);
	tcvo.setIndividualWE(Long.valueOf(indiwe));
	tcvo.setPartnershipWE(Long.valueOf(partwe));
	tcvo.setMinimumBankBalance(Long.valueOf(minbb));
	tcvo.setTenderVO(tvo);
	tcvo.setMinimumTurnover(Long.valueOf(minto));
	tcvo.setTenderCriteriaId(Long.valueOf(id));

	
	TenderCriteriaDAO tcdao=new TenderCriteriaDAO();
	
	tcdao.update(tcvo);
	

	
}

void tccheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	
	Long t_ID=Long.parseLong(request.getParameter("Tender_ID"));
	System.out.println(t_ID + "tender's ID");

	TenderVO tvo=new TenderVO();
	tvo.setTender_Id(t_ID);
	
	TenderDescVO tdvo=new TenderDescVO();
	tdvo.setTenderVO(tvo);
	TenderDescDAO tddao=new TenderDescDAO();
	List ls8=null;
	ls8=tddao.edit(tdvo);
	
	Iterator itr8 =  ls8.iterator();
	
	TenderDescVO z11 = (TenderDescVO)itr8.next();
	
	 Date q8 = z11.getSubmission();
	 System.out.println("date from tenderdesc" + q8);
	
	Date dt = new Date();
	System.out.print(dt.toString() + "it is today's date");
	
	if(dt.compareTo(q8)<0)
	{
		System.out.println("Date1 is after Date2");
	
		TenderDAO t1dao=new TenderDAO();
	
		TenderCriteriaVO tcvo=new TenderCriteriaVO();
		TenderCriteriaDAO tcdao=new TenderCriteriaDAO();
	
		ApplyTenderVO atvo=new ApplyTenderVO();
		atvo.setTenderVO(tvo);
		ApplyTenderDAO atdao=new ApplyTenderDAO();
		
		List ls33=null;
		ls33=atdao.checkk(atvo);
		if((ls33.size()) >=1)
		{
			response.sendRedirect("Company/Apply_for_Tender4.jsp");
		}
		else 
		{
			List vvv = t1dao.load1(tvo);
			System.out.println(vvv);
			HttpSession d = request.getSession();
			d.setAttribute("tendername", vvv);
			System.out.println("tender  = " + vvv.size());
			
			tcvo.setTenderVO(tvo);
	
			List ls=null;
			ls=tcdao.edit(tcvo);
			
			if((ls.size()) >=1)

			{	
				Iterator itr =  ls.iterator();
				
				TenderCriteriaVO z = (TenderCriteriaVO)itr.next();
				
				Long q = z.getGradeVO().getGrade_ID();
				Long w=z.getMinimumTurnover();
				Long e=z.getIndividualWE();
				Long r=z.getPartnershipWE();
				Long y=z.getMinimumBankBalance();
				
				System.out.println(q + "grade");
				System.out.println(w + "turnovr");
				System.out.println(e + "indiWE");
				System.out.println(r + "partnershipWE");
				System.out.println(y + "minBB");
				
			
				HttpSession session=request.getSession();
				Long www=(Long)session.getAttribute("userID");
					
				UserVO uvo=new UserVO();
				uvo.setUser_ID(www);
			
				CompanyVO cmpnyvo=new CompanyVO();
				cmpnyvo.setUserVO(uvo);
				
				CompanyDAO cmpnydao=new CompanyDAO();
				
				List ls1=null;
				ls1=cmpnydao.edit(cmpnyvo);
				
				Iterator itr1 =  ls1.iterator();
				
				CompanyVO a = (CompanyVO)itr1.next();
				
				Long x = a.getGradeVO().getGrade_ID();
				Long c=a.getTurnover();
				Long v=a.getWorkExpind();
				Long b=a.getWorkExpjoin();
				Long n=a.getMinBalance();
				
				System.out.println(x + "grade1");
				System.out.println(c + "turnovr1");
				System.out.println(v + "indiWE1");
				System.out.println(b + "partnershipWE1");
				System.out.println(n + "minBB1");
			
				if(q.equals(x) && w<=c && e<=v && r<=b && y<=n)
				{
					response.sendRedirect("Company/Apply_for_Tender1.jsp");
				}
				else
				{
					response.sendRedirect("Company/Apply_for_Tender2.jsp");
				}
	
			}
			else
			{
				response.sendRedirect("Company/Apply_for_Tender3.jsp");
			}
	
		}	
	}
	else
	{
		response.sendRedirect("Company/Apply_for_Tender5.jsp");
	}
}

}


