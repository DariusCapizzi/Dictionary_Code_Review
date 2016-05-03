import java.util.ArrayList;

public class Definition {

  public static ArrayList<Definition> definitionArray =  new ArrayList<Definition>();
  //array of words. that this definition fits.
  private ArrayList<Word> synonymArray = new ArrayList<Word>();

  //TODO add typeOfWord property
  private String mDescription;
  private int mDefId;
  private int mId;

  public Definition(String description){
    mDescription = description;
    mId = definitionArray.size();
    definitionArray.add(this);
  }

  //find word in wordarray from id (static)
  public static Definition findDef(int id) {
    try {
      return definitionArray.get(id);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
      return null;
    }
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

  //get synonymArray
  public ArrayList<Word> getSynonymArray(){
    return synonymArray;
  }

  public void addSynonym(Word synonym){
    synonymArray.add(synonym);
  }

  // //get word from synonymArray?
  // public findSynonym(){}
}
