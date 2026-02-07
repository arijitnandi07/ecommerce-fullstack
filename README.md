# 🛍️ E-Commerce Product Catalog

<div align="center">

### *A Lightweight Spring Boot + React Product Catalog*

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![Vite](https://img.shields.io/badge/Vite-7.x-646CFF.svg)](https://vitejs.dev/)
[![React](https://img.shields.io/badge/React-19.x-61DAFB.svg)](https://react.dev/)

[Features](#-features) • [Tech Stack](#-tech-stack) • [Getting Started](#-getting-started) • [API](#-api)

---

*Modern, minimal full-stack catalog app for showcasing products and categories.*

</div>

---

## 📋 Table of Contents

- [✨ Features](#-features)
- [🏗️ Tech Stack](#-tech-stack)
- [🚀 Getting Started](#-getting-started)
- [📁 Project Structure](#-project-structure)
- [🔗 API](#-api)
- [🧪 Testing](#-testing)
- [📄 License](#-license)

---

## ✨ Features

- 📦 Product catalog with category filtering
- ⚡ Fast API built with Spring Boot and JPA
- 🧩 React + Vite front-end
- 🔄 Seed data on startup for quick demos

---

## 🏗️ Tech Stack

| Category | Technologies |
|----------|--------------|
| **Backend** | Spring Boot 4, Java 21, Spring Data JPA |
| **Database** | MySQL 8 |
| **Frontend** | React 19, Vite 7 |
| **Build Tools** | Maven, npm |

---

## 🚀 Getting Started

### Prerequisites

- ☕ **Java 21**
- 🗄️ **MySQL 8+**
- 📦 **Maven** (or use the included `mvnw` wrapper)
- 🧰 **Node.js 18+** and **npm**

### 1) Configure the Database

Create a local database:

```sql
CREATE DATABASE product-catalog;
```

Default backend settings are in:

```
Backend/productcatalog/src/main/resources/application.properties
```

Current defaults:

- URL: `jdbc:mysql://localhost:3306/product-catalog`
- Username: `root`
- Password: `Jit@8`

> **Tip:** Override these values locally if your MySQL credentials differ.

### 2) Run the Backend

```bash
cd Backend/productcatalog
./mvnw spring-boot:run
```

API will be available at **http://localhost:8080**.

### 3) Run the Frontend

```bash
cd Frontend
npm install
npm run dev
```

UI will be available at **http://localhost:5173**.

---

## 📁 Project Structure

```
./Backend/productcatalog  # Spring Boot API
./Frontend               # React + Vite UI
```

---

## 🔗 API

Base URL:

```
http://localhost:8080
```

Endpoints:

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/categories` | List all categories |
| `GET` | `/api/products` | List all products |
| `GET` | `/api/products/category/{categoryId}` | Products by category |

---

## 🧪 Testing

No automated tests are currently defined for this project.

---

## 📄 License

Specify a license for this project if needed.
