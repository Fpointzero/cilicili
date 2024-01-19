user = localStorage.getItem("user");
let email
try {
    user = JSON.parse(user);
    email = user['email'];
} catch (e) {
}
console.log(email)
$('#sendCode').on('click', function () {
    $(this).prop('disabled', true);
    let countdown = 60;
    $(this).text(countdown + '秒后重新发送');

    let intervalId = setInterval(function () {
        countdown--;
        $('#sendCode').text(countdown + '秒后重新发送');
        if (countdown === 0) {
            clearInterval(intervalId);
            $('#sendCode').text('发送验证码').prop('disabled', false);
        }
    }, 1000);
    let data = {
        'email': email,
    }
    $.ajax({
        url: '/cilicili_war/api/sendEmail',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function (res) {
            console.log(res);
        },
        error: function (xhr, status, error) {
            $('#sendCode').text('发送验证码').prop('disabled', false);
            alert('发送验证码时发生错误。');
        }
    });
});
$('#changePasswordForm').on('submit', function (e) {
    // 阻止默认表单提交行为
    e.preventDefault();
    // 获取新密码和验证码的值
    let pwd = $('#newPassword').val();
    let code = $('#verificationCode').val();

    // 确保新密码和验证码字段非空
    if (!pwd || !code) {
        alert('新密码和验证码是必填项。');
        return;
    }
    data = {
        'email': email,
        'code': code,
        'password': CryptoJS.MD5(pwd).toString()
    }
    console.log(data);
    // 发送ajax请求到服务器
    $.ajax({
        url: '/cilicili_war/api/changePassword',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (res) {
            console.log(res);
            alert(res['msg']);
            $('#newPassword').val('');
            $('#verificationCode').val('');
            window.location.reload();
        },
        error: function (xhr, status, error) {
            alert('修改密码时发生错误：' + error);
        }
    });
});