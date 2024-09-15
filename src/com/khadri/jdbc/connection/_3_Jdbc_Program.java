package com.khadri.jdbc.connection;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class _3_Jdbc_Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Properties properties = new Properties();
		properties.load(new FileReader(new File("mysql.properties")));
		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", properties);

		Statement stmt = con.createStatement();

		ResultSet resultSet = stmt.executeQuery("select * from student");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
		}

		con.close();

	}
}
