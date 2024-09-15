package com.khadri.jdbc.statment.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _3_Jdbc_Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		Statement stmt = conn.createStatement();

		int count = stmt.executeUpdate("insert into customer values(2,'jhon')");

		System.out.println(count + " Record Affected!!!!");
		conn.close();

	}
}
