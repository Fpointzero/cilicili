user = localStorage.getItem("user");
try {
    user = JSON.parse(user);
    $('.name').text(user['username']);
} catch (e) {
    alert('请先登入');
    window.location.href = 'index.html';
}

const body = document.querySelector('body'),
    shell = body.querySelector('div'),
    toggle = body.querySelector(".toggle"),
    modeSwitch = body.querySelector(".toggle-switch"),
    modeText = body.querySelector(".mode-text"),
    main = body.querySelector(".main-content")
// 点击toggle元素时触发事件
toggle.addEventListener("click", () => {
    // 切换shell元素的close类
    shell.classList.toggle("close");
})
main.addEventListener("click", () => {
    // 切换shell元素的close类
    shell.classList.add("close");
})

// 点击modeSwitch元素时触发事件
modeSwitch.addEventListener("click", () => {
    // 切换body元素的dark类
    body.classList.toggle("dark");
    // 如果body元素包含dark类
    if (body.classList.contains("dark")) {
        modeText.innerText = "白日模式";
    } else {
        modeText.innerText = "夜间模式";
    }
});
document.addEventListener('DOMContentLoaded', function () {
    // 获取侧边栏中的链接
    let infoLink = document.querySelector('.nav-link a[href="#info"]');
    let changePwdLink = document.querySelector('.nav-link a[href="#changePwd"]');

    // 获取主内容区域中的两个部分
    let infoContent = document.querySelector('.main-content .info');
    let changePwdContent = document.querySelector('.main-content .changePwd');

    // 隐藏所有内容区域
    function hideAllContent() {
        infoContent.style.display = 'none';
        changePwdContent.style.display = 'none';
    }

    // 显示个人信息内容区域
    function showInfoContent() {
        hideAllContent();
        infoContent.style.display = 'block';
    }

    // 显示修改密码内容区域
    function showChangePwdContent() {
        hideAllContent();
        changePwdContent.style.display = 'block';
    }

    // 给个人信息链接添加点击事件监听器
    infoLink.addEventListener('click', function (e) {
        e.preventDefault(); // 阻止默认点击事件
        showInfoContent();
    });

    // 给修改密码链接添加点击事件监听器
    changePwdLink.addEventListener('click', function (e) {
        e.preventDefault(); // 阻止默认点击事件
        showChangePwdContent();
    });
});
