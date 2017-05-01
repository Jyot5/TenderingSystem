package Authentication;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import DAO.ApplyTenderDAO;
import DAO.CompanyProjectDAO;
import DAO.TenderDescDAO;
import DAO.UserDAO;
import VO.ApplyTenderVO;
import VO.CompanyProjectVO;
import VO.TenderCriteriaVO;
import VO.TenderDescVO;
import VO.TenderVO;
import VO.UserVO;

/**
 * Servlet Filter implementation class f1
 */
@WebFilter("/*")
public class Auth implements Filter {

    /**
     * Default constructor. 
     */
    public Auth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		
		System.out.println("Authentication Filter Verification Begins");
		HttpSession session =((HttpServletRequest) request).getSession();
		
/*Check whether the User has Requested to Submit User Name and Password*/
		
		
String uri = ((HttpServletRequest)request).getRequestURI();
		
System.out.println("uriiiiiiiiiii" +uri);


		if(uri.contains("font")||uri.contains("css") || uri.contains("js")&&uri.contains("dashboard.jsp")||uri.contains("View_Complaint.jsp")||uri.contains("User_Registration.jsp")||uri.contains("View_Feedback.jsp")||uri.contains("View_Tender.jsp")||uri.contains("Company_Reg.jsp")||uri.contains("UserController")||uri.contains("FeedbackController")||uri.contains("ComplaintController")||uri.contains("AreaController")||uri.contains("CityController")||uri.contains("StreetController")||uri.contains("TenderController")||uri.contains("CategoryController")||uri.contains("SubCategoryController")||uri.contains("GradeController")|| uri.contains("images"))
		{
			System.out.println("if block................................");
			chain.doFilter(request, response);
			
		}
		
		else if(request.getParameter("login") !=null && request.getParameter("login").equals("true") ){
			
			System.out.println("insiddddddddddddddd loggggggggg");
			
						String userName = request.getParameter("uname");
						String password = request.getParameter("password");
						
						System.out.println("user name"+userName);
						System.out.println("password"+password);
						
						
						UserVO userVO = new UserVO();
						userVO.setFirst_Name(userName);
						userVO.setUser_Password(password);
						
						UserDAO userDAO = new UserDAO();
						List ls= userDAO.login(userVO);
						
						Date date = new Date();
						String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
						//System.out.print(dt.toString() + "it is today's date");
						System.out.println("today's date issss" + modifiedDate);
						
						TenderDescVO tdescvo=new TenderDescVO();
						TenderDescDAO tdescdao=new TenderDescDAO();
						List lsd=null;
						lsd=tdescdao.bringdate(tdescvo);
						
						for (Iterator iteratorw = lsd.iterator(); iteratorw.hasNext();) {
							Object[] objectf = (Object[]) iteratorw.next();
							
							System.out.println("jjjppp"+objectf[0]);
							System.out.println("jjjppp"+objectf[1]);
							
													
							Date date1=(Date)objectf[0];
							
							String date33= new SimpleDateFormat("yyyy-MM-dd").format(date1);
							
							System.out.println(date33 + "it is dateeee");
							
							
							
							TenderVO e11 = (TenderVO)objectf[1];
							Long e22 = e11.getTender_Id();
							System.out.println("here tidd===" + e22);
							
							int yy=modifiedDate.compareTo(date33);
							System.out.println(yy + "yyyyy");
							if (yy==0)
							{	
								System.out.println("compared with 0");
								ApplyTenderVO atvo=new ApplyTenderVO();
								ApplyTenderDAO atdao=new ApplyTenderDAO();
								
								atvo.setTenderVO(e11);
								
								List findlist=null;
								findlist=atdao.find(atvo);
								
								System.out.println("finish!!!");
								
								CompanyProjectVO cpvo=new CompanyProjectVO();
								CompanyProjectDAO cpdao=new CompanyProjectDAO();
								
								
								
									for (Iterator iterator = findlist.iterator(); iterator.hasNext();) {
										Object[] object = (Object[]) iterator.next();
										
										System.out.println("kkkkkkkkkkkkkkkkk"+object[0]);
										System.out.println("kkkkkkkkkkkkkkkkk"+object[1]);
										System.out.println("kkkkkkkkkkkkkkkkk"+object[2]);
										
										Long k0 = (Long)object[0];
										System.out.println(k0 + "it is obj0");
										
										
										
										/*TenderVO tvo=new TenderVO();
										tvo.setTender_Id(k12);
										*/
										UserVO k22 = (UserVO)object[1];
										System.out.println(k22 + "it is obj2");
										Long k23 = k22.getUser_ID();
										System.out.println(k23 + "hey");
										
										TenderVO k11 = (TenderVO)object[2];
										System.out.println(k11 + "it is obj1");
										Long k12 = k11.getTender_Id();
										System.out.println(k12 + "hey");
										
										cpvo.setT_amount(k0);
										cpvo.setTenderVO(k11);
										cpvo.setUserVO(k22);
										
										List lsx = null;
										lsx=cpdao.check(cpvo);
										
										if(lsx.size() == 0 )
										{
											cpdao.insert(cpvo);
										}
							}}
							else
							{
								System.out.println("DAte else------");
							}
						}
						RequestDispatcher rd=null;
						
/*Check for Authentic User*/ 
						
						if(ls != null && ls.size()>=1){
							
														Iterator itr = ls.iterator();
														UserVO user=(UserVO) itr.next();
														
														session.setAttribute("userID", user.getUser_ID());
														
														System.out.println("type  = " + user.getUser_Type());
														
														if(user.getUser_Type().equals("admin")){
														rd=request.getRequestDispatcher("/Admin/Dashboard.jsp");
														}
														else if(user.getUser_Type().equals("company")){
															rd=request.getRequestDispatcher("/Company/Dashboard.jsp");
															}
														//rd.forward(request,response);  
														
														else if(user.getUser_Type().equals("user1")){
															rd=request.getRequestDispatcher("/User/dashboard.jsp");
															}
															
														
														else if(user.getUser_Type().equals("govt")){
														rd=request.getRequestDispatcher("/Government_Employee/Dashboard.jsp");
														}
														rd.forward(request,response);  
						
	
														}else{
															
															rd=request.getRequestDispatcher("/login.jsp");  
															rd.forward(request,response);  
														}
													}
													else if(session.getAttribute("userID")!=null){
			
														System.out.println(session.getAttribute("userID"));
														chain.doFilter(request, response);
			
														}else{
							
															RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
															rd.forward(request,response);  
				
			   }

		System.out.println("Authentication Filter Verification Ends");

		}
		

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
