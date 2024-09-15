package com.khadri.jdbc.batch.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class _1_Jdbc_BatchUpdate {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch", "root", "root");

		PreparedStatement pstmt = con.prepareStatement("insert into customer(id,name) values(?,?)");

		for (int i = 0; i < 5; i++) {
			System.out.println("Please enter customer id: ");
			int id = sc.nextInt();
			System.out.println("Please enter customer name: ");
			String name = sc.next();
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.addBatch();
		}

		int[] count = pstmt.executeBatch();

		System.out.println(count[0] + " Batch Affected!!!!");
		sc.close();

	}
}
