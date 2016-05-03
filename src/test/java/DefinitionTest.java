
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition testDefinition = new Definition("a type of shelter");
    assertEquals(true, testDefinition instanceof Definition);
  }

}
