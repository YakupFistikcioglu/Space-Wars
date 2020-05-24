
package space.wars;

import javax.swing.JFrame;

public class Window extends JFrame{
    
    public Window(String title){
        super(title) ; 
    }
    public static void main(String[] args) {
        
        JFrame GameWindow = new JFrame("SPACE WARS") ; 
        
        GameWindow.setResizable(false) ; 
        GameWindow.setFocusable(false);
        GameWindow.setSize(1000 , 700) ;
        GameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameWindow.setLocationRelativeTo(null);
        
        Game game = new Game() ;
        
        game.requestFocus() ; 
        game.addKeyListener(game);
        game.setFocusable(true) ; 
        game.setFocusTraversalKeysEnabled(false) ; 
        
        GameWindow.add(game) ; 
        
        GameWindow.setVisible(true) ;
        
    }
}
