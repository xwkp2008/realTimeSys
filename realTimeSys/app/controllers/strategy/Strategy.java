package controllers.strategy;

import java.io.File;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import tng.ark.common.util.FileUtils;
import views.html.list;
import views.html.strategy.stype.strategyAdd;
import views.html.strategy.stype.strategyEdit;
import views.html.strategy.stype.strategyUpdate;
import views.html.strategy.stype.typeAdd;
import views.html.strategy.stype.typeEdit;

public class Strategy extends Controller{
	// 策略分类列表
	public static Result typeList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/strategyTypeList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// 添加分类
	public static Result addType(){
		return ok(typeAdd.render(""));
	}
	
	// 编辑分类
	public static Result editType(){
		return ok(typeEdit.render(""));
	}
	
	// 策略列表
	public static Result strategyList() {
		File jsonFile = Play.application().getFile(
				"/app/controllers/json/strategyList.json");
		String jsonStr = "{}";
		try {
			jsonStr = FileUtils.readFileToString(jsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(list.render(jsonStr));
    }
	
	// 添加策略
	public static Result addStrategy(){
		return ok(strategyAdd.render(""));
	}
	
	// 编辑策略
	public static Result editStrategy(){
		return ok(strategyEdit.render(""));
	}
	
	// 更新策略
	public static Result updateStrategy(){
		return ok(strategyUpdate.render(""));
	}
}
