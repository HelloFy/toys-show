import Vue from "vue";
import Login from "./Login_";
import Background from "../components/background";
import TsFooter from "../components/footer";
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
        TsFooter
    }
/*
    router:router
*/
});
