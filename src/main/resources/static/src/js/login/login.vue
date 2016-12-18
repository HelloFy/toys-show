<template>
    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <sitetitle></sitetitle>
        </div>
    </div>
</template>
<script>
    require('../../css/semantic/semantic.min.css')
    require('../../css/site/login/login.css')
    var SiteTitle = require('../components/siteTitle.vue')
    export default {
        components:{
            'sitetitle':SiteTitle
        }
    }
</script>