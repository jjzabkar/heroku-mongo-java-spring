package com.jjz.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import com.jjz.domain.Foo;
import com.jjz.service.FooService;

/**
 * {@link Controller} that declares {@link RequestMapping} endpoints to allow a client to interact with a business {@code Service}.
 * 
 * @author JJ Zabkar
 */
@Controller
public class FooController {

	@Inject
	FooService svc;

	@RequestMapping(value = "/foo/{uuid}", method = GET)
	@ResponseBody
	public Foo getFooByUuid(@PathVariable("uuid") UUID uuid) {
		return svc.getFoo(uuid);
	}

	@RequestMapping(value = "/foo", method = GET)
	@ResponseBody
	public String getFooOne() {
		UUID one = UUID.randomUUID();
		Foo foo = getFooByUuid(one);
		return "Hello from FooController at " + new Date() + ".  \n<br/>"//
				+ "foo/" + one + " = " + foo.toString();
	}

	@RequestMapping(value = "/foos", method = GET)
	@ResponseBody
	public List<Foo> getFoos() {
		return svc.getFoos();
	}

}
