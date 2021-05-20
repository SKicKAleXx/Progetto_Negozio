import Error404Screen from './screens/Error404Screen.js';
import HomeScreen from './screens/HomeScreen.js';
import ProductScreen from './screens/ProductScreen.js';
import SigninScreen from './screens/SigninScreen.js';
import { parseRequestUrl } from './utils.js';
const routes = {
    '/': HomeScreen,
    '/product/:id': ProductScreen,
    '/signin': SigninScreen,
    
};
const router = async () => {
    const request = parseRequestUrl();
    const parseUrl = 
    (request.resource ? `/${request.resource}`: '/') +
    (request.id? '/:id': '') + 
    (request.verb ? `/${request.verb}`: '');
    const screen = routes[parseUrl]? routes[parseUrl]: Error404Screen;
    const main = document.getElementById('main-container');
    main.innerHTML = screen.render();
};
window.addEventListener('load', router);
window.addEventListener('hashchange', router);

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