<!DOCTYPE html> <!-- 使用 HTML5 doctype，不区分大小写 -->
<html lang="zh-cmn-Hans"> <!-- 更加标准的 lang 属性写法 http:/zhi.hu/XyIa -->
<head>
    <!-- 声明文档使用的字符编码 -->
    <meta charset='utf-8'>
    <!-- 优先使用 IE 最新版本和 Chrome -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <!-- 页面描述 -->
    <meta name="description" content="不超过150个字符"/>
    <!-- 页面关键词 -->
    <meta name="keywords" content="toysSite"/>
    <!-- 网页作者 -->
    <meta name="author" content="FeiYue, feiyue.khalid@gmail.com"/>
    <!-- 搜索引擎抓取 -->
    <meta name="robots" content="index,follow"/>
    <!-- 为移动设备添加 viewport -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
    <!-- `width=device-width` 会导致 iPhone 5 添加到主屏后以 WebApp 全屏模式打开页面时出现黑边 http:/bigc.at/ios-webapp-viewport-meta.orz -->

    <!-- iOS 设备 begin -->
    <meta name="apple-mobile-web-app-title" content="标题">
    <!-- 添加到主屏后的标题（iOS 6 新增） -->
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <!-- 是否启用 WebApp 全屏模式，删除苹果默认的工具栏和菜单栏 -->

    <meta name="apple-itunes-app" content="app-id=myAppStoreID, affiliate-data=myAffiliateData, app-argument=myURL">
    <!-- 添加智能 App 广告条 Smart App Banner（iOS 6+ Safari） -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <!-- 设置苹果工具栏颜色 -->
    <meta name="format-detection" content="telphone=no, email=no"/>
    <!-- 忽略页面中的数字识别为电话，忽略email识别 -->
    <!-- 启用360浏览器的极速模式(webkit) -->
    <meta name="renderer" content="webkit">
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
    <meta name="HandheldFriendly" content="true">
    <!-- 微软的老式浏览器 -->
    <meta name="MobileOptimized" content="320">
    <!-- uc强制竖屏 -->
    <meta name="screen-orientation" content="portrait">
    <!-- QQ强制竖屏 -->
    <meta name="x5-orientation" content="portrait">
    <!-- UC强制全屏 -->
    <meta name="full-screen" content="yes">
    <!-- QQ强制全屏 -->
    <meta name="x5-fullscreen" content="true">
    <!-- UC应用模式 -->
    <meta name="browsermode" content="application">
    <!-- QQ应用模式 -->
    <meta name="x5-page-mode" content="app">
    <!-- windows phone 点击无高光 -->
    <meta name="msapplication-tap-highlight" content="no">
    <!-- iOS 图标 begin -->
    <link rel="apple-touch-icon-precomposed" href="/apple-touch-icon-57x57-precomposed.png"/>
    <!-- iPhone 和 iTouch，默认 57x57 像素，必须有 -->
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/apple-touch-icon-114x114-precomposed.png"/>
    <!-- Retina iPhone 和 Retina iTouch，114x114 像素，可以没有，但推荐有 -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/apple-touch-icon-144x144-precomposed.png"/>
    <!-- Retina iPad，144x144 像素，可以没有，但推荐有 -->
    <!-- iOS 图标 end -->

    <!-- iOS 启动画面 begin -->
    <link rel="apple-touch-startup-image" sizes="768x1004" href="/splash-screen-768x1004.png"/>
    <!-- iPad 竖屏 768 x 1004（标准分辨率） -->
    <link rel="apple-touch-startup-image" sizes="1536x2008" href="/splash-screen-1536x2008.png"/>
    <!-- iPad 竖屏 1536x2008（Retina） -->
    <link rel="apple-touch-startup-image" sizes="1024x748" href="/Default-Portrait-1024x748.png"/>
    <!-- iPad 横屏 1024x748（标准分辨率） -->
    <link rel="apple-touch-startup-image" sizes="2048x1496" href="/splash-screen-2048x1496.png"/>
    <!-- iPad 横屏 2048x1496（Retina） -->

    <link rel="apple-touch-startup-image" href="/splash-screen-320x480.png"/>
    <!-- iPhone/iPod Touch 竖屏 320x480 (标准分辨率) -->
    <link rel="apple-touch-startup-image" sizes="640x960" href="/splash-screen-640x960.png"/>
    <!-- iPhone/iPod Touch 竖屏 640x960 (Retina) -->
    <link rel="apple-touch-startup-image" sizes="640x1136" href="/splash-screen-640x1136.png"/>
    <!-- iPhone 5/iPod Touch 5 竖屏 640x1136 (Retina) -->
    <!-- iOS 启动画面 end -->

    <!-- iOS 设备 end -->
    <meta name="msapplication-TileColor" content="#000"/>
    <!-- Windows 8 磁贴颜色 -->
    <meta name="msapplication-TileImage" content="icon.png"/>
    <!-- Windows 8 磁贴图标 -->

    <link rel="alternate" type="application/rss+xml" title="RSS" href="/rss.xml"/>
    <!-- 添加 RSS 订阅 -->
    <link rel="shortcut icon" type="image/ico" href="/favicon.ico"/>
    <!-- 添加 favicon icon -->

    <script type="text/javascript" src="/js/vue/vue.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/js/semantic/semantic.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/reset.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/site.css">

    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/container.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/grid.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/header.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/image.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/menu.css">

    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/divider.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/segment.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/tab.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/form.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/input.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/button.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/list.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/message.css">
    <link rel="stylesheet" type="text/css" href="/css/semantic/semantic/components/icon.css">

    <script src="/js/semantic/components/form.js"></script>
    <script src="/js/semantic/components/tab.js"></script>
    <script src="/js/semantic/components/transition.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.ui.secondary.pointing.menu .item').tab(
                    'change tab', 'login'
            );
            $('ui.menu a.item')
                    .on('click', function () {
                        $(this)
                                .addClass('active')
                                .siblings()
                                .removeClass('active')
                        ;
                    })
            ;
        });
    </script>
    <script type="text/javascript" src="/js/site/login/login.validate.js"></script>

    <link rel="stylesheet" type="text/css" href="/css/site/login/login.css"/>
    <link rel="stylesheet" type="text/css" href="/css/site/footer.css">

    <title>Toys Site Login</title>
