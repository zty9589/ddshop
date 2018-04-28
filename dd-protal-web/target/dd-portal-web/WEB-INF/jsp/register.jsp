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
					var username = $('#username').val();
                    alert(username);
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
					<div class="tips">
						
					</div>
				</div>
				<div class="register-box">
					<label for="username" class="other_label"><span>设 置 密 码</span>
					<input maxlength="20" id="password1" type="password" placeholder="建议至少使用两种字符组合"/>
					</label>
					<div class="tips">
						
					</div>
				</div>
				<div class="register-box">
					<label for="username" id="password2" class="other_label"><span>确 认 密 码</span>
					<input maxlength="20" type="password" placeholder="请再次输入密码"/>
					</label>
					<div class="tips">
						
					</div>
				</div>
				<div class="register-box">
					<label for="username" class="other_label">
					<span>中国 0086∨</span>
					<input class="phone" id="phone" maxlength="20" type="text" placeholder="建议使用常用手机"/>
					</label>
					<div class="tips">
						
					</div>
				</div>
				<div class="register-box">
					<label for="username" class="other_label">
					<span>验 证 码</span>
					<input maxlength="20" id="ms_code" type="text" placeholder="请输入手机验证码"/>
					</label>
					<div class="tips">
					</div>
				</div>
				<div class="arguement">
					<input type="checkbox" id="xieyi"/>
					阅读并同意
					<a href="#">《天天书店用户注册协议》</a>
					<a href="#">《隐私政策》</a>
					<div class="tips">
						
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
