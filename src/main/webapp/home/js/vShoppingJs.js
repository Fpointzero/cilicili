var s1 = $('.header-channel-select>a:nth-of-type(1)');
var s2 = $('.header-channel-select>a:nth-of-type(2)');
s1.css('font-weight', 'bold');
s1.css('color','#212121');
s1.css('box-shadow','5px 5px 5px #cccccc');
// 获取展示界面对象
var c1 = $('.content-box1');
var c2 = $('.content-box2');

// 漫展演出按钮事件
function selectOne() {
    s1.css('font-weight', 'bold');
    s1.css('color','#212121');
    s1.css('box-shadow','5px 5px 5px #cccccc');
    s2.css('font-weight', 'normal');
    s2.css('color','#BCBCBC');
    s2.css('box-shadow','none');
    c1.css('transform', 'rotateY(0deg)')
    c2.css('transform', 'rotateY(180deg)')
}
// B站周边按钮事件
function selectTwo() {
    s2.css('font-weight', 'bold');
    s2.css('color','#212121');
    s2.css('box-shadow','5px 5px 5px #cccccc');
    s1.css('font-weight', 'normal');
    s1.css('color','#BCBCBC');
    s1.css('box-shadow','none');
    c1.css('transform', 'rotateY(540deg)')
    c2.css('transform', 'rotateY(720deg)')
}
// 内容1 2的翻转
