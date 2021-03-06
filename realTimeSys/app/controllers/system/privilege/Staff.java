package controllers.system.privilege;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.system.privilege.staff.*;

public class Staff extends Controller{
	// 成员列表
	public static Result list() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/staffList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// 详情
	public static Result detail(){
		return ok(staffDetail.render(""));
	}
	
	// 添加人员
	public static Result add(){
		return ok(staffAdd.render(""));
	}
	
	// 修改人员
	public static Result edit(){
		return ok(staffEdit.render(""));
	}
}
