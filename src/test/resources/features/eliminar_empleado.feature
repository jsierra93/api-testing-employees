# language: es
Característica: Eliminar empleado
  Yo como usuario requiero eliminar un empleado en el sistema

  Escenario: Eliminar empleado
    Cuando el actor quiere eliminar un empleado con id 2
    Entonces deberia obtener status code 200
    Y deberia obtener la confirmacion de la eliminacion