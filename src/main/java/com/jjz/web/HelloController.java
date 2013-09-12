package com.jjz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Set;

import javax.inject.Inject;

import com.mongodb.DB;

@Controller
public class HelloController {

	@Inject
	DB db;

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		Set<String> colls = db.getCollectionNames();

		return "Hello from HelloController at " + new Date() + ".  \n<br/>"//
				+ "Collections found in DB: " + colls.toString();
	}
}
