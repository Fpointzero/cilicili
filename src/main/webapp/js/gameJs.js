//1.获取ul
var cur_ul = document.getElementById('banner')
// 2.创建一个数组实例
var arr = new Array();
// 声明一个定时器，然后把轮播图函数放进间歇函数，3秒进行一次轮播
var timer = setInterval(get_next, 3000)

// 用js来创建li、img元素，有多少张图片要轮播就循环多少次
for (i = 1; i <= 3; i++) {
    // 创建li元素
    var cur_li = document.createElement('li')
    // 创建img元素
    var cur_img = document.createElement('img')
    // 给img元素设置src、width、height属性
    // 这里src是轮播图的路径
    // 在img文件夹下的图片命名为1.jpg、2.jpg、3.jpg....才可以这样写
    cur_img.src = '../images/' + i + '.jpg';
    cur_img.style.width = '660px';
    cur_img.style.height = '220px';
    // 把img元素插入到创建的li里面
    cur_li.appendChild(cur_img);
    // 然后在把li插入到ul里面
    cur_ul.appendChild(cur_li);
    // 然后给ul元素设置事件，鼠标移进来停止轮播
    cur_ul.onmouseenter = function () {
        // 清除定时器
        clearInterval(timer);
        pre_img.style.display = 'inline';
        pre_img.style.animation = 'display 0.5s ease-in-out';
        next_img.style.display = 'inline';
        next_img.style.animation = 'display 0.5s ease-in-out';
    }
    // 鼠标移出ul又继续轮播图片
    cur_ul.onmouseleave = function () {
        timer = setInterval(get_next, 3000)
        pre_img.style.display = 'none';
        next_img.style.display = 'none';
    }
    // 当创建完一个li（li里已经有img元素）就把li添加到arr数组里
    // arr里存的li 相当于一个对象，在其他地方在把arr里的li取出来，还是指向原来那个，并不是一个新的li
    // 相当于对象的浅拷贝，指针指向问题
    arr.push(cur_li)
}

// 因为所写的轮播图是中间图片放大大，左右两边图片正常，所以要进行下面的操作
// 如果你只需要那种一张张图片轮播，即没有左右两边的轮播图，可以去掉下面代码
// 我们要三张图片进行展示， 左 中 右
var len = arr.length - 1; //2
// 这是取得左边图片并调整位置
arr[len - 2].style.left = '0px';
arr[len - 2].style.top = '40px';
// 这是取得中间图片并调整位置
arr[len - 1].style.left = '220px';
arr[len - 1].style.top = '40px';
// 这是取得右边图片并调整位置
arr[len].style.left = '440px';
arr[len].style.top = '40px';
// 然后中间图片调用scale使其变大
arr[len - 1].style.transform = 'scale(1.4)';
// 中间图片也给其一个较大的堆叠数值，使其中间图片在左右图片上面
arr[len - 1].style.zIndex = 100;

// 封装轮播图函数
// 然后开始进行轮播，原理就是换arr里的li元素的位置，越靠后的li元素z-index越大
// z-index越大，就会叠在其他li元素上面，所以换arr里的li位置就可以实现轮播
function get_next() {
    var give_up = arr[arr.length - 1];//获取arr数值里最后一个li元素
    arr.pop();//删除掉最后一个li元素
    arr.unshift(give_up);//最后把最后一个元素插入到arr数组的前面
    // 然后重新给arr数组里的li元素设置z-index和scale
    // 让三张图片顺序排列且大小相同
    for (var i = 0; i < arr.length; i++) {
        arr[i].style.zIndex = i;
        arr[i].style.transform = 'scale(1)'
    }
    // 和之前一样，对三张图片再次设置位置和大小为展示的样式
    var len = arr.length - 1; //2
    // 这是取得左边图片并调整位置
    arr[len - 2].style.left = '0px';
    arr[len - 2].style.top = '40px';
    // 这是取得中间图片并调整位置
    arr[len - 1].style.left = '220px';
    arr[len - 1].style.top = '40px';
    // 这是取得右边图片并调整位置
    arr[len].style.left = '440px';
    arr[len].style.top = '40px';
    // 然后中间图片调用scale使其变大
    arr[len - 1].style.transform = 'scale(1.4)';
    // 中间图片也给其一个较大的堆叠数值，使其中间图片在左右图片上面
    arr[len - 1].style.zIndex = 100;
}

// 用js创建左箭头
var pre_img = document.createElement('img')
pre_img.src = '../images/左箭头白色.png';//左箭头图片
pre_img.style.position = 'absolute';
pre_img.style.display = 'none';
pre_img.style.top = 0;
pre_img.style.bottom = 0;
pre_img.style.left = 0;
pre_img.style.width = '36px';
pre_img.style.margin = 'auto';
pre_img.style.zIndex = 100;
cur_ul.appendChild(pre_img);

