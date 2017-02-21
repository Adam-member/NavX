package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.util.Stats;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class NavX extends Subsystem {

	public NavX() {
		super();
		
		driftStatsX = new Stats();
		driftStatsY = new Stats();
		
		averageDriftX = 0.0;
		averageDriftY = 0.0;
		
		stdDevDriftX = 0.0;
		stdDevDriftY = 0.0;		
	}
	
	private Stats driftStatsX;
	private Stats driftStatsY;
	
	private double averageDriftX;
	private double averageDriftY;
	
	private double stdDevDriftX;
	private double stdDevDriftY;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void getAcceleration(){
    	RobotMap.accelX = RobotMap.ahrs.getRawAccelX();
    	RobotMap.accelY = RobotMap.ahrs.getRawAccelY();
    	    	
    	if (RobotMap.accelX < 0.0 && RobotMap.accelX > -1.0
    			&& !driftStatsX.isAtEnd()) {
    		driftStatsX.addValue(RobotMap.accelX);
    	}
    	
       	if (RobotMap.accelY < 0.0 && RobotMap.accelY > -1.0
       			&& !driftStatsY.isAtEnd()) {
       		driftStatsY.addValue(RobotMap.accelY);
    	}
    	
    	if (Math.abs(RobotMap.accelX) - Math.abs(averageDriftX) < 0.01
    			&& Math.abs(RobotMap.accelX) - Math.abs(averageDriftX) > -0.01) {
    		RobotMap.accelX = 0.0;
    	}
    	
    	if (Math.abs(RobotMap.accelY) - Math.abs(averageDriftY) < 0.01
    			&& Math.abs(RobotMap.accelY) - Math.abs(averageDriftY) > -0.01) {
    		RobotMap.accelY = 0.0;
    	}
    	
    	if (driftStatsX.isAtEnd() && averageDriftX == 0.0) {
    		averageDriftX = driftStatsX.getAverage();
    		stdDevDriftX = driftStatsX.getStandardDeviation();
    	}
    	
    	if (driftStatsY.isAtEnd() && averageDriftY == 0.0) {
    		averageDriftY = driftStatsY.getAverage();
    		stdDevDriftY = driftStatsY.getStandardDeviation();
    	}
    	
    	SmartDashboard.putNumber("accelX ", RobotMap.accelX);
    	SmartDashboard.putNumber("accelY ", RobotMap.accelY);

       	SmartDashboard.putNumber("Avarage X drift ", averageDriftX);
       	SmartDashboard.putNumber("Standard Deviation of X drift ", stdDevDriftX);
    	SmartDashboard.putNumber("Avarage Y drift ", averageDriftY);
    	SmartDashboard.putNumber("Standard Deviation of Y drift ", stdDevDriftY);
    }
}


