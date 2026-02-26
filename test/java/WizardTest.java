import com.example.Wizard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WizardTest {
    private Wizard wizard;
    @BeforeEach
    void setUp(){
        wizard=new Wizard("Sauron",100,20,35);
    }
    @Test
    void NewWizardTest(){
      assertNotNull(wizard);
      assertEquals("Sauron",wizard.getName());
      assertEquals(100,wizard.getHp());
      assertEquals(20,wizard.getMana());
      assertEquals(35,wizard.getIntelligence());
    }
    @Test
    void WizardGettersTest(){
        assertEquals("Sauron",wizard.getName());
        assertEquals(100,wizard.getHp());
        assertEquals(20,wizard.getMana());
        assertEquals(35,wizard.getIntelligence());
    }
    @Test
    void WizardSettersTest(){
        wizard=new Wizard("Gandalf",101,20,34);
        assertEquals("Gandalf",wizard.getName());
        assertEquals(101,wizard.getHp());
        assertEquals(20,wizard.getMana());
        assertEquals(34,wizard.getIntelligence());
    }

}
