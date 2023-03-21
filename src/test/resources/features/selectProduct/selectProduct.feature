#language:es
@WebApp
@SelectProduct
Característica:Selección de productos

  Esquema del escenario: agregar productos de la sección <seccion> al carrito de compras
    Dado que Pedro se encuentra en la seccion de <seccion>
    Cuando selecciona los productos <productos>
    Entonces al ingresar al carro de compras se deben mostrar los productos seleccionados

    Ejemplos: Selección de productos
      | seccion    | productos                                                          |
      | tees-women | Desiree Fitness Tee,Tiffany Fitness Tee,Gabrielle Micro Sleeve Top |
      | tees-men   | Strike Endurance Tee,Aero Daily Fitness Tee,Balboa Persistence Tee |
      | gear-bags  | Push It Messenger Bag,Compete Track Tote,Rival Field Messenger     |


