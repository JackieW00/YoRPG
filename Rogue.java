public class Rogue extends Character{
    private String name;
    
    public Rogue(){
        HP = 18;
        strength = 10;
        defense = 3;
        attackRating = 1.0;
    }
    public Rogue(String newName){
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
    	retstr += "\tRogue Guild: Use your nimbleness to backstab and steal precious items from your foes\n";
 		return retstr;
    }
}