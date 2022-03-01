package profile_post;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.Servlet;
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
@WebServlet("/Pro")
public class Pro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Pro() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
			
			
			String u = "select username from users  where id =" +session.getAttribute("ID");

			PreparedStatement pst6 = con.prepareStatement(u);
			
			ResultSet rs6 = pst6.executeQuery(u);
			
			rs6.next();
							
				String q,l;
			
			q = "SELECT id FROM users WHERE username LIKE '%"+request.getParameter("fetch")+"%'";
			
			PreparedStatement pst1 = con.prepareStatement(q);
			
			ResultSet rs9 = pst1.executeQuery();
			
			rs9.next();
					
			l = "select * from post where user_id =" + rs9.getInt(1) ;
			
			PreparedStatement pst20 = con.prepareStatement(l);
			
			ResultSet rs4 = pst20.executeQuery();
			
			
			
			//rs4.next();
			
					
			pw.print("<html>"
					
					+ "<head><title>Posts</title>"
					
					
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

				+ "<h2>Hello  <b>" + rs6.getString(1) + "</b></h2>"
				
				+ "<br><br><br>"
							
				+ "<div class='container'><div class='row'>    "
				+"   <div><h4 class='mb-4'>Posts</h4></div>  "
				+"  </div>"  );
			
	
		while( rs4.next())
		{	
			
			
			String k = "select user_id from post where id = "+ rs4.getInt(1) ;
    		
			PreparedStatement pst7 = con.prepareStatement(k);
			
			ResultSet rs7 = pst7.executeQuery(k);
		
			rs7.next();
			
			String n ="select username from users where id = " + rs7.getInt(1) ;
			
				PreparedStatement pst8 = con.prepareStatement(n);
				
				ResultSet rs8 = pst8.executeQuery(n);
			
				rs8.next();
			
			
			pw.print(	"<div id='section-one' class='shadow p-3 mb-5 bg-body rounded'>  "
				      +" <div class='row'>  "
				        +" <div class='post'>  "
				          +"  <p><b>"+ "Username : " + rs8.getString(1) +"</b></p>     "
				            +"  <p><b>"+ "Titre : </b>"+ rs4.getString(2)+"</p>  "
				            +"  <p><b>"+ "Content : </b>"		+ rs4.getString(3)+ "</p>  "
				            +"  <p><b>"+ "time-added : </b>"		+ rs4.getString(6)+ "</p>  "
				           +" <p><image src ='images/"+rs4.getString(4)+"' width ='700'  heigth ='500' style='margin:50px 50px'></p> "
				            
				            +"     </div>"
				          +"   </div>"
				     +" </div>"
				      );
		}
				
			pw.print("</table></body></html>");
			
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