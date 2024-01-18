// 页面加载时执行的方法
json = localStorage.getItem("user");
try {
    json = JSON.parse(json);
    if (json == null)
        redirectLogin();
    console.log(json);
} catch (error) {
    console.log(error);
    redirectLogin();
}
function redirectLogin() {
    location.href = "LoginAndRegist.html";
}
window.onload = function () {
    var a1 = $('.hidden-nav .hiddenNav-left>a:nth-of-type(1)');
    var a2 = $('.content-nav .hiddenNav-left>a:nth-of-type(1)');
    a1.css('color', '#00A1D6');
    a2.css('color', '#00A1D6');
    $('.hidden-nav .hiddenNav-left>div').css('width', a1.width());
    $('.content-nav .hiddenNav-left>div').css('width', a2.width());
    hiddenNavItems();
    init();
}
// 隐藏nav的滑动监听事件
window.onscroll = function () {
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    if (t > 323){
        $('.hidden-nav').css('transform', 'translateY(70px)');
    }else {
        $('.hidden-nav').css('transform', 'translateY(-70px)');
    }
}
// 导航栏选项样式切换
function hiddenNavItems() {
    var a = $('.hiddenNav-left>a');
    // 获取触发标签 a标签 设置a标签鼠标悬浮事件 e是鼠标对象 e.target是鼠标所指向的目标对象
    // fnOver是鼠标进入事件
    // 获取滑动条对象
    var d = $('.border-bottom');
    var d1 = $('.hidden-nav .border-bottom');
    var d2 = $('.content-nav .border-bottom');
    a.hover(function (e) {
        var target = e.target;
        // 判断鼠标所指向对象是否为a标签
        if ($(target).is('.hiddenNav-left>a')) {
            // 设置滑动条里左边的位置 距离为鼠标所指向对象的left坐标
            d.css('left', $(target).position().left);
            d.css('width', $(target).width());
            a.css('color', '#18191C');
            $(target).css('color', '#00A1D6');
        } else {
            // 如果是指向a标签子元素 则切换为父元素
            d.css('left', $(target).parent().position().left);
            d.css('width', $(target).parent().width());
            a.css('color', '#18191C');
            $(target).parent().css('color', '#00A1D6');
        }
    }, function (e) {  // 鼠标移出方法
        var a1 = $('.hidden-nav .hiddenNav-left>a:nth-of-type(1)');
        var a2 = $('.content-nav .hiddenNav-left>a:nth-of-type(1)');
        d1.css('left', a1.position().left);
        d2.css('left', a2.position().left);
        d1.css('width', a1.width());
        d2.css('width', a2.width());
        $('.hiddenNav-left>a').css('color', '#18191C');
        a1.css('color', '#00A1D6');
        a2.css('color', '#00A1D6');
    })
}
function creatItem(cover, title, createTime, playNum, starNum, vid) {
    // console.log(cover);
    let str = "";
    str += `            <div class="list-item">
                <div class="list-item-left">
                    <img class="cover" src="${cover}" alt="">
                </div>
                <div class="list-item-right">
                    <span class="list-item-title">${title}</span>
                    <div class="list-item-middle">
                        <p>${createTime}</p>
                        <a class="btn-edt">编辑</a>
                    </div>
                    <!--                    <p class="">2023年11月23日 20:28:18</p>-->
                    <div class="list-item-icons">
                        <div class="list-item-show">
                            <img src="images/video-line.png" class="list-item-icon" alt="">
                            <span>${playNum}</span>
                        </div>
                        <div class="list-item-show">
                            <img src="images/star-line.png" class="list-item-icon" alt="">
                            <span style="color: gray;font-size: 10px">${starNum}</span>
                        </div>
                    </div>
                </div>
            </div>`
    let node = $(str);
    node.find(".btn-edt").click(function () {
        location.href = "manuscriptEdit.html?vid=" + vid;
    });
    return node;
}
function init() {
    let data = {
        "uid": json.id,
    };
    var settings = {
        url: "/cilicili_war/api/video/getUserVideo",
        method: "POST",
        contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(data)
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        if (response.code != 200) {
            alert(response.msg);
            redirectLogin();
            return;
        }
        videoData = response.data;
        for (let i = 0; i < videoData.length; ++i) {
            let video = videoData[i];
            $(".list-container").append(creatItem(video.coverPath, video.title, video.createTime, video.playNumber, video.starNumber, video.id));
        }
        $("#list-number").html(videoData.length);
        $("");
    }).fail(function(jqXHR, textStatus, errorThrown) {
        // 处理错误响应
        console.log("请求失败：" + errorThrown);
        redirectLogin();
    });
}

