import java.util.zip.Deflater;
import java.util.zip.Inflater;
class SixBitEnDec {

    final static public int FOUR_BIT = 4;

    public static void main(String[] args){
        String test ="123456789";
        SixBitEnDec obj = new SixBitEnDec();
        byte[] enc = obj.encode(test,FOUR_BIT);
        System.out.println("Input: "+test);
        System.out.println("Current bytes length: "+test.getBytes().length+"\nAfter encode bytes length: "+enc.length);
        System.out.println("Output: "+obj.decode(enc,FOUR_BIT));
    }

    byte[] encode(String txt, int bit) {
        int length = txt.length();
        int len = (int)Math.ceil((length*bit)/8);
        len = (length%2 == 0)?len:++len;
        byte encoded[] = new byte[len];
        char str[] = new char[length];
        txt.getChars(0, length, str, 0);
        int chaVal = 0;
        String temp;
        String strBinary = new String("");
        for (int i = 0; i < length; i++) {
            temp = Integer.toBinaryString(toValue(str[i]));
            while (temp.length() % bit != 0) {
                temp = "0" + temp;
            }
            strBinary = strBinary + temp;
        }
        while (strBinary.length() % 8 != 0) {
            strBinary = strBinary + "0";
        }
        Integer tempInt = new Integer(0);
        for (int i = 0; i < strBinary.length(); i = i + 8) {
            tempInt = tempInt.valueOf(strBinary.substring(i, i + 8), 2);
            encoded[i / 8] = tempInt.byteValue();
        }
        return encoded;
    }

    String decode(byte[] encoded, int bit) {
        String strTemp = new String("");
        String strBinary = new String("");
        String strText = new String("");
        Integer tempInt = new Integer(0);
        int intTemp = 0;
        for (int i = 0; i < encoded.length; i++) {
            if (encoded[i] < 0) {
                intTemp = (int) encoded[i] + 256;
            } else
                intTemp = (int) encoded[i];
            strTemp = Integer.toBinaryString(intTemp);
            while (strTemp.length() % 8 != 0) {
                strTemp = "0" + strTemp;
            }
            strBinary = strBinary + strTemp;
        }
        for (int i = 0; i < strBinary.length(); i = i + bit) {
            tempInt = tempInt.valueOf(strBinary.substring(i, i + bit), 2);
            strText = strText + tempInt.intValue();
        }
        return strText;
    }

    int toValue(char ch) {
        int chaVal = 0;
        switch (ch) {
            case '0':chaVal = 0;break;
            case '1':chaVal = 1;break;
            case '2':chaVal = 2;break;
            case '3':chaVal = 3;break;
            case '4':chaVal = 4;break;
            case '5':chaVal = 5;break;
            case '6':chaVal = 6;break;
            case '7':chaVal = 7;break;
            case '8':chaVal = 8;break;
            case '9':chaVal = 9;break;
            default:chaVal = 0;
        }
        return chaVal;
    }

    
}