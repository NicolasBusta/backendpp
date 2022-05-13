# Práctica Profesionalizante: Backend
Aquí se llevara acabo todo el backend de la practica profesionalizante de los alumnos Eze FC.

## Integrantes
**Lider**: Ezequiel Ferrauti

**Backend Team**
- Nicolas Bustamante
- Leonardo Bravo

## Services

Service  | Request | URL            | Parameters                                                 |
| -----  | ------- | -------------- | ---------------------------------------------------------- |
| Career | GET     | career/all/    | `int pageNo, int pageSize, String sortBy, String direction`
| Career | GET     | career/get/    | `int !id`
| Career | POST    | career/create/ | 
| Career | UPDATE  | career/update/ | `int !id`
| Career | DELETE  | career/delete/ | `int !id`
| Degree | GET     | degree/all/    | 
| Degree | GET     | degree/get/    | `int !id`
| Degree | POST    | degree/save/   | 

**Glosary**
- !: required parameter.
- int: number type.
- String: text type.