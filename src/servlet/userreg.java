package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

import DBcon.dbconn;

/**
 * Servlet implementation class userreg
 */
@WebServlet("/userreg")
public class userreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userreg() {
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
		
		
		MultipartParser mp =new MultipartParser(request, 999999999);
		String key = "YBHDFBggfb436674";
				Part part = null;
				ArrayList paramValues = new ArrayList();

				FilePart filepart = null;
				ParamPart param=null;
				File file1 = null;
				String filepath1 = null;
				String filetype=null;
				String filepath2 = null;
				String filename = null;
				
				long size=0;
				String path=getServletContext().getRealPath("");
				
				System.out.println("path=="+path);
				
				
				String editpath=path.substring(0, path.indexOf("."));
				
				System.out.println("edithpath=="+editpath);
				
				String fullpath=editpath+"globalinvest\\WebContent\\Local\\";
				
				
				System.out.println("fullpath=="+fullpath);
				
				while((part=mp.readNextPart())!=null)
				{
					
					if(part.isFile())
					{
						
						filepart=(FilePart)part;
				
					    filename=filepart.getFileName();
						System.out.println("filename=="+filename);
						
					    fullpath=fullpath+filename;
				        System.out.println("fullpath=="+fullpath);
						
						
						File file=new File(fullpath);
					    size=filepart.writeTo(file);
						System.out.println("size=="+size);
						
				         filetype=filepart.getContentType();
						System.out.println("filetype---"+filetype);
						
					}
					else if(part.isParam())
					{
						param = (ParamPart) part;
						String tagName =param.getName();
						System.out.println("tagName ============= " + tagName);
						String tagValue = param.getStringValue();
						System.out.println("tagValue ************ " + tagValue);
						 
						paramValues.add(tagValue);
						paramValues.add(tagName);
						
					}
				
				}
				

		           Connection con;
		       	int dd=0;
		       	try
		       	{
		       		
		       		 con=dbconn.create();
		       		 PreparedStatement ps=con.prepareStatement("INSERT INTO globalinvest.`user` VALUES(id,?,?,?,?,?,?)");
		       		
		       		 ps.setString(1,(paramValues.get(0).toString()));
		       		 ps.setString(2,(paramValues.get(2).toString()));
		       		 ps.setString(3,(paramValues.get(4).toString()));
		       		 ps.setString(4,(paramValues.get(6).toString()));
		       	   	 ps.setString(5,(paramValues.get(8).toString()));
		       		 ps.setString(6,filename);
		       		 
		       		 
		       		 dd=ps.executeUpdate();	
		     
		       	
		       		response.sendRedirect("userreg.jsp");
		       	
		       	
		       	
		       	
		       	
		       	
		       	
		       	
		       	
		       	}
		       	
		       	
		       	catch(Exception e)
		       	{
		       		e.printStackTrace();
		       	}
			 	
	}

}
