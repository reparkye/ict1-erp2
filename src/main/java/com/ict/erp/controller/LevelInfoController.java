package com.ict.erp.controller;
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 	
 	
 	@RequestMapping(value="/levelinfo",method=RequestMethod.GET)   //겟방식은 바디 사용불가 로 ?로 해줌
 	/*public String getLevelInfoList(
			 @ModelAttribute LevelInfo li, Model m) {
		m.addAttribute("liList", lis.getLevelInfoList(li));
		return "levelinfo/list";     */
 	public @ResponseBody List<LevelInfo> getLevelInfoList(@ModelAttribute LevelInfo li){	//@ form 
 		return lis.getLevelInfoList(li);
	}
 	
 	@RequestMapping(value="/levelinfo/{linum}",method=RequestMethod.GET)
 	public @ResponseBody LevelInfo getLevelInfo(@PathVariable Integer linum) {	//{linum} 을 @pathvar.. 에다가 넣어준다.
 		return lis.getLevelInfo(linum);
 	}
 	
 	
 	@RequestMapping(value="/levelinfo",method=RequestMethod.POST)
	@ResponseBody 	//!!!!!!!!!!!!!!!!! 반드시 이해하기 없으면 뷰 리졸버를 타게된다. 있으면 json
	
	public Integer insertLevelInfo(@RequestBody LevelInfo li) {
		return lis.insertLevelInfo(li); 
	}
 	
 	
 	@RequestMapping(value="/levelinfo/{linum}",method=RequestMethod.PUT)
	@ResponseBody 
	public Integer updateLevelInfoList(@RequestBody LevelInfo li, @PathVariable Integer linum) {
		li.setLinum(linum);
		return lis.updateLevelInfo(li); 
	}
 	
 	
 	@RequestMapping(value="/levelinfo/{linum}",method=RequestMethod.DELETE)
	@ResponseBody 
	/*public String deleteLevelInfoList(
			@PathVariable int linum,
			Model m) {
		System.out.println(linum);*/
	public String deleteLevelInfoList(@PathVariable int linum) {
		return lis.deleteLevelInfo(linum)+""; 
	}
 	
 
 	@RequestMapping(value="/levelinfos",method=RequestMethod.PUT)
	@ResponseBody
	public Integer deleteLevelInfoList(@RequestBody List<LevelInfo> delList) {
 		System.out.println(delList);
 		return delList.size();
 	}
}