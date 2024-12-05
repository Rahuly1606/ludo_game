package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Player class to store player information
class Player {
    int height,width,status,coin;
    Pawn[] pa=new Pawn[4]; // Array of 4 pawns for each player
    public Player(int height,int width) {
        status=-1;
        coin=0;
        for(int i=0;i<4;i++) { // Initializing pawns for each player
            pa[i]=new Pawn(height,width);
        }
    }
    public void draw(Graphics2D g) {
    }
}

// Pawn class to store pawn information
class Pawn {
    int x,y;
    int current;
    int height,width;
    public Pawn(int h,int w){ // Constructor to initialize pawn
        current=-1;
        x=-1;
        y=-1;
        height=h;
        width=w;
    }
    // Function to draw pawn on board
    public void draw(Graphics2D g, int i, int j,int play) {
        if(current==-1) { // If pawn is not on board
            int temp1=80+(height/2),temp2=50+(width/2); // Initial position of pawn
            x=i; // x coordinate of pawn
            y=j; // y coordinate of pawn
            if(play==0) { // If player 1
                g.setColor(Color.RED); // Color of pawn
            }
            else if(play==1) { // If player 2
                g.setColor(Color.GREEN); // Color of pawn
            }
            else if(play==2) { // If player 3
                g.setColor(Color.YELLOW); // Color of pawn
            }
            else if(play==3) { // If player 4
                g.setColor(Color.BLUE); // Color of pawn
            }
            g.fillOval(temp1+5+(i*width),temp2+5+(j*height),width-10,height-10); // Drawing pawn on board
            g.setStroke(new BasicStroke(2)); // Thickness of border
            g.setColor(Color.BLACK); // Color of border
            g.drawOval(temp1+5+(i*width),temp2+5+(j*height),width-10,height-10); // Drawing border of pawn
        }
        else
        { // If pawn is on board
            int temp1=80,temp2=50; // Initial position of board
            x=Path.ax[play][current]; // x coordinate of pawn
            y=Path.ay[play][current]; // y coordinate of pawn
            if(play==0) {
                g.setColor(Color.RED);
            }
            else if(play==1) {
                g.setColor(Color.GREEN);
            }
            else if(play==2) {
                g.setColor(Color.YELLOW);
            }
            else if(play==3) {
                g.setColor(Color.BLUE);
            }
            g.fillOval(temp1+5+(x*width),temp2+5+(y*height),width-10,height-10); // Drawing pawn on board
            g.setStroke(new BasicStroke(2)); // Thickness of border
            g.setColor(Color.BLACK);
            g.drawOval(temp1+5+(x*width),temp2+5+(y*height),width-10,height-10); // Drawing border of pawn
        }
    }
}

// Path class to store path information
class Path {
    static int[][] ax= { // x coordinates of path for each player
            {1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6},
            {8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,7,7,7,7,7,7},
            {13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,13,12,11,10,9,8},
            {6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,7,7,7,7,7,7}
    };
    static int[][] ay= { // y coordinates of path for each player
            {6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,7,7,7,7,7,7},
            {1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6},
            {8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,7,7,7,7,7,7},
            {13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,13,12,11,10,9,8}
    };
    static int[][] initialx= { // x coordinates of initial position of each player
            {1,1,3,3},
            {10,10,12,12},
            {10,10,12,12},
            {1,1,3,3}
    };
    static int[][] initialy= { // y coordinates of initial position of each player
            {1,3,1,3},
            {1,3,1,3},
            {10,12,10,12},
            {10,12,10,12}
    };
}

// Layout class to draw board
class Layout {
    int x,y,width,height; // x,y coordinates and width and height of board
    public Layout(int xi,int yi) {
        x=xi;
        y=yi;
        width=30;
        height=30;
    }

