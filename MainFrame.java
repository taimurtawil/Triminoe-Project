import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

  
class MyFrame extends JFrame implements ActionListener{
    private Container c;
    private JLabel title;
    private JLabel frameSize;
    private JTextField tframeSize;
    private JLabel rmvHoleA;
    private JTextField trmvHoleA;
    private JLabel rmvHoleB;
    private JTextField trmvHoleB;
    private JButton sub;
    private static int a;
    private static int b;
    private static int n;
    
    
    public MyFrame(){
        setTitle("Frame Settings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 90, 900, 600);;
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Frame Settings");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        frameSize = new JLabel("Size(n)");
        frameSize.setFont(new Font("Arial", Font.PLAIN, 20));
        frameSize.setSize(100, 20);
        frameSize.setLocation(100, 100);
        c.add(frameSize);

        tframeSize = new JTextField();
        tframeSize.setFont(new Font("Arial", Font.PLAIN, 15));
        tframeSize.setSize(190, 20);
        tframeSize.setLocation(200, 100);
        c.add(tframeSize);

        rmvHoleA = new JLabel("A");
        rmvHoleA.setFont(new Font("Arial", Font.PLAIN, 20));
        rmvHoleA.setSize(100,20);
        rmvHoleA.setLocation(100, 150);
        c.add(rmvHoleA);

        trmvHoleA = new JTextField();
        trmvHoleA.setFont(new Font("Arial", Font.PLAIN, 15));
        trmvHoleA.setSize(190, 20);
        trmvHoleA.setLocation(200, 150);
        c.add(trmvHoleA);

        rmvHoleB = new JLabel("B");
        rmvHoleB.setFont(new Font("Arial", Font.PLAIN, 20));
        rmvHoleB.setSize(100,20);
        rmvHoleB.setLocation(100, 200);
        c.add(rmvHoleB);

        trmvHoleB = new JTextField();
        trmvHoleB.setFont(new Font("Arial", Font.PLAIN, 15));
        trmvHoleB.setSize(190, 20);
        trmvHoleB.setLocation(200, 200);
        c.add(trmvHoleB);
        
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);
        setVisible(true);
    }
    public MyFrame(int n, int a, int b)throws Exception {
        
        setTitle("Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        int gridSize = (int) Math.pow(2, n);
        setLayout(new GridLayout(gridSize, gridSize));
        setVisible(true);
        JButton[][] arrButtons = new JButton[gridSize][gridSize];
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                arrButtons[i][j] = new JButton("("+ i + "," + j +")");
                add(arrButtons[i][j]);
            }
        }
        arrButtons[a][b].setBackground(Color.BLACK);
        Tri(n,0,0,a,b,arrButtons);

    }
    public static void Tri(int n, int i, int j, int a, int b, JButton[][] arrButtons)throws Exception{
        if(n==0 ){
            return;
        }
        Thread.sleep(1000);
        int length = (int)Math.pow(2,n)/2;
        int lengthd= length-1;
        int quad1Removedx;
        int quad2Removedx;
        int quad3Removedx;
        int quad4Removedx; 
        int quad1Removedy;
        int quad2Removedy;
        int quad3Removedy;
        int quad4Removedy;

        float hue = (float) Math.random();
        int rgb = Color.HSBtoRGB(hue,0.5f,0.5f);
        Color color = new Color(rgb);

        if(a < (length+i) && b < (length+j)){//quadrent 1
            quad1Removedx = a;
            quad1Removedy = b;
            quad2Removedx = length + i;
            quad2Removedy = lengthd + j;
            quad3Removedx = lengthd + i;
            quad3Removedy = length + j;
            quad4Removedx = length + i;
            quad4Removedy = length + j; 
            arrButtons[length + i][lengthd + j].setBackground(color);
            arrButtons[length + i][length + j].setBackground(color);
            arrButtons[lengthd + i][length + j].setBackground(color);

        }
        else if(a>=length+i && b < length+j){//quadrent 2
            quad1Removedx = lengthd + i;
            quad1Removedy = lengthd + j;
            quad2Removedx = a;
            quad2Removedy = b;
            quad3Removedx = lengthd + i;
            quad3Removedy = length + j;
            quad4Removedx = length + i;
            quad4Removedy = length + j; 
            arrButtons[lengthd + i][lengthd + j].setBackground(color);
            arrButtons[lengthd + i][length + j].setBackground(color);
            arrButtons[length + i][length + j].setBackground(color);
        }
        else if(a < length+i && b >= length+j){//quadrent 3
            quad1Removedx = lengthd + i;
            quad1Removedy = lengthd + j;
            quad2Removedx = length + i;
            quad2Removedy = lengthd + j;
            quad3Removedx = a;
            quad3Removedy = b;
            quad4Removedx = length + i;
            quad4Removedy = length + j;
            arrButtons[lengthd + i][lengthd + j].setBackground(color);
            arrButtons[length + i][lengthd + j].setBackground(color);
            arrButtons[length + i][length + j].setBackground(color);
        }
        else{//quadrent4
            quad1Removedx = lengthd + i;
            quad1Removedy = lengthd + j;
            quad2Removedx = length + i;
            quad2Removedy = lengthd + j;
            quad3Removedx = lengthd + i;
            quad3Removedy = length +j;
            quad4Removedx = a;
            quad4Removedy = b;
            arrButtons[length + i][lengthd + j].setBackground(color);
            arrButtons[lengthd + i][lengthd + j].setBackground(color);
            arrButtons[lengthd + i][length + j].setBackground(color);
        }
        Tri(n-1, i, j, quad1Removedx, quad1Removedy, arrButtons);
        Tri(n-1, i + (int)Math.pow(2,n)/2, j, quad2Removedx, quad2Removedy, arrButtons); 
        Tri(n-1, i, j + (int)Math.pow(2,n)/2, quad3Removedx, quad3Removedy, arrButtons);
        Tri(n-1, i + (int)Math.pow(2,n)/2, j + (int)Math.pow(2,n)/2, quad4Removedx, quad4Removedy, arrButtons);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == sub){
            n=Integer.parseInt(tframeSize.getText());
            a=Integer.parseInt(trmvHoleA.getText());
            b=Integer.parseInt(trmvHoleB.getText());
            this.dispose();
        }
    }
    public static void main(String[] args)throws Exception {
        MyFrame form = new MyFrame();
        Thread.sleep(18000);
        MyFrame board = new MyFrame(n, a, b);
    }
}