package org.usfirst.frc.team2557.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static AHRS  ahrs;
	
	public static float accelX;
	public static float accelY;

	public static double[] aDistance;
	
	public static Timer time;
	
	
	
	public static void init(){
		ahrs = new AHRS(SPI.Port.kMXP);
		time = new Timer();
		
		aDistance = new double[2];
	}
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}

