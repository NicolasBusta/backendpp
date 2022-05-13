# Práctica Profesionalizantes: Backend
Aquí se llevara acabo todo el backend de la practica profesionalizante de los alumnos Eze FC.

## Integrantes
**Lider**: Ezequiel Ferrauti

**Backend Team**
- Nicolas Bustamante
- Leonardo Bravo

## Services

### Career
- GET: `career/all/{pageNo (op)} {pageSize (op)} {sortBy (op)} {direction (op)}`
- GET: `career/get/{id} {pageNo (op)} {pageSize (op)} {sortBy (op)} {direction (op)}`
- POST: `career/create`
- DELETE: `career/delete/{id}`
- UPDATE: `career/update/{id}`

| Request | URL | Parameters |
| ------- | --- | ----------- |
| GET     | career/all/ | `int pageNo, int pageSize, String sortBy, String direction`
| GET     | career/get/ | `int !id`
| POST     | career/create/ | 
| UPDATE     | career/update/ | `int !id`
| DELETE     | career/delete/ | `int !id`

### Degree
- GET: `degree/all`
- GET: `degree/get`
- POST: `degree/create`