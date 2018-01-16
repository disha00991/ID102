package com.myapp.spring.di;

import java.sql.Connection;

public interface DataSourceBean {
	public Connection getConnection();
}
