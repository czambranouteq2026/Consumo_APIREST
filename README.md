# ConsumoAPIRest - Android

Este proyecto es una aplicación Android desarrollada en Java que consume una API REST para obtener y mostrar una lista de alumnos de la Universidad Técnica Estatal de Quevedo (UTEQ).

## 🚀 Características

- Consumo de API REST utilizando la librería **Volley**.
- Visualización de datos de alumnos (Nombres, Paralelo, Periodo Académico y Correo).
- Manejo seguro de credenciales mediante `BuildConfig` y `local.properties`.
- Interfaz moderna con `ConstraintLayout` y `EdgeToEdge`.

## 🛠️ Requisitos Técnicos

- **Min SDK:** 34
- **Target SDK:** 36
- **JDK:** 11 o superior
- **Gradle:** 8.0+

## 📦 Instalación y Configuración

1.  **Clonar el repositorio:**
    ```bash
    git clone <url-del-repositorio>
    ```

2.  **Configurar las credenciales de la API:**
    Para que la aplicación funcione correctamente, debes crear o editar el archivo `local.properties` en la raíz del proyecto y añadir las siguientes variables:
    ```properties
    API_URL="TU_URL_DE_LA_API"
    API_KEY="TU_API_KEY_AQUÍ"
    ```

3.  **Sincronizar el proyecto:**
    Abre el proyecto en Android Studio y realiza un *Gradle Sync*.

4.  **Ejecutar:**
    Selecciona un dispositivo virtual o físico con API 34 o superior y presiona el botón "Run".

## 📚 Librerías Principales

- [Volley](https://github.com/google/volley): Para las peticiones HTTP.
- [Material Components](https://material.io/develop/android/): Para los elementos de la interfaz de usuario.
- [ConstraintLayout](https://developer.android.com/training/constraint-layout): Para el diseño flexible de la pantalla.

## 📄 Estructura del Proyecto

- `MainActivity.java`: Lógica principal de la aplicación, petición a la API y parseo de JSON.
- `activity_main.xml`: Interfaz de usuario que contiene el logo de la UTEQ y la lista de alumnos.
- `build.gradle`: Configuración de dependencias y variables de compilación.

---
© 2024 - Software UTEQ
