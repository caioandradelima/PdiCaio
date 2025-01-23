<template>
    <div class="container mt-5">
      <div class="text-center">
        <h2>Lista de Médicos</h2>
      </div>
  
      <div v-if="medicos.length > 0" class="mt-4">
        <ul class="list-group">
          <li v-for="medico in medicos" :key="medico.id" class="list-group-item">
            {{ medico.nome }} - Especialidade: {{ medico.cargo }}
            <button class="btn btn-warning btn-sm float-end" @click="editarMedico(medico.id)">Editar</button>
            <button class="btn btn-danger btn-sm float-end me-2" @click="excluirMedico(medico.id)">Excluir</button>
          </li>
        </ul>
      </div>
      <div v-else class="mt-4">
        <p>Não há médicos cadastrados.</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        medicos: [],
      };
    },
    created() {
      this.listarMedicos();
    },
    methods: {
    async listarMedicos() {
        try {
            const response = await this.$http.get('http://localhost:8080/api/medicos');
            this.medicos = response.data;
        } catch (error) {
            console.error('Erro ao listar médicos:', error);
        }
        },
      editarMedico(id) {
        this.$router.push(`/editar-medico/${id}`);
      },
      async excluirMedico(id) {
        try {
          await this.$http.delete(`/api/medicos/${id}`);
          this.listarMedicos();
        } catch (error) {
          console.error('Erro ao excluir médico:', error);
        }
      },
    },
  };
  </script>
  