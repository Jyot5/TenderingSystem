package Controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Iterator;


import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.GovtEmpDAO;
import DAO.UserDAO;
import VO.CategoryVO;
import VO.GovtEmpVO;
import VO.GradeVO;
import VO.LinkVO;
import VO.UserVO;
import VO.CityVO;
import VO.AreaVO;
import VO.StreetVO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.AreaDAO;
import DAO.GradeDAO;
import DAO.LinkDAO;
import DAO.StreetDAO;
import VO.ImgMappingVO;
import DAO.ImgMappingDAO;
import VO.User1VO;
import DAO.User1DAO;
import VO.CompanyVO;
import DAO.CompanyDAO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
		else if(flag!=null && flag.equals("insert"))
		{
			insert(request,response);
		}
		else if(flag!=null && flag.equals("insert2"))
		{
			insert2(request,response);
		}
		
		else if(flag!=null && flag.equals("load"))
		{
			load(request,response);
		}
		else if(flag!=null && flag.equals("load1"))
		{
			load1(request,response);
		}
		else if(flag!=null && flag.equals("loadc"))
		{
			loadc(request,response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		System.out.println("flag = " + flag);
		if(flag!=null && flag.equals("search"))
		{
			search(request,response);
		}
		else if(flag!=null && flag.equals("insert"))
		{
			insert(request,response);
		}
		else if(flag!=null && flag.equals("insert2"))
		{
			insert2(request,response);
		}
		else if(flag!=null && flag.equals("insertc"))
		{
			insertc(request,response);
		}

		else if(flag!=null && flag.equals("load"))
		{
			load(request,response);
		}
		else if(flag!=null && flag.equals("load1"))
		{
			load1(request,response);
		}
		else if(flag!=null && flag.equals("update"))
		{
			update(request,response);
		}
	}
	
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserVO gVO = new UserVO();
		
		UserDAO gDAO = new UserDAO();
		List ls=gDAO.search(gVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("search1",ls);
		response.sendRedirect("Admin/Manage_Users.jsp");
	
	}


void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	String  uname= request.getParameter("uname");
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String email = request.getParameter("email");
	String  pwd = request.getParameter("pwd");
	String education = request.getParameter("education");
	String designation = request.getParameter("designation");
	String dept = request.getParameter("dept");
	String type = request.getParameter("utype");
	String status = request.getParameter("status");
	String aname = request.getParameter("aname");
	Long cid = Long.valueOf(request.getParameter("City_ID"));
	Long aid = Long.valueOf(request.getParameter("Area_ID"));
	Long sid = Long.valueOf(request.getParameter("Street_ID"));
	String r = request.getParameter("radio");
	String num1 = request.getParameter("connum");
	
	
	System.out.println(num1+"vadsajnedfkjanhqehjr");
	System.out.println(aname+"vadsajnedfkjanhqehjr");
	
	GovtEmpVO gvo= new GovtEmpVO();
	
	if("F".equals(r))
	{
		gvo.setGender(r);
	}
	else
	{
		gvo.setGender(r);
	}
	
	
	
	
	
	try{
		SimpleDateFormat obj=new SimpleDateFormat("yyyy/mm/dd");
		Date d=obj.parse(request.getParameter("bday"));
		gvo.setBday(d);
		
	}
	catch(Exception e)
	{}
	
	

	UserVO uVO = new UserVO();
	uVO.setFirst_Name(fname);
	uVO.setLast_Name(lname);
	uVO.setUser_Password(pwd);
	uVO.setUser_Type(type);
	uVO.setUser_Status(status);
	
	UserDAO uDAO = new UserDAO();
	uDAO.insert(uVO);
	
	AreaVO avo = new AreaVO();
	avo.setArea_ID(aid);
	CityVO cvo = new CityVO();
	cvo.setCity_ID(cid);
	StreetVO svo = new StreetVO();
	svo.setStreet_ID(sid);
	
	
	gvo.setDepartment(dept);
	gvo.setDesignation(designation);
	gvo.setEducation(education);
	gvo.setLast_Name(lname);
	gvo.setUname(uname);
	gvo.setFirst_Name(fname);
	gvo.setEmail(email);
	gvo.setNum1(num1);
	gvo.setAname(aname);
	gvo.setUservo(uVO);
	
	gvo.setAreavo(avo);
	gvo.setStreetvo(svo);
	gvo.setCityvo(cvo);
	
	
	
	GovtEmpDAO gDAO = new GovtEmpDAO();
	gDAO.insert(gvo); 
	
	
	HttpSession session =request.getSession();
	List myList=(List)session.getAttribute("fileList");
	
	 Iterator itr =  myList.iterator();
     
     System.out.println("Reading for session");
     int i =0;
     while (itr.hasNext()) {
    	ImgMappingVO eamv=new ImgMappingVO();
    	ImgMappingDAO eamd=new ImgMappingDAO();
 		//mpgvo.setMpg_id(imgvo);
    	
 		eamv.setGvo(gvo);
    	 eamv.setMpg_Name("Photo"+i);
    	 eamv.setPath((String)itr.next());
    	 eamd.insert(eamv);
    	 
    	 i++;
		}
	
     sendActivationLink(email,uVO,gvo,request,response);

}

