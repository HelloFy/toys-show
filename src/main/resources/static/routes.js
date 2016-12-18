import Login from "./src/js/components/loginform.vue";
import Register from "./src/js/components/regForm.vue";

const routes = [
    { path: '/login', component: Login },
    { path: '/reg', component: Register }
]

const router = new VueRouter({
    routes // （缩写）相当于 routes: routes
})

export default router