
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

		int damage = (int)( (strength * attackRating) - w.getDefense() );

		if ( damage < 0 )
	   	 	damage = 0;

		w.lowerHP( damage );

		return damage;
    }//end attack

    public void lowerHP( int damage ) {
		HP = HP - damage;
    }
    
    

}//end class Character
