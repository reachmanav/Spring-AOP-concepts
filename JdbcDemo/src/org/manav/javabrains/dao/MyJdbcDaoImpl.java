package org.manav.javabrains.dao;

import org.manav.javabrains.model.Circle;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MyJdbcDaoImpl extends JdbcDaoSupport {

	public void insertCircleObject (Circle circle)  {
		
		String sql = "insert into CIRCLE (ID, NAME) VALUES (?,?)";
		this.getJdbcTemplate().update(sql, new Object[] {circle.getId(), circle.getName()});
	}
	
	
}
