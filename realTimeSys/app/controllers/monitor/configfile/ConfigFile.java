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
}
