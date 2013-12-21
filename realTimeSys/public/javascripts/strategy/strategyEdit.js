function saveType(){
	$.pdialog.closeCurrent();
	alertMsg.correct("分类新增成功。");
}

function saveTypeEdit(){
	$.pdialog.closeCurrent();
	alertMsg.correct("分类修改成功。");
}

function saveStrategy(){
	$.pdialog.closeCurrent();
	alertMsg.correct("策略新增成功。");
}

function saveStrategyEdit(){
	$.pdialog.closeCurrent();
	alertMsg.correct("策略编辑成功。");
}
function saveStrategyUpdate(){
	$.pdialog.closeCurrent();
	alertMsg.correct("策略更新成功。");
}

$(document).ready(function(){ 
	$('#gxlb').change(function(){ 
		var selected=$(this).children('option:selected').val();//这就是selected的值 
		if(selected==0){//文件地址
			$("#wjdz").show();
			$("#fwqdz").hide();
		}else{//服务器地址
			$("#wjdz").hide();
			$("#fwqdz").show();
		}
	}) 
})