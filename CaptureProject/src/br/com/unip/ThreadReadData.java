package br.com.unip;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

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
                        ImageIO.write(screenShot, "png", new File("c://OCR/myScrenShot.png"));
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
}
