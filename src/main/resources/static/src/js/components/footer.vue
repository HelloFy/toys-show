<template>
    <div class="footer">
        <span>{{siteName}}</span>
        <span class="ui line">|</span>
        <span>联系我 email:{{email}}</span>
    </div>
</template>
<script>
    import '../../css/site/footer.css'
    export default{
        data(){
            return {
                email :'916073811@qq.com',
                siteName : '© Toys Site'
            }
        }
    }
</script>
