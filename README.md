# Test API Employees
Test automatizado de un API Rest utilizando Serenity BDD, Serenity-Rest, Cucumber,
Java, Maven.

Prerequisito:
1. Instalar JDK, Maven, Docker (Opcional)

Para ejecutar los test utilizar el comando:

`mvn verify -Dtest="co.com.jsierra.runners.*"`

Para el ejemplo se construyó un api sandbox en caso que falle el api principal, para hacer uso del sandbox
ejecutar el comando:

`mvn verify -Drestapi.baseurl=https://dummy-employee.getsandbox.com:443 -Dtest="co.com.jsierra.runners.*"`

Para utilizar Jenkins por primera vez:
1. Instalar docker
2. En la raiz del proyecto ejecutar el comando `docker-compose up`
3. En el log que se visualiza al crear el contenedor observamos una linea que nos 
 indica que se creo un password, copiar para usar al ingresar por primera vez a jenkins.
4. Una vez el contenedor se crea, en la terminal se visualiza el mensaje
   **Jenkins is fully up and running**
5. Para ingresar a Jenkins utilizamos la dirección **http://localhost:8080/**
6. Aqui nos solicita la contraseña indicada en el paso 3 e instalamos los plugins default. 
(Tiempo de espera depende de velocidad del internet)
7. Ahora desde la opción Manage Jenkins -> Manage Plugins instalaremos los siguientes plugins:   
   * HTML Publisher
   * Pipeline Maven Integration
8. En la opción Manage Jenkins -> Global Tool Configuration
buscamos el item Maven e instalamos la versión que requerimos:
En este caso name:maven3.8.3, Version: 3.8.3
9. Para evitar problemas visualizando el reporte Serenity aplicamos una politica a Jenkins:
    Manage Jenkins -> Script Console
Copiamos el codigo en el cuadro de texto y ejecutamos:
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
10. Procedemos a la creación del proyecto, para esto tenemos varias opciones en Dashboard -> New Item:
En este caso simple, crearemos un pipeline.
11. Ya en la configuración del pipeline tenemos los siguientes parametros:
    1. Github project: aqui agregamos la url del proyecto [https://github.com/jsierra93/api-testing-employees.git](https://github.com/jsierra93/api-testing-employees.git)
    2. Pipeline: 
       1. Definition: Podemos utilizar el Jenkinsfile desde Github o se copia el codigo directamente,
       para este caso se utiliza desde GIT.
       2. Script Path: Jenkinsfile
    3. Apply y Save.
12. Solo nos queda ejecutar, por medio de la opción Build Now.