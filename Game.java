
package space.wars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Fire{
    
    private int firePositionX , firePositionY ;
    
    public Fire(int firePositionX , int firePositionY){
        this.firePositionX = firePositionX ; 
        this.firePositionY = firePositionY ; 
    }

    public int getFirePositionX() {
        return firePositionX;
    }

    public void setFirePositionX(int firePositionX) {
        this.firePositionX = firePositionX;
    }

    public int getFirePositionY() {
        return firePositionY;
    }

    public void setFirePositionY(int firePositionY) {
        this.firePositionY = firePositionY;
    }
    
}

class EnemyFire{
    private int EnemyFirePositionX , EnemyFirePositionY ;
    
     public EnemyFire(int EnemyFirePositionX , int EnemyFirePositionY){
        this.EnemyFirePositionX = EnemyFirePositionX ; 
        this.EnemyFirePositionY = EnemyFirePositionY ; 
    }

    public int getEnemyFirePositionX() {
        return EnemyFirePositionX;
    }

    public void setEnemyFirePositionX(int EnemyFirePositionX) {
        this.EnemyFirePositionX = EnemyFirePositionX;
    }

    public int getEnemyFirePositionY() {
        return EnemyFirePositionY;
    }

    public void setEnemyFirePositionY(int EnemyFirePositionY) {
        this.EnemyFirePositionY = EnemyFirePositionY;
    }
     
}
class EnemyRightFire {
    private int EnemyRightFirePositionX , EnemyRightFirePositionY ;
    
     public EnemyRightFire(int EnemyRightFirePositionX , int EnemyRightFirePositionY){
        this.EnemyRightFirePositionX = EnemyRightFirePositionX ; 
        this.EnemyRightFirePositionY = EnemyRightFirePositionY ; 
    }

    public int getEnemyRightFirePositionX() {
        return EnemyRightFirePositionX;
    }

    public void setEnemyRightFirePositionX(int EnemyRightFirePositionX) {
        this.EnemyRightFirePositionX = EnemyRightFirePositionX;
    }

    public int getEnemyRightFirePositionY() {
        return EnemyRightFirePositionY;
    }

    public void setEnemyRightFirePositionY(int EnemyRightFirePositionY) {
        this.EnemyRightFirePositionY = EnemyRightFirePositionY;
    }
     
}
class EnemyLeftFire {
    private int EnemyLeftFirePositionX , EnemyLeftFirePositionY ;
    
     public EnemyLeftFire(int EnemyLeftFirePositionX , int EnemyLeftFirePositionY){
        this.EnemyLeftFirePositionX = EnemyLeftFirePositionX ; 
        this.EnemyLeftFirePositionY = EnemyLeftFirePositionY ; 
    }

    public int getEnemyLeftFirePositionX() {
        return EnemyLeftFirePositionX;
    }

    public void setEnemyLeftFirePositionX(int EnemyLeftFirePositionX) {
        this.EnemyLeftFirePositionX = EnemyLeftFirePositionX;
    }

    public int getEnemyLeftFirePositionY() {
        return EnemyLeftFirePositionY;
    }

    public void setEnemyLeftFirePositionY(int EnemyLeftFirePositionY) {
        this.EnemyLeftFirePositionY = EnemyLeftFirePositionY;
    }
     
}

public class Game extends JPanel implements KeyListener , ActionListener{
    
    private int SpaceShipPositionX = 475, SpaceShipPositionY = 610 ; 
    private int EnemyPositionX = 475 , EnemyPositionY = 0; 
    private int EnemyRightPositionX = 935 , EnemyRightPositionY = 0  ; 
    private int EnemyLeftPositionX = 0, EnemyLeftPositionY = 0 ; 
    
    private int EnemyLeftConstantValue = 5 ; 
    private int EnemyRightConstantValue = 5 ; 
    private int EnemyConstantValue = 5; 
    private int SpaceShipConstantValue = 10; 
    private int FireConstantValue = 5 ; 
    
