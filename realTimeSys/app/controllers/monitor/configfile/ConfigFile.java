package controllers.monitor.configfile;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;

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
	
	
}
