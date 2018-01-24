/**
 * Created by Administrator on 2018/1/16.
 */
$(document).ready(function() {
    $("#submitBtn").click(function() {
        var userName = $("#userName").val();
        if (userName == null || $.trim(userName).length < 1) {
            alert("请输入用户名");
            return;
        }
        var password = $("#password").val();
        if (password == null || $.trim(password).length < 1) {
            alert("请输入密码");
            return;
        }
        // var code = $("#code").val();
        // if (code == null || $.trim(code).length < 1) {
        //     alert("请输入验证码");
        //     return;
        // }

        var data = {"userName":userName, "password":password};

        $.ajax({
            async: false,
            type : "POST",
            url : "login",
            data :data,
            dataType : 'json',
            success : function(resp) {
                if (resp.resultCode == 1) { // 成功
                    // 把登录后的数据存入cookie
                    cookie.set("userIdString",resp.result.userIdString);
                    cookie.set("userName",resp.result.userName);
                    cookie.set("realName",resp.result.realName);
                    // $.cookie("userIdString", resp.result.userIdString);
                    // $.cookie("userName", resp.result.userName);
                    // $.cookie("realName", resp.result.realName);
                    window.location.href = ctx;
                } else { // 失败
                    alert(resp.resultMessage);
                }
            }
        });
        // $.post("user/login", data, function(resp) {
        // 	if (resp.resultCode == 1) { // 成功
        // 		// 把登录后的数据存入cookie
        // 		$.cookie("userIdString", resp.result.userIdString);
        // 		$.cookie("userName", resp.result.userName);
        // 		$.cookie("realName", resp.result.realName);
        // 		window.location.href = ctx+"main";
        // 	} else { // 失败
        // 		alert(resp.resultMessage);
        // 	}
        // });
    });
});