    // Method to draw board
    public void draw(Graphics2D g){
        g.setColor(Color.WHITE); // Color of background of board
        g.fillRect(x,y,15*width,15*height); // Drawing background of board
        for(int i=0;i<6;i++) { // drawing all the inner squares
            g.setColor(Color.RED);
            g.fillRect(x+(i*width),y, width, height);
            g.fillRect(x, y+(i*height), width, height);
            g.fillRect(x+(i*width),y+(5*height), width, height);
            g.fillRect(x+(5*width), y+(i*height), width, height);
            g.setColor(Color.GREEN);
            g.fillRect(x+((i+9)*width),y, width, height);
            g.fillRect(x+(9*width), y+(i*height), width, height);
            g.fillRect(x+((i+9)*width),y+(5*height), width, height);
            g.fillRect(x+(14*width), y+(i*height), width, height);
            g.setColor(Color.YELLOW);
            g.fillRect(x+((i+9)*width),y+(9*height), width, height);
            g.fillRect(x+(9*width), y+((i+9)*height), width, height);
            g.fillRect(x+((i+9)*width),y+(14*height), width, height);
            g.fillRect(x+(14*width), y+((i+9)*height), width, height);
            g.setColor(Color.BLUE);
            g.fillRect(x+(i*width),y+(9*height), width, height);
            g.fillRect(x, y+((i+9)*height), width, height);
            g.fillRect(x+(i*width),y+(14*height), width, height);
            g.fillRect(x+(5*width), y+((i+9)*height), width, height);
        }
        for(int i=1;i<6;i++) { // Drawing the inner boxes
            g.setColor(Color.RED);
            g.fillRect(x+(i*width),y+(7*height), width, height);
            g.setColor(Color.YELLOW);
            g.fillRect(x+((8+i)*width),y+(7*height), width, height);
            g.setColor(Color.GREEN);
            g.fillRect(x+(7*width),y+(i*height), width, height);
            g.setColor(Color.BLUE);
            g.fillRect(x+((7)*width),y+((8+i)*height), width, height);
        }
        g.setColor(Color.RED);
        g.fillRect(x+(1*width),y+(6*height), width, height);
        g.setColor(Color.YELLOW);
        g.fillRect(x+((13)*width),y+(8*height), width, height);
        g.setColor(Color.GREEN);
        g.fillRect(x+(8*width),y+(1*height), width, height);
        g.setColor(Color.BLUE);
        g.fillRect(x+((6)*width),y+((13)*height), width, height);
        int temp1=x+45,temp2=y+45;
        for(int i=0;i<2;i++) { // Drawing the outer boxes
            for(int j=0;j<2;j++) {
                g.setColor(Color.RED);
                g.fillRect(temp1+(2*i*width),temp2+(2*j*height), width, height);
                g.setColor(Color.YELLOW);
                g.fillRect(temp1+(2*i*width)+9*width,temp2+(2*j*height)+9*height, width, height);
                g.setColor(Color.GREEN);
                g.fillRect(temp1+(2*i*width)+9*width,temp2+(2*j*height)+0*height, width, height);
                g.setColor(Color.BLUE);
                g.fillRect(temp1+(2*i*width)+0*width,temp2+(2*j*height)+9*height, width, height);
            }
        }
        g.setColor(Color.RED);
        int xpoints0[] = {x+(6*width),x+(6*width), x+15+(7*width)};
        int ypoints0[] = {y+(6*height),y+(9*height),y+15+(7*width)};
        int npoints = 3;
        g.fillPolygon(xpoints0, ypoints0, npoints); // Drawing the triangle in the center
        g.setColor(Color.YELLOW);
        int xpoints1[] = {x+(9*width),x+(9*width), x+15+(7*width)};
        int ypoints1[] = {y+(6*height),y+(9*height),y+15+(7*width)};
        int npoints1= 3;
        g.fillPolygon(xpoints1, ypoints1, npoints1); // Drawing the triangle in the center
        g.setColor(Color.GREEN);
        int xpoints2[] = {x+(6*width),x+(9*width), x+15+(7*width)};
        int ypoints2[] = {y+(6*height),y+(6*height),y+15+(7*width)};
        int npoints2= 3;
        g.fillPolygon(xpoints2, ypoints2, npoints2); // Drawing the triangle in the center
        g.setColor(Color.BLUE);
        int xpoints3[] = {x+(6*width),x+(9*width), x+15+(7*width)};
        int ypoints3[] = {y+(9*height),y+(9*height),y+15+(7*width)};
        int npoints3= 3;
        g.fillPolygon(xpoints3, ypoints3, npoints3); // Drawing the triangle in the center
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        for(int i=0;i<3;i++) { // Drawing the outer boxes
            for(int j=0;j<6;j++) {
                g.drawRect(x+((i+6)*width),y+(j*height), width, height);
                g.drawRect(x+((j)*width),y+((i+6)*height), width, height);
                g.drawRect(x+((i+6)*width),y+((j+9)*height), width, height);
                g.drawRect(x+((j+9)*width),y+((i+6)*height), width, height);
            }
        }
        g.drawRect(x+((1)*width),y+(1*height),4*width,4*height);
        g.drawRect(x+((10)*width),y+(1*height),4*width,4*height);
        g.drawRect(x+((1)*width),y+(10*height),4*width,4*height);
        g.drawRect(x+((10)*width),y+(10*height),4*width,4*height);
        g.drawRect(x,y,15*width,15*height);
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                g.drawRect(temp1+(2*i*width),temp2+(2*j*height), width, height);
                g.drawRect(temp1+(2*i*width)+9*width,temp2+(2*j*height)+9*height, width, height);
                g.drawRect(temp1+(2*i*width)+9*width,temp2+(2*j*height)+0*height, width, height);
                g.drawRect(temp1+(2*i*width)+0*width,temp2+(2*j*height)+9*height, width, height);
            }
        }
        g.drawPolygon(xpoints0, ypoints0, npoints);
        g.drawPolygon(xpoints1, ypoints1, npoints1);
        g.drawPolygon(xpoints2, ypoints2, npoints2);
        g.drawPolygon(xpoints3, ypoints3, npoints3);
        g.drawOval(x+5+(6*width),y+5+(2*height),width-10,height-10); // Drawing the circles in the center
        g.drawOval(x+5+(12*width),y+5+(6*height),width-10,height-10); // Drawing the circles in the center
        g.drawOval(x+5+(8*width),y+5+(12*height),width-10,height-10);
        g.drawOval(x+5+(2*width),y+5+(8*height),width-10,height-10);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        g.drawString("RED", 90, 35); // Drawing the text on top of the boxes
        g.drawString("GREEN", 370, 35);
        g.drawString("Blue", 90, 540);
        g.drawString("Yellow", 370, 540);
        g.setFont(new Font("MV Boli", Font.BOLD, 30));
        g.drawString("Press enter to roll dice", 550,150);
        g.drawString("Click on the token to move", 550,200);
    }
}

