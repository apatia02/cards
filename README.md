# cards
Программа выполнена на IntelliJ IDEA, клонируем репозиторий, открываем проект в IntelliJ IDEA, и следуем инструкциям программы.
***
В программе существует три сущности: Карты, Колоды, Альбомы.
***
Карты располагаются в колодах, колоды располагаются в альбосах.
***
Атрибуты для сущности карточка: название, герой или монстр(булево или перечисление), сила атаки, сила защиты, очки здоровья, название колоды.
Методы для сущности карточка:
1. Добавить карточку(проверка уникальности названия)
2. Изменить карточку(только атрибуты, кроме названия колоды)
3. Удалить карточку
4. Вывести список карточек с возможностью сортировки по численному признаку(атака, защита, очки здоровья) или типу карточки(герой или монстр). Перед выводом списка задаётся вопрос по какому признаку сортировать и направление сортировки (возрастание/убывание).
***
Атрибуты для сущности колода:
1. Название колоды
2. Количество карточек
3. Название альбома, к которому принадлежит колода
Методы для сущности колода: "заказчик" не уточнил какие конкретно методы ему нужны для колоды, но он хотел бы добавлять колоды, изменять имеющиеся колоды, добавлять(проверка уникальности имени) или переносить карточки между колодами, причем таким образом, чтобы при переносе карточки из одной колоды в другую, в записи этой карточки автоматически изменялась информация о колоде. Также он хотел бы переносить колоды из альбома в альбом(см. выделенный жирным текст чуть ниже). Ну, и удалять колоду целиком, с удалением всех содержащихся в ней карточек. На-сов-сем. 
***
Атрибуты для сущности альбом:
1. Название альбома
2. Год выпуска альбома
3. Порядковый номер выхода альбома
4. Количество колод в альбоме
5. Количество карточек в альбоме
Методы для сущности альбом:
1. Добавить альбом
2. Изменить альбом (только атрибуты)
3. Удалить альбом (вместе с колодами и картами)
4. Удалить альбом (только сам альбом, колоды и карточки нужно перенести в предыдущий по порядковому номеру, альбом).
