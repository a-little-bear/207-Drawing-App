//package data_access;
//
//import entity.canvas.Canvas;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//import static org.mockito.Mockito.*;
//
//public class DataAccessObjectTest {
//
//    private DataAccessObject dataAccessObject;
//    private JFileChooser mockFileChooser;
//
//    @BeforeEach
//    void setUp() {
//        mockFileChooser = mock(JFileChooser.class);
//        dataAccessObject = new DataAccessObject(mockFileChooser);
//    }
//
//    @Test
//    void testSaveFile() {
//        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
//        when(mockFileChooser.showSaveDialog(null)).thenReturn(JFileChooser.APPROVE_OPTION);
//        when(mockFileChooser.getSelectedFile()).thenReturn(new File("test.png"));
//
//        assertDoesNotThrow(() -> dataAccessObject.saveFile("Save Image", image));
//    }
//
//    @Test
//    void testExportFile() {
//        ArrayList<Canvas> layers = new ArrayList<>();
//        layers.add(new Canvas(100, 100));
//        when(mockFileChooser.showSaveDialog(null)).thenReturn(JFileChooser.APPROVE_OPTION);
//        when(mockFileChooser.getSelectedFile()).thenReturn(new File("test.canvas"));
//
//        assertDoesNotThrow(() -> dataAccessObject.exportFile("Export Canvas", layers));
//    }
//}
