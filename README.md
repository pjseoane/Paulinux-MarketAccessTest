# restAccessROFEX-Java
Introduccion a un conector REST en JAVA a la API de primary.
Se muestran 3 consultas primitivas:

1-Obtencion del token de session.

2-Consulta a todos los contratos listados en el mercado

3-Consulta a los detalles de un contrato en particular.

Estructura del proyecto.

Realizado en JAVA-MAVEN. el IDE es IntelliJ Idea Community Edition 

El JDK es Open JDK11.0

La estrucutra del proyecto es basica y se puede escalar.

En el package configuration se define el fiel config.propertires donde se definen algunos campos 
y el usr y pswd que asigna primary, la conexion es al entorno demo.

Main Access, es el punto de entrada al demo y donde se hacen las consultas y outputs de las primarias definidas
en RESTSession.