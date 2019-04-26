var Account ={
	Login:{
		LoginHandler:function isNum(){
			//账号密码不能为空
			$("#enter").click(function(){
				var name = document.getElementById("inputYourName").value;
				var password = document.getElementById("inputPassword").value;	
				if(name == "" || password == "")
				{
					alert("不能为空");
				}
				else{
					 window.location.href="/ubang/User/CheckLoginAdmin?name="+encodeURI(encodeURI(name))+"&password="+password;
				}
			})
		}
		
	}
	
}