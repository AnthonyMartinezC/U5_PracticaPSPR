# Proyecto: Validación de DNI con Sockets TCP

## 📌 Descripción
Este proyecto implementa un sistema de validación de **DNI** utilizando **sockets TCP** en Java. El sistema consta de un **servidor concurrente** y un **cliente** que se comunican para validar un DNI ingresado por el usuario.

## 🛠️ Tecnologías Utilizadas
- **Java 21**
- **Sockets TCP**
- **JUnit 5** para pruebas unitarias
- **Maven** para la gestión de dependencias
- **Mockito** para pruebas simuladas

---

## 📂 Estructura del Proyecto
<img src="https://github.com/user-attachments/assets/37d591cc-34d4-4ebc-a7a3-c500ae8d8314" alt="imagen" width="400px">



## 🔹  Compilar el Proyecto
Ejecutar el siguiente comando para compilar el código:
mvn clean install
## 🔹  Ejecutar el Servidor
Para iniciar el servidor TCP:
Dale a run en el archivo ServidorDNI.java

## 🔹 Ejecutar el Cliente
Para iniciar el cliente: 
Dale a run en el archivo ClienteDNI.java


## 🎯 Funcionamiento
El servidor escucha en el puerto 5000 y espera conexiones.
El cliente solicita un DNI al usuario y lo envía al servidor.
El servidor valida el formato y la letra del DNI, devolviendo true si es válido o false si es incorrecto.
El cliente muestra el resultado en pantalla.
