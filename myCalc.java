
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.function.Function;

public class myCalc implements ActionListener {
    JFrame frame;
    JTextField textField;
    JTextField textField2;
    
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[27];
    JRadioButton Radiobutton1 = new JRadioButton("Norm");
    JRadioButton  Radiobutton2 = new JRadioButton("Inverse");
       

    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton, modButton,percButton,srtButton,lnButton,logButton,piButton,inButton,eButton,sinButton,cosButton,tanButton,sinh,cosh,tanh;
    JButton cuberoot,yroot,etox,tentox;
    JPanel panel;
    JPanel panel2;

    Font myFont = new Font("SANSSERRIF", Font.PLAIN, 20);
    
    
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public myCalc() {
        
        frame = new JFrame("myCalc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(null);
        textField = new JTextField();
        textField2 = new JTextField();
        textField.setBounds(10, 75, 840, 75);
        textField.setEditable(true);
        textField.setBackground(Color.darkGray);
        textField.setForeground(Color.white);
        textField.setBorder(new LineBorder(Color.BLACK));
        Radiobutton1.setBounds(25,10,100,30); 
        Radiobutton2.setBounds(125,10,100,30);  
        Radiobutton1.setFocusable(false);
        Radiobutton2.setFocusable(false);     
      
        ButtonGroup group = new ButtonGroup();
        group.add(Radiobutton1);
        group.add(Radiobutton2);
        group.add(sinButton);
        
        Radiobutton1.addActionListener(this);
        Radiobutton2.addActionListener(this);
        textField2.setBounds(550,50,300,25);
        textField2.setBorder(new LineBorder(Color.BLACK));
        textField2.setBackground(Color.darkGray);
        textField2.setForeground(Color.white);
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
        srtButton = new JButton("<html><sup style='font-size:20pt'>2</sup>&#8730x</html>");
        lnButton = new JButton("ln");
        logButton = new JButton("log");
        piButton = new JButton("Pi");
        inButton = new JButton("1/x");
        eButton = new JButton("e");
        sinButton= new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        sinh = new JButton("sinh");
        cosh = new JButton("cosh");
        tanh = new JButton("tanh");
        cuberoot = new JButton("<html><sup style='font-size:20pt'>3</sup>&#8730x</html>");
        yroot = new JButton("<html><sup style='font-size:20pt'>y</sup>&#8730x</html>");
        etox = new JButton("<html><sub style='font-size:20pt'>e</sub>x</html>");
        tentox = new JButton("<html><sub style='font-size:20pt'>10</sub>x</html>");


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
        functionButtons[19]= tanButton;
        functionButtons[20]= sinh;
        functionButtons[21]=cosh;
        functionButtons[22]= tanh;
        functionButtons[23]=cuberoot;
        functionButtons[24]=yroot;
        functionButtons[25]=etox;
        functionButtons[26]=tentox;


        for (int i = 0; i < 27; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.DARK_GRAY);
            functionButtons[i].setForeground(Color.WHITE);
            functionButtons[i].setBorderPainted(true);
            functionButtons[i].setBorder(new LineBorder(Color.BLACK));
           // functionButtons[i].setOpaque(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.GRAY);
           
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setBorder(new LineBorder(Color.BLACK));

        }   

       
        delButton.setBounds(50,500,100,50);
        clrButton.setBounds(150,500,100,50);
        
       
        textField.setFont(myFont);
      
        mulButton.setBackground(Color.orange);
        divButton.setBackground(Color.orange);
        addButton.setBackground(Color.orange);
        subButton.setBackground(Color.orange);
        equButton.setBackground(Color.ORANGE);

        mulButton.setForeground(Color.WHITE);
        divButton.setForeground(Color.WHITE);
        addButton.setForeground(Color.WHITE);
        subButton.setForeground(Color.WHITE);
        
        panel = new JPanel();
        panel2= new JPanel();
        panel.setBounds(10, 150, 500, 275);
        panel2.setBounds(510,150,340,275);
        panel2.setLayout(new GridLayout(5, 6, 1, 1));
         panel2.setBackground(Color.darkGray);
        panel.setLayout(new GridLayout(3, 6, 1, 1));
        panel.setBackground(Color.darkGray);
        panel2.add(numberButtons[9]);
        panel2.add(numberButtons[8]);
        panel2.add(mulButton);
        panel2.add(numberButtons[7]);
        panel.add(percButton);
        panel.add(piButton);
        panel.add(inButton);
        panel2.add(numberButtons[6]);
        panel.add(eButton);
        panel.add(delButton);
        panel2.add(addButton);
        panel2.add(numberButtons[5]);
        panel2.add(numberButtons[4]);
        panel2.add(equButton);
        panel2.add(numberButtons[3]);
        panel2.add(numberButtons[2]);
        panel2.add(divButton);
        panel2.add(numberButtons[1]);
        panel.add(modButton);
        panel.add(decButton);
        panel.add(negButton); 
        panel.add(sinh);
        panel.add(cosh);
        panel.add(tanh);
        panel.add(etox);
        panel.add(tentox);
        panel.add(cuberoot);
        panel.add(yroot);
        frame.add(panel);
        frame.add(Radiobutton1);
        frame.add(Radiobutton2);
        frame.add(panel2);
        frame.add(delButton);
        panel.add(srtButton);
        frame.add(clrButton);
        panel.add(sinButton);
        panel.add(cosButton);

        panel.add(tanButton);;
        panel.add(lnButton);
        panel.add(logButton);
        panel2.add(numberButtons[0]);
        panel2.add(subButton);
        frame.getRootPane().setDefaultButton(equButton);
        
        frame.add(textField);
        frame.add(textField2);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        myCalc mymyCalc = new myCalc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Radiobutton2.isSelected()) {
            sinButton.setForeground(Color.orange);
            cosButton.setForeground(Color.orange);
            tanButton.setForeground(Color.orange);
            sinButton.setText("<html>sin<sup style='font-size:20pt'>-1<sup></html>");
          
            cosButton.setText("<html>cos<sup style='font-size:20pt'>-1<sup></html>");
            tanButton.setText("<html>tan<sup style='font-size:20pt'>-1<sup></html>");
            if (e.getSource() == sinButton) {
                double mysin = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.asin(mysin)));
            }
            if (e.getSource() == cosButton) {
                double mycos = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.acos(mycos)));
            }
            if (e.getSource() == tanButton) {
                double mytan = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.atan(mytan)));
            }
        }
        
        else if(Radiobutton1.isSelected()){
            sinButton.setForeground(Color.white);
            cosButton.setForeground(Color.white);
            tanButton.setForeground(Color.white);
            sinButton.setText("sin");
          
            cosButton.setText("cos");
            tanButton.setText("tan");
            if (e.getSource() == sinButton) {
                double mysin = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.sin(mysin)));
                textField2.setText("Sin"+"("+num1+")");
            }
            if (e.getSource() == cosButton) {
                double mycos = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.cos(mycos)));
                textField2.setText("Cos"+"("+num1+")");
            }
            if (e.getSource() == tanButton) {
                double mytan = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.tan(mytan)));
                textField2.setText("Tan"+"("+textField.getText()+")");
            }
        
        }
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
        if (e.getSource() == eButton) {
            double mye = Double.parseDouble(textField.getText());
            mye= mye*Math.E;
            textField.setText(String.valueOf(mye));
        }
        if (e.getSource() == etox) {
            double E = Double.parseDouble(textField.getText());
            E = Math.pow(Math.E,E);
            textField.setText(String.valueOf(E));
        }

        if (e.getSource() == srtButton) {
            double mysrt = Double.parseDouble(textField.getText());
            
            textField.setText(String.valueOf(Math.sqrt(mysrt)));
        }
        if (e.getSource() == cuberoot) {
            double mysrt = Double.parseDouble(textField.getText());
            
            textField.setText(String.valueOf(Math.cbrt(mysrt)));
        }
        if (e.getSource() == lnButton) {
            double myln = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.log(myln)));
        }
        if (e.getSource() == logButton) {
            double mylog = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.log10(mylog)));
        }
       
        if (e.getSource() == sinh) {
            double mysinh = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.sinh(mysinh)));
        }
        if (e.getSource() == cosh) {
            double mycosh = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.cosh(mycosh)));
        } if (e.getSource() == tanh) {
            double mytanh = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.tanh(mytanh)));
        }
        if (e.getSource() == piButton) {
            double mypi = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.PI*mypi));
        }
        if (e.getSource() == inButton) {
            double myin = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(1/myin));
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
        if (e.getSource() == yroot) {
            num1 = Double.parseDouble(textField.getText());
            operator = 'y';
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
                case 'y':
                    result = Math.round(Math.pow(num1,(1/(num2))));
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
