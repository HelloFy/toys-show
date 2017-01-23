const TsBody = resolve => require(['../src/js/components/body.vue'], resolve);;;;;;;;;;;;;;;;;;
const ProfileHeader = resolve => require(['../src/js/components/profile-header.vue'], resolve);;;;;;;;;;;;;;;;;;

const  routes= [
    { path: 'profile/:uid', name: 'userProfile',component: ProfileHeader},
    { path: '' , name: 'index' , component: TsBody}
];
module.exports = routes;
