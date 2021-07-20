package com.shubham.interviews.google;

import java.util.Map;

public class StringPrinter {
    public String format(String str, Map<String, String> values) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '%') {
                if(i >= 1 && str.charAt(i-1) == '\\') {
                    //If it is escaped, continue
                    res.append(str.charAt(i));
                } else {
                    StringBuilder variableName = new StringBuilder();
                    int j = i + 1;
                    while(j < str.length() && str.charAt(j) != '%') {
                        variableName.append(str.charAt(j));
                        j++;
                    }
                    String key = variableName.toString();
                    if(values.containsKey(key)) {
                        res.append(values.get(key));
                    }
                    i = j;
                }
            } else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        StringPrinter printer = new StringPrinter();
        System.out.println(printer.format("Hi I am %name% and my roll number is %roll%",
                Map.of("name", "Ram", "roll", "123")));
    }
}
