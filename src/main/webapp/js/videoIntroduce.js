function init() {
    $.ajax({
        url: "/cilicili_war/api/video/getVideos",
        method: "GET",
        dataType: "json",
        sync: false,
        success: function (res) {
            console.log(res)
            videoList = res["data"];
            shuffleArray(videoList);
            const selectedVideos = videoList.slice(0, 6);
            for (let i = 0; i < selectedVideos.length; i++) {
                createVideoCard(videoList[i]["coverPath"], videoList[i]["id"], videoList[i]["title"], videoList[i]["username"], videoList[i]["createTime"])
            }
            initClick();
        },
    });
}

function createVideoCard(imagePath, id, title, subtitle, time) {
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

    $('.video-card-box').append(card);


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
function shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
}
init()