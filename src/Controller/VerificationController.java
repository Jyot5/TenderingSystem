package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.util.Date;
import java.util.Iterator;
import java.util.List;


import VO.LinkVO;
import VO.UserVO;

import DAO.LinkDAO;
import DAO.UserDAO;


/**
 * Servlet implementation class VerificationController
 */
@WebServlet("/VerificationController")
public class VerificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode="activation";
		if(request.getParameter("proc")!=null)
			   mode = request.getParameter("proc");
			else
				mode="activation";
			
			
			if(mode.equals("activation")){
				activation(request, response);
			}
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
protected void activation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String link = request.getParameter("authentication");
		List entry=null;
		HttpSession session = request.getSession();
		boolean test = true;
		UserVO userVO = null;
		UserDAO userDAO = new UserDAO();
		LinkVO linkVO = new LinkVO();
			
		
		linkVO.setLink(link);
		
		LinkDAO linkDAO = new LinkDAO();
		entry = linkDAO.getElementByLink(linkVO);
		
		if(entry != null ){
			
			Iterator it = entry.iterator();
			while(it.hasNext()){
				linkVO = (LinkVO) it.next();
				
				boolean flag = true;
				long temp =new Date().getTime();
				
				System.out.println("time arrv "+temp);
				System.out.println("time dispatch "+linkVO.getDispatchDT());
				
				if( new Date().getTime()-linkVO.getDispatchDT()  <= 1000*60*60 ){
				//if(flag == true){
					
				
									if(linkVO.getStatus()==0){
									
										linkVO.setActivationDT(new Date().getTime());
										linkVO.setStatus(1);
										userVO.setUser_Status("active");
										linkDAO.update(linkVO);
										
										
										
										session.setAttribute("msg", "Account Activated");
										
									}else{
										
										session.setAttribute("msg", "Account Already Activated");
									}
									
						}else{
							
							session.setAttribute("msg", "Activation Link has Expired");
							
						}
				
				
				}
	
		}else{
			session.setAttribute("msg", "Invalid Activation Code");
		}
	
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	

	
}
