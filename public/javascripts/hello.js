if (window.console) {
    console.log("Welcome to your Play application's JavaScript! C'mon work!");
}
$(function () {
    if (window.location.href != "http://localhost:9000/home" && window.location.href != "http://localhost:9000/register" && window.location.href != "http://localhost:9000/login") {
        console.log("Logged in");
        $(".not_logged_in").hide();
        $(".logged_in").show();
    }
    else {
        console.log("Not logged in");
        $(".not_logged_in").show();
        $(".logged_in").hide();
    }
});
