<template>
    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <site-title></site-title>
            <div class="ui secondary pointing menu">
                <div class="ui container">
                    <a class="item login-item" v-on:click="lgclick" v-bind:class="{active:active}"><div class="content">登录</div></a>
                    <a class="item reg-item" v-on:click="rgclick" v-bind:class="{active:!active}"><div class="content">注册</div></a>
                </div>
            </div>
            <transition name="fade" mode="out-in">
                <login-form v-if="show"></login-form>
                <reg-form v-if="!show"></reg-form>
            </transition>
        </div>
    </div>
</template>
<script>
    import '../../css/semantic-ui/dist/components/site.min.css'
    import '../../css/semantic-ui/dist/components/container.min.css'
    import '../../css/semantic-ui/dist/components/form.min.css'
    import '../../css/semantic-ui/dist/components/grid.min.css'
    import '../../css/semantic-ui/dist/components/header.min.css'
    import '../../css/semantic-ui/dist/components/icon.min.css'
    import '../../css/semantic-ui/dist/components/image.min.css'
    import '../../css/semantic-ui/dist/components/button.min.css'
    import '../../css/semantic-ui/dist/components/menu.min.css'
    import '../../css/semantic-ui/dist/components/item.min.css'
    import '../../css/semantic-ui/dist/components/input.min.css'
    import '../../css/semantic-ui/dist/components/label.min.css'
    import '../../css/semantic-ui/dist/components/transition.min.css'


    import '../../css/site/login/login.css'
    import SiteTitle from '../components/site-title'
    import LoginForm from '../components/login-form'
    import RegForm from '../components/reg-form'
    export default {
        data(){
            return {
                show : true,
                active : true
            }
        },
        components:{
            SiteTitle,
            LoginForm,
            RegForm
        },
        methods:{
            lgclick(){
                this.active = true;
                this.show = true;
            },
            rgclick(){
                this.active = false;
                this.show =false;
            }
        }
    }
</script>
