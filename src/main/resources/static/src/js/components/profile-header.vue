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
                <div class="ui medium header">Medium Header</div>
                <div class="profile-content">
                  <div class="profile-content-item">
                    <div class="icon-wrapper"><i class="world icon"></i></div>
                    互联网
                  </div>
                  <div class="profile-content-item">
                    <div class="icon-wrapper"><i class="man icon"></i></div>
                  </div>
                </div>
                <div class="profile-footer">
                  <div class="item">
                    <div class="icon-wrapper">
                      <i class="angle double down icon"></i>
                    </div>
                    查看详细资料
                  </div>
                  <div class="profile-button-wrapper">
                    <button class="ui primary button">关注他 </button>
                    <button class="ui button">私信 </button>
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
    import '../../css/semantic-ui/dist/components/header.min.css'
    import '../../css/semantic-ui/dist/components/item.min.css'
    export default{
        data(){
            return;
        }
    }
</script>
