package controllers.process;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;

public class Process extends Controller{
	// 进程信息列表
	public static Result list() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/processList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	
}
