package app.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import app.common.base.ExecuteResult;
import app.home.model.Config;
import app.home.service.ConfigService;

@Controller
@RequestMapping("/Config")
public class ConfigController extends BaseController {

	private ConfigService thisService;
	private ExecuteResult executeResult = new ExecuteResult();
	
	@Value("${jdbc_url}")
	private String aa;
	
	private String viewPath = "App/Admin/Config/";

	public ConfigService getConfigService() {
		return thisService;
	}

	@Autowired
	public void setConfigService(ConfigService thisService) {
		this.thisService = thisService;
	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		try {
			List<Config> list = thisService.select();
			System.out.println(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
			request.setAttribute("list", list);
			System.out.println(aa);
			controllerName();
			return viewPath + "index";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("/show")
	public String show(String id, HttpServletRequest request) {
		Config info = thisService.find(id);
		System.out.println(JSON.toJSONStringWithDateFormat(info, "yyyy-MM-dd HH:mm:ss"));
		request.setAttribute("info", info);
		return viewPath + "showConfig";
	}
	
	@RequestMapping("/edit")
	public String edit(String id,HttpServletRequest request){
		try {
			Config info = thisService.find(id);
			request.setAttribute("info", info);
			return viewPath + "add";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(Config info){
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