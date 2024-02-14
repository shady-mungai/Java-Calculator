
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class myCalc implements ActionListener {
    JFrame frame;
    JTextField textField;
    
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[19];

    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton, modButton,percButton,srtButton,lnButton,logButton,piButton,inButton,eButton,sinButton,cosButton;
    JPanel panel;

    Font myFont = new Font("Ariel", Font.PLAIN, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public myCalc() {
        
        frame = new JFrame("myCalc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(50, 25, 400, 50);
        textField.setEditable(true);
       

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("`-");
        modButton = new JButton("m");
        percButton = new JButton("%");
        srtButton = new JButton("sqrt");
        lnButton = new JButton("ln");
        logButton = new JButton("log");
        piButton = new JButton("Pi");
        inButton = new JButton("1/x");
        eButton = new JButton("e");
        sinButton= new JButton("sin");
        cosButton = new JButton("cos");


        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = delButton;
        functionButtons[5] = clrButton;
        functionButtons[6] = decButton;
        functionButtons[7] = equButton;
        functionButtons[8] = negButton;
        functionButtons[9] = modButton;
        functionButtons[10]= percButton;
        functionButtons[11]= srtButton;
        functionButtons[12]= lnButton;
        functionButtons[13]= logButton;
        functionButtons[14]= piButton;
        functionButtons[15]= inButton;
        functionButtons[16]= eButton;
        functionButtons[17]= sinButton;
        functionButtons[18]= cosButton;


        for (int i = 0; i < 19; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 400, 100, 50);
        clrButton.setBounds(250, 400, 100, 50);
        srtButton.setBounds(150,400,100,50);
        sinButton.setBounds(50,450,100,50);
        cosButton.setBounds(150,450,100,50);

        lnButton.setBounds(470,100,80,60);
        logButton.setBounds(470,180,80,60 );
        piButton.setBounds(470,260,80,60);
        inButton.setBounds(470,340,80,60);
        
        textField.setFont(myFont);
      

        panel = new JPanel();
        panel.setBounds(50, 100, 400, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.darkGray);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(delButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(negButton);
        panel.add(modButton);
        panel.add(percButton);
        panel.add(eButton); 
        frame.add(panel);
        frame.add(delButton);
        frame.add(srtButton);
        frame.add(clrButton);
        frame.add(sinButton);
        frame.add(cosButton);
        frame.add(lnButton);
        frame.add(logButton);
        frame.add(piButton);
        frame.add(inButton);
        frame.getRootPane().setDefaultButton(equButton);
        
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        myCalc mymyCalc = new myCalc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat(String.valueOf(".")));

        }
        
        if (e.getSource() == negButton) {
            double myneg = Double.parseDouble(textField.getText());
            myneg *= -1;
            textField.setText(String.valueOf(myneg));
        }
        if (e.getSource() == srtButton) {
            double mysrt = Double.parseDouble(textField.getText());
            mysrt *=1;
            textField.setText(String.valueOf(Math.sqrt(mysrt)));
        }
        if (e.getSource() == lnButton) {
            double myln = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.log(myln)));
        }
        if (e.getSource() == logButton) {
            double mylog = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.log10(mylog)));
        }
        if (e.getSource() == sinButton) {
            double mysin = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.sin(mysin)));
        }
        if (e.getSource() == cosButton) {
            double mycos = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.cos(mycos)));
        }
        if (e.getSource() == piButton) {
            double mypi = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.PI*mypi));
        }
        if (e.getSource() == inButton) {
            double myin = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(1/myin));
        }
        if (e.getSource() == eButton) {
            double mye = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf((Math.exp(mye))));
        }



        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        
        if (e.getSource() == percButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == modButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 'M';
            textField.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case 'M':
                   
                    result = num1 % num2;
                    break;
                case '%':
                    result = (num1+num2)/200;
                    break;   
                
            }
            textField.setText(String.valueOf(result));
            result = num1;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");

        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

    }
   
    
    
    
}
