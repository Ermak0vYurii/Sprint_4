<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
Это **финальный проект 4 спринта** курса обучения **Автоматизатор тестирования на Java**, который я прохожу на [Яндекс.Практикуме](https://practicum.yandex.ru/)

Тестирование UI web-приложения ["Яндекс Самокат"](https://qa-scooter.praktikum-services.ru/)

**Тестовые сценарии:**

1. Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
2. Заказ самоката. Нужно проверить весь флоу позитивного сценария с двумя наборами данных. Проверить точки входа в сценарий, их две: кнопка «Заказать» вверху страницы и внизу.
Из чего состоит позитивный сценарий:
Нажать кнопку «Заказать». На странице две кнопки заказа.
Заполнить форму заказа.
Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.

Дополнительные тестовые сценарии

- Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
- Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
- Проверить ошибки для всех полей формы заказа.
- Проверить: если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет.


**Установка:**
1. Клонируйте репозиторий **Sprint_4** c помощью Git.
2. Перейдите в корневую директорию проекта и выполните команду 'mvn clean install'.

**Использование:**
Для запуска тестов выполните команду "mvn clean test"

**Выбор браузеров для тестирования:**

Автотесты поддеживают браузеры:
- Chrome
- Firefox


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* java 11
* maven 4.0.0
* junit 4.13.2
* selenium 3.141.59

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Юрий **Ермаков** - bigbro89@yandex.ru
