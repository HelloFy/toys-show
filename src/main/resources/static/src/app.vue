<template>
  <comp-header v-bind:uinfo="info" v-bind:isLogin="isLogin" v-bind:nonLogin="nonLogin"></comp-header>
</template>

<script>
    import CompHeader from './js/components/header';

    import './css/semantic-ui/dist/semantic.min.css'
    import './css/site/index.css'

    export default {
        computed:{
          isLogin(){
            return this.$store.state.isLogin;
          },
          nonLogin(){
            return this.$store.state.nonLogin;
          },
          info(){
            return this.$store.state.uinfo;
          }
        },
        components: {
            CompHeader
        },
        beforeCreate(){
           this.$store.commit('updateUInfo');
        }
    }
</script>
