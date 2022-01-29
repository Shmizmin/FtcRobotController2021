package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Blue A Auto")
public class BlueAauto extends AutonomousAbstract
{
    @Override
    public void runOpMode()
    {
        onInit("blueA");

        ElapsedTime time = new ElapsedTime();
        time.reset();

        while (opModeIsActive() && (time.seconds() < 2))
        {
            telemetry.addData("Frame Count", camera.webcam.getFrameCount());
            telemetry.addData("FPS", String.format("%.2f", camera.webcam.getFps()));
            telemetry.addData("Total frame time ms", camera.webcam.getTotalFrameTimeMs());
            telemetry.addData("Pipeline time ms", camera.webcam.getPipelineTimeMs());
            telemetry.addData("Overhead time ms", camera.webcam.getOverheadTimeMs());
            telemetry.addData("Theoretical max FPS", camera.webcam.getCurrentPipelineMaxFps());
            telemetry.addData("Position", camera.detector.data);
            telemetry.addData("Right Total", camera.detector.right);
            telemetry.addData("Left Total", camera.detector.left);
            telemetry.update();
            sleep(100);
        }

        camera.webcam.stopStreaming();

        switch (camera.detector.data)
        {
            case "l":
                encoderDrive(-8.0,-8.0, -8.0, -8.0, 10000);
                rotate(-90);
                encoderDrive(-28.25, -28.25, -28.25, -28.25, 10000);
                rotate(-90);
                encoderDrive(8.0, 8.0, 8.0, 8.0, 10000);

                setArm(210);

                sleep(200);

                robot.clawLifter.clawServo.setPower(-1.0);
                sleep(1000);
                robot.clawLifter.clawServo.setPower(0.0);

                //sleep(200);

                encoderDrive(-8.5, -8.5, -8.5, -8.5, 10000);

                setArm(10);

                sleep(200);

                rotate(-90);
                encoderDrive(-24.5, 24.5, 24.5, -24.5, 2);
                encoderDrive(60.0, 60.0, 60.0, 60.0, 10000);
                break;

            case "c":
                encoderDrive(-8.0,-8.0, -8.0, -8.0, 10000);
                rotate(-90);
                encoderDrive(-28.25, -28.25, -28.25, -28.25, 10000);
                rotate(-90);
                encoderDrive(9.25, 9.25, 9.25, 9.25, 10000);

                setArm(110);

                sleep(200);

                robot.clawLifter.clawServo.setPower(-1.0);
                sleep(1000);
                robot.clawLifter.clawServo.setPower(0.0);

                sleep(200);

                encoderDrive(-3.0, -3.0, -3.0, -3.0, 10000);

                setArm(25);

                //sleep(200);

                rotate(-90);
                encoderDrive(-24.5, 24.5, 24.5, -24.5, 2);
                encoderDrive(60.0, 60.0, 60.0, 60.0, 10000);
                break;

            case "r":
                robot.clawLifter.clawServo.setPower(-1.0);
                sleep(1000);
                robot.clawLifter.clawServo.setPower(0.0);

                encoderDrive(-8.0,-8.0, -8.0, -8.0, 10000);
                rotate(-90);
                encoderDrive(-28.25, -28.25, -28.25, -28.25, 10000);
                rotate(90);
                encoderDrive(-9.5, -9.5, -9.5, -9.5, 10000);

                setLifter(950);

                sleep(200);

                robot.blockLifter.blockDropper.setPosition(INTAKE_DUMP);
                sleep(1000);
                robot.blockLifter.blockDropper.setPosition(INTAKE_STORE);

                setLifter(10);

                //sleep(200);

                encoderDrive(3.0, 3.0, 3.0, 3.0, 10000);
                rotate(-90);
                encoderDrive(24.5, -24.5, -24.5, 24.5, 2);
                encoderDrive(-61.0, -61.0, -61.0, -61.0, 10000);

                break;
        }
    }
}
