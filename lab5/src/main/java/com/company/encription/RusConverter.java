package com.company.encription;

/**
 * Одна из реализаций интерфейса Converter.
 * Имеет функционал для формирования из строки русских символов массив чисел с их порядковыми номерами в русском алфавите со сдвигом -1(первый символ 0).
 * Также выполняет обратную операцию.
 * @author Андрей Нагорный
 * @see com.company.encription.Converter
 */
public class RusConverter implements Converter{
    /**
     * Формирует массив чисел из строки, путем ее перевода в ASCII char, а затем сдвигом числа к значениям порядковых номеров букв в русском алфавите(от 0 до 32).
     * @param message строковое представление сообщения, которое нужно перевести в числа.
     * @return массив чисел с порядковыми номерами русских букв, полученный из message.
     */
    @Override
    public Integer[] lettersToNumbers(String message) {
        Integer[] numbers = new Integer[message.length()];
        int index = 0;
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            if (ch == ' ')
                numbers[index++] = null;
            else
                numbers[index++] = (int) ch - 'а';
        }
        return numbers;
    }

    /**
     * Формирует строку с русскими символами из массива чисел с их порядковыми номерами в русском алфавите(порядковый номер первого символа - 0).
     * @param numbers массив чисел, который нужно превратить в строку.
     * @return строковое представление массива чисел с порядковыми номерами русских символов.
     */
    @Override
    public String numbersToLetters(Integer[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            if (number == null)
                stringBuilder.append(" ");
            else {
                int numASII = number + (int) 'а';
                stringBuilder.append(Character.toLowerCase((char) (numASII)));
            }
        }
        String message = stringBuilder.toString();
        return message;
    }
}
