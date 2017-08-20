package com.leolee.metadataplatform.util;

import java.util.UUID;

/**
 * Created by panxiaobai on 20/08/2017.
 */
public class StringUtils {
    public static String getRandomId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
