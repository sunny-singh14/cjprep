package org.example.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Repeatable(Commands.class)
public @interface Command {
    String value();

    int order() default 0;

    String description() default "";
}
