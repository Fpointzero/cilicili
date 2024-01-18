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
