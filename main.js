var aperto = false;

function toggle(){
    if(!aperto){
        document.getElementById('menu').style.marginRight="0px";
        aperto = true;

    }else{
        document.getElementById('menu').style.marginRight="-240px";
        aperto = false;


    };
};