protected void sendActivationLink(String s,UserVO uvo,GovtEmpVO gevo,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	String link = generateHashCode(gevo);
	Date dispatchDT = new Date();

		
	System.out.println(dispatchDT.toString());
	/*Setting the parameter for link table from confirming the user's identity*/
	
	LinkVO linkVO = new LinkVO();
	linkVO.setLink(link);
	linkVO.setDispatchDT(dispatchDT.getTime());
	linkVO.setStatus(0);
	linkVO.setGevo(gevo);
	
	
	LinkDAO linkDAO = new LinkDAO();
	linkDAO.insert(linkVO);
	
	String activationLink = "http://localhost:8080/RT/VerificationController?authentication="+linkVO.getLink()+"&proc=activation"; 

	
	/*Setting the parameter for link table from confirming the user's identity*/
	
	
	 
	//PatientVO pv=new PatientVO();
	
	//pv.setUserid(VO_obj);
	String s1 = gevo.getFirst_Name();
	String s2 = uvo.getUser_Password();
	System.out.println("GovtEmp id:"+gevo.getG_id());
	System.out.println("Recievers email id:"+s);
	System.out.println("name" +s1);
	sendMail(s,s1,s2,activationLink,"Account Activation");
	

	
}

protected String generateHashCode(GovtEmpVO gevo){
	
	String myKey=gevo.getUname()+gevo.getG_id();
	
	byte[] unencodedPassword = myKey.getBytes();
	MessageDigest md = null;
	try {
	md = MessageDigest.getInstance("MD5");
	} catch (Exception e) {}
	md.reset();
	md.update(unencodedPassword);
	byte[] encodedPassword = md.digest();
	StringBuffer buf = new StringBuffer();
	for (int i = 0; i < encodedPassword.length; i++) {
	if (((int) encodedPassword[i] & 0xff) < 0x10) {
	buf.append("0");
	}
	buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
	}
	String hashCode=buf.toString(); 
	
	
	return hashCode;
	
	
}



