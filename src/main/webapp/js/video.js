let vid;
let action;
let starNum;
window.onload = function () {
    let flag = false;
    vid = UrlParam.paramValues("vid")[0];
    console.log(vid)
    let data = {
        "vid": vid
    }
    $.ajax({
        url: "/cilicili_war/api/user/starInfo",
        method: "GET",
        dataType: "json",
        sync: false,
        success: function (res) {
            let starList = res['data'];
            console.log(starList)
            for (let i = 0; i < starList.length; i++) {
                if (vid == starList[i]['vid']) {
                    flag = true
                }
            }
            if (flag) {
                $("#starImg").attr('src','./images/已收藏.png');
                action = "unset";
            } else {
                $('#starImg').attr('src','./images/未收藏.png')
                action = "set";
            }
        },
    });
    $.ajax({
        url: "/cilicili_war/api/video/getVideo",
        method: "POST",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        sync: false,
        success: function (res) {
            let video = res['data'];
            console.log(video)
            $('#video-title').html(video['title']);
            $('#video').attr('src', video['videoPath']);
            $('#introduction').html(video['subtitle']);
            $('#playNum').append(video['playNumber']);
            $('#starNum').append(video['starNumber']);
            $('.name').text(video['username']);
            starNum = video['starNumber'];
        },
    });
}

function star() {
    let data = {
        "vid": vid,
        "action": action
    }
    if (!isUserLoggedIn()) {
        alert("请先登入");
    } else {
        $.ajax({
            url: "/cilicili_war/api/user/starInfo",
            method: "POST",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            sync: false,
            success: function (res) {
                if (action === "set"){
                    $("#starImg").attr('src','./images/已收藏.png');
                    action = "unset";
                    starNum++;
                    starRemove();
                    $('#starNum').append(starNum);
                }else {
                    $("#starImg").attr('src','./images/未收藏.png');
                    action = "set";
                    starNum--;
                    starRemove();
                    $('#starNum').append(starNum);
                }
            },
        });
    }

}

$(document).ready(function () {
    let video = $('video')[0];
    video.autoplay = true;
    video.play();
});
function starRemove() {
    $('#starNum').contents().filter(function() {
        return this.nodeType === 3;
    }).remove();
}
