<template>
    <form class="ui large form" id="reg-form">
        <div class="ui stacked">
            <div class="field" v-bind:class="{error:lerror}">
                <div class="ui left icon input">
                    <i class="user icon"></i>
                    <input type="text" name="loginName" v-model="loginName" placeholder="昵称">
                </div>
                <div class="ui basic red pointing prompt label transition" v-bind:class="{hidden:lvalid,visible:!lvalid}">
                  {{lmsg}}
                </div>
            </div>
            <div class="field" v-bind:class="{error:merror}">
                <div class="ui left icon input">
                    <i class="phone icon"></i>
                    <input type="text" name="mobile" v-model="mobile" placeholder="手机">
                </div>
                <div class="ui basic red pointing prompt label transition" v-bind:class="{hidden:mvalid,visible:!mvalid}">
                  {{mmsg}}
                </div>
            </div>
            <div class="field" v-bind:class="{error:cerror}">
                <div class="ui left icon input">
                    <i class="lock icon"></i>
                    <input type="password" name="credence" v-model="credence" placeholder="密码">
                </div>
                <div class="ui basic red pointing prompt label transition" v-bind:class="{hidden:cvalid,visible:!cvalid}">
                  {{cmsg}}
                </div>
            </div>
            <button class="ui fluid large teal button" v-on:click.stop.prevent="reg_inTS" v-bind:class="{loading:loading}">注册</button>
            <div class="field">
                <div class="ui secondary menu">
                    <div class="approve">
                        点击注册代表您同意<a href="#">《TS许可协议》</a>
                    </div>
                </div>
            </div>
        </div>
      <modal v-if="isShow" v-on:closeModal="closeModal"></modal>
    </form>
</template>
<script>
    import Modal from './modal'

    export default{
        data(){
            return{
               isShow:false,
               loading:false,
               lmsg:'',
               mmsg:'',
               cmsg:'',
               lvalid:true,
               mvalid:true,
               cvalid:true,
               loginName:'',
               mobile:'',
               credence:'',
               lerror:false,
               merror:false,
               cerror:false
            }
        },
        watch:{
          loginName(val){
            this.lvalid=true;
            this.lmsg='';
            this.lerror=false;
          },
          mobile(val){
            this.merror=false;
            this.mvalid=true;
            this.mmsg='';
          },
          credence(val){
            this.cmsg='';
            this.cvalid=true;
            this.cerror=false;
          }
        },
        components:{
          Modal
        },
        methods:{
          reg_inTS(){
            var ref = this;
            //登录名校验
            if(this.loginName == ''){
              this.lerror=true;
              this.lmsg='昵称不能为空';
              this.lvalid=false;
            }
            else if(this.loginName.length < 2 || this.loginName.length > 8){
              this.lerror=true;
              this.lmsg='昵称长度不符合(2-8个字符)';
              this.lvalid=false;
            }
            //手机号验证
            if(this.mobile == ''){
              this.merror=true;
              this.mmsg='手机号不能为空';
              this.mvalid=false;
            }
            else if(!(/^1[3|4|5|7|8][0-9]{9}$/.test(this.mobile))){
              this.merror=true;
              this.mmsg='手机号规则不符合';
              this.mvalid=false;
            }
            //密码验证
            if(this.credence == ''){
              this.cerror=true;
              this.cmsg='密码不能为空';
              this.cvalid=false;
            }
            else if(this.credence.length <6 || this.credence.length>10){
              this.cerror=true;
              this.cmsg='密码长度不符合(6-10个字符)';
              this.cvalid=false;
            }
            if(this.cerror || this.merror || this.lerror){
              return;
            }
            else{
               require.ensure(["whatwg-fetch"],function () {
                fetch('/user/existName?loginName='+ref.loginName,{
                  credentials: 'include'
                 }).then(function(response){
                    response.json().then(function (data) {
                      if(data.result == 'FAIL'){
                        ref.lerror=true;
                        ref.lmsg='昵称重复';
                        ref.lvalid=false;
                      }
                    })
                 },function (error) {
                    ref.lerror = true;
                    ref.lmsg='请检查您的网络设置.';
                    ref.lvalid=false;
                 }).catch(function(ex){
                    ref.lerror = true;
                    ref.lmsg='请检查您的网络设置.';
                    ref.lvalid=false;
                 });
                fetch('/user/existMobile?mobile='+ref.mobile,{
                  credentials: 'include'
                }).then(function(response){
                    response.json().then(function (data) {
                      if(data.result == 'FAIL'){
                        ref.merror=true;
                        ref.mmsg='手机号重复';
                        ref.mvalid=false;
                      }
                    })
                 },function(error){
                  ref.merror=true;
                  ref.mmsg='请检查您的网络设置';
                  ref.mvalid=false;
                 }).catch(function(ex){
                  ref.merror=true;
                  ref.mmsg='请检查您的网络设置';
                  ref.mvalid=false;
                 });
                 if( ref.merror || ref.lerror){
                  return;
                 }
                 else{
                   ref.loading = true;
                   var _csrf_token = document.getElementsByTagName('meta')['_csrf'].getAttribute('content')
                   fetch('/register',{
                    method:'POST',
                    headers: {
                       'Content-Type': 'application/x-www-form-urlencoded',
                       'X-CSRF-TOKEN':_csrf_token
                    },
                    credentials: 'include',
                    body:'loginName='+ref.loginName+'&credence='+ref.credence+'&mobile='+ref.mobile
                   }).then(function(response){
                     response.json().then(function (data) {
                      if(data.result == 'SUCCESS'){
                        ref.isShow = true;
                        ref.loading = false;
                      }
                      else{
                        ref.loading =false;
                        ref.lerror = true;
                        ref.lvalid =false;
                        ref.lmsg='登录名或手机号被其他人抢占了,T.T';
                      }
                   })},function(error){
                      ref.loading =false;
                      ref.lerror = true;
                      ref.lvalid =false;
                      ref.lmsg='请检查您的网络设置.';
                   }
                   ).catch(function(ex){
                      ref.loading =false;
                      ref.lerror = true;
                      ref.lvalid =false;
                      ref.lmsg='请检查您的网络设置.';
                   })
                 }
              })
            }
          },
          closeModal(){
            this.isShow = false;
          }
        }
    }
</script>
