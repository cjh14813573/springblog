$(function () {
    $("div.c-card-click").click(function (e) {
        e.preventDefault();
        url = $(this).attr("href");
        window.location.href = url;
    });
});