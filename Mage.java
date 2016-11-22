public class Mage extends Character{
    private String name;
    
    public Mage(){
        HP = 15;
        strength = 4;
        defense = 3;
        attackRating = 1.0;
    }
    public Mage(String newName){
        this();
        name = newName;
    }
    
    public String getName(){
        return name;
    }
    
    //overridden methods
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
    	retstr += "\tMage Guild: Tap into this land's magic to oppose enemies with the elements\n";
 		return retstr;
    }
}