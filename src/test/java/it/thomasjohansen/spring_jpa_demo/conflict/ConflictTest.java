package it.thomasjohansen.spring_jpa_demo.conflict;

import it.thomasjohansen.spring_jpa_demo.config.SpringJdbcConfig;
import it.thomasjohansen.spring_jpa_demo.config.SpringPersistenceContextAConfig;
import it.thomasjohansen.spring_jpa_demo.config.SpringPersistenceContextBConfig;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * @author thomas@thomasjohansen.it
 */
public class ConflictTest {

    @Test(expected = IllegalStateException.class)
    public void onlyOneTransactionManagementConfigurerMayExist() {
        try {
            new AnnotationConfigApplicationContext(
                    SpringJdbcConfig.class,
                    SpringPersistenceContextAConfig.class,
                    SpringPersistenceContextBConfig.class
            );
        } catch (BeanCreationException e) {
            while (e.getCause().getClass() == BeanCreationException.class)
                e = (BeanCreationException)e.getCause();
            assertEquals(IllegalStateException.class, e.getCause().getClass());
            assertEquals("Only one TransactionManagementConfigurer may exist", e.getCause().getMessage());
            throw (IllegalStateException)e.getCause();
        }
    }

}
