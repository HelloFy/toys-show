const  routes= [
    { path: '/loginform', component: require('./src/js/components/login-form.vue') },
    { path: '/regform', component: require('./src/js/components/reg-form.vue') },
    { path: '/login.html', redirect: '/loginform' }
];;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

module.exports = routes;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;