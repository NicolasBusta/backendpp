# BackendPP
Aquí se llevara acabo todo el backend de la practica profesionalizante de los alumnos Eze FC.

## Integrantes
**Lider**: Ezequiel Ferrauti 
**Backend Team**:
+ Nicolas Bustamante
+ Leonardo Bravo

## Services

### Career
- GET: `career/all/{pageNo (op)} {pageSize (op)} {sortBy (op)} {direction (op)}`
- GET: `career/get/{id} {pageNo (op)} {pageSize (op)} {sortBy (op)} {direction (op)}`
- POST: `career/create`
- DELETE: `career/delete/{id}`
- UPDATE: `career/update/{id}`

op: optional

### Degree
- GET: `degree/all`
- GET: `degree/get`
- POST: `degree/create`