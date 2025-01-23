<template>
  <div class="container mt-5">
    <h2 class="mb-4">Cadastro de Paciente</h2>

    <div v-if="isEnfermeiro">
      <form @submit.prevent="submitForm">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="nome">Nome</label>
            <input
              type="text"
              class="form-control"
              id="nome"
              v-model="paciente.nome"
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
              v-model="paciente.cpf"
              placeholder="Digite o CPF"
              required
            />
          </div>
        </div>
        
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="dataNascimento">Data de Nascimento</label>
            <input
              type="date"
              class="form-control"
              id="dataNascimento"
              v-model="paciente.dataNascimento"
              required
            />
          </div>
          <div class="form-group col-md-3">
            <label for="peso">Peso (Kg)</label>
            <input
              type="number"
              class="form-control"
              id="peso"
              v-model="paciente.peso"
            />
          </div>
          <div class="form-group col-md-3">
            <label for="altura">Altura (m)</label>
            <input
              type="number"
              class="form-control"
              id="altura"
              v-model="paciente.altura"
            />
          </div>
        </div>

        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="uf">Estado (UF)</label>
            <select
              id="uf"
              class="form-control"
              v-model="paciente.uf"
              required
            >
              <option selected disabled>Escolha...</option>
              <option
                v-for="estado in estados"
                :key="estado"
                :value="estado"
              >
                {{ estado }}
              </option>
            </select>
          </div>
        </div>

        <button type="submit" class="btn btn-primary mt-3">Cadastrar Paciente</button>
      </form>
    </div>

    <div v-else class="alert alert-danger mt-3">
      <p>Você não tem permissão para cadastrar pacientes. Apenas enfermeiros podem realizar essa ação.</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isEnfermeiro: true,
      paciente: {
        nome: '',
        cpf: '',
        dataNascimento: '',
        peso: '',
        altura: '',
        uf: ''
      },
      estados: [
        'AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA',
        'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN',
        'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO'
      ]
    };
  },
  methods: {
    submitForm() {
      this.$http.post('http://localhost:8080/api/pacientes', this.paciente)
        .then(() => {
          alert('Paciente cadastrado com sucesso!');
          this.resetForm();
        })
        .catch((error) => {
          console.error(error);
          alert('Erro ao cadastrar paciente!');
        });
    },
    resetForm() {
      this.paciente = {
        nome: '',
        cpf: '',
        dataNascimento: '',
        peso: '',
        altura: '',
        uf: ''
      };
    }
  },
  mounted() {
    const userRole = localStorage.getItem('role');
    if (userRole === 'medico') {
      this.isEnfermeiro = false;
    }
  }
};
</script>
