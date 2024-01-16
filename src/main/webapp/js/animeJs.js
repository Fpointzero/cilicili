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
        $('.tools>div:nth-of-type(2)').css('display','inline');
    }else {
        $('.nav-left>a').css('color', 'white');
        $('.nav-right>a').css('color', 'white');
        $('.nav').css('border-bottom','none');
        $('.nav').css('background','none');
        $('.nav').css('background-image','linear-gradient(to bottom,rgba(0,0,0,0.3),transparent)');
        $('.nav').css('box-shadow','');
        //设置工具栏隐藏
        $('.tools>div:nth-of-type(2)').css('display','none');
    }
}
// 回到顶端事件
function back() {
    // 平滑滚动
    window.scrollTo({top:0,behavior: "smooth"});
}

// 头部背景 图片切换
// 新建数组存放items
var items = new Array();
// for循环放入所有对象
for (var i = 1; i <= 7; i++) {
    items.push($('.items-box>div:nth-of-type('+i+')'));
}
// 获取背景图片展示框 之后用于左右移动 实现切换展示图片的效果
var bg = $('.bg-box');
// 鼠标移入事件
$('.items-box>div').hover(function (e) {
    var target = e.target;
    // 如果选择中了div下的img或者span标签 则让target重新赋值为div
    if ($(target).is('.items-box>div>img')||$(target).is('.items-box>div>span')){
        target = $(target).parent('div');
    }
    // 判断当前对象是父元素的第几个子元素 规定父元素为.items-box
    switch ($(target).index('.items-box>div')) {
        case 0:
            bg.css('left', '0px');
            break;
        case 1:
            bg.css('left', -1905+'px');
            break;
        case 2:
            bg.css('left', -1905*2+'px');
            break;
        case 3:
            bg.css('left', -1905*3+'px');
            break;
        case 4:
            bg.css('left', -1905*4+'px');
            break;
        case 5:
            bg.css('left', -1905*5+'px');
            break;
        case 6:
            bg.css('left', -1905*6+'px');
            break;
    }
});


// 热播番剧 左右滑动方法
function slidToRight(){
    $('.popular-anime-showBox').css('transform','translateX(-1630px)');
    $('.popular-anime>div:nth-of-type(3)').css('display','flex');
    $('.popular-anime>div:nth-of-type(2)').css('display','none');
}
function slidToLeft(){
    if (!$('.popular-anime-showBox').position().left == 0){
        $('.popular-anime-showBox').css('transform','translateX(0)');
        $('.popular-anime>div:nth-of-type(3)').css('display','none');
        $('.popular-anime>div:nth-of-type(2)').css('display','flex');
    }
}
