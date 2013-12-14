package controllers.system.privilege;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.system.privilege.role.*;
import views.html.system.privilege.assignPrivilege;

public class Role extends Controller{
	// 角色列表
	public static Result list() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/roleList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// 添加角色
	public static Result add(){
		return ok(roleAdd.render(""));
	}
	
	// 修改角色
	public static Result edit(){
		return ok(roleEdit.render(""));
	}
	
	// 分配权限
	public static Result assignPrivilege(){
		return ok(assignPrivilege.render(""));
	}
}
