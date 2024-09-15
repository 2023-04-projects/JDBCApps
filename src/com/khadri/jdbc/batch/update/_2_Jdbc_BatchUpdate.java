package com.khadri.jdbc.batch.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class _2_Jdbc_BatchUpdate {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		Statement stmt = con.createStatement();

		for (int i = 0; i < 2; i++) {
			System.out.println("Please enter customer id: ");
			int id = sc.nextInt();
			System.out.println("Please enter customer name: ");
			String name = sc.next();
			stmt.addBatch("insert into customer(id,name) values(" + id + ",'" + name + "')");
		}

		for (int i = 0; i < 3; i++) {
			System.out.println("Please enter student id: ");
			int id = sc.nextInt();
			System.out.println("Please enter student name: ");
			String name = sc.next();
			stmt.addBatch("insert into student(id,name) values(" + id + ",'" + name + "')");
		}

		int[] arrayOfResults = stmt.executeBatch();

		for (int result : arrayOfResults) {

			System.out.println(result + " Row Affected!!!!");
		}

		sc.close();

	}
}
