//交易记录的表格
var TransactionListUrl = "/ubang/User/GetAllManagerAdmin";

//将选中的那一行的所有信息赋值到 modal 中
function updated(ID) {
	$.ajax({
		url:"/ubang/SeekHelp/GetHelpInfoAdmin",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			id:ID
		},
 
		success:function(meg){
			var inf = JSON.parse(meg);
			$('#TranNum').val(ID);
			$('#TranName').val(inf.status);
			$('#TranMoney').val(inf.name);
			$('#TranCount').val(inf.type);
			$('#TranDate').val(inf.content);
			$('#TranOpe').val(inf.create_time);	
			
			$('#deleteTranNum').val(ID);
			$('#deleteTranName').val(inf.status);
			$('#deleteTranMoney').val(inf.name);
			$('#deleteTranCount').val(inf.type);
			$('#deleteTranDate').val(inf.content);
			$('#deleteTranOpe').val(inf.create_time);
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
	
}

//将选中的那一行的所有信息赋值到 modal 中
function show(ID) {
	$.ajax({
		url:"/ubang/SeekHelp/GetSeekHelpAdmin",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			id:ID
		},
 
		success:function(meg){
			var inf = JSON.parse(meg);
			$('#recourse').val(inf.resourse);
			$('#type').val(inf.type);
			$('#recourse_create_time').val(inf.recourse_create_time);
			$('#content').val(inf.content);
			$('#helper').val(inf.helper);
			$('#helper_create_time').val(inf.helper_create_time);	
			$('#helper_end_time').val(inf.helper_end_time);
			$('#rating').val(inf.rating);
			$('#description').val(inf.description);	
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
	
}

function showHelping(ID) {
	$.ajax({
		url:"/ubang/SeekHelp/GetSeekHelpAdmin",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			id:ID
		},
 
		success:function(meg){
			var inf = JSON.parse(meg);
			$('#recourse_helping').val(inf.resourse);
			$('#type_helping').val(inf.type);
			$('#recourse_create_time_helping').val(inf.recourse_create_time);
			$('#content_helping').val(inf.content);
			$('#helper_helping').val(inf.helper);
			$('#helper_create_time_helping').val(inf.helper_create_time);	
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
	
}

function sort(ID) {
	if(ID == '全部'){
		location.replace("/ubang/SeekHelp/GetSeekHelpListAdmin");
	}else{
		window.location.href="/ubang/SeekHelp/SortHelpListAdmin?type="+ID;
//		location.replace("/ubang/SeekHelp/SortHelpListAdmin?type="+ID);
	}

}

//删除员工的信息
function DeleteTran() {
	var workerNum = document.getElementById("deleteTranNum").value;	
	$.ajax({
		url:"/ubang/SeekHelp/DeleteSeekHelpListAdmin",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			id:workerNum
		},
 
		success:function(meg){
			location.replace(TransactionListUrl);
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//更新员工的信息
function UpdateTran(){
	//获取modal中的各个信息
	var workerNum = document.getElementById("TranNum").value;
	var workerName = document.getElementById("TranName").value;
	var workerMoney = document.getElementById("TranMoney").value;
	var workerCount = document.getElementById("TranCount").value;
	var workerDate = document.getElementById("TranDate").value;
	var workerOpe = document.getElementById("TranOpe").value;
	$.ajax({
		url:"/warehouseBeta/Transaction/UpdateTransaction",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			id:workerNum,
			name:workerName,
			money:workerMoney,
			count:workerCount,
			date:workerDate,
			operator:workerOpe
		},
		success:function(meg){
			location.replace(TransactionListUrl);
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//新增交易记录
function AddTran(){
	//获取modal中的各个信息
	var workerName = document.getElementById("addTranName").value;
	var workerMoney = document.getElementById("addTranMoney").value;
	var workerCount = document.getElementById("addTranCount").value;
	var workerDate = document.getElementById("addTranDate").value;
	var workerOpe = document.getElementById("addTranOpe").value;
	
	$.ajax({
		url:"/warehouseBeta/Transaction/AddTransaction",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			name:workerName,
			money:workerMoney,
			count:workerCount,
			date:workerDate,
			operator:workerOpe
		},
 
		success:function(meg){
			location.replace(TransactionListUrl);
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//查看商品信息
function getCommodity(ID){
	
	$.ajax({
		url:"/warehouseBeta/Stock/GetCommodity",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			ID:ID
		},
 
		success:function(meg){
			var inf = JSON.parse(meg)[0];
			document.getElementById("CommodityName").innerText = inf.name;
			document.getElementById("CommodityOrig").innerText = inf.origin;
			document.getElementById("CommoditySupp").innerText = inf.supplier;
			document.getElementById("CommodityRema").innerText = inf.remark;
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//设置添加功能的经办人
function setAddTranOpe(name){
	$('#TranOpe').val(name);	
}