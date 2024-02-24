
package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private DifferentialDrive m_drivetrain;

  private WPI_TalonSRX leftFront;
  private WPI_TalonSRX leftRear;
  private WPI_TalonSRX rightFront;
  private WPI_TalonSRX rightRear;

  private double maxThrottle = kDefaultMaxThrottle;
  private double maxTurn = kDefaultMaxTurn;

  public Drivetrain() {
    leftFront = new WPI_TalonSRX(kLeftFrontID);
    leftRear = new WPI_TalonSRX(kLeftRearID);
    rightFront = new WPI_TalonSRX(kRightFrontID);
    rightRear = new WPI_TalonSRX(kRightRearID);


    SupplyCurrentLimitConfiguration currentLimit =
      new SupplyCurrentLimitConfiguration(true,
        kCurrentLimit,
        kCurrentLimit,
        0);

    leftFront.configSupplyCurrentLimit(currentLimit);
    leftRear.configSupplyCurrentLimit(currentLimit);
    rightFront.configSupplyCurrentLimit(currentLimit);
    rightRear.configSupplyCurrentLimit(currentLimit);
    

    leftRear.follow(leftFront);
    rightRear.follow(rightFront);

    leftFront.setInverted(true);
    rightFront.setInverted(false);

    m_drivetrain = new DifferentialDrive(leftFront, rightFront);
  }

  private void setMaxSpeeds(double maxThrottle, double maxTurn) {
    this.maxThrottle = maxThrottle;
    this.maxTurn = maxTurn;
  }

  public void arcadeDrive(double speed, double rotation) {
    m_drivetrain.arcadeDrive(maxThrottle * speed, maxTurn * rotation);
  }

  public Command turbo() {
    return this.startEnd(
      () -> setMaxSpeeds(kTurboMaxThrottle, kTurboMaxTurn),
      () -> setMaxSpeeds(kDefaultMaxThrottle, kDefaultMaxTurn)
    );
  }

  @Override
  public void periodic() {

  }
}
