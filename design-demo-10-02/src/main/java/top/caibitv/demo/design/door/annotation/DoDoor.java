package top.caibitv.demo.design.door.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 切面注解定义
 *
 * @Retention(RetentionPolicy.RUNTIME) 被修饰的注解在程序运行时仍然保留，因此可以通过反射机制读取。这是三种保留策略（源代码级别、类文件级别、运行时级别）中最长的一种
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoDoor {

    /**
     * 获取某个字段例如用户ID
     *
     * @return
     */
    String key() default "";

    /**
     * 确定白名单拦截后返回的具体内容。
     *
     * @return
     */
    String returnJson() default "";

}
