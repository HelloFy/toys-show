<template>
    <div class="ui container">
      <div class="ui two column grid">
        <div class="widescreen only computer only ten wide column">
          <div id="ts-x-funcmenu" class="ui large stackable menu">
            <a class="item">About Us </a>
            <a class="item">Jobs </a>
            <a class="item">Locations </a>
            <div class="right menu">
              <a class="item">Box</a>
            </div>
          </div>
        </div>
        <div class="widescreen only computer only five wide column">
          <div class="ui vertical menu">
            <div class="item">
              <div class="header">Products</div>
              <div class="menu">
                <a class="item">Enterprise</a>
                <a class="item">Consumer</a>
              </div>
            </div>
            <div class="item">
              <div class="header">CMS Solutions</div>
              <div class="menu">
                <a class="item">Rails</a>
                <a class="item">Python</a>
                <a class="item">PHP</a>
              </div>
            </div>
            <div class="item">
              <div class="header">Hosting</div>
              <div class="menu">
                <a class="item">Shared</a>
                <a class="item">Dedicated</a>
              </div>
            </div>
            <div class="item">
              <div class="header">Support</div>
              <div class="menu">
                <a class="item">E-mail Support</a>
                <a class="item">FAQs</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</template>
<style>
  .ui.vertical.menu{
    float:right;
    border:none !important;
    box-shadow:none !important;
  }
  #ts-x-funcmenu{
    background-color:#fafafa;
  }
</style>
<script>
    import '../../css/semantic-ui/dist/components/grid.min.css'
    export default{
        data(){
            return{
                msg:'hello vue'
            }
        },
        components:{
        }
    }
</script>
