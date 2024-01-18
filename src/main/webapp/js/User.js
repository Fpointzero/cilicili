document.addEventListener('DOMContentLoaded', function() {
    if (isUserLoggedIn()) {
        document.getElementById('logout').style.display = 'block';
        document.getElementById('login').style.display = 'none';
    } else {
        document.getElementById('logout').style.display = 'none';
        document.getElementById('login').style.display = 'block';
    }
});
function isUserLoggedIn() {
    var userInfo = localStorage.getItem("user");
    if (userInfo) {
        try {
            var userObj = JSON.parse(userInfo);
            if (userObj && userObj.email && userObj.id && userObj.username) {
                return true;
            }
        } catch (e) {
            console.error("Parsing user info failed", e);
        }
    }
    return false;
}

function logoutUser() {
    localStorage.removeItem("user");
    document.getElementById('logout').style.display = 'none';
    document.getElementById('login').style.display = 'block';
    window.location.href = 'LoginAndRegist.html'
}