
$(function () {
    $.get("/comment/load/"+$("#blog_id").text(), load_comment_section);
});

function load_comment_section(data) {

    $("#comment_section").html(data);
    load_avatar();
    $("#comment_post_btn").click(function (e) {
        e.preventDefault();
        $.post("/comment/add", $("#comment_form").serialize(), load_comment_section);
    });
}


function load_avatar() {
    $("img.c_avatar").each(function () {
        $(this).attr("src", "https://www.gravatar.com/avatar/" + md5($(this).attr("email")) + "?s=50&d=identicon");
    });
}