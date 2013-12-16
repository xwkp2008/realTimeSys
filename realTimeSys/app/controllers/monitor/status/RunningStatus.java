package controllers.monitor.status;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.monitor.status.*;

public class RunningStatus extends Controller {
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
	
}
