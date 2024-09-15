package com.khadri.jdbc.statment.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class _7_Jdbc_Program {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		boolean decision = false;
		do {
			System.out.println("Enter customer id: ");
			int id = sc.nextInt();

			System.out.println("Enter customer name: ");
			String name = sc.next();

			System.out.println(conn);

			Statement stmt = conn.createStatement();

			int count = stmt.executeUpdate("update customer set name='" + name + "' where id=" + id);

			System.out.println(count + " Record Affected!!!!");

			System.out.println("do you want to continue?(YES/NO) : ");
			String wish = sc.next();

			if (wish.equalsIgnoreCase("YES")) {
				decision = true;
			} else if (wish.equalsIgnoreCase("NO")) {
				decision = false;
			}

		} while (decision);

		sc.close();
		conn.close();
	}
}
