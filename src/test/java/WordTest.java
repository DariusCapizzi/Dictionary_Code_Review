
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word testWord = new Word("house");
    assertEquals(true, testWord instanceof Word);
  }


  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("fire");
    Word secondWord = new Word("water");
    assertTrue(secondWord.getWordArray().contains(firstWord));
    assertTrue(Word.getWordArray().contains(secondWord));
  }

  @Test
  public void clear_emptiesAllWordsFromArrayList_0() {
    Word myWord = new Word("Mow the lawn");
    Word.clearWordArray();
    assertEquals(Word.getWordArray().size(), 0);
  }
  //
  // @Test
  // public void getId_WordsInstantiateWithAnID_1() {
  //   Word.clear();  // THIS TEST WILL FAIL WITHOUT THIS LINE!
  //   Word myWord = new Word("Mow the lawn");
  //   assertEquals(0, myWord.getId());
  // }
  //
  // @Test
  // public void find_returnsWordWithSameId_secondWord() {
  //   Word.clear();
  //   Word firstWord = new Word("Mow the lawn");
  //   Word secondWord = new Word("Buy groceries");
  //   assertEquals(Word.find(secondWord.getId()), secondWord);
  // }
}
