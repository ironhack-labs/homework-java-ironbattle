import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GeneratorTest {

    @Test
    public void hpWizard(){
        int x = Generator.generatorWizard();
        assertTrue(x >= 50 || x <=100);
    }

    @Test
    public void hpWarrior(){
        int x = Generator.generatorWarrior();
        assertTrue(x >= 100 || x <=200);
    }

    @Test
    public void StrengthWarrior(){
        int x = Generator.generatorStrength();
        assertTrue(x >= 1 || x <=10);
    }

    @Test
    public void staminaWarrior(){
        int x = Generator.generatorMana();
        assertTrue(x >= 10 || x <=50);
    }

    @Test
    public void manaWizard(){
        int x = Generator.generatorWizard();
        assertTrue(x >= 10 || x <=50);
    }

    @Test
    public void intelligenceWizard(){
        int x = Generator.generatorWizard();
        assertTrue(x >= 1 || x <=50);
    }

}
