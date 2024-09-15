package com.khadri.jdbc.statment.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _13_Jdbc_Program {

	private Connection con;

	private Statement stmt;

	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("SQL Exception occured : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("CNFE Exception occured : " + e);
		}

	}

	public static void main(String[] args) {

		_13_Jdbc_Program program = new _13_Jdbc_Program();

		program.performDBOperation("select * from student");

	}

	private void performDBOperation(String query) {
		try {

			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
			}

		} catch (SQLException e) {
			System.out.println("Exection occured : " + e);
		} finally {
			System.out.println("finally block : closing resources");
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("finally: catch block " + e.getMessage());
			}

		}
	}
}
