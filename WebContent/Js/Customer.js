//客户表格路径
var CustomerListUrl = "/warehouseBeta/Customer/CustomerList";
//将选中的那一行的 ID 信息赋值到 modal 中的 id 上
function updated(ID) {

	$.ajax({
		url:"/warehouseBeta/Customer/GetCustomer",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			ID:ID
		},
 
		success:function(meg){
			var inf = JSON.parse(meg)[0];
			
			$('#CustomerNum').val(ID);
			$('#CustomerName').val(inf.name);
			$('#CustomerBank').val(inf.bank);
			$('#CustomerTele').val(inf.telephone);
			$('#CustomerAdd').val(inf.address);

			$('#deleteCustomerNum').val(ID);
			$('#deleteCustomerName').val(inf.name);
			$('#deleteCustomerBank').val(inf.bank);
			$('#deleteCustomerTele').val(inf.telephone);
			$('#deleteCustomerAdd').val(inf.address);
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//删除员工的信息
function DeleteCustomer() {
	var workerNum = document.getElementById("deleteCustomerNum").value;	
	$.ajax({
		url:"/warehouseBeta/Customer/DeleteCustomer",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			ID:workerNum
		},
 
		success:function(meg){
			location.replace(CustomerListUrl);
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//更新员工的信息
function UpdateCustomer(){
	//获取modal中的各个信息
	var workerNum = document.getElementById("CustomerNum").value;
	var workerName = document.getElementById("CustomerName").value;
	var workerBank = document.getElementById("CustomerBank").value;
	var workerTele = document.getElementById("CustomerTele").value;
	var workerAdd = document.getElementById("CustomerAdd").value;
	$.ajax({
		url:"/warehouseBeta/Customer/UpdateCustomer",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			id:workerNum,
			name:workerName,
			bank:workerBank,
			telephone:workerTele,
			address:workerAdd
		},
		success:function(meg){
			location.replace(CustomerListUrl);		
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//新增员工
function AddCustomer(){
	//获取modal中的各个信息
	var workerName = document.getElementById("addCustomerName").value;
	var workerBank = document.getElementById("addCustomerBank").value;
	var workerTele = document.getElementById("addCustomerTele").value;
	var workerAdd = document.getElementById("addCustomerAdd").value;
	/*alert(workerName+""+workerPwd+""+workerTele+""+workerAdd);*/
	$.ajax({
		url:"/warehouseBeta/Customer/AddCustomer",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			name:workerName,
			bank:workerBank,
			telephone:workerTele,
			address:workerAdd
		},
 
		success:function(meg){
			location.replace(CustomerListUrl);
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}
//获取个人交易记录
function getSale(name){
	//alert(name	);
$.ajax({
		url:"/warehouseBeta/Customer/GetSale",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			purchaser:name
		},
 
		success:function(meg){
			tableCon(JSON.parse(meg));			
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}
//创建交易记录的内容行
function tableCon(date){
	getOutTable();
	for(var i=0;i<date.length;i++){
		
		var row = document.createElement("tr"); //创建tr的
			
		var cell = document.createElement("td");//创建td
		cell.appendChild(document.createTextNode(date[i].name));//td里注入文本
		row.appendChild(cell);//将TD注入TR
		
		var cell = document.createElement("td");//创建td
		cell.appendChild(document.createTextNode(date[i].date));
		row.appendChild(cell);//将TD注入TR
		
		var cell = document.createElement("td");//创建td
		cell.appendChild(document.createTextNode(date[i].operator));
		row.appendChild(cell);//将TD注入TR
		
		var cell = document.createElement("td");//创建td
		cell.appendChild(document.createTextNode(date[i].money));
		row.appendChild(cell);//将TD注入TR

		document.getElementById("tableContext").appendChild(row);//将TR注入到相应地方(sortList可以看下面html)
	}
}
//清空交易记录表格的所有行，除了标题行
function getOutTable(){
	var tb = document.getElementById('saleContext');
    var rowNum=tb.rows.length;
    for (i=1;i<rowNum;i++)
    {
        tb.deleteRow(i);
        rowNum=rowNum-1;
        i=i-1;
    }
}