$('#userInfoForm').on('submit', function (e) {
    // 阻止默认表单提交行为
    e.preventDefault();
    // 获取新密码和验证码的值
    let username = $('#username').val();

    // 确保用户名字段非空
    if (!username) {
        alert('用户名是必填项。');
        return;
    }
    data = {
        'username': username,
    }
    // 发送ajax请求到服务器
    $.ajax({
        url: '/cilicili_war/api/user/userInfo',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (res) {
            console.log(res);
            alert(res['msg']);
            $('#username').val('');
            window.location.reload();
        },
        error: function (xhr, status, error) {
            alert('修改时发生错误：' + error);
        }
    });
});