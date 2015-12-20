UPDATE course SET description='Даний курс вивчає мінімалістичний підхід до дизайну об"єктів, який підкреслює зручність використання, більшою мірою орієнтований на кінцевого користувача. Курс буде цікавий студентам, які хотіли б оволодіти мистецтвом розробки веб-ресурсів згідно нових тенденцій дизайну' WHERE id=1;
UPDATE course SET description='Будуть розглянуті сучасні можливості каскадних таблиць стилів і їхню підтримку востанніх популярних браузерах' WHERE id=2;
UPDATE course SET description='Даний курс складається з п"яти модулів та екзаменаційного завдання. Кожен модуль містить посилання на матеріали відеохарактеру та допоміжну інформацію. Курс буде цікавий студентам, які хотіли б оволодіти мистецтвом розробки веб-ресурсів згідно нових тенденцій дизайну' WHERE id=3;
UPDATE course SET description='Даний курс орієнтований на вивчення Java як людьми з мінімальним рівнем знання програмування так і людей, які хочуть покращити свої знання з певних нюансів мови.' WHERE id=4;
UPDATE course SET description='У Вас буде можливість вивчити технології та підходи до розробки Web-програм з багаторівневою архітектурою. Ви отримаєте досвід побудови Web-програм засобами ASP.NET MVC, Silverlight, побудови десктопних програм засобами WPF, реалізацію ORM засобами ADO.NET Entity, а також розробки Web-сервісів з допомогою WСF.' WHERE id=5;
UPDATE course SET description='Програма навчання сформована відповідно до вимог провідних ІТ компаній, що підтверджує Львівський Кластер ІТ-BPO. Це можливість всім починаючим дизайнерам та архітекторам з головою поринути в світ найперспективнішої сфери – дизайну в ІТ. Ринок потребує нових спеціалістів і Lviv UI/UX School ставить собі за мету підготувати справжніх професіоналів дизайну.' WHERE id=6;

