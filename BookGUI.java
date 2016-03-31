import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookGUI extends JFrame{
  //text label
  private JLabel welcomeLbl;

  //buttons
  private JButton viewBtn;
  private JButton searchBtn;
  private JButton addBtn;
  private JButton deleteBtn;
  private JButton quitBtn;

  //ActionListener handlers
  private VHandler viewHandler;
  private SHandler searchHandler;
  private AHandler addHandler;
  private DHandler deleteHandler;
  private QHandler quitHandler;

  //window size
  private static final int WIDTH = 500;
  private static final int HEIGHT = 150;

  //construct window
  public BookGUI(){
    setTitle("Welcome");
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(6,3));

    //create items and add text
    welcomeLbl = new JLabel("Welcome to your library. Please choose an option below:", SwingConstants.CENTER);
    viewBtn = new JButton("VIEW");
    searchBtn = new JButton("SEARCH");
    addBtn = new JButton("ADD");
    deleteBtn = new JButton("DELETE");
    quitBtn = new JButton("QUIT");

    //add items to panel
    pane.add(welcomeLbl);
    pane.add(viewBtn);
    pane.add(searchBtn);
    pane.add(addBtn);
    pane.add(deleteBtn);
    pane.add(quitBtn);

    //add ActionListners to buttons
    viewBtn.addActionListener(new VHandler());
    searchBtn.addActionListener(new SHandler());
    addBtn.addActionListener(new AHandler());
    deleteBtn.addActionListener(new DHandler());
    quitBtn.addActionListener(new QHandler());

    //set defaults
    setSize(WIDTH, HEIGHT);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  private class VHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){

    }
  }

  private class SHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){

    }
  }

  private class AHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){

    }
  }

  private class DHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){

    }
  }
  private class QHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){

    }
  }

  public static void main(String[] args){
    BookGUI b = new BookGUI();
  }
}
