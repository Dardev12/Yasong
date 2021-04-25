import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Vuetify from 'vuetify'

createApp(App).use(store).use(router).use(Vuetify).mount('#app')
