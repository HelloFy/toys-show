import Vue from "vue";
import Login from "./login";
import Background from "../components/background";
import TSFooter from "../components/footer";
/*var VueRouter = require('vue-router');

Vue.use(VueRouter);
const router = new VueRouter({
    mode:'history',
    routes:require('../../../routes.js')
});*/


new Vue({
    el : '.ts',
    components :{
        Login,
        Background,
        TSFooter
    }
/*
    router:router
*/
});
