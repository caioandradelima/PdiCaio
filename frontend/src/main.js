import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import axios from 'axios'
import $ from 'jquery';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import App from './App.vue'
import Login from './views/Login.vue'
import CadastroPaciente from './views/CadastroPaciente.vue'
import CadastroEnfermeiro from './views/CadastroEnfermeiro.vue'
import Medico from './views/Medico.vue'
import Enfermeiro from './views/Enfermeiro.vue'
import Listar from './views/Listar.vue'
import ListagemEnfermeiro from './views/ListagemEnfermeiro.vue'
import ListagemMedico from './views/ListagemMedico.vue'
import ListagemPaciente from './views/ListagemPaciente.vue'

axios.defaults.baseURL = 'http://localhost:8080/api';

const routes = [
  { path: '/', component: Login },
  { path: '/cadastroPaciente', component: CadastroPaciente },
  { path: '/CadastroEnfermeiro', component: CadastroEnfermeiro },
  { path: '/Medico', component: Medico },
  { path: '/Enfermeiro', component: Enfermeiro },
  { path: '/Listar', component: Listar },
  { path: '/enfermeiros', component: ListagemEnfermeiro },
  { path: '/medicos', component: ListagemMedico },
  { path: '/pacientes', component: ListagemPaciente },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

const app = createApp(App)
app.use(router)
app.config.globalProperties.$http = axios
app.mount('#app')
