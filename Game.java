//Rishi Wadhwa, Srikar Nalamalapu
//Testing Plan: Accepted

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Game extends JFrame{//class header extends JFrame
        private static CardLayout cards = new CardLayout();
        private static JPanel cardPanel = new JPanel(cards);

        public static void main(String[] args){//copy + paste most stuff,
                //but add class1, class2, and class3 with card layout
                Game z = new Game();
        }
        public Game(){
                super("Shoe Shop");
                setSize(700, 740);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setLocation(0, 0);
                setResizable(true);
                ShoeShop zp = new ShoeShop();
                setContentPane(zp);
                setVisible(true);
        }
        class ShoeShop extends JPanel{
                private MainTitle mt;
                private DesignShop ds;
                private TriviaDif td;
                private TriviaQs tq;
                private int score = 20;
                //private PracticeTutorial pt;
                private Color c = new Color(84, 154, 160);
                private boolean hardb = false;
                private boolean mediumb = false;
                private boolean easyb = false;
                private int firstNum = 1;
                private int secondNum = 1;
				private int qCounter = 0;
                public ShoeShop(){
                        setLayout(new BorderLayout());
                        cardPanel.setLayout(cards);
                        mt = new MainTitle();
                        ds = new DesignShop(1);
                        td = new TriviaDif();
                        cardPanel.add(mt, "1");
                        cardPanel.add(ds, "2");
                        cardPanel.add(td, "5");
                        add(cardPanel,BorderLayout.CENTER);
                        cards.show(cardPanel,"1");
                }

                class MainTitle extends JPanel implements ActionListener{
                        private JButton credits;
                        private JButton trivia;
                        private JButton design;
                        private JButton tutorial;
                        private Image title;
                        public MainTitle(){
                                setLayout(null);
                                title = Toolkit.getDefaultToolkit().getImage("ShoeShop.png");
                                trivia = new JButton("Trivia");
                                design = new JButton("Design");
                                tutorial = new JButton("Tutorial");
                                tutorial.setBounds(250, 400, 200, 40);
                                trivia.setBounds(250, 480, 200, 40);
                                design.setBounds(250, 440, 200, 40);
                                add(tutorial);
                                add(trivia);
                                add(design);
                                tutorial.addActionListener(this);
                                trivia.addActionListener(this);
                                design.addActionListener(this);
                        }

                        public void paintComponent(Graphics g){
                                super.paintComponent(g);
                                setBackground(c);
                                g.drawImage(title, 175, 40, this);
                        }

                        public void actionPerformed(ActionEvent evt){
                                if(evt.getSource()==trivia){
                                        cards.show(cardPanel, "5");
                                }
                                else if(evt.getSource()==design){
                                        ds = new DesignShop(1);
                                        cardPanel.add(ds, "2");
                                        cards.show(cardPanel, "2");
                                }
                                else if(evt.getSource()==credits){
                                        cards.show(cardPanel, "4");
                                }
                                else if(evt.getSource() == tutorial){
                                    new PracticeTutorial();
                                }
                        }
                }
                class DesignShop extends JPanel implements ActionListener{//NEED A Back BUTTON AND ALSO STUFF FOR TRIVIA AND THIS CLASS NEEDS TO RESET AFTER YOU CLICK BACK
                        private JButton back;
                        private JTextArea prompt;
                        private DesignButtons dg;
                        private int [] whichPic = new int[3];
                        private int questionR = 0;
                        private DesignShop ds;
                        DesignShop(int question){
                                setLayout(null);
                                questionR = question;
                                dg = new DesignButtons();
                                prompt = new JTextArea("", 10, 5);
                                back = new JButton("Back");
                                prompt.setLineWrap(true);
                                prompt.setEditable(false);
                                prompt.setFont(new Font("SanSeriff", Font.PLAIN, 15));
                                if(questionR == 1){
                                    prompt.setText("I am a Defender who plays processional Soccer in the Barclay's Premier League on very soft grass. I want to buy a shoe that has the best touch, feel for the ball, and is more traditional. I would like to also have some part of the shoe that is is green and allows for a good sock like feel, for speed!");
                                }
                                else if(questionR == 2){
                                    prompt.setText("I am a player who is playing on my school's Varsity team. Most of my games and training in on turf. I am a striker and I need to run like the wind. So I need something flexible and sock like for the body of my shoe. I would also like the body of the shoe to be white. I want the traditional upper where it doesn't cover the ankle.");
                                }
                                add(prompt); 
                                prompt.setBounds(0, 0, 700, 100);
                                prompt.setForeground(Color.YELLOW);
                                prompt.setBackground(Color.DARK_GRAY);
                                add(dg);
                                dg.setBounds(0, 100, 700, 600);
                                back.setBounds(0, 690, 700, 30);
                                add(back);
                                back.addActionListener(this);
                        }
                        public void paintComponent(Graphics g){
                                super.paintComponent(g);
                                setBackground(Color.GRAY);
                                g.drawString("Test", 5, 10);
                        }
                        public void actionPerformed(ActionEvent evt){
                            if(evt.getSource() == back){
                                cards.show(cardPanel, "1");
                            }
                        }

                        class DesignButtons extends JPanel implements ActionListener{
                                private JRadioButton [] upper = new JRadioButton[3];
                                private ButtonGroup upperGrp = new ButtonGroup();
                                private JRadioButton [] bottom = new JRadioButton[3];
                                private ButtonGroup bottomGrp = new ButtonGroup();
                                private JRadioButton [] body = new JRadioButton[3];
                                private ButtonGroup bodyGrp = new ButtonGroup();
                                private Image [] pics = new Image[3];
                                private boolean [] correct = new boolean[3];
                                private JTextArea feedbackBoxD;
                                private JButton nextD;
                                DesignButtons(){
                                        setLayout(null);
                                        nextD = new JButton("Next");
                                        correct[0] = false;
                                        correct[1] = false;
                                        correct[2] = false;
                                        bottom[0] = new JRadioButton("Turf");//creates a JButton for each element of the 
                                        bottom[1] = new JRadioButton("StudsFG");//bottom array with the proper String label
                                        bottom[2] = new JRadioButton("StudsSgpro");
                                        body[0] = new JRadioButton("White Fly Knit");//creates a JButton for each element of the 
                                        body[1] = new JRadioButton("Leather");//body array with the proper String label
                                        body[2] = new JRadioButton("Orange Fly Knit");
                                        upper[0] = new JRadioButton("Tall Upper Black");//creates a JButton for each element of the 
                                        upper[1] = new JRadioButton("Tall Upper Green");//upper array with the proper String label
                                        upper[2] = new JRadioButton("Low Cut Upper");//all these JButtons 
                                        //are labeled by the component of the shoe
                                        feedbackBoxD = new JTextArea("", 100, 100);
                                        for(int i = 0; i < 3; i++){
                                            bottomGrp.add(bottom[i]);
                                            add(bottom[i]);
                                            bottom[i].addActionListener(this);
                                            bottom[i].setBounds(((150*i) + 175), 50, 150, 20);
                                        }
                                        for(int i = 0; i < 3; i++){
                                            bodyGrp.add(body[i]);
                                            add(body[i]);
                                            body[i].addActionListener(this);
                                            body[i].setBounds(((150*i) + 175), 30, 150, 20);
                                        }
                                        for(int i = 0; i <3; i++){
                                            upperGrp.add(upper[i]);
                                            add(upper[i]);
                                            upper[i].addActionListener(this);
                                            upper[i].setBounds(((150*i) + 175), 10, 150, 20);
                                        }
                                        feedbackBoxD.setText("Click on the buttons above to design a shoe!");
                                        feedbackBoxD.setBounds(370, 75, 370, 75);
                                        add(feedbackBoxD);
                                        feedbackBoxD.setEditable(false);
                                        add(nextD);
                                        nextD.setBounds(370, 150, 370, 50);
                                        nextD.addActionListener(this);
                                }
                                public void actionPerformed(ActionEvent evt){
                                    if(evt.getSource() == nextD){
                                            questionR++;
                                            ds = new DesignShop(questionR);
                                            cardPanel.add(ds, "2");
                                            cards.show(cardPanel, "2");
                                    }
                                    if(evt.getSource() == bottom[0]){//if this radio button is selected, it will change pics[0] to the proper image
                                        pics[0] = Toolkit.getDefaultToolkit().getImage("Turf.png");
                                    }
                                    else if(evt.getSource() == bottom[1]){//if this radio button is selected, it will change pics[0] to the proper image
                                        pics[0] = Toolkit.getDefaultToolkit().getImage("StudsFG.png");
                                    }
                                    else if(evt.getSource() == bottom[2]){//if this radio button is selected, it will change pics[0] to the proper image
                                        pics[0] = Toolkit.getDefaultToolkit().getImage("StudsSgpro.png");
                                    }
                                    if(evt.getSource() == body[0]){//if this radio button is selected, it will change pics[1] to the proper image
                                        pics[1] = Toolkit.getDefaultToolkit().getImage("BodyFlyKnit.png");
                                    }
                                    else if(evt.getSource() == body[1]){//if this radio button is selected, it will change pics[1] to the proper image
                                        pics[1] = Toolkit.getDefaultToolkit().getImage("BodyLeather.png");
                                    }
                                    else if(evt.getSource() == body[2]){//if this radio button is selected, it will change pics[1] to the proper image
                                        pics[1] = Toolkit.getDefaultToolkit().getImage("BodyOrange.png");
                                    }
                                    if(evt.getSource() == upper[0]){//if this radio button is selected, it will change pics[2] to the proper image
                                        pics[2] = Toolkit.getDefaultToolkit().getImage("TallUpper.png");
                                    }
                                    else if(evt.getSource() == upper[1]){//if this radio button is selected, it will change pics[2] to the proper image
                                        pics[2] = Toolkit.getDefaultToolkit().getImage("TallUpper2.png");
                                    }
                                    else if(evt.getSource() == upper[2]){//if this radio button is selected, it will change pics[2] to the proper image
                                        pics[2] = Toolkit.getDefaultToolkit().getImage("TinyUpper.png");
                                    }
                                    
                                    if(questionR == 1){
                                        if(evt.getSource() == bottom[2]){
                                                correct[0] = true;
                                        }

                                        if(evt.getSource() == body[1]){
                                                correct[1] = true;
                                        }

                                        if(evt.getSource() == upper[1]){
                                                correct[2] = true;
                                        }

                                        if(correct[0] && correct[1] && correct[2]){
                                                feedbackBoxD.setText("Good job!");
                                        }
                                    }
                                    else if(questionR == 2){
                                        if(evt.getSource() == bottom[0]){
                                            correct[0] = true;  
                                        }
                                        else{
                                            feedbackBoxD.setText("");
                                        }
                                        /*else if(evt.getSource() == bottom[1]){
                                            correct[0] = false;
                                        }
                                        else if(evt.getSource() == bottom[2]){
                                            correct[0] = false;
                                        }*/
                                        if(evt.getSource() == body[0]){
                                            correct[1] = true;  
                                        }
                                        else{
                                            feedbackBoxD.setText("");
                                        }
                                        /*else if(evt.getSource() == body[1]){
                                            correct[0] = false;
                                        }
                                        else if(evt.getSource() == body[2]){
                                            correct[0] = false;
                                        }*/
                                        if(evt.getSource() == upper[2]){
                                            correct[2] = true;  
                                        }
                                        else{
                                            feedbackBoxD.setText("");
                                        }
                                        /*else if(evt.getSource() == upper[1]){
                                            correct[0] = false;
                                        }
                                        else if(evt.getSource() == upper[0]){
                                            correct[0] = false;
                                        }*/
                                        
                                        if(correct[0] && correct[1] && correct[2]){
                                            feedbackBoxD.setText("Good job!");
                                        }
                                    }
                                    //pics[2] = Toolkit.getDefaultToolkit().getImage("TinyUpper.png");
                                    repaint();
                                }
                                public void paintComponent(Graphics g){
                                    super.paintComponent(g);
                                    setBackground(c);
                                    g.drawImage(pics[0], 0, 470, 700, 200, this);
                                    g.drawImage(pics[1], 0, 270, 700, 200, this);
                                    g.drawImage(pics[2], 0, 70, 350, 200, this);
                                }
                        }
                                
                }
                class TriviaDif extends JPanel implements ActionListener{
                    private JButton hard;
                    private JButton medium;
                    private JButton easy;
                    private JButton back;
                    private int min = 0;
                    private int max = 0;

                    TriviaDif(){
						setLayout(new GridLayout(4, 1));
                        hard = new JButton("Difficulty Level: Hard");
                        medium = new JButton("Difficult Level: Medium");
                        easy = new JButton("Difficult Level: Easy");
                        back = new JButton("Back");
                        add(hard);
                        add(medium);
                        add(easy);
                        add(back);
                        back.addActionListener(this);
                        hard.addActionListener(this);
                        medium.addActionListener(this);
                        easy.addActionListener(this);
                    }
                    public void actionPerformed(ActionEvent evt){
                        if(evt.getSource() == hard){
                            tq = new TriviaQs(5, 1, 0, 0, true);
                            cardPanel.add(tq, "3");
                            cards.show(cardPanel, "3");//AY SRIKAR, ITS RISHI DOE
                        }                               //aight so this part causes it to display the sane question for all three
                        else if(evt.getSource() == medium){//difficulty levels
                            tq = new TriviaQs(5, 6, 0, 0, true); 
                            cardPanel.add(tq, "3");
                            cards.show(cardPanel, "3");
                        }
                        else if(evt.getSource() == easy){
                            tq = new TriviaQs(5, 11, 0, 0, true);
                            cardPanel.add(tq, "3");
                            cards.show(cardPanel, "3");
                        }
                        if(evt.getSource() == back){
                            cards.show(cardPanel, "1");
                        }
                    }
                }
                class TriviaQs extends JPanel implements ActionListener{
                        private JButton back;
                        private JButton next = new JButton("Next");
                        private String [] questions = new String [16];
                        private JButton [] answers = new JButton [4];
                        private JTextArea box;
                        private JTextArea feedbackBox;
                        private String feedback = "";
                        private int [] order = new int [4];
                        private int first = 0;
                        private int second = 0;
                        private int third = 0;
                        private int fourth = 0;
                        private int whichAnswer = 0;
                        private String [] answersQ = new String[4];
                        private int [] asked = new int [5];
                        private int count;
                        private int maxR = 0;
                        private int minR = 0;
                        private int questionIntR = 0;
                        private int firstNumR = 0;
                        private boolean loop = false;
                        private Won wn;
                        TriviaQs(int max, int min, int questionInt, int firstNum, boolean runBefore){
                            maxR = max;
                            minR = min;
                            if(runBefore){
                                questionInt = minR;
                                firstNum = questionInt;
                            }
                            else{
                                questionInt++;
                            }
                            if(questionInt == (maxR + (minR))){
                                questionInt = minR;
                                loop = true;
                            }
                            feedbackBox = new JTextArea("", 50, 50);
                            
                            questionIntR = questionInt;
                            firstNumR = firstNum;
                            questions[0] = "Who won the most FIFA World Cups?";
                            questions[1] = "What is the highest score ever made in a soccer game?";
                            questions[2] = "Which player has scored the most World Cup goals?";
                            questions[3] = "What is the World Cup most valuable player award called?";
                            questions[4] = "Which country hosted the first World Cup tournament?";
                            questions[5] = "What is soccer called in most countries?";
                            questions[6] = "How often are the FIFA World Cups?";
                            questions[7] = "When was the last time Brazil won the World Cup championship at home?";
                            questions[8] = "How many Brazilian cities were hosting the World Cup games in 2014?";
                            questions[9] = "Which stadium holds the record for biggest attendance ever at a World Cup match?";
                            questions[10] = "How long is a soccer match that does not reach an overtime?";
                            questions[11] = "How many players are on a field at one time?";
                            questions[12] = "How many total people are allowed to defend the goals with their hands?";
                            questions[13] = "What type of card makes a player leave the field?";
                            questions[14] = "Of these players, who is considered one of the best footballers?";
                            back = new JButton("Back");
                            add(back);
                            back.setBounds(0, 690, 700, 30);
                            box = new JTextArea("", 100, 50);
                            box.setFont(new Font("SanSeriff",Font.PLAIN, 30));
                            box.setEditable(false);
                            box.setLineWrap(true);
                            box.setBackground(Color.GRAY);
                            box.setForeground(Color.BLUE);
                            add(feedbackBox);
                            feedbackBox.setEditable(false);
                            back.addActionListener(this);
                            setLayout(null);
                            feedbackBox.setBackground(Color.GRAY);
                            add(next);
                            next.setBounds(275, 475, 150, 40);
                            next.addActionListener(this);
                            order[0] = (int)(Math.random()*4+1) - 1 ;
                            first = order[0];
                            order[1] = (int)(Math.random()*4+1) - 1 ;
                            second = order[1];
                            while(second == first){
                                            order[1] = (int)(Math.random()*4+1) - 1 ;
                                            second = order[1];
                            }
                            order[2] = (int)(Math.random()*4+1) - 1 ;
                            third = order[2];
                            while((third == first) || (third == second)){
                                            order[2] = (int)(Math.random()*4+1) - 1 ;
                                            third = order[2];
                            }
                            order[3] = (int)(Math.random()*4+1) - 1 ;
                            fourth = order[3];
                            while((fourth == first) || (fourth == second) || (fourth == third)){
                                            order[3] = (int)(Math.random()*4+1) - 1 ;
                                            fourth = order[3];
                            }
                            switch(questionInt){
                                    case 1: answersQ[0] = "Brazil";
                                                    answersQ[1] = "Argentina";
                                                    answersQ[2] = "U.S.A";
                                                    answersQ[3] = "Germany";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 2: answersQ[0] = "149-0";
                                                    answersQ[1] = "187-0";
                                                    answersQ[2] = "71-0";
                                                    answersQ[3] = "34-0";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 3: answersQ[0] = "Miroslav Klose (Germany)";
                                                    answersQ[1] = "Just Fontaine (France)";
                                                    answersQ[2] = "Ronaldo Luiz de Lima (Brazil)";
                                                    answersQ[3] = "Diego Maradona (Argentina)";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 4: answersQ[0] = "The Golden Ball";
                                                    answersQ[1] = "The Beckenbauer Bust";
                                                    answersQ[2] = "The Golden Boot";
                                                    answersQ[3] = "The Pele Prize";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 5: answersQ[0] = "Uruguay";
                                                    answersQ[1] = "United States";
                                                    answersQ[2] = "Britain";
                                                    answersQ[3] = "Italy";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 6: answersQ[0] = "Football";
                                                    answersQ[1] = "Soccer";
                                                    answersQ[2] = "Basketball";
                                                    answersQ[3] = "Hockey";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 7: answersQ[0] = "4 Years";
                                                    answersQ[1] = "3 Years";
                                                    answersQ[2] = "5 Years";
                                                    answersQ[3] = "6 Years";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 8: answersQ[0] = "Not listed";
                                                    answersQ[1] = "1950";
                                                    answersQ[2] = "2002";
                                                    answersQ[3] = "1998";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 9: answersQ[0] = "12";
                                                    answersQ[1] = "6";
                                                    answersQ[2] = "14";
                                                    answersQ[3] = "10";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 10: answersQ[0] = "Brazil's Maracane Stadium";
                                                    answersQ[1] = "Mexico's Estadio Azteca";
                                                    answersQ[2] = "The US's Rose Bowl";
                                                    answersQ[3] = "England's Wembley Stadium";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 11: answersQ[0] = "90 Minutes";
                                                    answersQ[1] = "70 Minutes";
                                                    answersQ[2] = "60 Minutes";
                                                    answersQ[3] = "120 Minutes";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 12: answersQ[0] = "11 Players";
                                                    answersQ[1] = "13 Players";
                                                    answersQ[2] = "12 Players";
                                                    answersQ[3] = "10 Playerse";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 13: answersQ[0] = "2 People";
                                                    answersQ[1] = "1 Person";
                                                    answersQ[2] = "4 People";
                                                    answersQ[3] = "6 People";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 14: answersQ[0] = "Red Card";
                                                    answersQ[1] = "Yellow Card";
                                                    answersQ[2] = "Black Card";
                                                    answersQ[3] = "Purple Card";
                                                    box.setText(questions[questionInt-1]);
                                                    break;
                                    case 15: answersQ[0] = "Lionel Messi";
                                                    answersQ[1] = "Angel de Maria";
                                                    answersQ[2] = "Arjen Robben";
                                                    answersQ[3] ="Thomas Muller";
                                                    box.setText(questions[questionInt-1]);
                                                    break;

                            }
                            add(box);
                            box.setBounds(75, 75, 550, 100);
                            feedbackBox.setBounds(275, 425, 150, 25);
                            answers[first] = new JButton("");
                            answers[second] = new JButton("");
                            answers[third] = new JButton("");
                            answers[fourth] = new JButton("");
                            answers[first].setText(answersQ[0]);
                            answers[second].setText(answersQ[1]);
                            answers[third].setText(answersQ[2]);
                            answers[fourth].setText(answersQ[3]);
                            add(answers[0]);
                            add(answers[1]);
                            add(answers[2]);
                            add(answers[3]);
                            answers[0].setBounds(250, 240, 200, 40);
                            answers[1].setBounds(250, 280, 200, 40);
                            answers[2].setBounds(250, 320, 200, 40);
                            answers[3].setBounds(250, 360, 200, 40);
                            answers[0].addActionListener(this);
                            answers[1].addActionListener(this);
                            answers[2].addActionListener(this);
                            answers[3].addActionListener(this);
                        }
                        public void paintComponent(Graphics g){
                                setBackground(c);
                                super.paintComponent(g);
                        }
                        public void actionPerformed(ActionEvent evt){
                                if(evt.getSource() == back){
                                        cards.show(cardPanel, "1");
                                        feedbackBox.setText("");
                                }
                                if(evt.getSource() == next){
                                    tq = new TriviaQs(maxR, minR, questionIntR, firstNumR, false);
                                    cardPanel.add(tq, "3");
                                    cards.show(cardPanel, "3");
                                    qCounter++;
                                    if(qCounter == 5){
                                        wn = new Won(score);
                                        cardPanel.add(wn, "6");
                                        cards.show(cardPanel, "6");
                                    }

                                }
                                if((evt.getSource() == answers[0]) && (answers[0].getText().equals(answersQ[0]))){
                                        feedbackBox.setForeground(Color.GREEN);
                                        feedbackBox.setText("Good job! You are correct!");
                                }
                                else if((evt.getSource() == answers[0]) && !(answers[0].getText().equals(answersQ[0]))){
                                        feedbackBox.setForeground(Color.RED);
                                        feedbackBox.setText("You are wrong, try again");
                                        score--;
                                }
                                if((evt.getSource() == answers[1]) && (answers[1].getText().equals(answersQ[0]))){
					feedbackBox.setForeground(Color.GREEN);
                                        feedbackBox.setText("Good job! You are correct!");
                                }
                                else if((evt.getSource() == answers[1]) && !(answers[1].getText().equals(answersQ[0]))){
					feedbackBox.setForeground(Color.RED);
                                        feedbackBox.setText("You are wrong, try again");
                                        score--;
                                }
                                if((evt.getSource() == answers[2]) && (answers[2].getText().equals(answersQ[0]))){
					feedbackBox.setForeground(Color.GREEN);
                                        feedbackBox.setText("Good job! You are correct!");
                                }
                                else if((evt.getSource() == answers[2]) && !(answers[2].getText().equals(answersQ[0]))){
					feedbackBox.setForeground(Color.RED);
                                        feedbackBox.setText("You are wrong, try again");
                                        score--;
                                }
                                if((evt.getSource() == answers[3]) && (answers[3].getText().equals(answersQ[0]))){
					feedbackBox.setForeground(Color.GREEN);
                                        feedbackBox.setText("Good job! You are correct!");
                                }
                                else if((evt.getSource() == answers[3]) && !(answers[3].getText().equals(answersQ[0]))){
					feedbackBox.setForeground(Color.RED);
                                        feedbackBox.setText("You are wrong, try again");
                                        score--;
                                }
                                

                            }
                        }
                class Won extends JPanel implements ActionListener{
                    private JTextArea feedbackWin;
                    private JButton back;
                    private Image messiBeast;
                    Won(int score1){
                        setLayout(null);
                        back = new JButton("Back");
                        if(score1 < 0 ){
                            score1 = 0;
                        }
                        messiBeast = Toolkit.getDefaultToolkit().getImage("messi.gif");
                        back.setBounds(0, 680, 700, 30);
                        feedbackWin = new JTextArea("Good job! You beat this difficulty level! Your score is " + score1, 300, 300);
                        feedbackWin.setBounds(200, 100, 300, 200);
                        feedbackWin.setForeground(Color.YELLOW);
                        feedbackWin.setBackground(Color.BLACK);
                        add(feedbackWin);
                        add(back);
                        back.addActionListener(this);
                    }
                    public void paintComponent(Graphics g){
                        super.paintComponent(g);
                        g.drawImage(messiBeast, 100, 400, this);
                        setBackground(new Color(84, 154, 160));
                    }
                    public void actionPerformed(ActionEvent evt){
                        if(evt.getSource() == back){
                                cards.show(cardPanel, "1");
                        }
                    }
                }


                
        }
}





