import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    // Declare variables
	JFrame frame;          // Main calculator window
	JTextField textfield;  // Text field where numbers are displayed 
	JButton[] numberButtons =new JButton[10];
	JButton[] functionButton = new JButton[9];
	JButton addButton, subButton, mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;  // Panel where buttons are displayed
	
	Font myFont = new Font("Monospaced",Font.BOLD,25);  // Font used for all buttons and text field
	
	double num1=0,num2=0,result=0; // Variables for storing numbers and result of arithmetic operation
	char operator;
	
    Calculator(){
        // Create main calculator window
    	frame = new JFrame("Calcuator");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(420,560);
    	frame.setLayout(null);
    	
        // Create text field and set font
    	textfield = new JTextField();
    	textfield.setBounds(50,25,300,50);
    	textfield.setFont(myFont);
    	textfield.setEditable(false);

        // Create buttons for arithmetic operations
    	addButton = new JButton("+");
    	subButton = new JButton("-");
    	mulButton = new JButton("x");
    	divButton = new JButton("/");
    	decButton = new JButton(".");
    	equButton = new JButton("=");
    	delButton = new JButton("Del");
    	clrButton = new JButton("Clr");
    	negButton = new JButton("(-)");

        // Create array of function buttons and add them to ActionListener, set font, and disable focus
    	/*JButton[] functionButton = {addButton, subButton,mulButton, 
    	 * divButton, decButton, equButton, delButton, clrButton}; 
    	 *  same as */
    	functionButton[0]=addButton;
    	functionButton[1]=subButton;
    	functionButton[2]=mulButton;
    	functionButton[3]=divButton;
    	functionButton[4]=decButton;
    	functionButton[5]=equButton;
    	functionButton[6]=delButton;
    	functionButton[7]=clrButton;
    	functionButton[8]=negButton;
    	
    	// Loop through the functionButton array
    	for(int i=0;i<9;i++) {
    	    // Add an action listener to each button, with the current class as the listener
    		functionButton[i].addActionListener(this);
    	    // Set the font of each button to myFont
    		functionButton[i].setFont(myFont);
    		functionButton[i].setFocusable(false);
    		}
    	
        // Create buttons for numbers 0-9, add them to ActionListener, set font, and disable focus
    	for(int i=0;i<10;i++) {
    		numberButtons[i] = new JButton(String.valueOf(i));
    		numberButtons[i].addActionListener(this);
    		numberButtons[i].setFont(myFont);
    		numberButtons[i].setFocusable(false);
    		}
    	
        // Set positions of buttons
    	negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
    	
        // Create panel to hold buttons and set layout
    	panel = new JPanel();
    	panel.setBounds(50, 100, 300, 300);
    	panel.setLayout(new GridLayout(4,4,10,10));
    	
        // Add buttons to panel in correct order
    	panel.add(numberButtons[1]);
    	panel.add(numberButtons[2]);
    	panel.add(numberButtons[3]);
    	panel.add(addButton);
    	//kaysali ster hna ;) so katrjae lstar
    	panel.add(numberButtons[4]);
    	panel.add(numberButtons[5]);
    	panel.add(numberButtons[6]);
    	panel.add(subButton);
    	panel.add(numberButtons[7]);
    	panel.add(numberButtons[8]);
    	panel.add(numberButtons[9]);
    	panel.add(mulButton);
    	// . 0 = x 
    	panel.add(decButton);
    	panel.add(numberButtons[0]);
    	panel.add(equButton);
    	panel.add(divButton);
    	
        // Add panel and neg del clr texfield to frame
    	frame.add(panel);
    	frame.add(negButton);
    	frame.add(delButton);
    	frame.add(clrButton); 
    	frame.add(textfield);
    	frame.setVisible(true);
    }
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	// Check which number button is pressed and update the text field with the number.
    	for(int i=0;i<10;i++) {
    		
    		if(e.getSource()==numberButtons[i]) {
    			textfield.setText(textfield.getText().concat(String.valueOf(i)));
    		}
    	}
    	// Check if decimal button is pressed and add a decimal point to the text field.
    		if(e.getSource()==decButton) {
    			textfield.setText(textfield.getText().concat("."));

    		}
    		if(e.getSource()==addButton) {
    			num1 =Double.parseDouble(textfield.getText());
    			operator='+';
    			textfield.setText(" ");
    		}
    		if(e.getSource()==subButton) {
    			num1 =Double.parseDouble(textfield.getText());
    			operator='-';
    			textfield.setText(" ");
    		}
    		if(e.getSource()==mulButton) {
    			num1 =Double.parseDouble(textfield.getText());
    			operator='x';
    			textfield.setText(" ");
    		}	
    		if(e.getSource()==divButton) {
    			num1 =Double.parseDouble(textfield.getText());
    			operator='/';
    			textfield.setText(" ");
    		}
    		
    		if(e.getSource()==equButton) {
    			num2=Double.parseDouble(textfield.getText());
    			
    			switch(operator) {
    			case '+':result =num1+num2;
    			break;
    			case '-':result =num1-num2;
    			break;
    			case 'x':result =num1*num2;
    			break;
    			case '/':result =num1/num2;
    			break;
    			}
    			textfield.setText(String.valueOf(result));
    			num1=result;
    			
    		}
    		if(e.getSource()==clrButton) {
    			textfield.setText(" ");
			}
    		
    		if(e.getSource()==delButton) {
    			String string = textfield.getText();
    			textfield.setText("");
    			for(int i=0;i<string.length()-1;i++) {
    				textfield.setText(textfield.getText()+string.charAt(i));
    			}
    		}
			if(e.getSource()==negButton) {
				double temp = Double.parseDouble(textfield.getText());
				temp*=-1;
				textfield.setText(String.valueOf(temp));
    			}
			
    	}

    }