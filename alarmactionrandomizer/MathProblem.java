package alarmactionrandomizer;

import java.lang.Math;

import javax.swing.JOptionPane;

public class MathProblem extends GenericProblem{
	
	private int inputAlpha;
	private int inputBeta;
	private String resultFinal;
	private boolean isCorrect = false;
	
	public MathProblem() {
		inputAlpha = (int)Math.floor(Math.random() * 10);
		inputBeta = (int)Math.floor(Math.random() * 10);
		resultFinal = Integer.toString(inputAlpha + inputBeta);
		
		JOptionPane popper = new JOptionPane();
		String jarvis = popper.showInputDialog("Do the math: " + inputAlpha + "+" + inputBeta);
		if(jarvis.equals(resultFinal)) {
			isCorrect = true;
		}
		else {
			popper.showMessageDialog(null, "Wrong." + resultFinal + ":" + jarvis);
			isCorrect = false;
		}
	}
	
	public boolean isCorrect() {
		return isCorrect;
	}
	
}
