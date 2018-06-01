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
}
