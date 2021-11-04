# language: es
Característica: Crear empleado
  Yo como usuario requiero crear empleado en el sistema

  Escenario: Crear empleado
    Cuando el actor quiere crear un empleado
      | employeeName | employeeSalary | employeeAge | profileImage                        |
      | demo demo    | 1064501        | 25          | http://dummy.image.com/profile/1234 |
    Entonces deberia obtener status code 200
    Y deberia obtener la confirmacion del registro
