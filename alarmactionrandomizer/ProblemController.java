package alarmactionrandomizer;

import java.lang.Math;

import javax.sound.sampled.Clip;

public class ProblemController {
	//the purpose of this class is to select a type of problem and check inputs and outputs
	
	enum ProblemType {
		MATH,
		INPUTSTRING
	}
		
	private ProblemType selectProblemType() {
		double i = Math.random();
		if(i < 0.5) {
			return ProblemType.MATH;
		}
		
		else {
			return ProblemType.INPUTSTRING;
		}
	}
	
	//use some variation of the below method in conjunction with the above method to randomly select prob
	
//	private void MathProblemLooper(Clip clipInput) {
//		MathProblem mather = new MathProblem();
//		
//		if(!mather.isCorrect()) {
//			MathProblemLooper(clipInput); //I'm... prouder of this bit than I care to admit
//		}
//		
//		else{
//			clipInput.stop(); //resolve to re-loop it until it's correct
//		}
//	}
	
}
