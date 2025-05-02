# Envío de Mails para RAICO

Este proyecto automatiza el envío de facturas y comprobantes en formato PDF a clientes de la empresa RAICO, utilizando información almacenada en una base de datos SQL Server.

## 📌 Objetivo

Automatizar el proceso de envío de correos electrónicos con archivos PDF adjuntos, que representan comprobantes emitidos a los clientes. Esto permite ahorrar tiempo y reducir errores en el proceso manual.

## 🚀 Funcionalidades

- Conexión a base de datos SQL Server (RAICO)
- Lectura de archivos PDF desde una carpeta específica
- Obtención de dirección de email del cliente desde la base de datos
- Envío de email con archivos adjuntos según el código de cliente
- Registro de logs con errores o confirmaciones de envío
- Respaldo de archivos procesados en una carpeta BackUp
- Preparado para ejecución como servicio o tarea programada en Windows

## 🔧 Tecnologías

- **Lenguaje**: Java
- **IDE**: IntelliJ IDEA
- **Gestor de dependencias**: Maven
- **Base de datos**: SQL Server
- **Correo**: Gmail (SMTP)

## 📂 Estructura de Archivos

- Carpeta de entrada: `\RmRaico\Facturas PDF`
- Carpeta de respaldo: `\RmRaico\Facturas PDF\BackUp`
- Nombre de archivos PDF: el código del cliente está en los primeros 8 caracteres (ej: `00010444_FCA0010500584593_00000000US00482597.pdf` → código: `10444`)

## 🧠 Lógica de Envío

1. Se analiza el nombre de cada archivo PDF para extraer el código del cliente.
2. Se consulta el mail del cliente con una query:
   ```sql
   SELECT Clientes_Codigo, Clientes_Nombre, Clientes_EMail 
   FROM Clientes 
   WHERE Clientes_Codigo = ?
