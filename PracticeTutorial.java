//Testing plan: Accept: clicks
//              Not accepted: Typing, scrolling, sliding, hovering

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;   //import necessary libraries
import javax.imageio.*;
import java.io.*;

public class PracticeTutorial extends JFrame{//class header extends JFrame
	
	public static void main(String[] args){
		new PracticeTutorial();
	}
        public PracticeTutorial(){
                setSize(1150, 1150);
                setDefaultCloseOperation(EXIT_ON_CLOSE);        //Frame specifications, plus add panel
                setLocationRelativeTo(null);
                setResizable(true);
                Left l = new Left();
                add(l);
                setVisible(true);
        }
        
 
		class Left extends JPanel implements ActionListener, MouseListener{
			
			private JButton backB;
			
			private boolean hint;
			
			private JButton hintB;
			private JButton exit = new JButton("Exit");
			
			private JTextArea ta;
			
			private String info;
			
			private int next;
			
			private JButton nextB;
			
			private boolean flyknit;
			private boolean leather;        //body
			private boolean synleather;
			private boolean knit;
			
			private boolean sgpro;
            private boolean turf;
            private boolean indoor;      //studs
            private boolean fg;
            private boolean running;
            private boolean lifestyle;
            
            private boolean tall;
            private boolean med;     //uppers
            private boolean tiny;
            
			
            private Image supi;
			private Image primeknit2i;
			private Image lowcuti;
			private Image synthetic2i;     //images
			private Image synthetic1i;
			private Image softgroundi;
			private Image leatheri;
			private Image indoori;
			private Image fg2i;
			private Image fg1i;
			private Image artturfi;
			private Image stadium;
		
        
        public Left(){
			setBackground(Color.BLACK);
			addMouseListener(this);               //background color, add listener, layout is null
			
			setLayout(null);
			
			hint = false;
			
			hintB = new JButton("Do you want a hint?");
			hintB.setBounds(50, 725, 200, 50);                        //location of butons
			hintB.addActionListener(this);
			add(hintB);
			
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){            //exit button to exit out of Frame
					setVisible(false);
					dispose();
				}
			});	
			exit.setBounds(700,500,113,70);
			add(exit);
			
			backB = new JButton("Previous Shoe!");
			backB.setBounds(100, 1000, 150, 75);
			backB.addActionListener(this);
			add(backB);
			
			info = "";                   //text inside of JTextArea
			
			ta = new JTextArea(info);
			ta.setBounds(700, 0, 400 ,500);
			ta.setLineWrap(true);                      //textArea specifications
			ta.setWrapStyleWord(true);
			ta.setFont(ta.getFont().deriveFont(20.0f));
			ta.setEditable(false);
			add(ta);
			
			next = -1;
			
			nextB = new JButton("Next Shoe!");
			nextB.setBounds(1000, 1000, 100, 75);
			nextB.addActionListener(this);
			add(nextB);

			
			flyknit = false;
			knit = false; 
			synleather = false;   //body
			leather = false;
			
			sgpro = false;
			turf = false;
			indoor = false;    //studs
			fg = false;
			running = false;
			lifestyle = false;
			
		    tall = false;
		    med = false;      //uppers
		    tiny = false;  
			
		   
		    stadium = Toolkit.getDefaultToolkit().getImage("stadium.jpg");
			supi = Toolkit.getDefaultToolkit().getImage("superflyfg.jpg");
			primeknit2i = Toolkit.getDefaultToolkit().getImage("primeknit2.jpg");
			lowcuti = Toolkit.getDefaultToolkit().getImage("lowcut.jpg");
			synthetic2i = Toolkit.getDefaultToolkit().getImage("synthetic2.jpg");
			synthetic1i = Toolkit.getDefaultToolkit().getImage("synthetic1.jpg");
			softgroundi = Toolkit.getDefaultToolkit().getImage("sgpro.jpg");          //images
			leatheri = Toolkit.getDefaultToolkit().getImage("leather.jpg");
			indoori = Toolkit.getDefaultToolkit().getImage("indoor.jpg");
			fg2i = Toolkit.getDefaultToolkit().getImage("fg2.jpg");
			fg1i = Toolkit.getDefaultToolkit().getImage("fg1.jpg");
			artturfi = Toolkit.getDefaultToolkit().getImage("artificialturf.png");
			//lifestyle + running???
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(stadium, 0, 0, 1150, 1150, this);
			g.setColor(Color.BLUE);
			//g.fillRect(0, 0, 700, 700);
			
			if (next < 0){
				g.setFont(new Font("TimesRoman", Font.PLAIN, 45)); 
				g.drawImage(stadium, 0, 0, 1150, 1150, this);
				g.setColor(Color.YELLOW);
				g.drawString("CLICK 'NEXT SHOE!' TO BEGIN :-)", 0, 250);
				g.drawString("Please pay attention to the", 0, 300);
				g.drawString("following - you will need to", 0, 350);
				g.drawString("Memorize this stuff for the", 0, 400);
				g.drawString("Next section!!!", 0, 450);
				g.drawString("And when you need help, please", 0, 550);
				g.drawString("click on the hint buttons!", 0, 600);
				ta.setText("SHOE SHOP TUTORIAL");
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.setColor(Color.PINK);
				g.drawString("Here will be the number of parts you will have in your shoe", 350, 975);
				g.drawRect(420, 1000, 450, 100);
				g.setColor(Color.RED);
				g.drawString("Click the hint button for help", 15, 700);
				g.setColor(Color.ORANGE);
				g.drawString("Click here to back to previous shoe.", 0, 1000);
				g.drawString("Click here for next shoe.", 875, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 75));
				g.drawString("Directions", 450, 750);
				hint = false;
			}
			if (next == 0){
				g.drawImage(stadium, 0, 0, 1150, 1150, this);
				g.drawImage(supi, 0, 0 ,this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.drawString("Try clicking on parts of the shoe!", 100, 800); 
				g.setColor(Color.PINK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
				g.drawString("There are two parts in this shoe...", 400, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.setColor(Color.WHITE);
				//add(flyknitB);
				//add(tallB);
				
				if (hint){
					g.drawString("Parts: Body", 100, 825);
					g.drawString("Upper", 125, 850);
					hint = false;
				}
				if (flyknit){
					info = "The body of the Nike Mercurial Superfly IV is made of Flyknit, a very unique material that uses ultra strong yarn made by Nike. The combination of it being lightweight and flexible gives a sock like feeling, resulting in one of the best advantages for speed possible in a soccer shoe.";
					ta.setText(info);
					flyknit = false;
				}
				if (tall){
					info = "This is a one piece tall upper, called a 'Dynamic Fit collar' made of Flyknit. By covering the ankle, it gives more support, resulting in a sock like feeling that locks your foot in place (better fit).";
					ta.setText(info);
					tall = false;
				}
			}
			
			if (next == 1){
				g.drawImage(stadium, 0, 0, 1150, 1150, this); //g.fillRect(0, 0, 700, 700);
				ta.setText("");
				g.drawImage(primeknit2i, 0, 0, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.drawString("Try clicking on parts of the shoe!", 100, 800); 
				g.setColor(Color.PINK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
				g.drawString("There are two parts in this shoe...", 400, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.setColor(Color.WHITE);
				if (hint){
					g.drawString("Parts: Body", 100, 825);
					g.drawString("Upper", 125, 850);
					hint = false;
				}
				//add(medB);
				//add(knitB);
				if(knit){
					info = "The body of the Adidas PrimeKnit 2.0 is made of 'Adidas knit' material. Although this has the same concept of Nike's Flyknit, is is not nearly as popular.";
					ta.setText(info);
					knit = false;
				}
				if (med){
					info = "The shoe has a low cut upper through the heel section, then a very tall section at the achillie's area. Unlike the tall upper of the Superfly, when actually wearing this shoe, most will find that it does not even make that much contact with your foot, and is more of a marketing gimmick to make more people buy it.";
					ta.setText(info);
					med = false;
				}
			}
			
			if (next == 2){
				g.drawImage(stadium, 0, 0, 1150, 1150, this);//g.fillRect(0, 0, 700, 700);
				ta.setText("");
				g.drawImage(lowcuti, 0, 0, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.drawString("Try clicking on parts of the shoe!", 100, 800); 
				g.setColor(Color.PINK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
				g.drawString("There is only one part in this shoe...", 400, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.setColor(Color.WHITE);
				if (hint){
					g.drawString("Upper", 125, 850);
					hint = false;
				}
				//add(tinyB);
				if (tiny){
				
					//g.drawImage(lowcuti, 0, 0, this);
					info = "A low cut upper is the more traditional upper for a soccer shoe. This doesn't cover the ankle, which some players enjoy the feeling of.";
					ta.setText(info);
					tiny = false;
				}
			}
			
			if (next == 3){
				g.drawImage(stadium, 0, 0, 1150, 1150, this);//g.fillRect(0, 0, 700, 700);
				ta.setText("");
				g.drawImage(synthetic2i, 0, 0, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.drawString("Try clicking on parts of the shoe!", 100, 800); 
				g.setColor(Color.PINK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
				g.drawString("There is only one part in this shoe...", 400, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.setColor(Color.WHITE);
				if (hint){
					g.drawString("Parts: Any of the two shoes!!!", 100, 825);
					hint = false;
				}
				//g.drawImage(synthetic2i, 200, 600, this);
				//add(synleatherB);
				if (synleather){
					//g.drawImage(synthetic2i, 0, 0, this);
					info = "Unlike leather, synthetic leather is used to give shoes less weight and more durability, but doesn't come close to being as comfortable as leather and doesn't give as good of a touch for the ball.";
					ta.setText(info);
					synleather = false;
				}
			}
			
			if (next == 4){
				g.drawImage(stadium, 0, 0, 1150, 1150, this);//g.fillRect(0, 0, 700, 700);
				ta.setText("");
				g.drawImage(softgroundi, 0, 0, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.drawString("Try clicking on parts of the shoe!", 100, 800);
				g.setColor(Color.PINK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
				g.drawString("There is only one part in this shoe...", 400, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.setColor(Color.WHITE); 
				if (hint){
					g.drawString("Parts: The gold conical stud to the right", 100, 825);
					hint = false;
				}
				//add(sgproB);
				if (sgpro){
			
					info = "You can see the conical metal studs of the shoe. All shoes have some kind of plate with some kind of traction for some kind of playing surface! The shoes with the conical studs are meant to be played on soft ground surfaces (natural grass fields) that are extremely well mentatined. Usually proffesional players play on this type of grass. Also, the concial studs are removable and can be replaced.";
					ta.setText(info);
					sgpro = false;
				}
			}
			
			if (next == 5){
				g.drawImage(stadium, 0, 0, 1150, 1150, this);//g.fillRect(0, 0, 700, 700);
				ta.setText("");
				g.drawImage(leatheri, 0, 0, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.drawString("Try clicking on parts of the shoe!", 100, 800); 
				g.setColor(Color.PINK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
				g.drawString("There is only one part in this shoe...", 400, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.setColor(Color.WHITE);
				if (hint){
					g.drawString("Parts: The shoe", 100, 825);
					hint = false;
				}//add(leatherB);
				if (leather){
					
					info = "Almost no shoe is fully leather. But like the Nike Tiempo Legend shown on the left, some shoes have large quantity. Leather is soft, one of the best for ball control and touch, and naturally contorts to your foot. Unlike Synthetic leather, natural leather is more premium and made of animal hide, but is heavier and less durable.";
					ta.setText(info);
					leather = false;
				}
			}
			
			if (next == 6){
				g.drawImage(stadium, 0, 0, 1150, 1150, this);//g.fillRect(0, 0, 700, 700);
				ta.setText("");
				g.drawImage(indoori, 0, 0, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.drawString("Try clicking on parts of the shoe!", 100, 800); 
				g.setColor(Color.PINK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
				g.drawString("There is only one part in this shoe...", 400, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.setColor(Color.WHITE);
				if (hint){
					g.drawString("Parts: Any of the four bottoms of the shoes.", 100, 825);
					hint = false;
				}
				//add(indoorB);
				if(indoor){
					
					info = "You can see that the bottom plates of the shoes don't have any studs. These are indoor soccer shoes and are meant for more gym use for futsol, an indoor version of soccer.";
					ta.setText(info);
					indoor = false;
				}
			}
			
			if (next == 7){
				g.drawImage(stadium, 0, 0, 1150, 1150, this);//g.fillRect(0, 0, 700, 700);
				ta.setText("");
				g.drawImage(fg2i,0, 0, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.drawString("Try clicking on parts of the shoe!", 100, 800); 
				g.setColor(Color.PINK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
				g.drawString("There is only one part in this shoe...", 400, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.setColor(Color.WHITE);
				if (hint){
					g.drawString("Parts: Any of the studs", 100, 825);
					hint = false;
				}
				//add(fgB);
				if(fg){
					
					info = "This shoe is called a Firm Ground soccer shoe because the stud patterns are shaped like blades, practical for playing on natural outdoor grass, that are not soft. The studs are non removable, and are usually very durable.";
					ta.setText(info);
					fg = false;
				}
			}
			
			if (next == 8){
				g.drawImage(stadium, 0, 0, 1150, 1150, this);//g.drawString("Turf shoe", 300, 880);
				//g.fillRect(0, 0, 700, 700);
				ta.setText("");
				g.drawImage(artturfi, 0, 0, this);
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.drawString("Try clicking on parts of the shoe!", 100, 800); 
				g.setColor(Color.PINK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
				g.drawString("There is only one part in this shoe...", 400, 1000);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
				g.setColor(Color.WHITE);
				if (hint){
					g.drawString("Parts: The bottom of the shoe.", 100, 825);
					hint = false;
				}
				//add(turfB);
				if(turf){
					
					info = "This shoe called a Turf shoe, has very tiny rubber studs meant to be played on artificial grass and very hard surfaces.";
					ta.setText(info);
					turf = false;
				}
			}
			
			if (next > 8){
				g.setFont(new Font("TimesRoman", Font.PLAIN, 35)); 
				g.drawImage(stadium, 0, 0, 1150, 1150, this);
				g.setColor(Color.GREEN);
				g.drawString("YOU ARE DONE WITH THE TUTORIAL!", 0, 250);
				ta.setText("NEXT SECTION: SHOE SHOP GARAGE");
			}
		}
	
		
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == nextB){            //if the next button is pressed increase value of next int variable, then repaint
				next++;
				repaint();
			}
			
			if (e.getSource() == backB && next > -1){      //if the back button is pressed, decrease value of next, then repaint
				next--;
				repaint();
			}
			
			if (e.getSource() == hintB){             //if the hint button was pressed, make the boolean hint, true.
				hint = true;
				repaint();
			}

		}
				
		public void mouseEntered(MouseEvent e){        //if the mouse enters the component, request focus for the mouse on the JPannel
			requestFocus();
		}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e){                       //store x position and y position value of where the mouse was clicked in variables x and y
			int x = e.getX();
			int y = e.getY();
			if((x >= 36 && x <= 255) && (y >= 78 && y <= 136) && next == 0){        //depending on which shoe user is on, check by value of next, set the condition
				flyknit = true; //                                                    to the ares of the part of the shoe you want
				repaint();  //                                                        then change the associated boolean and call repaint() mehtod to go back to 
			} //                                                                      paintComponent() to display text according to what boolean is true
			else if((x >= 165 && x <= 241) && (y >= 26 && y <= 76) && next == 0){
				tall = true;
				repaint();
			}
			else if((x >= 3 && x <= 223) && (y >= 102 && y <= 143) && next == 1){
				knit = true;
				repaint();
			}
			else if((x >= 6 && x <= 80) && (y >= 61 && y <= 101) && next == 1){
				med = true;
				repaint();
			}
			else if((x >= 197 && x <= 314) && (y >= 25 && y <= 60) && next == 2){
				tiny = true;
				repaint();
			}
			else if((x >= 63 && x <= 718) && (y >= 1 && y <= 315) && next == 3){
				synleather = true;
				repaint();
			}
			else if((x >= 459 && x <= 507) && (y >= 355 && y <= 395) && next == 4){
				sgpro = true;
				repaint();
			}
			else if((x >= 0 && x <= 621) && (y >= 204 && y <= 480) && next == 5){
				leather = true;
				repaint();
			}
			else if( (((x >= 33 && x <= 164) && (y >= 18 && y <= 154)) || ((x >= 190 && x <= 299) && (y >= 39 && y <= 436)) || ((x >= 323 && x <= 433) && (y >= 36 && y <= 441)) || ((x >= 453 && x <= 569) && (y >= 44 && y <= 415))) && (next == 6) ){
				indoor = true;
				repaint();
			}
			else if( (((x >= 133 && x <= 192) && (y >= 266 && y <= 307)) || ((x >= 216 && x <= 280) && (y >= 303 && y <= 338)) || ((x >= 360 && x <= 481) && (y >= 372 && y <= 400)) ) && (next == 7) ){
				fg = true;
				repaint();
			}
			else if((x >= 138 && x <= 706) && (y >= 266 && y <= 307) && next == 8){ 
				turf = true;
				repaint();
			}
				
		}
	}
}
