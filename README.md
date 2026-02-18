Conversor de Monedas en Java

Aplicación de consola desarrollada en **Java 17** que consume la API de ExchangeRate-API para realizar conversiones de divisas en tiempo real.

Tecnologías utilizadas

- Java 17
- HttpClient (Java moderno)
- Gson
- ExchangeRate-API
- Programación orientada a objetos
- Records (Java 16+)

Arquitectura del proyecto

El proyecto está organizado siguiendo separación de responsabilidades:

Main
Punto de entrada de la aplicación.
Menu
Maneja la interacción con el usuario.
CurrencyService
Se encarga de consumir la API usando `HttpClient`.
ExchangeResponse
Modela la respuesta JSON utilizando `record`.

Conversiones disponibles

1. USD → MXN  
2. MXN → USD  
3. USD → EUR  
4. EUR → USD  
5. USD → GBP  
6. GBP → USD  
7. USD → JPY  
8. JPY → USD

Cómo usar tu propia API Key

Este proyecto utiliza la API de ExchangeRate-API.

Por seguridad, la API key **no está incluida en el repositorio**.  
Cada usuario debe generar su propia clave siguiendo estos pasos:

Crear una cuenta en ExchangeRate-API

1. Visita: https://www.exchangerate-api.com/
2. Regístrate gratuitamente.
3. Recibiras un correo con tu API personal.

Configurar la variable de entorno

El proyecto obtiene la clave mediante la siguiente lineas de codigo:
System.getenv("API_KEY");

Abre CMD o PowerShell y ejecuta:
setx API_KEY "Tu API KEY"

En MAC o Linux
export API_KEY="Tu API KEY"

Reinicia tu IDE o terminal
Ya con tu variable de entorno configurada ejecuta Main.java

Clonar repositorio
git clone https://github.com/TU_USUARIO/conversor-moneda-java.git
