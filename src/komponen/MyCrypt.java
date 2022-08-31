/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komponen;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Reed
 */
public class MyCrypt {
    public MyCrypt(){
        
    }
    public static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
        int halfbyte = (data[i] >>> 4) & 0x0F;
        int two_halfs = 0;
        do {
        if ((0 <= halfbyte) && (halfbyte <= 9))
        buf.append((char) ('0' + halfbyte));
        else
        buf.append((char) ('a' + (halfbyte - 10)));
        halfbyte = data[i] & 0x0F;
        } while(two_halfs++ < 1);
        }
        return buf.toString();
    }
    public static String MD5(String text)
        throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }
    public String CurencyFormat(String Rp){
        Double money = Double.valueOf(Rp);
        String strFormat ="#,###.00";
        DecimalFormat df = new DecimalFormat(strFormat,new DecimalFormatSymbols(Locale.GERMAN));
        return df.format(money);
    }
}
