package ufogame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;

public class Game implements ITickableListener, IKeyboardListener {

	// Idea: we want to have multiple instances of an ufo and of a projectile
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
//	private Ufo [] ufos = new Ufo[10];
//	private Projectile [] projectiles = new Projectile[30];
	private Ship ship;
	private int screenWidth = 900;
	private int screenHeight = 700;
	private GameFrameWork frameWork = new GameFrameWork();
	private int score = 0;

	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("ProgrammierenS20\\01Vorlesung\\assets\\space14.jpg"));
		
		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9,
				"ProgrammierenS20\\01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);

		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 1,
				"ProgrammierenS20\\01Vorlesung\\assets\\ufo20.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);

		for (int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}

		frameWork.addTick(this);
		frameWork.addIKeyInput(this);

	}

	public void shoot() {
		// create a projectile
		Projectile projectile = new Projectile(ship.getX() + ship.getWidth()/4, 
				ship.getY() - ship.getWidth() / 2, ship.getWidth() / 2, ship.getWidth() / 2, 3,
				"ProgrammierenS20\\01Vorlesung\\assets\\projectile05.png");
		projectiles.add(projectile);

		frameWork.addGameObject(projectile);

//		for(int i = 0; i < 1000; i++) {
//			projectiles.add(projectile);
//		}
//		
//		for(Projectile p : projectiles) {
//			System.out.println(p.getImagePath());
//		}
		// Variante Array
		// projectiles[0] = projectile;

		// projectiles.get(0).getWidth();
		// Variante Array
		// projectiles[0].getWidth();

		// projectiles.size();
		// Variante Array
		// projectiles.lenght
		System.out.println(projectiles.size());
	}
	
	//Collision
	
	private boolean collisionCheck(Projectile  projectile, Ufo enemy)
    {
        boolean enemyHit = false;
        int enemyBorderLeft = enemy.getX();
        int enemyBorderRight = enemy.getX()+enemy.getWidth();
        int enemyBorderTop = enemy.getY();
        int enemyBorderBottom = enemy.getY()+enemy.getHeight();
        
        int projectileBorderLeft = projectile.getX();
        int projectileBorderRight = projectile.getX()+projectile.getWidth();
        int projectileBorderTop = projectile.getY();
        int projectileBorderBottom = projectile.getY()+projectile.getHeight();
                
        if((projectileBorderLeft > enemyBorderLeft && projectileBorderLeft < enemyBorderRight)|| projectileBorderRight > enemyBorderLeft && projectileBorderRight <  enemyBorderRight)
        {
                if((projectileBorderTop > enemyBorderTop && projectileBorderTop < enemyBorderBottom) || projectileBorderBottom > enemyBorderTop && projectileBorderBottom < enemyBorderBottom)
                {
                    enemyHit = true;
                }
            
        }
        
        
        
        return enemyHit;
    }
	
	// Deleting Collided objects Projectile & Ufo
	
    private void removeCollidedObjects() {
        
        if (projectiles.size() >0) {
	        for(int i=0 ; i<=projectiles.size()-1; i++) {
	            if(projectiles.get(i).isCollided()) {
	                projectiles.remove(i);
	            }
	        }
        }

    }
        
	
	

	@Override
	public void tick(long elapsedTime) {
		for (Ufo ufo : ufos) {
			ufo.move();
		}
		if (ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() - 1));
			System.out.println(ufos.size());
		}
		
		for(Projectile p: projectiles) {
			for (Ufo u : ufos) {
				if(p.getY()+p.getHeight() < 0) {
					p.setCollided(true);
					System.out.println(projectiles.size());
				}
				
				
				if(collisionCheck(p, u) &! u.isCollided()) {
					p.setCollided(true);
					u.setCollided(true);
					frameWork.removeGameObject(p);
					frameWork.removeGameObject(u);
					//Score count + 100 for points
					score = score + 100;
					System.out.println(score);
				}
			}
            p.move();
        }
		
		//TODO check size of list
//			frameWork.removeGameObject(projectiles.get(0));
	removeCollidedObjects();
	}

	@Override
	public int[] getKeys() {
		int [] keys = {KeyEvent.VK_SPACE};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		shoot();
		
	}

}
