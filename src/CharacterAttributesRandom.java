public class CharacterAttributesRandom extends CharacterAttributes {

    public CharacterAttributesRandom(){
        setAttributesRandom();
    }

    //Setters Random
    public void setAttributesRandom() {
        this.type = Utils.generateRandomNumber();
        this.name = "Fighter";
        this.attribute1 = Utils.generateRandomNumber(10, 50);
        if (this.type == 0){
            this.hp = Utils.generateRandomNumber(100, 200);
            this.attribute2 = Utils.generateRandomNumber(1, 10);
        } else{
            this.hp = Utils.generateRandomNumber(50, 100);
            this.attribute2 = Utils.generateRandomNumber(1, 50);
        }
    }
}
