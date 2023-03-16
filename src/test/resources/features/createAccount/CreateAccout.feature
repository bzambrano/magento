# language: es
@WebApp
Característica: Realizar el registro de un nuevo usuario

  Escenario: Registro Exitoso.
    Dado que juan se encuentra en la pagina de registro y quiere hacer el registro para poder hacer las compras en la plataforma de LUMA
    Cuando Diligencia los campos requeridos en el formulario y envia la infomacion
    Entonces El sistema me debe indicar que el registro fue exitoso
    Y al hacer el login con las mismas credenciales del registro se debe ingresar de forma correcta

  Escenario: : Validación de campos requeridos en formulario de registro
    Dado que Pedro se encuentra diligenciado el formulario de registro
    Cuando se intenta crear una cuenta con campos vacios
    Entonces se deben mostrar las alertas para cada campo
    Y al diligenciar el campo la alerta no se debe mostrar