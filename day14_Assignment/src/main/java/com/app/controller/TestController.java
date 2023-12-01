package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Mandatory class level annotation to specify
public class TestController {
public TestController() {
	System.out.println("In ctor of"+getClass());
	}
// add request handling method to display welcome message to client
@RequestMapping("/test1")
//mandatory method level annotation
//HandlerMapping bean,Key:/test1
public String testMe1() {
	System.out.println("In testme1");
	return "/display";// actual view name: /WEB-INF/views/display.jsp
}

}
