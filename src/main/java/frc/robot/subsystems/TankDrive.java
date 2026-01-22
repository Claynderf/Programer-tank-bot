package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;



public class TankDrive extends SubsystemBase { 
    
   
   DifferentialDrive m_tankDrive;
  
    
      private final  WPI_VictorSPX m_leftLeader = new WPI_VictorSPX(DriveConstants.KleftfrontID);
  private final  WPI_VictorSPX m_leftFollower = new  WPI_VictorSPX(DriveConstants.kleftbackID); 
    private final WPI_VictorSPX m_rightLeader = new  WPI_VictorSPX(DriveConstants.krightfrontID);
  private final WPI_VictorSPX m_rightFollower = new WPI_VictorSPX(DriveConstants.krightbackID);
  private final Field2d Field2d = new Field2d();
  private static NetworkTable limelight = NetworkTableInstance.getDefault().getTable("rvfrc");
        



     public TankDrive() {

        
         
    m_rightFollower.follow(m_rightLeader);
    m_leftFollower.follow(m_leftLeader);


        m_rightLeader.setInverted(true);
        m_rightFollower.setInverted(true);


        m_tankDrive = new DifferentialDrive(m_leftLeader, m_rightLeader);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        m_tankDrive.tankDrive(leftSpeed, rightSpeed);
    }
  @Override
  public void periodic(){
    
    SmartDashboard.putData(Field2d);
  }

    
}