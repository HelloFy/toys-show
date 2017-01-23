const TsBody = resolve => require(['../src/js/components/body.vue'], resolve);
const ProfileHeader = resolve => require(['../src/js/components/profile-header.vue'], resolve);

const  routes= [
    { path: '/user/profile/:uid', name: 'userProfile',components: { navMain:ProfileHeader }},
    { path: '' , name: 'index' , components: { navMain:TsBody }}
];
module.exports = routes;
