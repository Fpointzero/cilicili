// user = localStorage.getItem("user");
// try {
//     user = JSON.parse(user);
// } catch (e){
//     console.log(e);
// }
let user;

$("#upload").on("click", function () {
    location.href = "creation.html";
});

$(".nav-right > a").click(function () {
    let _this = $(this);
    if (_this.html().includes("历史")) {
        location.href = "archive.html"
    } else if (_this.html().includes("收藏")) {
        location.href = "Star.html"
    } else if (_this.html().includes("个人中心")) {
        location.href = "person.html"
    }
});

$(".nav-left > a").click(function () {
    let _this = $(this);
    if (_this.html().includes("首页")) {
        location.href = "index.html"
    }
});

$.ajax({
    url: "/cilicili_war/api/user/userInfo",
    dataType: "json",
    async: false,
    type: "get",
    success: function (res) {
        if (res.code === 200) {
            localStorage.setItem("user", JSON.stringify(res.data));
            user = res.data;
            $("#head-more-box > a").html(user.username);
        }
    },
    error: function (err) {
        localStorage.removeItem("user");
        $("#head-more-box > a").html("请登录");
        user = null;
    }
});


// 获取输入框和搜索图标
let input = document.getElementById('keyword');
let searchIcon = document.getElementById('search-icon');

// 监听输入框的keydown事件
input.addEventListener('keydown', function (e) {

    // 检测是否按下了Enter键
    if (e.key === 'Enter') {
        // 防止默认行为
        e.preventDefault();
        // 模拟点击搜索按钮
        searchIcon.click();
    }
});

// 为搜索图标添加点击事件监听
searchIcon.addEventListener('click', async () => {
    // 判断输入框是否有内容
    if (input.value.trim()) {
        // 跳转到search页面,同时传递搜索关键词
        window.location.href = `Search.html?keyword=${input.value.trim()}`;
    } else {
        // 输入框无内容,提示用户输入
        alert('请输入搜索内容');
    }
});