// 用js创建右箭头
var next_img = document.createElement('img')
next_img.src = '../images/右箭头白色.png';//右箭头的图片
next_img.style.position = 'absolute';
next_img.style.display = 'none';
next_img.style.top = 0;
next_img.style.bottom = 0;
next_img.style.right = 0;
next_img.style.width = '36px';
next_img.style.margin = 'auto';
next_img.style.zIndex = 100;
cur_ul.appendChild(next_img);

// 给左箭头点击绑定事件
pre_img.onclick = function () {
    get_pre();
}
// 右箭头的作用就是向前轮播一直图片，和我们上面写的get_next()方法要实现的功能一样，直接引用
next_img.onclick = function () {
    get_next();
}

// 左箭头的绑定事件 和get_next()思路一样，就是要改一下就行。
// 先取出arr数组第一个li，在把这个li放到最后即可
function get_pre() {
    var give_up = arr[0];
    arr.shift();//取出来最后一张图片
    arr.push(give_up);//把最后一张图片放到第一张
    for (var i = 0; i < arr.length; i++) {
        arr[i].style.zIndex = i;
        arr[i].style.transform = 'scale(1)'
    }
    arr[len - 2].style.left = '0px';
    arr[len - 2].style.top = '40px';
    // 这是取得中间图片并调整位置
    arr[len - 1].style.left = '220px';
    arr[len - 1].style.top = '40px';
    // 这是取得右边图片并调整位置
    arr[len].style.left = '440px';
    arr[len].style.top = '40px';
    // 然后中间图片调用scale使其变大
    arr[len - 1].style.transform = 'scale(1.4)';
    // 中间图片也给其一个较大的堆叠数值，使其中间图片在左右图片上面
    arr[len - 1].style.zIndex = 100;
}



// 新游预约样式
// 数组存储items
var gameItems = new Array();
// 把五个items依次存入数组
for (var i = 1; i <= 5;i++) {
    gameItems.push($('.new-game-items>div:nth-of-type('+i+')'));
}
// 设置第一个默认选中
gameItems[0].css('border','2px solid #00A1D6');
gameItems[0].css('opacity','1')
gameItems[0].children('div').children('a').css('color','#18191C');

// 鼠标悬浮hover方法
$('.new-game-items>div').hover(function (e) {
    // 获取鼠标悬浮对象
    var target = e.target;
    if ($(target).is(gameItems[0]) || $(target).is(gameItems[0].children())){
        // 将每个item样式设置为未选中状态
        noSelected();
        // 设置第一个item为选中状态
        onSelected(0);
        // 切换对应背景
        showBgChange(0);
    }else if ($(target).is(gameItems[1]) || $(target).is(gameItems[1].children())){
        noSelected();
        onSelected(1);
        showBgChange(1);
    }else if ($(target).is(gameItems[2]) || $(target).is(gameItems[2].children())){
        noSelected();
        onSelected(2);
        showBgChange(2);
    }else if ($(target).is(gameItems[3]) || $(target).is(gameItems[3].children())){
        noSelected();
        onSelected(3);
        showBgChange(3);
    }else if ($(target).is(gameItems[4]) || $(target).is(gameItems[4].children())){
        noSelected();
        onSelected(4);
        showBgChange(4);
    }
},function (){
    console.log(3);
})
// 设置所有item默认未选中
function noSelected() {
    for (var i = 0;i < 5;i++){
        gameItems[i].css('border','1px solid #99a2aa');
        gameItems[i].css('opacity','0.5')
        gameItems[i].children('div').children('a').css('color','#99a2aa');
    }
}
// 设置某个item为选中状态
function onSelected(i) {
    gameItems[i].css('border','2px solid #00A1D6');
    gameItems[i].css('opacity','1')
    gameItems[i].children('div').children('a').css('color','#18191C');
}

// 切换背景图片的对象 游戏名 介绍语
var showBg = $('.new-gameCard-show');
var title = $('.new-gameCard-show>div>h3');
var info = $('.new-gameCard-show>div>p');
// 设置对应的背景图片展示
function showBgChange(i){
    switch (i){
        case 0:
            showBg.css('background-image','url("../images/光隙解语.png")');
            title.html('光隙解语');
            info.html('破云绽光，只为与你相遇');
            break;
        case 1:
            showBg.css('background-image','url("../images/依露希尔：星晓.png")');
            title.html('依露希尔：星晓');
            info.html('3D即时策略卡牌手游，以动态指令式的沉浸式战斗体验为特色。');
            break;
        case 2:
            showBg.css('background-image','url("../images/闪耀！优俊少女.png")');
            title.html('闪耀！优俊少女');
            info.html('亚洲超人气大作');
            break;
        case 3:
            showBg.css('background-image','url("../images/斯露德.png")');
            title.html('斯露德');
            info.html('自由空战，爽快射击');
            break;
        case 4:
            showBg.css('background-image','url("../images/凡应.png")');
            title.html('凡应');
            info.html('净海奔流、不进则坠');
            break;
    }
}








