<template>
  <div>
    <div class="login-form">
      <input type="text" placeholder="Email" v-model="email">
      <input type="text" placeholder="Password" v-model="password">
      <input type="text" placeholder="Confirm Password" v-model="confirmPassword">
      <input type="submit" v-on:click="register" value="Register">
    </div>
    <a v-on:click="gotoLogin">Already registered? Login!</a>
  </div>
</template>

<script>
import callApi from '@/services/CallApi'

export default {
  name: 'Login',
  data: function () {
    return {
      email: '',
      password: '',
      confirmPassword: ''
    }
  },
  methods: {
    register: function () {
      callApi.post('http://mon-url.com', {email: this.email, password: this.password})
    },
    gotoLogin: function () {
      this.$emit('register', false)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
  cursor: pointer;
}
.login-form {
  display: flex;
  flex-direction: column;
  align-items: center;

  input {
    width: 350px;
  }
}
</style>
