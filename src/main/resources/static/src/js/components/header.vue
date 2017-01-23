<template>
  <div>
    <div class="ui mini stackable borderless menu">
        <div class="ui container">
            <div class="item">
                <router-link class="ui header" to="/">
                    <img class="image" src="../../img/icon/favicon.png">
                    <div class="content">T S</div>
                </router-link>
            </div>
            <div class="item">
                <div class="ui action left icon input">
                    <i class="search icon"></i>
                    <input type="text" placeholdPer="搜索...">
                    <div class="ui teal button">搜索</div>
                </div>
            </div>
            <div class="right container menu">
                <div v-if="isLogin" class="ui simple dropdown item">
                    <div class="text"><img class="ui avatar image" alt="头像" src="../../img/avatar-test.jpg">{{uinfo.loginName}}</div>
                    <i class="dropdown icon"></i>
                    <div class="menu" id="profile-menu">
                        <router-link class="item" :to="{name: 'userProfile', params: { uid: uid }}">我的主页</router-link>
                        <a class="item">私信</a>
                        <a class="item">设置</a>
                        <a class="item" id="logout-ts" v-on:click="logout">退出</a>
                        <form id="logout-x-form" class="hidden" action="/logout" method="post">
                          <input id="logout-x-csrf-bt" type="hidden" name="_csrf">
                        </form>
                    </div>
                </div>
                <div v-else-if="nonLogin" class="item">
                  <button class="ui teal basic button" style="margin-right:5px;">登 录</button>
                  <button class="ui teal basic button">注 册</button>
                </div>
            </div>
        </div>
    </div>
    <router-view></router-view>
  </div>
</template>

<style>
  .ui.header:not(h1):not(h2):not(h3):not(h4):not(h5):not(h6) {
    font-size: 1.28em;
  }
  .ui.header {
    border: none;
  }
  .ui.header>.image+.content, .ui.header>img+.content {
    padding-left: .75rem;
    vertical-align: middle;
  }
  .ui.header .content {
    display: inline-block;
    vertical-align: top;
  }
  .ui.header>.image, .ui.header>img {
    display: inline-block;
    margin-top: .14285em;
    width: 2.5em;
    height: auto;
    vertical-align: middle;
  }
  .ui.avatar.image{
    height: 2em;
    border-radius: 500rem;
  }

</style>

<script>
    export default {
        data: function(){
            return {
                name : '',
                avatarUrl:'/img/icon/favicon.png',
                csrf:'',
            };
        },
        props: {
          uinfo:[String,Object],
          isLogin:Boolean,
          nonLogin:Boolean
        },
        computed: {
          uid: function () {
              return this.uinfo.uid;
           }
        },
        methods: {
            logout(){
               var _csrf_token = document.getElementsByTagName('meta')['_csrf'].getAttribute('content');
               document.getElementById('logout-x-csrf-bt').value = _csrf_token;
               document.getElementById('logout-x-form').submit();
            },
            toProfile(){

            }
        }
    }
</script>
