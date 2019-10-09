
function init_title(title) {
    document.title = title;
}


/**
 * 初始化基本链接
 */
function init_base_link(page_data) {
    $(".home-link").attr("href", page_data.home_url)
    $(".chn-link").attr("href", page_data.chn_url)
    $(".login-link").attr("href", page_data.login_url)
}

/**
 * 初始化导航栏
 * @param categories
 */
function init_navbar(categories) {
    categories = categories || {};
    let categories_box = $("#categories-box");
    for (let i = 0; i < categories.length; i++) {
        let category = categories[i];
        let node_html = `<div class="nav-child1"><a href="${category.url}" class="master1">${category.title}</a></div>`;
        let node = $(node_html);
        categories_box.append(node);
    }
}

/**
 * 初始化搜索
 * @param search_url
 */
function init_search(search_url) {
    let form_search = $("#search-form");
    form_search.attr("action", search_url);
}

/**
 * 初始化轮播图
 * @param images
 * @param speed
 */
function init_rolling_images(images, speed) {
    let flash = $("#flash");
    for (let i = 0; i < images.length; i++) {
        let img = images[i];
        let node_html = `<img class="zy-img" style="display: none;" src="${img.url}" height="400" width="1170"/>`;
        let node = $(node_html);
        flash.append(node);
    }

    let curr_img_idx = 0;
    flash.children().eq(0).css("display", "block");

    function next() {
        flash.children().eq(curr_img_idx).css("display", "none");

        curr_img_idx = (curr_img_idx + 1) % images.length;
        flash.children().eq(curr_img_idx).css("display", "block");
        flash.children().eq(curr_img_idx).css("opacity", "0");
        flash.children().eq(curr_img_idx).animate({
            opacity: "1"
        });
    }

    let t = setInterval(next, speed);
    flash.bind({
        "mousemove": function () {
            t = clearInterval(t)
        },
        "mouseout": function () {
            t = setInterval(next, speed);
        }
    })
}

/**
 * 格式化时间戳输出
 * @param time
 * @returns {string}
 */
function timestamp_to_string(time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date+" "+hour+":"+minute;
}


/**
 * 初始化首页新闻
 * @param info
 * @param box_id
 */
function init_home_news(info, box_id) {
    let box = $(`#${box_id}`);
    box.find("a.more").attr("href", info.more_url);
    for (let i = 0; i < info.news.length; i++) {
        let news = info.news[i];
        let time = new Date(news.time);
        time = `${time.getFullYear()}-${time.getMonth() + 1}-${time.getDate()} ${time.getHours()}:${time.getMinutes()}`;
        let node_html = `<ul class="list cl" style="padding-bottom: 7px;"><li class="title fl"><a href="${news.url}">${news.title}</a></li><li class="time fr">${timestamp_to_string(news.time)}</li></ul>`;
        let node = $(node_html);
        box.append(node);
    }
}

/**
 * 初始化列表页子列表结构
 * @param structure
 */
function init_list_structure(structure) {
    let list_structure = $("#list-structure");
    list_structure.find("h4").text(structure.title);
    let ul = list_structure.find("ul");
    for (let i = 0; i < structure.children.length; i++) {
        let item = structure.children[i];
        let node_html = `<li><a href="./list.html?id=${item.id}">${item.title}</a></li>`;
        let node = $(node_html);
        ul.append(node);
    }
}

/**
 * 初始化列表页新闻
 * @param title
 * @param content
 * @param is_news_list
 */
function init_content(title, content, is_news_list) {
    let page_title = $("#page-title");
    page_title.text(title);

    let page_content = $("#page-content");
    if (is_news_list) {

        for (let i = 0; i < content.length; i++) {
            let item = content[i];
            let node_html = `<ul class="list cl">
                        <li class="title fl"><a href="./content.html?id=${item.id}">${item.title}</a></li>
                        <span class="time fr">[${timestamp_to_string(item.time)}]</span>
                    </ul>`;
            let node = $(node_html);
            page_content.append(node);
        }
    } else {
        page_content.append($(content));
    }

}