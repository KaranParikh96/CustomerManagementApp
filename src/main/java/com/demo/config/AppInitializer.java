package com.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	public AppInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		Class dbConfig[] = {DBConfig.class};
		return dbConfig;
		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class aConfig[] = {AppConfig.class};
		return aConfig;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		String path[]= {"/"};
		return path;
	}

}
