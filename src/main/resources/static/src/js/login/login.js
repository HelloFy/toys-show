import Vue from 'vue';
import Login from './login.vue';
import Background from  '../components/background.vue'
import TSFooter from  '../components/footer.vue'
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
