package com.crsms.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DbPopulator extends ResourceDatabasePopulator {
	private static final ResourceLoader RESOURCE_LOADER = new DefaultResourceLoader();

	public DbPopulator() {
	}

	@Autowired
	private DataSource dataSource;

	public DbPopulator(String scriptLocation) {
		super(RESOURCE_LOADER.getResource(scriptLocation));
	}

	public void execute() {
		DatabasePopulatorUtils.execute(this, dataSource);
	}
}
