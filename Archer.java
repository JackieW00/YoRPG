public class Archer extends Character{
    private String name;
    
    public Archer(){
        HP = 15;
        strength = 6;
        defense = 10;
        attackRating = 1.0;
    }
    public Archer(String newName){
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
    	retstr += "\tArcher Guild: Use your eagle eye to shoot enemies from afar with your trusty bow and arrow\n";
 		return retstr;
    }
}