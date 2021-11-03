# language: es
Característica: Consultar empleado por id
  Yo como usuario requiero consultar informacion de empleado por id registrados en el sistema

  Escenario: Consultar empleado por id
    Cuando el actor consulta informacion empleado con id 1
    Entonces deberia obtener status code 200
    Y deberia obtener la informacion del empleado