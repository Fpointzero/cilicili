function pwdLogin() {
    $('.login-pwd').css('display', 'flex');
    $('.login-phone').css('display', 'none');
    $('.login-right>div>a:nth-child(1)').css('color', '#4FA5D9')
    $('.login-right>div>a:nth-child(2)').css('color', '#505050')
}

function phoneLogin() {
    $('.login-pwd').css('display', 'none');
    $('.login-phone').css('display', 'flex');
    $('.login-right>div>a:nth-child(1)').css('color', '#505050')
    $('.login-right>div>a:nth-child(2)').css('color', '#4FA5D9')
}

// 获取密码输入框 得到焦点/失去焦点 执行不同方法
$('.login-pwd div:nth-child(2)>input').on('focus', openEye);
$('.login-pwd div:nth-child(2)>input').on('blur', closeEye);

function openEye() {
    $('.login-box>img:nth-of-type(2)').css('display', 'none');
    $('.login-box>img:nth-of-type(4)').css('display', 'none');
}

function closeEye() {
    $('.login-box>img:nth-of-type(2)').css('display', 'inline');
    $('.login-box>img:nth-of-type(4)').css('display', 'inline');
}

function actionPasswordLogin(username, password) {
    let data = {
        "type": "pwd",
        "username": username,
        "password": CryptoJS.MD5(password).toString()
    };
    var settings = {
        url: "/cilicili_war/api/login",
        method: "POST",
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(data)
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        if (response.code == 200) {
            localStorage.setItem("user", JSON.stringify(response.data));
            window.location.href = "index.html";
        } else {
            alert("用户名或者密码错误！");
        }
    });
}

function sendVerifyCode(email) {
    let data = {
        "email": email
    };
    var settings = {
        url: "/cilicili_war/api/sendEmail",
        method: "POST",
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(data)
    };
    $.ajax(settings).done(function (response) {
        console.log(response);
        if (response.code == 200) {
            console.log("发送验证码成功");
        } else {
            console.log("发送失败");
        }
    });
}

// 获取链接元素
var link = $("#send-verify-code");
// 设置初始倒计时时间
var countdown = 60;
// 启动倒计时
var timer;
let sendVerifyCodeEvent = function () {
    countdown = 60;
    sendVerifyCode($("#email").val());
    link.off("click", sendVerifyCodeEvent);
    timer = setInterval(function () {
        // 更新倒计时显示
        link.html(countdown + " 秒后可点击");

        // 倒计时减少
        countdown--;

        // 倒计时结束后，启用链接点击并清除计时器
        if (countdown < 0) {
            link.on("click", sendVerifyCodeEvent);
            link.html("发送验证码");
            clearInterval(timer);
        }
    }, 1000)
};

link.on("click", sendVerifyCodeEvent);



function actionVerifyCodeLogin(email, code) {
    let data = {
        "type": "code",
        "email": email,
        "code": code
    };
    var settings = {
        url: "/cilicili_war/api/login",
        method: "POST",
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(data)
    };
    $.ajax(settings).done(function (response) {
        console.log(response);
        if (response.code == 200) {
            localStorage.setItem("user", JSON.stringify(response.data));
            window.location.href = "index.html";
        } else {
            alert("用户名或者密码错误！");
        }
    });
}