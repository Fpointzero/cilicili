// 界面滚动事件
let videoList = {};
let slideList = {};
window.onscroll = function () {
    let t = document.documentElement.scrollTop || document.body.scrollTop;
    changeNav(t);
}
window.onload = function () {
    let data = {"page_info": {"page": 3, "size": 15}}
    $.ajax({
        url: "http://124.220.20.83:8080/home/getHomeInfo",
        method: "POST",
        dataType: "json",
        contentType: 'application/json;',
        data: JSON.stringify(data),
        sync: false,
        success: function (res) {
            console.log(res)
            slideList = res["data"]['rotograph'];
            for (let i = 0; i < slideList.length; i++) {
                addSlideImages(slideList[i]['cover']);
            }
        },
    });
    $.ajax({
        url: "/cilicili_war/api/video/getVideos",
        method: "GET",
        dataType: "json",
        sync: false,
        success: function (res) {
            console.log(res)
            videoList = res["data"];
            for (let i = 0; i < videoList.length; i++) {
                if (i > 5) {
                    createVideoCard(videoList[i]["coverPath"], videoList[i]["id"], videoList[i]["title"], videoList[i]["username"], videoList[i]["createTime"], false)
                } else {
                    createVideoCard(videoList[i]["coverPath"], videoList[i]["id"], videoList[i]["title"], videoList[i]["username"], videoList[i]["createTime"], true)
                }
            }
            initClick();
        },
    });
    // $.ajax({
    //     url: "/cilicili_war/api/video/getVideos",
    //     method: "GET",
    //     dataType: "json",
    //     sync: false,
    //     success: function (res) {
    //         console.log(res)
    //         videoList = res["data"];
    //         for (let i = 6; i < videoList.length; i++) {
    //             createVideoCard(videoList[i]["coverPath"], videoList[i]["id"], videoList[i]["title"], videoList[i]["username"], videoList[i]["createTime"], false)
    //         }
    //
    //     },
    // });
}

// 改变nav样式
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

//刷新事件
$('.reload').click(function () {
    location.reload();
})

// 回到顶端事件
function back() {
    // 平滑滚动
    window.scrollTo({top: 0, behavior: "smooth"});
}

function addSlideImages(path) {
    // 创建img元素
    let img = document.createElement('img');
    img.src = path; // 设置图片路径
    // 可以添加更多的样式或属性
    img.alt = 'Banner Image'; // 设置替代文本
    // 将创建的img元素添加到容器中
    $('.banner-img-container').append(img);
}

function createVideoCard(imagePath, id, title, subtitle, time, flag) {
    // 创建 video-card 容器
    let card = document.createElement('div');
    card.className = 'video-card';
    card.id = id;

    // 创建图片元素
    let img = document.createElement('img');
    img.src = imagePath;
    img.alt = title; // 可以根据实际需要设置一个更合适的alt文本

    // 创建 video-card-info 容器
    let cardInfo = document.createElement('div');
    cardInfo.className = 'video-card-info';

    // 创建标题的<p>元素
    let titleElement = document.createElement('p');
    titleElement.textContent = title;

    // 创建副标题的<p>元素
    let subtitleElement = document.createElement('p');
    subtitle = subtitle + " · " + timeSince(time);
    subtitleElement.textContent = subtitle;

    // 将元素添加到对应的容器中
    cardInfo.appendChild(titleElement);
    cardInfo.appendChild(subtitleElement);

    card.appendChild(img);
    card.appendChild(cardInfo);

    if (flag) {
        $('.video-card-box').append(card);
    } else {
        $('.video-card-box2').append(card);
    }

}

function timeSince(dateString) {
    const now = new Date();
    const pastDate = new Date(dateString);
    const timeDiff = now - pastDate; // 差异（毫秒）

    // 检查时间差异是否小于1小时
    if (timeDiff < 1000 * 60 * 60) {
        return '刚刚';
    }
    // 检查时间差异是否小于24小时
    else if (timeDiff < 1000 * 60 * 60 * 24) {
        const hours = Math.floor(timeDiff / (1000 * 60 * 60));
        return `${hours}小时前`;
    }
    // 如果时间差异大于或等于24小时，返回年月日
    else {
        return pastDate.toLocaleDateString(undefined, {year: 'numeric', month: 'numeric', day: 'numeric'});
    }
}

$("#upload").on("click", function () {
    window.location.href = "creation.html";
});

function initClick() {
    const videoCards = document.querySelectorAll('.video-card');
    console.log(videoCards.length)
    videoCards.forEach(card => {
        card.addEventListener('click', function () {
            // 获取 data-video-id 属性值
            const videoId = card.getAttribute('id');
            console.log(videoId)
            window.location.href = `video.html?vid=${videoId}`;
        });
    });
}




