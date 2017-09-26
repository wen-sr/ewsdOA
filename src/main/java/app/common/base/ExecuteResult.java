package app.common.base;

import java.util.HashMap;
import java.util.Map;

public class ExecuteResult {
	
	public Map<String, Object> jsonReturn(int statusCode) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();
		if(statusCode == 200) {
			jsonObj.put("statusCode", "200");
			jsonObj.put("message", "操作成功");
		} else if (statusCode == 300) {
			jsonObj.put("statusCode", "300");
			jsonObj.put("message", "操作失败，请重试");
		}
		jsonObj.put("closeCurrent", true);
		return jsonObj;
	}
	
	public Map<String, Object> jsonReturn(int statusCode, boolean closeCurrent) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();
		if(statusCode == 200) {
			jsonObj.put("statusCode", "200");
			jsonObj.put("message", "操作成功");
		} else if (statusCode == 300) {
			jsonObj.put("statusCode", "300");
			jsonObj.put("message", "操作失败，请重试");
		}
		jsonObj.put("closeCurrent", closeCurrent);
		return jsonObj;
	}
	
	public Map<String, Object> jsonReturn(int statusCode, String msg) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();
		if(statusCode == 200) {
			jsonObj.put("statusCode", "200");
			jsonObj.put("message", "操作成功 " + msg);
		} else if (statusCode == 300) {
			jsonObj.put("statusCode", "300");
			jsonObj.put("message", "操作失败:" + msg);
		}
		jsonObj.put("closeCurrent", true);
		return jsonObj;
	}
	
	public Map<String, Object> jsonReturn(int statusCode, String msg, boolean closeCurrent) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();
		if(statusCode == 200) {
			jsonObj.put("statusCode", "200");
			jsonObj.put("message", "操作成功 " + msg);
		} else if (statusCode == 300) {
			jsonObj.put("statusCode", "300");
			jsonObj.put("message", "操作失败:" + msg);
		}
		jsonObj.put("closeCurrent", closeCurrent);
		return jsonObj;
	}
	
}
