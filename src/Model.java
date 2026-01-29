import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import util.GameObject;
import util.Point3f;
import util.Vector3f;

public class Model {
	private int Money = 0;
	private boolean isFishing = false;
    private GameObject player;
    private Controller controller = Controller.getInstance();
    private int score = 0;

    public Model() {
        player = new GameObject(
                "res/assets/hero.png",
                128,
                128,
                new Point3f(500, 500, 0)
        );
    }

    // This is the heart of the game: the model takes in all inputs,
    // decides outcomes, and updates the model accordingly.
    public void gamelogic() {
        // Player logic first
        playerLogic();

        // Interactions between objects
        gameLogic();
    }

    private void gameLogic() {
        // Increment across the array list

        // See if they hit anything
        // Using enhanced for-loop style as it makes it easier to read
    }

    private void playerLogic() {
        // Check for movement and if you fired a bullet

        if(controller.isKeyAPressed()) {
            player.getCentre().ApplyVector(new Vector3f(-2, 0, 0));
        }

        if(controller.isKeyDPressed()) {
            player.getCentre().ApplyVector(new Vector3f(2, 0, 0));
        }

        if(controller.isKeyWPressed()) {
            player.getCentre().ApplyVector(new Vector3f(0, 2, 0));
        }

        if(controller.isKeySPressed()) {
            player.getCentre().ApplyVector(new Vector3f(0, -2, 0));
        }
        if(controller.isKeySpacePressed()) {
        	castRod();
        	Controller.getInstance().setKeySpacePressed(false);
        }

    }

    public GameObject getPlayer() {
        return player;
    }

    public int getScore() {
        return Money;
    }
    
    private void castRod() {
        if(!isFishing) {
            isFishing = true;
            System.out.println("Rod cast!");
        } else {
            isFishing = false;
            System.out.println("Reeled in!");
            Money = Money + 10;
        }
    }
}
