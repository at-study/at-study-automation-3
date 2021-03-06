#language: ru

Функция: Вход Администратором. Проверка текста элемента "Моя учётная запись"

  Предыстория:
    Пусть В системе есть пользователь "ПОЛЬЗОВАТЕЛЬ" с параметрами:
      | Администратор                | true                                                             |
      | Статус                       | Активен                                                          |
      | Уведомления о новых событиях | Только для объектов, которые я отслеживаю или в которых участвую |
    И Открыт браузер на странице "/login"

  @ui
  @smoke
  Сценарий: Вход Администратором. Проверка текста элемента "Моя учётная запись"
    Если Авторизоваться как пользователь "ПОЛЬЗОВАТЕЛЬ"
    Тогда Текст элемента Моя учётная запись - "Моя учётная запись"