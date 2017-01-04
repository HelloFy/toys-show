<template>
  <div class="ui dimmer modals page transition visible active" >
    <div class="ui small modal transition visible active">
      <i class="close icon" v-on:click="cancel"></i>
      <div class="header">
        注册成功
      </div>
      <div class="content">
        <div class="description">
          现在要登陆么？
        </div>
      </div>
      <div class="actions">
        <div class="ui negative button" v-on:click="cancel">暂时不要</div>
        <div class="ui positive right labeled icon button" v-on:click="toLogin">去登陆
          <i class="checkmark icon"></i>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
  .ui.dimmer.modals.page.transition.visible.active{
    display: block !important;
  }
  .ui.modal .content{
    width:auto !important;
  }
  .ui.modal .header{
    border-bottom:none !important;
    color:green !important;
  }
  .ui.modal .actions{
    padding:0.5em !important;
  }

  @media only screen and (min-width: 1200px){
  .ui.small.modal{
    margin-top: -92.5px!important;
    display: block!important;
    max-width: 420px;
    margin-left: -11% !important
  }
}

</style>

<script>
      import '../../css/semantic-ui/dist/components/modal.min.css'
      import '../../css/semantic-ui/dist/components/dimmer.min.css'

      export default{
          methods:{
            cancel(){
              this.$emit('closeModal');
            },
            toLogin(){
              this.$emit('toLogin')
            }
          }
      }

</script>
