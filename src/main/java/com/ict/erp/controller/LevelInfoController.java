package com.ict.erp.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ict.erp.service.LevelInfoService;
import com.ict.erp.vo.LevelInfo;

@Controller
public class LevelInfoController {
	
	@Autowired
	private LevelInfoService ls;
	
	@RequestMapping(value="/levelinfo", method=RequestMethod.GET)
	public String getLevelInfoList(@ModelAttribute LevelInfo li, Model m) {
		System.out.println(li);
		m.addAttribute("liList",ls.getLevelInfoList(li));
		return "levelinfo/list";  
	}
	
	@RequestMapping(value="/levelinfo", method=RequestMethod.POST)
	public String getLevelInsert(@ModelAttribute LevelInfo li, Model m) {
		System.out.println(li);
		m.addAttribute("iCnt",ls.insertLevelInfo(li));
		return "levelinfo/list";  
	}
	
	
	
	@RequestMapping(value="/levelinfo", method=RequestMethod.PUT)
	public String getLevelUpdate(@ModelAttribute LevelInfo li, Model m) {
		System.out.println(li);
		m.addAttribute("upd",ls.updateLevelInfo(li));
		return "levelinfo/list";  
	}
	
	
	@RequestMapping(value="/levelinfo/{linum}", method=RequestMethod.DELETE)
	public String getLevelDelete(@PathVariable int linum, Model m) {
		System.out.println(linum);
		return ls.deleteLevelInfo(linum)+"";  
	}
	
}
