package controllers.monitor.status;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.monitor.status.memory;

public class Memory extends Controller {
	// 内存运行状态一览
	public static Result index() {
		return ok(memory.render(""));
    }
}
