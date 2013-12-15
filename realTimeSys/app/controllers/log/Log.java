package controllers.log;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.log.logDetail;

public class Log extends Controller{
	// 角色列表
	public static Result list() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/logList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// 查看日志详细
	public static Result detail(){
		return ok(logDetail.render(""));
	}
}
