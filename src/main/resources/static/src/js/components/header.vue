<template>
    <div class="ui secondary stackable menu">
        <div class="ui container">
            <div class="item">
                <a class="ui header" href="/">
                    <img class="image" src="png.">
                    <div class="content">T S</div>
                </a>
            </div>
            <div class="item">
                <div class="ui action left icon input">
                    <i class="search icon"></i>
                    <input type="text" placeholder="搜索...">
                    <div class="ui teal button">搜索</div>
                </div>
            </div>
            <div class="ui right secondary menu">
                <div class="ui simple dropdown item">
                    <div class="text"><img class="ui avatar image" src="../../img/icon/favicon.ico">{{msg.name}}</div>
                    <i class="dropdown icon"></i>
                    <div class="menu" id="profile-menu">
                        <a class="item">我的主页</a>
                        <a class="item">私信</a>
                        <a class="item">设置</a>
                        <a class="item" id="logout-ts" v-on:click="logout()">退出</a>
                        <form id="logout-form" class="ui hidden" action="/logout" method="post">
                            <input type="hidden" id="csrf-token" name="_csrf" v-bind:value="msg.csrf" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data: function(){
            return {
                msg: {
                    name : 'Josh Player',
                    csrf : '213'
                }
            };
        },
        mounted:function(){
        },
        methods: {
            logout: function(){
               document.getElementById('logout-form').submit();
            }
        }
    }
</script>
