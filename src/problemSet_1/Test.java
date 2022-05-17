package problemSet_1;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Test {
    public static void main(String[] arg) {

        MessageDigest md5Algo = null;

        try{
            md5Algo = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalArgumentException(ex);
        }


        byte[] bytes = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] md5Bytes = md5Algo.digest(bytes);

        StringBuffer sb = new StringBuffer();
        for (byte b : md5Bytes) {
            String str = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            sb.append(str);
        }

        String subString43bits = new String(sb).substring(0, 43);
        long decimalConversion = binaryDecimalConversion(subString43bits);
        String baseConversion = baseXDecimalConversion(decimalConversion, 62);

        System.out.println(baseConversion);
        System.out.println(baseConversion.length());



        System.out.println(Base64.getEncoder().encodeToString(bytes));
    }

    private static long binaryDecimalConversion(String input) {
        long sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum = sum + (input.charAt(i) - 48) * (long) Math.pow(2, input.length()-i-1);
        }

        System.out.println("SUM: " + sum);
        return sum;
    }

    private static String baseXDecimalConversion(long input, int base) {
        List<String> list = new ArrayList<>();

        while (input > 0) {
            Long remainder = (input % base);
            list.add(remainder.toString());
            input = input/base;
        }

        System.out.println(list.size());
        System.out.println(list);
        StringBuffer sb = new StringBuffer();
        for (int i = list.size()-1; i >= 0; i--) {
            // TODO: Map string to base62 codes
            sb.append(list.get(i));
        }

        return new String(sb);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
