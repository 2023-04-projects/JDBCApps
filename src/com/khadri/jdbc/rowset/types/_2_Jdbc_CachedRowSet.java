package com.khadri.jdbc.rowset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class _2_Jdbc_CachedRowSet {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2024_batch", "root", "root");

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from student");

		RowSetFactory newFactory = RowSetProvider.newFactory();
		CachedRowSet cachedRowSet = newFactory.createCachedRowSet();
		cachedRowSet.populate(rs);

		con.close();

//		while (rs.next()) {
//			System.out.println(rs.getString(1) + "\t" + rs.getString(2));
//		}

		while (cachedRowSet.next()) {
			System.out.println(cachedRowSet.getString(1) + "\t" + cachedRowSet.getString(2));
		}

	}
}
