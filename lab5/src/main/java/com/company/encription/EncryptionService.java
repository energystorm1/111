package com.company.encription;

/**
 * Класс, которой нужен для взаимодействия с кодерами. Он позволяет использовать разные кодеры не прибегая к детализации.
 * Все конструкторы кроме первого являются опциональными, в которых производится лишь перестановка параметров.
 * @see Encryption
 * @author Андрей Нагорный
 */
public class EncryptionService {
    /**
     * Кодировщик, который будет использоваться при шифровке и дешифровке сообщений.
     */
    private Encryption encryption;
    /**
     * Числовой ключ, который будет использоваться при шифровке и дешифровке сообщений.
     */
    private Integer numKey;
    /**
     * Строковой ключ, который будет использоваться при шифровке и дешифровке сообщений.
     */
    private String strKey;

    /**
     * Конструктор в котором задаются кодировщик и конвертор. Два этих поля нужно задать обязательно.
     * @param encryption кодировщик с помощью которого будут шифроваться сообщения.
     * @param converter конвертор который будет переводить сообщения в числа.
     * @see Encryption
     * @see Converter
     */
    public EncryptionService(Encryption encryption,Converter converter) {
        this.encryption = encryption;
        this.encryption.setConverter(converter);
    }

    public EncryptionService(Encryption encryption,Converter converter, Integer numKey, String strKey) {
        this.encryption = encryption;
        this.encryption.setConverter(converter);
        this.numKey = numKey;
        this.strKey = strKey;
    }

    public EncryptionService(Encryption encryption,Converter converter, Integer numKey) {
        this.encryption = encryption;
        this.encryption.setConverter(converter);
        this.numKey = numKey;
    }

    public EncryptionService(Encryption encryption,Converter converter, String strKey) {
        this.encryption = encryption;
        this.encryption.setConverter(converter);
        this.strKey = strKey;
    }

    /**
     * Функция для шифровки сообщения с числовым ключом.
     * @param message сообщение для шифровки.
     * @return зашифрованное сообщение, либо сообщение о ошибке.
     */
    public String encryptMessageWithNumKey(String message) {
        if (numKey == null) {
            return "Сначала задайте числовой ключ";
        } else return encryption.encrypt(numKey, message);
    }

    /**
     * Функция для дешифровки сообщения с числовым ключом.
     * @param message сообщение для дешифровки.
     * @return расшифрованное сообщение, либо сообщение об ошибке.
     */
    public String deEncryptMessageWithNumKey(String message) {
        if (numKey == null) {
            return "Сначала задайте числовой ключ";
        }
        else return encryption.deEncrypt(numKey, message);
    }

    /**
     * Функция для шифровки сообщения со строковым ключом.
     * @param message сообщение для шифровки.
     * @return зашифрованное сообщение либо сообщение о ошибке.
     */
    public String encryptMessageWithStrKey(String message) {
        if (strKey == null) {
            return "Сначала задайте строковый ключ";
        } else return encryption.encrypt(strKey, message);

    }

    /**
     * Функция для дешифровки сообщения со строковым ключом.
     * @param message сообщение для дешифровки.
     * @return расшифрованное сообщение либо сообщение о ошибке.
     */
    public String deEncryptMessageWithStrKey(String message) {
        if (strKey == null) {
            return "Сначала задайте строковый ключ";
        } else return encryption.deEncrypt(strKey, message);
    }

    public int getNumKey() {
        return numKey;
    }

    public void setNumKey(int numKey) {
        this.numKey = numKey;
    }

    public String getStrKey() {
        return strKey;
    }

    public void setStrKey(String strKey) {
        this.strKey = strKey;
    }
}
