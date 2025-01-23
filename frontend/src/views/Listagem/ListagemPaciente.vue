<template>
    <div class="container mt-5">
      <div class="text-center">
        <h2>Lista de Pacientes</h2>
      </div>
  
      <div v-if="pacientes.length > 0" class="mt-4">
        <ul class="list-group">
          <li v-for="paciente in pacientes" :key="paciente.id" class="list-group-item">
            {{ paciente.nome }} - CPF: {{ paciente.cpf }}
            <button class="btn btn-warning btn-sm float-end" @click="editarPaciente(paciente.id)">Editar</button>
            <button class="btn btn-danger btn-sm float-end me-2" @click="excluirPaciente(paciente.id)">Excluir</button>
          </li>
        </ul>
      </div>
      <div v-else class="mt-4">
        <p>Não há pacientes cadastrados.</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        pacientes: [],
      };
    },
    created() {
      this.listarPacientes();
    },
    methods: {
      async listarPacientes() {
        try { 
          const response = await this.$http.get('http://localhost:8080/api/medicos');
          this.pacientes = response.data;
        } catch (error) {
          console.error('Erro ao listar pacientes:', error);
        }
      },
      editarPaciente(id) {
        this.$router.push(`/editar-paciente/${id}`);
      },
      async excluirPaciente(id) {
        try {
          await this.$http.delete(`/api/pacientes/${id}`);
          this.listarPacientes();
        } catch (error) {
          console.error('Erro ao excluir paciente:', error);
        }
      },
    },
  };
  </script>
  