package com.shubham.prep.strings;

public class AppdynamicsBinaryStringFlip {
    private int solve(String str) {
        int res = 1;
        if(str.charAt(0) == '0') {
            res = 0;
        }
        boolean flipMode = (str.charAt(0) == '1');
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == (flipMode ? '0' : '1')) {
                while(i < str.length() && str.charAt(i) == (flipMode ? '0' : '1')) {
                    i++;
                }
                res++;
                flipMode = !flipMode;
                i--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        AppdynamicsBinaryStringFlip flip = new AppdynamicsBinaryStringFlip();
        System.out.println(flip.solve("11000"));
    }
}
