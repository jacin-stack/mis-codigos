let inputNombre = document.querySelector("input#input-nombre");
let inputApellido = document.querySelector("input#input-apellido");
let inputCorreo = document.querySelector("input#input-correo");
let boton = document.querySelector("#boton-agregar");
let listaUsuarios = document.querySelector("#lista-usuarios");
let listaUsuariosDatos = [];
let departamentoSeleccionado = document.querySelector("#selector");
let it = document.querySelector("#it");
let marketing = document.querySelector("#marketing");
let ventas = document.querySelector("#ventas");
let administracion = document.querySelector("#administracion");
let contadorIT = 0;
let contadorMarketing = 0;
let contadorVentas = 0;
let contadorAdministracion = 0;

boton.addEventListener("click", () => {
    let departamento = departamentoSeleccionado.value;
    if (inputNombre.value.length > 0 && inputApellido.value.length > 0) {
        listaUsuariosDatos.push(inputNombre.value, inputApellido.value, inputCorreo.value, departamento);
        let nodo = document.createElement("li");
        nodo.textContent = `${inputNombre.value} ${inputApellido.value}`;
        nodo.className = "list-group-item";
        listaUsuarios.append(nodo);
        inputNombre.value = "";
        inputApellido.value = "";
        inputCorreo.value = "";
        console.log("Datos en listaUsuariosDatos:", listaUsuariosDatos);
    } else {
        alert("No se puede añadir al empleado");
    }

    if (departamento == "IT") {
        contadorIT++;
        it.innerHTML = contadorIT;
    } else if (departamento == "Marketing") {
        contadorMarketing++;
        marketing.innerHTML = contadorMarketing;
    } else if (departamento == "Ventas") {
        contadorVentas++;
        ventas.innerHTML = contadorVentas;
    } else if (departamento == "Administración") {
        contadorAdministracion++;
        administracion.innerHTML = contadorAdministracion;
    }

})

