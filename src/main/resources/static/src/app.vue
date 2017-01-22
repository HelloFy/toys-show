<template>
  <div>
    <comp-header v-bind:uinfo="info" v-bind:logined="logined" v-bind:login="login"></comp-header>
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
            logined:false,
            login:false
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
                        ref.logined=true;
                        ref.login=false;
                        ref.info =(new Function("","return "+data.message))();
                        return;
                      }
                      else{
                        ref.login=true;
                        ref.logined=false;
                        return;
                      }
                    })
               },function(error){
                   ref.login=true;
                   ref.logined=false;
                   return ;
               })
            })
        },
    }
</script>
