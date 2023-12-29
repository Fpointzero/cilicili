/*=============== SHOW MENU ===============*/
const navMenu = document.getElementById('nav-menu'),
    navToggle = document.getElementById('nav-toggle'),
    navClose = document.getElementById('nav-close')

/* Menu show */
navToggle.addEventListener('click', () => {
    navMenu.classList.add('show-menu')
})

/* Menu hidden */
navClose.addEventListener('click', () => {
    navMenu.classList.remove('show-menu')
})

/*=============== SEARCH ===============*/
const search = document.getElementById('search'),
    searchBtn = document.getElementById('search-btn'),
    searchClose = document.getElementById('search-close')

/* Search show */
searchBtn.addEventListener('click', () => {
    search.classList.add('show-search')
})

/* Search hidden */
searchClose.addEventListener('click', () => {
    search.classList.remove('show-search')
})

/*=============== LOGIN ===============*/
const login = document.getElementById('login'),
    loginBtn = document.getElementById('login-btn'),
    loginClose = document.getElementById('login-close')
loginSignup = document.getElementById('login-signup')

/* Login show */
loginBtn.addEventListener('click', () => {
    login.classList.add('show-login')
})

/* Login hidden */
loginClose.addEventListener('click', () => {
    login.classList.remove('show-login')
})

/*=============== Register ===============*/
const register = document.getElementById('register'),
    registerClose = document.getElementById('register-close')
registerLogin = document.getElementById('register-login')

/* Register show */
loginSignup.addEventListener('click', () => {
    register.classList.add('show-register')
    login.classList.remove('show-login')
})

registerLogin.addEventListener('click', () => {
    login.classList.add('show-login')
    register.classList.remove('show-register')
})

/* Register hidden */
registerClose.addEventListener('click', () => {
    register.classList.remove('show-register')
})