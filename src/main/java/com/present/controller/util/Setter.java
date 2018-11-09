package com.present.controller.util;

import java.lang.annotation.*;

/**
 * The purpose of this annotation is access modifying.
 * It allows to annotate the methods which further allowed to set the fields values
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Setter {
}
