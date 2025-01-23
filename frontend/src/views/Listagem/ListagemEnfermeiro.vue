<template>
    <div class="container mt-5">
      <div class="text-center">
        <h2>Lista de Enfermeiros</h2>
      </div>
  
      <div v-if="enfermeiros.length > 0" class="mt-4">
        <ul class="list-group">
          <li v-for="enfermeiro in enfermeiros" :key="enfermeiro.id" class="list-group-item">
            {{ enfermeiro.nome }} - Registro: {{ enfermeiro.registro }}
            <button class="btn btn-warning btn-sm float-end" @click="editarEnfermeiro(enfermeiro.id)">Editar</button>
            <button class="btn btn-danger btn-sm float-end me-2" @click="excluirEnfermeiro(enfermeiro.id)">Excluir</button>
          </li>
        </ul>
      </div>
      <div v-else class="mt-4">
        <p>Não há enfermeiros cadastrados.</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        enfermeiros: [],
      };
    },
    created() {
      this.listarEnfermeiros();
    },
    methods: {
      async listarEnfermeiros() {
        try {
          const response = await this.$http.get('/enfermeiros');
          this.enfermeiros = response.data;
        } catch (error) {
          console.error('Erro ao listar enfermeiros:', error);
        }
      },
      editarEnfermeiro(id) {
        this.$router.push(`/editar-enfermeiro/${id}`);
      },
      async excluirEnfermeiro(id) {
        try {
          await this.$http.delete(`/enfermeiros/${id}`);
          this.listarEnfermeiros();
        } catch (error) {
          console.error('Erro ao excluir enfermeiro:', error);
        }
      },
    },
  };
  </script>
  