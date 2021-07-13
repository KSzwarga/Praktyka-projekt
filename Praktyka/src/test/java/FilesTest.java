import com.praktyka.FilesManagement;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class FilesTest {

    File test;
    public FilesManagement testFolder;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp()  {
        testFolder = new FilesManagement(folder.getRoot().toString());
    }

    @Test
    public void test_exists_doesExist() throws IOException {
        test = folder.newFile("test_exists_doesExist.txt");
        assertTrue(testFolder.exists("test_exists_doesExist.txt"));
    }

    @Test
    public void test_exists_doesNotExist()  {
        assertFalse(testFolder.exists("test_exists_doesNotExist.txt"));
    }

    @Test
    public void test_info_fileIsAFile() throws IOException {
        test = folder.newFile("test_info_fileIsAFile.txt");
        assertTrue(testFolder.info("test_info_fileIsAFile.txt"));
    }

    @Test
    public void test_info_fileIsNotAFile()  {
        assertFalse(testFolder.info("test_info_fileIsNotAFile.txt"));
    }

    @Test
    public void test_createFile_FileIsCreated()  {
        testFolder.createFile("test_createFile.txt", "testing text content");
        test = new File(folder.getRoot().toString() + "\\test_createFile.txt");
        assertTrue(test.exists());
    }


    @Test
    public void test_readFile() throws IOException {
        String test = "Testing reading from a file";
        FileWriter myWriter = new FileWriter(folder.getRoot().toString() + "\\test_createFile.txt");
        myWriter.write(test);
        myWriter.close();
        assertEquals(testFolder.readFile("test_createFile.txt"), test);
    }

    @Test
    public void test_createFile_createdTextIsCorrect() {
        String test = "Testing reading from a created file";
        testFolder.createFile("test_createFile_createdTextIsCorrect.txt", test);
        assertEquals(testFolder.readFile("test_createFile_createdTextIsCorrect.txt"), test);
    }
}
