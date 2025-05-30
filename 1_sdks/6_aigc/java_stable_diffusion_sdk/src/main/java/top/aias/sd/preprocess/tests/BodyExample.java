package top.aias.sd.preprocess.tests;

import ai.djl.Device;
import ai.djl.ModelException;
import ai.djl.modality.cv.Image;
import ai.djl.opencv.OpenCVImageFactory;
import ai.djl.translate.TranslateException;
import top.aias.sd.preprocess.pose.BodyModel;
import top.aias.sd.utils.ImageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * OpenPose 姿态检测,身体关键点
 *
 * @author Calvin
 * @mail 179209347@qq.com
 * @website www.aias.top
 */
public final class BodyExample {

    private static final Logger logger = LoggerFactory.getLogger(BodyExample.class);

    private BodyExample() {
    }

    public static void main(String[] args) throws IOException, ModelException, TranslateException {
        Path imageFile = Paths.get("src/test/resources/pose.png"); // pose.png beauty.jpg
        Image img = OpenCVImageFactory.getInstance().fromFile(imageFile);
        String bodyModelPath = "models/body.pt";

        try (BodyModel model = new BodyModel(512, 512, bodyModelPath, 1, Device.cpu());) {

            Image depthImg = model.predict(img);
            ImageUtils.saveImage(depthImg, "body.png", "build/output");
        }
    }
}
