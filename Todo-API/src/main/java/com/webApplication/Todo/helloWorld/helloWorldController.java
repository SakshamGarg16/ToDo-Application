package com.webApplication.Todo.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {

	@Autowired
	private MessageSource message;

	@GetMapping("/basicauth")
	public String basicauth() {
		return "successfull";
	}

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	public helloWorldBean helloWorldBean() {
		return new helloWorldBean("Hello World");
	}

	@GetMapping(path = "/hello-world/pathvar/{name}")
	public helloWorldBean helloWorldpathvari(@PathVariable String name) {
		return new helloWorldBean(String.format("Hello World %s", name));
	}

	@GetMapping("/hello-world-interlizatied")
	public String helloWorldinterlizatied() {

		Locale locale = LocaleContextHolder.getLocale();
		return message.getMessage("good.morning.message", null, "Default message", locale);

	}

}
