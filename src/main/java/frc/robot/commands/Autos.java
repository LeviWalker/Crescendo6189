
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

import frc.robot.subsystems.Drivetrain;

public final class Autos {
  public static Command exampleAuto(Drivetrain drivetrain) {
    return new RunCommand(() -> drivetrain.arcadeDrive(-.5, 0), drivetrain)
        .withTimeout(1)
        .andThen(new RunCommand(() -> drivetrain.arcadeDrive(0, 0), drivetrain));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
