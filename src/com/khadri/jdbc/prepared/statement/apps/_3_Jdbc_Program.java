package com.khadri.jdbc.prepared.statement.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class _3_Jdbc_Program {

	public static void main(String[] args) throws Exception {

		boolean decision = false;
		do {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

			PreparedStatement pstmt = con.prepareStatement("delete from customer where name=?");

			System.out.println("Please enter customer name: ");
			String name = sc.next();

			pstmt.setString(1, name);

			int count = pstmt.executeUpdate();

			System.out.println(count + " Rows Affected!!!!");

			System.out.println("Do you want to continue ?(YES/NO) ");
			String wish = sc.next();

			if (wish.equalsIgnoreCase("YES")) {
				decision = true;
			} else if (wish.equalsIgnoreCase("NO")) {
				decision = false;
			}

		} while (decision);

	}
}
