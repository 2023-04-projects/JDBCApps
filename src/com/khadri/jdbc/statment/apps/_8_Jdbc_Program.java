package com.khadri.jdbc.statment.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class _8_Jdbc_Program {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		System.out.println("Enter customer id: ");
		int id = sc.nextInt();

		Statement stmt = conn.createStatement();

		int count = stmt.executeUpdate("delete from customer where id=" + id);
		System.out.println(count + " Record Affected!!!!");

		sc.close();
		conn.close();

	}

}