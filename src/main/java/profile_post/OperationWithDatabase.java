package profile_post;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
//import java.sql.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/* Created By Seriaa Bakir
*/

/**
 * Servlet implementation class OperationWithDatabase
 */
@WebServlet("/OperationWithDatabase")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)

public class OperationWithDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     
    public OperationWithDatabase() {
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
		
		try
		{
			Connection con = ConnectDB.connect();

			//   Check operationType value
			
			//   this is post delete function
			
			if(request.getParameter("OperationType").equals("Delete"))
			{
				int Id = Integer.parseInt(request.getParameter("Id"));
			
				String delete_query = "delete from post where id = '"+ Id +"'";
				
				Statement st = con.createStatement();
				
				int check = st.executeUpdate(delete_query);
				
				if(check == 1)
				{
					pw.print("<script>alert('post Deleted..')</script>");
					
					RequestDispatcher rq = request.getRequestDispatcher("Home");
					
					rq.include(request, response);
				}
				else
				{
					pw.print("<script>alert('post Not Deleted Try Again..')</script>");
				}
					return;
			}
			
			//  if operationType not delete then execute this code
			
			// get parameters from operationForm

			

			
			String titre,text ;
			
			titre = request.getParameter("titre");
			
			text = request.getParameter("text");
			
			

			
			
			// this is add post function
			
			if(request.getParameter("OperationType").equals("Add"))
			{
				Part part = request.getPart("file");
				
				String fileName =extractFileName(part);
				
				
				String savePath = "C://Users//LENOVO//Desktop//the Real Projects//project//src//main//webapp//images//" + File.separator + fileName ;

				//File  fileSaveDir = new File(savePath);
				
				
				part.write(savePath + File.separator );
				
				String 	insert_query = "insert into post (titre , text ,file,path, user_id ) values ('"+ titre +"','"+ text +"','"+fileName+"','"+savePath+"','"+ session.getAttribute("ID")+"')";
				
				Statement st = con.createStatement();
				
				int check = st.executeUpdate(insert_query);
				 
				if(check == 1)
				{
					pw.print("<script>alert('Post Inserted..')</script>");
					
					RequestDispatcher rq = request.getRequestDispatcher("Home");
					
					rq.include(request, response);
				}
				else
				{
					pw.print("<script>alert('post Not Inserted Try Again..')</script>");
				}
			return;
			}
				//  this is update post function
			
			if(request.getParameter("OperationType").equals("Update"))
			{
				int Id = Integer.parseInt(request.getParameter("Id"));
				
				String update_query = "update post set titre ='"+ titre +"', text='"+ text +"'  where id = '"+Id+"'";
				
				Statement st = con.createStatement();
				
				int check = st.executeUpdate(update_query);
				 
				if(check == 1)
				{
					pw.print("<script>alert('post Updated..')</script>");
					
					RequestDispatcher rq = request.getRequestDispatcher("Home");
					
					rq.include(request, response);
				}
				else
				{
					pw.print("<script>alert('post Not Updated Try Again..')</script>");
				}
			
			}
		}
		catch(Exception ex)
		{
			pw.print(ex);
		}
}
		
	

	private String extractFileName(Part part) {

		String  contentDisp = part.getHeader("content-disposition");
		
		String[] items  =contentDisp.split(";");
		
		for(String s : items) {
			
			if(s.trim().startsWith("filename"))
			{
				return s.substring(s.indexOf("=") + 2, s.length() -1);
			}
		}
		
		return "";
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
