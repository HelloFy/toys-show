<template>
    <compheader></compheader>
</template>

<script>
    import CompHeader from './js/components/header.vue';
    import './css/semantic/dist/semantic.css';
    import './css/site/index.css';

    export default {
        name:'app',
        components: {
            CompHeader
        }
    }
</script>