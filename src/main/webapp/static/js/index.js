/*=============== SHOW MENU ===============*/
const navMenu = document.getElementById('nav-menu'),
    navToggle = document.getElementById('nav-toggle'),
    navClose = document.getElementById('nav-close')

/* Menu show */
navToggle.addEventListener('click', () => {
    navMenu.classList.add('show-menu')
})

/* Menu hidden */
navClose.addEventListener('click', () => {
    navMenu.classList.remove('show-menu')
})

/*=============== SEARCH ===============*/
const search = document.getElementById('search'),
    searchBtn = document.getElementById('search-btn'),
    searchClose = document.getElementById('search-close')

/* Search show */
searchBtn.addEventListener('click', () => {
    search.classList.add('show-action')
})

/* Search hidden */
searchClose.addEventListener('click', () => {
    search.classList.remove('show-action')
})

/*=============== LOGIN ===============*/
const login = document.getElementById('login'),
    loginBtn = document.getElementById('login_btn'),
    loginClose = document.getElementById('login-close')
loginSignup = document.getElementById('login-signup')
loginForget = document.getElementById('login-forget')

/* Login show */
loginBtn.addEventListener('click', () => {
    login.classList.add('show-action')
})

/* Login hidden */
loginClose.addEventListener('click', () => {
    login.classList.remove('show-action')
})

/*=============== Register ===============*/
const register = document.getElementById('register'),
    registerClose = document.getElementById('register-close')
registerLogin = document.getElementById('register-login')

/* Register show */
loginSignup.addEventListener('click', () => {
    register.classList.add('show-action')
    login.classList.remove('show-action')
})

/* Register -> Login */
registerLogin.addEventListener('click', () => {
    login.classList.add('show-action')
    register.classList.remove('show-action')
})

/* Register hidden */
registerClose.addEventListener('click', () => {
    register.classList.remove('show-action')
})

/*=============== FORGET ===============*/
const forget = document.getElementById('forget'),
    forgetClose = document.getElementById('forget-close')
forgetLogin = document.getElementById('forget-login')

/* Forget show */
loginForget.addEventListener('click', () => {
    forget.classList.add('show-action')
    login.classList.remove('show-action')
})
/* Forget -> Login */
forgetLogin.addEventListener('click', () => {
    login.classList.add('show-action')
    forget.classList.remove('show-action')
})

/* Forget hidden */
forgetClose.addEventListener('click', () => {
    forget.classList.remove('show-action')
})

/* 自定义函数 */
function actionPasswordLogin(username, password) {
    let data = {
        // "username": "Ogawa Yota",
        // "password": "T1q8aWio1U"
        "type": "pwd",
        "username": username,
        "password": password
    };
    var settings = {
        url: "http://localhost:8080/cilicili_war/login",
        method: "POST",
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(data)
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        if (response.code == 200) {
            localStorage.setItem("user", JSON.stringify(response.data));
            window.location.href = "./Index.html";
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
        url: "http://localhost:8080/cilicili_war/sendEmail",
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


function actionVerifyCodeLogin(email, code) {
    let data = {
        "type": "code",
        "email": email,
        "code": code
    };
    var settings = {
        url: "http://localhost:8080/cilicili_war/login",
        method: "POST",
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(data)
    };
    $.ajax(settings).done(function (response) {
        console.log(response);
        if (response.code == 200) {
            localStorage.setItem("user", JSON.stringify(response.data));
            window.location.href = "./Index.html";
        } else {
            alert("用户名或者密码错误！");
        }
    });
}