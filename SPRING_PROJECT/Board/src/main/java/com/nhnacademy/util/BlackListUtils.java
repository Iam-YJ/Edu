package com.nhnacademy.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BlackListUtils {
    public static List<String> toList(String blacklist){
        return Arrays.stream(blacklist.split("\n"))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}
