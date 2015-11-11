package com.crsms.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl<T> implements GenericDao<T> {
	private static Logger log = LogManager.getLogger(GenericDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;

	@Override
	public Integer getRowsCount() {
		Integer rowsCount = null;
		try {
			rowsCount = (Integer) sessionFactory.getCurrentSession()
					.createCriteria(clazz)
					.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {
			log.error("Error get rowsCount " + e);
		}

		return rowsCount;
	}
}
