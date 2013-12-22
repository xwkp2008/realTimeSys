package controllers.monitor.history;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.monitor.history.*;

public class History extends Controller {
	// 系统资源占用趋势
	public static Result resource(){
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/overview.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(resource.render(jsonStr));
	}
	
	// 总览详情
	public static Result database(){
		return ok(database.render(""));
	}
	
	// 内存运行状态一览
	public static Result process() {
		return ok(process.render(""));
    }
}
