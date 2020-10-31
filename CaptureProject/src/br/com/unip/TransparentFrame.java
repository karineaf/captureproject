package br.com.unip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class TransparentFrame extends JFrame implements MouseMotionListener, ActionListener {

    public TransparentFrame(){
        addMouseMotionListener(this);
        setUndecorated(true);
        setLayout(new GridBagLayout());
        setSize(150,150);
        setLocation(200,200);

        ThreadReadData t = new ThreadReadData();
        t.windowReference = this;
        t.start();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //posição da janela de acordo com o ponteiro do  mouse
        this.setLocation(e.getLocationOnScreen().x - this.getSize().width/2 ,
                         e.getLocationOnScreen().y - this.getSize().height/2);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent arg0){}

}
