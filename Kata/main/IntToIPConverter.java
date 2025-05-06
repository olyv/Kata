
/*
Take the following IPv4 address: 128.32.10.1

This address has 4 octets where each octet is a single byte (or 8 bits).

    1st octet 128 has the binary representation: 10000000
    2nd octet 32 has the binary representation: 00100000
    3rd octet 10 has the binary representation: 00001010
    4th octet 1 has the binary representation: 00000001

So 128.32.10.1 == 10000000.00100000.00001010.00000001

Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361

Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.
Examples

2149583361 ==> "128.32.10.1"
32         ==> "0.0.0.32"
0          ==> "0.0.0.0"

 */

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IntToIPConverter {

    public static final int OCTET_LENGTH = 8;
    public static final int NUMBER_OF_OCTETS = 4;
    public static final int BINARY_BASE = 2;
    private static final int LENGTH_OF_BINARY_REPRESENTATION = OCTET_LENGTH * NUMBER_OF_OCTETS;
    public static final String DOT = ".";
    public static final long MAX_ALLOWED_UNSIGNED_DECIMAL = 4294967295L;

    public static String longToIP(long ip) {
        // Java doesn't have uint32, so here we use long to represent int32
        validateInput(ip);
        String ipAsBinary = toBinary(ip);
        return toIPv4(ipAsBinary);
    }

    private static String toIPv4(String ipAsBinary) {
        Pattern pattern = Pattern.compile("\\" + DOT);
        String[] binaryOctets = ipAsBinary.split(pattern.toString());
        return Arrays.stream(binaryOctets)
                .map(IntToIPConverter::binaryOctetToInt)
                .map(Object::toString)
                .collect(Collectors.joining(DOT));
    }

    private static int binaryOctetToInt(String binaryOctet) {
        int result = 0;
        var binaryOctetAsArray = binaryOctet.toCharArray();
        for (int i = 0; i < OCTET_LENGTH; i++) {
            if (binaryOctetAsArray[i] == '1') {
                var exponent = OCTET_LENGTH - 1 - i;
                result += (int) Math.pow(BINARY_BASE, exponent);
            }
        }
        return result;
    }

    private static String getIpStringOfRequiredLength(String ipString) {
        if (LENGTH_OF_BINARY_REPRESENTATION > ipString.length()) {
            var stringBuilder = new StringBuilder();
            var charsCount = LENGTH_OF_BINARY_REPRESENTATION - ipString.length();
            for (int i = 0; i < charsCount; i++) {
                stringBuilder.append('0');
            }
            return stringBuilder.append(ipString).toString();
        } else {
            return ipString;
        }
    }

    private static String toBinary(long ip) {
        var ipString = getIpStringOfRequiredLength(Long.toBinaryString(ip));
        var binaryStringChars = ipString.toCharArray();
        var result = new StringBuilder();
        var charCounter = 0;
        for (int i = 0; i <= binaryStringChars.length - 1; i++) {
            result.append(binaryStringChars[i]);
            charCounter++;
            if (charCounter % OCTET_LENGTH == 0 && charCounter < LENGTH_OF_BINARY_REPRESENTATION) {
                result.append(DOT);
            }
        }
        return result.toString();
    }

    private static void validateInput(long ip) {
        if (ip > MAX_ALLOWED_UNSIGNED_DECIMAL) {
            throw new IllegalArgumentException("Provided value of ip <%d> can not be converted to IPv4 address".formatted(ip));
        }
    }
}