</head>
<body>
<canvas id="canvas"></canvas>
<script>
    //定义画布宽高和生成点的个数
    var WIDTH = window.innerWidth, HEIGHT = window.innerHeight, POINT = 35;

    var canvas = document.getElementById('canvas');
    canvas.width = WIDTH,
            canvas.height = HEIGHT;
    var context = canvas.getContext('2d');
    context.strokeStyle = 'rgba(0,0,0,0.02)',
            context.strokeWidth = 1,
            context.fillStyle = 'rgba(0,0,0,0.05)';
    var circleArr = [];

    //线条：开始xy坐标，结束xy坐标，线条透明度
    function Line (x, y, _x, _y, o) {
        this.beginX = x,
                this.beginY = y,
                this.closeX = _x,
                this.closeY = _y,
                this.o = o;
    }
    //点：圆心xy坐标，半径，每帧移动xy的距离
    function Circle (x, y, r, moveX, moveY) {
        this.x = x,
                this.y = y,
                this.r = r,
                this.moveX = moveX,
                this.moveY = moveY;
    }
    //生成max和min之间的随机数
    function num (max, _min) {
        var min = arguments[1] || 0;
        return Math.floor(Math.random()*(max-min+1)+min);
    }
    // 绘制原点
    function drawCricle (cxt, x, y, r, moveX, moveY) {
        var circle = new Circle(x, y, r, moveX, moveY)
        cxt.beginPath()
        cxt.arc(circle.x, circle.y, circle.r, 0, 2*Math.PI)
        cxt.closePath()
        cxt.fill();
        return circle;
    }
    //绘制线条
    function drawLine (cxt, x, y, _x, _y, o) {
        var line = new Line(x, y, _x, _y, o)
        cxt.beginPath()
        cxt.strokeStyle = 'rgba(0,0,0,'+ o +')'
        cxt.moveTo(line.beginX, line.beginY)
        cxt.lineTo(line.closeX, line.closeY)
        cxt.closePath()
        cxt.stroke();

    }
    //初始化生成原点
    function init () {
        circleArr = [];
        for (var i = 0; i < POINT; i++) {
            circleArr.push(drawCricle(context, num(WIDTH), num(HEIGHT), num(15, 2), num(10, -10)/40, num(10, -10)/40));
        }
        draw();
    }

    //每帧绘制
    function draw () {
        context.clearRect(0,0,canvas.width, canvas.height);
        for (var i = 0; i < POINT; i++) {
            drawCricle(context, circleArr[i].x, circleArr[i].y, circleArr[i].r);
        }
        for (var i = 0; i < POINT; i++) {
            for (var j = 0; j < POINT; j++) {
                if (i + j < POINT) {
                    var A = Math.abs(circleArr[i+j].x - circleArr[i].x),
                            B = Math.abs(circleArr[i+j].y - circleArr[i].y);
                    var lineLength = Math.sqrt(A*A + B*B);
                    var C = 1/lineLength*7-0.009;
                    var lineOpacity = C > 0.03 ? 0.03 : C;
                    if (lineOpacity > 0) {
                        drawLine(context, circleArr[i].x, circleArr[i].y, circleArr[i+j].x, circleArr[i+j].y, lineOpacity);
                    }
                }
            }
        }
    }

    //调用执行
    window.onload = function () {
        init();
        setInterval(function () {
            for (var i = 0; i < POINT; i++) {
                var cir = circleArr[i];
                cir.x += cir.moveX;
                cir.y += cir.moveY;
                if (cir.x > WIDTH) cir.x = 0;
                else if (cir.x < 0) cir.x = WIDTH;
                if (cir.y > HEIGHT) cir.y = 0;
                else if (cir.y < 0) cir.y = HEIGHT;

            }
            draw();
        }, 16);
    }

