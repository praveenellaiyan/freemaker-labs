/**
 * 
 */
package com.practice.productmanagement.controller;

import static com.practice.productmanagement.utils.PathConstant.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Praveen Ellaiyan
 *
 */
@Controller
public class HomeController {

	@Value("${spring.application.name}")
	private String application;

	@RequestMapping(path = { ROOT_CONTEXT, INDEX })
	public String index(Model model) {
		model.addAttribute("application", application);
		return "index";
	}

	@RequestMapping(path = HEALTH_CHECK)
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<String>("All Good!", HttpStatus.OK);
	}

}
