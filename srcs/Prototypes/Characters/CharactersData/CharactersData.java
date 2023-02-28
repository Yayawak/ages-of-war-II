package srcs.Prototypes.Characters.CharactersData;
import java.util.ArrayList;
import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Characters.CharactersData.CharLists.GrimStroke;
import srcs.Prototypes.Characters.CharactersData.CharLists.Morphling;
import srcs.Prototypes.Characters.CharactersData.CharLists.NatureProphet;
import srcs.Prototypes.Characters.CharactersData.CharLists.Rubick;;

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

        charactersList.add((CharacterPrototype)new GrimStroke(TeamType.PLAYER));
        charactersList.add((CharacterPrototype)new NatureProphet(TeamType.PLAYER));
        charactersList.add((CharacterPrototype)new Rubick(TeamType.PLAYER));
        charactersList.add((CharacterPrototype)new Morphling(TeamType.PLAYER));
    }

}

