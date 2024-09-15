package com.khadri.jdbc.prepared.statement.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class _5_Jdbc_Program {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		PreparedStatement pstmt = con.prepareStatement("select * from customer");

		ResultSet resultSet = pstmt.executeQuery();

		while (resultSet.next()) {
			System.out.println("ID: " + resultSet.getInt(1) + " NAME: " + resultSet.getString(2) + " TXN DATE: "
					+ resultSet.getDate(3) + " TXN TIME: " + resultSet.getTime(4) + " TXN TIMESTAMP: "
					+ resultSet.getTimestamp(5));
		}

	}
}
