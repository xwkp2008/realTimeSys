package controllers.monitor.configfile;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.monitor.configfile.dbParamList;

public class ConfigFile extends Controller{
	// 操作系统参数列表
	public static Result sysParamList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/sysParamList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	// 数据库参数主页
	public static Result dbParamList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/OParamList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(dbParamList.render(list.render(jsonStr).toString()));
    }
	
	// ORACLE参数列表
	public static Result OParamList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/OParamList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// informix参数列表
	public static Result IParamList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/IParamList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }

	// 进程参数列表
	public static Result jcparamList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/jcparamList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	//新增进程参数
	public static Result jcparamAdd(){
		return ok(views.html.monitor.configfile.jcparamAdd.render(""));
	}
	//编辑进程参数
	public static Result jcparamEdit(){
		return ok(views.html.monitor.configfile.jcparamEdit.render(""));
	}
	//加载进程参数
	public static Result loadJcparam(){
		return ok(views.html.monitor.configfile.loadJcparam.render(""));
	}
}
