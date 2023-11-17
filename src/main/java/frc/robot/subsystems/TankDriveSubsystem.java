package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.components.GenericMotor;
import frc.robot.components.TalonComponent;
public class TankDriveSubsystem extends SubsystemBase{
    private GenericMotor leftMotor;
    private GenericMotor rightMotor;

    public TankDriveSubsystem() {
        rightMotor = new TalonComponent(TankDriveConstants.DRIVE_RIGHT_MOTOR_ID, "Talon SRX");
        leftMotor = new TalonComponent(TankDriveConstants.DRIVE_LEFT_MOTOR_ID, "Talon SRX");
    }

    // Now create two methods, one for each motor
    // These methods should set the percent
    // Output of the left and right motors respectively
    public void setLeftSpeed (double targetOutput) {
        leftMotor.setOutput(ExtendedMath.clamp(-0.5, 0.5))
    }
    
}
