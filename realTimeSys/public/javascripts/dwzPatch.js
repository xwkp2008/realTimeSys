$.extend(true, navTab, {
	/**
	 * 针对发布信息和修改信息不应该同时出现来进行判断
	 * 发布信息tabid=info_add 修改信息tabid=info_edit
	 * @param {Object} tabid
	 * @param {Object} url
	 * @param {Object} params: title, data, fresh
	 */
	openTab: function(tabid, url, options){ //if found tabid replace tab, else create a new tab.
		var op = $.extend({title:"New Tab", data:{}, fresh:true, external:false}, options);
		var iOpenIndex = this._indexTabId(tabid), otherId;
		if (this._indexTabId("package_add") >= 0) otherId = "package_add";
		if (this._indexTabId("package_edit") >= 0) otherId = "package_edit";
		if((tabid == "package_add" || tabid == "package_edit") && otherId){
			return alertMsg.confirm(
				"您有套餐还在编辑中，是否要放弃之前编辑的套餐开始新的编辑？",
				{
					okName:"是，开始新的编辑",
					cancelName:"否，我要继续编辑",
					okCall:function(){
						navTab.closeTab(otherId);
						navTab.openTab(tabid, url, options);
					}, 
					cancelCall:function(){
						return navTab._switchTab(navTab._indexTabId(otherId));
					}
				}
			);
		}
		if (this._indexTabId("merchant_add") >= 0) otherId = "merchant_add";
		if (this._indexTabId("merchant_edit") >= 0) otherId = "merchant_edit";
		if((tabid == "merchant_add" || tabid == "merchant_edit") && otherId){
			return alertMsg.confirm(
				"您有商家还在编辑中，是否要放弃之前编辑的商家开始新的编辑？",
				{
					okName:"是，开始新的编辑",
					cancelName:"否，我要继续编辑",
					okCall:function(){
						navTab.closeTab(otherId);
						navTab.openTab(tabid, url, options);
					}, 
					cancelCall:function(){
						return navTab._switchTab(navTab._indexTabId(otherId));
					}
				}
			);
		}
		if (iOpenIndex >= 0){
			// alert("刷新页面");
			var $tab = this._getTabs().eq(iOpenIndex);
			var span$ = $tab.attr("tabid") == this._op.mainTabId ? "> span > span" : "> span";
			$tab.find(">a").attr("title", op.title).find(span$).text(op.title);
			var $panel = this._getPanels().eq(iOpenIndex);
			if(op.fresh || $tab.attr("url") != url) {
				$tab.attr("url", url);
				if (op.external || url.isExternalUrl()) {
					$tab.addClass("external");
					navTab.openExternal(url, $panel);
				} else {
					$tab.removeClass("external");
					$panel.ajaxUrl({
						type:"GET", url:url, data:op.data, callback:function(){
							navTab._loadUrlCallback($panel);
						}
					});
				}
			}
			this._currentIndex = iOpenIndex;
		} else {
			var tabFrag = '<li tabid="#tabid#"><a href="javascript:" title="#title#" class="#tabid#"><span>#title#</span></a><a href="javascript:;" class="close">close</a></li>';
			this._tabBox.append(tabFrag.replaceAll("#tabid#", tabid).replaceAll("#title#", op.title));
			this._panelBox.append('<div class="page unitBox"></div>');
			this._moreBox.append('<li><a href="javascript:" title="#title#">#title#</a></li>'.replaceAll("#title#", op.title));
			
			var $tabs = this._getTabs();
			var $tab = $tabs.filter(":last");
			var $panel = this._getPanels().filter(":last");
			
			if (op.external || url.isExternalUrl()) {
				$tab.addClass("external");
				navTab.openExternal(url, $panel);
			} else {
				$tab.removeClass("external");
				$panel.ajaxUrl({
					type:"GET", url:url, data:op.data, callback:function(){
						navTab._loadUrlCallback($panel);
					}
				});
			}
			
			if ($.History) {
				setTimeout(function(){
					$.History.addHistory(tabid, function(tabid){
						var i = navTab._indexTabId(tabid);
						if (i >= 0) navTab._switchTab(i);
					}, tabid);
				}, 10);
			}
				
			this._currentIndex = $tabs.size() - 1;
			this._contextmenu($tabs.filter(":last").hoverClass("hover"));
		}
		
		this._init();
		this._scrollCurrent();
		
		this._getTabs().eq(this._currentIndex).attr("url", url);
	},
	/*
	 * 关闭tab页时销毁页面上的上传控件，避免IE下js报错
	 */
	_closeTab: function(index, openTabid){
		this._getTabs().eq(index).remove();
		if ($.fn.upload) {
			$(".uploadify", this._getPanels().eq(index)).uploadify("destroy");
		}
		if($("#placeholder", navTab.getCurrentPanel())){
			$("#placeholder", navTab.getCurrentPanel()).remove();
		}
		this._getPanels().eq(index).trigger(DWZ.eventType.pageClear).remove();
		this._getMoreLi().eq(index).remove();
		if (this._currentIndex >= index) this._currentIndex--;
		
		if (openTabid) {
			var openIndex = this._indexTabId(openTabid);
			if (openIndex > 0) this._currentIndex = openIndex;
		}
		
		this._init();
		this._scrollCurrent();
		this._reload(this._getTabs().eq(this._currentIndex));
	}
});