public class Monster{

	private int HP;
	private int strength;
	private int defense;
	private double attackRating;

	public Monster(){
		HP = 20;
		// range [2,16)
		strength = (int)(Math.random()*18) + 2;
		defense = 2;
		attackRating = 1;
	}
	
	//am I alive?
	public boolean isAlive(){
		return HP > 0;
	}
	
	//Access defense
	public int getDefense(){
		return defense;
	}
	
	
	//lowerHP by hit number
	public void lowerHP(int hit){
		HP = HP - hit;
	}
	
	//attack warrior method
	public int attack (Object w){
		double damage = (strength*attackRating) - ((Character)w).getDefense();
		((Character)w).lowerHP((int)damage);
        return (int)damage;
	}
}