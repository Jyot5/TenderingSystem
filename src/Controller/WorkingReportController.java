package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CSubGradeDAO;
import VO.CSubGradeVO;
import DAO.CBaseCourseDAO;
import VO.CBaseCourseVO;
import DAO.CBituminousDAO;
import DAO.CSubBaseDAO;
import VO.CSubBaseVO;
import VO.CBituminousVO;
/**
 * Servlet implementation class AuditReportController
 */
@WebServlet("/WorkingReportController")
public class WorkingReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkingReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		
		
		
		CSubGradeVO svo = new CSubGradeVO();
		CSubGradeDAO sdao = new CSubGradeDAO();
		
		svo.setSc(sampling1);
		svo.setSf(sampling);
		svo.setLtf(lt);
		svo.setLtc(lt1);
		svo.setFtc(ft1);
		svo.setFtf(ft);
		
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
		
		
		
		
		CBaseCourseVO svo = new CBaseCourseVO();
		CBaseCourseDAO sdao = new CBaseCourseDAO();
		
		svo.setS2(sampling1);
		svo.setS1(sampling);
		svo.setLt1(lt);
		svo.setLt2(lt1);
		svo.setFt2(ft1);
		svo.setFt1(ft);
		
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
		
		
		
		
		CSubBaseVO svo = new CSubBaseVO();
		CSubBaseDAO sdao = new CSubBaseDAO();
		
		svo.setS2(sampling1);
		svo.setS1(sampling);
		svo.setLt1(lt);
		svo.setLt2(lt1);
		svo.setFt2(ft1);
		svo.setFt1(ft);
		
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
		
		
		
		
		
		CBituminousVO svo = new CBituminousVO();
		CBituminousDAO sdao = new CBituminousDAO();
		
		svo.setBc(bc);
		svo.setBm(bm);
		svo.setBt(bt);
		svo.setDbm(dbm);
		svo.setSdbc(sdbc);
		
		
		sdao.insert(svo);

}

	
}
