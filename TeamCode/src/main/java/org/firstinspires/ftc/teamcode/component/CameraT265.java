package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.spartronics4915.lib.T265Camera;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Transform2d;

public class CameraT265
{
    private static final double encoderMeasurementCovariance = 0.8;
    public Transform2d cameraToRobot = null;
    public Pose2d startingPose = null;
    public T265Camera slamra = null;

    public CameraT265(HardwareMap hardwareMap)
    {
        //initialize camera stuffs
        cameraToRobot = new Transform2d();
        startingPose = new Pose2d(1, 1, new Rotation2d());
        slamra = new T265Camera(cameraToRobot, encoderMeasurementCovariance, hardwareMap.appContext);
        slamra.setPose(startingPose);
        slamra.start();
    }
}