package controllers.system.privilege;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.system.privilege.staffConfig;

public class Staff extends Controller{
	// 成员列表
	public static Result list() {
		return ok(staffConfig.render(""));
    }
}
