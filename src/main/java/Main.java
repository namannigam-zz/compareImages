import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

/**
 * Created by naman.nigam on 07/04/16.
 */
public class Main {


    public static void main(String[] args) {
        if (compareImages())
            System.out.println("Yay!");
        else
            System.out.println("Oops..");
    }

    private static boolean compareImages() {
        String filePath = "/Users/naman.nigam/GitHub/compareImages/src/main/resources/";
        String firstImage = new File(getFileDir(), imgFirst).getAbsolutePath();
        String secondImage = new File(getFilesDir(), imgSecond).getAbsolutePath();
        Bitmap bitmap1 = BitmapFactory.decodeFile(filePath + imgFirst);
        Bitmap bitmap2 = BitmapFactory.decodeFile(filePath + imgSecond);
        if (bitmap1.getWidth() != bitmap2.getWidth() ||
                bitmap1.getHeight() != bitmap2.getHeight()) {
            return false;
        }
        for (int y = 0; y < bitmap1.getHeight(); y++) {
            for (int x = 0; x < bitmap1.getWidth(); x++) {
                if (bitmap1.getPixel(x, y) != bitmap2.getPixel(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String imgFirst = "first.png";
    private static String imgSecond = "sec.png";

}