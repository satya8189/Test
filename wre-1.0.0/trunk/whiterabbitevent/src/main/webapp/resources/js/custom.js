$(document).ready(function(){
    
    $("#pin").click(function(){
       
        if($("#pin").attr('class')=="fa fa-arrow-circle-o-down down-arrow")
            {
               
                 $(".service").not('.'+service1).hide('3000');
               
               
               
            }
        else
            {
               
                 $('.serimg').css("opacity","1");
            }
        
    });
    
});

