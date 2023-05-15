package com.company.encription;
/**
 *Одна из реализаций интерфейса Encryption. Позволяет шифровать и дешифровать сообщения методом Цезаря.
 * @author Андрей Нагорный
 * @see com.company.encription.Encryption
 */
public class CesarEncryption implements Encryption {
    /**
     * Конвертер нужен для перевода строк в числа для произведения над ними операции инкрементации и декрементации.
     * @see Converter
     */
    private Converter converter;

    public CesarEncryption(Converter converter) {
        this.converter = converter;
    }
    /**
     * Шифрует сообщение методом Цезаря с помощью числового ключа. К порядковому номеру каждого символа сообщения в алфавите
     * прибавляется значение ключа шифрования.
     * @param key числовой ключ, по которому происходит шифрование.
     * @param message сообщение, которое нужно зашифровать.
     * @return зашифрованное методом Цезаря сообщение.
     */
    @Override
    public String encrypt(int key, String message) {
        Integer[] numbers = converter.lettersToNumbers(message);
        Integer[] newNumbers = new Integer[numbers.length];
        int index = 0;
        for (Integer number : numbers) {
            if (number == null)
                newNumbers[index++] = null;
            else {
                int res = number + key;
                if (res > 32 || res < 0) {
                    res %= 32;
                }
                newNumbers[index++] = res;
            }
        }
        String result = converter.numbersToLetters(newNumbers);
        return result;
    }

    /**
     * Шифрует сообщение методом Цезаря с помощью строкового ключа. К порядковому номеру каждого символа сообщения в алфавите,
     * прибавляется порядковый номер каждого символа ключа в алфавите. Если ключ короче сообщения,
     * то ключ обрабатывается циклически.
     * @param key строковый ключ, по которому происходит шифрование.
     * @param message сообщение, которое нужно зашифровать.
     * @return зашифрованное методом Цезаря сообщение.
     */
    @Override
    public String encrypt(String key, String message) {
        Integer[] numbers = converter.lettersToNumbers(message);
        Integer[] newNumbers = new Integer[numbers.length];
        Integer[] numbersKey = converter.lettersToNumbers(key);

        int index = 0;
        int keyIndex = 0;
        for (Integer number : numbers) {
            if (number == null)
                newNumbers[index++] = null;
            else {
                int res = number + numbersKey[keyIndex++];
                if (res > 32 || res < 0) {
                    res %= 32;
                }
                newNumbers[index++] = res;
            }
            keyIndex = keyIndex >= numbersKey.length ? 0 : keyIndex;
        }
        String result = converter.numbersToLetters(newNumbers);
        return result;
    }

    /**
     * Дешифрует сообщение методом Цезаря с помощью числового ключа. От порядкового номера каждого символа сообщения
     * в алфавите, отнимается значение ключа.
     * @param key числовой ключ, по которому происходит шифрование.
     * @param message сообщение, которое нужно зашифровать.
     * @return расшифрованное сообщение методом цезаря.
     */
    @Override
    public String deEncrypt(int key, String message) {
        Integer[] numbers = converter.lettersToNumbers(message);
        Integer[] newNumbers = new Integer[numbers.length];
        int index = 0;
        for (Integer number : numbers) {
            if (number == null)
                newNumbers[index++] = null;
            else {
                int res = number - key;
                if (res > 32 || res < 0) {
                    res %= 32;
                }
                newNumbers[index++] = res;
            }
        }
        String result = converter.numbersToLetters(newNumbers);
        return result;
    }

    /**
     * Дешифрует сообщение методом Цезаря с помощью строкового ключа. От порядкового номера каждого символа
     * сообщения в алфавите, отнимается порядковый номер каждого символа ключа в алфавите. Если ключ короче сообщения,
     * то ключ обрабатывается циклически.
     * @param key строковый ключ, по которому происходит шифрование.
     * @param message сообщение, которое нужно зашифровать.
     * @return расшифрованное сообщение методом цезаря.
     */
    @Override
    public String deEncrypt(String key, String message)  {
        Integer[] numbers = converter.lettersToNumbers(message);
        Integer[] newNumbers = new Integer[numbers.length];
        Integer[] numbersKey = converter.lettersToNumbers(key);

        int index = 0;
        int keyIndex = 0;
        for (Integer number : numbers) {
            if (number == null)
                newNumbers[index++] = null;
            else {
                int res = number - numbersKey[keyIndex++];
                if (res > 32 || res < 0) {
                    res %= 32;
                }
                newNumbers[index++] = res;
            }
            keyIndex = keyIndex >= numbersKey.length ? 0 : keyIndex;
        }
        String result = converter.numbersToLetters(newNumbers);
        return result;
    }
    @Override
    public void setConverter(Converter converter) {
        this.converter = converter;
    }
}
