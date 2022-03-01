package profile_post;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Home() {
    	super(); 
    }

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		// Create HttpSessions object
		
		HttpSession session = request.getSession(false);
		
		// check session status, already created or not ? if not creat then redirect on Login
		
			if(session == null)
		{
			response.sendRedirect("Login.jsp");
		} 
		
		try
		{
			// connection from connectDB
			
			Connection con = ConnectDB.connect();
			
			// write select Query
			
			String fetch_posts = "select * from post";
			
			PreparedStatement pst = con.prepareStatement(fetch_posts);
			
			ResultSet rs = pst.executeQuery();
			
			String u = "select username from users  where id =" +session.getAttribute("ID");

			PreparedStatement pst1 = con.prepareStatement(u);
			
			ResultSet rs1 = pst1.executeQuery(u);
			
			rs1.next();
				
			pw.print("<html>"
					
					+ "<head><title>Home Page</title>"
					
					
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
				
				+ "<h2>Hello  <b>" + rs1.getString(1) + "</b></h2>"
				
				 
				+ "<br><br><br>"

				+ "<div class='container'><div class='row'>    "
						+"   <div><h4 class='mb-4'><b>Posts</b></h4></div>  "  
					+"  </div>"  );
				
			 
			while( rs.next())
				
			{
				
				String k = "select user_id from post where id = "+ rs.getInt(1) ;
	    		
				PreparedStatement pst2 = con.prepareStatement(k);
				
				ResultSet rs2 = pst2.executeQuery(k);
			
				rs2.next();
				
				String n ="select username from users where id = " + rs2.getInt(1) ;
				
					PreparedStatement pst3 = con.prepareStatement(n);
					
					ResultSet rs3 = pst3.executeQuery(n);
				
					rs3.next();
				
					
				
						pw.print(  "<div id='section-one' class='shadow p-3 mb-5 bg-body rounded'>  "
							      +" <div class='row'>  "
							        +" <div class='post'>  "
							          +"  <p><b>"+ "Username : "+ rs3.getString(1) +"</b></p>     "
							            +"  <p><b>"+ "Titre : </b>"+ rs.getString(2)+"</p>  "
							            +"  <p><b>"+ "Content : </b>"		+ rs.getString(3)+ "</p>  "
							            +"  <p><b>"+ "time-added : </b>"		+ rs.getString(6)+ "</p>  "
							            +" <p><image src ='images/"+rs.getString(4)+"' width ='700'  heigth ='500' style='margin:50px 50px'></p> "
							              +"     </div>"
							          +"   </div>"
							     +" </div>"

								+" <footer class="footer2">"
								<h2>Algérie Télécom 2020\2021</h2> </footer>"

							      );
			}
			

			pw.print("<br>Created By Seriaa Bakir</body></html>");
			
			con.close();
		}
		catch(Exception ex)
		{
			pw.print(ex);
		}
	}
	


}
