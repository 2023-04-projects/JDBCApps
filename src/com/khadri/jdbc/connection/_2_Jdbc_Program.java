package com.khadri.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _2_Jdbc_Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch?user=root&password=root");

		Statement stmt = con.createStatement();

		ResultSet resultSet = stmt.executeQuery("select * from student");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
		}

		con.close();

	}
}
