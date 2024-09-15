package com.khadri.jdbc.metadata.parameter;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;

public class _1_Jdbc_MetaData_Parameter {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2024_batch", "root", "root");

		CallableStatement callable = con.prepareCall("call CALC_PROC(?,?)");
		callable.setInt(1, 100);
		callable.setInt(2, 100);
		callable.execute();

		ParameterMetaData parameterMetaData = callable.getParameterMetaData();
		int count = parameterMetaData.getParameterCount();
		System.out.println("parameter count " + count);

		for (int i = 1; i <= count; i++) {
			System.out.println(parameterMetaData.getParameterMode(i));
			System.out.println(parameterMetaData.getParameterClassName(i));
			System.out.println(parameterMetaData.getParameterType(i));
			System.out.println(parameterMetaData.getParameterTypeName(i));
			System.out.println(parameterMetaData.getPrecision(i));
			System.out.println(parameterMetaData.getScale(i));
		}

	}
}
