/*
 *  ____    _    ____  _   _ _____     ___    _
 * / ___|  / \  |  _ \| \ | |_ _\ \   / / \  | |
 * | |    / _ \ | |_) |  \| || | \ \ / / _ \ | |
 * | |___/ ___ \|  _ <| |\  || |  \ V / ___ \| |___
 * \____/_/   \_\_| \_\_| \_|___|  \_/_/   \_\_____|
 *
 * https://github.com/yingzhuo/carnival
 */
package com.github.yingzhuo.carnival.common.condition;

import lombok.val;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.*;

/**
 * @author 应卓
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(ProfileAny.OnProfileAnyCondition.class)
public @interface ProfileAny {

    public String[] value();

    public static class OnProfileAnyCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            val aas = AnnotationAttributes.fromMap(
                    metadata.getAnnotationAttributes(ProfileAny.class.getName()));
            val value = aas.getStringArray("value");

            for (String v : value) {
                if (context.getEnvironment().acceptsProfiles(v)) {
                    return true;
                }
            }
            return false;
        }
    }

}
