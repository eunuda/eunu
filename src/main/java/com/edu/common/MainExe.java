package com.edu.common;

import java.util.List;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;

public class MainExe {
	public static void main(String[] args) {

		EmpDAO dao = new EmpDAO();

// 입력 값을 fn, ln, em, hd, ji, sa

		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId(209);

		vo.setFirstName("민수");
		vo.setLastName("김");

		vo.setEmail("ms@email.com");
		vo.setHireDate("2021-05-01");
		vo.setJobId("SA_MAN");
		vo.setSalary(6000);

//dao.insertEmp(vo);
//dao.updateEmp(vo);
		dao.deleteEmp(209);

		List<EmployeeVO> empList = dao.getEmpList();

		for (EmployeeVO emp : empList)
			System.out.println(emp);

	}

}
