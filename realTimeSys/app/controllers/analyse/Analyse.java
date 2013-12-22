package controllers.analyse;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.analyse.sqlCollect;

public class Analyse extends Controller {
	// sql记录采集
	public static Result sqlCollect() {
		return ok(sqlCollect.render(""));
    }
	
	// sql记录采集
	public static Result sqlDetail() {
		return ok(views.html.analyse.sqlDetail.render(""));
    }
	
	// sql优化分析
	public static Result sqlAnalyse() {
		return ok(views.html.analyse.sqlAnalyse.render(""));
    }
	
}
