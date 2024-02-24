
package frc.robot.commands;

import static frc.robot.Constants.LauncherConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Launcher;

public class PrepareLaunch extends Command {
  Launcher m_launcher;
  public PrepareLaunch(Launcher launcher) {
    m_launcher = launcher;

    addRequirements(m_launcher);
  }

  @Override
  public void initialize() {
    m_launcher.setLaunchWheel(kLauncherSpeed);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
