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

import DAO.GBaseCourseDAO;
import DAO.GBituminousDAO;
import DAO.GSubBaseDAO;
import DAO.GSubGradeDAO;
import DAO.TenderDAO;
import VO.GBaseCourseVO;
import VO.GBituminousVO;
import VO.GSubBaseVO;
import VO.GSubGradeVO;
import VO.TenderVO;

/**
 * Servlet implementation class AuditReportController
 */
@WebServlet("/AuditReportController")
public class AuditReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuditReportController() {
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
		if(flag!=null && flag.equals("tenderload"))
		{
			tenderload(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		System.out.println("flag = " + flag);
		
		if(flag!=null && flag.equals("sginsert"))
		{
			sginsert(request,response);
		}
	else if(flag!=null && flag.equals("sbcinsert"))
		{
			sbcinsert(request,response);
		}
	else if(flag!=null && flag.equals("bwinsert"))
	{
		bwinsert(request,response);
	}
	else if(flag!=null && flag.equals("bcinsert"))
	{
		bcinsert(request,response);
	}
	else if(flag!=null && flag.equals("pn"))
	{
		dd(request,response);
	}
	else if(flag!=null && flag.equals("work"))
	{
		work(request,response);
	}

	
	}
	void dd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String pname = request.getParameter("tender_Id");
		System.out.println(pname + "=pname");
		
		
		HttpSession session=request.getSession();
		session.setAttribute("projname",pname);
		response.sendRedirect("Government_Employee/Post_AuditReport1.jsp");
	}

	void sginsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		System.out.println("inside sub grade insert");
		
		
		
		String sampling = request.getParameter("sampling");
		String sampling1 = request.getParameter("sampling2");
		String lt = request.getParameter("lt");
		String lt1 = request.getParameter("lt2");
		String ft = request.getParameter("ft");
		String ft1 = request.getParameter("ft2");
		
		String inote = request.getParameter("inote");
		String remark = request.getParameter("remark");
		
		Long tid = Long.valueOf(request.getParameter("idt"));
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Id(tid);
		
		GSubGradeVO svo = new GSubGradeVO();
		GSubGradeDAO sdao = new GSubGradeDAO();
		
		svo.setSc(sampling1);
		svo.setSf(sampling);
		svo.setLtf(lt);
		svo.setLtc(lt1);
		svo.setFtc(ft1);
		svo.setFtf(ft);
		svo.setInote(inote);
		svo.setRemark(remark);
		svo.setTvo(tvo);
		sdao.insert(svo);

}


	void bcinsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		System.out.println("inside  base course insert");
		
		
		
		String sampling = request.getParameter("sampling");
		String sampling1 = request.getParameter("sampling2");
		String lt = request.getParameter("lt");
		String lt1 = request.getParameter("lt2");
		String ft = request.getParameter("ft");
		String ft1 = request.getParameter("ft2");
		String inote = request.getParameter("inote");
		String remark = request.getParameter("remark");
		Long tid = Long.valueOf(request.getParameter("idt"));
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Id(tid);
		
		
		GBaseCourseVO svo = new GBaseCourseVO();
		GBaseCourseDAO sdao = new GBaseCourseDAO();
		
		svo.setS2(sampling1);
		svo.setS1(sampling);
		svo.setLt1(lt);
		svo.setLt2(lt1);
		svo.setFt2(ft1);
		svo.setFt1(ft);
		svo.setInote(inote);
		svo.setRemark(remark);
		svo.setTvo(tvo);
		
		sdao.insert(svo);

}

	void sbcinsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		System.out.println("inside sub base insert");
		
		
		
		String sampling = request.getParameter("sampling");
		String sampling1 = request.getParameter("sampling2");
		String lt = request.getParameter("lt");
		String lt1 = request.getParameter("lt2");
		String ft = request.getParameter("ft");
		String ft1 = request.getParameter("ft2");
		
		String inote = request.getParameter("inote");
		String remark = request.getParameter("remark");
		
		Long tid = Long.valueOf(request.getParameter("idt"));
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Id(tid);
		
		
		GSubBaseVO svo = new GSubBaseVO();
		GSubBaseDAO sdao = new GSubBaseDAO();
		
		svo.setS2(sampling1);
		svo.setS1(sampling);
		svo.setLt1(lt);
		svo.setLt2(lt1);
		svo.setFt2(ft1);
		svo.setFt1(ft);
		svo.setInote(inote);
		svo.setRemark(remark);
		svo.setTvo(tvo);
		sdao.insert(svo);

}

	
	void bwinsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		System.out.println("inside bitu work insert");
		
		
		
		String sdbc = request.getParameter("sdbc");
		String bm = request.getParameter("bm");
		String bc = request.getParameter("bc");
		String dbm = request.getParameter("dbm");
		String bt = request.getParameter("bt");
		String inote = request.getParameter("inote");
		String remark = request.getParameter("remark");
		
		
		Long tid = Long.valueOf(request.getParameter("idt"));
		
		TenderVO tvo=new TenderVO();
		tvo.setTender_Id(tid);
		
		GBituminousVO svo = new GBituminousVO();
		GBituminousDAO sdao = new GBituminousDAO();
		
		svo.setBc(bc);
		svo.setBm(bm);
		svo.setBt(bt);
		svo.setDbm(dbm);
		svo.setSdbc(sdbc);
		svo.setInote(inote);
		svo.setRemark(remark);
		svo.setTvo(tvo);
		sdao.insert(svo);

}
	void tenderload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		TenderVO tvo=new TenderVO();
		TenderDAO tdao=new TenderDAO();
		List ls=new ArrayList();
		System.out.println("before tender load");
		ls=tdao.load(tvo);
		
		System.out.println("session set for tender");
		HttpSession session=request.getSession();
		session.setAttribute("tender_list",ls);
		response.sendRedirect("Government_Employee/Post_AuditReport.jsp");
		
	}
	
	
	void work(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*String tid = request.getParameter("idt");
		System.out.println("tender id is = " + tid);*/
		String selectwork = request.getParameter("select");
		System.out.println("work is=" + selectwork);
		
/*		HttpSession session=request.getSession();
		session.setAttribute("tenderid",tid);*/
		
		if(selectwork.equals("1"))
			{response.sendRedirect("Government_Employee/SubGrade.jsp");}
		else if(selectwork.equals("2"))
			{response.sendRedirect("Government_Employee/SubBase_Course.jsp");}
		else if(selectwork.equals("3"))
			{response.sendRedirect("Government_Employee/Base_Course.jsp");}
		else if(selectwork.equals("4"))
			{response.sendRedirect("Government_Employee/Bituminous_Work.jsp");}
	}


	}