</script>
<div class="ui middle aligned center aligned grid">
    <div class="column">
        <h1 class="ui teal image header">
            <img src="/images/icon/favicon.ico" class="image">
        </h1>
        <h2 class="ui teal header content">
            Toys Site
        </h2>
        <div class="ui secondary pointing menu">
            <div class="ui container">
                <a class="item login-item" data-tab="login"><div class="content">登录</div></a>
                <a class="item reg-item" data-tab="reg"><div class="content">注册</div></a>
            </div>
        </div>
        <div class="ui tab" data-tab="login">
            <form class="ui large form">
                <div class="ui stacked">
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="user icon"></i>
                            <input type="text" name="email" placeholder="邮箱/手机">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="lock icon"></i>
                            <input type="password" name="password" placeholder="密码">
                        </div>
                    </div>
                    <div class="ui fluid large teal submit button">登录</div>
                </div>
                <div class="ui error message"></div>
                <div class="ui container">
                    <div class="ui secondary menu">
                        <a class="item"><i class="weibo icon"></i> </a>
                        <a class="item"><i class="qq icon"></i> </a>
                        <div class="right menu" >
                            <a class="a-loss-pw" href="#">忘记密码？</a>
                        </div>
                    </div>
                </div>

            </form>
        </div>

        <div class="ui tab" data-tab="reg">
            <form class="ui large form" id="reg-form" action="/register" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="ui stacked">
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="user icon"></i>
                            <input type="text" name="name" placeholder="昵称">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="phone icon"></i>
                            <input type="text" name="phone" placeholder="手机">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="lock icon"></i>
                            <input type="password" name="password" placeholder="密码">
                        </div>
                    </div>
                    <div id="reg-button">
                    <button class="ui fluid large teal button" v-on:click="doRegister">{{name}}</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<footer class="footer">
    <span>© Toys Site</span>
    <span class="ui line">|</span>
    <span>联系我 email:916073811@qq.com</span>
</footer>

</body>
<script type="text/javascript">
    new Vue({
        el: '#reg-button',
        data: {
            name:'注册'
        },
        methods: {
            doRegister: function (){
                alert("do register")
            }
        }
    });
</script>
</html>