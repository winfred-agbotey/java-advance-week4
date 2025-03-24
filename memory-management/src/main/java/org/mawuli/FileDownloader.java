package org.mawuli;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {
    public static void main(String[] args) {
        String[] fileUrls = {
                "https://asset.cloudinary.com/deucnm0iz/4a3028b9e24a7c8a2912b19196721162",
                "https://asset.cloudinary.com/deucnm0iz/c01ac01e4667e0ed7556cc4a54729699",
                "https://asset.cloudinary.com/deucnm0iz/50ec4984a926fc91110f933d4f3c1115",
                "https://asset.cloudinary.com/deucnm0iz/585f89480807dad010d7fd50ee036a32",
                "https://asset.cloudinary.com/deucnm0iz/c65750832a98cb3e88d8ee44f35b052c",
                "https://asset.cloudinary.com/deucnm0iz/1e3d6d5743155238bc57a7de19890f17"
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String url : fileUrls) {
            executor.submit(() -> downloadFile(url));
        }

        executor.shutdown();
    }

    private static void downloadFile(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("Failed to download: " + fileUrl + " | HTTP Code: " + responseCode);
                return;
            }

            String fileName = "downloaded_" + fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
            try (InputStream in = connection.getInputStream();
                 FileOutputStream out = new FileOutputStream(fileName)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                System.out.println("Downloaded: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error downloading file: " + fileUrl + " | Error: " + e.getMessage());
        }
    }
}
