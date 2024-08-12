package use_case.create_tool;

import entity.tool.FillTool;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateFillToolTest {

    private CreateFillTool createFillTool;

    @Test
    void testCreateFillTool() {
        createFillTool = new CreateFillTool();
        FillTool fillTool = createFillTool.create(Color.RED);

        assertNotNull(fillTool, "Fill tool should not be null");
    }
}
