package srcs.Prototypes.Characters;

public class OldCharProto {

}
// public class CharacterPrototype {
// // public class Character {
//     private String characterName;
//     private int experiance;
//     private int gold;
//     private int hp;
//     private int movementSpeed;
//     private int attackSpeed;
//     private TeamType team = TeamType.PLAYER;
//     private ImageData imageData;
//     // private Point position = new Point(0,0);
//     // private Point position = new Point(50, 50);
//     // private Point position = new Point(500, 200);
//     private Point position = new Point(999, 200);
//     private float buildTime;
//     private CharacterPrototype copyInstance;


//     public CharacterPrototype(TeamType teamType) {
//         // int spawnX = (team == TeamType.PLAYER) ? 0 : (int)MainUI.getInstance().getScreenSize().getWidth();
//         this.team = teamType;
//         int spawnX = (team == TeamType.PLAYER) ? 0 : (int)MainUI.getInstance().getScreenSize().getWidth();
//         this.position = new Point(spawnX, position.y);
//         // int spawnX = (team == TeamType.PLAYER) ? 600 : 1209;
//     }

//     public CharacterPrototype(CharacterPrototype anotherChar, TeamType teamType) {
//         this.copyInstance = anotherChar;
//         this.team = teamType;
//         int spawnX = (team == TeamType.PLAYER) ? 0 : (int)MainUI.getInstance().getScreenSize().getWidth();
//         this.position = new Point(spawnX, position.y);
//     }

//     public CharacterPrototype(String characterName, int experiance, int gold,
//         int hp, int movementSpeed, int attackSpeed,
//         TeamType team,
//         ImageData imageData,
//         float buildTime
//     ) {
//         this.characterName = characterName;
//         this.experiance = experiance;
//         this.gold = gold;
//         this.hp = hp;
//         this.movementSpeed = movementSpeed;
//         this.attackSpeed = attackSpeed;
//         this.team = team;
//         this.imageData = imageData;
//         this.buildTime = buildTime;
//         int spawnX = (team == TeamType.PLAYER) ? 0 : (int)MainUI.getInstance().getScreenSize().getWidth();
//         this.position = new Point(spawnX, position.y);
// }

//     public String getCharacterName() {
//         return characterName;
//     }

//     public void setCharacterName(String characterName) {
//         this.characterName = characterName;
//     }

//     public int getExperiance() {
//         return experiance;
//     }

//     public void setExperiance(int experiance) {
//         this.experiance = experiance;
//     }

//     public int getGold() {
//         return gold;
//     }

//     public void setGold(int gold) {
//         this.gold = gold;
//     }

//     public int getHp() {
//         return hp;
//     }

//     public void setHp(int hp) {
//         this.hp = hp;
//     }

//     public int getMovementSpeed() {
//         return movementSpeed;
//     }

//     public void setMovementSpeed(int movementSpeed) {
//         this.movementSpeed = movementSpeed;
//     }

//     public TeamType getTeam() {
//         return team;
//     }

//     public void setTeam(TeamType team) {
//         this.team = team;
//     }

//     public ImageData getImageData() {
//         return imageData;
//     }

//     public void setImageData(ImageData imageData) {
//         this.imageData = imageData;
//     }

//     public int getAttackSpeed() {
//         return attackSpeed;
//     }

//     public void setAttackSpeed(int attackSpeed) {
//         this.attackSpeed = attackSpeed;
//     }

//     public Point getPosition() {
//         return position;
//     }

//     public void setPosition(Point position) {
//         this.position = position;
//     }

//     public float getBuildTime() {
//         return buildTime;
//     }

//     public void setBuildTime(float buildTime) {
//         this.buildTime = buildTime;
//     }

//     public CharacterPrototype getCopyInstance() {
//         // return copyInstance;
//         if (copyInstance == null)
//             copyInstance = new CharacterPrototype(this, team);
//         return copyInstance;
//     }

// }
