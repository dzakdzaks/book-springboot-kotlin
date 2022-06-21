# Book Spring Boot Kotlin API

## Base url

```
https://book-springboot-kotlin.herokuapp.com/
```

## Table endpoints
### Book

| Name           | Endpoint        | Method   | Body and response                 |
|----------------|-----------------| -------- |-----------------------------------|
| Get Book By ID | `/v1/book/{id}` | `GET`   | [example](#book---get-book-by-id) |
| Get Books      | `/v1/book`      | `GET`   | [example](#book---get-books)      |
| Add Book       | `/v1/book`      | `POST`    | [example](#book---add-book)       |
| Update Book    | `/v1/book/{id}` | `PUT`    | [example](#book---update-book)    |
| Delete Book    | `/v1/book/{id}` | `DELETE`    | [example](#book---delete-book)    |

## Run on localhost
- Run `./gradlew bootRun`
- Then access to `http://localhost:8003`

## Postman collection
Import file [book-springboot-kotlin.postman_collection.json](https://github.com/dzakdzaks/book-springboot-kotlin/blob/master/book-springboot-kotlin.postman_collection.json) to your postman, and setup your environment collection.

---

## Book Examples
### Book - Get Book By Id

```
GET /v1/book/62b1524bd0db143a3a80ae46
```
Response

```json
{
    "status": 200,
    "message": "Get Book Success",
    "data": {
        "id": "62b1524bd0db143a3a80ae46",
        "title": "book 1",
        "createdDate": "2022-06-21T05:08:27.033+00:00",
        "updatedDate": "2022-06-21T05:08:27.033+00:00"
    }
}
```

### Book - Get Books

```
POST /v1/book
```

Response

```json
{
    "status": 200,
    "message": "Get Books Success",
    "data": [
        {
            "id": "62b1524bd0db143a3a80ae46",
            "title": "book 1",
            "createdDate": "2022-06-21T05:08:27.033+00:00",
            "updatedDate": "2022-06-21T05:08:27.033+00:00"
        },
        {
            "id": "62b15a302e74cd6dfb74235a",
            "title": "book 2",
            "createdDate": "2022-06-21T05:42:08.057+00:00",
            "updatedDate": "2022-06-21T05:42:08.057+00:00"
        },
        {
            "id": "62b15a342e74cd6dfb74235b",
            "title": "book 3",
            "createdDate": "2022-06-21T05:42:12.322+00:00",
            "updatedDate": "2022-06-21T05:42:12.322+00:00"
        }
    ]
}
```

### Book - Add Book

```
POST /v1/book
```
Body

```json
{
    "title":"book 3"
}
```

Response

```json
{
    "status": 200,
    "message": "Add Book Success",
    "data": {
        "id": "62b15a342e74cd6dfb74235b",
        "title": "book 3",
        "createdDate": "2022-06-21T05:42:12.322+00:00",
        "updatedDate": "2022-06-21T05:42:12.322+00:00"
    }
}
```

### Book - Update Book

```
PUT /v1/book
```

Body

```json
{
    "title":"book 2 updated"
}
```

Response

```json
{
    "status": 200,
    "message": "Update Book Success",
    "data": {
        "id": "62b15a302e74cd6dfb74235a",
        "title": "book 2 updated",
        "createdDate": "2022-06-21T05:42:08.057+00:00",
        "updatedDate": "2022-06-21T05:45:59.325+00:00"
    }
}
```

### Book - Delete Book

```
GET /v1/book/62b15a302e74cd6dfb74235a
```

Response

```json
{
    "status": 200,
    "message": "book 2 updated Deleted",
    "data": null
}
```
