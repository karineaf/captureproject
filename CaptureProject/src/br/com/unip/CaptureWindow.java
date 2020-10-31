package br.com.unip;

import java.awt.*;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

public class CaptureWindow {

    public CaptureWindow(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        if(!gd.isWindowTranslucencySupported(TRANSLUCENT)){
            System.err.println("Translucido não é suportado");
            System.exit(0);
        }

        TransparentFrame tw = new TransparentFrame();
        tw.setOpacity(0.55f);
        tw.setVisible(true);
    }

}

