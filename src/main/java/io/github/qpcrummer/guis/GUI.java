package io.github.qpcrummer.guis;

import io.github.qpcrummer.Main;
import io.github.qpcrummer.launch.ScuffedLoadingGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static io.github.qpcrummer.guis.ConfigGUI.settingframe;
import static io.github.qpcrummer.guis.JavaGUI.javaframe;
import static io.github.qpcrummer.guis.LoadingGUI.icon;
import static io.github.qpcrummer.guis.UtilGUI.utilframe;
import static io.github.qpcrummer.guis.VersionGUI.versionframe;

public class GUI {

    public static ImageIcon background;

    static {
        background = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("assets/TaterMC%20V3%20RC4.png")));
    }
    public static ImageIcon utilitater;

    static {
        utilitater = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("assets/Utilitater.png")));
    }
    public static ImageIcon settingtater;

    static {
        settingtater = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("assets/SettingsTater.png")));
    }

    //Frames
    public static final JFrame frame = new JFrame();
    //Panels
    public static final JPanel panel = new JPanel();
    //Sub Panels
    public static final JPanel buttonsubpanel = new JPanel();
    public static final JPanel topsubpanel = new JPanel();
    public static final JPanel leftsubpanel = new JPanel();
    public static final JPanel rightsubpanel = new JPanel();
    //Buttons
    public static final JButton startbutton = new JButton("Start Minecraft");
    public static final JButton settingsbutton = new JButton("Settings",settingtater);
    public static final JButton versionbutton = new JButton("Version");
    public static final JButton utilsbutton = new JButton("Utils",utilitater);
    public static final JButton javabutton = new JButton("Java Configuration");
    //Labels
    private static final JLabel menupic = new JLabel(background);
    public static final JLabel launchername = new JLabel("Tater Launcher");

    public static void initializeGui() {

        try {
            Main.loadingGUI.dispose();
        } catch (Exception ignored) {
            System.out.println("Loading Screen Skipped");
        }
        //Main Frame
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tater Launcher");
        frame.setMinimumSize(new Dimension(510,510));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setIconImage(icon);
        frame.getContentPane().add(panel);
        JFrame.setDefaultLookAndFeelDecorated(false);

        //Panel Settings
        panel.setLayout(new BorderLayout());
        panel.add(menupic, BorderLayout.CENTER);
        panel.add(buttonsubpanel, BorderLayout.PAGE_END);
        panel.add(leftsubpanel, BorderLayout.LINE_START);
        panel.add(rightsubpanel, BorderLayout.LINE_END);
        panel.add(topsubpanel, BorderLayout.PAGE_START);


        buttonsubpanel.add(versionbutton);
        buttonsubpanel.add(startbutton);
        buttonsubpanel.add(javabutton);

        topsubpanel.add(settingsbutton);
        topsubpanel.add(launchername);
        topsubpanel.add(utilsbutton);


        //Label settings
        launchername.setFont(new Font("Serif", Font.BOLD, 40));

        //start button settings
        startbutton.setPreferredSize(new Dimension(150,50));
        startbutton.addActionListener(e -> {
            //Temp. removed for alternative launch method
            //startbutton.setText("Minecraft is starting!");
            ScuffedLoadingGUI.openTempLoadingScreen();
        });
        //settings button settings
        settingsbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
        settingsbutton.setHorizontalTextPosition(SwingConstants.CENTER);
        settingsbutton.addActionListener(e -> {
            System.out.println("Settings Was Pressed");
            settingframe.setVisible(true);
            ConfigGUI.initializeConfigGui();
        });

        //version button settings
        versionbutton.setPreferredSize(new Dimension(150,50));
        versionbutton.addActionListener(e -> {
            System.out.println("Version Button Was Pressed");
            versionframe.setVisible(true);
            VersionGUI.initializever();
        });

        //Java button settings
        javabutton.setPreferredSize(new Dimension(150,50));
        javabutton.addActionListener(e -> {
            javaframe.setVisible(true);
            System.out.println("Java Button Was Pressed");
            try {
                JavaGUI.initializejavaui();
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });

        //Util button settings
        utilsbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
        utilsbutton.setHorizontalTextPosition(SwingConstants.CENTER);
        utilsbutton.addActionListener(e -> {
            utilframe.setVisible(true);
            System.out.println("Util Button Was Pressed");
            UtilGUI.initializeUtil();
        });
        frame.pack();
    }
}