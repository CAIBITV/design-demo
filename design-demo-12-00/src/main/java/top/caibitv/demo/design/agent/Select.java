package top.caibitv.demo.design.agent;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {

    String value() default "";
}
