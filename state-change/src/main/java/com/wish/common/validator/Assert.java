package com.wish.common.validator;

import com.wish.common.exception.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 */
public abstract class Assert {

    public static void assertNotBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void assertNotNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }

    public static void assertTrue(boolean exists, String message) {
        if(!exists) {
            throw new RRException(message);
        }
    }
}
