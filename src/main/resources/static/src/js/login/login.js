var Vue= require('vue');
var Login = require('./login.vue');
var Background = require('../components/background.vue');
var Footer = require('../components/footer.vue');
/*var VueRouter = require('vue-router');

Vue.use(VueRouter);
const router = new VueRouter({
    mode:'history',
    routes:require('../../../routes.js')
});*/


new Vue({
    el : '.ts',
    components :{
        'login' : Login,
        'background':Background,
        'tsfooter':Footer
    }
/*
    router:router
*/
});
