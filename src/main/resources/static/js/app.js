$(function(){
    $(".menu-icon").on("click",function() {
        if($(this).hasClass("menu-icon-clicked")) {
            $(this).removeClass("menu-icon-clicked");
            $("nav > .nav-bar:nth-of-type(1)").fadeOut();            
        }else {
            $(this).addClass("menu-icon-clicked");
            $("nav > .nav-bar:nth-of-type(1)").fadeIn();
        }
    });

    $(".reserve-count").off().bind("keyup change click",function(){
        $(".menu-price > span").text($(this).val() * $(".menu-original-price").val());
    });

    $(".reserve-table input").off().bind("keyup change click",function(){
        $(this).parent().parent().find(".price").text($(this).siblings(".reserve-original-price").val() * $(this).val());        
        getTotal();
    });
});

$(window).resize(function (){                 
    if (window.outerWidth > 768) {       
        $("nav > .nav-bar:nth-of-type(1)").css({"display":"inline"});     
        if($(window).scrollTop() > ($(".header-scroll-point").scrollTop() + $(".header-scroll-point").height()) - 70) {
            $("header").addClass("header-scrolled");
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
});

function getTotal() {
    var length = $(".price").length;
    var totalPrice = 0;
    for(i = 0; i < length; i++) {
        totalPrice += parseInt($(".price").eq(i).text());
    }
    $(".total-price > span").text(totalPrice);
}