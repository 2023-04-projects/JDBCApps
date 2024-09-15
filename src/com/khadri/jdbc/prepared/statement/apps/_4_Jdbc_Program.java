package com.khadri.jdbc.prepared.statement.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class _4_Jdbc_Program {

	public static void main(String[] args) throws Exception {

		boolean decision = false;
		Scanner sc = new Scanner(System.in);
		do {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

			PreparedStatement pstmt = con.prepareStatement("insert into customer values(?,?,?,?,?)");

			System.out.println("Please enter customer id: ");
			int id = sc.nextInt();

			System.out.println("Please enter customer name: ");
			String name = sc.next();

			Date currentDate = new Date();

			java.sql.Date date = new java.sql.Date(currentDate.getTime());
			Time time = new Time(currentDate.getTime());
			Timestamp timestamp = new Timestamp(currentDate.getTime());

			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setDate(3, date);
			pstmt.setTime(4, time);
			pstmt.setTimestamp(5, timestamp);

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

		sc.close();

	}
}
