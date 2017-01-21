package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class NavX extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void getAcceleration(){
    	RobotMap.accelX = RobotMap.ahrs.getRawAccelX();
    	RobotMap.accelY = RobotMap.ahrs.getRawAccelY();
    	
    	SmartDashboard.putNumber("accelX", RobotMap.accelX);
    	SmartDashboard.putNumber("accelY", RobotMap.accelY);
    }
}


