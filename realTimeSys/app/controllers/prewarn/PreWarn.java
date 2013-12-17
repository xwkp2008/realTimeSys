package controllers.prewarn;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.log.logDetail;
import views.html.prewarn.prewarnLogDetail;
import views.html.prewarn.warnEdit;

public class PreWarn extends Controller{
	// 预警设置列表
	public static Result makeWarn() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/prewarnList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// 编辑预警
	public static Result editWarn(){
		return ok(warnEdit.render(""));
	}
	
	// 预警信息列表
	public static Result warnInfoList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/prewarnInfoList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// 短信信息列表
	public static Result warnLogList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/prewarnLogList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// 查看短信日志详细
	public static Result warnLogDetail(){
		return ok(prewarnLogDetail.render(""));
	}
}
