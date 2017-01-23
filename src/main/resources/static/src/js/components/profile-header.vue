<template>
    <div class="ui container">
      <div class="ui segment">
        <div class="ui grid ">
          <div class="teal row profile-hd">
            <div class="column"></div>
          </div>
          <div class="row profile-ft">
            <div class="column">
              <div class="profile">
                <div class="ui medium header">{{name}}</div>
                <div class="profile-content">
                  <div class="profile-content-item">
                    <div class="icon-wrapper"><i class="world icon"></i></div>
                    互联网
                  </div>
                  <div class="profile-content-item">
                    <div class="icon-wrapper">
                      <i v-bind:class="{man:isMan,woman:!isMan,icon:true}"></i>
                    </div>
                  </div>
                </div>
                <div class="profile-footer">
                  <a class="item">
                    <div class="icon-wrapper">
                      <i class="angle down icon"></i>
                    </div>
                    查看详细资料
                  </a>
                  <div class="profile-button-wrapper" v-if="!isSelf">
                    <button class="ui button" v-bind:class="{primary:!isFollow}" v-on:click="follow">{{follow_btn_txt}}</button>
                    <button class="ui icon button">
                      <i class="send icon"></i>
                      私信
                    </button>
                  </div>
                  <div class="profile-button-wrapper" v-else>
                    <button class="ui basic button">编辑个人资料</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <img class="ui small circular image profile-avatar" src="../../img/avatar-test.jpg">
      </div>
    </div>
</template>
<style>
  .teal.row.profile-hd{
    min-height:4em;
  }
  .row.profile-ft{
    min-height:6em;
  }
  .ui.small.circular.image.profile-avatar{
    position:absolute;
    top:10px;
  }
  .profile{
    padding-left:32px;
    padding-top:2px;
    border-left: 164px solid transparent;
  }
  .profile-content{
    font-size: 14px;
    line-height: 20px;
  }
  .profile-content-item:not(:last-child){
    margin-bottom:10px;
  }
  .icon-wrapper{
    display: inline-block;
    width: 18px;
    height: 18px;
    margin-right: 12px;
    text-align: center;
  }
  .profile-footer{
    position: relative;
    padding-top: 8px;
  }
  .profile-button-wrapper{
    position: absolute;
    right:0px;
    bottom:0px;
  }
</style>
<script>

    import '../../css/semantic-ui/dist/components/segment.min.css'
    export default{
        data(){
            return {
              isFollow:false,
              follow_btn_txt:'关注他',
              isSelf:false,
              name:'',
              isMan:true
            };
        },
        /**
        beforeRouteEnter (to, from, next) {
          next(vm => {
            if(to.params.uid === vm.$store.state.uinfo.uid){
              console.log(to.params.uid);
              vm.isSelf = true;
              vm.isMan = (vm.$store.state.uinfo.sex == '男')? true : false;
              vm.name = vm.$store.state.uinfo.loginName;
            }
            else{
              console.log(vm);
              vm.name = '他人';
              vm.isMan = false;
              }
          })
          next();
        },*/
        created(){
          this.fetchData();
        },
        watch: {
           '$route': 'fetchData'
        },
        methods:{
          follow(){
            this.isFollow=!this.isFollow;
            if(!this.isFollow){
              this.follow_btn_txt='关注他';
            }
            else{
              this.follow_btn_txt='取消关注';
            }
          },
          fetchData(){
            if(this.$route.params.uid === this.$store.state.uinfo.uid){
              this.isSelf = true;
              this.isMan = (this.$store.state.uinfo.sex == '男')? true : false;
              this.name = this.$store.state.uinfo.loginName;
            }
            else{
              this.name = '他人';
              this.isMan = false;
            }
          }
        }
    }
</script>
