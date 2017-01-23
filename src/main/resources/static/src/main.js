// The Vue build version to load with the `import` command
import Vue from "vue";
import App from "./app";
import VueRouter from "vue-router";
import Vuex from "vuex";

Vue.use(VueRouter);
Vue.use(Vuex);


const router = new VueRouter({
  mode : 'hash',
  routes:require('../config/routes.js')
});

const store = new Vuex.Store({
  state: {
    uinfo:'',
    isLogin:false,
    nonLogin:false
  },
  mutations: {
  },
  actions:{
    updateUInfo (context) {
      require.ensure(["whatwg-fetch"],function(){
        fetch('/user/isLoginAndGetInfo',{
          credentials: 'include',
        }).then(function(response){
          return response.json().then(function(data){
            if(data.result=='SUCCESS'){
              context.state.isLogin = true;
              context.state.nonLogin = false;
              context.state.uinfo =(new Function("","return "+data.message))();
              return;
            }
            else{
              context.state.isLogin= false;
              context.state.nonLogin =true;
              return;
            }
          })
        },function(error){
          context.state.isLogin= false;
          context.state.nonLogin =true;
          return;
        })
      })
    }
  }
});


new Vue({
    el: '.ui',
    store,
    components: {
      App
    },
    router
});
