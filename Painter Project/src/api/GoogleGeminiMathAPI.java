package api;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Optional;

/**
 * The GoogleGeminiMathAPI class implements the MathAPI interface to interact with the Gemini API
 * for generating content based on text prompts and solving mathematical equations.
 */
public class GoogleGeminiMathAPI implements MathAPI {

    /**
     * The URL for the Gemini API endpoint.
     */
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";


    /**
     * Load environment variables from .env file
     */
    private static final Dotenv dotenv = Dotenv.load();

    /**
     * The API key used for authenticating requests to the Gemini API.
     * This value is retrieved first from dotenv, and if not found, from System.getenv.
     */
    private static final String API_KEY = Optional.ofNullable(dotenv.get("GOOGLE_GEMINI_API_KEY"))
            .orElseGet(() -> Optional.ofNullable(System.getenv("GOOGLE_GEMINI_API_KEY"))
                    .orElseThrow(() -> new IllegalArgumentException("GOOGLE_GEMINI_API_KEY environment variable must be set")));

    /**
     * The prompt used to request instructions for solving LaTeX formatted equations.
     */
    private static final String MATH_PROMPT = "Give me a list of instructions on how to solve the following LaTeX:\n";

    /**
     * Sends a LaTeX formatted equation to the Gemini API and retrieves a list of instructions for solving it.
     *
     * @param latex the LaTeX formatted equation to be solved
     * @return a list of instructions for solving the given LaTeX equation
     */
    @Override
    public String solveEquation(String latex) throws IOException {
        return getResponse(MATH_PROMPT + latex);
    }

    /**
     * Sends a text prompt to the Gemini API and retrieves the generated response.
     *
     * @param prompt the text prompt to be sent to the API
     * @return the generated response from the API
     * @throws IOException if an error occurs during the API request
     */
    @Override
    public String getResponse(String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(createJsonBody(prompt), MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL + "?key=" + API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();

                // Parse the response to extract the content
                JSONObject jsonResponse = new JSONObject(responseBody);
                return jsonResponse
                        .getJSONArray("candidates")
                        .getJSONObject(0)
                        .getJSONObject("content")
                        .getJSONArray("parts")
                        .getJSONObject(0)
                        .getString("text");
            } else {
                throw new IOException("Request failed with status: " + response.code());
            }
        }
    }

    /**
     * Creates a JSON body for the API request from the given prompt.
     *
     * @param prompt the text prompt to be included in the request body
     * @return a JSON string representing the request body
     */
    private static String createJsonBody(String prompt) {
        JSONObject part = new JSONObject();
        part.put("text", prompt);

        JSONObject content = new JSONObject();
        content.append("parts", part);

        JSONObject requestBody = new JSONObject();
        requestBody.append("contents", content);

        return requestBody.toString();
    }
}
