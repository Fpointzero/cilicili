<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--=============== REMIXICONS ===============-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/3.5.0/remixicon.css">
    <%--    <script src="https://unpkg.com/vue@next"></script>--%>
    <link rel="stylesheet" href="static/css/index.css">

    <title>C哩C哩</title>
</head>

<body>
<div id="app">
    <!--==================== HEADER ====================-->
    <header class="header" id="header">
        <nav class="nav container">
            <a href="#" class="nav__logo">CiliCili</a>

            <div class="nav__menu" id="nav-menu">
                <ul class="nav__list">
                    <li class="nav__item">
                        <a href="#" class="nav__link">Home</a>
                    </li>

                    <li class="nav__item">
                        <a href="#" class="nav__link">About Us</a>
                    </li>

                    <li class="nav__item">
                        <a href="#" class="nav__link">Profile</a>
                    </li>
                </ul>

                <!-- Phone -->
                <div class="nav__close" id="nav-close">
                    <i class="ri-close-line"></i>
                </div>
            </div>

            <div class="nav__actions">
                <i class="ri-search-line nav__search" id="search-btn"></i>
                <i class="ri-user-line nav__login" id="login-btn"></i>
                <div class="nav__toggle" id="nav-toggle">
                    <i class="ri-menu-line"></i>
                </div>
            </div>
        </nav>
    </header>

    <!--==================== SEARCH ====================-->
    <div class="search" id="search">
        <form action="" class="search_form">
            <i class="ri-search-line search__icon"></i>
            <input type="search" placeholder="What are you looking for?" class="search_input">
        </form>

        <i class="ri-close-line action_close" id="search-close"></i>
    </div>

    <!--==================== LOGIN ====================-->
    <div class="login" id="login">
        <form action="" class="action_form">
            <h2 class="action_title">Log In</h2>

            <div class="action_group">
                <div>
                    <label for="login-email" class="action_label">Email</label>
                    <input type="email" placeholder="Write your email" id="login-email" class="action_input">
                </div>

                <div>
                    <label for="login-password" class="action_label">Password</label>
                    <input type="password" placeholder="Enter your password" id="login-password" class="action_input">
                </div>
            </div>

            <div>
                <p class="action_signup">
                    You do not have an account? <a href="#" id="login-signup">Sign up</a>
                </p>

                <a href="#" class="action_forgot" id="login-forget">
                    You forgot your password
                </a>

                <button type="submit" class="action_button" id="login_btn">Log In</button>
            </div>
        </form>

        <i class="ri-close-line action_close" id="login-close"></i>
    </div>
    <!--==================== Register ====================-->
    <div class="register" id="register">
        <form action="" class="action_form">
            <h2 class="action_title">Sign Up</h2>

            <div class="action_group">
                <div>
                    <label for="register-email" class="action_label">Email</label>
                    <input type="email" placeholder="Write your email" id="register-email" class="action_input">
                </div>
                <div>
                    <label for="name" class="action_label">Name</label>
                    <input type="name" placeholder="Write your name" id="name" class="action_input">
                </div>
                <div>
                    <label for="register-password" class="action_label">Password</label>
                    <input type="password" placeholder="Enter your password" id="register-password"
                           class="action_input">
                </div>
                <div>
                    <label for="register-code" class="action_label">Code</label>
                    <div class="send_box">
                        <input type="code" placeholder="Check Your Email For Code" id="register-code"
                               class="action_input">
                        <button class="send_codeBtn" id="register-codeBtn">send</button>
                    </div>
                </div>
            </div>

            <div>
                <p class="action_login">
                    Already have an account <a href="#" id="register-login">Log In</a>
                </p>

                <button type="submit" class="action_button">Sign Up</button>
            </div>
        </form>

        <i class="ri-close-line action_close" id="register-close"></i>
    </div>
    <!--==================== Forget ====================-->
    <div class="forget" id="forget">
        <form action="" class="action_form">
            <h2 class="action_title">Change Passwd</h2>

            <div class="action_group">
                <div>
                    <label for="register-email" class="action_label">Email</label>
                    <input type="email" placeholder="Write your email" id="forget-email" class="action_input">
                </div>
                <div>
                    <label for="register-password" class="action_label">Password</label>
                    <input type="password" placeholder="Enter your new password" id="forget-password"
                           class="action_input">
                </div>
                <div>
                    <label for="forget-code" class="action_label">Code</label>
                    <div class="send_box">
                        <input type="code" placeholder="Check Your Email For Code" id="forget-code"
                               class="action_input">
                        <button class="send_codeBtn" id="forget_codeBtn">send</button>
                    </div>
                </div>
            </div>

            <div>
                <p class="action_login">
                    Already remember account <a href="#" id="forget-login">Log In</a>
                </p>

                <button type="submit" class="action_button">Change</button>
            </div>
        </form>

        <i class="ri-close-line action_close" id="forget-close"></i>
    </div>

    <!--==================== MAIN ====================-->
    <main class="main">
        <img src="static/image/bg-image.png" alt="image" class="main__bg">
    </main>
</div>

<script src="static/js/index.js"></script>
</body>
</html>
