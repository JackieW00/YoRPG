//Weeboda(Nikita Borisov,Daniel Regassa, Jackie Woo)
//APCS1 pd01
//HW#34
//due: 11/22/16
/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Monster, Warrior, Mage, Rogue, Assassin
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG 
	{
		// ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

		//change this constant to set number of encounters in a game
		public final static int MAX_ENCOUNTERS = 5;

		//each round, a Warrior and a Monster will be instantiated...
		private Character pat;   //Is it man or woman?
		private Monster smaug; //Friendly generic monster name?

		private int moveCount;
		private boolean gameOver;
		private int difficulty;
		private int role;

		private InputStreamReader isr;
		private BufferedReader in;
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


		// ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
		public YoRPG() {
		   moveCount = 0;
		   gameOver = false;
		   isr = new InputStreamReader( System.in );
		   in = new BufferedReader( isr );
		   newGame();
		}
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


		// ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

		/*=============================================
		  void newGame() -- facilitates info gathering to begin a new game
		  pre:  
		  post: according to user input, modifies instance var for difficulty 
		  and instantiates a Warrior
		  =============================================*/
		public void newGame() {

			String s;
			String name = "";
			s = "Welcome to Ye Olde RPG!\n";

			s += "\nChoose your difficulty: \n";
			s += "\t1: Easy\n";
			s += "\t2: Not so easy\n";
			s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
			s += "Selection: ";
			System.out.print( s );

			try {
				difficulty = Integer.parseInt( in.readLine() );
			}
			catch ( IOException e ) { }

			s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
			System.out.print( s );

			try {
				name = in.readLine();
			}
			catch ( IOException e ) { }
			
			// Choose Character ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			String retstr = "";
            retstr += "\nWelcome to Ye Olde RPG!\n";
            retstr += "Young Adventurer, please free this land of the Wretched Smaug Monsters.\n";
            retstr += "They have been harassing our people since the beginning of time.\n";
            retstr += "Please help us brave Adventurer!\n";
            retstr += "Choose your guild to study in:\n";
            retstr += "\t1: Warrior Guild: Slay your enemies with the fatal blow of your might sword\n";
            retstr += "\t2: Mage Guild: Tap into this land's magic to oppose enemies with the elements\n";
            retstr += "\t3: Rogue Guild: Use your nimbleness to backstab and steal precious items from your foes\n";
            retstr += "\t4: Assassin Guild: Travel swiftly through the night and deal your unsuspecting foes fatal hits\n";
            retstr += "\t5: Archer Guild: Use your eagle eye to shoot enemies from afar with your trusty bow and arrow\n";
			System.out.println( retstr );
			
			try {
				role = Integer.parseInt( in.readLine() );
			}
			catch ( IOException e ) { }

			//instantiate the player's character
			if (role == 1) {pat = new Warrior( name );}
			else if (role == 2) {pat = new Mage( name );}
			else if (role == 3) {pat = new Rogue( name );}
			else if (role == 4) {pat = new Assassin( name );}
			else if (role == 5) {pat = new Archer( name );}
			
		}//end newGame()


		/*=============================================
		  boolean playTurn -- simulates a round of combat
		  pre:  Character pat has been initialized
		  post: Returns true if player wins (monster dies).
		  Returns false if monster wins (player dies).
		  =============================================*/
		public boolean playTurn() {
		
			int i = 1;
			int d1, d2;

			if ( Math.random() >= ( difficulty / 3.0 ) )
				System.out.println( "\nNothing to see here. Move along!" );
			else {
				System.out.println( "\nLo, yonder monster approacheth!" );

				smaug = new Monster();

			while( smaug.isAlive() && pat.isAlive() ) {


				// Give user the option of using a special attack:
				// If you land a hit, you incur greater damage,
				// ...but if you get hit, you take more damage.
			    
				try {
					System.out.println( "\nDo you feel lucky?" );
					System.out.println( "\t1: Nay.\n\t2: Aye!" );
					i = Integer.parseInt( in.readLine() );
				}
				catch ( IOException e ) { }

				if ( i == 2 )
					pat.specialize();
				else
					pat.normalize();
				
				//-------------------------------------------------------
			        //Attack Stage
				if (pat.inRange(smaug)){
				    d1 = pat.attack( smaug );
				    System.out.println( "\n" + pat.getName() + " dealt " + d1 +
							" points of damage.");

				    d2 = smaug.attack( pat );
				
				    System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
							" for " + d2 + " points of damage.");
				}
				else{
				    d1 = 0;
				    try {
					System.out.println( "\nYou Missed!" );
					
					d2 = smaug.attack( pat );
					System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
							" for " + d2 + " points of damage.");
					
					System.out.println("\nApproach thy Monster?");
					System.out.println( "\t1: Nay.\n\t2: Aye!" );
					i = Integer.parseInt( in.readLine() );
				    }
				    catch ( IOException e ) { }

				    if ( i == 2 )
					smaug.moveCloser();
				    
				}


				//-----------------------------------------------------------------------
			       
			}//end while

			//option 1: you & the monster perish
			if ( !smaug.isAlive() && !pat.isAlive() ) {
				System.out.println( "'Twas an epic battle, to be sure... " + 
							"You cut ye olde monster down, but " +
							"with its dying breath ye olde monster. " +
							"laid a fatal blow upon thy skull." );
				return false;
			}
			//option 2: you slay the beast
			else if ( !smaug.isAlive() ) {
				System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
				return true;
			}
			//option 3: the beast slays you
			else if ( !pat.isAlive() ) {
				System.out.println( "Ye olde self hath expired. You got dead." );
				return false;
			}
		}//end else

		return true;
		}//end playTurn()
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


		public static void main( String[] args ) {

			//As usual, move the begin-comment bar down as you progressively 
			//test each new bit of functionality...

			//loading...
			YoRPG game = new YoRPG();

			int encounters = 0;

			while( encounters < MAX_ENCOUNTERS ) {
				if ( !game.playTurn() )
				break;
				encounters++;
				System.out.println();
			}

			System.out.println( "Thy game doth be over." );
			/*================================================
		  	================================================*/
		}//end main

}//end class YoRPG
