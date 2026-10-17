package in.sp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.sp.connection.DbConnection;

@WebServlet("/RegForm")
public class Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		String myname=req.getParameter("name1");
		String myemail=req.getParameter("email1");
		String mypass=req.getParameter("pass1");
		String mycity=req.getParameter("city1");
		String mypin=req.getParameter("pin1");
		try {
			Connection con=DbConnection.getConnection();
			String insert_sql_query="insert into register(name,email,password,city,pin)values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(insert_sql_query);
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mycity);
			ps.setString(5, mypin);
			int c=ps.executeUpdate();
			if(c>0) {
				out.println("<h1 style='color:Green'>Registered Successfully</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("/Login.html");
				rd.include(req, resp);
				
			}
			else {
				out.println("<h1 style='color:Red'>Registered UnSuccessfull due to issues Re-enter The details</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("Register.html");
				rd.include(req, resp);
				
			}
			 ps.close();
	         con.close();
			
		}
		catch(Exception e){
			out.println("<h1 style='color:red'>Something went wrong</h1>");
			e.printStackTrace();
		}
	}
	

}
