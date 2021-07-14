import com.praktyka.FilesManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;


class FilesTest {

    File test;
    public FilesManagement testFolder;

    @TempDir
    static Path folder;

    @BeforeEach
    void setUp()  {
        testFolder = new FilesManagement(folder.getRoot().toString());
    }

    @Test
    void testExistsDoesExist()  {
        test = new File(folder.getRoot().toString() + "\\testExistsDoesExist.txt");
        assertTrue(testFolder.exists("testExistsDoesExist.txt"),"file should exist");
    }

    @Test
    void testExistsDoesNotExist()  {
        assertFalse(testFolder.exists("testExistsDoesNotExist.txt"),"file should not exist");
    }

    @Test
    void testInfoFileIsAFile()  {
        test = new File(folder.getRoot().toString() + "\\testInfoFileIsAFile.txt");
        assertTrue(testFolder.info("testInfoFileIsAFile.txt"),"tested file should be considered a file");
    }

    @Test
    void testInfoFileIsNotAFile()  {
        assertFalse(testFolder.info("testInfoFileIsNotAFile.txt"), "tested file should not be considered a file");
    }

    @Test
    void testCreateFileFileIsCreated()  {
        testFolder.createFile("testCreateFileFileIsCreated.txt", "testing text content");
        test = new File(folder.getRoot().toString() + "\\testCreateFileFileIsCreated.txt");
        assertTrue( test.exists(),"created file should exist");
    }


    @Test
    void testReadFile() throws IOException {
        String test = "Testing reading from a file";
        FileWriter myWriter = new FileWriter(folder.getRoot().toString() + "\\testReadFile.txt");
        myWriter.write(test);
        myWriter.close();
        assertEquals(testFolder.readFile("testReadFile.txt"), test,"method readFile should give the same result as content of the text file");
    }

    @Test
    void testCreateFileCreatedTextIsCorrect() {
        String test = "Testing reading from a created file";
        testFolder.createFile("testCreateFileCreatedTextIsCorrect.txt", test);
        assertEquals(testFolder.readFile("testCreateFileCreatedTextIsCorrect.txt"), test, "Method createFile should create file with the same text as passed in the argument");
    }
}
