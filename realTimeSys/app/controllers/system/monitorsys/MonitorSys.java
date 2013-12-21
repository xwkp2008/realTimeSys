package controllers.system.monitorsys;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.system.monitorsys.czxt.czxtAdd;
import views.html.system.monitorsys.czxt.czxtEdit;
import views.html.system.monitorsys.sjk.sjkList;
import views.html.system.monitorsys.sjk.odbAdd;
import views.html.system.monitorsys.sjk.odbEdit;
import views.html.system.monitorsys.czxt.czxtInfo;

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
}
