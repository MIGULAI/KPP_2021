package com.company.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String ad = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432,"
                + "54 Holy Grail Street Niagara Town ZP 32908,3200 Main Rd. Bern AE 56210,1 Gordon St. Atlanta RE 13000,"
                + "10 Pussy Cat Rd. Chicago EX 34342,10 Gordon St. Atlanta RE 13000,58 Gordon Road Atlanta RE 13000,"
                + "22 Tokyo Av. Tedmondville SW 43098,674 Paris bd. Abbeville AA 45521,10 Surta Alley Goodtown GG 30654,"
                + "45 Holy Grail Al. Niagara Town ZP 32908,320 Main Al. Bern AE 56210,14 Gordon Park Atlanta RE 13000,"
                + "100 Pussy Cat Rd. Chicago EX 34342,2 Gordon St. Atlanta RE 13000,5 Gordon Road Atlanta RE 13000,"
                + "2200 Tokyo Av. Tedmondville SW 43098,67 Paris St. Abbeville AA 45521,11 Surta Avenue Goodtown GG 30654,"
                + "45 Holy Grail Al. Niagara Town ZP 32918,320 Main Al. Bern AE 56215,14 Gordon Park Atlanta RE 13200,"
                + "100 Pussy Cat Rd. Chicago EX 34345,2 Gordon St. Atlanta RE 13222,5 Gordon Road Atlanta RE 13001,"
                + "2200 Tokyo Av. Tedmondville SW 43198,67 Paris St. Abbeville AA 45522,11 Surta Avenue Goodville GG 30655,"
                + "2222 Tokyo Av. Tedmondville SW 43198,670 Paris St. Abbeville AA 45522,114 Surta Avenue Goodville GG 30655,"
                + "2 Holy Grail Street Niagara Town ZP 32908,3 Main Rd. Bern AE 56210,77 Gordon St. Atlanta RE 13000";

        String code = "OH 43071,NY 56432,ZP 32908,AE 56210,RE 13000,EX 34342,SW 43098,AA 45521,GG 30654,ZP 32908,AE 56215,RE 13200,EX 34345,"
                + "RE 13222,RE 13001,SW 43198,AA 45522,GG 30655,XX 32321,YY 45098";

        System.out.println("Fixed Tests: travel");
        String v = Travel.travel(ad, "AA 45522");
        System.out.println(Travel.travel(ad, "AA 45522"));

    }
}

class Travel {
    public static String travel(String r, String zipcode) {
        String[] subStr = r.split(",");
        String[] rSubStr = subStr.clone();
        System.out.println(rSubStr[4]);
        String[] list = new String[subStr.length];
        String[] numbers = new String[subStr.length];
        Pattern pattern = Pattern.compile("\\d{1,}+\\s+\\D{1,}");
        Matcher matcher = pattern.matcher(r);
        int checker = 0;
        while (matcher.find()){
            list[checker] = matcher.group();
            checker++;
        }

        for(int i = 0; i < rSubStr.length;i++){
            list[i] = new StringBuilder(list[i]).reverse().toString();
            list[i] = list[i].substring(4);
            list[i] = new StringBuilder(list[i]).reverse().toString();
            rSubStr[i] = rSubStr[i].substring( rSubStr[i].length() - 8);
        }
        for(int i = 0; i < list.length;i++){
            Pattern pattern1 = Pattern.compile("\\d{1,}");
            Matcher matcher1 = pattern1.matcher(list[i]);
            while (matcher1.find()){
                numbers[i] = matcher1.group();
            }
            list[i] = list[i].replace(numbers[i]+ " ","");

        }

        String returning = zipcode + ":";
        String subcode = "/";
        int point = 0;
        for(int i = 0; i < rSubStr.length;i++){
            if(rSubStr[i].equals(zipcode)){
                if(point == 0){
                    returning += list[i];
                    subcode += numbers[i];
                    point++;
                }
                else{
                    returning = returning + "," + list[i];
                    subcode = subcode + "," + numbers[i];
                    point++;
                }

            }
        }

        return returning + subcode;
    }


}