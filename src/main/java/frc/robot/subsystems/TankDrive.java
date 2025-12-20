package frc.robot.subsystems;
//imported motor ids
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.KleftfrontID;
import static frc.robot.Constants.DriveConstants.kleftbackID;
import static frc.robot.Constants.DriveConstants.krightbackID;
import static frc.robot.Constants.DriveConstants.krightfrontID;

public class TankDrive extends SubsystemBase { 
    
    //WPI_VictorSPX m_leftfront;
    //WPI_VictorSPX m_leftback;
    //WPI_VictorSPX m_rightfront;
    //WPI_VictorSPX m_rightback;
    PWMVictorSPX m_leftfront;
    PWMVictorSPX m_leftback;
    PWMVictorSPX m_rightfront;
    PWMVictorSPX m_rightback;
    DifferentialDrive m_tankDrive;
    DifferentialDrive m_tankDrive2;

    public TankDrive() {

        //setting up the motors
        m_leftfront = new PWMVictorSPX(KleftfrontID);
        m_leftback = new PWMVictorSPX(kleftbackID);
        m_rightfront = new PWMVictorSPX(krightfrontID);
        m_rightback = new PWMVictorSPX(krightbackID);
         
        m_rightfront.setInverted(true);
        m_rightback.setInverted(true);
       // m_rightback.follow(m_rightfront);
       // m_leftback.follow(m_leftfront);
        m_rightfront.setSafetyEnabled(true);
        m_rightback.setSafetyEnabled(true);
        m_leftback.setSafetyEnabled(true);
        m_leftfront.setSafetyEnabled(true);
        
    
        m_tankDrive = new DifferentialDrive(m_leftfront, m_rightfront);
        m_tankDrive2 = new DifferentialDrive(m_leftback, m_rightback);
}

    public void drive(double leftSpeed, double rightSpeed) {
        m_tankDrive.tankDrive(leftSpeed, rightSpeed);
        m_tankDrive2.tankDrive(leftSpeed, rightSpeed);
    }
   // Use WPILib PWM Victor and MotorControllerGroup instead of CTRE Phoenix
/*import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase { 
    
    PWMVictorSPX m_leftfront;
    PWMVictorSPX m_leftback;
    PWMVictorSPX m_rightfront;
    PWMVictorSPX m_rightback;
    MotorControllerGroup m_leftGroup;
    MotorControllerGroup m_rightGroup;
    DifferentialDrive m_tankDrive;

    public TankDrive() {

        //setting up the motors
        m_leftfront = new PWMVictorSPX(KleftfrontID);
        m_leftback = new PWMVictorSPX(kleftbackID);
        m_rightfront = new PWMVictorSPX(krightfrontID);
        m_rightback = new PWMVictorSPX(krightbackID);
         
        // group the left and right motors so we can drive them together
        m_leftGroup = new MotorControllerGroup(m_leftfront, m_leftback);
        m_rightGroup = new MotorControllerGroup(m_rightfront, m_rightback);

        // invert the right side if necessary
        m_rightGroup.setInverted(true);

    
    }*/

    
}