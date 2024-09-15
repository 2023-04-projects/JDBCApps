package com.khadri.jdbc.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class _1_Jdbc_Scrolable_Forward_Backward {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet resultSet = stmt.executeQuery("select * from student");

		System.out.println("ResultSet forward direction......>");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
		}

		System.out.println("ResultSet backward direction......>");
		while (resultSet.previous()) {
			System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
		}

		con.close();
	}
}
