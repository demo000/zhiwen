var testPage={
    buttonFn:function(){
        alert(11)
    },
    toPage:function(){
        $.StandardPost("/test/t",{name:"tet"})
}

};
$(function(){
    $(".btn").on("click",testPage.toPage)

})
