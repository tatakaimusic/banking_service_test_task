ЗАПУСК ПРИЛОЖЕНИЯ:
1. Создайте .env файл с такими переменными:
     HOST=localhost:5437 <br />
     POSTGRES_DB=banking <br />
     POSTGRES_USERNAME=postgres <br />
     POSTGRES_PASSWORD=postgres <br />

     JWT_SECRET=aGZiYmtiYWllYmNpZWFpZWJsZWNldWNlY2xhZWNhaWJlbGNhZWN3Q0VCV0VXSUM= <br />
     JWT_ACCESS=1 <br />
     JWT_REFRESH=30 <br />
2. Запустите docker контейнер для базы данных postgres
3. Запустите com/example/banking_service_test_task/BankingServiceTestTaskApplication.java


Все пользователи в базе данных имеют пароль 12345.
