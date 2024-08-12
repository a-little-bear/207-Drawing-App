package use_case.create_tool;

import entity.tool.EraserTool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateEraserToolTest {

    private CreateEraserTool createEraserTool;

    @Test
    void testCreateEraserTool() {
        createEraserTool = new CreateEraserTool();
        EraserTool eraserTool = createEraserTool.create(null);  // No color is actually used in the method

        assertNotNull(eraserTool, "Eraser tool should not be null");
    }
}
