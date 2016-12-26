<template>
    <form class="ui large form" id="reg-form">
        <div class="ui stacked">
            <div class="field left">
                <div class="ui left icon input">
                    <i class="user icon"></i>
                    <input type="text" name="loginName" placeholder="昵称">
                </div>
            </div>
            <div class="field">
                <div class="ui left icon input">
                    <i class="phone icon"></i>
                    <input type="text" name="mobile" placeholder="手机">
                </div>
            </div>
            <div class="field">
                <div class="ui left icon input">
                    <i class="lock icon"></i>
                    <input type="password" name="credence" placeholder="密码">
                </div>
            </div>
            <button class="ui fluid large teal button" v-on:click.stop.prevent="!isShow">注册</button>
            <div class="field">
                <div class="ui secondary menu">
                    <div class="approve">
                        点击注册代表您同意<a href="#">《TS许可协议》</a>
                    </div>
                </div>
            </div>
        </div>
      <modal v-if="isShow"></modal>
    </form>
</template>
<script>
    import Modal from './modal'

    export default{
        data(){
            return{
               isShow:false
            }
        },
        components:{
          Modal
        }
    }

</script>
