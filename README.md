# DevMura - Backend

¡Bienvenido a DevMura! Este es el repositorio del backend de nuestra red social enfocada en desarrolladores. Aquí encontrarás toda la información necesaria para comprender y trabajar en el backend de DevMura, que ha sido desarrollado utilizando Java y Spring Boot.

## Descripción

DevMura es una plataforma social dedicada a los desarrolladores de software. Permite a los usuarios compartir conocimientos, discutir temas relacionados con la programación, colaborar en proyectos y conectarse con otros profesionales de la industria.

## Tecnologías utilizadas

El backend de DevMura ha sido desarrollado utilizando las siguientes tecnologías principales:

- **Java**: Un lenguaje de programación de propósito general ampliamente utilizado.
- **Spring Boot**: Un marco de aplicación de Java que facilita el desarrollo rápido y la configuración fácil de aplicaciones basadas en Spring.
- **Spring Data JPA**: Una biblioteca que simplifica el acceso a la base de datos utilizando el patrón de acceso a datos de objeto (Object Relational Mapping - ORM).
- **Spring Security**: Un marco de seguridad para aplicaciones Java que proporciona autenticación y autorización robustas.
- **MySQL**: Un sistema de gestión de bases de datos relacional utilizado para almacenar los datos de la aplicación.

## Estructura del proyecto

El proyecto del backend de DevMura sigue una estructura de directorios bien organizada:

- `src/main/java`: Contiene el código fuente de la aplicación Java.
  - `com.devmura`: Paquete raíz del proyecto.
    - `config`: Contiene las clases de configuración de Spring.
    - `controllers`: Contiene los controladores de la API REST.
    - `models`: Contiene las clases de modelo que representan las entidades de la base de datos.
    - `repositories`: Contiene las interfaces de repositorio que definen las operaciones de acceso a datos.
    - `services`: Contiene los servicios de negocio que interactúan con los repositorios y realizan la lógica de la aplicación.
- `src/main/resources`: Contiene los archivos de configuración y recursos adicionales.
  - `application.properties`: Archivo de configuración principal de Spring Boot.
  - `schema.sql`: Archivo que define el esquema de la base de datos.

## Configuración

Para ejecutar el backend de DevMura en tu entorno de desarrollo local, sigue estos pasos:

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener instalada la versión adecuada de Java.
3. Configura tu entorno de desarrollo con las dependencias necesarias (Spring Boot, MySQL, etc.).
4. Crea una base de datos MySQL y configura los detalles de conexión en el archivo `application.properties`.
5. Ejecuta el proyecto utilizando una herramienta de construcción como Maven o Gradle.

## Contribución

Si deseas contribuir a DevMura, ¡estamos encantados de recibir tus aportes! Puedes colaborar de varias formas:

- Realizando mejoras en el código existente.
- Implementando nuevas características y funcionalidades.
- Reportando y corrigiendo errores.

Antes de comenzar a contribuir, asegúrate de revisar nuestras pautas y políticas de contribución en el archivo `CONTRIBUTING.md`.

## Contacto

Si tienes alguna pregunta o sugerencia relacionada con el backend de DevMura, no dudes en ponerte en contacto con
