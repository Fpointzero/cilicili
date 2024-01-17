// 界面滚动事件
let videoList = {};
let slideList = {};
window.onscroll = function () {
    let t = document.documentElement.scrollTop || document.body.scrollTop;
    changeNav(t);
}
window.onload = function () {
    let data = {
        "page_info": {
            "page": 1,
            "size": 15
        }
    };
    $.ajax({
        url: "http://124.220.20.83:8080/home/getHomeInfo",
        method: "POST",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            console.log(res)
            slideList = res["data"]["rotograph"];
            for (let i = 0; i < slideList.length; i++) {
                addSlideImages(slideList[i]["cover"]);
            }
            videoList = res["data"]["videoList"];
            for (let i = 0; i < videoList.length; i++) {
                if (i > 5) {
                    createVideoCard(videoList[i]["cover"], videoList[i]["title"], videoList[i]["username"], videoList[i]["created_at"], false)
                } else {
                    createVideoCard(videoList[i]["cover"], videoList[i]["title"], videoList[i]["username"], videoList[i]["created_at"], true)
                }
            }
        },
    });
    data["page_info"]["page"]++;
    $.ajax({
        url: "http://124.220.20.83:8080/home/getHomeInfo",
        method: "POST",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            console.log(res)
            data = res["data"];
            videoList = data["videoList"];
            for (let i = 0; i < videoList.length; i++) {
                createVideoCard(videoList[i]["cover"], videoList[i]["title"], videoList[i]["username"], videoList[i]["created_at"], false)
            }
        },
    });
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

function createVideoCard(imagePath, title, subtitle, time, flag) {
    // 创建 video-card 容器
    let card = document.createElement('div');
    card.className = 'video-card';

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

// 获取输入框和搜索图标
const input = document.getElementById('keyword');
const searchIcon = document.getElementById('search-icon');

// 监听输入框的keydown事件
input.addEventListener('keydown', function(e) {

    // 检测是否按下了Enter键
    if(e.key === 'Enter') {
        // 防止默认行为
        e.preventDefault();
        // 模拟点击搜索按钮
        searchIcon.click();
    }
});

// 为搜索图标添加点击事件监听
searchIcon.addEventListener('click', async () => {
    // 判断输入框是否有内容
    if(input.value.trim()) {
        // 跳转到search页面,同时传递搜索关键词
        window.location.href = `Search.html?keyword=${input.value.trim()}`;
    } else {
        // 输入框无内容,提示用户输入
        alert('请输入搜索内容');
    }
});

$("#upload").on("click", function () {
    window.location.href = "creation.html";
});


