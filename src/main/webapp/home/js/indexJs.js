// 界面滚动事件
window.onscroll = function () {
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    changeNav(t);
}
// 改变nav样式
function changeNav(t){
    if (t > 10){
        $('.nav-left>a').css('color', 'black');
        $('.nav-right>a').css('color', 'black');
        $('.nav').css('background','white');
        //设置工具栏可见
        $('.tools').css('display','inline');
    }else {
        $('.nav-left>a').css('color', 'white');
        $('.nav-right>a').css('color', 'white');
        $('.nav').css('border-bottom','none');
        $('.nav').css('background','none');
        $('.nav').css('box-shadow','');
        //设置工具栏隐藏
        $('.tools').css('display','none');
    }
}
//刷新事件
$('.reload').click(function (){
    location.reload();
})
// 回到顶端事件
function back() {
    // 平滑滚动
    window.scrollTo({top:0,behavior: "smooth"});
}