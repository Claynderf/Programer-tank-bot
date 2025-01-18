package frc.robot.subsystems;
//imported motor ids
import static frc.robot.Constants.DriveConstants.KleftfrontID;
import static frc.robot.Constants.DriveConstants.kleftbackID;
import static frc.robot.Constants.DriveConstants.krightbackID;
import static frc.robot.Constants.DriveConstants.krightfrontID;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


// imported victor library
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase { 
    
    WPI_VictorSPX m_leftfront;
    WPI_VictorSPX m_leftback;
    WPI_VictorSPX m_rightfront;
    WPI_VictorSPX m_rightback;
    DifferentialDrive m_tankDrive;

    public TankDrive() {

        //setting up the motors
        m_leftfront = new WPI_VictorSPX(KleftfrontID);
        m_leftback = new WPI_VictorSPX(kleftbackID);
        m_rightfront = new WPI_VictorSPX(krightfrontID);
        m_rightback = new WPI_VictorSPX(krightbackID);
         
        m_rightfront.setInverted(true);
        m_rightback.setInverted(true);
        m_rightback.follow(m_rightfront);
        m_leftback.follow(m_leftfront);
        
    
        m_tankDrive = new DifferentialDrive(m_leftfront, m_rightfront);
}

    public void drive(double leftSpeed, double rightSpeed) {
        m_tankDrive.tankDrive(leftSpeed, rightSpeed);
    }

    
}