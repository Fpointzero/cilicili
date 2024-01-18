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
        "password": password
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


function actionVerifyCodeLogin(email, code){
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