package com.cj.core.utils;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * AES加密算法util
 */
public class AESUtils {

    private static final String EncryptAlg ="AES";
    private static final String Cipher_Mode="AES/ECB/PKCS7Padding";
    private static final String Encode="UTF-8";
    private static final int Secret_Key_Size=32;
    private static final String Key_Encode="UTF-8";

    /**
     * AES/ECB/PKCS7Padding 加密
     * @param content
     * @param key 密钥
     * @return aes加密后 转base64
     * @throws Exception
     */
    public static String aesPKCS7PaddingEncrypt(String content, String key) throws Exception {
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

            Cipher cipher = Cipher.getInstance(Cipher_Mode);
            byte[] realKey=getSecretKey(key);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(realKey,EncryptAlg));
            byte[] data=cipher.doFinal(content.getBytes(Encode));
            String result=new Base64().encodeToString(data);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("AES加密失败：content=" +content +" key="+key);
        }
    }

    /**
     * AES/ECB/PKCS7Padding 解密
     * @param content
     * @param key 密钥
     * @return 先转base64 再解密
     * @throws Exception
     */
    public static String aesPKCS7PaddingDecrypt(String content, String key) throws Exception {
        try {
            //Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

            byte[] decodeBytes=Base64.decodeBase64(content);

            Cipher cipher = Cipher.getInstance(Cipher_Mode);
            byte[] realKey=getSecretKey(key);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(realKey,EncryptAlg));
            byte[] realBytes=cipher.doFinal(decodeBytes);

            return new String(realBytes, Encode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("AES解密失败：Aescontent = " +e.fillInStackTrace(),e);
        }
    }

    /**
     * 对密钥key进行处理：如密钥长度不够位数的则 以指定paddingChar 进行填充；
     * 此处用空格字符填充，也可以 0 填充，具体可根据实际项目需求做变更
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] getSecretKey(String key) throws Exception{
        final byte paddingChar=' ';

        byte[] realKey = new byte[Secret_Key_Size];
        byte[] byteKey = key.getBytes(Key_Encode);
        for (int i =0;i<realKey.length;i++){
            if (i<byteKey.length){
                realKey[i] = byteKey[i];
            }else {
                realKey[i] = paddingChar;
            }
        }

        return realKey;
    }
}