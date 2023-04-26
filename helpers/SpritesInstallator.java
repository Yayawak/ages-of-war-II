package helpers;

import java.awt.Image;
import java.io.File;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
// import java.util.stream.Collectors;
import java.util.stream.Stream;
// import javax.sound.sampled.SourceDataLine;

public class SpritesInstallator {
    public static List<Image> getSpritesInFolder(String relativePath) {
    // public static LinkedList<Image> getSpritesInFolder(String relativePath) {
        // relativePath = "charactes/Knight/Knight_1";
        String basePath = new File("").getAbsolutePath();
        basePath += "/images/";
        String fullPath = basePath + relativePath;
        return Stream.of(new File(fullPath).listFiles())
            .filter(f -> f.isFile())
            .map(f -> f.getAbsolutePath().replace(
                new File("").getAbsolutePath() + "/images/", "")
            )
            .sorted((f1, f2) -> f1.compareTo(f2))
            // .peek(System.out::println)
            .map(f -> ImageData.getSprite(f))
            .toList();
    }
}