// This is the class for initializing the player positons
class Build_Player {
    Player[] pl=new Player[4];
    int[][] initialx= { // This is the array for the initial x positions of the players
            {1,1,3,3},
            {10,10,12,12},
            {10,10,12,12},
            {1,1,3,3}
    };
    int[][] initialy= { //This is the array for the initial y positions of the players
            {1,3,1,3},
            {1,3,1,3},
            {10,12,10,12},
            {10,12,10,12}
    };
    // This is the constructor for initializing the player positions
    public Build_Player(int height, int width) {
        for(int i=0;i<4;i++) {
            pl[i]=new Player(height,width);
        }
    }
    // This is the method for drawing the players
    public void draw(Graphics2D g) {
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                pl[i].pa[j].draw(g,initialx[i][j],initialy[i][j],i);
            }
        }
    }

}

// This is the class for the the game moves
class GameMoves extends JPanel implements KeyListener, ActionListener,MouseListener{
    private static final long serialVersionUID = 1L;
    Layout la; // This is the object for the layout class
    Build_Player p; // This is the object for the build player class
    Timer time; // This is the object for the timer class
    int delay=10; // This is the delay for the timer
    int current_player,dice; // This is the variable for the current player and the dice
    int flag=0,roll,kill=0; // This is the flag for the dice roll and the kill variable

    public GameMoves() {
        setFocusTraversalKeysEnabled(false);
        requestFocus();
        current_player=0; // first player is set to red
        la = new Layout(80,50);
        p=new Build_Player(la.height,la.width);
        dice=0;
        flag=0;
        roll=0;
        kill=0;
    }

    // This is the method for drawing the game

