package com.hugui.springmvc.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JDBCUtils {

	public static DataSource getDataSource() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"WebRoot/WEB-INF/springmvc-servlet.xml");

		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		
		return dataSource;
	}
	
	
	public static void closeConnection(Connection connection) throws SQLException{
		if(connection != null){
			connection.close();
		}
	}
}
