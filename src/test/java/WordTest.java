
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word testWord = new Word("house");
    assertEquals(true, testWord instanceof Word);
  }
  //
  // @Test
  // public void Task_instantiatesWithDescription_String() {
  //   Task myTask = new Task("Mow the lawn");
  //   assertEquals("Mow the lawn", myTask.getDescription());
  // }
  //
  // @Test
  // public void isCompleted_isFalseAfterInstantiation_false() {
  //   Task myTask = new Task("Mow the lawn");
  //   assertEquals(false, myTask.isCompleted());
  // }
  //
  //
  // @Test
  // public void getCreatedAt_instantiatesWithCurrentTime_today() {
  //   Task myTask = new Task("Mow the lawn");
  //   assertEquals(LocalDateTime.now().getDayOfWeek(), myTask.getCreatedAt().getDayOfWeek());
  // }
  //
  // @Test
  // public void all_returnsAllInstancesOfTask_true() {
  //   Task firstTask = new Task("Mow the lawn");
  //   Task secondTask = new Task("Buy groceries");
  //   // System.out.println(firstTask.all());
  //   assertTrue(secondTask.all().contains(firstTask));
  //   assertTrue(Task.all().contains(secondTask));
  // }
  //
  // @Test
  // public void clear_emptiesAllTasksFromArrayList_0() {
  //   Task myTask = new Task("Mow the lawn");
  //   Task.clear();
  //   assertEquals(Task.all().size(), 0);
  // }
  //
  // @Test
  // public void getId_tasksInstantiateWithAnID_1() {
  //   Task.clear();  // THIS TEST WILL FAIL WITHOUT THIS LINE!
  //   Task myTask = new Task("Mow the lawn");
  //   assertEquals(0, myTask.getId());
  // }
  //
  // @Test
  // public void find_returnsTaskWithSameId_secondTask() {
  //   Task.clear();
  //   Task firstTask = new Task("Mow the lawn");
  //   Task secondTask = new Task("Buy groceries");
  //   assertEquals(Task.find(secondTask.getId()), secondTask);
  // }
}
