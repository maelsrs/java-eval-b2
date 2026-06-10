package partie3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** (2 pts) @Loggable : applicable sur une méthode, visible àl'exécution.
 * Attribut : String niveau() parmi "INFO", "WARN", "ERROR", défaut "INFO" */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggable { String niveau() default "INFO"; }