/*
                //class1 is tutorial (this will be a nested class that
gives the user atutorial) implements various listeners{
                //global variables
                //buttons
                //boolean for sole
                //boolean for body
                //boolean for laces
                //boolean for uppers
                //different whole shoe images

                //constructor{
                //images
                //declare global variables
                //set layout to no layout because we want the presentation
to be fun andall random over the screen
                //add a button that will continue into the game
                //}
                                //paint component method{
                                                //draw the Strings with all
the instructions (like a presentation
that from which you learn in an interactive presentation)
                                                //draw black outlined boxes
on top of each part: draw a black box on
the laces, draw a black box on the body, draw a black box on the
upper, draw a black box on the sole
                                                //if a boolean for sole was
clicked,
                                                        //add a JTextField,
that explains more about it
                                                //if a boolean for shoe
lace was clicked,
                                                        //add a JTextField,
that explains more about it
                                                //if a boolean for upper
was clicked,
                                                        //add a JTextField,
that explains more about it
                                                //if a boolean for shoe
body was clicked,
                                                        //add a JTextField,
that explains more about it

                                //}

                                //all event handeler methods
                                //if user clicks in between the shoe lace
box, it will change a lace
value to true
                                //if user clicks in between the sole box,
it will change a sole
boolean value to true
                                //if user clicks in between the body box,
it will change the body
boolean to true
                                //if user clicks in between upper box box,
it will change the upper
boolean to true
                //}

                //class2 is customize a shoe based on what you learned from
the tutorial
extends various Listeners{
                //declare global variables
                //images(of one whole shoe cropped up) - the parts
                //constructor
                //set layout to NO layout with potential shoe in center,
shoe parts left
and right and a slider north, and leave space below for text field and a
button
                                //paint component method{
                                                //JTextfield on bottom to
prompt user what to do
                                                //if user drags image close
to or on the shoe, draw the image
automatically onto the desired location
        //TRICKY                        //depending on where the user puts
the slider, all the parts
resize porportionally to the slider prompted for example: location 30 -
50 is size 8, 50 - 70 is size 9, etc.
                                                //after user clicks "Done!"
button below, check if the size was
right, and the parts were correct. paint over text field and draw
another text field with feedback.
                                                //if user still  has
something incorrect, the text field would have
prompted user to try again,
                                                // AND ALSO, it will draw a
little colored pointer to where the
problem was
                                //}

                                //all event handeler methods
                                //if somethings were triggered, change
boolean values
                //}

                //class3 is an interactive quiz that tests you on more
thought provoking
things
                //declare global variables
                //radio buttons
                //buttons
                //images
                //constructor
                                //set layout to grid layout, with two rows
and two collumns
                                //add objects like 4 Radiobuttons and
JTextfields
                                //add strings that are the questions
                //paint component method
                                //use multiple if statements to decide what
answer was chosen
                                //set the buttons to the answers of the
question that will be asked

                //add event handler methods
                        //if a button or a radio button was clicked, change
a boolean value
*/

