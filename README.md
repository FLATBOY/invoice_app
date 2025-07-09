
# 🧾 Invoice Dashboard – A Personal Fullstack Java Learning Project

Welcome! This project is a hands-on, fullstack learning journey where I explore backend architecture using **Java + Spring Boot**, build a lightweight **invoicing web app**, and implement **modern authentication via JWT**, all while storing and managing data securely in **PostgreSQL**.

---

## 🚀 What the Project Is

A web-based dashboard that allows users to:
- Register and log in (JWT auth)
- Create, view, and track their invoices
- See their total spending
- Store invoices **per user** securely in a database
- Interact through a clean and simple frontend interface

It’s a foundation-level system inspired by real-world app structure — minus the complexity — to focus on understanding fullstack fundamentals with Java.

---

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot 3
- Spring Security
- JWT (via [jjwt](https://github.com/jwtk/jjwt))
- Spring Data JPA
- PostgreSQL

### Frontend
- HTML / CSS / Vanilla JS
- Fetch API
- LocalStorage for JWT
- Minimal JS framework (no React/Vue — intentionally raw)

### Dev & Hosting
- Cloudflare Pages (Frontend Hosting)
- Cloudflare Tunnel (or Fly.io / Render for Backend)
- GitHub for version control

---

## 🔄 Current Development Phase

> 🔐 **Phase 3 – JWT Authentication & PostgreSQL Integration**

### ✅ Completed so far:
- User model and invoice model linked via JPA
- Secure backend API with Spring Boot
- PostgreSQL DB connection
- JWT login + token validation
- Role-based access setup for invoice API
- Static frontend integrated (with token auth)

---

## ⏳ What’s Pending / To Be Improved

| Section | Status | Notes |
|--------|--------|-------|
| 🔐 Signup form (HTML) | ⏳ Planned | Build a public-facing frontend form |
| 📈 Data charts | ⏳ Planned | Add pie/bar charts for invoice summary |
| 📄 PDF export | ⏳ Planned | Export invoice summary as downloadable PDF |
| 🔐 Password reset flow | ⏳ Later | Optional for user support UX |
| 🧪 Testing suite | ⏳ Later | Add JUnit/Postman automated tests |
| 🚀 CI/CD | ⏳ Later | Setup GitHub Actions or deploy pipelines |

---

## 🗃️ Data Structure

### User Entity
```java
Long id (PK)
String username (unique)
String password (hashed)

### Invoice Entity
Long id (PK)
String itemName
double quantity
double price
String unit
String date (ISO format)
User user (FK)

---
FOLDER STRUCTURE
invoice-dashboard/
├── backend/
│   ├── entity/           # JPA models (User, Invoice)
│   ├── controller/       # Auth + Invoice controllers
│   ├── repository/       # JPA Repositories
│   ├── service/          # JWT and User logic
│   ├── config/           # Spring Security config
│   ├── filter/           # JWT filter
│   └── application.properties
├── frontend/
│   ├── index.html        # Login page
│   ├── dashboard.html    # Invoice table + total
│   ├── invoice.html      # Form to create invoice
│   └── js/               # invoice.js, dashboard.js

---
🔒 Security & Auth Logic

🔐 Authentication Tech
	•	JWT Token-Based Auth via jjwt (no sessions)
	•	POST /api/auth/login returns a token
	•	Token stored in localStorage on frontend
	•	All protected endpoints (like /api/invoice) require Authorization: Bearer <token>

🛡️ Login Flow
	•	User sends login data
	•	Server authenticates using UserDetailsService
	•	JWT is generated + sent back
	•	Every future request attaches the token in headers
	•	A custom filter (JwtAuthFilter) validates and loads user context

⸻

🧠 Why This Project Exists

I built this from scratch to:
	•	Deepen my backend Java/Spring skills
	•	Understand security systems like JWT
	•	Learn how APIs and databases talk securely
	•	Move from creative design into fullstack confidence 🌱

It’s a sandbox to try ideas, break things, and actually learn by doing.

------





