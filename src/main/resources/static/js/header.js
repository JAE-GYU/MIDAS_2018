$(document).scroll(function() {    
    if(window.outerWidth >= 768) {
        if($(window).scrollTop() > ($(".header-scroll-point").scrollTop() + $(".header-scroll-point").height()) - 70) {
            $("header").addClass("header-scrolled");
        }else {
            $("header").removeClass("header-scrolled");        
        }
    }
});

$(".menu-icon").on("click",function() {
    if($(this).hasClass("menu-icon-clicked")) {
        $(this).removeClass("menu-icon-clicked");
        $("nav > .nav-bar:nth-of-type(1)").fadeOut();            
    }else {
        $(this).addClass("menu-icon-clicked");
        $("nav > .nav-bar:nth-of-type(1)").fadeIn();
    }
});