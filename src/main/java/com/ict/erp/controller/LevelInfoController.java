package com.ict.erp.controller;
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 import com.ict.erp.service.LevelInfoService;
import com.ict.erp.vo.LevelInfo;
 
@Controller
public class LevelInfoController {
 	@Autowired
	private LevelInfoService lis;
 	@RequestMapping(value="/levelinfo",method=RequestMethod.GET)
	public String getLevelInfoList(
			 @ModelAttribute LevelInfo li,
			Model m) {
		m.addAttribute("liList", lis.getLevelInfoList(li));
		return "levelinfo/list";
	}
 	
 	@RequestMapping(value="/levelinfo",method=RequestMethod.POST)
	@ResponseBody 
	public String insertLevelInfoList(
			 LevelInfo li,
			Model m) {
		//m.addAttribute("iCnt", lis.insertLevelInfo(li)); 		
		System.out.println(li);
		return "" + lis.insertLevelInfo(li); 
	}
 	
 	@RequestMapping(value="/levelinfo/{linum}",method=RequestMethod.DELETE)
	@ResponseBody 
	public String deleteLevelInfoList(
			@PathVariable int linum,
			Model m) {
		System.out.println(linum);
		System.out.println("타나");
		return lis.deleteLevelInfo(linum)+""; 
	}
	/*@RequestMapping(value="/levelinfo2",method=RequestMethod.GET)
	public @ResponseBody String getLevelInfoList2(
			 @ModelAttribute LevelInfo li) {
		return lis.getLevelInfoList(li).toString();
	}
	@RequestMapping(value="/levelinfo3",method=RequestMethod.GET)
	public @ResponseBody List<LevelInfo> getLevelInfoList3(
			 @ModelAttribute LevelInfo li) {
		return lis.getLevelInfoList(li);
	}*/
}