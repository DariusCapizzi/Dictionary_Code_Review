
import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args){

    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    //serves: home.vtl, word array in session(words)
    //routes from: home.vtl -fullSubmition.
    get("/", (request,res) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("wordArray", Word.getWordArray());
      ArrayList<Word> words = request.session().attribute("words");
      if (words == null) {
        words = new ArrayList<Word>();
        request.session().attribute("words", words);
      }
      if (request.queryParams().contains("inWord")) {
        //take definition input, construct definition, add to definition array
        String inDef = request.queryParams("inDef");
        Definition newDef = new Definition(inDef);

        //take word input, construct new word
        String inWord = request.queryParams("inWord");
        Word newWord = new Word(inWord);

        newDef.addSynonym(newWord); //put word in def.synonymArray
        newWord.addDef(newDef); //put definition in definitionArray
        words.add(newWord); //put  word in session so it can be displayed on this page.
      }
      model.put("words", request.session().attribute("words"));
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    //serves: word.vtl, newWord (the newly created word)
    //routes from: home.vtl -wordSubmition
    get("/newWord", (request,res) -> {

      Map<String, Object> model = new HashMap<String, Object>();
      model.put("wordArray", Word.getWordArray());
      //new word, no definition
      //this version of the page will only take a definition, and add it to the new word.
      String inWord = request.queryParams("inWord");
      Word newWord = new Word(inWord);
      ArrayList<Word> words = request.session().attribute("words");
      if (words == null) {
        words = new ArrayList<Word>();
        request.session().attribute("words", words);
      }
      words.add(newWord);
      model.put("words", request.session().attribute("words"));
      model.put("thisWord", newWord);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //serves: word.vtl, thisWord(a word stored in session array)
    //routes from: home.vtl -sessionWords, word.vtl -wordDefSubmition, word.vtl -wordSynonyms
    get("/thisWord/:wordId", (request,res) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word thisWord = Word.findWord(Integer.parseInt(request.params(":wordId")));
      //if a new definition was added (queryParams("inDef") exists) addDef
      if (request.queryParams().contains("inDef")) {
        String inDef = request.queryParams("inDef");
        Definition newDef = new Definition(inDef);
        newDef.addSynonym(thisWord);
        thisWord.addDef(newDef);
      }
      model.put("thisWord", thisWord);
      model.put("wordArray", Word.getWordArray());
      model.put("words", request.session().attribute("words"));
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //serves: definition.vtl, newDef (the newly created definition),
    //routes from: home.vtl -defSubmition,
    get("/newDefinition", (request,res) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      //handles definitions without words (new definitions)
      String inDef = request.queryParams("inDef");
      Definition newDef = new Definition(inDef);
      model.put("definition", newDef);
      model.put("wordArray", Word.getWordArray());
      model.put("words", request.session().attribute("words"));
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //serves: definition.vtl, thisDef (the definition selected)
    //routes from: definition.vtl -definitionWordSubmition, word.vtl -wordDefinitions
    get("/thisDefinition/:defId", (request,res) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Definition thisDef = Definition.findDef(Integer.parseInt(request.params(":defId")));
      if (request.queryParams().contains("inWord")){
        String inWord = request.queryParams("inWord");
        Word newWord = new Word(inWord);
        newWord.addDef(thisDef);
        thisDef.addSynonym(newWord);
        ArrayList<Word> words = request.session().attribute("words");
        if (words == null) {
          words = new ArrayList<Word>();
          request.session().attribute("words", words);
        }
        words.add(newWord);
      }
      model.put("definition", thisDef);
      model.put("wordArray", Word.getWordArray());
      model.put("words", request.session().attribute("words"));
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
