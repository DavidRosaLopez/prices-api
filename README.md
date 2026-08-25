# prices-api

Microservicio para consultar el precio aplicable de un producto en una cadena, dado un momento concreto de aplicación.

## Resumen

La aplicación expone un endpoint REST que recibe como parámetros de consulta:

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

- Java 21
- Spring Boot 3.3
- Spring Web
- Spring Data JPA
- Validation
- H2 en memoria
- MapStruct
- Springdoc OpenAPI

## Endpoint

`GET /api/v1/prices/retrievePrice`

### Query params

- `brandId`: identificador de la cadena
- `productId`: identificador del producto
- `applicationDate`: fecha y hora de consulta en formato ISO-8601

### Ejemplo

```http
GET /api/v1/prices/retrievePrice?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1
```

## Datos de ejemplo

La base de datos H2 se inicializa automáticamente con los 4 registros del enunciado en `src/main/resources/data.sql`.

La entidad principal es `PRICES`, con estos campos:

- `BRAND_ID`
- `START_DATE`
- `END_DATE`
- `PRICE_LIST`
- `PRODUCT_ID`
- `PRIORITY`
- `PRICE`
- `CURR`
- `CREATION_DATE`

## Reglas de negocio

- Un precio es aplicable si `applicationDate` está dentro del rango `[START_DATE, END_DATE]`.
- Si hay varias tarifas válidas con la misma `PRIORITY`, se obtiene el registro más reciente por `CREATION_DATE`.
- `CREATION_DATE` es único, así que no puede haber dos registros con la misma fecha de creación.
- Si no se obtiene ningún resultado de la consulta, el servicio responderá con un código de estado `204 No Content` y un cuerpo vacío.

## Tests

La suite de tests del controlador valida estos casos:

Casos del enunciado:

- Test 1: Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA).
- Test 2: Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA).
- Test 3: Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA).
- Test 4: Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA).
- Test 5: Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA).

Test adicional de regla de negocio:

- Test 6: Verifica que, si dos tarifas tienen la misma prioridad, gana la más reciente por `CREATION_DATE`.

Tests adicionales de validación de errores:

- Test 7: Petición con parámetros inválidos.
- Test 8: Petición sin parámetros.
- Test 9: Petición con parámetros nulos.
- Test 10: Petición con parámetros fuera de rango.
- Test 11: Petición con parámetros con formato inválido.
