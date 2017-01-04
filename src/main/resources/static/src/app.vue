<template>
  <div>
    <comp-header></comp-header>
    <ts-body></ts-body>
  </div>
</template>

<script>
    import CompHeader from './js/components/header';
    import TsBody from './js/components/body'
    import './css/site/index.css';

    export default {
        components: {
            CompHeader,
            TsBody
        }
    }
</script>
