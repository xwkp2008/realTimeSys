package controllers.system.privilege;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.system.privilege.menu.menuAdd;
import views.html.system.privilege.menu.*;

public class Menu extends Controller{
	// 菜单列表
	public static Result list() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/menuList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// 添加菜单
	public static Result add(){
		return ok(menuAdd.render(""));
	}
	
	// 修改菜单
	public static Result edit(){
		return ok(menuEdit.render(""));
	}
	
}
