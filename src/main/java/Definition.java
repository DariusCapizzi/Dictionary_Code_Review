import java.util.ArrayList;

public class Definition {

  //used to find definitions in active memory
  public static ArrayList<Definition> definitionArray =  new ArrayList<Definition>();
  //used to relate words by definition
  private ArrayList<Word> synonymArray = new ArrayList<Word>();

  private String mDescription;
  private int mDefId;
  private int mId;

  public Definition(String description){
    mDescription = description;
    mId = definitionArray.size();
    definitionArray.add(this);
  }

  public static ArrayList<Definition> getDefinitionArray(){
    return definitionArray;
  }
  public static Definition findDef(int id) {
    try {
      return definitionArray.get(id);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
      return null;
    }
  }

  public static void clearDefinitionArray(){
     definitionArray.clear();
  }

  public String getDescription(){
    return mDescription;
  }

  public void setDefId(Word word){
    mDefId = word.getDefinitions().size();
  }

  public int getId(){
    return mId;
  }

  public ArrayList<Word> getSynonymArray(){
    return synonymArray;
  }

  public void addSynonym(Word synonym){
    synonymArray.add(synonym);
  }

  public void clearSynonyms(){
    synonymArray.clear();
  }


}
