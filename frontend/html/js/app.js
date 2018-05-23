$(function(){
    if (window.outerWidth < 768) {        
        $("header").addClass("header-scrolled");            
    }

    $(".menu-icon").on("click",function() {
        if($(this).hasClass("menu-icon-clicked")) {
            $(this).removeClass("menu-icon-clicked");
            $("nav > .nav-bar:nth-of-type(1)").fadeOut();            
        }else {
            $(this).addClass("menu-icon-clicked");
            $("nav > .nav-bar:nth-of-type(1)").fadeIn();
        }
    });

    $(window).resize(function (){                 
        if (window.outerWidth > 768) {       
            $("nav > .nav-bar:nth-of-type(1)").css({"display":"inline"});     
            if($(window).scrollTop() > ($("#main").scrollTop() + $("#main").height()) - 70) {
                $("header").addClass("header-scrolled");
            }else {
                $("header").removeClass("header-scrolled");        
            }                                    
        }else {
            $("header").addClass("header-scrolled");    
        }

        if(($(".menu-icon").hasClass("menu-icon-clicked"))) {                
            $("nav > .nav-bar:nth-of-type(1)").css({"display":"inline"});
        }else {
            if (window.outerWidth < 768) {       
                $("nav > .nav-bar:nth-of-type(1)").css({"display":"none"});
            }
        }
    })
});