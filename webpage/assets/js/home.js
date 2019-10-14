var bpicnum = 3;
//<![CDATA[
var currentindex = 1;
jQuery("#flashBg").css("background-color", jQuery("#flash1").attr("name"));

function changeflash(i) {
    currentindex = i;
    for (j = 1; j <= bpicnum; j++) {//此处的5代表你想要添加的幻灯片的数量与下面的5相呼应
        if (j == i) {
            jQuery("#flash" + j).fadeIn("normal");
            jQuery("#flash" + j).css("display", "block");
            jQuery("#f" + j).removeClass();
            jQuery("#f" + j).addClass("dq");
            jQuery("#flashBg").css("background-color", jQuery("#flash" + j).attr("name"));
        } else {
            jQuery("#flash" + j).css("display", "none");
            jQuery("#f" + j).removeClass();
            jQuery("#f" + j).addClass("no");
        }
    }
}

function startAm() {
    timerID = setInterval("timer_tick()", 4000);//8000代表间隔时间设置
}

function stopAm() {
    clearInterval(timerID);
}

function timer_tick() {
    currentindex = currentindex >= bpicnum ? 1 : currentindex + 1;//此处的5代表幻灯片循环遍历的次数
    changeflash(currentindex);
}

jQuery(document).ready(function () {
    jQuery(".flash_bar div").mouseover(function () {
        stopAm();
    }).mouseout(function () {
        startAm();
    });
    startAm();
});
//]]>

var step = 154;
var n = $(".in_co div.list li.demo p").length;
var left = -n * step;
var i = 0;
$(".demo1").html($(".demo").html());
$(".demo2").html($(".demo").html());
$(".in_co div.list ul").css("margin-left", left + "px");
$(".pre").bind({
    "click": function () {
        pre()
    }
})
$(".next").bind({
    "click": function () {
        next()
    }
})







var aspeed = 500;
var speed = 1500;
var t = setInterval("next()", speed);
$(".in_co").bind({
    "mousemove": function () {
        t = clearInterval(t)
    },
    "mouseout": function () {
        t = setInterval("next()", speed);
    }
})

function pre() {
    left += step;
    if (left == step) {
        $(".in_co div.list ul").css("margin-left", (-n * step) + "px");
        left = (1 - n) * step;
    }
    $(".in_co div.list ul").stop().animate({"margin-left": left + "px"}, aspeed);

}

function next() {
    left -= step;
    if (left == -(2 * n - 6) * step) {
        $(".in_co div.list ul").css("margin-left", ((6 - n + 1) * step) + "px");
        left = (6 - n) * step;
    }
    $(".in_co div.list ul").stop().animate({"margin-left": left + "px"}, aspeed);
}