package controllers.system.monitorsys;

import java.io.File;
import java.util.List;
import java.util.Map;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.json.JSONUtils;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.system.monitorsys.czxt.czxtAdd;
import views.html.system.monitorsys.czxt.czxtEdit;
import views.html.system.monitorsys.sjk.sjkList;
import views.html.system.monitorsys.sjk.odbAdd;
import views.html.system.monitorsys.sjk.odbEdit;
import views.html.system.monitorsys.czxt.czxtInfo;
import views.html.system.monitorsys.fwjc.fwjcEdit;
import views.html.system.monitorsys.fwjc.fwjcAdd;
import views.html.system.monitorsys.qxyh.qlist;
import views.html.system.monitorsys.qxyh.qxyhList;

public class MonitorSys extends Controller{
	// 操作系统监控列表
	public static Result operaList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/operaList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	//添加操作系统监控对象
	public static Result operaAdd(){
		return ok(czxtAdd.render(""));
	}
	//编辑操作系统监控对象
	public static Result operaEdit(){
		return ok(czxtEdit.render(""));
	}
	
	// 数据库监控列表
	public static Result dbList(String type) {
		String jsonFilePath = "/app/controllers/json/odbList.json";
		if("informix".equals(type)){
			jsonFilePath = "/app/controllers/json/idbList.json";
		}
		File jsonFile = Play.application().getFile(jsonFilePath);
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(sjkList.render(list.render(jsonStr).toString()));
    }
	//添加oracle数据库监控对象
	public static Result odbAdd(){
		return ok(odbAdd.render(""));
	}
	//编辑oracle数据库监控对象
	public static Result odbEdit(){
		return ok(odbEdit.render(""));
	}
	
	public static Result odbList() {
		String jsonFilePath = "/app/controllers/json/odbList.json";
		File jsonFile = Play.application().getFile(jsonFilePath);
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	public static Result idbList() {
		String jsonFilePath = "/app/controllers/json/idbList.json";
		File jsonFile = Play.application().getFile(jsonFilePath);
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	//当前操作系统信息
	public static Result czxtInfo(){
		return ok(czxtInfo.render(""));
	}
	
	//当前操作系统信息
	public static Result cjOperaAdd(){
		return ok(views.html.system.monitorsys.qxyh.cjOperaAdd.render(""));
	}
	
	//采集软件的系统
	public static Result cjOperaList(String reload) {
		String jsonFilePath = "/app/controllers/json/cjOperaList.json";
		File jsonFile = Play.application().getFile(jsonFilePath);
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
			if(reload != null){
				List<Map<String, Object>> list = JSONUtils.list(jsonStr, "$.data");
				for(int i=0;i<5;i++){
					list.add(list.get(0));
				}
				jsonStr = JSONUtils.merge(jsonStr, "$", "data",list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	//服务进程对象列表
	public static Result fwjcList() {
		String jsonFilePath = "/app/controllers/json/fwjcList.json";
		File jsonFile = Play.application().getFile(jsonFilePath);
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }

	//建立服务进程对象
	public static Result fwjcAdd(){
		return ok(fwjcAdd.render(""));
	}
	//编辑服务进程对象
	public static Result fwjcEdit(){
		return ok(fwjcEdit.render(""));
	}
	
	// ip和权限用户主页
	public static Result qxyhList() {
		String jsonFilePath = "/app/controllers/json/qxyhList.json";
		File jsonFile = Play.application().getFile(jsonFilePath);
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(qxyhList.render(qlist.render(jsonStr).toString()));
    }
	
	// ip和权限用户列表
	public static Result qxyhdataList(String id) {
		String jsonFilePath = "/app/controllers/json/qxyhList.json";
		File jsonFile = Play.application().getFile(jsonFilePath);
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
			List<Map<String, Object>> list = JSONUtils.list(jsonStr, "$.data[?(@.type=='"+id+"')]");
			jsonStr = JSONUtils.merge(jsonStr, "$", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(qlist.render(jsonStr).toString());
    }
	//新增ip和权限用户
		public static Result qxyhAdd(){
		return ok(views.html.system.monitorsys.qxyh.qxyhAdd.render(""));
	}
	//编辑ip和权限用户
	public static Result qxyhEdit(){
		return ok(views.html.system.monitorsys.qxyh.qxyhEdit.render(""));
	}
}
