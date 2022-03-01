package profile_post;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/* Created By Seriaa Bakir
*/
                                       
/**
 * Servlet implementation class SearchResult
 */
@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchResult() {
    	super();
    }

	
	public void init(ServletConfig config) throws ServletException {
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		// Create HttpSessions object
		
		HttpSession session = request.getSession(false);
		
		// check session status, already created or not ? if not create then redirect on Login
		
			if(session == null)
		{
			response.sendRedirect("Login.jsp");
		}
		
		Connection con = ConnectDB.connect();

		try
		{
			// write select Query
			
			String u = "select username from users  where id =" +session.getAttribute("ID");

			PreparedStatement pst6 = con.prepareStatement(u);
			
			ResultSet rs6 = pst6.executeQuery(u);
			
			rs6.next();
			
			
		String s;
			
			if(request.getParameter("Fetch").equals("friends"))
			{
				s = "select * from  users where id !="  +session.getAttribute("ID");
			}
			else 
			{
				s =  "select * from users where username like '%"+ request.getParameter("Fetch") +"%'";
			}
			
			PreparedStatement pst10 = con.prepareStatement(s);
			
			ResultSet rs10 = pst10.executeQuery();
			
			
			pw.print("<html>"
					
					+ "<head><title> Friends-Result   Friends</title>"
					
					
			
			
			+"<link rel='stylesheet' href='styles/Home.css'>"
			+"<link rel='stylesheet' href='styles/bootstrap.min.css'>"
			  +"<link rel='stylesheet' href='styles/style.css'>"
				
				+ "</head>"
				
				+ "<body>"
							
					+ "	<nav class='navbar navbar-expand-lg navbar-light bg-light'>"
					+ "			  <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarTogglerDemo01' aria-controls='navbarTogglerDemo01' aria-expanded='false' aria-label='Toggle navigation'>"
					+ "			    <span class='navbar-toggler-icon'></span>"
					+ "			  </button>"
						+ "			  <div class='collapse navbar-collapse' id='navbarTogglerDemo01'>"
						+ "		    <a class='navbar-brand' href='Home'><img src='images/fb.jpg' width='40'  height='30' alt='facebook f logo white background' /></a>"
					
							+ "				    <form action ='SearchResult'  id='searchBar' class='form-inline my-2 my-lg-0'>"
							+ "	      <input class='form-control mr-sm-2' type='search' name ='Fetch' placeholder='Search' aria-label='Search'  required>"
							+ "	      <button class='btn btn-outline-success my-2 my-sm-0' type='submit'>Search</button>"
							+ "	    </form>"
								+ "	    <ul class='navbar-nav mr-auto mt-2 mt-lg-0'>"
								+ "      <li class='nav-item active'>"
								+ "        <a class='nav-link' href='Home'> Home <span class='sr-only'></span></a>"
								+ "      </li>"
									+ "      <li class='nav-item'>"
									+ "     <a class='nav-link' href='OperationForm?Id=Add'> Add Post </a>"
									+ "   </li>"
									   + "   <li class='nav-item'>"
									   + "  <a class='nav-link ' href='Profile?Fetch=profile' tabindex='-1' > My Profile </a>"
									   + "</li>"
									      + "<li class='nav-item'>"
									      + "<a class='nav-link ' href='SearchResult?Fetch=friends' tabindex='-1' > Friends </a>"
									      + "</li>"
									      + "<li class='nav-item'>"
									      + "<a class='nav-link ' href='Logout' tabindex='-1' > Logout </a>"
									      + "</li>"
							+ "		    </ul>"
								+ "	  </div>"
									+ "</nav>	"
							
							+ "<center><br>"
							
							+ "<h2>Hello  <b>" + rs6.getString(1) + "</b></h2><br><br><br>"	

				
				
				+ "<div style='clear:both;'><h2>Friends List</h2><br><br>");
				 
			
		while( rs10.next())
		{
			
		 // Fetch record
			
			pw.print( "	<div id='myfriends-center-hand' class='card' style='width:20rem '>"
					+"  <div class='card-body'>"
					+"<h5 class='card-title'>My Friend</h5>"
						+"<ul class='list-group list-group-flush'>"
							+"		      <li class='list-group-item'><br><th><b>Name : </b></th>"+ rs10.getString(2)+"<br></li>"
								+"		      <li class='list-group-item'><br><th><b>Gender : </b></th>"+ rs10.getString(5)+"<br></li>"
									+"		     <li class='list-group-item'><br><b>View Profile : </b><a href='Pro?fetch="+rs10.getString(2)+"''>GO</a><br></li>"
							  +"		    </ul>"
								  +"		  </div>"
								  	 +"	 		</div><br> ");
		 }
		
	pw.print("</body></html>");
			
			con.close();
		}
		catch(Exception ex)
		{
			pw.print(ex);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}