<template>
    <comp-header></comp-header>
</template>

<script>
    import CompHeader from './js/components/header';
    import './css/semantic-ui/dist/semantic.min.css';
    import './css/site/index.css';

    export default {
        name:'app',
        components: {
            CompHeader
        }
    }
</script>
