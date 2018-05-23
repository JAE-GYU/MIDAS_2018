$(document).scroll(function() {    
    if(window.outerWidth >= 768) {
        if($(window).scrollTop() > ($("#main").scrollTop() + $("#main").height()) - 70) {
            $("header").addClass("header-scrolled");
        }else {
            $("header").removeClass("header-scrolled");        
        }
    }
});