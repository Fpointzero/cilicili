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
            if (userObj.id) {
                return true;
            }
        } catch (e) {
            console.error("Parsing user info failed", e);
        }
    }
    return false;
}

function logoutUser() {
    $.ajax({
        url: '/cilicili_war/api/logout',
        dataType: 'json',
        type: 'post',
        success: function (res) {
            console.log(res);
            if (res.code === 200) {
                console.log('logout success');
                document.getElementById('logout').style.display = 'none';
                document.getElementById('login').style.display = 'block';
                window.location.replace('LoginAndRegist.html');
                localStorage.removeItem("user");
            }
        }
    })
    // document.getElementById('logout').style.display = 'none';
    // document.getElementById('login').style.display = 'block';
    // window.location.replace('LoginAndRegist.html');
}