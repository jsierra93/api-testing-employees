# language: es
Característica: Consultar lista empleados
  Yo como usuario requiero consultar los empleados registrados en el sistema

  Escenario: Consultar empleados
    Cuando el actor consulta lista de empleados
    Entonces deberia obtener status code 200
    Y deberia obtener la informacion de todos los empleados