package com.khadri.jdbc.statment.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class _12_Jdbc_program {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		Statement stmt = con.createStatement();

//		String query = "select count(*) from customer";
		String query = "select min(id) from customer";
//		String query= "select max(id) from customer";
//		String query= "select avg(id) from customer";
//		String query= "select sum(id) from customer";

		ResultSet resultSet = stmt.executeQuery(query);
		if (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
		}

	}
}
