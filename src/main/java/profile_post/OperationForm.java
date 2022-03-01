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
 * Servlet implementation class OperationForm
 */
@WebServlet("/OperationForm")
public class OperationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OperationForm() {
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

			PreparedStatement pst1 = con.prepareStatement(u);
			
			ResultSet rs1 = pst1.executeQuery(u);
			
			rs1.next();
			
			pw.print("<html>"
					
					+ "<head><title> Add Post - Update</title>"
					
					
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

				+ "<h2>Hello  <b>" + rs1.getString(1) + "</b></h2><br><br><br>");

			String Id = request.getParameter("Id");

			
			ResultSet rs4 = null;
			
			// Add post Code
			
			if(Id.equals("Add"))
			{
				pw.print("<h1>Add New Post</h1>"
	
						+"<div id='postSection' style='margin:50px 50px'>"

						    +"	  <div class='form-group shadow-textarea'>" 
							+"	    <form action='OperationWithDatabase' method='post'  enctype ='multipart/form-data'>"
							+ "			<br>		<td><b>titre<b></td><br><br>"
							+"      <textarea class='form-control z-depth-1' id='exampleFormControlTextarea6' rows='1' name='titre' placeholder='titre'></textarea>"
								+ "					<br><td><b>Whats On Your Mind?<b></td><br><br>"
							+"      <textarea class='form-control z-depth-1' id='exampleFormControlTextarea6' rows='4' name='text' placeholder='Whats On Your Mind?'></textarea>"
							+"<br><input type='file' name='file' >"		
							+"      <button type='submit'name='OperationType' value='Add' class='btn btn-secondary btn-sm'>Post</button>"
									+"</form>"
									+"  </div>"
								+"</div>"    ); 
			}
			
					// Update post code
			else	
			{
				pw.print("<h1>Update The Post</h1>");
				
				//  Write select Query
				
				String q = "select * from post where id = "+ Integer.parseInt(Id) +"";
				
				PreparedStatement pst4 = con.prepareStatement(q);
				
				rs4 = pst4.executeQuery();
				
				rs4.next();
				
				// set controls value according post id
				
				pw.print("<div id='postSection'style='margin:50px 50px'>"

							+"	  <div class='form-group shadow-textarea'>"  
							+"	    <form action='OperationWithDatabase' method='post' >"
							+ "			<br>		<td><b>titre</b></td><br><br>"
							+"      <textarea class='form-control z-depth-1' id='exampleFormControlTextarea6' rows='1' name='titre' >"+rs4.getString(2)+"</textarea>"
								+ "		         <br>  <td><b>Whats On Your Mind?</b></td><br><br>"
							+"      <textarea class='form-control z-depth-1' id='exampleFormControlTextarea6' rows='4' name='text'>"+rs4.getString(3)+"</textarea>"
							+ "		<input type='hidden' value='Update' name='OperationType'>"                 // hidden field for send operation type (update post)
							+ "		<input type='hidden' value='"+rs4.getString("Id")+"' name='Id'>"          // pass post id
							+"      <button type='submit'name='OperationType' value='Update' class='btn btn-secondary btn-sm'>Update</button>"
									+"</form>"
									+"  </div>"
								+"</div>"  );       }

						pw.print("</center></body></html>");
			
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
