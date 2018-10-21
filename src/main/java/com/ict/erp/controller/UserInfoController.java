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

/*import com.ict.erp.service.UserInfoService;
import com.ict.erp.vo.UserInfo;
*/

@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService lis;
	
		//Resource userinfo
	@RequestMapping(value="/Userinfo",method=RequestMethod.GET)
		public @ResponseBody List<UserInfo> getUserInfoList(@ModelAttribute UserInfo ui) {
			return lis.getUserInfoList(ui);
		}
		
		//Resource userinfo/{uinum}
	@RequestMapping(value="/Userinfos/{uinum}",method=RequestMethod.GET)
		public @ResponseBody UserInfo getUserInfo(@PathVariable Integer uinum) {
			return lis.getUserInfo(uinum);
		}
	
	//GET selectUserList
	@RequestMapping(value="/Userinfo",method=RequestMethod.GET)
	public @ResponseBody List<UserInfo> selectUserList(@ModelAttribute UserInfo ui) {
		return lis.getUserInfoList(ui);
	}
	
	//GET selectUser
	@RequestMapping(value="/Userinfos/{uinum}",method=RequestMethod.GET)
	public @ResponseBody UserInfo selectUser(@PathVariable Integer uinum) {
		return lis.getUserInfo(uinum);
	}

	//POST insertUserList
	@RequestMapping(value="/Userinfos",method=RequestMethod.POST) 
	public @ResponseBody List<UserInfo> insertUserList(@ModelAttribute UserInfo ui) {
	return lis.insertUserInfo(ui); 
	}

	//POST 404error
	@RequestMapping(value="/Userinfos/{uinum}",method=RequestMethod.POST)
	@ResponseBody 
	public Integer insertUserInfo(@RequestBody UserIn ui) {	//UserIn는 404 에러 내기위해 일부러
		return lis.insertUserInfo(ui); 
	}
	
	//PUT updateUserList
	@RequestMapping(value="/Userinfos/{uinum}",method=RequestMethod.PUT)
	@ResponseBody 
	public List<UserInfo> updateUserList(@ModelAttribute UserInfo ui) {
		return lis.updateUserInfo(ui);
	}
	
	//PUT updateUser
	@RequestMapping(value="/Userinfos/{uinum}",method=RequestMethod.PUT)
	@ResponseBody 
	public Integer updateUser(@RequestBody UserInfo ui,@PathVariable Integer uinum) {
		li.setLinum(uinum);
		return lis.updateUserInfo(ui);
	}
	
	//DELETE deleteUserList
	@RequestMapping(value="/Userinfo",method=RequestMethod.DELETE)
	public @ResponseBody List<UserInfo> deleteUserList(@ModelAttribute UserInfo ui) {
		return lis.deleteUserInfo(ui)+"";
	}

	//DELETE deleteUser
		@RequestMapping(value="/Userinfos/{uinum}",method=RequestMethod.DELETE)
		@ResponseBody 
		public String deleteUserInfo(@PathVariable int uinum) {
			return lis.deleteUserInfo(uinum)+""; 
		}
	
}