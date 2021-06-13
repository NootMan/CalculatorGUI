import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private static JFrame frame;
    private static JLayeredPane panel;
    private static JLabel bgLabel;
    private static JButton btZero;
    private static JButton btOne;
    private static JButton btTwo;
    private static JButton btThree;
    private static JButton btFour;
    private static JButton btFive;
    private static JButton btSix;
    private static JButton btSeven;
    private static JButton btEight;
    private static JButton btNine;
    private static JButton btPeriod;
    private static JButton btEquals;
    private static JButton btPlus;
    private static JButton btMinus;
    private static JButton btMultiply;
    private static JButton btClear;
    private static JButton btNegate;
    private static JButton btPercent;
    private static JButton btDivide;
    private static JLabel box;
    private static JLabel textBox;

    //Used in calculation
    private String a = "";              //stored as a string so I can concatenate easier with +=
    private String b = "";              //^
    private String c = "";              //kind of a useless variable since the math can be done inside the textbox.setText line, but whatever
    private String aOrb = "a";          //weird work around to have operators switch which variable is being worked on
    private String operation = "";      //stores the most recent operation

    public CalculatorGUI()
    {
        panel = new JLayeredPane();     //layered pane so I could put text over a custom border
        panel.setLayout(null);
        panel.setBounds(0, 0, 223, 348);

        frame = new JFrame("Math");
        frame.setIconImage(new ImageIcon("images/icon.png").getImage());
        frame.setSize(223, 348);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        bgLabel = new JLabel();
        bgLabel.setBounds(0,0, 223, 348);
        bgLabel.setBackground(new Color(89, 87, 86));
        bgLabel.setOpaque(true);
        panel.add(bgLabel, Integer.valueOf(0));

        // BUTTON EXAMPLE:
        // button1 = new JButton(new ImageIcon("images/button template.png"));
        // button1.setBounds(10, 30, 50, 50);
        // button1.setBorder(BorderFactory.createEmptyBorder());
        // button1.setFocusable(false);
        // panel.add(button1);

        //LARGE BUTTON SETUP, ALL THE SAME, JUST SKIM THROUGH
        btZero = new JButton(new ImageIcon("images/zero.png"));         //creates new button that looks like the specified image
        btZero.setBounds(2, 257, 101, 50);                              //sets the bounds where it can be clicked (x, y, width, height)
        btZero.setBorder(BorderFactory.createEmptyBorder());            //makes an empty border cause the default one is gross
        btZero.setFocusable(false);                                     //removes the dotted border that appears when you click something
        panel.add(btZero, Integer.valueOf(1));                          //adds the button to the panel, couldn't exist otherwise

        btPeriod = new JButton(new ImageIcon("images/period.png"));
        btPeriod.setBounds(104, 257, 50, 50);
        btPeriod.setBorder(BorderFactory.createEmptyBorder());
        btPeriod.setFocusable(false);
        panel.add(btPeriod, Integer.valueOf(1));

        btEquals = new JButton(new ImageIcon("images/equals.png"));
        btEquals.setBounds(155, 257, 50, 50);
        btEquals.setBorder(BorderFactory.createEmptyBorder());
        btEquals.setFocusable(false);
        panel.add(btEquals, Integer.valueOf(1));

        btOne = new JButton(new ImageIcon("images/one.png"));
        btOne.setBounds(2, 206, 50, 50);
        btOne.setBorder(BorderFactory.createEmptyBorder());
        btOne.setFocusable(false);
        panel.add(btOne, Integer.valueOf(1));

        btTwo = new JButton(new ImageIcon("images/two.png"));
        btTwo.setBounds(53, 206, 50, 50);
        btTwo.setBorder(BorderFactory.createEmptyBorder());
        btTwo.setFocusable(false);
        panel.add(btTwo, Integer.valueOf(1));

        btThree = new JButton(new ImageIcon("images/three.png"));
        btThree.setBounds(104, 206, 50, 50);
        btThree.setBorder(BorderFactory.createEmptyBorder());
        btThree.setFocusable(false);
        panel.add(btThree, Integer.valueOf(1));

        btPlus = new JButton(new ImageIcon("images/plus.png"));
        btPlus.setBounds(155, 206, 50, 50);
        btPlus.setBorder(BorderFactory.createEmptyBorder());
        btPlus.setFocusable(false);
        panel.add(btPlus, Integer.valueOf(1));

        btFour = new JButton(new ImageIcon("images/four.png"));
        btFour.setBounds(2, 155, 50, 50);
        btFour.setBorder(BorderFactory.createEmptyBorder());
        btFour.setFocusable(false);
        panel.add(btFour, Integer.valueOf(1));

        btFive = new JButton(new ImageIcon("images/five.png"));
        btFive.setBounds(53, 155, 50, 50);
        btFive.setBorder(BorderFactory.createEmptyBorder());
        btFive.setFocusable(false);
        panel.add(btFive, Integer.valueOf(1));

        btSix = new JButton(new ImageIcon("images/six.png"));
        btSix.setBounds(104, 155, 50, 50);
        btSix.setBorder(BorderFactory.createEmptyBorder());
        btSix.setFocusable(false);
        panel.add(btSix, Integer.valueOf(1));

        btMinus = new JButton(new ImageIcon("images/minus.png"));
        btMinus.setBounds(155, 155, 50, 50);
        btMinus.setBorder(BorderFactory.createEmptyBorder());
        btMinus.setFocusable(false);
        panel.add(btMinus, Integer.valueOf(1));

        btSeven = new JButton(new ImageIcon("images/seven.png"));
        btSeven.setBounds(2, 104, 50, 50);
        btSeven.setBorder(BorderFactory.createEmptyBorder());
        btSeven.setFocusable(false);
        panel.add(btSeven, Integer.valueOf(1));

        btEight = new JButton(new ImageIcon("images/eight.png"));
        btEight.setBounds(53, 104, 50, 50);
        btEight.setBorder(BorderFactory.createEmptyBorder());
        btEight.setFocusable(false);
        panel.add(btEight, Integer.valueOf(1));

        btNine = new JButton(new ImageIcon("images/nine.png"));
        btNine.setBounds(104, 104, 50, 50);
        btNine.setBorder(BorderFactory.createEmptyBorder());
        btNine.setFocusable(false);
        panel.add(btNine, Integer.valueOf(1));

        btMultiply = new JButton(new ImageIcon("images/multiply.png"));
        btMultiply.setBounds(155, 104, 50, 50);
        btMultiply.setBorder(BorderFactory.createEmptyBorder());
        btMultiply.setFocusable(false);
        panel.add(btMultiply, Integer.valueOf(1));

        btClear = new JButton(new ImageIcon("images/clear.png"));
        btClear.setBounds(2, 53, 50, 50);
        btClear.setBorder(BorderFactory.createEmptyBorder());
        btClear.setFocusable(false);
        panel.add(btClear, Integer.valueOf(1));
    
        btNegate = new JButton(new ImageIcon("images/negate.png"));
        btNegate.setBounds(53, 53, 50, 50);
        btNegate.setBorder(BorderFactory.createEmptyBorder());
        btNegate.setFocusable(false);
        panel.add(btNegate, Integer.valueOf(1));

        btPercent = new JButton(new ImageIcon("images/percent.png"));
        btPercent.setBounds(104, 53, 50, 50);
        btPercent.setBorder(BorderFactory.createEmptyBorder());
        btPercent.setFocusable(false);
        panel.add(btPercent, Integer.valueOf(1));

        btDivide = new JButton(new ImageIcon("images/divide.png"));
        btDivide.setBounds(155, 53, 50, 50);
        btDivide.setBorder(BorderFactory.createEmptyBorder());
        btDivide.setFocusable(false);
        panel.add(btDivide, Integer.valueOf(1));

        box = new JLabel(new ImageIcon("images/box.png"));
        box.setBounds(2, 2, 203, 50);
        box.setBorder(BorderFactory.createEmptyBorder());
        panel.add(box, Integer.valueOf(1));

        textBox = new JLabel("");
        textBox.setFont(new Font("Calibri", Font.PLAIN, 25));
        textBox.setVerticalAlignment(JLabel.CENTER);
        textBox.setBounds(5, 10, 197, 44);
        textBox.setBorder(BorderFactory.createEmptyBorder());
        panel.add(textBox, Integer.valueOf(2));

        //Makes all buttons functional
        ActionManager manager = new ActionManager();
        btZero.addActionListener(manager);
        btOne.addActionListener(manager);
        btTwo.addActionListener(manager);
        btThree.addActionListener(manager);
        btFour.addActionListener(manager);
        btFive.addActionListener(manager);
        btSix.addActionListener(manager);
        btSeven.addActionListener(manager);
        btEight.addActionListener(manager);
        btNine.addActionListener(manager);
        btPeriod.addActionListener(manager);
        btEquals.addActionListener(manager);
        btPlus.addActionListener(manager);
        btMinus.addActionListener(manager);
        btMultiply.addActionListener(manager);
        btDivide.addActionListener(manager);
        btPercent.addActionListener(manager);
        btNegate.addActionListener(manager);
        btClear.addActionListener(manager);

        frame.setVisible(true);
    }

    //class in a class that handles button actions
    private class ActionManager implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {   
            //CLEAR BUTTON
            if(e.getSource() == btClear)
            {
                textBox.setText("");
                aOrb = "a";
                a = "";
                b = "";
                c = "";
                //System.out.println("testing clearing");               //debug
            }
            //BUTTON 0
            else if(e.getSource() == btZero)
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                //decides which variable to work on
                if(aOrb == "a" && textBox.getText().length() < 14)      //14 is how many spaces are available in the box
                {
                    textBox.setText(textBox.getText() + 0);
                    a += "0";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 0);
                    b += "0";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON 1
            else if(e.getSource() == btOne)
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 1);
                    a += "1";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 1);
                    b += "1";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON 2
            else if(e.getSource() == btTwo)
            {
                
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 2);
                    a += "2";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 2);
                    b += "2";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON 3
            else if(e.getSource() == btThree)
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 3);
                    a += "3";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 3);
                    b += "3";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON 4
            else if(e.getSource() == btFour)
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 4);
                    a += "4";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 4);
                    b += "4";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON 5
            else if(e.getSource() == btFive)
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 5);
                    a += "5";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 5);
                    b += "5";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON 6
            else if(e.getSource() == btSix)
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 6);
                    a += "6";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 6);
                    b += "6";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON 7
            else if(e.getSource() == btSeven)
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 7);
                    a += "7";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 7);
                    b += "7";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON 8
            else if(e.getSource() == btEight)
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 8);
                    a += "8";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 8);
                    b += "8";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON 9
            else if(e.getSource() == btNine)
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 9);
                    a += "9";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + 9);
                    b += "9";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON PLUS
            //clears the text, 
            //sets aOrb to b if the variable being worked on was a,
            //sets operation to the button's operation
            //SAME FOR ALL OPERATION BUTTONS
            else if(e.getSource() == btPlus && a != "")             //code breaks if you try an operation when a is an empty string
            {
                textBox.setText("");
                if(aOrb == "a")
                {
                    aOrb = "b";
                }
                operation = "PLUS";
            }
            //BUTTON MINUS
            else if(e.getSource() == btMinus && a != "")
            {
                textBox.setText("");
                if(aOrb == "a")
                {
                    aOrb = "b";
                }
                operation = "MINUS";
            }
            //BUTTON MULTIPLY
            else if(e.getSource() == btMultiply && a != "")
            {
                textBox.setText("");
                if(aOrb == "a")
                {
                    aOrb = "b";
                }
                operation = "MULTIPLY";
            }
            //BUTTON DIVIDE
            else if(e.getSource() == btDivide && a != "")
            {
                textBox.setText("");
                if(aOrb == "a")
                {
                    aOrb = "b";
                }
                operation = "DIVIDE";
            }
            //BUTTON PERCENT
            else if(e.getSource() == btPercent && a != "")
            {
                textBox.setText("");
                operation = "PERCENT";
            }
            //BUTTON PERIOD
            else if(e.getSource() == btPeriod && a != "")
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + ".");
                    a += ".";
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText(textBox.getText() + ".");
                    b += ".";
                    System.out.println("b: " + b);
                }
            }
            //BUTTON NEGATE
            else if(e.getSource() == btNegate && a != "")
            {
                if(operation == "EQUALS")
                {
                    operation = "";
                    textBox.setText("");
                }
                if(aOrb == "a" && textBox.getText().length() < 14)
                {
                    textBox.setText("-" + textBox.getText());
                    a = "-" + a;
                    System.out.println("a: " + a);
                }
                else if(aOrb == "b" && textBox.getText().length() < 14)
                {
                    textBox.setText("-" + textBox.getText());
                    b = "-" + b;
                    System.out.println("b: " + b);
                }
            }
            //BUTTON EQUALS
            else if(e.getSource() == btEquals)
            {
                //handles operations
                if(operation == "PLUS")
                {
                    c = "" + (Double.parseDouble(a) + Double.parseDouble(b));
                    textBox.setText(c);
                }
                else if(operation == "MINUS")
                {
                    c = "" + (Double.parseDouble(a) - Double.parseDouble(b));
                    textBox.setText(c);
                }
                else if(operation == "MULTIPLY")
                {
                    c = "" + (Double.parseDouble(a) * Double.parseDouble(b));
                    textBox.setText(c);
                }
                else if(operation == "DIVIDE")
                {
                    c = "" + (Double.parseDouble(a) / Double.parseDouble(b));
                    textBox.setText(c);
                }
                else if(operation == "PERCENT")
                {
                    c = "" + (Double.parseDouble(a) / 100.0);
                    textBox.setText(c);
                }
                //resets everything without having to close and reopen the program
                operation = "EQUALS";
                aOrb = "a";
                c = "";
                a = "";
                b = "";
            }
        }
    }
}