protected void sendMail(String email,String uname,String pwd,String activationLink,String msg){
	
	java.util.Properties properties = new java.util.Properties();
    properties.put("mail.smtp.auth", "true");
     properties.put("mail.smtp.starttls.enable", "true");
     javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

    System.out.println("Inside send mail");
    System.out.println("uname====="+uname);
    System.out.println("password====="+pwd);
     try {
        MimeMessage message = new MimeMessage(mailSession);

       
        message.setContent("<h1>Below is your "+msg+" Code</h1>"+
        		 "<a href='"+activationLink+"'> Click here to "+msg+" your account </a> "+
        		"<h5>your id is "+uname+" and password is "+pwd+" </h5>"
        		+""
        		+ "","text/html" );
        message.setSubject("Confirmation Message");
        
        InternetAddress sender = new InternetAddress("sweetyraval18@gmail.com", "Administrator");
         InternetAddress receiver = new InternetAddress(email);
        message.setFrom(sender);
        message.setRecipient(Message.RecipientType.TO, receiver);
         message.saveChanges();
        
        javax.mail.Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", 587, "sweetyraval18@gmail.com", "ilovemyself9");
         transport.sendMessage(message, message.getAllRecipients());
        transport.close();
                  
    } catch (Exception e) {
        System.out.println("err = " + e);
     }
	
	
	
}



protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("inside load method in usercontroller");
	
	CityVO cvo = new CityVO();
	CityDAO cdao = new CityDAO();
	List ls=cdao.load(cvo);
	HttpSession session=request.getSession();
	session.setAttribute("city",ls);
	
	AreaVO avo = new AreaVO();
	AreaDAO adao = new AreaDAO();
	List ls1=adao.load(avo);
	HttpSession session1=request.getSession();
	session.setAttribute("area",ls1);

	StreetVO svo = new StreetVO();
	StreetDAO sdao = new StreetDAO();
	List ls2=sdao.load(svo);
	HttpSession session2=request.getSession();
	session.setAttribute("street",ls2);
	
	response.sendRedirect("Admin/User_profile.jsp");
	
}

protected void load1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("inside load method in usercontroller");
	
	CityVO cvo = new CityVO();
	CityDAO cdao = new CityDAO();
	List ls=cdao.load(cvo);
	HttpSession session=request.getSession();
	session.setAttribute("city",ls);
	
	AreaVO avo = new AreaVO();
	AreaDAO adao = new AreaDAO();
	List ls1=adao.load(avo);
	HttpSession session1=request.getSession();
	session.setAttribute("area",ls1);

	StreetVO svo = new StreetVO();
	StreetDAO sdao = new StreetDAO();
	List ls2=sdao.load(svo);
	HttpSession session2=request.getSession();
	session.setAttribute("street",ls2);
	
	response.sendRedirect("User/User_Registration.jsp");
	
}
protected void loadc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

System.out.println("inside load method in usercontroller");
	
	CityVO cvo = new CityVO();
	CityDAO cdao = new CityDAO();
	List ls=cdao.load(cvo);
	HttpSession session=request.getSession();
	session.setAttribute("city",ls);
	
	AreaVO avo = new AreaVO();
	AreaDAO adao = new AreaDAO();
	List ls1=adao.load(avo);
	HttpSession session1=request.getSession();
	session.setAttribute("area",ls1);

	StreetVO svo = new StreetVO();
	StreetDAO sdao = new StreetDAO();
	List ls2=sdao.load(svo);
	HttpSession session2=request.getSession();
	session.setAttribute("street",ls2);
	
	GradeVO gvo=new GradeVO();
	GradeDAO gdao= new GradeDAO();
	List ls11=gdao.load(gvo);
	session.setAttribute("edit11",ls11);
	
	response.sendRedirect("User/Company_Reg.jsp");

}

