package br.com.unip;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ThreadReadData extends Thread {

    public TransparentFrame windowReference;

    public void run(){
        try {
            while(true){
                if(this.windowReference.isShowing()){
                    Robot robot;
                    try {
                        //captura a tela
                        robot = new Robot();
                        BufferedImage screenShot = robot.createScreenCapture(
                            new Rectangle(windowReference.getLocationOnScreen().x, windowReference.getLocationOnScreen().y,
                                        windowReference.getSize().width, windowReference.getSize().height));
                        Graphics2D graphics = screenShot.createGraphics();

                        //salva a captura
                        ImageIO.write(screenShot, "png", new File("myScrenShot.png"));

                        //chama o tesseract - executavel, caminho da imagem e caminho da saída
                        Process process = new ProcessBuilder("Tesseract-OCR/tesseract.exe",
                                "myScrenShot.png,", "outTeresseract").start();

                        String everything = this.readFile("outTeresseract.txt");
                        System.out.println("OCR: " + everything);

                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String readFile(String file) {
        String everything = "";
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return everything;
    }
}
