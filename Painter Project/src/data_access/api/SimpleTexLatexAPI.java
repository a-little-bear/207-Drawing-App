package data_access.api;

import io.github.cdimascio.dotenv.Dotenv;

import okhttp3.*;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.Optional;


/**
 * The SimpleTexLatexAPI class implements the LatexAPI interface to provide OCR functionality
 * for converting images to LaTeX code using the SimpleTex OCR API.
 */
public class SimpleTexLatexAPI implements LatexAPI {
    private static final String OCR_URL = "https://server.simpletex.net/api/latex_ocr_turbo";

    /**
     * Load environment variables from .env file
     */
    private static final Dotenv dotenv = Dotenv.load();

    private static final String TOKEN = Optional.ofNullable(dotenv.get("SIMPLETEX_API_KEY"))
            .orElseGet(() -> Optional.ofNullable(System.getenv("SIMPLETEX_API_KEY"))
                    .orElseThrow(() -> new IllegalArgumentException("SIMPLETEX_API_KEY environment variable must be set")));

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
