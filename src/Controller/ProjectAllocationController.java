package Controller;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import javax.servlet.annotation.WebServlet;
import DAO.CategoryDAO;
import DAO.GovtEmpDAO;
import DAO.TenderDAO;
import VO.CategoryVO;
import VO.GovtEmpProjectVO;
import VO.GovtEmpVO;
import VO.LinkVO;
import VO.TenderVO;
import DAO.LinkDAO;

import DAO.ProjectAllocationDAO;
/**
 * Servlet implementation class ProjectAllocationController
 */
@WebServlet("/ProjectAllocationController")
public class ProjectAllocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectAllocationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TenderVO tvo=new TenderVO();
		TenderDAO tdao=new TenderDAO();
		List ls=new ArrayList();
		System.out.println("before tender load");
		ls=tdao.load(tvo);
		
		System.out.println("session set for tender");
		HttpSession session=request.getSession();
		session.setAttribute("tender_list",ls);
		
		GovtEmpVO gvo = new GovtEmpVO();
		GovtEmpDAO gdao = new GovtEmpDAO();
		
		List ls1=new ArrayList();
		System.out.println("before govt load");
		ls1=gdao.load(gvo);
		
		System.out.println("session set for govt emp");
		HttpSession session1=request.getSession();
		session1.setAttribute("govt_list",ls1);
		
		
		System.out.println("both load done");
		
		
		
		response.sendRedirect("Admin/Project_Allocation.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		System.out.println("flag = " + flag);
		if(flag!=null && flag.equals("insert"))
		{
			insert(request,response);
		}
	}

	void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Long  tid=Long.valueOf( request.getParameter("tender_Id"));
		
		Long gid =Long.valueOf( request.getParameter("govt_Id"));
	
		GovtEmpProjectVO gpvo = new GovtEmpProjectVO();
		ProjectAllocationDAO  pdao = new ProjectAllocationDAO();
		
		TenderVO tvo = new TenderVO();
		tvo.setTender_Id(tid);
		
		GovtEmpVO gevo = new GovtEmpVO();
		gevo.setG_id(gid);
		
		gpvo.setGeVO(gevo);
		gpvo.setTenderVO(tvo);
		
		pdao.insert(gpvo);
		
		GovtEmpDAO gedao = new GovtEmpDAO();
		List ls1 = gedao.getmail(gevo);
		
		Iterator itr =  ls1.iterator();
		
		GovtEmpVO z = (GovtEmpVO)itr.next();
		
		String q = z.getEmail();
		
		System.out.println(q);
		
		sendActivationLink(q,gevo,request,response);
		
}
	
protected void sendActivationLink(String s,GovtEmpVO gevo,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		String activationLink = "http://localhost:9090/SGC_PROJECT/Verification?authentication="+linkVO.getLink()+"&proc=activation"; 
		//PatientVO pv=new PatientVO();
		
		//pv.setUserid(VO_obj);
		
		System.out.println("GovtEmp id:"+gevo.getG_id());
		System.out.println("Recievers email id:"+s);
		sendMail(s,activationLink,"Account Activation");
		
	
		
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

protected void sendMail(String email,String activationLink,String msg){
		
		java.util.Properties properties = new java.util.Properties();
        properties.put("mail.smtp.auth", "true");
         properties.put("mail.smtp.starttls.enable", "true");
         javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

        System.out.println("Inside send mail");
        
 
         try {
            MimeMessage message = new MimeMessage(mailSession);
   
           
            message.setContent("<h1>Below is your "+msg+" Code</h1>"
            		+ "<a href='"+activationLink+"'> Click here to "+msg+" your account </a> "
            		+ ""
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

}
