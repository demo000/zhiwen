$(function () {

    var reg_div = $("#reg");
    var email_input = $("#email");
    var reg_form = $("#regForm");
    var loading_div = $("#loading");
    var login_form = $("#login_form");
    var login_div = $("#login_div");
    var error_div = $("#error");
    var question_div = $("#question");
    var question_form = $("#question_form");
    var content_div = $(".content");
    var search_form = $("#search_form");


    search_form.ajaxForm({
        url: '/search_question',
        type: "post",
        success: function (data) {

            content_div.hide();
            content_div.html(data);
            content_div.show();
        }
    })

    /*搜索按钮样式*/
    $("#search_button").button({
        icons: {
            primary: 'ui-icon-search',
        }
    }).click(function () {
        search_form.submit();
    });

    /*
     模拟点击
     $("#search_button").trigger('click');*/

    //初始加载数据,ajax表单初始化必须在前面
    search_form.submit();

    $("#question_button").button({
        icons: {
            primary: 'ui-icon-lightbulb',
        },
    }).click(function () {
        if ($.cookie("user")) {
            question_div.dialog("open");

        } else {
            error_div.dialog("open");
            window.setTimeout(function () {
                error_div.dialog("close");
                login_form.clearForm();
                login_div.dialog("open");
            }, 1000);

        }
    });

    if ($.cookie("user")) {
        $("#reg_a,#login_a").hide();
        $("#user_a,#logout").show();
        var user = eval('(' + $.cookie("user") + ')');
        $("#user_a").html(user.userName);

    } else {
        $("#user_a,#logout").hide();
        $("#reg_a,#login_a").show();
    }


    /*登陆按钮*/
    $("#login_a").on("click", function () {
        login_div.dialog("open");
    });

    reg_div.dialog({
        title: "知问注册",
        autoOpen: false,
        show: 'blind',
        hide: 'blind',
        modal: true,
        width: 380,
        height: 360,
        buttons: {
            '提交': function () {
                reg_form.submit();
            }
        }
    });
    login_div.dialog({
        title: "知问登陆",
        autoOpen: false,
        show: 'blind',
        hide: 'blind',
        width: 360,
        height: 230,
        modal: true,
        buttons: {
            "登陆": function () {
                login_form.ajaxSubmit({
                    url: "/login",
                    type: "POST",
                    success: function (data) {
                        if (data.state == 200) {
                            alert(data.msg);
                            login_div.dialog("close");
                            login_form.clearForm();
                            window.location.reload();

                        } else {
                            alert(data.msg);

                        }
                    }

                })
            }
        }
    });

    loading_div.dialog({
        modal: true,
        autoOpen: false,
        closeOnEscape: false, //按下esc 无效
        resizable: false,
        draggable: false,
        width: 180,
        height: 50,
    }).parent().find('.ui-widget-header').hide();//隐藏标题头颜色

    error_div.dialog({
        modal: true,
        autoOpen: false,
        resizable: false,
        draggable: false,
        width: 200,
        height: 50,
    }).parent().find('.ui-widget-header').hide();
    //点击事件


    $("#reg_a").on("click", function () {
        reg_div.dialog("open");
    });

    /*退出*/
    $("#logout").click(function () {
        $.removeCookie("user");
        $.get("/logout", function (data) {
            if (data) {
                if (data.state == 200) {
                    alert("退出成功");
                    window.location.reload();
                }
            }
        })
    });

    //日期控件
    $("#birthDay").datepicker({
        dateFormat: 'yy-mm-dd',
        dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
        dayNamesShort: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
        dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
        monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        monthNamesShort: ['一', '二', '三', '四', '五', '六', '七', '八', '九', '十', '十一', '十二'],
        altFormat: 'yy-mm-dd',
        currentText: '今天',
        firstDay: 1,
        maxDate: new Date(),
        weekHeader: '周',

    });


    /*邮箱自动补全*/
    email_input.autocomplete({
        source: function (request, response) {
            var hosts = ['qq.com', '163.com', 'gmail.com'];
            var term = request.term;
            var result = new Array();
            //加上自己输入的
            result.push(term);
            if (term) {

                var _index = term.lastIndexOf("@");
                if (_index > -1) {
                    var len = term.length;
                    if ((len - _index) > 1) {
                        var subStr = term.substring(_index + 1, len);

                        result = $.map(hosts, function (value, index) {
                            if (value.lastIndexOf(subStr) > -1) {
                                return term.substring(0, _index) + "@" + value;
                            }
                        })
                    } else {
                        result = $.map(hosts, function (value, index) {
                            return term + value;
                        })
                    }
                } else {
                    result = $.map(hosts, function (value, index) {
                        return term + "@" + value;
                    })
                }
            }
            response(result);


        },
        minLength: 1,
        autoFocus: true,

    });

    /*注册表单*/
    reg_form.validate({

        submitHandler: function (form) {
            reg_form.ajaxSubmit({
                url: "/register",
                type: "POST",

                beforeSubmit: function () {
                    /*打开加载*/
                    loading_div.dialog("open");
                    /*禁用提交按钮*/
                    reg_div.dialog("widget").find("button").eq(1).button('disable');
                },
                success: function (data) {
                    // console.debug(data);
                    if (data) {
                        if (data.state == 200) {

                            //延迟1秒关闭
                            loading_div.css('background', 'url(img/success.gif) no-repeat 20px center').html(data.msg);
                            window.setTimeout(function () {
                                reg_div.dialog("close");
                                loading_div.dialog("close");
                                /*复原样式*/
                                loading_div.css('background', 'url(img/loading.gif) no-repeat 20px center').html("数据加载中...");
                                reg_form.clearForm();
                                $('#reg span.star').html('*').removeClass('succ');
                                reg_div.dialog("widget").find("button").eq(1).button('enable');
                                //打开登陆页面
                                login_form.clearForm();
                                login_div.dialog("open");
                            }, 1000);


                        } else {
                            loading_div.html(data.msg);
                        }
                    }
                }
            })
        },
        showErrors: function (errorMap, errorList) {
            /*获得错误个数*/
            var errors = this.numberOfInvalids();
            //加长弹窗
            if (errors > 0) {
                reg_div.dialog('option', 'height', errors * 20 + 360);
            } else {
                reg_div.dialog('option', 'height', 360);
            }

            this.defaultShowErrors();
        },
        /*验证成功*/
        highlight: function (element, errorClass) {
            $(element).css('border', '1px solid #630');
            $(element).parent().find('span').html('*').removeClass('succ');
        },

        unhighlight: function (element, errorClass) {
            $(element).css('border', '1px solid #ccc');
            $(element).parent().find('span').html('&nbsp;').addClass('succ');
        },
        /*错误包裹*/
        errorLabelContainer: 'ol.myerror',
        wrapper: 'li',

        rules: {
            userName: {
                required: true,
                minlength: 2,
                remote: {
                    /*后台返回true or false 的字符串*/
                    url: '/checkUserName',
                    type: "GET",
                    /*额外发送数据 默认发送当前验证字段*/
                    data: {
                        name: function () {
                            return $("#regForm input[name='userName']").val();
                        }
                    }
                }

            },
            passWord: {
                required: true,
                minlength: 3
            },
            repassWord: {
                required: true,
                equalTo: "#passWord"
            },
            email: {
                email: true,
                remote: {
                    url: "/checkEmail",
                    type: "GET",
                },
            }
        },
        messages: {
            userName: {
                required: "用户名不能为空",
                minlength: $.format('用户名不得小于{0}位！'),
                remote: '用户名不可用',
            },
            passWord: {
                required: '密码不能为空',
                minlength: $.format('密码不得小于{0}位！'),
            },
            repassWord: {
                equalTo: "前后密码不一致",
            },
            email: {
                email: '请输入正确的邮箱',
                remote: "该邮箱已被注册",

            }
        }
    });

    /*选项卡*/
    $('#tabs').tabs({
        collapsible: true,
        event: 'click',
        show: 'blind',
        hide: 'blind',
        load: function (event, ui) {

        }

    });

    /*菜单*/
    $("#accordion").accordion({
        event: 'mouseover',
        active: 1,
        icons: {
            "header": "ui-icon-plus",
            "activeHeader": "ui-icon-minus",
        },
    });

    question_div.dialog({
        title: "在线提问",
        autoOpen: false,
        show: 'blind',
        hide: 'blind',
        width: 600,
        height: 600,
        modal: true,
        buttons: {
            "提交": function () {
                question_form.ajaxSubmit({

                    url: "/add_question",
                    type: "POST",
                    beforeSubmit: function () {
                        var ck = eval('(' + $.cookie('user') + ')');

                        console.debug(ck)
                        /*打开加载*/
                        loading_div.dialog("open");
                        /*禁用提交按钮*/
                        question_div.dialog("widget").find("button").eq(1).button('disable');
                    },
                    success: function (data) {
                        if (data.state == 200) {
                            loading_div.css('background', 'url(img/success.gif) no-repeat 20px center').html(data.msg);

                            window.setTimeout(function () {
                                question_div.dialog("close");
                                question_form.clearForm();
                                /*复原样式*/
                                loading_div.css('background', 'url(img/loading.gif) no-repeat 20px center').html("数据加载中...");
                                window.location.reload();
                            }, 1000);

                        } else {
                            error_div.dialog("open").val(data.msg);

                            window.setTimeout(function () {
                                error_div.dialog("close");
                                error_div.val(" 请登录后操作...")
                            }, 1000);


                        }
                    }

                })
            }
        }
    })

    var editor_a = UE.getEditor('content', {initialFrameHeight: 260});
    editor_a.execCommand('backcolor', '#000');


});
