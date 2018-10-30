/*package com.ict.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ict.erp.service.UserInfoService;
import com.ict.erp.vo.UserInfo;


@Controller

public class UserInfoController {

@Autowired

private UserInfoService ui;



// GET selectUserList

@RequestMapping(value="/userinfo", method=RequestMethod.GET)

public @ResponseBody List<UserInfo> selectUserList(@ModelAttribute UserInfo ui) {

return us.getUserList(ui);

}



//GET selectUser

@RequestMapping(value="/userinfo/{uinum}", method=RequestMethod.GET)

public @ResponseBody UserInfo selectUser(@PathVariable Integer uinum) {

return us.getUser(uinum);

}



//POST insertUserList

@RequestMapping(value="/userinfo", method=RequestMethod.POST)

public @ResponseBody int insertUserList(@RequestBody UserInfo ui) {

return us.insertUser(ui);

}



//POST 404 error

@RequestMapping(value="/userinfo/{uinum}", method=RequestMethod.POST)

public String insertUser(Model m,@ModelAttribute UserInfo ui) {

m.addAttribute("ui", us.insertUser(ui));

return "/userinfo/erro";

}



//PUT updateUserList

@RequestMapping(value="/userinfo", method=RequestMethod.PUT)

public @ResponseBody String updateUserList(@RequestBody UserInfo ui,Model m) {

m.addAttribute("ulist",us.updateUser(ui));

return "ulist";

}



//PUT updateUser

@RequestMapping(value="/userinfo/{uinum}", method=RequestMethod.PUT)

public @ResponseBody Integer updateUser(@RequestBody UserInfo ui, @PathVariable Integer uinum) {

ui.setUinum(uinum);

return us.updateUser(ui);

}



//DELETE deleteUserList

@RequestMapping(value="/userinfo", method=RequestMethod.DELETE)

public @ResponseBody String deleteUserList(@PathVariable int uinum) {

return us.deleteUser(uinum)+"";

}



//DELETE deleteUser

@RequestMapping(value="/userinfo/{uinum}", method=RequestMethod.DELETE)

public @ResponseBody String deleteUser(@PathVariable int uinum) {

return us.deleteUser(uinum)+"";

}
}*/