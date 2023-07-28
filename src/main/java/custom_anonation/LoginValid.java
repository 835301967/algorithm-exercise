package custom_anonation;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@Documented
public @interface LoginValid {
    String value();
}
