package com.khadri.jdbc.statment.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class _11_Jdbc_Program {

	public static void main(String[] args) throws Exception {
		String query = null;
		Scanner sc = new Scanner(System.in);

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		Statement stmt = con.createStatement();

		System.out.println("Please choose operation(SELECT/UPDATE/INSERT/DELETE) on customer table : ");
		String input = sc.next();

		if (input.equals("SELECT")) {
			query = "select name from customer";
		} else if (input.equals("UPDATE")) {

			System.out.println("Enter customer id: ");
			int id = sc.nextInt();

			System.out.println("Enter customer name: ");
			String name = sc.next();

			query = "update customer set name='" + name + "' where id=" + id;
		} else if (input.equals("INSERT")) {

			System.out.println("Enter customer id: ");
			int id = sc.nextInt();

			System.out.println("Enter customer name: ");
			String name = sc.next();

			query = "insert into customer values(" + id + ",'" + name + "')";
		} else if (input.equals("DELETE")) {

			System.out.println("Enter customer id: ");
			int id = sc.nextInt();

			query = "delete from customer where id=" + id;
		}

		boolean isSelectQuery = stmt.execute(query);

		if (isSelectQuery) {
			ResultSet resultSet = stmt.getResultSet();

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}

		} else {
			int count = stmt.getUpdateCount();
			System.out.println(count + " Records Affected!!!!");
		}

		sc.close();
		con.close();

	}
}
