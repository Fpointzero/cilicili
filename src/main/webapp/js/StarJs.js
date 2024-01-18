let videoList = {}

window.onscroll = function (){
    let t = document.documentElement.scrollTop || document.body.scrollTop;
    changeNav(t);
}

window.onload = function (){
    $.ajax({
        url: "/cilicili_war/api/user/starInfo",
        method: "GET",
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            console.log(res)
            if (res.code != 200) {
                console.log("error");
                return;
            }
            videoList = res.data;
            for (let i = 0; i < videoList.length; i++) {
                $(".Collection-list").append(createStarCard(videoList[i].coverPath, videoList[i].createTime,videoList[i].vid,videoList[i].title));
            }
        },
    });
}

function createStarCard(coverPath,starTime,vid,title){
    let str = "";
    str += `<div class="video-item">
                <a class="video-box" target="_blank" href="./video.html?vid=${vid}">
                    <img  class="video-img" src="${coverPath}">
                </a>
                <a class="video-info" target="_blank" href="./video.html?vid=${vid}">${title}</a>
                <span class="time-stamp">收藏于：${starTime}</span>
            </div>`;
    let node = $(str);

    return node;
}

function changeNav(t) {
    if (t > 10) {
        $('.nav-left>a').css('color', 'black');
        $('.nav-right>a').css('color', 'black');
        $('.nav').css('background', 'white');
        //设置工具栏可见
        $('.tools').css('display', 'inline');
    } else {
        $('.nav-left>a').css('color', 'black');
        $('.nav-right>a').css('color', 'black');
        $('.nav').css('border-bottom', 'none');
        $('.nav').css('background', 'none');
        $('.nav').css('box-shadow', '');
        //设置工具栏隐藏
        $('.tools').css('display', 'none');
    }
}

$(".username").html(user.username);