import java.awt.*;

public class Game {

    private final int X = 1, O = -1;
    private int[][] board;
    private boolean isXTurn;
    private int count;

    public Game(){
        board = new int[3][3];
        isXTurn = true;
        count = 0;
    }

    public void draw(Graphics2D g2){
        for(int i = 200; i < 600; i+=200)
            g2.fillRect(i, 0, 5, 600);
        for(int i = 200; i < 600; i+=200)
            g2.fillRect(0, i, 600, 5);
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.RED);
        for(int r = 0; r < 600; r+=200)
            for(int c = 0; c < 600; c+=200)
                if(board[r/200][c/200] == O)
                    g2.drawOval(25 + c,25 + r,150,150);
        g2.setColor(Color.BLUE);
        for(int r = 0; r < 600; r+=200)
            for(int c = 0; c < 600; c+=200) {
                if(board[r/200][c/200] == X) {
                    g2.drawLine(200 * (c/200), 200 * (r/200), 200 * (c/200 + 1), 200 * (r/200 + 1));
                    g2.drawLine(200 * (c/200), 200 * (r/200 + 1), 200 * (c/200 + 1), 200 * (r/200));
                }
            }
        if(checkForWinner() == 1) {
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("arial black", Font.PLAIN, 50));
            g2.drawString("Player 1 Wins!", 125, 300);
            for(int r = 0; r < 3; r++)
                for(int c = 0; c < 3;c++)
                    board[r][c] = 0;
            count = 0;
        }
        if(checkForWinner() == -1) {
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("arial black", Font.PLAIN, 50));
            g2.drawString("Player 2 Wins!", 125, 300);
            for(int r = 0; r < 3; r++)
                for(int c = 0; c < 3;c++)
                    board[r][c] = 0;
            count = 0;
        }
        if(checkForWinner() == 0){
            if(count == 9) {
                g2.setFont(new Font("arial black", Font.PLAIN, 50));
                g2.setColor(Color.BLACK);
                g2.drawString("Draw!", 220, 300);
                count = 0;
                for(int r = 0; r < 3; r++)
                    for(int c = 0; c < 3;c++)
                        board[r][c] = 0;
            }
            }
    }


    public void processClick(int r, int c){
        count++;
        if(board[r][c] == 0) {
            if (isXTurn) {
                board[r][c] = X;
                isXTurn = false;
            } else {
                board[r][c] = O;
                isXTurn = true;
            }
        }
    }

    public int checkForWinner(){
        for(int r = 0; r < 3; r++)
            for(int c = 0; c < 3;c++){
                if(r == 0 && board[r][c] == board[r + 1][c] && board[r][c] == board[r + 2][c]){
                    if(board[r][c] == 1)
                        return 1;
                    if(board[r][c] == -1)
                        return -1;
                }
                if(c == 0 && board[r][c] == board[r][c + 1] && board[r][c] == board[r][c + 2]){
                    if(board[r][c] == 1)
                        return 1;
                    if(board[r][c] == -1)
                        return -1;
                }
                if(r == 0 && c == 0 && board[r][c] == board[r + 1][c + 1] && board[r][c] == board[r + 2][c + 2]){
                    if(board[r][c] == 1)
                        return 1;
                    if(board[r][c] == -1)
                        return -1;
                }
                if(r == 0 && c == 2 && board[r][c] == board[r + 1][c - 1] && board[r][c] == board[r + 2][c - 2]){
                    if(board[r][c] == 1)
                        return 1;
                    if(board[r][c] == -1)
                        return -1;
                }
            }
        return 0;
    }
}