<template>
    <div class="login-container">
      <div class="login-card">
        <h1 class="title">Bem-vindo à Clínica</h1>
        <p class="subtitle">Faça login para acessar o sistema</p>
        
        <form @submit.prevent="login" class="login-form">
          <div class="input-group">
            <label for="email">Email</label>
            <input type="email" id="email" v-model="email" placeholder="Digite seu e-mail" required />
          </div>
  
          <div class="input-group">
            <label for="password">Senha</label>
            <input type="password" id="password" v-model="password" placeholder="Digite sua senha" required />
          </div>
  
          <div class="action-group">
            <button type="submit" class="login-button">Entrar</button>
          </div>
        </form>
  
        <div class="footer">
          <p><a href="#" class="forgot-password">Esqueceu a senha?</a></p>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        email: '',
        password: ''
      };
    },
    methods: {
      login() {
        console.log("Login feito com:", this.email, this.password);
      }
    }
  };
  </script>
  
  <style scoped>
  .login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f4f7fc;
  }
  
  .login-card {
    background-color: white;
    padding: 2rem;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px;
  }
  
  .title {
    font-size: 2rem;
    color: #2c3e50;
    text-align: center;
    margin-bottom: 0.5rem;
  }
  
  .subtitle {
    font-size: 1.2rem;
    color: #7f8c8d;
    text-align: center;
    margin-bottom: 2rem;
  }
  
  .input-group {
    margin-bottom: 1.5rem;
  }
  
  .input-group label {
    display: block;
    font-size: 1rem;
    color: #2c3e50;
    margin-bottom: 0.5rem;
  }
  
  .input-group input {
    width: 100%;
    padding: 0.8rem;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    outline: none;
  }
  
  .input-group input:focus {
    border-color: #3498db;
  }
  
  .login-button {
    width: 100%;
    padding: 0.8rem;
    font-size: 1.2rem;
    color: white;
    background-color: #3498db;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  
  .login-button:hover {
    background-color: #2980b9;
  }
  
  .footer {
    text-align: center;
    margin-top: 1.5rem;
  }
  
  .forgot-password {
    color: #3498db;
    text-decoration: none;
  }
  
  .forgot-password:hover {
    text-decoration: underline;
  }
  </style>
  