package srcs.Systems.Tooltips;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.CharacterAttribute;

import srcs.GameUI.topBar.unitsBox.SubUnit.SubUnit;
import srcs.Prototypes.Characters.CharacterPrototype;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

// public class CharacterTooltip extends JPanel {
public class CharacterTooltip extends JPopupMenu {
    private CharacterPrototype characterPrototype;

    // public CharacterTooltip(CharacterPrototype characterPrototype) {
    public CharacterTooltip(CharacterPrototype characterPrototype) {
        this.characterPrototype = characterPrototype;
        init();
    }

    void init() {
        // setSize(30, 30);
        // setPreferredSize(new Dimension(30, 30));
        setPreferredSize(new Dimension(150, 200));

        setLayout(new GridLayout(4, 2));
        // setLayout(null);
        // setLayout(new FlowLayout());
        // set
        // JLabel name = new JLabel("Name: " + characterPrototype.getName());
        HashMap<String, Object> characterAtributesPair = new HashMap<>();
        characterAtributesPair.putIfAbsent("Name", characterPrototype.getName());
        characterAtributesPair.putIfAbsent("Gold", characterPrototype.getGold());
        characterAtributesPair.putIfAbsent("Damage", characterPrototype.getAttackDamage());
        characterAtributesPair.putIfAbsent("Attack speed", characterPrototype.getAttackSpeed());
        characterAtributesPair.putIfAbsent("Attack range", characterPrototype.getAttackRange());
        characterAtributesPair.putIfAbsent("Health point", characterPrototype.getMaxHp());
        characterAtributesPair.putIfAbsent("Build time", characterPrototype.getBuildTime());
        characterAtributesPair.putIfAbsent("Movement speed", characterPrototype.getMovementSpeed());

        for (String attributeName : characterAtributesPair.keySet()) {
            TextWithValue lwv = new TextWithValue(
                attributeName,
                characterAtributesPair.get(attributeName)
            );
            add(lwv);
        }
    }
}

// class TextWithValue extends JTextField {
class TextWithValue extends JTextArea {
    public TextWithValue(String lead, Object value) {
        setText(lead + ": " + String.valueOf(value));
        init();
    }

    void init() {
        setFont(new Font(Font.SANS_SERIF,
        // Font.CENTER_BASELINE, 15));
        Font.CENTER_BASELINE, 10));
        setForeground(new Color(
            (float)Math.random(),
            (float)Math.random(),
            (float)Math.random()
        ));
        setLineWrap(true);
        setWrapStyleWord(true);
    }
}
