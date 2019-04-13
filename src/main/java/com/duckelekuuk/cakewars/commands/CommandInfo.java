package com.duckelekuuk.cakewars.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandInfo {

    String description() default "";
    String usage() default "";
    String[] aliases();
    boolean op() default false;
    boolean player_only() default false;
}
