package practices.completableFTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

public class FutureTest {

    public void renderPage(CharSequence source) {

//        List<ImageInfo> info = scanForImageInfo(source);
//        // create 'Callable' which means download all the pics.
//        final Callable<List<ImageData>> task = () -> {
//            return info.stream()
//                    .map(ImageInfo::downloadImage)
//                    .collect(Collectors.toList());
//        };

        List<ImageInfo> info = scanForImageInfo(source);
        info.forEach(imageInfo -> CompletableFuture.supplyAsync(imageInfo::downloadImage).thenAccept(this::renderImage));


    }

    public void renderWithErr(CharSequence source) {
        ExecutorService executors = Executors.newFixedThreadPool(3);

        Function<ImageInfo, ImageData> infoToData = imageInfo -> {
            CompletableFuture<ImageData> imageDataFuture = CompletableFuture.supplyAsync(imageInfo::downloadImage, executors);

            try {
                return imageDataFuture.get(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                imageDataFuture.cancel(true);
                return ImageData.createIcon(e);
            } catch (ExecutionException e) {
                return ImageData.createIcon(e);
            } catch (TimeoutException e) {
                return ImageData.createIcon(e);
            }
        };


//        Function<ImageInfo, ImageData> infoToData = imageInfo -> {
//            CompletableFuture<ImageData> imageDataFuture =
//                    CompletableFuture.supplyAsync(imageInfo::downloadImage, executors);
//            try {
//                return imageDataFuture.get(5, TimeUnit.SECONDS);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                imageDataFuture.cancel(true);
////                return ImageData.createIcon(e);
//            } catch (ExecutionException e) {
////                throw launderThrowable(e.getCause());
//            } catch (TimeoutException e) {
////                return ImageData.createIcon(e);
//            }
//        };
    }


    private <U> void renderImage(U u) {
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        return new ArrayList<>();
    }

    private static class ImageInfo {
        public <R> R downloadImage(ImageInfo imageInfo) {
            return null;

        }

        public <U> U downloadImage() {
            return null;
        }
    }

    private static class ImageData {
        public static <R> R downloadImage(ImageInfo imageInfo) {
            return null;

        }

        public static ImageData createIcon(Exception e) {
            return null;
        }
    }


    public static void main(String[] args){

        int result = testTCF();
        System.out.println("Result:   " + result);
    }

    private static int testTCF(){

        int result = 3;

        try {

            Object obj = null;

            if (obj.equals(1)){

            }

        }catch (Exception e){
            System.out.println("Exception....");
        }finally {
            result = result + 3;
            System.out.println("Finally:   " + result);
        }

        return result;
    }
}
