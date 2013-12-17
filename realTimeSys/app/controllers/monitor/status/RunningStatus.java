package controllers.monitor.status;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.monitor.status.*;

public class RunningStatus extends Controller {
	// 总览
	public static Result overview(){
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/overview.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
	}
	
	// 总览详情
	public static Result overviewDetail(){
		return ok(overviewDetail.render(""));
	}
	
	// 内存运行状态一览
	public static Result memory() {
		return ok(memory.render(""));
    }
	
	// 硬盘存储状态一览
	public static Result storage() {
		return ok(storage.render(""));
    }
	
	// 硬盘存储状态一览
	public static Result storageFrame() {
		return ok(storageFrame.render(""));
    }
	
	// CPU状态一览
	public static Result CPU() {
		return ok(CPU.render(""));
    }
	
	// 网络状态一览
	public static Result network() {
		return ok(network.render(""));
    }
	
}
