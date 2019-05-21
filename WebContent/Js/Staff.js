//将选中的那一行的 ID 信息赋值到 modal 中的 id 上
function updated(ID) {
	
	$.ajax({
		url:"/ubang/User/GetUserAdmin",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			ID:ID
		},
 
		success:function(meg){
	
			var inf = JSON.parse(meg);			
			
			$('#userNum').val(inf.id);
			$('#userName').val(inf.name);
			$('#userNickname').val(inf.nickname);
			$('#userSex').val(inf.sex);
			$('#userPhone').val(inf.phone);
			$('#userPwd').val('123456');
		
			$('#deleteUserNum').val(inf.id);
			$('#deletUserName').val(inf.name);
			$('#deleteUserNickname').val(inf.nickname);
			$('#deleteUserSex').val(inf.sex);
			$('#deleteUserPhone').val(inf.phone);
			$('#deleteUserPwd').val('*******');
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//删除员工的信息
function DeleteStaff() {
	var userNum = document.getElementById("deleteUserNum").value;	
	$.ajax({
		url:"/ubang/User/DeleteUserAdmin",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			ID:userNum
		},
 
		success:function(meg){
			location.replace("/ubang/User/GetAllUsersAdmin");
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//更新员工的信息
function UpdateStaff(){
	//获取modal中的各个信息
	var userNum = document.getElementById("userNum").value;
	var userName = document.getElementById("userName").value;
	var userNickname = document.getElementById("userNickname").value;
	var userSex = document.getElementById("userSex").value;
	var userPhone = document.getElementById("userPhone").value;
	var userPwd = document.getElementById("userPwd").value;
	
	$.ajax({
		url:"/ubang/User/UpdateUserAdmin",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			id:userNum,
			name:userName,
			nickname:userNickname,
			sex:userSex,
			phone:userPhone,
			password:userPwd
		},
		success:function(meg){
			location.replace("/ubang/User/GetAllUsersAdmin");		
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//新增员工
function AddStaff(){
	//获取modal中的各个信息
	var userName = document.getElementById("addUserName").value;
	var userNickname = document.getElementById("addUserNickname").value;
	var userSex = document.getElementById("addUserSex").value;
	var userPhone = document.getElementById("addUserPhone").value;
	var userPwd = document.getElementById("addUserPwd").value;
	/*alert(workerName+""+workerPwd+""+workerTele+""+workerAdd);*/
	$.ajax({
		url:"/ubang/User/AddUserAdmin",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			name:userName,
			password:userPwd,
			phone:userPhone,
			sex:userSex,
			nickname:userNickname
		},
 
		success:function(meg){
			location.replace("/ubang/User/GetAllUsersAdmin");
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}