    public void paint(Graphics g) {
        la.draw((Graphics2D)g);
        p.draw((Graphics2D)g);
        if(p.pl[current_player].coin==4) { // This is the condition for the winner
            g.setColor(Color.WHITE);
            g.fillRect(590, 100, 380,130);
            if(current_player==0) {
                g.setColor(Color.RED);
            }
            else if(current_player==1) {
                g.setColor(Color.GREEN);
            }
            else if(current_player==2) {
                g.setColor(Color.YELLOW);
            }
            else if(current_player==3) {
                g.setColor(Color.BLUE);
            }
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString("Player "+(current_player+1)+" wins.", 600, 350);
            g.drawString("Congratulations.", 600, 400);
            current_player=0;
            la = new Layout(80,50);
            p=new Build_Player(la.height,la.width);
            dice=0;
            flag=0;
            roll=0;
            kill=0;
        }
        else if(dice!=0) { // This is the condition for the dice roll

            g.setColor(Color.pink);
            g.fillRect(590, 300, 260,200);
            if(current_player==0) {
                g.setColor(Color.RED);
            }
            else if(current_player==1) {
                g.setColor(Color.GREEN);
            }
            else if(current_player==2) {
                g.setColor(Color.YELLOW);
            }
            else if(current_player==3) {
                g.setColor(Color.BLUE);
            }

            g.setFont(new Font("MV Boli", Font.BOLD, 30));
            if(current_player==0){
                g.drawString("RED's turn:", 600, 350);
            }
            else if(current_player==1){
                g.drawString("GREEN's turn:", 600, 350);
            }
            else if(current_player==2){
                g.drawString("YELLOW's turn:", 600, 350);
            }
            else if(current_player==3){
                g.drawString("BLUE's turn:", 600, 350);
            }

            // draw dice
            g.setColor(Color.BLACK);
            g.drawRect(670, 370, 100, 100);
            g.setFont(new Font("MV Boli", Font.BOLD, 50));
            g.drawString(""+dice, 700, 440);
        }
        if(flag==0&&dice!=0&&dice!=6&&kill==0) {
            current_player=(current_player+1)%4;
        }
        kill=0;
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER&&flag==0) { // if enter is pressed the dice is rolled
            roll=0;
            dice=1 + (int)(Math.random() * 6); // random number is generated for the dice roll
            repaint();
            for(int i=0;i<4;i++) {
                if(p.pl[current_player].pa[i].current!=-1&&p.pl[current_player].pa[i].current!=56&&(p.pl[current_player].pa[i].current+dice)<=56) {
                    flag=1;
                    break;
                }
            }
            if(flag==0&&dice==6) {
                for(int i=0;i<4;i++) {
                    if(p.pl[current_player].pa[i].current==-1) {
                        flag=1;
                        break;
                    }
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if(flag==1) {
            int x=e.getX();
            int y=e.getY();
            x=x-80;
            y=y-50;
            x=x/30;
            y=y/30;
            int value=-1;
            //System.out.println(x+" "+y);
            if(dice==6) { // if dice is 6
                for(int i=0;i<4;i++) {
                    if(p.pl[current_player].pa[i].x==x&&p.pl[current_player].pa[i].y==y&&(p.pl[current_player].pa[i].current+dice)<=56) {
                        value=i;
                        flag=0;
                        break;
                    }
                }
                if(value!=-1) { // if the player has a coin on the clicked position
                    p.pl[current_player].pa[value].current+=dice;
                    if(p.pl[current_player].pa[value].current==56) {
                        p.pl[current_player].coin++;
                    }
                    int k=0;
                    int hou=p.pl[current_player].pa[value].current;
                    if((hou%13)!=0&&(hou%13)!=8&&hou<51)
                    {
                        for(int i=0;i<4;i++) {
                            if(i!=current_player) {
                                for(int j=0;j<4;j++) {
                                    int tem1=Path.ax[current_player][p.pl[current_player].pa[value].current],tem2=Path.ay[current_player][p.pl[current_player].pa[value].current];
                                    if(p.pl[i].pa[j].x==tem1&&p.pl[i].pa[j].y==tem2) {
                                        p.pl[i].pa[j].current=-1;
                                        kill=1;
                                        k=1;
                                        break;
                                    }
                                }
                            }
                            if(k==1)
                                break;
                        }
                    }
                }
                else { // if the player does not have a coin on the clicked position
                    for(int i=0;i<4;i++) {
                        if(p.pl[current_player].pa[i].current==-1) {
                            p.pl[current_player].pa[i].current=0;
                            flag=0;
                            break;
                        }
                    }
                }
            }
            else { // if dice is not 6
                for(int i=0;i<4;i++) {
                    if(p.pl[current_player].pa[i].x==x&&p.pl[current_player].pa[i].y==y&&(p.pl[current_player].pa[i].current+dice)<=56) {
                        value=i;
                        flag=0;
                        break;
                    }
                }
                if(value!=-1) { // if the player has a coin on the clicked position
                    p.pl[current_player].pa[value].current+=dice;
                    if(p.pl[current_player].pa[value].current==56) {
                        p.pl[current_player].coin++;
                    }
                    int k=0;
                    int hou=p.pl[current_player].pa[value].current;
                    if((hou%13)!=0&&(hou%13)!=8&&hou<51)
                    {
                        for(int i=0;i<4;i++) {
                            if(i!=current_player) {
                                for(int j=0;j<4;j++) {
                                    int tem1=Path.ax[current_player][p.pl[current_player].pa[value].current],tem2=Path.ay[current_player][p.pl[current_player].pa[value].current];
                                    if(p.pl[i].pa[j].x==tem1&&p.pl[i].pa[j].y==tem2) {
                                        p.pl[i].pa[j].current=-1;
                                        kill=1;
                                        k=1;
                                        break;
                                    }
                                }
                            }
                            if(k==1)
                                break;
                        }
                    }
                }
            }
            repaint();
        }
    }

    // these functions are not used but are compulsory to be defined as they are abstract functions of MouseListener
    public void actionPerformed(ActionEvent e) {
    }


    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }


    public void mousePressed(MouseEvent e) {
    }


    public void mouseReleased(MouseEvent arg0) {
    }
}

class gmaewins {
    // Run the application from here
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setBounds(10,10,1000,600);
        jframe.setBackground(new Color(0XB2A4FF));
        jframe.setTitle("LUDO");
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameMoves gm = new GameMoves();
        gm.setFocusable(true);
        gm.addKeyListener(gm);
        gm.addMouseListener(gm);
        jframe.add(gm);
        jframe.setVisible(true);
    }
}