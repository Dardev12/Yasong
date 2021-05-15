import { createRouter, createWebHistory } from 'vue-router';

import Welcome from '../components/views/WelcomeView.vue';
import Inscritpion from '../components/views/InscriptionView.vue';
import Connection from '../components/views/ConnectionView.vue';

import Home from '../components/views/UserView/HomeView.vue';
import Compte from '../components/views/UserView/CompteView.vue';
import Parametre from '../components/views/UserView/ParametreView.vue';

import BiblioPlayList from '../components/views/BiblioView/BiblioPlaylistView.vue';
import BiblioYasong from '../components/views/BiblioView/BiblioYaView.vue';

import Player from '../components/views/MusicView/PlayView.vue';
import Playlist from '../components/views/MusicView/PlaylistView.vue';
import Convertisseur from '../components/views/MusicView/ConvertisseurView.vue';

import NotFound from '../components/views/NotFound/404NotFoundView.vue';


const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes:[
    {path:'/',redirect:'/Welcome'}
    {
      name:'Welcome',
      path:'/Welcome',
      component:Welcome,
      children:[
        {path:'Inscription', component:Inscritpion},
        {path:'Connection', component:Connection}
      ]
    },
    {
      path:'/Home',
      component:Home,
      children:[
        {path:'Compte', component:Compte},
        {path:'Parametre', component:Parametre},
        {
          path:'BiblioYasong', 
          component:BiblioYasong,
          children:[
              {path:'Player', component:Player}
          ]
        },
        {
          path:'BiblioPlaylist', 
          component:BiblioPlayList,
          children:[
              {
                path:'PlayList', 
                component:Playlist,
                children:[
                  {path:'Player', component:Player}
                ]
              }
          ]
        },
        {path:'Convertisseur', component:Convertisseur}
      ]
    },
    {path:'/:notFound(.*)',component:NotFound}
  ],
  linkActiveClass:'active'
})

export default router
