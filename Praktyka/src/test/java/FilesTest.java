import com.praktyka.FilesManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import static org.junit.jupiter.api.Assertions.*;

class FilesTest {

    Path test, test2;
    public FilesManagement testFolder;

    @TempDir
    static Path folder;

    @BeforeEach
    void setUp()  {
        testFolder = new FilesManagement(folder.toFile().getAbsolutePath());
    }

    @Test
    void testExistsDoesExist() throws IOException {
        test = Files.createFile(folder.resolve("testExistsDoesExist.txt"));
        assertTrue(testFolder.exists("testExistsDoesExist.txt"),"file should exist");
    }

    @Test
    void testExistsDoesNotExist()  {
        assertFalse(testFolder.exists("testExistsDoesNotExist.txt"),"file should not exist");
    }

    @Test
    void testInfoFileIsAFile() throws IOException {
        test = Files.createFile(folder.resolve("testInfoFileIsAFile.txt"));
        assertNotNull(testFolder.info("testInfoFileIsAFile.txt"),"tested file should be considered a file");
    }

    @Test
    void testInfoFileReturn() throws IOException {
        test = Files.createFile(folder.resolve("testInfoFileReturn.txt"));
        assertEquals(testFolder.info("testInfoFileReturn.txt"), test.toFile(), "method should return file");
    }

    @Test
    void testInfoFileNull()  {
        assertNull(testFolder.info("testInfoFileReturnNotExists.txt"), "method should return null, file doesnt exist");
    }

    @Test
    void testInfoFileIsNotAFile()  {
        assertNull(testFolder.info("testInfoFileIsNotAFile.txt"), "tested file should not be considered a file");
    }

    @Test
    void testCreateFileFileIsCreated()  {
        testFolder.createFile("testCreateFileFileIsCreated.txt", "testing text content");
        assertTrue( testFolder.exists("testCreateFileFileIsCreated.txt"),"created file should exist");
    }

    @Test
    void testReadFile() throws IOException {
        String test = "Testing reading from a file";
        FileWriter myWriter = new FileWriter(folder.toFile().getAbsolutePath() + "\\testReadFile.txt");
        myWriter.write(test);
        myWriter.close();
        assertEquals(testFolder.readFile("testReadFile.txt"), test,"method readFile should give the same result as content of the text file");
    }

    @Test
    void testReadFileNull()  {
       assertNull(testFolder.readFile("testReadFileNull.txt"), "file should not exist and return null");
    }

    @Test
    void testCreateFileCreatedTextIsCorrect() {
        String test = "Testing reading from a created file";
        testFolder.createFile("testCreateFileCreatedTextIsCorrect.txt", test);
        assertEquals(testFolder.readFile("testCreateFileCreatedTextIsCorrect.txt"), test, "Method createFile should create file with the same text as passed in the argument");
    }
    @Test
    void testInfoDateSwapIsCorrect() throws IOException {
        test = Files.createFile(folder.resolve("testInfoDateSwapIsCorrect.txt"));
        File testfile = new File(test.toString());
        testfile.setLastModified(1437987756000L);
        test2 = Files.createFile(folder.resolve("testInfoDateSwapIsCorrect2.txt"));
        File test2file = new File(test2.toString());
        test2file.setLastModified(1439752556000L);
        assertEquals(java.util.Arrays.toString(testFolder.info("15/07/2015", "17/08/2015")),
                java.util.Arrays.toString(testFolder.info("17/08/2015", "15/07/2015")),
                "Methods should return the same files regardless of date order");
    }

    @Test
    void testInfoDateNotNull() throws IOException {
        test = Files.createFile(folder.resolve("testInfoDateNotNull.txt"));
        File testfile = new File(test.toString());
        testfile.setLastModified(1437987756000L);
        assertNotNull(java.util.Arrays.toString(testFolder.info("15/07/2015", "17/08/2015")), "Files found by dates should be not null");
    }

    @Test
    void testInfoDateFileReturn() throws IOException {
        test = Files.createFile(folder.resolve("testInfoDateFileReturn.txt"));
        File testfile = new File(test.toString());
        testfile.setLastModified(1437987756000L);
        test2 = Files.createFile(folder.resolve("testInfoDateFileReturn2.txt"));
        File test2file = new File(test2.toString());
        test2file.setLastModified(1439752556000L);
        File[] files = new File[2];
        files[0] = testfile;
        files[1] = test2file;
        assertEquals(java.util.Arrays.toString(testFolder.info("15/07/2015", "17/08/2015")), java.util.Arrays.toString(files), "Return of method should be same as files array");
    }

}
