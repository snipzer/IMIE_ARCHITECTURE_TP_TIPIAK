<template>
  <div>
    <div v-if="post">
      <p><strong>{{post.title}}</strong></p>
      <p>{{post.body}}</p>
    </div>
    <div v-if="errors && errors.length">
      <li v-for="error in errors" :key="error.columnNumber">
        {{error.message}}
      </li>
    </div>
  </div>
</template>

<script>
import callApi from '@/services/CallApi'

export default {
  name: 'TripList',
  data: function () {
    return {
      post: {},
      errors: []
    }
  },
  created: function () {
    callApi.get(`http://jsonplaceholder.typicode.com/posts/` + this.$route.params.id)
      .then(response => {
        this.post = response.data
      })
      .catch(e => {
        this.errors.push(e)
      })
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
}
</style>
