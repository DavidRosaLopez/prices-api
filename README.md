# prices-api

API REST para consultar el precio aplicable de un producto en una cadena en una fecha y hora concretas.

## Resumen

La API expone un endpoint REST que recibe como parámetros de consulta:

- Identificador de producto
- Identificador de cadena
- Fecha y hora de aplicación

Y devuelve el precio aplicable con la siguiente información:

- Identificador de producto
- Identificador de cadena
- Tarifa aplicable
- Fechas de vigencia
- Precio final y moneda

## Stack

- Java 25
- Spring Boot 4.1
- Spring Web
- Spring Web MVC Test
- Spring Data JPA
- Spring Boot Test
- Springdoc OpenAPI 3
- H2 Database
- Lombok
- MapStruct

## Perfiles

- `dev`: perfil por defecto. Usa base de datos H2 en memoria, crea el esquema al arrancar y activa la consola H2.
- `test`: perfil para la suite automatizada. Usa una base de datos H2 aislada para no compartir estado con `dev`.

## Endpoints

`GET /api/v1/prices/retrievePrice`

### Query params

- `brandId`: identificador de la cadena
- `productId`: identificador del producto
- `applicationDate`: fecha y hora de consulta en formato ISO-8601 sin zona horaria (`2020-06-14T16:00:00`)

### Ejemplo

```http
GET /api/v1/prices/retrievePrice?brandId=1&productId=35455&applicationDate=2020-06-14T16:00:00
```

### Contrato de respuesta

- `200 OK`: devuelve la tarifa aplicable.
- `204 No Content`: no existe tarifa válida para la fecha y hora de aplicación.
- `400 Bad Request`: parámetros ausentes, inválidos o con formato incorrecto.
- `500 Internal Server Error`: error no controlado.

## Datos de ejemplo

La base de datos H2 se inicializa automáticamente con los 4 registros del enunciado, más 1 registro adicional para validar el desempate por fecha de creación (`CREATION_DATE`), en `src/main/resources/data.sql`.

La entidad principal es `PRICES`, con estos campos:

- `BRAND_ID`
- `START_DATE`
- `END_DATE`
- `PRICE_LIST`
- `PRODUCT_ID`
- `PRIORITY`
- `PRICE`
- `CURR`
- `CREATION_DATE` (campo añadido)

## Reglas de negocio

- Un precio es aplicable si `applicationDate` está dentro del rango `[START_DATE, END_DATE]`.
- Si hay varias tarifas válidas con la misma `PRIORITY`, se obtiene el registro más reciente por `CREATION_DATE`.
- `CREATION_DATE` es único, así que no puede haber dos registros con la misma fecha de creación.

## Tests

La suite de tests del controlador valida estos casos:

### Tests del enunciado

- Test 1: Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA).
- Test 2: Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA).
- Test 3: Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA).
- Test 4: Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA).
- Test 5: Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA).

### Test adicional

- Test 6: Verifica que, si dos tarifas tienen la misma prioridad, se obtiene la más reciente por fecha de creación (`CREATION_DATE`).

### Tests adicionales de validación de errores

- Test 7: Petición con parámetros inválidos.
- Test 8: Petición sin parámetros.
- Test 9: Petición con parámetros nulos.
- Test 10: Petición con parámetros fuera de rango.
- Test 11: Petición con parámetros con formato inválido.
- Test 12: Petición que no encuentra resultados.

La suite se ejecuta con el perfil `test`.

## Documentación

- [Swagger UI](http://localhost:8080/swagger-ui.html)
- [OpenAPI JSON](http://localhost:8080/v3/api-docs)