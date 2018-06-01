<template>
  <div>
    <input type="text" placeholder="Recherche" v-model="search">
    <ul v-if="filteredPosts && filteredPosts.length">
      <li v-for="post in filteredPosts" :key="post.id">
        <p><strong>{{post.title}}</strong></p>
        <p>{{post.body}}</p>
      </li>
    </ul>

    <ul v-if="errors && errors.length">
      <li v-for="error in errors" :key="error.columnNumber">
        {{error.message}}
      </li>
    </ul>
  </div>
</template>

<script>
import callApi from '@/services/CallApi'

export default {
  name: 'TripList',
  data: function () {
    return {
      search: '',
      posts: [],
      errors: []
    }
  },
  created: function () {
    callApi.get(`http://jsonplaceholder.typicode.com/posts`)
      .then(response => {
        this.posts = response.data
      })
      .catch(e => {
        this.errors.push(e)
      })
  },
  computed: {
    filteredPosts: function () {
      if (this.search !== '') {
        return this.posts.filter(post => {
          return (post.title.includes(this.search) | post.body.includes(this.search))
        })
      } else {
        return this.posts
      }
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
}
</style>
