<template>
    <div class="ui mini stackable borderless menu">
        <div class="ui container">
            <div class="item">
                <a class="ui header" href="/">
                    <img class="image" src="../../img/icon/favicon.png">
                    <div class="content">T S</div>
                </a>
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
                        <a class="item" v-bind:onclick="toProfile">我的主页</a>
                        <a class="item">私信</a>
                        <a class="item">设置</a>
                        <a class="item" id="logout-ts" v-on:click="logout">退出</a>
                        <form id="logout-x-form" class="hidden" action="/logout" method="post">
                          <input id="logout-x-csrf-bt" type="hidden" name="_csrf">
                        </form>
                    </div>
                </div>
                <div v-else class="item">
                  <button class="ui teal basic button" style="margin-right:5px;">登 录</button>
                  <button class="ui teal basic button">注 册</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import '../../css/semantic-ui/dist/components/container.min.css'
    import '../../css/semantic-ui/dist/components/menu.min.css'
    import '../../css/semantic-ui/dist/components/button.min.css'
    import '../../css/semantic-ui/dist/components/item.min.css'
    import '../../css/semantic-ui/dist/components/header.min.css'
    import '../../css/semantic-ui/dist/components/image.min.css'
    import '../../css/semantic-ui/dist/components/dropdown.min.css'
    import '../../css/semantic-ui/dist/components/icon.min.css'
    import '../../css/semantic-ui/dist/components/input.min.css'
    import '../../css/semantic-ui/dist/components/site.min.css'
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
          isLogin:Boolean
        },
        computed: {
          profilePage: function () {
              return '/user/profile/'+this.uinfo.uid;
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
