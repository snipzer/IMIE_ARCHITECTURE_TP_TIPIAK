import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import LoginRegister from './views/LoginRegister.vue'
import TripView from './views/Trip.vue'

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
    },
    {
      path: '/trip/:id',
      name: 'trip-detail',
      component: TripView
    }
  ]
})
