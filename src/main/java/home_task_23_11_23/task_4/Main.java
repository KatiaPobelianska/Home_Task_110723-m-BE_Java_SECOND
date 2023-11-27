package home_task_23_11_23.task_4;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

/*4 Напишите код для скачивания пяти картинок c сайта https://doodles.google*/
public class Main {
    public static void main(String[] args) throws IOException {
        String baseUrl = "https://www.google.com";// URL страницы с Google
        String doodleUrl = baseUrl + "/doodles";  // URL страницы с Google Doodles


        // Получаем HTML страницы с Google Doodles
        org.jsoup.nodes.Document document = Jsoup.connect(doodleUrl).get();

        // Извлекаем URL изображений
        int count = 0;
        for (org.jsoup.nodes.Element imageEl : document.select("img")) {
            String imageURL = imageEl.attr("src");

            if (!imageURL.isEmpty()) {
                imageURL = "https:" + imageURL;
                downLoadImage(imageURL, "doodle_" + count + ".jpg");
                count++;

                if (count >=5) break;
            }
        }
    }

    private static void downLoadImage(String imageURL, String destinationFileName) throws MalformedURLException {
        URL url = new URL(imageURL);
        try (InputStream inputStream = url.openStream()) {
            Path destinationPath = Path.of(destinationFileName);
            Files.copy(inputStream, destinationPath);
            System.out.println("Изображение сохранено: " + destinationPath.toAbsolutePath());
            System.out.println("Абсолютный путь: " + destinationPath.toAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
