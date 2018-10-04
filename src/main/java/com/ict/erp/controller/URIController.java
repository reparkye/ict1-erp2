package com.ict.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller						//levelinfo 저장역할
public class URIController {

	@RequestMapping(value="/url/{path}",method=RequestMethod.GET)
	public String goPage(@PathVariable String path) {
		path = path.replace(":", "/");		// path에서  / 인것을 찾을수없으므로 : 바꿈 
		return path;
	}
}
