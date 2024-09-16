package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBcon.dbconn;

/**
 * Servlet implementation class investorlogin
 */
@WebServlet("/investorlogin")
public class investorlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public investorlogin() {
        super();
        // TODO Auto-generated constructor stub
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
		
		int z=0;
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		
		try {
		
		Connection con= dbconn.create();
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery("SELECT * FROM globalinvest.investors where email='"+email+"' and password='"+password+"' and status1='Approved' and status2='Approved' ");
		

		while(rs.next())
		{	
		z=1;
		session.setAttribute("email", email);
		session.setAttribute("contact", rs.getString(5));
		session.setAttribute("name", rs.getString(2));
		
		}
		if(z==0) {
		response.sendRedirect("Errorpage.jsp");
		
		}else{
		
			response.sendRedirect("investorshome.jsp");
			
		}
		
		
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
