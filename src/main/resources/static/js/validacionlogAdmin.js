let btnenviar = document.getElementById('btnEnviar');
let btnregistrar = document.getElementById('btnEnviar02');
let idTimeout;
let datosUsuario = [];
let validos = 0;
btnenviar.addEventListener('click', function (event) {
  event.preventDefault();
  let inputUsuario = document.getElementById('usuario');
  let inputPassword = document.getElementById('password');
  let inputToken= document.getElementById('token');
  let alertError = document.getElementById('alertError');
  let alertSuccess = document.getElementById('alertSuccess');

  let pass1 = document.getElementById('password');
  let email =
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

  alertError.style.display = 'none';
  alertError.innerHTML = '';
  alertSuccess.style.display = 'none';
  alertSuccess.innerHTML = '';
  
  if (inputUsuario.value.match(email) == null || pass1.value.length == 0||inputToken.value.length==0) {
    alertError.style.display = 'block';
    alertError.innerHTML += 'Datos inválidos. Por favor rellene todos los campos';
    inputUsuario.style.background = '#f8d7da';
    inputUsuario.style.border = 'solid red 3px';
    inputPassword.style.background = '#f8d7da';
    inputPassword.style.border = 'solid red 3px';
    inputToken.style.background = '#f8d7da';
    inputToken.style.border = 'solid red 3px';
  }
else{
    alertError.style.display = 'block';
    alertError.innerHTML += 'Datos inválidos. Por favor rellene todos los campos.';
    inputUsuario.style.background = '#f8d7da';
    inputUsuario.style.border = 'solid red 3px';
    inputPassword.style.background = '#f8d7da';
    inputPassword.style.border = 'solid red 3px';
    inputToken.style.background = '#f8d7da';
    inputToken.style.border = 'solid red 3px';
    console.log(inputToken.value);
 }
    //Modal
  

  function login(username, password) {
    let users = JSON.parse(localStorage.getItem('datosUsuario'));
    for (let i = 0; i < users.length; i++) {
      if (users[i].correo == username && users[i].password == password && inputToken.value==77) {
        validos++;
        alertError.style.display = 'none';
        alertError.innerHTML += '';
        inputUsuario.style.background = '#fff';
        inputUsuario.style.border = 'solid green 3px';
        inputPassword.style.background = '#fff';
        inputPassword.style.border = 'solid green 3px';
        inputToken.style.background = '#fff';
    inputToken.style.border = 'solid green 3px';
        sessionStorage.setItem('currentUser', username);
        alertSuccess.style.display = 'block';
        alertSuccess.innerHTML += '<br/>Inicio de sesión exitoso.';
        setTimeout(() => {
          window.location.href = '../html/formulario_de_creacion.html'; 
        }, 2000);
        return;
      } 
    }
    
  }
  let tmp = localStorage.getItem('datosUsuario');
  if (tmp != null) {
    datosUsuario = JSON.parse(tmp);
    let inputUsuario = document.getElementById('usuario');
    let inputPassword = document.getElementById('password');
    login(inputUsuario.value, inputPassword.value);
  }
});
btnregistrar.addEventListener('click', function (event) {
  event.preventDefault();
  window.location.href = '../html/registro.html'; 
});
