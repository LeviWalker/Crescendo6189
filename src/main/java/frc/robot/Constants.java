
package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }

  public static class DrivetrainConstants {
    public static final int kLeftRearID = 1;
    public static final int kLeftFrontID = 2;
    public static final int kRightRearID = 3;
    public static final int kRightFrontID = 4;

    public static final int kCurrentLimit = 60;

    public static final double kDefaultMaxThrottle = 0.70;
    public static final double kDefaultMaxTurn = 0.55;

    public static final double kTurboMaxThrottle = 0.90;
    public static final double kTurboMaxTurn = 0.75;
  }

  public static class LauncherConstants {
    public static final int kFeederID = 5;
    public static final int kLauncherID = 6;

    public static final int kLauncherCurrentLimit = 80;
    public static final int kFeedCurrentLimit = 80;

    public static final double kLauncherSpeed = 1;
    public static final double kLaunchFeederSpeed = 1;
    public static final double kIntakeLauncherSpeed = -1;
    public static final double kIntakeFeederSpeed = -.2;

    public static final double kLauncherDelay = 1;
  }
}
