package api;

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
     * The API key used for authenticating requests to the Gemini API.
     * This value is retrieved from the environment variable "GOOGLE_GEMINI_API_KEY".
     */
    private static final String API_KEY = Optional.ofNullable(System.getenv("GOOGLE_GEMINI_API_KEY"))
            .orElseThrow(() -> new IllegalArgumentException("GOOGLE_GEMINI_API_KEY environment variable must be set"));

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
    public static String solveEquation(String latex) {
        return getResponse(MATH_PROMPT + latex);
    }

    /**
     * Sends a text prompt to the Gemini API and retrieves the generated response.
     *
     * @param prompt the text prompt to be sent to the API
     * @return the generated response from the API
     * @throws IOException if an error occurs during the API request
     */
    public static String getResponse(String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(createJsonBody(prompt), MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL + "?key=" + API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
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
