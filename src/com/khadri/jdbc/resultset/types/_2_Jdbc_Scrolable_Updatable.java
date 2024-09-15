package com.khadri.jdbc.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class _2_Jdbc_Scrolable_Updatable {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = stmt.executeQuery("select * from student");

		while (rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(2));
		}

		System.out.println("Results already processed from ResultSet ");

		//System.in.read();
		rs.updateString(6, "QQQQQ");
//		rs.beforeFirst();
		System.out.println("!!!Updated the records!!!!");
		while (rs.next()) {
			rs.refreshRow();
			System.out.println(rs.getString(1) + "\t" + rs.getString(2));
		}
		con.close();
	}
}
