import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**  Dima Bobrov */
public class TicTacToe extends JPanel{

    private Game game;

    public TicTacToe(int w, int h){
        setSize(w, h);
        game = new Game();
        setupMouse();


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        game.draw(g2);
    }

    public void setupMouse(){
        addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                game.processClick(y/200,x/200);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        int width = 600;
        int height = 600;
        frame.setPreferredSize(new Dimension(width, height + 24));


        JPanel panel = new TicTacToe(width, height);
        panel.setFocusable(true);
        panel.grabFocus();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}