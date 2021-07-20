package com.shubham.prep.misc;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<String> res = new ArrayList<>();
        res.add("0");
        res.add("1");
        for(int i = 2; i < (1<<n); i = i<<1) {
            for(int j = i-1; j>= 0; j--) {
                res.add(res.get(j));
            }
            for(int j = 0; j < i; j++) {
                res.set(j, "0" + res.get(j));
            }

            for(int j = i; j < 2*i; j++) {
                res.set(j, "1" + res.get(j));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < (1<<n); i++) {
            ans.add(Integer.parseInt(res.get(i), 2));
        }
        return ans;
    }
}
