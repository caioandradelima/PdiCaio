<template>
    <div class="container mt-5">
      <div class="text-center">
        <h2>Bem-vindo ao perfil, {{ enfermeiro.nome }}</h2>
        <p class="lead">{{ enfermeiro.cargo }}</p>
      </div>
  
      <div class="mt-4">
        <h4>Ações disponíveis</h4>
        <div class="row">
          <div class="col-md-6">
            <div class="card">
              <div class="card-body text-center">
                <h5 class="card-title">Cadastrar Paciente</h5>
                <p class="card-text">Adicione novos pacientes ao sistema.</p>
                <button class="btn btn-primary" @click="navigateTo('/CadastroPaciente')">Cadastrar</button>
              </div>
            </div>
          </div>
  
          <div class="col-md-6">
            <div class="card">
              <div class="card-body text-center">
                <h5 class="card-title">Editar Pacientes</h5>
                <p class="card-text">Atualize informações de pacientes existentes.</p>
                <button class="btn btn-warning" @click="navigateTo('/CadastroPaciente')">Editar</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        enfermeiro: {
          nome: "Enf. Ana Silva",
          cargo: "Enfermeiro Assistencial"
        }
      };
    },
    methods: {
      navigateTo(route) {
        this.$router.push(route);
      }
    }
  };
  </script>
  
  <style scoped>
  .card {
    border: none;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
  .card:hover {
    transform: scale(1.05);
    transition: transform 0.2s ease;
  }
  </style>
  