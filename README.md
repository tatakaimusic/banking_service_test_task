ЗАПУСК ПРИЛОЖЕНИЯ:
1. Создайте .env файл с такими переменными:
     HOST=localhost:5437
     POSTGRES_DB=banking
     POSTGRES_USERNAME=postgres
     POSTGRES_PASSWORD=postgres

    JWT_SECRET=aGZiYmtiYWllYmNpZWFpZWJsZWNldWNlY2xhZWNhaWJlbGNhZWN3Q0VCV0VXSUM=
    JWT_ACCESS=1
    JWT_REFRESH=30
2. Запустите docker контейнер для базы данных postgres
3. Запустите com/example/banking_service_test_task/BankingServiceTestTaskApplication.java


Все пользователи в базе данных имеют пароль 12345.
