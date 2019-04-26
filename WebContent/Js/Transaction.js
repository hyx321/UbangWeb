//交易记录的表格
var TransactionListUrl = "/warehouseBeta/Transaction/TransactionList";

//将选中的那一行的所有信息赋值到 modal 中
function updated(ID) {
	$.ajax({
		url:"/warehouseBeta/Transaction/GetTransaction",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			ID:ID
		},
 
		success:function(meg){
			var inf = JSON.parse(meg)[0];
			$('#TranNum').val(ID);
			$('#TranName').val(inf.name);
			$('#TranMoney').val(inf.money);
			$('#TranCount').val(inf.count);
			$('#TranDate').val(inf.date);
			$('#TranOpe').val(inf.operator);	
			
			$('#deleteTranNum').val(ID);
			$('#deleteTranName').val(inf.name);
			$('#deleteTranMoney').val(inf.money);
			$('#deleteTranCount').val(inf.count);
			$('#deleteTranDate').val(inf.date);
			$('#deleteTranOpe').val(inf.operator);
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
	
}

//删除员工的信息
function DeleteTran() {
	var workerNum = document.getElementById("deleteTranNum").value;	
	$.ajax({
		url:"/warehouseBeta/Transaction/DeleteTransaction",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			ID:workerNum
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