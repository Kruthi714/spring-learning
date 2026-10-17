package in.sp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.sp.connection.DbConnection;
import in.sp.model.User;
@WebServlet("/LogForm")
public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String myname=req.getParameter("name1");
	String myemail=req.getParameter("email1");
	PrintWriter out=resp.getWriter();
	resp.setContentType("text/html");
	Connection con=null;
	try {
		con=DbConnection.getConnection();
		String select_query="select * from register where name=? and email=?";
		PreparedStatement ps=con.prepareStatement(select_query);
		ps.setString(1, myname);
		ps.setString(2, myemail);
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			User user=new User();
			user.setName(res.getString("name"));//coln name of the sql
			user.setEmail(res.getString("email"));
			
			HttpSession session=req.getSession();
			session.setAttribute("session_user",user);
			RequestDispatcher rd=req.getRequestDispatcher("/Profile.jsp");
			rd.forward(req, resp);
		}
		else {
			out.println("<h3 style='color:red'>Name and Email didnt match Renter the details</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/Login.html");
			rd.include(req, resp);
			
		}
		
		ps.close();
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
}
