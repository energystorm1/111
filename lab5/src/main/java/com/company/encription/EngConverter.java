package com.company.encription;
/**
 * Одна из реализаций интерфейса Converter.
 * Имеет функционал для формирования из строки английских символов массив чисел с их порядковыми номерами в английском алфавите со сдвигом -1(первый символ 0).
 * Также выполняет обратную операцию.
 * @author Андрей Нагорный
 * @see com.company.encription.Converter
 */
public class EngConverter implements Converter {
    @Override
    /**
     * Формирует массив числел из строки, путем ее перевода в ASCII char, а затем сдвигом числа к значениям порядковых номеров букв в английском алфавите(от 0 до 25).
     * @param message строковое представление сообщения, которое нужно перевести в числа.
     * @return массив чисел с порядковыми номерами русских букв, полученный из message.
     */
    public Integer[] lettersToNumbers(String message) {
        Integer[] numbers = new Integer[message.length()];
        int index = 0;
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            if (ch == ' ')
                numbers[index++] = null;
            else
                numbers[index++] = (int) ch - 'a';
        }
        return numbers;
    }
    /**
     * Формирует строку с русскими символами из массива чисел с их порядковыми номерами в английском алфавите(порядковый номер первого символа - 0).
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
                int numASII = number + (int) 'a';
                stringBuilder.append(Character.toLowerCase((char) (numASII)));
            }
        }
        String message = stringBuilder.toString();
        return message;
    }
}
