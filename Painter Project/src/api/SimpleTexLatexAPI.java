package api;

import okhttp3.*;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * The SimpleTexLatexAPI class implements the LatexAPI interface to provide OCR functionality
 * for converting images to LaTeX code using the SimpleTex OCR API.
 */
public class SimpleTexLatexAPI implements LatexAPI {
    private static final String OCR_URL = "https://server.simpletex.net/api/latex_ocr_turbo";
    private static final String TOKEN = "ZFETyXjnrYfcGxumS5rgjUSEFgIh4rtXL9wEsRQFJSDDozn4bigEe7uqsa7VhVjU";

    /**
     * Performs Optical Character Recognition (OCR) on the provided image and returns the recognized LaTeX code.
     *
     * @param image the image to be processed
     * @return the recognized LaTeX code from the image
     */
    @Override
    public String OCR(BufferedImage image) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);
            byte[] imageBytes = outputStream.toByteArray();

            RequestBody fileBody = RequestBody.create(imageBytes, MediaType.parse("image/png"));

            MultipartBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("file", "image.png", fileBody)
                    .build();

            Request request = new Request.Builder()
                    .url(OCR_URL)
                    .header("token", TOKEN)
                    .post(requestBody)
                    .build();

            OkHttpClient client = new OkHttpClient();
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }
                String responseBody = response.body().string();
                JSONObject jsonResponse = new JSONObject(responseBody);

                if (jsonResponse.has("res") && jsonResponse.getJSONObject("res").has("latex")) {
                    return jsonResponse.getJSONObject("res").getString("latex");
                } else {
                    return "Latex field not found in the response.";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred during the request.";
        }
    }
}
