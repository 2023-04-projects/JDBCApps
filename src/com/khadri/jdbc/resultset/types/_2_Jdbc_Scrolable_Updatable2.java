package com.khadri.jdbc.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class _2_Jdbc_Scrolable_Updatable2 {

	public static void main(String[] args) throws Exception {

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 Connection con= DriverManager.getConnection("jdbc:odbc:testdb","root","root");
		

		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = stmt.executeQuery("select * from shop");
		
		 while(rs.next()) {
			 System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		 }
		
		 System.out.println("Results already processed from ResultSet ");
		 
		 System.in.read();
		 rs.beforeFirst();
		 System.out.println("!!!Updated the records!!!!");
		 while(rs.next()) {
			 rs.refreshRow();
			 System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		 }
		 con.close();
	}
}
