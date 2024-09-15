package com.khadri.jdbc.metadata.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class _1_Jdbc_MetaData_ResultSet {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2024_batch", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("select * from student");
		ResultSetMetaData metaData = resultSet.getMetaData();

		System.out.println(metaData.getColumnCount());
		System.out.println(metaData.getTableName(1));
		System.out.println(metaData.getColumnName(1));
		System.out.println(metaData.getColumnName(2));
		System.out.println(metaData.getSchemaName(0));

	}
}