void insert2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	String  uname= request.getParameter("uname");
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String email = request.getParameter("email");
	String  pwd = request.getParameter("pwd");
	//String education = request.getParameter("education");
	//String designation = request.getParameter("designation");
	String PAN = request.getParameter("pan");
	String type = request.getParameter("utype");
	String status = request.getParameter("status");
	String aname = request.getParameter("aname");
	Long cid = Long.valueOf(request.getParameter("City_ID"));
	Long aid = Long.valueOf(request.getParameter("Area_ID"));
	Long sid = Long.valueOf(request.getParameter("Street_ID"));
	String r = request.getParameter("radio");
	String num = request.getParameter("connum");
	String bday1=request.getParameter("bday");
	System.out.println(bday1 + "=birthdate");
	
	System.out.println(num+ "=number");
	System.out.println(aname+ "=apt name");
	
	
	User1VO u1vo=new User1VO();
	
	if("F".equals(r))
	{
		u1vo.setGender(r);
	}
	else
	{
		u1vo.setGender(r);
	}
	
		
	try{
		SimpleDateFormat obj1=new SimpleDateFormat("yyyy/mm/dd");
		Date d1=obj1.parse(bday1);
		u1vo.setBday(d1);
		
	}
	catch(Exception e)
	{}
	
	

	UserVO uVO = new UserVO();
	uVO.setFirst_Name(fname);
	uVO.setLast_Name(lname);
	uVO.setUser_Password(pwd);
	uVO.setUser_Type(type);
	uVO.setUser_Status(status);
	
	UserDAO uDAO = new UserDAO();
	uDAO.insert(uVO);
	
	AreaVO avo = new AreaVO();
	avo.setArea_ID(aid);
	CityVO cvo = new CityVO();
	cvo.setCity_ID(cid);
	StreetVO svo = new StreetVO();
	svo.setStreet_ID(sid);
	
	u1vo.setAreavo(avo);
	u1vo.setCityvo(cvo);
	u1vo.setStreetvo(svo);
	
	u1vo.setPan(PAN);
	u1vo.setLast_Name(lname);
	u1vo.setUname(uname);
	u1vo.setFirst_Name(fname);
	u1vo.setEmail(email);
	u1vo.setNum1(num);
	u1vo.setAname(aname);
	u1vo.setUservo(uVO);
	
	
	User1DAO u1dao=new User1DAO();
	
	u1dao.insert(u1vo);
 
	
	
	

}

void insertc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	System.out.println("inside xontroller insert");
	String  cname= request.getParameter("uname");
	String  fax= request.getParameter("fax");
	String lname = request.getParameter("lname");
	String email = request.getParameter("email");
	String  pwd = request.getParameter("pwd");
	//String education = request.getParameter("education");
	//String designation = request.getParameter("designation");
	
	String type = request.getParameter("utype");
	String status = request.getParameter("status");
	String complex = request.getParameter("aname");
	Long cid = Long.valueOf(request.getParameter("City_ID"));
	Long aid = Long.valueOf(request.getParameter("Area_ID"));
	Long sid = Long.valueOf(request.getParameter("Street_ID"));
	Long gid = Long.valueOf(request.getParameter("grade_Id"));
	
	
	Long weind = Long.valueOf(request.getParameter("weind"));
	Long wejoin = Long.valueOf(request.getParameter("wejoin"));
	Long hvp = Long.valueOf(request.getParameter("hvp"));
	Long ato = Long.valueOf(request.getParameter("ato"));
	
	String num = request.getParameter("connum");
	
	
	UserVO uVO = new UserVO();
	uVO.setFirst_Name(cname);
	
	uVO.setUser_Password(pwd);
	uVO.setUser_Type(type);
	uVO.setUser_Status(status);
	
	UserDAO uDAO = new UserDAO();
	uDAO.insert(uVO);
	
	AreaVO avo = new AreaVO();
	avo.setArea_ID(aid);
	CityVO cvo = new CityVO();
	cvo.setCity_ID(cid);
	StreetVO svo = new StreetVO();
	svo.setStreet_ID(sid);
	GradeVO gvo = new GradeVO();
	gvo.setGrade_ID(gid);
	
	CompanyVO cmvo = new  CompanyVO();
	cmvo.setName(cname);
	cmvo.setAreaVO(avo);
	cmvo.setCityVO(cvo);
	cmvo.setComplex(complex);
	cmvo.setContactNo(num);
	cmvo.setEmailId(email);
	cmvo.setFAX(fax);
	cmvo.setGradeVO(gvo);
	cmvo.setHighestValueProj(hvp);
	cmvo.setStreetVO(svo);
	cmvo.setWorkExpind(weind);
	cmvo.setTurnover(ato);
	cmvo.setWorkExpjoin(wejoin);
	cmvo.setUserVO(uVO);
	
	CompanyDAO cmdao = new CompanyDAO();
	cmdao.insert(cmvo);
	
	

}


protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("inside user edit");
	List ls=null;
	Long id=Long.valueOf(request.getParameter("id"));
	
	
	GovtEmpVO geVO = new GovtEmpVO();
	GovtEmpDAO geDAO = new GovtEmpDAO();
	
	UserVO uvo = new UserVO();
	uvo.setUser_ID(id);
	
	geVO.setUservo(uvo);
	 ls = geDAO.edit(geVO);
	 HttpSession session=request.getSession();
		session.setAttribute("edit",ls);
		
	 CityVO cvo = new CityVO();
	 CityDAO cdao = new CityDAO();
	 List lsc = cdao.load(cvo);
	 session.setAttribute("editc",lsc);
	 
	 AreaVO avo = new AreaVO();
	 AreaDAO adao = new AreaDAO();
	 List lsa = adao.load(avo);
	 session.setAttribute("edita",lsa);
	 
	 StreetVO svo = new StreetVO();
	 StreetDAO sdao = new StreetDAO();
	 List lss = sdao.load(svo);
	 session.setAttribute("edits",lss);
	 
	
	
   	response.sendRedirect("Government_Employee/User_profile.jsp");

}


void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	
	System.out.println("inside controller update");
	
	
	HttpSession session= request.getSession();
			Long d = (Long)session.getAttribute("userID");
	
	//String s = request.getParameter("id");
	//Long id = Long.valueOf(s);
	//System.out.println("user is+++" +id);
	
	//Long id=Long.parseLong(request.getParameter("id"));
	System.out.println("user id+++++++" +d);
	String  uname= request.getParameter("uname");
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String email = request.getParameter("email");
	String connum = request.getParameter("connum");
	String edu = request.getParameter("education");
	String desig = request.getParameter("designation");
	String dept = request.getParameter("dept");
	String aname = request.getParameter("aname");
	Long cid = Long.valueOf(request.getParameter("City_ID"));
	Long aid = Long.valueOf(request.getParameter("Area_ID"));
	Long sid = Long.valueOf(request.getParameter("Street_ID"));
	String status = request.getParameter("status");
	String type = request.getParameter("utype");
	String pwd = request.getParameter("pwd");
	
	GovtEmpVO gevo = new GovtEmpVO();
	GovtEmpDAO gedao = new GovtEmpDAO();
	
	try{
		SimpleDateFormat obj=new SimpleDateFormat("yyyy/mm/dd");
		Date d1=obj.parse(request.getParameter("bday"));
		gevo.setBday(d1);
		
	}
	catch(Exception e)
	{}
	
	AreaVO avo = new AreaVO();
	avo.setArea_ID(aid);
	CityVO cvo = new CityVO();
	cvo.setCity_ID(cid);
	StreetVO svo = new StreetVO();
	svo.setStreet_ID(sid);
	UserVO uservo = new UserVO();
	uservo.setUser_ID(d);
	
	uservo.setFirst_Name(fname);
	uservo.setLast_Name(lname);
	uservo.setUser_Status(status);
	uservo.setUser_Type(type);
	uservo.setUser_Password(pwd);
	
	UserDAO udao = new UserDAO();
	udao.update(uservo);
	
	gevo.setAname(aname);
	gevo.setAreavo(avo);
	gevo.setCityvo(cvo);
	gevo.setDepartment(dept);
	gevo.setDesignation(desig);
	gevo.setEducation(edu);
	gevo.setEmail(email);
	gevo.setFirst_Name(fname);
	gevo.setLast_Name(lname);
	gevo.setNum1(connum);
	gevo.setStreetvo(svo);
	gevo.setUservo(uservo);
	
	gedao.update(gevo);
	
	}

	

}
