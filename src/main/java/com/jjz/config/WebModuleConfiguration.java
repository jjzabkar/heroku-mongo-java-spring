package com.jjz.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

/**
 * Spring context {@code Configuration} that configures the root Spring context.
 * <p>
 * Does <b>NOT</b> load {@link Controller}s; that is the job of {@link WebMvcConfiguration}.
 */
@Configuration
// @Import({PropertiesConfiguration.class, OtherConfiguration.class})
@ComponentScan(basePackages = { "com.jjz" }, excludeFilters = @ComponentScan.Filter({ Controller.class, Configuration.class }))
public class WebModuleConfiguration {

	Logger logger = LoggerFactory.getLogger(getClass());

	public WebModuleConfiguration() {
		logger.info("init");
	}

	@Bean
	public DB mongoDb() throws UnknownHostException, MongoException {
		logger.info("connecting to db");
		MongoURI mongoURI = new MongoURI(System.getenv("MONGOHQ_URL"));
		assert mongoURI != null : "missing MONGOHQ_URL";
		DB db = mongoURI.connectDB();
		db.authenticate(mongoURI.getUsername(), mongoURI.getPassword());

		logger.info("connected to db");

		Set<String> colls = db.getCollectionNames();
		logger.info("Collections found in DB (Spring Configuration): " + colls.toString());

		return db;
	}
}
