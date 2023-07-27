<h1 align="center">Задачи</h1>

## 7. Задачи

1. Разгледайте и се опитайте да разберете как работят двата метода append и insertAfter в класа DLL
2. Напишете програма, която чете думи от текстов файл и показва всички думи (разрешени дубликати) във възходящ азбучен ред.
3. Напишете програма, която позволява на потребителя да въвежда числа от GUI и да ги показва в TextArea, както е показано на фигурата. Използвайте свързан списък, за да съхранявате числата. Не съхранявайте дублирани номера. Добавете бутоните Sort, Shuffle и Reverse за да сортирате, разбърквате и обръщате списъка.

![yRNVVaB9ujBYBC1-PfNmUyOLcoggIFDxYwf6CaIb3JJJRaEoQbdSZ2pD0PDv7T4UWNgXZ85ZX6cFD98nki7-tZzmS-WqR6ePEWFX_53eBG8gl74m4IkSeQePlEksJLr8BGQ7CdLSULMqQGQ7zxqmiA](https://github.com/rayagrigorova/tasks-data-structures/assets/72023155/db24f11f-fe05-422d-9b0c-53eebabd6233)

4. Примерът в тази папка създава и показа множество подскачащи топки. Разширете примера като добавите засичане на сблъсъци. След като две топки се сблъскат, отстранете по-късно добавената към панела топка, и добавете радиуса й към другата топка, както е показано на фигурата. Добавете mouse listener, който премахва дадена топка, когато мишката щракне върху нея.
- По желание добавете произволна начална посока на топчетата, различна от default-ната в момента

![dfgdf](https://github.com/rayagrigorova/tasks-data-structures/assets/72023155/cce39cd0-f885-4ffa-9208-4d33f6c52535)

5. Напишете тестова програма, която съхранява 5 милиона цели числа в свързан списък и тествайте времето за обхождане на списъка с помощта на итератор спрямо метода get (index).

## 8. Задачи

1. Към задачата за оценяване на изрази добавете опция за четене на знак ^  за повдигане на степен
2. Програмите написани на Java съдържат различни двойки символи за групиране, като например:
Кръгли скоби: (и)
Къдрави скоби: {и}
Квадратни скоби: [и] { [ ]  
Имайте предвид, че символите за групиране не могат да се застъпват. Тоест (a {b)} не е позволено. Напишете програма, за да проверите дали файл код на Java има правилни двойки символи за групиране.
3. Променете MultipleBallApp.java, задавайки произволен радиус между 2 и 20, когато се създава топка. Когато се натисне бутона -1, една от най-големите топки се премахва. (Съвет: Използвайте PriorityQueuet, за да съхранявате топките.)
4. Създайте две приоритетни опашки, { "George" , "Jim" , "John" , "Blake" , "Kevin" , "Michael" } и { "George" , "Katie" , "Kevin" , "Michelle" , "Ryan" } и намерете техните
обединение, разлика и пресичане.

![g-aGX9em_45y5h42P445vMkla_fVjvEQuiU3naPTpSjlFpNTtpqrhoJmy3IGfsEAEmIjFh36acX_s6jazjEpE2GgX5XkMB6zNFxwPGiPGNq6fA_ecy0ryyeayrj56DdNCOXazYlFxXSXzRx_mMN0iA](https://github.com/rayagrigorova/tasks-data-structures/assets/72023155/7c4e6ccc-7089-4f43-8d1c-8cad5f9c5f30)

5. Postfix нотацията (Обратен полски запис) е начин за писане на изрази без използване на скоби. Например изразът (1 + 2) * 3 ще бъде записан като 1 2 + 3 *. Изразът за постфикс се оценява с помощта на стек. Постфиксният израз се чете отляво надясно. Числата се трупат в стека. Когато се срещне оператор, той се прилага на горните два операнда (числа) в стека, а резултата се поставя в стека. Следващата диаграма показва как се оценява 1 2 + 3 *.

![VdgmbrNDSeILBtIfeQrSIwR1966psbb-U-SqELJSnqDIOUER-OpE67oG9ruquDCPAUqV5AfWwXBGsAP5K_o342us_cZ8KfLso5CTbUQopbOt547IQ7QLqd2aAVlKXfMqVcbwQQY65US1efdPeUroYg](https://github.com/rayagrigorova/tasks-data-structures/assets/72023155/04d6f5e6-fef7-4eee-aa6b-0c8fc5219792)

Напишете програма за оценка на postfix изрази.

6. **ПО ЖЕЛАНИЕ** Напишете метод, който преобразува инфиксен израз в postfix (обратен полски запис) израз. Например методът трябва да преобразува инфиксния израз (1 + 2) * 3 в 1 2 + 3 * и 2 * (1 + 3) в 2 1 3 + *.

```java
public static String infixToPostfix(String expression)
```

**Задачите са от Модул 2 - Алгоритми и структури от данни, Тема 3 - Lists, Stacks and Queues.**

7. **ПО ЖЕЛАНИЕ** Създайте програма, която проверява дали за дадени четири числа от 1 до 13 съществува математически израз, чийто резултат е 24. Ако съществува, изведете израза. Имате право да използвате скоби, +, -, / и * при създаване на израза. Четирите числа могат да заемат всяка стойност между 1 и 13 незвисимо от другите три ( може да има повторение на стойностите )



