package com.zoudys;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.zoudys.config.AppConfig;
import com.zoudys.model.Article;

public class App {

	public static void main(String[] args) throws UnknownHostException {

		 ApplicationContext ctx = new
		 ClassPathXmlApplicationContext("spring-context.xml");
		
		MongoOperations ops = ctx.getBean("mongoTemplate", MongoOperations.class);
		
		//AppConfig appConfig = new AppConfig();
		//MongoOperations ops = appConfig.mongoOperations();
		
		// Create article
		Article article = new Article();
		article.setAuthorId(UUID.randomUUID());
		article.setAuthor("Chris");
		article.setDate(new Date());
		article.setTitle("Hello Chris");

		// insert
		ops.insert(article);

	}

}
