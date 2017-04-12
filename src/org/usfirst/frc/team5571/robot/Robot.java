package org.usfirst.frc.team5571.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're
 * inexperienced, don't. Unless you know what you are doing, complex code will
 * be much more difficult under this system. Use IterativeRobot or Command-Based
 * instead if you're new.
 */
public class Robot extends SampleRobot {
	RobotDrive myRobot = new RobotDrive(0, 1); // class that handles basic drive
												// operations
	Joystick leftStick = new Joystick(0); // set to ID 1 in DriverStation
	JoystickButton ledButton = new JoystickButton(leftStick, 1);
	DigitalOutput LED = new DigitalOutput(9);

	public Robot() {
		myRobot.setExpiration(0.1);
	}

	/**
	 * Runs the motors with arcade steering.
	 * Also will turin an LED connected to Digital output 9 when Joystick Button 1 is depressed
	 */
	@Override
	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			myRobot.arcadeDrive(leftStick);
			Timer.delay(0.005); // wait for a motor update time
			if (ledButton.get())
				LED.set(true);
			else
				LED.set(false);	
		}
	}
}
