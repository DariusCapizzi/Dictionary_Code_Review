
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition testDefinition = new Definition("a type of shelter");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getDefinitionArray_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("fire");
    Definition secondDefinition = new Definition("water");
    assertTrue(secondDefinition.getDefinitionArray().contains(firstDefinition));
    assertTrue(Definition.getDefinitionArray().contains(secondDefinition));
  }

  @Test
  public void clearDefinitionArray_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("fire");
    Definition.clearDefinitionArray();
    assertEquals(Definition.getDefinitionArray().size(), 0);
  }

  @Test
  public void getId_DefinitionsInstantiateWithAnID_0() {
    Definition.clearDefinitionArray();
    Definition myDefinition = new Definition("fire");
    assertEquals(0, myDefinition.getId());
  }

  @Test
  public void findDef_returnsDefinitionWithSameId_secondDefinition() {
    Definition.clearDefinitionArray();
    Definition firstDefinition = new Definition("fire");
    Definition secondDefinition = new Definition("water");
    assertEquals(Definition.findDef(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void addSynonym_addsDefinitionToDefinitionArray_0() {
    Definition.clearDefinitionArray();
    Definition myDefinition = new Definition("is hot");
    Word mySynonym = new Word("fire");
    myDefinition.addSynonym(mySynonym);
    assertEquals(1, myDefinition.getSynonymArray().size());
  }

  @Test
  public void clearSynonyms_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("is hot");
    Word mySynonym = new Word("fire");
    myDefinition.addSynonym(mySynonym);
    myDefinition.clearSynonyms();
    assertEquals(0 , myDefinition.getSynonymArray().size());
  }
}
