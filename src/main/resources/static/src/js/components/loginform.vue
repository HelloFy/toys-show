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
<script>
    export default{
        data(){
            return{
                msg:'hello vue'
            }
        }
    }

</script>
