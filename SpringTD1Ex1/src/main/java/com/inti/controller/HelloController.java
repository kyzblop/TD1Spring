package com.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "helloWorld", method = RequestMethod.GET)
	public ModelAndView helloWorld(ModelAndView model) {
		model = new ModelAndView("helloWorld");
		String prenom = "Pierre";
		model.addObject("name", prenom);
		return model;
	}
}
