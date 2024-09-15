package com.khadri.jdbc.callable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class _4_Jdbc_Program {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		CallableStatement call = con.prepareCall("call KOPIKO(?)");

		call.setString(1, "A1 MILK ");
		call.registerOutParameter(1, Types.INTEGER);

		boolean isSelect = call.execute();

		if (!isSelect) {
			String result = call.getString(1);
			System.out.println(result);
		}

	}
}