UPDATE module SET description='\"Теги\"? Теги це мітки, які ви використовуєте для вказівки браузеру, як він повинен показувати ваш web-сайт. Всі теги мають однаковий формат: вони починаються знаком \"&lt;\" і закінчуються знаком sign \"&gt;\". Зазвичай є два теги - відкриваючий: &lt;html&gt; і закриваючий: &lt;/html&gt;. Різниця в тому, що в закриваючому є слеш \"/\". Весь вміст, що вміщено між відкриваючими і закриваючими тегами, є вмістом тега. Але, як то кажуть, в кожному правилі є винятки, і в HTML також є теги, які є і відкривають, і закривають. Ці теги не містять тексту, а є мітками, наприклад, перенесення рядка виглядає так: &lt;br />. HTML - це теги, і нічого крім тегів. Для вивчення HTML потрібно вивчити різні теги. Наприклад, тег &lt;b&gt; інформує браузер, що весь текст між &lt;b&gt; і &lt;/b&gt; повинен бути надрукований жирним шрифтом. (\"b\" це скорочення від \"bold\".) ' WHERE id=1;
UPDATE module SET description='Форма в мережі є будь-якою областю на сторінці Web, де можна ввести інформацію, наприклад, введення тексту або чисел у текстовому полі, постановка прапорця, встановлення радіо-кнопки або вибір варіанта зі списку. Потім форма, після натискання на кнопку відправки, надсилається на Web-сайт. Використання форм в Web зустрічається повсюдно: для введення імен користувачів і паролів на екрані реєстрації, коментарі в блозі, заповнення профілю на сайті соціальної мережі або повідомлення інформації для рахунку на сайті магазина. Створити форму легко, але як щодо відповідності форми стандартам Web? До даного моменту, якщо ви пропрацювали навчальний курс за стандартами Web, будемо сподіватися, що ви вже переконалися, що стандарти Web є способом руху вперед. Код, який необхідно створити для доступної форми відповідно до стандартів, вимагає не більше роботи для реалізації, ніж неохайна форма.Тому, давайте почнемо з самої основної та простої форми, яку хтось, можливо, захоче використати, і після цього потроху будемо її ускладнювати – у цій лекції будуть розглянуті всі основні елементи, які необхідно знати для створення елегантної, доступної форми з допомогою HTML. ' WHERE id=2;
UPDATE module SET description='Як використовувати стандарти Web для організації безлічі даних? Сама ідея множини вкладених елементів, необхідних для перетворення всіх даних в симпатичні рядки та клітинки, повинна привести мозок у стан тривоги, але на щастя рішення є – на допомогу приходять таблиці! <br /> У Web-дизайні таблиці є хорошим способом організації даних в табличній формі. Іншими словами, завдяки таблицям, діаграмам та іншій графічній інформації, яка допомагає побачити і перетворити великий обсяг інформації в зведення, яке дозволяє порівнювати і зіставляти різні фрагменти даних. Ви зустрічаєте їх постійно на Web-сайтах, де вони представляють підсумки порівняння результатів політичних виборів, спортивної статистики, порівняння цін, таблиці розмірів, або інші дані. <br /> Раніше, в доісторичні часи Інтернет, перш ніж CSS став популярний як засіб поділу подання та структури HTML, таблиці використовувалися як засіб компонування Web-сторінок – для створення стовпців, боксів і загальної організації контенту. Це неправильний спосіб вирішення цих питань; використання таблиць для компонування призводить до громіздких, безладних сторінок з безліччю вкладених одна в одну таблиць – тобто великі розміри файлів, труднощі з обслуговуванням, труднощі з модифікацією після створення. Можна до цього часу бачити в Web такі сайти, але сьогодні необхідно використовувати таблиці тільки для того,для чого вони призначені – табличних даних – і використовувати CSS для управління компоновкою.<br /> Тут ми розглянемо, як правильно використовувати таблиці HTML – стаття має наступну структуру: <ul><li>Найбільша загальна таблиця</li><li>Додавання деяких властивостей</li><li>Додаткова структуризація таблиці</li><li>Допомога CSS: поліпшення вигляду таблиці</li></ul>) ' WHERE id=3;
UPDATE module SET description='header - тег представляє собою набір початкових даних і певної навігації. В ньому розміщюють логотипи, заголовки, посилання на сайт, а інколи і меню навігації по сайту. Тобто цей елемент - це \"шапка\" веб-сторінки. article - тег який тепер буде дуже поширений=) Він відповідає статті, запису в блозі, замітці, новині. Все що відноситься, н-д, до вашої статті на сайті повинне бути включене в цей тег(тобто це і заголовок статті, дата, сам контент, а також коментарі). Щодо коментарів, то вони також окремі, але вкладені в основний. footer - назва говорить сама за себе, це нижня частина сайту, де зазвичай розміщюють авторські права, додаткову інформацію, лічильники. nav - тег виділяє панель навігації по сайту, меню.  На сторінці може бути декілька таких елементів. section - з допомогою нього можна розділяти веб-сторінку на певні тематичні розділи або розділіти статтю на розділи. Як правило має власний заголовок. Тег aside використовується для контенту, який повинен розміщуватись окремо від основного. Це може бути бокова панель, частина сторінки перед footer абощо. В тезі можна розміщувати меню, рекламу та інший додатковий контент.' WHERE id=4;
UPDATE module SET description='Основным инструментом работы и динамических изменений на странице является DOM (Document Object Model) — объектная модель, используемая для XML/HTML-документов.<br />Согласно DOM-модели, документ является иерархией, деревом. Каждый HTML-тег образует узел дерева с типом «элемент». Вложенные в него теги становятся дочерними узлами. Для представления текста создаются узлы с типом «текст».<br />DOM — это представление документа в виде дерева объектов, доступное для изменения через JavaScript.' WHERE id=5;
UPDATE module SET description='На екзамен виносяться вузлові теоретичні питання, розрахункові задачі, проблемні ситуації, професійні завдання, що потребують творчої відповіді та вміння синтезувати набуті знання і використовувати їх для вирішення практичних задач тощо.' WHERE id=6;
UPDATE module SET description='\"Теги\"? Теги це мітки, які ви використовуєте для вказівки браузеру, як він повинен показувати ваш web-сайт. Всі теги мають однаковий формат: вони починаються знаком \"&lt;\" і закінчуються знаком sign \"&gt;\". Зазвичай є два теги - відкриваючий: &lt;html&gt; і закриваючий: &lt;/html&gt;. Різниця в тому, що в закриваючому є слеш \"/\". Весь вміст, що вміщено між відкриваючими і закриваючими тегами, є вмістом тега. Але, як то кажуть, в кожному правилі є винятки, і в HTML також є теги, які є і відкривають, і закривають. Ці теги не містять тексту, а є мітками, наприклад, перенесення рядка виглядає так: &lt;br />. HTML - це теги, і нічого крім тегів. Для вивчення HTML потрібно вивчити різні теги. Наприклад, тег &lt;b&gt; інформує браузер, що весь текст між &lt;b&gt; і &lt;/b&gt; повинен бути надрукований жирним шрифтом. (\"b\" це скорочення від \"bold\".) ' WHERE id=7;
UPDATE module SET description='\"Теги\"? Теги це мітки, які ви використовуєте для вказівки браузеру, як він повинен показувати ваш web-сайт. Всі теги мають однаковий формат: вони починаються знаком \"&lt;\" і закінчуються знаком sign \"&gt;\". Зазвичай є два теги - відкриваючий: &lt;html&gt; і закриваючий: &lt;/html&gt;. Різниця в тому, що в закриваючому є слеш \"/\". Весь вміст, що вміщено між відкриваючими і закриваючими тегами, є вмістом тега. Але, як то кажуть, в кожному правилі є винятки, і в HTML також є теги, які є і відкривають, і закривають. Ці теги не містять тексту, а є мітками, наприклад, перенесення рядка виглядає так: &lt;br />. HTML - це теги, і нічого крім тегів. Для вивчення HTML потрібно вивчити різні теги. Наприклад, тег &lt;b&gt; інформує браузер, що весь текст між &lt;b&gt; і &lt;/b&gt; повинен бути надрукований жирним шрифтом. (\"b\" це скорочення від \"bold\".) ' WHERE id=8;
UPDATE module SET description='\"Теги\"? Теги це мітки, які ви використовуєте для вказівки браузеру, як він повинен показувати ваш web-сайт. Всі теги мають однаковий формат: вони починаються знаком \"&lt;\" і закінчуються знаком sign \"&gt;\". Зазвичай є два теги - відкриваючий: &lt;html&gt; і закриваючий: &lt;/html&gt;. Різниця в тому, що в закриваючому є слеш \"/\". Весь вміст, що вміщено між відкриваючими і закриваючими тегами, є вмістом тега. Але, як то кажуть, в кожному правилі є винятки, і в HTML також є теги, які є і відкривають, і закривають. Ці теги не містять тексту, а є мітками, наприклад, перенесення рядка виглядає так: &lt;br />. HTML - це теги, і нічого крім тегів. Для вивчення HTML потрібно вивчити різні теги. Наприклад, тег &lt;b&gt; інформує браузер, що весь текст між &lt;b&gt; і &lt;/b&gt; повинен бути надрукований жирним шрифтом. (\"b\" це скорочення від \"bold\".) ' WHERE id=9;