package login_out;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import profile_post.ConnectDB;

/* Created By Seriaa Bakir
*/

@WebServlet("/register")
public class register extends HttpServlet {

   
	private static final long serialVersionUID = 1L;
	Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try 
        {
            
			Connection con = ConnectDB.connect();
	
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            
            
            pst = con.prepareStatement("insert into users(username,password,dob,gender,phone)values(?,?,?,?,?)");
            pst.setString(1, username);
            pst.setString(2, password); 
            pst.setString(3, dob);
            pst.setString(4, gender);
            pst.setString(5, phone);
            pst.executeUpdate();
            
          RequestDispatcher rd = request.getRequestDispatcher("signupSuccessful.jsp");
			
			rd.forward(request, response);
             
            
        }  catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
}
