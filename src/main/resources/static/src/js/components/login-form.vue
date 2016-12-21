<template>
    <form class="ui large form" id="log-form">
        <div class="ui stacked">
            <div class="field" v-bind:class="uerror">
                <div class="ui left icon input">
                    <i class="user icon"></i>
                    <input type="text" name="username" v-model="username" placeholder="邮箱/手机">
                    <div class="ui basic red pointing prompt label transition" v-bind:class="{hidden:unamevalid,visible:!unamevalid}">{{lnmsg}}</div>
                </div>
            </div>
            <div class="field" v-bind:class="perror">
                <div class="ui left icon input">
                    <i class="lock icon"></i>
                    <input type="password" name="password" v-model="password" placeholder="密码">
                    <div class="ui basic red pointing prompt label transition" v-bind:class="{hidden:pvalid,visible:!pvalid}">{{pmsg}}</div>
                </div>
            </div>
            <div class="two fields">
                <div class="field" v-bind:class="verror">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input type="text" name="validate-code" v-model="vcode" placeholder="验证码">
                        <div class="ui basic red pointing prompt label transition" v-bind:class="{hidden:vcodevalid,visible:!vcodevalid}">{{vmsg}}</div>
                    </div>
                </div>
                <div class="field">
                    <div data-tooltip="看不清？点击切换" data-inverted="">
                    <a href="javascript:void(0)" class="ui middle aligned fluid image" v-on:click="recode">
                        <img :src="url" />
                    </a>
                    </div>
                </div>
            </div>
            <div class="ui fluid large teal button" v-on:click="login" v-bind:class="{loading:loading}">登录</div>
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
                url:'/getCode',
                loading:false,
                username:'',
                password:'',
                unamevalid:true,
                uerror:false,
                perror:false,
                verror:false,
                lnmsg:'',
                vcode:'',
                pvalid:true,
                vcodevalid:true,
                pmsg:'',
                vmsg:''
            }
        },
        methods:{
            recode(){
                var timestamp = Date.parse(new Date());
                timestamp = timestamp / 1000;
                this.url='/getCode?r='+timestamp
            },
            login(){
                this.loading = true;
            }
        }
    }

</script>
