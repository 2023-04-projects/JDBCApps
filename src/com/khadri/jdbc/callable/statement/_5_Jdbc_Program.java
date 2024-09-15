package com.khadri.jdbc.callable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class _5_Jdbc_Program {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		CallableStatement call = con.prepareCall("{? = call student_avg(?,?)}");

		call.registerOutParameter(1, Types.DOUBLE);
		call.setInt(2, 70);
		call.setInt(3, 80);

		boolean isSelect = call.execute();

		if (!isSelect) {
			Double result = call.getDouble(1);
			System.out.println(result);
		}

	}
}
