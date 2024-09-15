package com.khadri.jdbc.statment.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class _4_Jdbc_Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		Statement stmt = conn.createStatement();

		System.out.println("Please enter customer id: ");
		int id = sc.nextInt();

		System.out.println("Please enter customer name: ");
		String name = sc.next();

		int count = stmt.executeUpdate("insert into customer values(" + id + ",'" + name + "')");

		System.out.println(count + " Record Affected!!!!");
		sc.close();
		conn.close();

	}
}
