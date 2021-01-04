package com.company;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import static java.lang.Thread.sleep;
class ab {
    public static PointerInfo a;
    public static Point b;
    public static  String m_point(){
        a = MouseInfo.getPointerInfo();
        b = a.getLocation();
        return(b.toString());
    }
}
class g extends JPanel{
    public static PointerInfo a;
    public static Point b;
    public static int old_x,app_x,app_y,points;
    public static int old_y,go=0;
    public static int x=300,cx1=0,cy1,cx2,cy2,yflag=1,terminator=0,app_num,checker=1;
    public static int y=300;
    public static int xp_counter=0,min=100,max=600;
    public static int xn_counter=0;
    public static int x_counter=0;
    public static int yp_counter=0;
    public static int yn_counter=0;
    public static int y_counter=0;
    public static int i=0;
    public static int xp_str;
    public static int xn_str;
    public static int yp_str;
    public static int yn_str;
    public static int flag,y_flag=1,x_flag=0;
    public static int xp_inf=1;
    public static int xn_inf=0;
    public static int yp_inf=1;
    public static int yn_inf=0,inc=0,inc1;
    public static int rise=27;
    Boolean swapper=true;
    // n=b.x;
    public static  String m_point() {
        a = MouseInfo.getPointerInfo();
        b = a.getLocation();
        return (b.toString());
    }
    public void Apple(Graphics apple)  {
        if(checker==1) {
            Random r_num = new Random();
            app_num = r_num.nextInt((max - min) + 1) + min;
            app_x=app_num;
            app_num = r_num.nextInt((max - min) + 1) + min;
            app_y=app_num;
            rise+=27;
            checker=0;
        }
        apple.setColor(Color.red);
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("apple.png");
        apple.drawImage(i, app_x,app_y,20,20,this);
  //      apple.fillOval(app_x,app_y,20,20);
    }
    public static void Gameover(Graphics s)throws InterruptedException {
        if(yflag==0) {
            if (x - 54 <= 30 || x >= 725 ) {
                terminator=1;
            }
            if(points>=1)
            {
                if (x - rise <= 30)
                    terminator=1;
            }
        }
            else if(yflag==1)
            {
                if(y >= 660 || y-54 <= 30)
                {
                    terminator=1;
                }
                if(points>=1)
                {
                    if (y - rise <= 30)
                        terminator=1;
                }
            }
            if(terminator==1)
                System.exit(0);
    }
    public void paint(Graphics g) {
        m_point();
       Apple(g);
        try {
            Gameover(g);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Font font = new Font ("Courier New", 1, 25);
        g.setFont(font);
        g.drawString("POINTS: "+Integer.toString(points), 50, 60);
        g.setColor(Color.ORANGE);
        for(int x=0;x<=780;x+=30)
            g.fill3DRect(x, 0, 30, 30, true);
        for(int y=0;y<=720;y+=30)
            g.fill3DRect(0, y, 30, 30, true);
        for(int x=30;x<=750;x+=30)
            g.fill3DRect(x, 680, 30, 30, true);
        for(int y=30;y<=750;y+=30)
            g.fill3DRect(754, y, 30, 30, true);
        g.setColor(Color.GREEN);
        // Navigating Snake
        if (b.x > old_x) {
            xp_counter += 1;
        }
        if (b.x < old_x) {
            xn_counter += 1;
        }
        if (b.y > old_y) {
            yp_counter += 1;
        }
        if (b.y < old_y) {
            yn_counter += 1;
        }
        if (i == 20) {
            if (xp_counter > xn_counter)
                x_counter = xp_counter;
            else
                x_counter = xn_counter;
            if (yp_counter > yn_counter)
                y_counter = yp_counter;
            else
                y_counter = yn_counter;
            xp_str = xp_counter;
            xn_str = xn_counter;
            yp_str = yp_counter;
            yn_str = yn_counter;
            xn_counter = 0;
            xp_counter = 0;
            yn_counter = 0;
            yp_counter = 0;
            i = 0;
        }
        if (x_counter > y_counter) {
            if (xp_str > xn_str) {
                if (x_flag == 0) {
                    g.fillOval(x +=54, y, 25, 25);
                    g.fillOval(x - 27, y, 25, 25);
                    g.fillOval(x - 54, y, 25, 25);
                    if(points>=1) {
                        for (int restrict = 54; restrict <= rise; restrict += 27)
                            g.fillOval(x - restrict, y, 25, 25);
                    }
                    xp_inf = xp_str;
                    xn_inf = 0;
                }
                else {
                    g.fillOval(x++, y, 25, 25);
                g.fillOval(x - 27, y, 25, 25);
                g.fillOval(x - 54, y, 25, 25);
                    if(points>=1) {
                        for (int restrict = 54; restrict <= rise; restrict += 27)
                            g.fillOval(x - restrict, y, 25, 25);
                    }
                xp_inf = xp_str;
                xn_inf = 0;
                    }
            }
            else {
                g.fillOval(x--, y, 25, 25);
                g.fillOval(x - 27, y, 25, 25);
                g.fillOval(x - 54, y, 25, 25);
                if(points>=1) {
                    for (int restrict = 54; restrict <= rise; restrict += 27)
                        g.fillOval(x - restrict, y, 25, 25);
                }
                xn_inf = xn_str;
                xp_inf = 0;
            }
            flag = 1;
            yflag=0;
            y_flag = 0;
            inc = 27;
            inc1 = 54;
            x_flag=1;
        } else if (y_counter > x_counter) {
            if (yp_str > yn_str) {
                    if (y_flag == 0) {
                        g.fillOval(x, y+=54, 25, 25);
                        g.fillOval(x, y-27, 25, 25);
                        g.fillOval(x , y-54, 25, 25);
                        if(points>=1) {
                            for (int restrict = 54; restrict <= rise; restrict += 27)
                                g.fillOval(x, y - restrict, 25, 25);
                        }
                        yp_inf = yp_str;
                        yn_inf = 0;
                        y_flag=1;
                    }
                else {
                    g.fillOval(x, y++, 25, 25);
                    g.fillOval(x, y - 27, 25, 25);
                    g.fillOval(x, y - 54, 25, 25);
                        if(points>=1) {
                            for (int restrict = 54; restrict <= rise; restrict += 27)
                                g.fillOval(x, y - restrict, 25, 25);
                        }
                    yp_inf = yp_str;
                    yn_inf = 0;
                }
            }
            else {
                g.fillOval(x, y--, 25, 25);
                g.fillOval(x, y - 27, 25, 25);
                g.fillOval(x, y - 54, 25, 25);
                if (points >= 1){
                    for (int restrict = 54; restrict <= rise; restrict += 27)
                        g.fillOval(x, y - restrict, 25, 25);
            }
                yn_inf = yn_str;
                yp_inf = 0;
            }
            flag = 0;
            x_flag=0;
            yflag=1;
        }
        else if(x_counter==y_counter){
            if(flag==1)
            {
                if(xp_inf>xn_inf) {
                    g.fillOval(x++, y, 25, 25);
                    g.fillOval(x - 27, y, 25, 25);
                    g.fillOval(x - 54, y, 25, 25);
                    if (points >= 1){
                        for (int restrict = 54; restrict <= rise; restrict += 27)
                            g.fillOval(x - restrict, y, 25, 25);
                }
                }
                else if(xp_inf<xn_inf) {
                    g.fillOval(x--, y, 25, 25);
                    g.fillOval(x-27, y, 25, 25);
                    g.fillOval(x-54, y, 25, 25);
                    if(points>=1) {
                        for (int restrict = 54; restrict <= rise; restrict += 27)
                            g.fillOval(x - restrict, y, 25, 25);
                    }
                }
            }
            else if(flag==0){
                if (yp_inf >yn_inf) {
                    g.fillOval(x, y++, 25, 25);
                    g.fillOval(x, y-27, 25, 25);
                    g.fillOval(x, y-54, 25, 25);
                    if(points>=1) {
                        for (int restrict = 54; restrict <= rise; restrict += 27)
                            g.fillOval(x, y - restrict, 25, 25);
                    }
                }
                else if(yp_inf < yn_inf) {
                    g.fillOval(x, y--, 25, 25);
                    g.fillOval(x, y-27, 25, 25);
                    g.fillOval(x, y-54, 25, 25);
                    if(points>=1) {
                        for (int restrict = 54; restrict <= rise; restrict += 27)
                            g.fillOval(x, y - restrict, 25, 25);
                    }
                }
            }
        }
        if(yflag==1)
        {
            if((x<app_x+20 && y-rise<app_y+20) && (x>app_x-20 && y-rise>app_y-20)) {
                checker = 1;
                points++;
            }
        }
        else if(yflag==0)
        {
            if((x-rise<app_x+20 && y<app_y+20) && (x-rise>app_x-20 && y>app_y-20)){
                checker = 1;
                points++;
            }
        }
        if((x<app_x+20 && y<app_y+20) && (x>app_x-20 && y>app_y-20)){
            checker = 1;
            points++;
        }
        old_x=b.x;
        old_y=b.y;
        i++;
        xn_inf++;
        xp_inf++;
        yn_inf++;
        yp_inf++;
    }
}
public class Main {
    public static void main(String[] args)throws InterruptedException{
        // Creating game frame
        JFrame game=new JFrame("SNAKE GAME");
        game.setVisible(true);
        game.setBackground(Color.darkGray);
        game.setSize(300,300);
        game.setBounds(400, 50, 800, 750);
        game.getContentPane().add(new g());
        while(true) {
            game.repaint();
            sleep(10);
        }
    }
}