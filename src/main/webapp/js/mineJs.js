// 页面加载时执行的方法
try {
    user = JSON.parse(localStorage.getItem("user"));
} catch (e) {
    console.log(e);
}

window.onload = function () {
    var a1 = $('.hidden-nav .hiddenNav-left>a:nth-of-type(1)');
    var a2 = $('.content-nav .hiddenNav-left>a:nth-of-type(1)');
    a1.css('color', '#00A1D6');
    a2.css('color', '#00A1D6');
    $('.hidden-nav .hiddenNav-left>div').css('width', a1.width());
    $('.content-nav .hiddenNav-left>div').css('width', a2.width());
    hiddenNavItems();

    $.ajax({
        url: "/cilicili_war/api/video/getUserVideo",
        method: "POST",
        dataType: "json",
        data: JSON.stringify({
            "uid": user.id
        }),
        contentType: "application/json",
        success: function (res) {
            console.log(res)
            if (res.code != 200) {
                console.log("error");
                return;
            }
            videoList = res.data;
            for (let i = 0; i < videoList.length; i++) {
                $(".mine-video-content").append(createStarCard(videoList[i].coverPath, videoList[i].playNumber, videoList[i].createTime, videoList[i].id, videoList[i].title));
            }
        },
    });
}

function createStarCard(coverPath, playNumber, createTime, vid, title) {
    var dateString = createTime;
    var formattedDate = new Date(dateString).toISOString().split("T")[0];
    // console.log(formattedDate);
    let str = "";
    str += `<div class="video-card">
                <img src="${coverPath}">
                    <p>${title}</p>
                    <div class="video-card-info">
                        <img src="images/投稿.png">
                        <p>${playNumber}</p>
                        <p style="font-size: 10px">${formattedDate}</p>
                    </div>
            </div>`;
    // str +=
    //     `<div class="video-item">
    //         <a class="video-box" target="_blank" href="./video.html?vid=${vid}">
    //             <img  class="video-img" src="${coverPath}">
    //         </a>
    //         <a class="video-info" target="_blank" href="./video.html?vid=${vid}">${title}</a>
    //         <span class="time-stamp">发布于：${createTime}</span>
    //     </div>`;
    let node = $(str);
    let img = node.children("img");
    img.click(function () {
        location.href = "./video.html?vid=" + vid;
    });
    img.css("cursor", "pointer");

    return node;
}

// 隐藏nav的滑动监听事件
window.onscroll = function () {
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    if (t > 323) {
        $('.hidden-nav').css('transform', 'translateY(70px)');
    } else {
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

user = localStorage.getItem("user");
try {
    user = JSON.parse(user);
} catch (e) {
    console.log(e);
}
if (user != null) {
    $(".username").html(user.username);
} else {
    $(".username").html("请登录");
}
