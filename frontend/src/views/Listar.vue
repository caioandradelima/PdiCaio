<template>
    <div class="container mt-5">
      <div class="text-center">
        <h2>Escolha uma opção para gerenciar</h2>
      </div>
  
      <div class="mt-4">
        <h4>Selecione a opção</h4>
        <div class="row">
          <div class="col-md-4">
            <div class="card">
              <div class="card-body text-center">
                <h5 class="card-title">Médicos</h5>
                <button class="btn btn-info" @click="navigateTo('/medicos')">Listar Médicos</button>
              </div>
            </div>
          </div>
  
          <div class="col-md-4">
            <div class="card">
              <div class="card-body text-center">
                <h5 class="card-title">Enfermeiros</h5>
                <button class="btn btn-info" @click="navigateTo('/enfermeiros')">Listar Enfermeiros</button>
              </div>
            </div>
          </div>
  
          <div class="col-md-4">
            <div class="card">
              <div class="card-body text-center">
                <h5 class="card-title">Pacientes</h5>
                <button class="btn btn-info" @click="navigateTo('/pacientes')">Listar Pacientes</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    methods: {
      navigateTo(route) {
        this.$router.push(route);
      },
    },
  };
  </script>
  