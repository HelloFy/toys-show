<template>
    <form v-if="!show" class="ui large form" id="reg-form">
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
            <button class="ui fluid large teal button">注册</button>
        </div>
    </form>
</template>
<script>
    export default{
        data(){
            return{
            }
        }
    }

</script>
