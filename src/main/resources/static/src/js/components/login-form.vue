<template>
    <form class="ui large form" id="log-form">
        <div class="ui stacked">
            <div class="field">
                <div class="ui left icon input">
                    <i class="user icon"></i>
                    <input type="text" name="username" placeholder="邮箱/手机">
                </div>
            </div>
            <div class="field">
                <div class="ui left icon input">
                    <i class="lock icon"></i>
                    <input type="password" name="password" placeholder="密码">
                </div>
            </div>
            <div class="two fields">
                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input type="text" name="validate-code" placeholder="验证码">
                    </div>
                </div>
                <div class="field">
                    <a href="javascript:void(0)" class="ui middle aligned fluid image" v-on:click="recode">
                        <img :src="url" />
                    </a>
                </div>
            </div>
            <div class="ui fluid large teal button">登录</div>
            <div class="field">
                <div class="ui secondary menu">
                    <a class="item"><i class="weibo icon"></i> </a>
                    <a class="item"><i class="qq icon"></i> </a>
                    <div class="right menu" >
                        <a class="a-loss-pw" href="#">忘记密码？</a>
                    </div>
                </div>
            </div>
        </div>
    </form>
</template>
<script>
    export default{
        data(){
            return{
                url:'/getCode'
            }
        },
        methods:{
            recode(){
                var timestamp = Date.parse(new Date());
                timestamp = timestamp / 1000;
                this.url='/getCode?r='+timestamp
            }
        }
    }

</script>
