package volumeCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class VolumeCalculator extends JFrame implements ActionListener
{
	// Declaring components to be used
	
	JLabel lblNum0, lblNum1, lblNum2, lblVolume, lblBudget, lblNull;
	JTextField txtNum0, txtNum1, txtNum2, txtVolume, txtBudget;
	JButton btnCalc, btnClear;
	
	public static void main(String[] args)
	{
		// Basic window configuration
		
		JFrame window = new VolumeCalculator();
		window.setUndecorated(true);
		window.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	VolumeCalculator()
	{
		// Customising window layout
		
		setTitle("Pool Budget");
		setBounds(960, 540, 400, 400);
		getContentPane().setBackground(new Color(27, 28, 60));
		getContentPane().setLayout(new GridLayout(6, 2));
		
		
		// Instantiating JLabels
		
		lblNum0 = new JLabel("          Length:");
		lblNum0.setForeground(Color.white);
		lblNum0.setFont(new Font(" ", Font.BOLD, 20));
		
		lblNum1 = new JLabel("          Width:");
		lblNum1.setForeground(Color.white);
		lblNum1.setFont(new Font(" ", Font.BOLD, 20));
		
		lblNum2 = new JLabel("          Depth:");
		lblNum2.setForeground(Color.white);
		lblNum2.setFont(new Font(" ", Font.BOLD, 20));
		
		lblVolume = new JLabel("          Volume:");
		lblVolume.setForeground(Color.white);
		lblVolume.setFont(new Font(" ", Font.BOLD, 20));
		
		lblBudget = new JLabel("          Budget:");
		lblBudget.setForeground(Color.white);
		lblBudget.setFont(new Font(" ", Font.BOLD, 20));
		
		
		// Instantiating JButtons
		
		btnCalc = new JButton ("Calculate");
		btnCalc.addActionListener(this);
		
		btnClear = new JButton ("Clear");
		btnClear.addActionListener(this);
		
		
		// Instantiating JTextFields
		
		txtNum0 = new JTextField();
		txtNum1 = new JTextField();
		txtNum2 = new JTextField();
		
		txtVolume = new JTextField();
		txtVolume.setEditable(false);
		
		txtBudget = new JTextField();
		txtBudget.setEditable(false);
		
		
		// Adding components to the frame
		
		// Row 1
		getContentPane().add(lblNum0); 
		getContentPane().add(txtNum0);
		
		// Row 2
		getContentPane().add(lblNum1);
		getContentPane().add(txtNum1);
		
		// Row 3
		getContentPane().add(lblNum2); 
		getContentPane().add(txtNum2);
		
		// Row 4
		getContentPane().add(lblVolume);
		getContentPane().add(txtVolume);
		
		// Row 5
		getContentPane().add(lblBudget);
		getContentPane().add(txtBudget);
		
		// Row 6
		getContentPane().add(btnCalc);
		getContentPane().add(btnClear);

	}

	public void actionPerformed(ActionEvent e) 
	{
		double num0 = 0, num1 = 0, num2 = 0, volume = 0, budget = 0;
		
		try
		{
			num0 = Double.parseDouble(txtNum0.getText());
			num1 = Double.parseDouble(txtNum1.getText());
			num2 = Double.parseDouble(txtNum2.getText());
			
		}
		catch (NumberFormatException CharacterError)
		{
			txtVolume.setText("Error! Seems like you used a non-numeric character.");
			txtBudget.setText("Double-check your inputs and try again.");
			
		}
		
		
		if (e.getSource() == btnCalc)
		{
			volume = num0 * num1 * num2;
			
			budget = volume * 300;
			
		}
		
		
		if (e.getSource() == btnClear)
		{
			txtNum0.setText("");
			txtNum1.setText("");
			txtNum2.setText("");
			txtVolume.setText("");
			txtBudget.setText("");
			return;
			
		}
		
		
		txtVolume.setText(volume + "m³");
		txtBudget.setText("R$" + budget);
		
	}
	
}
