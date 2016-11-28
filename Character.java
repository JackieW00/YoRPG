
public abstract class Character {

    protected int HP;
    protected int strength;
    protected int defense;
    protected double attackRating;
    protected String name;
    //abstract methods
    public abstract void normalize();
    public abstract void specialize();
    public abstract String about();
    public abstract boolean isCloseEnough(int dist);
    // Constructors
    /* public Character() {
	   HP = 125;
	   strength = 100;
	   defense = 40;
	   attack = .4;
	   name = "Anon";
    }

	
	public Character(String newName) {
	   HP = 125;
	   strength = 100;
	   defense = 40;
	   attack = .4;
	   name = newName;
    }
    
	public Character(int newHP, int newStrength, int newDefense, int newAttack) {
	   HP = newHP;
	   strength = newStrength;
	   defense = newDefense;
	   attack = newAttack;
	   name = "Anon";
    }
    
	public Character(int newHP, int newStrength, int newDefense, int newAttack, String newName) {
	   HP = newHP;
	   strength = newStrength;
	   defense = newDefense;
	   attack = newAttack;
	   name = newName;
    }  */
    
    // Accessors   
    public int getDefense() { return defense; }
    public String getName() { return name; }

	// Methods
    public boolean isAlive() {
		return HP > 0;
    }

    public int attack( Monster w ) {
        if(isCloseEnough(w.getDistance())){
            int damage = (int)( (strength * attackRating) - w.getDefense() );
        
            if ( damage < 0 )
                damage = 0;

            w.lowerHP( damage );
            w.setDistance(w.getDistance()-1);//moves monster closer
            return damage;
        }
        else{
            System.out.println("You are too farz to hurt Monster");
            w.setDistance(w.getDistance()-1);//moves monster closer
            return 0;
        }
    }//end attack

    public void lowerHP( int damage ) {
        HP = HP - damage;
    }
    
    public boolean inRange (Monster m){
	return isCloseEnough(m.getDistance());
    }

}//end class Character
