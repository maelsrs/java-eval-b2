package partie3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * (2 pts) @Colonne : applicable sur un champ, visible à l'exécution.
 * Attributs : String nom() défaut "", boolean nullable() défaut true */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Colonne {
    String nom() default "";
    boolean nullable() default true;
}