package clocklogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ClockAlarm {

	private int currHour; //current time
	private int currMin;
	private int currSec;

	private int setoffHour; //time at which alarm clock goes off
	private int setoffMin;
	private int setoffSec;

	private Timer alarmCheck;
	private Ticker alarmSetup;
	private Timer freshAlarm;

	// the constructor's really the only important bit here, everything else supports it
	public ClockAlarm(int hourInput, int minInput, int secInput) {
		setoffHour = hourInput;
		setoffMin = minInput;
		setoffSec = secInput;
		alarmSetup = new Ticker();
		alarmCheck = new Timer(500, alarmSetup);
		alarmCheck.start();

		AlarmAction alarmer = new AlarmAction();
		freshAlarm = new Timer(500, alarmer);
		freshAlarm.start();
	}

	// AlarmAction handles the action that occurs when alarm time goes off
	public class AlarmAction implements ActionListener {

		public void actionPerformed(ActionEvent eventInput) {
			if (eventInput.getSource() == freshAlarm) {
				if (currHour == setoffHour && currMin == setoffMin && currSec == setoffSec) {
					try {
						// this is the alarm action, change how you please
						File alarmFile = new File("alarmSound.wav");
						AudioInputStream alarmStream;
						AudioFormat alarmFormat;
						DataLine.Info alarmInfo;
						Clip alarmClip;

						alarmStream = AudioSystem.getAudioInputStream(alarmFile);
						alarmFormat = alarmStream.getFormat();
						alarmInfo = new DataLine.Info(Clip.class, alarmFormat);
						alarmClip = (Clip) AudioSystem.getLine(alarmInfo);
						alarmClip.open(alarmStream);
						alarmClip.start();
						alarmClip.loop(Clip.LOOP_CONTINUOUSLY);
						
						JOptionPane alarmPopUp = new JOptionPane();
						int input = alarmPopUp.showOptionDialog(null, "WAKE UP!", "Wake Up!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						
						if(input == JOptionPane.OK_OPTION || input == JOptionPane.CLOSED_OPTION) {
							alarmClip.stop();
						}
						
					} catch (Exception e) {
						System.out.println("Something happened with the alarm");
					}
				}
			}
		}
	}

	private class Ticker implements ActionListener {

		public void actionPerformed(ActionEvent eventInput) {
			if (eventInput.getSource() == alarmCheck) {
				// basically, if alarmCheck adds a Ticker, this starts up and keeps looping over
				PrimeClock clocker = new PrimeClock();
				currHour = clocker.getCurrHour();
				currMin = clocker.getCurrMin();
				currSec = clocker.getCurrSec();
			}
		}

	}

	public int getSetoffHour() {
		return setoffHour;
	}

	public int getSetoffMin() {
		return setoffMin;
	}

	public int getSetoffSec() {
		return setoffSec;
	}

}
