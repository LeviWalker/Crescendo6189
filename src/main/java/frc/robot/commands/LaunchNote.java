
package frc.robot.commands;

import static frc.robot.Constants.LauncherConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Launcher;  

public class LaunchNote extends Command {
  Launcher m_launcher;
  public LaunchNote(Launcher launcher) {
    m_launcher = launcher;
    addRequirements(m_launcher);
  }

  @Override
  public void initialize() {
    m_launcher.setLaunchWheel(kLauncherSpeed);
    m_launcher.setFeedWheel(kLaunchFeederSpeed);
  }

  @Override
  public void execute() { }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    m_launcher.stop();
  }
}
