//仓库的表格
var StockListUrl = "/warehouseBeta/Stock/StockList";
//将选中的那一行的 ID 信息赋值到 modal 中的 id 上
function updated(ID) {
	$.ajax({
		url:"/warehouseBeta/Stock/GetStock",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			ID:ID
		},
		success:function(meg){
			var inf = JSON.parse(meg)[0];
			$('#StockNum').val(ID);
			$('#StockName').val(inf.name);
			$('#StockOrigin').val(inf.origin);
			$('#StockSupp').val(inf.supplier);
			$('#StockCount').val(inf.count);
			$('#StockDate').val(inf.date);
			$('#StockOpe').val(inf.operator);	
			
			$('#deleteStockNum').val(ID);
			$('#deleteStockName').val(inf.name);
			$('#deleteStockOrigin').val(inf.origin);
			$('#deleteStockSupp').val(inf.supplier);
			$('#deleteStockCount').val(inf.count);
			$('#deleteStockDate').val(inf.date);
			$('#deleteStockOpe').val(inf.operator);
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//删除员工的信息
function DeleteStock() {
	var workerNum = document.getElementById("deleteStockNum").value;	
	$.ajax({
		url:"/warehouseBeta/Stock/DeleteStock",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			ID:workerNum
		},
 
		success:function(meg){
			location.replace(StockListUrl);
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//更新员工的信息
function UpdateStock(){
	//获取modal中的各个信息
	var workerNum = document.getElementById("StockNum").value;
	var workerName = document.getElementById("StockName").value;
	var workerOri = document.getElementById("StockOrigin").value;
	var workerSupp = document.getElementById("StockSupp").value;
	var workerCount = document.getElementById("StockCount").value;
	var workerDate = document.getElementById("StockDate").value;
	var workerOpe = document.getElementById("StockOpe").value;
	$.ajax({
		url:"/warehouseBeta/Stock/UpdateStock",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			id:workerNum,
			name:workerName,
			origin:workerOri,
			supplier:workerSupp,
			count:workerCount,
			date:workerDate,
			operator:workerOpe
		},
		success:function(meg){
			location.replace(StockListUrl);
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//新增员工
function AddStock(){
	//获取modal中的各个信息
	var workerName = document.getElementById("addStockName").value;
	var workerOri = document.getElementById("addStockOrigin").value;
	var workerSupp = document.getElementById("addStockSupp").value;
	var workerCount = document.getElementById("addStockCount").value;
	var workerDate = document.getElementById("addStockDate").value;
	var workerOpe = document.getElementById("addStockOpe").value;
	var workerRem = document.getElementById("addStockRem").value;
	
	$.ajax({
		url:"/warehouseBeta/Stock/AddStock",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			name:workerName,
			origin:workerOri,
			supplier:workerSupp,
			count:workerCount,
			date:workerDate,
			operator:workerOpe,
			remark:workerRem
		},
 
		success:function(ID){
			//在交易记录中添加信息
			addTransaction(ID, workerName,"未交易");
			//在商品中添加信息
			addCommodity(ID,workerName,workerOri,workerSupp,workerRem)
			//跳转页面
			location.replace(StockListUrl);
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}
/*
 * 新增transaction的信息
 * ID和名称字段信息正常
 * 其他字段的信息都显示未交易
 */
function addTransaction(id,name,info){
	var id = parseInt(id);
	$.ajax({
		url:"/warehouseBeta/Transaction/addTransaction",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			id:id,
			name:name,
			money:0,
			count:0,
			date:info,
			operator:info
		},
		success:function(meg){
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//添加商品信息
function addCommodity(ID,workerName,workerOri,workerSupp,workerRem){
	var id = parseInt(ID);
	$.ajax({
		url:"/warehouseBeta/Stock/AddCommodity",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			id:id,
			name:workerName,
			origin:workerOri,
			supplier:workerSupp,
			remark:workerRem
		},
		success:function(meg){
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});	
}

//设置添加功能的经办人
function setAddStockOpe(name){
	$('#addStockOpe').val(name);
	$('#StockOpe').val(name);
}
