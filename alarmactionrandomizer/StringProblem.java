package alarmactionrandomizer;

import javax.swing.JOptionPane;

public class StringProblem extends GenericProblem{
	
	private String[] stringerAlpha = {"Arnold", "Harold", "Lawrence", "Jackson", "Dale"};
	private String[] stringerBeta = {"Janice", "Helen", "Laurie", "Josie", "Denise"};
	private int randomAlpha;
	private int randomBeta;
	private boolean isCorrect;
	
	public StringProblem() {
		randomAlpha = (int)Math.floor(Math.random() * (stringerAlpha.length+1));
		randomBeta = (int)Math.floor(Math.random() * (stringerBeta.length+1));

		JOptionPane popper = new JOptionPane();
		String argus = popper.showInputDialog("Enter the following prompt: " + stringerAlpha[randomAlpha] + stringerBeta[randomBeta]);
		if(argus.equals(stringerAlpha[randomAlpha] + stringerBeta[randomBeta])) {
			isCorrect = true;
		}
		else {
			popper.showMessageDialog(null, "Wrong.");
			isCorrect = false;
		}
	}

	public boolean isCorrect() {
		return isCorrect;
	}
	
}
