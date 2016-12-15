var vm = new Vue({
    el:'.ui',
    mounted:function () {
    },
    methods:{
        logout:function () {
            document.getElementById('logout-form').submit();
        }
    }

});
