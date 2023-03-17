package srcs.Prototypes.Characters.CharactersData;
import java.util.ArrayList;
import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.GrimStroke;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.Morphling;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.NatureProphet;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.Rubick;;

public class CharactersData {
    private static CharactersData instance = null;
    private ArrayList<CharacterPrototype> charactersList = new ArrayList<>();

    public ArrayList<CharacterPrototype> getCharactersList() {
        return charactersList;
    }
    public void setCharactersList(ArrayList<CharacterPrototype> charactersList) {
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

        charactersList.add((CharacterPrototype)new GrimStroke());
        charactersList.add((CharacterPrototype)new NatureProphet());
        charactersList.add((CharacterPrototype)new Rubick());
        charactersList.add((CharacterPrototype)new Morphling());
    }

}

