import axios from 'axios'

export default class CallApi {
  static get (url) {
    return new Promise((resolve, reject) => {
      axios.get(url)
        .then(response => {
          resolve(response)
        })
        .catch(e => {
          reject(e)
        })
    })
  }

  static post (url, data) {
    // return new Promise((resolve, reject) => {
    //   axios.post(url, data)
    //     .then(response => {
    //       resolve(response)
    //     })
    //     .catch(e => {
    //       reject(e)
    //     })
    // })
    console.log('url', url)
    console.log('data', data)
  }
}
