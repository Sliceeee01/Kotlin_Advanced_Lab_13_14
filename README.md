# Лабораторная работа №13-14. Коллекции, обобщения и функциональный стиль в Kotlin

## Описание

Данная лабораторная работа посвящена изучению продвинутых возможностей языка Kotlin, которые активно используются при разработке Android-приложений. В рамках работы рассматриваются:

- обобщённые типы (Generics);
- коллекции Kotlin;
- функции высшего порядка;
- extension-функции;
- scope-функции;
- интерфейсы;
- enum class;
- data class;
- singleton и companion object.

## Примеры из работы

### Generics
Создан универсальный класс Question<T>, который может работать с разными типами ответов (String, Boolean, Int).

### Enum class
Уровни сложности вопросов ограничены с помощью enum class Difficulty (EASY, MEDIUM, HARD).

### Data class
Класс Question преобразован в data class для автоматической генерации toString(), equals() и hashCode().

### Singleton и companion object
Создан класс Quiz с companion object StudentProgress для отслеживания прогресса.

### Extension-функции и свойства
Добавлены extension-функции и свойства для вывода прогресса в виде progress bar.

### Интерфейсы
Реализован интерфейс ProgressPrintable с методами progressText и printProgressBar().

### Scope-функции
Использованы функции let() и apply() для более чистого кода.

### Коллекции
Изучены Array, List, MutableList, Set, MutableSet, Map, MutableMap.

### Функции высшего порядка
Применены forEach(), map(), filter(), groupBy(), fold(), sortedBy() для работы с коллекциями.

## Как запустить проект

1. Клонируйте репозиторий:
```bash
git clone <https://github.com/Sliceeee01/Kotlin_Advanced_Lab_13_14>
