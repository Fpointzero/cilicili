window.onload = function () {
    let data = {"page_info": {"page": 1, "size": 15}}
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
            for (let i = 0; i < 6; i++) {
                createVideoCard(videoList[i]["cover"], videoList[i]["title"], videoList[i]["username"], videoList[i]["created_at"])
            }
        },
    });
}

function createVideoCard(imagePath, title, subtitle, time) {
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