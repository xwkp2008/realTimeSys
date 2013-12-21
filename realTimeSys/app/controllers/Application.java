package controllers;

import java.io.File;

import play.*;
import play.mvc.*;
import tng.ark.common.json.JSONUtils;
import tng.ark.common.json.JSONUtils.ListCallback;
import tng.ark.common.util.FileUtils;
import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
    	File jsonFile = Play.application().getFile(
				"/app/controllers/json/menu.json");
		final StringBuilder menuHtml = new StringBuilder();
		try {
			String jsonStr = FileUtils.readFileToString(jsonFile);
			JSONUtils.list(jsonStr, "$.menus", new ListCallback() {
	            @Override
	            public void callback(String json) {
					menuHtml.append("<div class=\"accordionHeader\">");
					menuHtml.append("<h2>");
					menuHtml.append("<span>Folder</span>"
							+ JSONUtils.getStr(json, "title"));
					menuHtml.append("</h2>");
					menuHtml.append("</div>");
					menuHtml.append("<div class=\"accordionContent\">");
					menuHtml.append("<ul class=\"tree treeFolder\">");
					submenu(menuHtml, json);
					menuHtml.append("</ul>");
					menuHtml.append("</div>");
	                
	            }
	        });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok(index.render(menuHtml.toString()));
    }
    
    // ajax提交响应方法
    public static Result ajaxDone(){
    	return ok("{ \"statusCode\":\"200\", \"message\":\"操作成功。\", \"navTabId\":\"\", \"rel\":\"\", \"callbackType\":\"\", \"forwardUrl\":\"\", \"confirmMsg\":\"\" }");
    }
    
    private static void submenu(final StringBuilder menuHtml, String menuitem) {
		JSONUtils.list(menuitem, "$.menus", new ListCallback() {
            @Override
            public void callback(String json) {
            	menuHtml.append("<li>");
    			if (!"".equals(JSONUtils.getStr(json, "url"))) {
    					String target = JSONUtils.getStr(json, "target");
    					if(!"dialog".equals(target)){
    						target = "navTab";
    					}
    					menuHtml.append("<a href=\"" + JSONUtils.getStr(json, "url")
    							+ "\" rel=\"" + JSONUtils.getStr(json, "title")
    							+ "\" target=\""+target+"\" width=\""+JSONUtils.getStr(json, "width")+"\">");
    					menuHtml.append(JSONUtils.getStr(json, "title"));
    					menuHtml.append("</a>");
    			} else {
    				menuHtml.append("<a>");
    				menuHtml.append(JSONUtils.getStr(json, "title"));
    				menuHtml.append("</a>");
    			}
    			if (json != null && JSONUtils.getStr(json, "menus") != null
    					&& "menus".equals(JSONUtils.getStr(json, "type"))) {
    				menuHtml.append("<ul>");
    				submenu(menuHtml, json);
    				menuHtml.append("</ul>");
    			}
    			menuHtml.append("</li>");
            }
        });
	}
  
}
