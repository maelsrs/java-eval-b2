package partie3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** (2 pts) @Entite : applicable sur une classe, visible à l'exécution.
 * Attribut : String table() — nom de la table DB, défaut : "" */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entite {
    String table() default "";
}