    private int EnemyRightHp = 50 , EnemyLeftHp = 50 , EnemyHp = 50 , UserHealth = 100 ;
    
    private int time = 0 ; 
    
    int value ; 
    
    
    private ArrayList<Fire> fires = new ArrayList<Fire>() ; 
    private ArrayList<EnemyFire> enemyfires = new ArrayList<EnemyFire>() ;
    private ArrayList<EnemyRightFire> enemyrightfires = new ArrayList<EnemyRightFire>() ;
    private ArrayList<EnemyLeftFire> enemyleftfires = new ArrayList<EnemyLeftFire>() ;
    
    Timer timer = new Timer(5 , this) ; 
    
    BufferedImage SpaceShip , Enemy , EnemyRight , EnemyLeft , Fire , X , EnemyFire; 
    
    public Game(){
        addImage() ;
        setBackground(Color.BLACK) ;
        timer.start() ; 
    }
    
    public void addImage(){
        try {
		SpaceShip = ImageIO.read(new FileImageInputStream(new File("SpaceShip.png"))) ; 
            }
            catch(IOException ex){
		Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex) ; 
            }
        try {
		Enemy = ImageIO.read(new FileImageInputStream(new File("Enemy.png"))) ; 
            }
            catch(IOException ex){
		Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex) ; 
            }
        
        try {
		EnemyRight = ImageIO.read(new FileImageInputStream(new File("EnemyRight.png"))) ; 
            }
            catch(IOException ex){
		Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex) ; 
            }
        
        try {
		EnemyLeft = ImageIO.read(new FileImageInputStream(new File("EnemyLeft.png"))) ; 
            }
            catch(IOException ex){
		Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex) ; 
            }
         try {
		Fire = ImageIO.read(new FileImageInputStream(new File("fire.png"))) ; 
            }
            catch(IOException ex){
		Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex) ; 
            }
         try {
		X = ImageIO.read(new FileImageInputStream(new File("x.png"))) ; 
            }
            catch(IOException ex){
		Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex) ; 
            }
         try {
		EnemyFire = ImageIO.read(new FileImageInputStream(new File("enemyFire.png"))) ; 
            }
            catch(IOException ex){
		Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex) ; 
            }
        
    }
    public void moveIt(){
        if(EnemyLeftPositionY >= 610){
            EnemyLeftConstantValue = EnemyLeftConstantValue  * -1; 
        }
        if(EnemyLeftPositionY <= 0){
            EnemyLeftConstantValue = EnemyLeftConstantValue * -1 ; 
        }
        if(EnemyRightPositionY >= 610){
            EnemyRightConstantValue = EnemyRightConstantValue  * -1; 
        }
        if(EnemyRightPositionY <= 0){
            EnemyRightConstantValue = EnemyRightConstantValue * -1 ; 
        }
        if(EnemyPositionX >= 935){
            EnemyConstantValue = EnemyConstantValue  * -1; 
        }
        if(EnemyPositionX <= 0){
            EnemyConstantValue = EnemyConstantValue * -1 ; 
        }
    }
    
    public boolean CheckCollision() {
        
        for(Fire fire : fires) {
            if(new Rectangle(fire.getFirePositionX() , fire.getFirePositionY() , 20 , 20).intersects(new Rectangle(EnemyPositionX , EnemyPositionY , 64 , 64))){
                value = 0 ;
                return true ; 
            }
            if(new Rectangle(fire.getFirePositionX() , fire.getFirePositionY() , 20 , 20).intersects(new Rectangle(EnemyRightPositionX , EnemyRightPositionY , 64 , 64))){
               value = 1 ; 
                return true ; 
            }
            if(new Rectangle(fire.getFirePositionX() , fire.getFirePositionY() , 20 , 20).intersects(new Rectangle(EnemyLeftPositionX , EnemyLeftPositionY , 64 , 64))){
                value = 2 ; 
                return true ; 
            }
        }
        return false ; 
    }
    public boolean CheckCollision2() {
        
        for(EnemyFire enemyfire : enemyfires) {
            if(new Rectangle(enemyfire.getEnemyFirePositionX() , enemyfire.getEnemyFirePositionY() , 20 , 20).intersects(new Rectangle(SpaceShipPositionX , SpaceShipPositionY , 64 , 64))){
                value = 0 ;
                return true ; 
            }
        }
        for(EnemyRightFire enemyrightfire : enemyrightfires) {
            if(new Rectangle(enemyrightfire.getEnemyRightFirePositionX() , enemyrightfire.getEnemyRightFirePositionY() , 20 , 20).intersects(new Rectangle(SpaceShipPositionX , SpaceShipPositionY , 64 , 64))){
                value = 1 ;
                return true ; 
            }
        }
        for(EnemyLeftFire enemyleftfire : enemyleftfires) {
            if(new Rectangle(enemyleftfire.getEnemyLeftFirePositionX() , enemyleftfire.getEnemyLeftFirePositionY() , 20 , 20).intersects(new Rectangle(SpaceShipPositionX , SpaceShipPositionY , 64 , 64))){
                value = 2 ;
                return true ; 
            }
        }
        return false ; 
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
        time++ ; 
        
        g.drawImage(SpaceShip , SpaceShipPositionX , SpaceShipPositionY , 64 , 64 , this) ;
        g.drawImage(Enemy , EnemyPositionX , EnemyPositionY , 64 , 64 , this) ;
        g.drawImage(EnemyRight , EnemyRightPositionX , EnemyRightPositionY , 64 , 64 , this) ;
        g.drawImage(EnemyLeft , EnemyLeftPositionX , EnemyLeftPositionY , 64 , 64 , this) ;

        if(EnemyConstantValue == 0)  g.drawImage(X , EnemyPositionX , EnemyPositionY , 64 , 64 , this) ;
        if(EnemyRightConstantValue == 0)  g.drawImage(X , EnemyRightPositionX , EnemyRightPositionY , 64 , 64 , this) ;
        if(EnemyLeftConstantValue == 0)  g.drawImage(X , EnemyLeftPositionX , EnemyLeftPositionY , 64 , 64 , this) ;
        
        if(EnemyLeftConstantValue != 0){
            for(EnemyLeftFire enemyleftfire : enemyleftfires)g.drawImage(EnemyFire , enemyleftfire.getEnemyLeftFirePositionX() , enemyleftfire.getEnemyLeftFirePositionY() , 32 , 32 , this);
        }
        if(EnemyRightConstantValue != 0){
            for(EnemyFire enemyfire : enemyfires)g.drawImage(EnemyFire , enemyfire.getEnemyFirePositionX() , enemyfire.getEnemyFirePositionY() , 32 , 32 , this);
            for(EnemyRightFire enemyrightfire : enemyrightfires)g.drawImage(EnemyFire , enemyrightfire.getEnemyRightFirePositionX() , enemyrightfire.getEnemyRightFirePositionY() , 32 , 32 , this);
        }
        if(EnemyConstantValue != 0){
            for(EnemyFire enemyfire : enemyfires)g.drawImage(EnemyFire , enemyfire.getEnemyFirePositionX() , enemyfire.getEnemyFirePositionY() , 32 , 32 , this);
        }
        
        if(CheckCollision()){
            if(value == 0){
                EnemyHp -= 1 ;
                if(EnemyHp < 40)EnemyConstantValue = 0 ;
            }
            if(value == 1){
                EnemyRightHp -= 1 ;
                if(EnemyRightHp < 40)EnemyRightConstantValue = 0 ;
            }
            if(value == 2){
                EnemyLeftHp -= 1  ;
                if(EnemyLeftHp < 40)EnemyLeftConstantValue = 0 ;
            }
            
        }
        
        if(CheckCollision2()){
            if(value == 0){
                UserHealth -= 1 ; 
                if(UserHealth <= 0){
                    JOptionPane.showMessageDialog(this,"DEAD") ; 
                    System.exit(0) ; 
                }
            }
            if(value == 1){
                UserHealth -= 1 ;
                if(UserHealth <= 0){
                    JOptionPane.showMessageDialog(this,"DEAD") ; 
                    System.exit(0) ; 
                }
            }
            if(value == 2){
                UserHealth -= 1 ;
                if(UserHealth <= 0){
                    JOptionPane.showMessageDialog(this,"DEAD") ; 
                    System.exit(0) ; 
                }
            }
            
        }
        
        for(Fire fire : fires){
            if(fire.getFirePositionY() < 0)fires.remove(fire) ;
        }
        for(EnemyFire enemyfire : enemyfires){
            if(enemyfire.getEnemyFirePositionY() > 700)enemyfires.remove(enemyfire) ;
        }
        for(EnemyRightFire enemyrightfire : enemyrightfires){
            if(enemyrightfire.getEnemyRightFirePositionX() < 0)enemyrightfires.remove(enemyrightfire) ;
        }
        for(EnemyLeftFire enemyleftfire : enemyleftfires){
            if(enemyleftfire.getEnemyLeftFirePositionX() > 1000)enemyleftfires.remove(enemyleftfire) ;
        }
        //  REMOVE
        
        if(time % 70 == 0) {
            enemyfires.add(new EnemyFire(EnemyPositionX + 20 , 50)) ;
            enemyrightfires.add(new EnemyRightFire(935 , EnemyRightPositionY + 20 )) ;
            enemyleftfires.add(new EnemyLeftFire(50,EnemyLeftPositionY + 20 )) ;
        }
        
        for(Fire fire : fires)g.drawImage(Fire , fire.getFirePositionX() , fire.getFirePositionY() , 32 , 32 , this) ;
        
        if(EnemyConstantValue == 0 && EnemyRightConstantValue == 0 && EnemyLeftConstantValue == 0 && UserHealth > 0){
            JOptionPane.showMessageDialog(this,"Tüm düşmanları katlettin") ; 
            System.exit(0) ;    
        }
        
        g.setColor(Color.white) ;
        g.drawString("User Health : " + UserHealth , 450 , 350 );
    }
    @Override
    public void repaint() {
        super.repaint();
    }
    //KEY EVENTS
    @Override
    public void keyTyped(KeyEvent ke) {   
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        int e = ke.getKeyCode() ; 
        if(e == KeyEvent.VK_W && SpaceShipPositionY > 0) SpaceShipPositionY -= SpaceShipConstantValue ;
        else if(e == KeyEvent.VK_S && SpaceShipPositionY < 700) SpaceShipPositionY += SpaceShipConstantValue ;
        else if(e == KeyEvent.VK_A && SpaceShipPositionX > 0) SpaceShipPositionX -= SpaceShipConstantValue ;
        else if(e == KeyEvent.VK_D && SpaceShipPositionX < 935) SpaceShipPositionX += SpaceShipConstantValue ;
        else if(e == KeyEvent.VK_SPACE) fires.add(new Fire(SpaceShipPositionX + 20 , SpaceShipPositionY - 20)) ;
    }
    @Override
    public void keyReleased(KeyEvent ke) {
    }
    //ACTİON EVENTS
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        EnemyLeftPositionY += EnemyLeftConstantValue ; 
        EnemyRightPositionY += EnemyRightConstantValue ; 
        EnemyPositionX += EnemyConstantValue ;
        
        moveIt() ;
        
        for(Fire fire : fires) fire.setFirePositionY(fire.getFirePositionY() - FireConstantValue) ;
        for(EnemyFire enemyfire : enemyfires) enemyfire.setEnemyFirePositionY(enemyfire.getEnemyFirePositionY() + FireConstantValue) ;
        for(EnemyRightFire enemyrightfire : enemyrightfires) enemyrightfire.setEnemyRightFirePositionX(enemyrightfire.getEnemyRightFirePositionX() - FireConstantValue) ;
        for(EnemyLeftFire enemyleftfire : enemyleftfires) enemyleftfire.setEnemyLeftFirePositionX(enemyleftfire.getEnemyLeftFirePositionX() + FireConstantValue) ;
        
        repaint();
    }
}