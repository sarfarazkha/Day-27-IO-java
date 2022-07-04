package com.bridgelabz;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NIOFileAPITest {

    private static String HOME = "D:\\GitProgram\\Day27_IO\\src";
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {

        Path homePath = Paths.get(HOME);
        assertTrue(Files.exists(homePath));
        System.out.println(homePath);

        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath))
            FileUtility.deleteFiles(playPath.toFile());
        assertTrue(Files.notExists(playPath));

        Files.createDirectory(playPath);
        assertTrue(Files.exists(playPath));

        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" + cntr);
            assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
            }
            assertTrue(Files.exists(tempFile));
        });

        System.out.println("Files.list");
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        System.out.println("Files.newDirectory");
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        System.out.println("Files.newDirectory with temp");
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().contains("temp"))
                .forEach(System.out::println);
    }

    public void givenADirectoryWhenWatchedListsAllTheActivities() throws IOException {
        Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new WatchServices(dir).processEvents();
    }
}