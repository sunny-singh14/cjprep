package UrlSortner;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashBasedKeyGenerator {

    public static String generateKey(String url) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(url.getBytes(StandardCharsets.UTF_8));

            // Convert first 6 bytes to a readable Base62 key
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                key.append(String.format("%02x",hash[i]));
            }

            return key.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash algorithm not available.", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateKey("https://example.com/some-other?page=withparma&some=longparam,like,this"));
        System.out.println(generateKey("https://example.com/some-other?page=withparma&some=longparam,like,this,one"));
        System.out.println(generateKey("https://example.com/some-another?page=withparma&some=longparam,like,this"));
    }
}
