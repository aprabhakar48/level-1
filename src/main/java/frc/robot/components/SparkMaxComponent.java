package frc.robot.components;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.util.Units;

/**
 * Wrapper for CANSparkMax motor controller which implements SmartMotorComponent
 */
public class SparkMaxComponent extends CANSparkMax {

	public SparkMaxComponent(int deviceID, MotorType type) {
		super(deviceID, type);
	}

	public double getAngle() {
		return getEncoder().getPosition() * 2 * Math.PI;
	}

	public void setAngle(double position) {
		getPIDController()
			.setReference(position / (2 * Math.PI), ControlType.kPosition);
	}

	public void setOutput(double output) {
		set(output);
	}

	public double getOutput() {
		return get();
	}

	public double getAngularVelocity() {
		return Units.rotationsPerMinuteToRadiansPerSecond(
			getEncoder().getVelocity()
		);
	}

	/**
	 * set velocity, in rad/s
	 * @param velocity angular velocity, in rad/s
	 */
	public void setAngularVelocity(double velocity) {
		getPIDController()
			.setReference(
				Units.radiansPerSecondToRotationsPerMinute(velocity),
				ControlType.kVelocity
			);
	}

	public void configureForSwerve(boolean isInverted, int currentLimit, double kP, double kD, boolean isDriveMotor) {
		setInverted(isInverted);
        getPIDController().setP(kP);
        getPIDController().setI(0);
        getPIDController().setD(kD);
        getPIDController().setFF(0);
        setSmartCurrentLimit(currentLimit);
	}
}
