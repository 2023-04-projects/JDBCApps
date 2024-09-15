package com.khadri.jdbc.callable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class _2_Jdbc_Program {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		CallableStatement call = con.prepareCall("call calc_multi_proc(?,?)");
		call.setInt(1, 1000);
		call.registerOutParameter(2, Types.INTEGER);
		boolean isSelect = call.execute();

		if (!isSelect) {
			int result = call.getInt(2);
			System.out.println(result);

		}

	}
}
