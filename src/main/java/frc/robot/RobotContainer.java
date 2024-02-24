
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.LauncherConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.LaunchNote;
import frc.robot.commands.PrepareLaunch;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Launcher;

public class RobotContainer {
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Launcher m_launcher = new Launcher();

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_operatorController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_drivetrain.setDefaultCommand(
        new RunCommand(
            () ->
                m_drivetrain.arcadeDrive(
                    -m_driverController.getLeftY(), -m_driverController.getRightX()),
            m_drivetrain));

    // m_driverController.x().whileTrue(m_drivetrain.turbo()); // turbo hehe

    m_operatorController
        .a()
        .whileTrue(
            new PrepareLaunch(m_launcher)
                .withTimeout(LauncherConstants.kLauncherDelay)
                .andThen(new LaunchNote(m_launcher))
                .handleInterrupt(() -> m_launcher.stop()));

    m_operatorController.leftBumper().whileTrue(m_launcher.getIntakeCommand());
  }

  public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_drivetrain);
  }
}
