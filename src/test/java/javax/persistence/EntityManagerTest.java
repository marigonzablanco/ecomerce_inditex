package javax.persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class EntityManagerTest {

    @Test
    void testEntityManagerInstantiation() {
        EntityManager em = new EntityManager();
        assertNotNull(em);
    }
}