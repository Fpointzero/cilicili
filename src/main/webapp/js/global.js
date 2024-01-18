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
})