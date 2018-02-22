
package org.manav.javabrains;

import org.manav.javabrains.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {

	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService =ctx.getBean("shapeService", ShapeService.class);
		
		shapeService.getCircle().setName("dummy name");
		System.out.println(shapeService.getCircle().getName());
	}

}
