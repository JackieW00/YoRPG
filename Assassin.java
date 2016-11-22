public class Assassin extends Character{
    private String name;
    
    public Assassin(){
        HP = 15;
        strength = 4;
        defense = 8;
        attackRating = 1.0;
    }
    public Assassin(String newName){
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
    	retstr += "\tAssassin Guild: Travel swiftly through the night and deal your unsuspecting foes fatal hits\n";
 		return retstr;
    }
}