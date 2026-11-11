# Командный backend «Заявки на пропуск»

REST API для заявок сотрудников на посещение организации гостем. Сотрудник создаёт и просматривает свои заявки, а охрана принимает решение через служебный API. Полная формулировка задания приведена в [`TASK.md`](TASK.md).

Проект использует Kotlin, Spring Boot, Spring Data JPA, Liquibase и PostgreSQL. Схема и учебные данные загружаются миграциями Liquibase. Для локального запуска нужны JDK 17, Docker с Docker Compose и доступ к Maven Central и Docker Hub при первой сборке. Gradle Wrapper уже включён.

## Запуск

Все команды выполняйте из каталога проекта. Docker Compose запускает PostgreSQL на `127.0.0.1:5435` с базой `nto_team` и локальными реквизитами `nto`/`nto`. При необходимости задайте свои параметры подключения через `DB_URL`, `DB_USER` и `DB_PASSWORD`. Переменная `ADMIN_KEY` задаёт ключ служебного API; укажите собственное локальное значение.

```bash
docker compose -p nto_team_local -f compose.yml up -d --wait
export DB_URL=jdbc:postgresql://127.0.0.1:5435/nto_team
export DB_USER=nto
export DB_PASSWORD=nto
export ADMIN_KEY=local-admin-key
./gradlew bootRun
```

Приложение будет доступно на `http://localhost:8080`. Другой HTTP-порт можно задать переменной `SERVER_PORT`.

Заготовка запускается, но незавершённые методы возвращают `501 {"error":"Task not implemented"}` до выполнения задания.

Остановить PostgreSQL:

```bash
docker compose -p nto_team_local -f compose.yml down
```

Команда `down` сохраняет данные в Docker-томе. Не добавляйте `-v`, если хотите сохранить их.
