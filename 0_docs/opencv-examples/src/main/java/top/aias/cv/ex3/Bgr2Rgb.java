package top.aias.cv.ex3;

import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 将图像从 BGR 转换为 RGB
 */
public class Bgr2Rgb {
    static {
        nu.pattern.OpenCV.loadLocally();
        if (System.getProperty("apple.awt.UIElement") == null) {
            // disables coffee cup image showing up on macOS
            System.setProperty("apple.awt.UIElement", "true");
        }
    }

    public static void main(String[] args) {

        // 读取图像文件
        Mat img = Imgcodecs.imread("src/test/resources/girl.png");

        // 创建一个空白的图像，用于存储转换后的结果
        Mat rgbImage = new Mat();

        // 将图像从 BGR 转换为 RGB
        Imgproc.cvtColor(img, rgbImage, Imgproc.COLOR_BGR2RGB);

        // 显示原图像与 RGB 图像
        HighGui.imshow("Original Image", img);
        HighGui.imshow("RGB Image", rgbImage);
        HighGui.waitKey(0);
        HighGui.destroyAllWindows();
    }
}
