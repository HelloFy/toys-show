<template>
    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <sitetitle></sitetitle>
            <div class="ui secondary pointing menu">
                <div class="ui container">
                    <router-link to="/loginform"><div class="content">登录</div></router-link>
                    <router-link to="/regform"><div class="content">注册</div></router-link>
                </div>
                <div class="ui tab">
                    <transition>
                        <router-view></router-view>
                    </transition>
                </div>
            </div>
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