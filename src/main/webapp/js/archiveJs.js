let videoList = {}

window.onscroll = function (){
    let t = document.documentElement.scrollTop || document.body.scrollTop;
    changeNav(t);
}

window.onload = function (){
    $.ajax({
        url: "/cilicili_war/api/user/historyInfo",
        method: "GET",
        dataType: "json",
        success: function (res) {
            console.log(res)
            if (res.code != 200) {
                console.log("error");
                return;
            }
            videoList = res.data;
            for (let i = 0; i < videoList.length; i++) {
                $(".history-list").append(createArchiveCard(videoList[i]["coverPath"], videoList[i]["createTime"],
                    videoList[i]["videoPath"],videoList[i]["Title"],videoList[i]["subtitle"]));
            }
        },
    });
}

function createArchiveCard(coverPath,createTime,videoPath,Title,subTitle){
    let str = "";
    str += `<li class="history-record">
                    <div class="l-info">
                        <div class="timeStamp">
                            <span class="time">0:22</span>
                        </div>
                    </div>

                    <div class="r-info">
                        <div class="cover-container">
                            <a class="preview" target="_blank" href="Your video path">
                                <div class="videoImage">
                                    <img src="${coverPath}" class="videoimg">
                                </div>
                            </a>
                        </div>
                        <div class="r-text">
                            <a class="videoTitle" target="_blank" href="${videoPath}">${Title}</a>
                            <p class="Subtitle">${subTitle}</p>
                            <div class="upInfo">
                                <a class="up-info" target="_blank" href="${videoPath}">
                                    <span class="up-info-text">up主信息</span>
                                </a>
                            </div>
                        </div>

                    </div>
                </li>`;

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
        $('.nav-left>a').css('color', 'white');
        $('.nav-right>a').css('color', 'white');
        $('.nav').css('border-bottom', 'none');
        $('.nav').css('background', 'none');
        $('.nav').css('box-shadow', '');
        //设置工具栏隐藏
        $('.tools').css('display', 'none');
    }
}