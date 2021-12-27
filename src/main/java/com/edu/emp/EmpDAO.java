package com.edu.emp;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;

public class EmpDAO extends DAO {

//쿼리-- 호출-- 프리페어만들고-- 실행하고

	// 수정
	public void updateEmp(EmployeeVO vo) {
		String sql = "update emp_temp set salary = ?, job_id=?, email=? where employee_id=?";
		connect();
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSalary());
			pstmt.setString(2, vo.getJobId());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getEmployeeId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 변경 ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 한건입력

	public void insertEmp(EmployeeVO vo) {
		String sql = "insert  into emp_temp(employee_id, first_name, last_name, email, job_id, salary, hire_date)"
				+ "Values(employees_seq.nextval, ?,?,?,?,?,?)";

		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getJobId());
			pstmt.setInt(5, vo.getSalary());
			pstmt.setString(6, vo.getHireDate());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 전체리스트
	public List<EmployeeVO> getEmpList() {

		List<EmployeeVO> employees = new ArrayList<>();
		String sql = "select * from emp_temp order by 1";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));

				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			disconnect();
		}
		return employees;
	}

	// 한건조회

	public EmployeeVO getEmployee(int eid) {
		String sql = "select * from emp_temp where employee_id=?";
		connect();

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));

				return emp;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return null;

	}

	public void deleteEmp(int i) {
		String sql = "delete from emp_temp where employee_id=?";
		connect();

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

	}

}
