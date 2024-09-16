package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBcon.dbconn;
import mail.mail1;

/**
 * Servlet implementation class date
 */
@WebServlet("/date")
public class date extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public date() {
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
		String id=request.getParameter("id");
		String mail=request.getParameter("mail");
		String date=request.getParameter("deliveryDate");
		String status="dateupdated";
		
		Connection con;
		
		try{
			con=dbconn.create();
			Statement st=con.createStatement();
			st.executeUpdate("UPDATE `rationshop`.`cart` set date='"+date+"' and status2='"+status+"' where id='"+id+"' and mail='"+mail+"' ");
			 mail1.mail(mail,"Dear User "+mail+", Your product is approved by ration shop, Your delivery date is  "+date+" come and get your product.");
			
			
			
			
			
			response.sendRedirect("managehome.jsp?valid");
		}
		catch(Exception e){
			response.sendRedirect("error.jsp?inval id");
		System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
