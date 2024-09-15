package com.khadri.jdbc.metadata.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class _1_Jdbc_MetaData_Database {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2024_batch", "root", "root");
		DatabaseMetaData metaData = con.getMetaData();

		System.out.println("URL = " + metaData.getURL());
		System.out.println("USERNAME= " + metaData.getUserName());
		System.out.println("SCHEMA= " + metaData.getSchemas());
		System.out.println("DRIVER NAME= " + metaData.getDriverName());
		System.out.println("DRIVER VERSION= " + metaData.getDriverVersion());
		System.out.println("DRIVER MJR VERSION= " + metaData.getDriverMajorVersion());
		System.out.println("DRIVER MNR VERSION= " + metaData.getDriverMinorVersion());
		System.out.println("JDBC MJR VERSION= " + metaData.getJDBCMajorVersion());
		System.out.println("JDBC MNR VERSION= " + metaData.getJDBCMinorVersion());
		System.out.println("MAX COLUMN LENGTH VERSION= " + metaData.getMaxColumnNameLength());
		System.out.println("MAX CONNECTIONS= " + metaData.getMaxConnections());
		System.out.println("DB PRODUCT NAME= " + metaData.getDatabaseProductName());
		System.out.println("TABLE TYPES= " + metaData.getTableTypes());
		System.out.println("ALL PROC CALLABLE?= " + metaData.allProceduresAreCallable());
		System.out.println("STRING FUNCTIONS= " + metaData.getStringFunctions());

	}
}
