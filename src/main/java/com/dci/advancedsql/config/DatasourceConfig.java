package com.dci.advancedsql.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatasourceConfig {

	private static String jdbc_url =  "jdbc:postgresql://localhost:5432/";
	private static String db_name = "group-project";
	private static String username = "postgres";
	private static String password = "pgAdmin";
	
	@Primary
	@Bean
	Statement getStatement() throws Exception {
		try
		{
			Connection connection = DriverManager.getConnection(jdbc_url + db_name, username, password);
				Statement statement = connection.createStatement();
				return statement;
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
}
