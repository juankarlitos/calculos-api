# API de Cálculos con Porcentaje Dinámico

Este proyecto expone una API REST que realiza cálculos con un porcentaje dinámico obtenido desde un servicio simulado.
También guarda un historial de llamadas en una base de datos PostgreSQL.

##  Tecnologías usadas

- Java 17
- Spring Boot 3.4.4
- PostgreSQL (Docker)
- Docker y Docker Compose
- Spring Data JPA
- Springdoc OpenAPI (Swagger)
- Maven

---

## Cómo ejecutar el proyecto

### 1. Clonar el repositorio

git clone https://github.com/juankarlitos/calculos-api.git
cd TU_REPOSITORIO

### 2. Compilar la aplicación (sin tests)
./mvnw clean package -DskipTests

### 3. Levantar la aplicación con Docker

docker-compose up --build

### 3.1 Si necesitas reiniciar desde cero:
docker-compose down --volumes

##  Imagen en Docker Hub

La imagen Docker de este proyecto está publicada en Docker Hub:

🔗 [https://hub.docker.com/repository/docker/jinostrozach/calculos-api](https://hub.docker.com/repository/docker/jinostrozach/calculos-api/general)

Puedes descargarla directamente con:

docker pull jinostrozach/calculos-api




## Endpoints principales

### POST /api/calcular
Realiza la suma de dos números y aplica un porcentaje adicional dinámico.

### GET /api/historial
Retorna el historial de todas las llamadas realizadas.

### GET /mock/porcentage
Simula un servicio externo que retorna un porcentaje fijo (por defecto 10%).

### Documentación Swagger
Puedes acceder a la documentación Swagger desde:

http://localhost:8097/swagger-ui.html

## Pruebas
Puedes ejecutar las pruebas unitarias con:

./mvnw test
Se incluyen pruebas para:

- Cálculo con porcentaje
- Simulación de caché
- Manejo de historial
- Comportamiento del caché

# Consideraciones
El historial de llamadas se guarda en PostgreSQL dentro de un contenedor Docker.

El porcentaje se cachea durante 30 minutos.

Si el servicio externo falla, se utiliza el último valor cacheado.
