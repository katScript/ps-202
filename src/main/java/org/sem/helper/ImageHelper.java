package org.sem.helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class ImageHelper {
    public Image getImage(String resource) {
        try {
            return ImageIO.read(Objects.requireNonNull(ImageHelper.class.getResource(resource)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
