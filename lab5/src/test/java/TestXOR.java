import com.company.encription.RusConverter;
import com.company.encription.XOREncryption;
import junit.framework.TestCase;
import org.junit.Assert;

public class TestXOR extends TestCase {
    private final String toEncrypt = "Привет мир";
    private final int key = 10;
    private final String strkey = "ключ";
    private final XOREncryption xorEncryption = new XOREncryption(new RusConverter());

    public void testIntEncrypt(){
        String expected = "еъвипш жвъ";
        String encrypted = xorEncryption.encrypt(key,toEncrypt);
        assertEquals(expected,encrypted);
    }
    public void testStrEncrypt(){
        String expected = "еыцхпщ тяъ";
        String encrypted = xorEncryption.encrypt(strkey,toEncrypt);
        assertEquals(expected,encrypted);
    }
}
