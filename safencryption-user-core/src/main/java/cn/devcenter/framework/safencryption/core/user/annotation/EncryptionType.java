package cn.devcenter.framework.safencryption.core.user.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EncryptionType {

    int value();

}
