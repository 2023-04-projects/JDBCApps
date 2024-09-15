package com.khadri.jdbc.statment.apps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class _14_Jdbc_Program {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Properties properties = new Properties();
		properties.load(new FileReader(new File("db.properties")));
		String url = properties.getProperty("URL");
		String userName = properties.getProperty("USER_NAME");
		String password = properties.getProperty("PASSWORD");

		Connection con = DriverManager.getConnection(url, userName, password);

		Statement stmt = con.createStatement();

		ResultSet resultSet1 = stmt.executeQuery("select * from student");
		while (resultSet1.next()) {
			System.out.println(resultSet1.getInt(1) + "-" + resultSet1.getString(2));
		}

		ResultSet resultSet2 = stmt.executeQuery("select * from student");
		while (resultSet2.next()) {
			System.out.println(resultSet2.getInt(1) + "-" + resultSet2.getString(2));
		}

		 
		 stmt.executeQuery("select * from student");
		 
		 stmt.executeQuery("select * from student");
		 
		 
		 stmt.executeQuery("select * from student");
		 
		 stmt.executeQuery("select * from student");
		 
		 stmt.executeQuery("select * from student");
		con.close();

	}
}
