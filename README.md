# 🎧 Podcast Queue Backend

A Spring Boot REST API that allows users to manage podcast episodes and maintain a personalized queue with notes and listened status.

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Lombok
- Postman (for testing)

---

## 📚 Features

- ✅ Add and view podcast episodes
- ✅ Add and view users
- ✅ Add episodes to a user’s queue
- ✅ Update notes and listened status
- ✅ Delete queue entries
- ✅ Automatically tracks `createdAt` and `updatedAt` timestamps

---

## 🔗 API Endpoints

### 🎧 Podcast Episodes
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/episodes` | Add a new podcast episode |
| `GET`  | `/api/episodes` | Get all podcast episodes |

### 👤 Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/users` | Add a new user |
| `GET`  | `/api/users` | Get all users |

### 📥 Queue
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/queue?userId=1&episodeId=1&listened=false&notes=testing` | Add episode to user’s queue |
| `GET`  | `/api/queue/{userId}` | View user’s queue |
| `PUT`  | `/api/queue/{queueId}?listened=true&notes=updated+note` | Update queue entry |
| `DELETE` | `/api/queue/{queueId}` | Delete queue entry |

---

## 📬 Sample Request (Add to Queue)

```http
POST /api/queue?userId=1&episodeId=1&listened=false&notes=Listen before sleep
