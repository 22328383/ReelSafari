import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import util.GameObject;
import util.Point3f;
import util.Vector3f; 

public class Model {
	
	 private  GameObject Player;
	 private Controller controller = Controller.getInstance();
	 private  CopyOnWriteArrayList<GameObject> FishList   = new CopyOnWriteArrayList<GameObject>();
	 private  CopyOnWriteArrayList<GameObject> BulletList = new CopyOnWriteArrayList<GameObject>();
	 private int Score=0; 

	public Model() {
		 //setup game world 
		//Player 	    
	}
	
	// This is the heart of the game , where the model takes in all the inputs ,decides the outcomes and then changes the model accordingly. 
	public void gamelogic() 
	{
		// Player Logic first 
		playerLogic(); 
		// interactions between objects 
		gameLogic(); 
	   
	}

	private void gameLogic() { 
		
		
		// this is a way to increment across the array list data structure 

		
		//see if they hit anything 
		// using enhanced for-loop style as it makes it alot easier both code wise and reading wise too 
		
	}

	private void playerLogic() {
				 
		//check for movement and if you fired a bullet 
		  
if(Controller.getInstance().isKeyAPressed()){Player.getCentre().ApplyVector( new Vector3f(-2,0,0)); }
		
		if(Controller.getInstance().isKeyDPressed())
		{
			Player.getCentre().ApplyVector( new Vector3f(2,0,0));
		}
			
		if(Controller.getInstance().isKeyWPressed())
		{
			Player.getCentre().ApplyVector( new Vector3f(0,2,0));
		}
		
		if(Controller.getInstance().isKeySPressed()){Player.getCentre().ApplyVector( new Vector3f(0,-2,0));}
		
		if(Controller.getInstance().isKeySpacePressed())
		{
			CreateBullet();
			Controller.getInstance().setKeySpacePressed(false);
		} 
		
	}

	private void CreateBullet() {
		BulletList.add(new GameObject("res/Bullet.png",32,64,new Point3f(Player.getCentre().getX(),Player.getCentre().getY(),0.0f)));
		
	}

	public GameObject getPlayer() {
		return Player;
	}

	
	public CopyOnWriteArrayList<GameObject> getBullets() {
		return BulletList;
	}

	public int getScore() { 
		return Score;
	}
 

}

