<template>
  <div>
    <div class="login-form">
      <input type="text" placeholder="Email" v-model="email">
      <input type="text" placeholder="Password" v-model="password">
      <input type="submit" v-on:click="login" value="Login">
    </div>
    <a v-on:click="gotoRegister">No account? Register!</a>
  </div>
</template>

<script>
import callApi from '@/services/CallApi'

export default {
  name: 'Login',
  data: function () {
    return {
      email: '',
      password: ''
    }
  },
  methods: {
    login: function () {
      callApi.post('http://mon-url.com', {email: this.email, password: this.password})
    },
    gotoRegister: function () {
      this.$emit('register', true)
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
