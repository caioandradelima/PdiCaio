<template>
    <div class="container mt-5">
      <h2 class="mb-4">Cadastro de Enfermeiro</h2>
      
      <form @submit.prevent="submitForm">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="nome">Nome</label>
            <input
              type="text"
              class="form-control"
              id="nome"
              v-model="enfermeiro.nome"
              placeholder="Digite o nome"
              required
            />
          </div>
          <div class="form-group col-md-6">
            <label for="cpf">CPF</label>
            <input
              type="text"
              class="form-control"
              id="cpf"
              v-model="enfermeiro.cpf"
              placeholder="Digite o CPF"
              required
            />
          </div>
        </div>
        
        <div class="form-row">
          <div class="form-group col-md-12">
            <label for="senha">Senha</label>
            <input
              type="password"
              class="form-control"
              id="senha"
              v-model="enfermeiro.senha"
              placeholder="Digite a senha"
              required
            />
          </div>
        </div>
  
        <button type="submit" class="btn btn-primary mt-3">Cadastrar Enfermeiro</button>
      </form>
  
      <div v-if="message" :class="`mt-3 alert ${messageClass}`">
        {{ message }}
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        enfermeiro: {
          nome: '',
          cpf: '',
          senha: ''
        },
        message: '',
        messageClass: ''
      };
    },
    methods: {
      submitForm() {
        const token = localStorage.getItem('auth-token');
  
        this.$http
          .post('http://localhost:8080/api/enfermeiros', this.enfermeiro, {
            headers: {
              Authorization: `Bearer ${token}`
            }
          })
          .then(() => {
            this.message = 'Enfermeiro cadastrado com sucesso!';
            this.messageClass = 'alert-success';
            this.resetForm();
          })
          .catch((error) => {
            this.message = `Erro ao cadastrar enfermeiro: ${error.response.data.message}`;
            this.messageClass = 'alert-danger';
          });
      },
      resetForm() {
        this.enfermeiro = {
          nome: '',
          cpf: '',
          senha: ''
        };
      }
    }
  };
  </script>
  