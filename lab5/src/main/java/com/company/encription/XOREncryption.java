package com.company.encription;

/**
 *Одна из реализаций интерфейса Encryption. Позволяет шифровать и дешифровать сообщения методом XOR.
 * @author Андрей Нагорный
 * @see com.company.encription.Encryption
 */
public class XOREncryption implements Encryption {
    /**
     * Конвертер нужен для перевода строк в числа для произведения над ними операции XOR.
     * @see Converter
     */
    private Converter converter;

    public XOREncryption(Converter converter) {
        this.converter = converter;
    }

    /**
     * Шифрует сообщение методом XOR с помощью числового ключа. Над каждым символом сообщения производится операция XOR
     * с ключом шифрования.
     * @param key  числовой ключ, по которому происходит шифрование.
     * @param message сообщение, которое нужно зашифровать.
     * @return зашифрованное методом XOR сообщение.
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
                int res = number ^ key;
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
     * Шифрует сообщение методом XOR с помощью строкового ключа. Над каждым символом сообщения и символом ключа попарно
     * производится операция XOR. Если ключ короче сообщения, то ключ обрабатывается циклически.
     * @param key  строковый ключ, по которому происходит шифрование.
     * @param message  сообщение, которое нужно зашифровать.
     * @return зашифрованное методом XOR сообщение.
     */
    @Override
    public String encrypt(String key, String message) {
        Integer[] numbersMessage = converter.lettersToNumbers(message);
        Integer[] numbersKey = converter.lettersToNumbers(key);
        Integer[] newNumbers = new Integer[numbersMessage.length];
        int index = 0;
        int keyIndex = 0;
        for (Integer number : numbersMessage) {
            if (number == null)
                newNumbers[index++] = null;
            else {
                int res = number ^ numbersKey[keyIndex++];
                newNumbers[index++] = res;
            }
            keyIndex = keyIndex >= numbersKey.length ? 0 : keyIndex;
        }
        String result = converter.numbersToLetters(newNumbers);
        return result;
    }
    /**
     * Дешифрует сообщение методом XOR с помощью числового ключа. Ввиду специфики метода шифрования - шифровка и
     * дешифровка являются одной и той же операцией.
     * @param key числовой ключ, по которому происходит шифрование.
     * @param message сообщение, которое нужно зашифровать.
     * @return расшифрованное сообщение методом XOR.
     */
    @Override
    public String deEncrypt(int key, String message) {
        return encrypt(key,message);
    }
    /**
     * Дешифрует сообщение методом XOR с помощью строкового ключа. Ввиду специфики метода шифрования - шифровка и
     * дешифровка являются одной и той же операцией.
     * @param key строковый ключ, по которому происходит шифрование.
     * @param message сообщение, которое нужно зашифровать.
     * @return расшифрованное сообщение методом XOR.
     */
    @Override
    public String deEncrypt(String key, String message) {
        return encrypt(key,message);
    }
    @Override
    public void setConverter(Converter converter) {
        this.converter = converter;
    }
}
