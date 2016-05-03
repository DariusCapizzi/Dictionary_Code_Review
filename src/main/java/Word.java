import java.util.ArrayList;

public class Word {

  public static ArrayList<Word> wordArray =  new ArrayList<Word>();
  public ArrayList<Definition> definitionArray =  new  ArrayList<Definition>();
  private String mName;
  private int mId;


  public Word(String name){
    mName = name;
    mId = wordArray.size();
    wordArray.add(this);
  }

  // // currently causes more problems than it is worth
  // public Word(String name, Definition definition){
  //   mName = name;
  //   wordArray.add(this)
  //   definitionArray.add(Defiinition);
  // }

  public int getId(){
    return mId;
  }

  public String getName(){
    return mName;
  }

  public ArrayList<Definition> getDefinitions(){
    return definitionArray;
  }

  //get synonymArray
  public ArrayList<Word> getSynonyms(Definition definition){
    return definition.getSynonymArray();
  }

  // //find definition
  // public Definition findDefinition(int defID){
  //   try {
  //     return definitionArray.get(defId);
  //   } catch (IndexOutOfBoundsException e) {
  //     System.out.println(e);
  //     return null;
  //   }
  // }

  //find word in wordarray from id (static)
  public static Word findWord(int id) {
    try {
      return wordArray.get(id);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
      return null;
    }
  }

  public static ArrayList<Word> getWordArray(){
    return wordArray;
  }



  public void addDef(Definition definition){
    //when added to definitionArray, setDefId to definitionArray.size()
    definition.setDefId(this); //I want "this" to be the instance of Word, but I dunno if it will even be nessisary.
    definitionArray.add(definition);
  }

}
