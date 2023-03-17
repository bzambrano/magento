#language:es
@WebApp
@Login
Característica:login

  Esquema del escenario: Validar login con credenciales validas y no validas
    Dado Que Camilo cuanto con usuario y contrasena <CasoUso>
    Cuando diligencia los campos del formulario e inicio sesion
    Entonces el sistema debe <RespuestaEspetada>

    Ejemplos:
      | CasoUso    | RespuestaEspetada                                                                                                  |
      | Validos    | Redirigir al usuario a la ventana de inicio con al usuario activo,                                                  |
      | No Validos | mostrar una alerta indicado un error ,Invalid Form Key. Please refresh the page. |
