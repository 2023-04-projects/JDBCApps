package com.khadri.jdbc.statment.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class _10_Jdbc_Program {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		Statement stmt = con.createStatement();

		ResultSet resultSet = stmt.executeQuery("select name from customer");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}

	}
}
