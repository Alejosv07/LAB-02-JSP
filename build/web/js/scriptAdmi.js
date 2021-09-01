const card__transaccion = document.getElementsByClassName("card__transaccion");;
const botonTransaccion = document.getElementsByClassName("boton--transaccion");
const botonActualizar = document.getElementsByClassName("boton--actualizar");
const botonCancelar = document.getElementsByClassName("boton--cancelar");
const btnGenerarNcuenta = document.getElementById("btnGenerarNcuenta");

for (let index = 0; index < card__transaccion.length; index++) {
    botonTransaccion[index].addEventListener("click", (evt) => {
        evt.preventDefault();
        const card = document.getElementsByClassName("card");
        //Agregamos html de forma dinamica
        card__transaccion[index].innerHTML = `<input type="number" name="txtMonto" class="inputText" placeholder="Monto" step="0.01" required="true" min="0.01">
        <input type="text" class="inputText" name="txtObservacion" placeholder="Observación" required>
        <button type="submit" name="btnAbonar" class="boton boton--abonar">Abonar</button>
        <button type="submit" name="btnRetirar" class="boton boton--retirar">Retirar</button>
        <button class="boton boton--cancelar" type="button"><i class="far fa-times-circle"></i></button>`;
        card[index].setAttribute('action', 'CTransaccion');
        card__transaccion[index].style.width = "100%";
        card__transaccion[index].style.margin = "1em 0 0.5em 0";
        card__transaccion[index].style.visibility = "visible";
        //Agregamos el boton cancelar
        btnCancelar();
    });

    botonActualizar[index].addEventListener("click", (evt) => {
        evt.preventDefault();

        const card = document.getElementsByClassName("card");
        //Agregamos html de forma dinamica
        card__transaccion[index].innerHTML = `<input type="text" name="txtNombreA" placeholder="Nombre" required class="inputText" value="${card[index].childNodes[1].textContent}">
        <input type="text" name="txtContraA" placeholder="Contraseña" required class="inputText" value="${card[index].childNodes[2].textContent}">
        <input type="email" name="txtCorreoA" placeholder="Email" required class="inputText" value="${card[index].childNodes[3].textContent}">
        <button type="submit" name="btnActualizar" class="boton boton--retirar"><i class="fas fa-save"></i></button>
        <button class="boton boton--cancelar" type="button"><i class="far fa-times-circle"></i></button>`;
        card[index].setAttribute('action', 'CCuenta');
        card__transaccion[index].style.width = "100%";
        card__transaccion[index].style.margin = "1em 0 0.5em 0";
        card__transaccion[index].style.visibility = "visible";
        btnCancelar();
    });
}

//Agregamos el evento al voton generar Ncuenta
btnGenerarNcuenta.addEventListener("click", (evt) => {
    evt.preventDefault();
    document.getElementById("txtNRandom").value = (Math.random() * (9999999999999999 - 1000000000000000) + 1000000000000000);
});


function btnCancelar() {
    if (botonCancelar.length > 0) {
        const card = document.getElementsByClassName("card");
        for (let index = 0; index < card__transaccion.length; index++) {
            botonCancelar[index].addEventListener("click", (evt) => {
                evt.preventDefault();
                card__transaccion[index].removeAttribute('style');
                card__transaccion[index].style.visibility = "hidden";
                card[index].setAttribute('action', 'CCuenta');
                card__transaccion[index].innerHTML = `<button class="boton boton--cancelar" type="button"><i class="far fa-times-circle"></i></button>`;
            });
        }
    }
}