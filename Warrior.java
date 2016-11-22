public class Warrior extends Character{
    private String name;
    
    public Warrior(){
        HP = 20;
        strength = 5;
        defense = 4;
        attackRating = 1.0;
    }
    public Warrior(String newName){
        this();
        name = newName;
    }
    
    public String getName(){
        return name;
    }
    //overwritten methods
    public void specialize (){
    	attackRating = 4*Math.random();
    	defense -= 2;
    }
    
    public void normalize (){
    
    	attackRating = 1.0;
    	defense += 2;
    }
    public String about(){
    	String retstr = "";
    	retstr += "\tWarrior Guild: Slay your enemies with the fatal blow of your might sword\n";
 		return retstr;
    }
}
