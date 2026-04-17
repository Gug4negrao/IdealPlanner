# 📋 IdeaPlanner

Sistema de gestão de conteúdos para redes sociais.

🔗 **[https://idealplanner.onrender.com](https://idealplanner.onrender.com)**

---

## 🛠️ Tecnologias

- Java 17
- Spring Boot 4.x
- PostgreSQL
- Docker
- Maven

---

## 🚀 Como rodar localmente

### Pré-requisitos

- Java 17+
- Maven
- PostgreSQL

### 1. Clone o repositório

```bash
git clone https://github.com/Gug4negrao/IdealPlanner.git
cd IdealPlanner
```

### 2. Configure as variáveis de ambiente

Configure as credenciais do banco de dados nas variáveis de ambiente da sua máquina antes de rodar.

### 3. Rode a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

---

## 🐳 Rodando com Docker

```bash
docker build -t idealplanner .
docker run -p 8080:8080 idealplanner
```

---

## 📦 Deploy

O projeto é implantado automaticamente no **Render** a cada push na branch `main`.

> ⚠️ A instância gratuita pode ter latência de até 50 segundos após inatividade.
