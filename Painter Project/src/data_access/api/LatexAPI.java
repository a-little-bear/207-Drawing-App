package data_access.api;

import java.awt.image.BufferedImage;

/**
 * The LatexAPI interface provides a method for performing OCR on images.
 */
public interface LatexAPI {

    /**
     * Performs Optical Character Recognition (OCR) on the provided image.
     *
     * @param image the image to be processed
     * @return the recognized text from the image
     */
    String OCR(BufferedImage image);
}
