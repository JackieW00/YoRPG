public class Monster{

	private int HP;
	private int strength;
	private int defense;
	private double attackRating;
        private int distance; // represents distance from player
    
	public Monster(){
		HP = 20;
		// range [2,20)
		strength = (int)(Math.random()*18) + 2;
		defense = 2;
		attackRating = 1;
		distance = (int)(Math.random()*5); //interval [0,4]
	}
	
	//am I alive?
	public boolean isAlive(){
		return HP > 0;
	}
	
	//Accessors
	public int getDefense(){
		return defense;
	}
	public int getDistance(){
        return distance;
    }
    //mutators
    public void setDistance(int newDist){
        distance = newDist;
    }
    public void moveCloser(){ //allows player to step closer to monster if not already close enough
	distance -= 1;
    }
	
	//lowerHP by hit number
	public void lowerHP(int hit){
        HP = HP - hit;
	}
	
	//attack warrior method
	public int attack (Object w){
		double damage = (strength*attackRating) - ((Character)w).getDefense();
		if (damage<0)
            damage = 0;
        ((Character)w).lowerHP((int)damage);
        return (int)damage;
	}
}
