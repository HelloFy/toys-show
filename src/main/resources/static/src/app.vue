<template>
  <div>
    <comp-header v-bind:uinfo="info" v-bind:isLogin="isLogin"></comp-header>
    <ts-body></ts-body>
  </div>
</template>

<script>
    import CompHeader from './js/components/header';
    import TsBody from './js/components/body'
    import ProfileHeader from './js/components/profile-header'

    import './css/semantic-ui/dist/components/grid.min.css'
    import './css/site/index.css';

    export default {
        data(){
          return {
            info:'',
            isLogin:false
          }
        },
        components: {
            CompHeader,
            TsBody,
            ProfileHeader
        },
        created(){
            var ref = this;
            require.ensure(["whatwg-fetch"],function(){
               fetch('/user/isLoginAndGetInfo',{
                  credentials: 'include',
               }).then(function(response){
                    return response.json().then(function(data){
                      if(data.result=='SUCCESS'){
                        ref.isLogin=true;
                        ref.info =(new Function("","return "+data.message))();
                        return;
                      }
                      else{
                        ref.isLogin=false;
                      }
                    })
               },function(error){
                  ref.isLogin=false;
                  return ref.isLogin;
               })
            })
        },
    }
</script>
