
import javax.swing.*;
import java.awt.*;
import Sweeper.Box;
import Sweeper.Coord;

public class JavaSweeper extends JFrame {

    private JPanel panel;
    private final int COLS = 15;
    private final int ROWS = 5;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new JavaSweeper();

    }

    private JavaSweeper () {
        setImages();
        initPanel();  //инициализация панели
        initFrame(); //инициализация фрейма


    }

    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Box box : Box.values()){
                    Coord coord = new Coord(box.ordinal()*IMAGE_SIZE,0);
                    g.drawImage((Image) box.image,
                        coord.x,coord.y,this); //рисуем бомбу на панели


                }
            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE,ROWS * IMAGE_SIZE));

        add (panel);

    }


    private void initFrame () {
        pack(); //устанавливает min размер для отображения всего содержимого
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //выход при нажатии "Х"
        setTitle("My Sweeper"); //название титульника
        setLocationRelativeTo(null); //расположение по центру экрана
        setResizable(false); //возможность изменять размер
        setVisible(true);
        setIconImage(getImage("icon"));
    }

    private void setImages() {
        for (Box box : Box.values()){
            box.image = getImage(box.name().toLowerCase());
        }

    }
    private Image getImage (String name){
        String filename = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename)); //полечение доступа к файлу
        return icon.getImage();

    }
}
