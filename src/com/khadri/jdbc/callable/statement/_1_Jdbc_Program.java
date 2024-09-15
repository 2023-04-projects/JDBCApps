package com.khadri.jdbc.callable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class _1_Jdbc_Program {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		CallableStatement call = con.prepareCall("call calc_procedure(?,?,?,?)");
		call.setInt(1, 1000);
		call.setInt(2, 1000);
		call.setInt(3, 1);
		call.setInt(4, 7);
		call.execute();

	}
}
