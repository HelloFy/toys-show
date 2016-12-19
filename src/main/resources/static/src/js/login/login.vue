<template>
    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <sitetitle></sitetitle>
            <div class="ui secondary pointing menu">
                <div class="ui container">
                    <a class="item login-item"><div class="content">登录</div></a>
                    <a class="item reg-item"><div class="content">注册</div></a>
                </div>
            </div>
            <transition name="fade">
                <router-view></router-view>
            </transition>
        </div>
    </div>
</template>
<script>
    require('../../css/semantic/semantic.min.css')
    require('../../css/site/login/login.css')
    var SiteTitle = require('../components/siteTitle.vue')
    export default {
        components:{
            'sitetitle':SiteTitle
        }
    }
</script>