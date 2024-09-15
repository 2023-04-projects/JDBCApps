package com.khadri.jdbc.rowset.types;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class _1_Jdbc_JdbcRowSet {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		RowSetFactory newFactory = RowSetProvider.newFactory();
		JdbcRowSet jdbcRowSet = newFactory.createJdbcRowSet();

		jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/2024_batch");
		jdbcRowSet.setUsername("root");
		jdbcRowSet.setPassword("root");
		jdbcRowSet.setCommand("select * from student");
		jdbcRowSet.execute();

		System.out.println("===========================> farward starts");
		while (jdbcRowSet.next()) {
			System.out.println(jdbcRowSet.getString(1) + "\t" + jdbcRowSet.getString(2));
		}
		System.out.println("===========================> farward ends");

		System.out.println("<=========================== backward starts");
		while (jdbcRowSet.previous()) {
			System.out.println(jdbcRowSet.getString(1) + "\t" + jdbcRowSet.getString(2));
		}
		System.out.println("<=========================== backward ends");

		System.out.println("===========================> cursor jump to 4 th position from current position");
		jdbcRowSet.absolute(4);

		while (jdbcRowSet.next()) {
			System.out.println(jdbcRowSet.getString(1) + "\t" + jdbcRowSet.getString(2));
		}

	}
}
