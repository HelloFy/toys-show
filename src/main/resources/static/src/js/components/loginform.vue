<template>
    <form class="ui large form" id="log-form">
        <div class="ui stacked">
            <div class="field">
                <div class="ui left icon input">
                    <i class="user icon"></i>
                    <input type="text" name="username" v-model="username" placeholder="邮箱/手机">
                </div>
            </div>
            <div class="field">
                <div class="ui left icon input">
                    <i class="lock icon"></i>
                    <input type="password" name="password" v-model="password" placeholder="密码">
                </div>
            </div>
        </div>
        <div class="ui fluid large teal submit button" v-bind:class="{loading:click}">登录</div>
        <div class="ui error message" v-bind:class="{hidden:hidden,visible:visible}">
            <i class="close icon"></i>
            <div class="header aligned left">登录失败 </div>
            <p class="aligned left">账号或密码错误.</p>
        </div>
        <div class="ui container">
            <div class="ui secondary menu">
                <a class="item"><i class="weibo icon"></i> </a>
                <a class="item"><i class="qq icon"></i> </a>
                <div class="right menu" >
                    <a class="a-loss-pw" href="#">忘记密码？</a>
                </div>
            </div>
        </div>
    </form>
</template>
<style>

</style>
<script>
    export default{
        data(){
            return{
                msg:'hello vue'
            }
        },
        components:{
            'other-component':OtherComponent,
            HeaderComponent,
        }
    }

</script>
