window.onload = function () {
    let vid = UrlParam.paramValues("vid")[0];
    let data = {
        "vid": vid
    }
    $.ajax({
        url: "/cilicili_war/api/video/getVideo",
        method: "POST",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        sync: false,
        success: function (res) {
            let video = res['data'];
            console.log(video)
            $('#video-title').html(video['title']);
            $('#video').attr('src', video['videoPath']);
            $('#introduction').html(video['subtitle'])
        },
    });
}
$(document).ready(function() {
   let video = $('video')[0];
   video.autoplay = true;
   video.play();
});
