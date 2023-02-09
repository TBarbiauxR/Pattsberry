let btnenviar = document.getElementById('btnEnviar');
let btnregistrar = document.getElementById('btnEnviar02');
let idTimeout;
let datosUsuario = [];
let validos = 0;

let usuariodb=[];
function getUser(){
  return fetch('/api/usuarios/', {
    method: 'GET',})
    .then(function (response) {
      response.json().then(function (json) {
        usuariodb = json;
        usuariodb.forEach((usuario) => {
         return usuario;
        }); // foreach
        console.log(usuariodb);
      }); //then
    })
    .catch(function (err) {
      console.log(err);
    });
}
window.addEventListener('load', function (event) {
  getUser();
  });

btnenviar.addEventListener('click', function (event) {
  event.preventDefault();
  let inputUsuario = document.getElementById('usuario');
  let inputPassword = document.getElementById('password');
  let alertError = document.getElementById('alertError');

  let pass1 = document.getElementById('password');
  let email =
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

  alertError.style.display = 'none';
  alertError.innerHTML = '';
  if (sessionStorage.getItem('currentUser')) {
    alertError.style.display = 'block';
    alertError.innerHTML +=
      'Ya existe una sesión activa. Por favor cierra sesión antes de iniciar sesión nuevamente.';
  } else {
    if (inputUsuario.value.match(email) == null || pass1.value.length == 0) {
      alertError.style.display = 'block';
      alertError.innerHTML += 'Datos inválidos. Por favor rellene ambos campos';
      inputUsuario.style.background = '#f8d7da';
      inputUsuario.style.border = 'solid red 3px';
      inputPassword.style.background = '#f8d7da';
      inputPassword.style.border = 'solid red 3px';
    } else {
      alertError.style.display = 'block';
      alertError.innerHTML +=
        'Datos inválidos. Por favor rellene ambos campos.';
      inputUsuario.style.background = '#f8d7da';
      inputUsuario.style.border = 'solid red 3px';
      inputPassword.style.background = '#f8d7da';
      inputPassword.style.border = 'solid red 3px';
    }
    //Modal

    function login(username, password) {
      let users = usuariodb;
     
      for (let i = 0; i < users.length; i++) { 
        if (users[i].correo == username && users[i].contraseña == password) {
          validos++;
          alertError.style.display = 'none';
          alertError.innerHTML += '';
          inputUsuario.style.background = '#fff';
          inputUsuario.style.border = 'solid green 3px';
          inputPassword.style.background = '#fff';
          inputPassword.style.border = 'solid green 3px';
          sessionStorage.setItem('currentUser', username);
          Swal.fire('Se ha iniciado sesión con éxito.', '', 'success');
          setTimeout(() => {
            window.location.href = '../index.html';
          }, 2000);
          return;
        }
      }
    }
    let tmp = usuariodb;
    if (tmp != null) {
      usuariodb;
      let inputUsuario = document.getElementById('usuario');
      let inputPassword = document.getElementById('password');
      login(inputUsuario.value, inputPassword.value);
    }
  }
});

btnregistrar.addEventListener('click', function (event) {
  event.preventDefault();
  window.location.href = '../html/registro.html';
});
