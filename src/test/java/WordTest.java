
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word testWord = new Word("house");
    assertEquals(true, testWord instanceof Word);
  }


  @Test
  public void getWordArray_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("fire");
    Word secondWord = new Word("water");
    assertTrue(secondWord.getWordArray().contains(firstWord));
    assertTrue(Word.getWordArray().contains(secondWord));
  }

  @Test
  public void clearWordArray_emptiesAllWordsFromArrayList_0() {
    Word myWord = new Word("fire");
    Word.clearWordArray();
    assertEquals(Word.getWordArray().size(), 0);
  }

  @Test
  public void getId_WordsInstantiateWithAnID_0() {
    Word.clearWordArray();
    Word myWord = new Word("fire");
    assertEquals(0, myWord.getId());
  }

  @Test
  public void findWord_returnsWordWithSameId_secondWord() {
    Word.clearWordArray();
    Word firstWord = new Word("fire");
    Word secondWord = new Word("water");
    assertEquals(Word.findWord(secondWord.getId()), secondWord);
  }

  @Test
  public void addDef_addsDefinitionToDefinitionArray_0() {
    Word.clearWordArray();
    Word myWord = new Word("fire");
    Definition myDef = new Definition("is hot");
    myWord.addDef(myDef);
    assertEquals(1, myWord.getDefinitions().size());
  }

  @Test
  public void clearDefinitionArray_emptiesAllWordsFromArrayList_0() {
    Word myWord = new Word("fire");
    Definition myDef = new Definition("is hot");
    myWord.addDef(myDef);
    myWord.clearDefinitionArray();
    assertEquals(0 , myWord.getDefinitions().size());
  }
}
