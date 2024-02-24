

package frc.robot.subsystems;

import static frc.robot.Constants.LauncherConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {
  CANSparkMax m_launchWheel;
  CANSparkMax m_feedWheel;

  public Launcher() {
    m_launchWheel = new CANSparkMax(kLauncherID, MotorType.kBrushed);
    m_feedWheel = new CANSparkMax(kFeederID, MotorType.kBrushed);

    m_launchWheel.setSmartCurrentLimit(kLauncherCurrentLimit);
    m_feedWheel.setSmartCurrentLimit(kFeedCurrentLimit);
  }

  public Command getIntakeCommand() {
    return this.startEnd(
        () -> {
          setFeedWheel(kIntakeFeederSpeed);
          setLaunchWheel(kIntakeLauncherSpeed);
        },
        () -> {
          stop();
        });
  }

  public void setLaunchWheel(double speed) {
    m_launchWheel.set(speed);
  }

  public void setFeedWheel(double speed) {
    m_feedWheel.set(speed);
  }

  public void stop() {
    m_launchWheel.set(0);
    m_feedWheel.set(0);
  }
}
