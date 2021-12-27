package com.edu.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;


@WebServlet({"/html/GetEmpServlet", "/html/empServlet"})
public class GetEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public GetEmpServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	EmpDAO dao = new EmpDAO();
	String eid = request.getParameter("id");
	EmployeeVO vo = dao.getEmployee(Integer.parseInt(eid));
	out.println("<h2>" + vo.getFirstName ()+ "" + vo.getLastName() + "</h2>");
	out.println("<p> + 이메일 :" + vo.getEmail()+ "</p> ");
	out.println("<p> + 입사일자 :" + vo.getHireDate()+ "</p> ");
	out.println("<p> + 직무 :" + vo.getJobId()+ "</p> ");
	out.println("<p> + 급여 :" + vo.getSalary()+ "</p> ");
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
