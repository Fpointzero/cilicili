<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/sidebar.css">
    <link rel="stylesheet" href="static/font/iconfont.css">
</head>

<body>

<nav class="sidebar close">
    <header>
        <div class="image-text">
                <span class="image">
                    <img src="static/image/1.jpg" alt="">
                </span>
            <div class="text logo-text">
                <span class="name">用户</span>
            </div>
        </div>
        <i class="iconfont icon-xiangyoujiantou toggle"></i>
    </header>
    <div class="menu-bar">
        <div class="menu">
            <li class="search-box">
                <i class="iconfont icon-sousuo icon"></i>
                <input type="text" placeholder="搜索...">
            </li>
            <ul class="menu-links">
                <li class="nav-link">
                    <a href="#">
                        <i class="iconfont icon-shouye icon"></i>
                        <span class="text nac-text">空间</span>
                    </a>
                </li>

                <li class="nav-link">
                    <a href="#">
                        <i class="iconfont icon-shoucang icon"></i>
                        <span class="text nac-text">收藏</span>
                    </a>
                </li>

                <li class="nav-link">
                    <a href="#">
                        <i class="iconfont icon-lishi icon"></i>
                        <span class="text nac-text">历史</span>
                    </a>
                </li>

                <li class="nav-link">
                    <a href="#">
                        <i class="iconfont icon-xiaoxi icon"></i>
                        <span class="text nac-text">消息</span>
                    </a>
                </li>

                <li class="nav-link">
                    <a href="#">
                        <i class="iconfont icon-fensi icon"></i>
                        <span class="text nac-text">粉丝</span>
                    </a>
                </li>

                <li class="nav-link">
                    <a href="#">
                        <i class="iconfont icon-chuangzuo icon"></i>
                        <span class="text nac-text">创作中心</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="bottom-content">
            <li class="">
                <a href="#">
                    <i class="iconfont icon-zhuxiao icon"></i>
                    <span class="text nac-text">注销</span>
                </a>
            </li>
            <li class="mode">
                <div class="sun-moon">
                    <i class="iconfont icon-rijian icon sun"></i>
                    <i class="iconfont icon-yejian icon moon"></i>
                </div>
                <span class="mode-text text">夜间模式</span>
                <div class="toggle-switch">
                    <span class="switch"></span>
                </div>
            </li>
        </div>
    </div>

</nav>

</body>


<script>

    const body = document.querySelector('body'),
        shell = body.querySelector('nav'),
        toggle = body.querySelector(".toggle"),
        searchBtn = body.querySelector(".search-box"),
        modeSwitch = body.querySelector(".toggle-switch"),
        modeText = body.querySelector(".mode-text");
    // 点击toggle元素时触发事件
    toggle.addEventListener("click", () => {
        // 切换shell元素的close类
        shell.classList.toggle("close");
    })
    // 点击searchBtn元素时触发事件
    searchBtn.addEventListener("click", () => {
        // 移除shell元素的close类
        shell.classList.remove("close");
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


</script>

</html>