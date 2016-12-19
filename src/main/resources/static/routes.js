const  routes= [
    { path: '/loginform', component: require('./src/js/components/loginform.vue') },
    { path: '/regform', component: require('./src/js/components/regForm.vue') },
    { path: '/login.html', redirect: '/loginform' }
]

module.exports = routes