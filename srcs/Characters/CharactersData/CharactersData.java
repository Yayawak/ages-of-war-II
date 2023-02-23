package srcs.Characters.CharactersData;
import java.util.ArrayList;
import helpers.ImageData;
import srcs.Characters.Malee.MaleeUnit;
import srcs.Enums.TeamType;
import srcs.Characters.Character;
import srcs.Characters.CharactersData.CharLists.GrimStroke;
import srcs.Characters.CharactersData.CharLists.NatureProphet;;

public class CharactersData {
    private static CharactersData instance = null;
    private ArrayList<Character> charactersList = new ArrayList<>();

    public static void setInstance(CharactersData instance) {
        CharactersData.instance = instance;
    }
    public ArrayList<Character> getCharactersList() {
        return charactersList;
    }
    public void setCharactersList(ArrayList<Character> charactersList) {
        this.charactersList = charactersList;
    }
    public static CharactersData getInstance() {
        if (instance == null)
            instance = new CharactersData();
        return instance;
    }
    public CharactersData() {
        // hp : 1 -> 100
        // money : 1 -> 100
        // exp : 1 -> 100
        //movement speed : 1 - 5
        // atk speed : 1 - 5

        // charactersList.add((Character)grimUnit);
        // new GrimStroke();
        charactersList.add((Character)new GrimStroke());
        charactersList.add((Character)new NatureProphet());
    }

}

