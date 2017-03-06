<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${pageResult.totalCount>0}">
        <c:forEach items="${pageResult.result}" var="page">
            <h4> ${page.userName} 发表于 ${page.createDate} </h4>
            <h3>${page.title}</h3>
            <div class="editor">
                    ${page.content}
            </div>
            <div class="bottom">

                <span class="comment" data-questionid="${page.id}">${page.commentNumber}</span>
                <span class="comment" data-questionid="${page.id}">条评论</span>
                <form class="query_comment">
                    <input type="hidden" name="currentPage" value="1"/>
                    <input type="hidden" name="totalCount" value="${page.commentNumber}"/>
                    <input type="hidden" name="questionId" value="${page.id}"/>
                    <input type="hidden" name="pageSize" value="5"/>
                </form>


                <span class="down" data-type="1" data-id="${page.id}">显示全部</span>
                <span class="up" data-type="0" data-id="${page.id}">显示部分</span>

            </div>
            <hr/>
            <div class="comment_list">
                    <%--评论内容--%>
                    <%--
                                    <dl class='temporary'><dd><span class='load_more'>加载更多评论</span></dd></dl>--%>
            </div>

            <div class="comment_add_div">
                <dl>
                    <dd><span class='load_more'>加载更多评论</span></dd>
                </dl>
                <form>
                    <input type="hidden" name="questionId" value="${page.id}"/>
                    <dl class="comment_add">
                        <dt>
                            <textarea name="content"></textarea>
                        </dt>
                        <dd>
                            <input type="button" data-questionid="${page.id}" value="发表"/>
                        </dd>
                    </dl>
                </form>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <div class="editor">
            没有查询到数据...
        </div>
    </c:otherwise>
</c:choose>

<script type="text/javascript">
    $(function () {


        //显示全部或者收起
        $(".down,.up").on("click", function () {
            var _this = $(this);
            var _type = _this.data("type");
            var questionId = _this.data("id");
            var _other;
            //点击显示全部
            if (_type) {
                _other = _this.next("span");
            } else {
                //点击显示部分
                _other = _this.prev("span");
            }
            var editor = _this.parent("div").prev(".editor");
            $.get("/showContent/" + questionId + "/" + _type, function (data) {
                if (data) {
                    editor.html(data);
                    _this.hide();
                    _other.show();
                }
            })

        });

        $(".up").hide();
        $(".down").show();

        $(".comment_list").hide();
        $(".comment_add_div").hide();

        //查看评论
        $(".comment").on("click", function () {
            var user = $.cookie("user");
            if (user) {
                var _this = $(this);
                var _comment_list = $(this).parent("div").next().next();
                var _comment_add_div = _comment_list.next();

                //判断是否是关闭状态
                var _isclose = _comment_list.is(":hidden");
                if (_isclose) {
                    //判断是否第一次点击查看评论(已经有评论数据)
                    var _childern = _comment_list.children("dl");
                    var _childern_length = _childern.length;
                    if (_childern_length) {
                        //已经加载过一次
                    } else {
                        var _form = _this.next("form");
                        _form.ajaxSubmit({
                            url: "comment_list",
                            type: "POST",
                            success: function (data) {

                                _comment_list.append(data);

                            }
                        })
                    }
                    _comment_list.show();
                    _comment_add_div.show()

                } else {
                    _comment_add_div.hide();
                    _comment_list.hide();
                }

            } else {
                alert("登录后才能查看评论!");
                $("#login_div").dialog("open");
            }


        });
        $(".load_more").button().on("click", function () {
            var _this = $(this);
            var _comment_list =  _this.closest("div").prev(".comment_list");

            var _form = _comment_list.prev().prev().find("form");
            var _currentPage = _form.find("input").first();
            var _totalCount = _form.find("input").eq(1).val();
            var  _page = parseInt(_currentPage.val())+1;
            _currentPage.val(_page);
            var _currentSize = _comment_list.children().length;

            if(_totalCount>_currentSize){
                _form.ajaxSubmit({
                    url: "comment_list",
                    type: "POST",
                    success: function (data) {
                        _comment_list.append(data);
                    }
                });
            }else{
                $("#error").html("已经没有数据了...");
                $("#error").dialog("open");
                window.setInterval(function(){
                    $("#error").dialog("close");
                    $("#error").val("请登录后在操作...");
                },2000);
            }


        });

        //提交评论
        $("input[type='button']").on("click", function () {

            var _this = $(this);

            var questionId = _this.data("questionid");
            //找到最近的form表单
            var _form = _this.closest("form");

            _form.ajaxSubmit({
                url: "/add_comment",
                type: "POST",
                success: function (data) {
                    if (data.state == 200) {
                        alert(data.msg);
                        _form.resetForm();
                        var _span = _this.closest("div").prev().prev().prev().find("span").eq(0);
                        //评论数加一
                        var _starNumber = parseInt(_span.text()) + 1;
                        _span.text(_starNumber);

                    } else {
                        alert(data.msg);
                    }
                }
            })


        })

        function create_comment(_text, _name) {
            var _dl = $("<dl></dl>")
            var _dt = $("<dt></dt>")
            _dt.val(eval('(' + $.cookie("user") + ')').userName);
            var _dd1 = $("<dd></dd>")
            _dd1.val(_text);
            var _dd2 = $("<dd></dd>").addClass("date")
            _dd1.val(new Date());
            _dl.append(_dt).append(_dd1).append(_dd2);

            return _dl;
        }


        /*var create_button = function () {
         var _dl = $("<dl></dl>");
         var _dd = $("<dd></dd>");
         var _span = $("<span><span>");

         _span.addClass("load_more").val("加载更多...");
         _dl.append(_dd).append(_span);
         return _dl;
         }*/
    });
</script>