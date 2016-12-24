<template>
  <form class="ui large form" id="log-form">
    <div class="ui stacked">
      <div class="field" v-bind:class="{error:uerror}">
        <div class="ui left icon input">
          <i class="user icon"></i>
          <input type="text" name="username" v-model="username" placeholder="邮箱/手机">
        </div>
        <div class="ui basic red pointing prompt label transition"
             v-bind:class="{hidden:unamevalid,visible:!unamevalid}">
          {{lnmsg}}
        </div>
      </div>
      <div class="field" v-bind:class="{error:perror}">
        <div class="ui left icon input">
          <i class="lock icon"></i>
          <input type="password" name="password" v-model="password" placeholder="密码">
        </div>
        <div class="ui basic red pointing prompt label transition" v-bind:class="{hidden:pvalid,visible:!pvalid}">
          {{pmsg}}
        </div>
      </div>
      <div class="field" v-bind:class="{error:verror}">
        <div class="ui left icon input">
          <i class="protect icon"></i>
          <input type="text" name="validate-code" v-model="vcode" placeholder="验证码">
          <div class="v-code" data-tooltip="看不清？点击切换" data-inverted="">
            <a href="javascript:void(0)" class="ui middle aligned fluid image" v-on:click="recode">
              <img :src="url" alt="验证码"/>
            </a>
          </div>
        </div>
        <div class="ui basic red pointing prompt label transition"
             v-bind:class="{hidden:vcodevalid,visible:!vcodevalid}">
          {{vmsg}}
        </div>
      </div>
      <div class="ui fluid large teal button" v-on:click="login" v-bind:class="{loading:loading}">登录</div>
      <div class="field">
        <div class="ui secondary menu">
          <a class="item"><i class="weibo icon"></i> </a>
          <a class="item"><i class="qq icon"></i> </a>
          <div class="right menu">
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
        watch: {
          username(val){
            this.unamevalid = true;
            this.lnmsg = '';
            this.uerror = false;
          },
          password(val){
            this.pvalid = true;
            this.pmsg = '';
            this.perror = false;
          },
          vcode(val){
            this.vcodevalid = true;
            this.verror = false;
            this.vmsg = '';
          }
        },
        methods:{
            recode(){
                var timestamp = Date.parse(new Date());
                timestamp = timestamp / 1000;
                this.url='/getCode?r='+timestamp
            },
            login(){
                //用户名称校验
                if(this.username == ''){
                  this.unamevalid = false;
                  this.lnmsg = '用户名称不能为空';
                  this.uerror = true;
                }
                //密码校验
                if(this.password == ''){
                  this.pvalid = false;
                  this.pmsg = '密码不能为空';
                  this.perror = true;
                }
                //校验失败 不进行验证码校验
                if(!this.unamevalid || !this.pvalid){
                  this.loading = false;
                  return;
                }
                //验证码校验
                if(this.vcode == ''){
                  this.vcodevalid = false;
                  this.verror = true;
                  this.loading = false;
                  this.vmsg='验证码不能为空';
                }
                else if(this.vcode.length!=4){
                  this.vcodevalid = false;
                  this.verror = true;
                  this.loading = false;
                  this.recode();
                  this.vmsg='验证码长度不符合';
                }
                else{
                  var ref = this;
                  //验证码远程验证 通过后进行登录
                  require.ensure(["whatwg-fetch"],function () {
                    fetch('/validateCode?validateCode='+ref.vcode,{
                          credentials: 'include'
                        }).then(function (response) {
                          response.json().then(function (data) {
                            if(data.result == 'FAIL'){
                              ref.vcodevalid = false;
                              ref.verror = true;
                              ref.loading = false;
                              ref.vmsg = '验证码错误';
                              ref.recode();
                              return;
                            }
                            else{
                              this.loading = true;
                              fetch('/login',{
                                method:'POST'

                              })
                            }
                          })
                         }, function (error) {
                             ref.loading =false;
                         }).catch(function(ex){
                            ref.loading =false;
                         })
                  })
                }
           }
        }
    }
</script>
