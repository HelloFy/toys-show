<template>
  <div>
    <comp-header></comp-header>
    <profile-header></profile-header>
  </div>
</template>

<script>
    import CompHeader from './js/components/header';
    import TsBody from './js/components/body'
    import ProfileHeader from './js/components/profile-header'

    import './css/semantic-ui/dist/components/grid.min.css'
    import './css/site/index.css';

    export default {
        components: {
            CompHeader,
            TsBody,
            ProfileHeader
        }
    }
</script>
