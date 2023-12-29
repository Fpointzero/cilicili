<%--
  Created by IntelliJ IDEA.
  User: FPoint
  Date: 2023/12/29
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--=============== REMIXICONS ===============-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/3.5.0/remixicon.css">

    <link rel="stylesheet" href="static/css/index.css">

    <title>C哩C哩</title>
</head>

<body>
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
                    <a href="#" class="nav__link">Contact Me</a>
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
    <form action="" class="search__form">
        <i class="ri-search-line search__icon"></i>
        <input type="search" placeholder="What are you looking for?" class="search__input">
    </form>

    <i class="ri-close-line search__close" id="search-close"></i>
</div>

<!--==================== LOGIN ====================-->
<div class="login" id="login">
    <form action="" class="login__form">
        <h2 class="login__title">Log In</h2>

        <div class="login__group">
            <div>
                <label for="login-email" class="login__label">Email</label>
                <input type="email" placeholder="Write your email" id="login-email" class="login__input">
            </div>

            <div>
                <label for="login-password" class="login__label">Password</label>
                <input type="password" placeholder="Enter your password" id="login-password" class="login__input">
            </div>
        </div>

        <div>
            <p class="login__signup">
                You do not have an account? <a href="#" id="login-signup">Sign up</a>
            </p>

            <a href="#" class="login__forgot">
                You forgot your password
            </a>

            <button type="submit" class="login__button">Log In</button>
        </div>
    </form>

    <i class="ri-close-line login__close" id="login-close"></i>
</div>
<!--==================== Register ====================-->
<div class="register" id="register">
    <form action="" class="register__form">
        <h2 class="register__title">Sign Up</h2>

        <div class="register__group">
            <div>
                <label for="register-email" class="register__label">Email</label>
                <input type="email" placeholder="Write your email" id="register-email" class="register__input">
            </div>
            <div>
                <label for="name" class="register__label">Name</label>
                <input type="name" placeholder="Write your name" id="name" class="register__input">
            </div>
            <div>
                <label for="register-password" class="register__label">Password</label>
                <input type="password" placeholder="Enter your password" id="register-password" class="register__input">
            </div>
            <div>
                <label for="code" class="register__label">Code</label>
                <div class="send_box">
                    <input type="code" placeholder="Check Your Email For Code" id="code" class="register__input">
                    <button class="send_codeBtn" id="send_codeBtn">send</button>
                </div>
            </div>
        </div>

        <div>
            <p class="register__login">
                Already have an account <a href="#" id="register-login">Log In</a>
            </p>

            <button type="submit" class="register__button">Sign Up</button>
        </div>
    </form>

    <i class="ri-close-line register__close" id="register-close"></i>
</div>

<!--==================== MAIN ====================-->
<main class="main">
    <img src="static/image/bg-image.png" alt="image" class="main__bg">
</main>

<!--=============== MAIN JS ===============-->
<script src="static/js/index.js"></script>
</body>

</html>
