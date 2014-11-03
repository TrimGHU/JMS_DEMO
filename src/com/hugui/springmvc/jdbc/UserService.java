package com.hugui.springmvc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserService {
	
	public static DataSource getDataSource() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"WebRoot/WEB-INF/springmvc-servlet.xml");

		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		
		return dataSource;
	}

	public static void main(String[] args) {
		DataSource dataSource = getDataSource();

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery("select * from user");

			while (rs.next()) {
				System.out.print("ID=" + rs.getString("id"));
				System.out.print("用户名=" + rs.getString("username"));
				System.out.print("密码=" + rs.getString("password"));
				System.out.println("年龄=" + rs.getString("age"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				
				if(statement != null){
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}