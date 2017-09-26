package app.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import app.common.base.ExecuteResult;
import app.home.model.User;
import app.home.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	private UserService thisService;
	private ExecuteResult executeResult = new ExecuteResult();
	private String viewPath = "App/Admin/User/";

	public UserService getUserService() {
		return thisService;
	}

	@Autowired
	public void setUserService(UserService thisService) {
		this.thisService = thisService;
	}

	@RequestMapping("/index")
	public String showAllList(HttpServletRequest request){
		try {
			List<User> list = thisService.select();
			System.out.println(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
			request.setAttribute("list", list);
			return viewPath + "index";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	// 访问形式：http://localhost:8080/BJUI_SSM_CMS/user/show.do?uid=1
	@RequestMapping("/show")
	public String showUser(String uid, HttpServletRequest request) {
		User info = thisService.find(uid);
		System.out.println(JSON.toJSONStringWithDateFormat(info, "yyyy-MM-dd HH:mm:ss"));
		request.setAttribute("info", info);
		return viewPath + "showUser";
	}
	
	// 访问形式：http://localhost:8080/BJUI_SSM_CMS/user/1/show.do
	@RequestMapping("/{id}/show")
	public String showUser2(@PathVariable String id, HttpServletRequest request) {
		User info = thisService.find(id);
		request.setAttribute("info", info);
		return "App/Admin/User/showUser";
	}
	
	@RequestMapping("/edit")
	public String modify(String uid,HttpServletRequest request){
		try {
			User info = thisService.find(uid);
			request.setAttribute("info", info);
			return viewPath + "edit";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(User info){
		try {
			if(thisService.save(info) == 1)
				return executeResult.jsonReturn(200);
			else
				return executeResult.jsonReturn(300);
		} catch (Exception e) {
			e.printStackTrace();
			return executeResult.jsonReturn(300, e.getMessage());
		}
	}

}