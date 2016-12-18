var Vue= require('vue')
var Login=require('./login.vue')
var Background = require('../components/background.vue')
var Footer = require('../components/footer.vue')
new Vue({
    el : '.ts',
    components :{
        'login' : Login,
        'background':Background,
        'tsfooter':Footer
    }
})