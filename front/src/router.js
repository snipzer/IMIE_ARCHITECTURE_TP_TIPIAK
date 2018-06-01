import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import LoginRegister from './views/LoginRegister.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/login-register',
      name: 'login-register',
      component: LoginRegister
    }
  ]
})
