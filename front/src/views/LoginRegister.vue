<template>
  <div>
    <loginForm v-if="!register" @register="toggleRegister"></loginForm>
    <registerForm v-if="register" @register="toggleRegister"></registerForm>
  </div>
</template>

<script>
// @ is an alias to /src
import loginForm from '@/components/LoginForm'
import registerForm from '@/components/RegisterForm'

export default {
  name: 'home',
  data: function () {
    return {
      register: false
    }
  },
  components: {
    loginForm,
    registerForm
  },
  methods: {
    toggleRegister: function (register) {
      this.register = register
    }
  }
}
</script>
