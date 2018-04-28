<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
   <!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>新用户注册</title>
		<script type="text/javascript" src="js/jquery-1.8.3-min.js"></script>
		<script type="text/javascript">
			$(function(){
			    $("#form").submit(function (e) {
			        //用户名
					var username = $('#username').val();
					var flag1 = false;
					//密码
                    var password1 = $('#password1').val();
                    var flag2 = false;
                    //确认密码
                    var password2 = $('#password2').val();
                    var flag3 = false;
                    //手机号码
                    var phone = $('#phone').val();
                    var flag4 = false;
                    var str = /^1[3,5,8]\d{9}$/;
                    //验证码
                    var ms_code = $('#ms_code').val();
                    var flag5 = false;
                    //勾选框
                    var status_ = $("input[type='checkbox']").is(':checked');
                    var flag6 = false;

					if(username == null || username == ""){
						$('#tips1').text("用户名不能为空").css("color","red").css("font-size","14px");
					}else{
					    
						$('#tips1').text("");
						flag1 = true;
					}

                    if(password1 == null || password1 == ""){
                        $('#tips2').html("密码不能为空").css("color","red").css("font-size","14px");
                    }else{
                        $('#tips2').html("");
                        flag2 = true;
                    }

                    if(password2 == null || password2 == ""){
                        $('#tips3').html("重复密码不能为空").css("color","red").css("font-size","14px");
                    }else{
                        if(password1 != password2){
                            $('#tips3').html("两次密码输入不一致").css("color","red").css("font-size","14px");
                        }else if(password1 == password2){
                            $('#tips3').html("");
                            flag3 = true;
						}
                    }

                    if(phone == null || phone == ""){
                        $('#tips4').html("手机号码不能为空").css("color","red").css("font-size","14px");
                    }else{
                        if(str.test(phone)){
                            $('#tips4').html("");
                            flag4 = true;
                        }else{
                            $('#tips4').html("手机号码格式不正确").css("color","red").css("font-size","14px");
						}
                    }

                    if(ms_code == null || ms_code == ""){
                        $('#tips5').html("验证码不能为空").css("color","red").css("font-size","14px");
                    }else{
                        $('#tips5').html("");
                        flag5 = true;
                    }

                    if(status_ == false){
                        $('#tips6').html("请勾选用户协议").css("color","red").css("font-size","14px");
                    }else{
                        $('#tips6').html("");
                        flag6 = true;
                    }

                    //阻止表单提交
                    e.preventDefault();
					//前端校验通过
                    if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6){
						//Ajax提交表单
						var param = {"username":username,"password":password2};
                        $.ajax({
                            url:"${pageContext.request.contextPath}/login.action",
                            data:param,
                            dataType:"json",
                            type:"post",
                            cache:false,
                            success:function(rec){

                            },
                            error:function(){
                                alert("服务器错误")
                            }

                        });
					}





                })











			})
		</script>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
	</head>
	<body>
		<header>
			<a href="#" class="logo"></a>
			<div class="desc">欢迎注册</div>
		</header>
		<section>
			<form id="form">
				<div class="register-box">
					<label for="username" class="username_label"><span>用 户 名</span>
					<input maxlength="20" id="username" type="text" placeholder="您的用户名和登录名"/>
					</label>
					<div class="tips" id = "tips1">

					</div>
				</div>
				<div class="register-box">
					<label for="username" class="other_label"><span>设 置 密 码</span>
					<input maxlength="20" id="password1" type="password" placeholder="建议至少使用两种字符组合"/>
					</label>
					<div class="tips" id = "tips2">
						
					</div>
				</div>
				<div class="register-box">
					<label for="username" class="other_label"><span>确 认 密 码</span>
					<input maxlength="20" id="password2" type="password" placeholder="请再次输入密码"/>
					</label>
					<div class="tips" id="tips3">
						
					</div>
				</div>
				<div class="register-box">
					<label for="username" class="other_label">
					<span>中国 0086∨</span>
					<input class="phone" id="phone" maxlength="20" type="text" placeholder="建议使用常用手机"/>
					</label>
					<div class="tips" id="tips4">
						
					</div>
				</div>
				<div class="register-box">
					<label for="username" class="other_label">
					<span>验 证 码</span>
					<input maxlength="20" id="ms_code" type="text" placeholder="请输入手机验证码"/>
					</label>
					<div class="tips" id="tips5">
					</div>
				</div>
				<div class="arguement">
					<input type="checkbox" id="xieyi"/>
					阅读并同意
					<a href="#">《天天书店用户注册协议》</a>
					<a href="#">《隐私政策》</a>
					<div class="tips" id="tips6">
						
					</div>
				</div>
				<div class="submit_btn">
					<button type="submit" id="submit_btn">立 即 注 册</button>
				</div>
			</form>
		</section>
		<%--<script src="js/index.js" type="text/javascript" charset="utf-8"></script>--%>
	</body>
</html>
