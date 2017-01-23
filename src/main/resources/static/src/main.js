// The Vue build version to load with the `import` command
import Vue from "vue";
import App from "./app";
import VueRouter from "vue-router";
import Vuex from "vuex";

Vue.use(VueRouter);
Vue.use(Vuex);


const store = new Vuex.Store({
  state: {
    uinfo:'',
    isLogin:false,
    nonLogin:false
  },
  mutations: {
    updateUInfo (state) {
      require.ensure(["whatwg-fetch"],function(){
        fetch('/user/isLoginAndGetInfo',{
          credentials: 'include',
        }).then(function(response){
          return response.json().then(function(data){
            if(data.result=='SUCCESS'){
              state.isLogin = true;
              state.nonLogin = false;
              state.uinfo =(new Function("","return "+data.message))();

            }
            else{
              state.isLogin= false;
              state.nonLogin =true;

            }
          })
        },function(error){
          state.isLogin= false;
          state.nonLogin =true;

        })
      })
    }
  }
});

const router = new VueRouter({
  routes:require('../config/routes.js')
});

new Vue({
    el: '.ui',
    components: {
        App
    },
    router:router,
    store
});
