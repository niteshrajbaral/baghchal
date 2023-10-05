import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class BotFrame extends JFrame implements ActionListener {
    private JPanel contentPane;

    JTextField goat_killed;
    JTextField goat_remain;
    private JTextField goatPlaced;
    JLabel turn_label;
    
    private JButton tigerMoveButton;
    private JButton placeGoatOk;
    private JTextField goatSourceTextField;
    private JTextField goatDestinationTextField;
    private JButton goatMoveButton;
    private String goatpath="src\\goat-icon.png";
    private String tigerpath="src\\tiger-icon.png";
    int source;
    int destination;
    int move = 1;
    int tigermove = 0;
    int goatused = 0;
    int botSuggestSource;
    int botSuggestDestination;
    int singleEatingSource;
    int singleEatingDestination;
    int singleEatingPosition;
    static int GOAT=2,TIGER=1,EMPTY=0;
    JLabel[][] labels=new JLabel[5][5];

    int[] row = {1,0,0,0,1,
                 0,0,0,0,0,
                 0,0,0,0,0,
                 0,0,0,0,0,
                 1,0,0,0,1};
    
    String calculate(int row) {
        if (row == 1) {
            return "src\\tiger-icon.png";
        }
        if (row == 2) {
            return "src\\goat-icon.png";
        } else
            return "null.png";
    }

    public int getBotSource(){
        suggestMove();
        System.out.println("bot suggest source " + botSuggestSource);
        
        return botSuggestSource;
    }
    public int getBotDestination(){
    suggestMove();
       
        System.out.println("bot suggest destination " + botSuggestDestination);
        return botSuggestDestination;
    }
    public boolean checkEating(int source, int destination){
        if (source== 0) { if(destination== 2 && row[1]==2){ return true;}} 
            if (source== 0) { if(destination== 10 && row[5]==2){ return true;}} 
            if (source== 0) { if(destination== 12 && row[6]==2){ return true;}} 
    
    
    
            if (source== 1) { if(destination== 3 && row[2]==2){ return true;}}
            if (source== 1) { if(destination== 11 && row[6]==2){ return true;}}
        
            if (source== 2) { if(destination== 0 && row[1]==2){ return true;}} 
            if (source== 2) { if(destination== 4 && row[3]==2){ return true;}} 
            if (source== 2) { if(destination== 12 && row[7]==2){ return true;}}
            if (source== 2) { if(destination== 10 && row[6]==2){ return true;}} 
            if (source== 2) { if(destination== 14 && row[8]==2){ return true;}} 
    
    
            if (source== 3) { if(destination== 1 && row[2]==2){ return true;}}
            if (source== 3) { if(destination== 13 && row[8]==2){ return true;}}
    
            if (source== 4) { if(destination== 2 && row[3]==2){ return true;}} 
            if (source== 4) { if(destination== 14 && row[9]==2){ return true;}} 
            if (source== 4) { if(destination== 12 && row[8]==2){ return true;}} 
    
            if (source== 5) { if(destination== 15 && row[10]==2){ return true;}}
            if (source== 5) { if(destination== 7 && row[6]==2){ return true;}}
    
            if (source== 6) { if(destination== 16 && row[11]==2){ return true;}} 
            if (source== 6) { if(destination== 18 && row[12]==2){ return true;}} 
            if (source== 6) { if(destination== 8 && row[7]==2){ return true;}} 
    
    
            if (source== 7) { if(destination== 5 && row[6]==2){ return true;}} 
            if (source== 7) { if(destination== 9 && row[8]==2){ return true;}} 
            if (source== 7) { if(destination== 17 && row[12]==2){ return true;}} 
    
            if (source== 8) { if(destination== 6 && row[7]==2){ return true;}} 
            if (source== 8) { if(destination== 16 && row[12]==2){ return true;}} 
            if (source== 8) { if(destination== 18 && row[13]==2){ return true;}} 
    
    
            if (source== 9) { if(destination== 7 && row[8]==2){ return true;}}
            if (source== 9) { if(destination== 19 && row[14]==2){ return true;}}
    
            if (source== 10) { if(destination== 0 && row[5]==2) {return true;}} 
            if (source== 10) { if(destination== 20 && row[15]==2){ return true;}} 
            if (source== 10) { if(destination== 12 && row[11]==2){ return true;}}
            if (source== 10) { if(destination== 22 && row[16]==2){ return true;}} 
            if (source== 10) { if(destination== 2 && row[6]==2) {return true;}}
    
    
            if (source== 11) { if(destination== 1 && row[6]==2){ return true;}} 
            if (source== 11) { if(destination== 13 && row[12]==2){ return true;}} 
            if (source== 11) { if(destination== 21 && row[16]==2){ return true;}}
            
            if (source== 12) { if(destination== 0 && row[6]==2) {return true;}}
            if (source== 12) { if(destination== 20 && row[16]==2){ return true;}}
            if (source== 12) { if(destination== 4 && row[8]==2) {return true;}}
            if (source== 12) { if(destination== 24 && row[18]==2){ return true;}}
            if (source== 12) { if(destination== 2 && row[7]==2) {return true;}}
            if (source== 12) { if(destination== 22 && row[17]==2){ return true;}}
            if (source== 12) { if(destination== 10 && row[11]==2){ return true;}}
            if (source== 12) { if(destination== 14 && row[13]==2){ return true;}}
    
            if (source== 13) { if(destination== 3 && row[8]==2) {return true;}} 
            if (source== 13) { if(destination== 23 && row[18]==2){ return true;}} 
            if (source== 13) { if(destination== 11 && row[12]==2){ return true;}} 
    
            if (source== 14) { if(destination== 22 && row[18]==2){ return true;}} 
            if (source== 14) { if(destination== 4 && row[9]==2) {return true;}} 
            if (source== 14) { if(destination== 12 && row[13]==2){ return true;}}
            if (source== 14) { if(destination== 2 && row[8]==2) {return true;}} 
            if (source== 14) { if(destination== 24 && row[19]==2){ return true;}}
    
            if (source== 15) { if(destination== 5 && row[10]==2){ return true;}}
            if (source== 15) { if(destination== 17 && row[16]==2){ return true;}}
    
            if (source== 16) { if(destination== 6 && row[11]==2){ return true;}} 
            if (source== 16) { if(destination== 8 && row[12]==2){ return true;}} 
            if (source== 16) { if(destination== 18 && row[17]==2){ return true;}} 
    
    
    
            if (source== 17) { if(destination== 15 && row[16]==2){ return true;}} 
            if (source== 17) { if(destination== 19 && row[18]==2){ return true;}} 
            if (source== 17) { if(destination== 7 && row[12]==2){ return true;}} 
    
            if (source== 18) { if(destination== 6 && row[12]==2){ return true;}} 
            if (source== 18) { if(destination== 16 && row[17]==2){ return true;}} 
            if (source== 18) { if(destination== 8 && row[13]==2){ return true;}} 
    
    
            if (source== 19) { if(destination== 9 && row[14]==2){ return true;}}
            if (source== 19) { if(destination== 17 && row[18]==2){ return true;}}
    
            if (source== 20) { if(destination== 22 && row[21]==2){ return true;}} 
            if (source== 20) { if(destination== 10 && row[15]==2){ return true;}} 
            if (source== 20) { if(destination== 12 && row[16]==2){ return true;}} 
           
            if (source== 21) { if(destination== 23 && row[22]==2){ return true;}}
            if (source== 21) { if(destination== 11 && row[16]==2){ return true;}}
    
            if (source== 22) { if(destination== 20 && row[21]==2){ return true;}} 
            if (source== 22) { if(destination== 24 && row[23]==2){ return true;}} 
            if (source== 22) { if(destination== 12 && row[17]==2){ return true;}}
            if (source== 22) { if(destination== 10 && row[16]==2){ return true;}} 
            if (source== 22) { if(destination== 14 && row[18]==2){ return true;}}
    
            if (source== 23) { if(destination== 13 && row[18]==2){ return true;}}
            if (source== 23) { if(destination== 21 && row[22]==2){ return true;}}
    
            if (source== 24) { if(destination== 12 && row[18]==2){ return true;}} 
            if (source== 24) { if(destination== 22 && row[23]==2){ return true;}} 
            if (source== 24) { if(destination== 14 && row[19]==2){ return true;}} 
            return false;
     }
     public boolean singleEating(int position) {
        int[] line1 = {0, 1, 2, 3, 4};
        int[] line2={5,6,7,8,9};
        int[] line3={10,11,12,13,14};
        int[] line4={15,16,17,18,19};
        int[] line5={20,21,22,23,24};
        int[] line6={0,5,10,15,20};
        int[] line7={1,6,11,16,21};
        int[] line8={2,7,12,17,22};
        int[] line9={3,8,13,18,23};
        int[] line10={4,9,14,19,24};
        int[] line11={0,6,12,18,24};
        int[] line12={4,8,12,16,20};
    
        for(int i=1; i <=3;i++){
            if(line1[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line2[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line3[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line4[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line5[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line6[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line7[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line8[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line9[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line10[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
        for(int i=1; i <=3;i++){
            if(line11[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        
        }
        for( i=1; i <=3;i++){
            if(line12[i]==position){
            if((row[i-1]==0 && row[i+1]==1)){
                System.out.println("it is eating from " + (i+1) +" position  " + " to " + (i-1) +"at line 1" + "it is " + position);
                singleEatingSource=i+1;
                singleEatingDestination=i-1;
                singleEatingPosition=position;
                return true;
            }
            if (row[i-1]==1 && row[i+1]==0){
                System.out.println("it is eating from " + (i-1) +" position  " + " to " + (i+1) +"at line 1" + "it is " + position);
                singleEatingSource= i-1;
                singleEatingDestination=i+1;
                singleEatingPosition=position;
                return true;
            }
        } 
        }
     } 
     return false;
    }




    public int suggestMove(){
        boolean eat;
        int i;
           //eating 
        for( i=0;i<=24;i++){
            if(row[i]==1){
                for(int a=0;a<=24;a++){
        eat = checkEating(i, a);
        if((eat==true) && (row[a]==0)){
           System.out.println("we are suggesting from eating section bot is suggesting source " + i + " and destination " + a);
            botSuggestSource= i;
            botSuggestDestination=a;
            
            return 0;
        }
        
    }}
     }
       
    //sure eat
    for( i=0;i<=24;i++){
        if(row[i]==1){
            for(int a=0;a<=24;a++){
                boolean check = checkLegalMoveAgain(i, a);
                if(check==true){
                    for(int j = 0; j<=24; j++){
                   boolean forkeat = checkEating(a,j);
                   if(row[j]==0){
                   if (forkeat == true){
                    boolean sureeat = singleEating(j);
                    if(sureeat==true){
                        System.out.println("we are suggesting from sure eat section bot is suggesting source " + i + " and destination " + a);
                        botSuggestSource= i;
                        botSuggestDestination=a;
                    }
                   }
                    }}
                
    }
    
    }}
    }
    //move tiger to center after move 30
    for( i=0;i<=24;i++){
        if(move>=30){
        if(row[i]==1){
            boolean check = checkLegalMoveAgain(i, 12);
           
    if((check==true) && (row[12]==0)){
       System.out.println("we are suggesting from center capture after move 30 section bot is suggesting source " + i + " and destination 12" );
        botSuggestSource= i;
        botSuggestDestination=12;
        
        return 0;
    }
}
}
    }   
    
    
      
    
     
     //forking
    for( i=0;i<=24;i++){
        if(row[i]==1){
            for(int a=0;a<=24;a++){
                boolean check = checkLegalMoveAgain(i, a);
                if(check==true && row[a]==0){
                    for(int j = 0; j<=24; j++){
                   boolean forkeat = checkEating(a,j);
                   if(row[j]==0){
                   if (forkeat == true){
                    System.out.println("start of forkeat");
                    System.out.println(" we are suggesting from forking section the tiger placed at "+ i + " will have eating position when it moves. it will jump from" + a + "  to  " + j);
                    System.out.println("we are suggesting from forking section bot is suggesting source " + i + " and destination " + a);
                    System.out.println("end of forkeat");
                    botSuggestSource=i;
                    botSuggestDestination=a;
                    return 0;
                   }
                    }}
                }
    eat = checkEating(i, a);
    if(eat==true){
        System.out.println("tiger is eating from " +i + " to " + a  );
    }
    
    }}
    }
    //random section
    for (int aa = 0; aa <= 100000; aa++) {
        int randomTiger = 0;
       
        Random random = new Random();
        int randomTigerNumber = random.nextInt(4) + 1;
        System.out.println("the random number  of tiger generated is " + randomTigerNumber);
    
        for ( i = 0; i <= 24; i++) {
            int legalRandomMove=0;
            if (row[i] == 1) {
                randomTiger++;
            if (randomTigerNumber == randomTiger) {
         for (int a = 0; a <= 24; a++) {
                    boolean randomTigerMove = checkLegalMoveAgain(i, a);
                    if (randomTigerMove == true) {
                        legalRandomMove++;
                    }
                }
                int randomTigerMoveNumberGenerated = randomTigerNumber = random.nextInt(legalRandomMove) + 1;
                int count=0;
                for (int a = 0; a <= 24; a++){
                   
                   boolean again = checkLegalMoveAgain(i,a);
                    if(again==true){
                        count++;
                   if ((randomTigerMoveNumberGenerated == count) && (row[i]==1) && (row[a] == 0) ){
                    System.out.println("we are suggesting from random section bot is suggesting source " + i + " and destination " + a);
                            botSuggestSource = i;
                            botSuggestDestination = a;
                            return 0;
                   }
                }
            }
            
            }
        }
        }

   
}
    
    return 0;
    
     }
     public int Issue(){
        for(int i =0;i<=2000;i++){
            suggestMove();
            source = botSuggestSource;
            destination = botSuggestDestination;
            boolean moveResult;
            moveResult = Move(source, destination);
            if(((row[source]==1) &&(moveResult==true)) &&  (row[destination]==0)){
                // printBoard();
                row[source]=0;
                row[destination]=1;
               
                printBoard();
                numberOfGoatEaten(goatused);
                
                System.out.println("new board");

                disableTxtField();
                move++;
                tigermove++;
                turnImagepath();

                contentPane.repaint();
        }return 0;
    }
    JOptionPane.showMessageDialog(null, "Please enter a valid goat move ");
    return 0;
     }
   
    
    public void actionPerformed(ActionEvent e) {
	
        if (e.getSource() == tigerMoveButton) {
            try {
               int i = Issue();
                }
			catch (NumberFormatException ex) {
                System.out.println("Invalid input format. Please enter valid integers.");
            }
        }
        printBoard();
        if (e.getSource() == goatMoveButton) {
            
               int  goatsource = Integer.parseInt(goatSourceTextField.getText());
               int  goatdestination = Integer.parseInt(goatDestinationTextField.getText());
                boolean moveGoatResult;
                moveGoatResult = checkLegalMoveAgain(goatsource, goatdestination);
                if((row[goatsource]==2) &&(moveGoatResult==true) &&  (row[goatdestination]==0)){
                    row[goatsource]=0;
                    row[goatdestination]=2;
                    goatSourceTextField.setText("");
                    goatDestinationTextField.setText("");
                    printBoard();
                    numberOfGoatEaten(goatused);
			      
                    disableTxtField();
                    move++;
                    turnImagepath(); 
                    
                    contentPane.repaint();
                }
                else {
                    // Value is out of range, ask the user to enter again
                    JOptionPane.showMessageDialog(null, "Please enter a valid goat move ");
                }
            }
        
            printBoard();
		if(e.getSource()== placeGoatOk){
			String textFieldValue = goatPlaced.getText();
            
            
			int intValue = Integer.parseInt(textFieldValue);
			if ((intValue >= 0 && intValue <= 24)&&row[intValue]==0) {
                row[intValue] = 2;
                goatPlaced.setText("");
                printBoard();
                
				goatused++;
                disableTxtField();
			    move++;
                turnImagepath();
                numberOfGoatEaten(goatused);
                contentPane.repaint();
            } else {
                // Value is out of range, ask the user to enter again
                JOptionPane.showMessageDialog(null, " invalid move! insert a goat at empty place.");
            }
			goatPlaced.setText("");
            printBoard();
		
			repaint();
        }
    }
    private void printBoard(){
        int x=0;
        for(int i = 0; i< 5; i++){
            for(int j = 0;j <5; j++){
                if(row[x] == TIGER){
                    labels[i][j].setIcon(new ImageIcon(tigerpath));
                }else if(row[x]== GOAT){
                    labels[i][j].setIcon(new ImageIcon(goatpath));
                }else{
                    labels[i][j].setIcon(new ImageIcon("null.png"));
                }
                x++;
            }
        }
    }
    
    // private void checkGoat(){}
    private void disableTxtField() {
        if (move % 2 == 1) {
            if((move/2)<20){
            goatPlaced.setEditable(true);
            goatSourceTextField.setEditable(false);
            goatDestinationTextField.setEditable(false);tigerMoveButton.setEnabled(false);
            goatMoveButton.setEnabled(false);
            placeGoatOk.setEnabled(true);
            }
            else{
                goatSourceTextField.setEditable(true);
                goatDestinationTextField.setEditable(true);
                 goatPlaced.setEditable(false);tigerMoveButton.setEnabled(false);
                 goatMoveButton.setEnabled(true);
                 placeGoatOk.setEnabled(false);
            }
        } else {
            goatPlaced.setEditable(false);
            goatSourceTextField.setEditable(false);
            goatDestinationTextField.setEditable(false);
            tigerMoveButton.setEnabled(true);
            goatMoveButton.setEnabled(false);
            placeGoatOk.setEnabled(false);
        }
    }

    

    public BotFrame() {

    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);



        //side ko component
        //TURN_OF KO TEXT
        JLabel lblNewLabel_2 = new JLabel("TURN OF : ");
        lblNewLabel_2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(794, 29, 123, 23);
        contentPane.add(lblNewLabel_2);

        //TURN OF PAXI KO IMAGE
        turn_label= new JLabel(); 
        turn_label = new JLabel("");
        turn_label.setIcon(new ImageIcon(goatpath));
        turn_label.setBounds(910, 10, 75, 70);
        contentPane.add(turn_label);

        //GOAT KILLED KO TEXT
        JLabel lblNewLabel_3 = new JLabel("GOAT KILLED :");
        lblNewLabel_3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(794, 114, 164, 23);
        contentPane.add(lblNewLabel_3);

        //Goat killed ko number
        
        goat_killed = new JTextField();
		goat_killed.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		goat_killed.setText("0");
		goat_killed.setBounds(1005, 117, 37, 24);
		goat_killed.setEditable(false);
		contentPane.add(goat_killed);
		goat_killed.setColumns(10);

        //goat remaining text
        JLabel lblNewLabel_4_1 = new JLabel("GOAT REMAINING :");
		lblNewLabel_4_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(794, 147, 212, 23);
		contentPane.add(lblNewLabel_4_1);

        //goat remaining textfield
        
        goat_remain = new JTextField();
		goat_remain.setText("20");
		goat_remain.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		goat_remain.setColumns(10);
		goat_remain.setBounds(1005, 147, 37, 24);
		goat_remain.setEditable(false);
		contentPane.add(goat_remain);

        //entergoat position
        JLabel goat_position_label = new JLabel("Enter goat position");
		goat_position_label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		goat_position_label.setBounds(794, 236, 266, 23);
		contentPane.add(goat_position_label);

        //Position text
        JLabel positionText = new JLabel("Position");
        positionText.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        positionText.setBounds(794, 269, 129, 23);
        contentPane.add(positionText);

        //goat position ko textfield
        goatPlaced = new JTextField();
        goatPlaced.setColumns(10);
        goatPlaced.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        goatPlaced.setBounds(910, 269, 37, 24);
        contentPane.add(goatPlaced);

        //goat position ko Ok button
        placeGoatOk = new JButton("OK");
        placeGoatOk.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
        placeGoatOk.setBounds(984, 269, 96, 25);
        contentPane.add(placeGoatOk);
        placeGoatOk.addActionListener(this);

        //reset button
        JButton btnNewButton = new JButton("RESET");
        btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		btnNewButton.setBounds(794, 606, 104, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BotFrameStartup mainGame= new BotFrameStartup();
				 mainGame.main(null);
			}
		});

 
		//exit button
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WelcomeFrame frame= new WelcomeFrame();
				frame.setVisible(true);
			}
		});
		exitButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		exitButton.setBounds(961, 606, 109, 35);
		contentPane.add(exitButton);
		
        //tiger ko ok button
        tigerMoveButton = new JButton("Ask bot to move");
        tigerMoveButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
        tigerMoveButton.setBounds(820, 445, 304, 29);
        // Add ActionListener to the "OK" button
        tigerMoveButton.addActionListener(this);
        contentPane.add(tigerMoveButton);

        // goat move

        //goat ko source text
        JLabel goat_source = new JLabel("Source");
		goat_source.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		goat_source.setBounds(794, 302, 129, 23);
		contentPane.add(goat_source);

        //goat ko source ko text field
        goatSourceTextField = new JTextField();
        goatSourceTextField.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        goatSourceTextField.setColumns(10);
        goatSourceTextField.setBounds(910, 305, 37, 24);
        contentPane.add(goatSourceTextField);

        
        // dest
        JLabel goat_dest = new JLabel("Dest");
		goat_dest.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		goat_dest.setBounds(961, 302, 81, 23);
		contentPane.add(goat_dest);
		
        //goat ko dest ko text field 
        goatDestinationTextField = new JTextField();
        goatDestinationTextField.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        goatDestinationTextField.setColumns(10);
        goatDestinationTextField.setBounds(1043, 302, 37, 24);
        contentPane.add(goatDestinationTextField);

        //goat ko source ra dest ko ok button
        goatMoveButton = new JButton("OK");
        goatMoveButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
        goatMoveButton.setBounds(910, 349, 96, 25);
        // Add ActionListener to the "OK" button
        goatMoveButton.addActionListener(this);
        contentPane.add(goatMoveButton);

        int y =0 ;
        int z=0;
	    	for (int labelRow = 0; labelRow < labels.length; labelRow++) {
	            int x =0;
	            for (int labelCol = 0; labelCol < labels[labelRow].length; labelCol++) {
	                JLabel label = new JLabel(Integer.toString(z));
                    label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
	                labels[labelRow][labelCol] = label;
	                getContentPane().add(label);
	                label.setBounds(58+x, 32+y, 63, 61);
	                x += 144;
                    z++;
	            }
	            y += 144;
	        }
        printBoard();

        for (int i=0 ;i<=4 ;i++) {
            for(int j=0 ;j<=4 ;j++){
                final int finalI = i;
                final int finalJ = j;
                labels[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                        if (goatPlaced.isEditable()) {
                            goatPlaced.setText(labels[finalI][finalJ].getText());
                        }
                        else if (goatSourceTextField.isEditable() && goatSourceTextField.getText().isEmpty()) {
                                goatSourceTextField.setText(labels[finalI][finalJ].getText()); 
                        }
                        
                        else{ 
                            
                            goatDestinationTextField.setText(labels[finalI][finalJ].getText());

                        }  
                     }
                });
            }
        }
        // // board ko image display
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 751, 703);
        lblNewLabel.setIcon(new ImageIcon("src\\board.png"));
        contentPane.add(lblNewLabel);


        disableTxtField();
        move++;

    }
    public void numberOfGoatEaten(int goatused) {
        int noOfGoatInBoard = 0;
        int r = 0; 
        for (int i = 0; i <=24; i++) {
            if (row[i] == 2) {
                noOfGoatInBoard++;
            }
        }
         r = goatused- noOfGoatInBoard; 
        goat_killed.setText(Integer.toString(r));
        int goatRemain=20-goatused;
        goat_remain.setText(Integer.toString(goatRemain));
        if (r>=5){
            
        WinnerDisplay display= new WinnerDisplay();
        display.setVisible(true);
        }
    }
    public void turnImagepath(){
        if (move % 2 == 0){ 
            turn_label.setIcon(new ImageIcon(goatpath));
        }   
        else{
            turn_label.setIcon(new ImageIcon(tigerpath));
        }       
}
    public boolean checkLegalMoveAgain(int source, int destination) {
        if ((source == 0) && (destination == 1 || destination == 6 || destination == 5)) {
            return true;
        }
        if ((source == 1) && (destination == 0 || destination == 6 || destination == 2)) {
            return true;
        }
        if ((source == 2)
                && (destination == 1 || destination == 3 || destination == 6 || destination == 7 || destination == 8)) {
            return true;
        }
        if ((source == 3) && (destination == 2 || destination == 4 || destination == 8)) {
            return true;
        }
        if ((source == 4) && (destination == 3 || destination == 8 || destination == 9)) {
            return true;
        }
        if ((source == 5) && (destination == 0 || destination == 6 || destination == 10)) {
            return true;
        }
        if ((source == 6) && (destination == 0 || destination == 1 || destination == 2 || destination == 5
                || destination == 7 || destination == 10 || destination == 11 || destination == 12)) {
            return true;
        }
        if ((source == 7) && (destination == 2 || destination == 6 || destination == 8 || destination == 12)) {
            return true;
        }
        if ((source == 8) && (destination == 2 || destination == 3 || destination == 4 || destination == 7
                || destination == 9 || destination == 12 || destination == 13 || destination == 14)) {
            return true;
        }
        if ((source == 9) && (destination == 4 || destination == 8 || destination == 14)) {
            return true;
        }
        if ((source == 10) && (destination == 5 || destination == 11 || destination == 15 || destination == 16
                || destination == 6)) {
            return true;
        }
        if ((source == 11) && (destination == 6 || destination == 10 || destination == 12 || destination == 16)) {
            return true;
        }
        if ((source == 12) && (destination == 6 || destination == 7 || destination == 8 || destination == 11
                || destination == 13 || destination == 16 || destination == 17 || destination == 18)) {
            return true;
        }
        if ((source == 13) && (destination == 8 || destination == 12 || destination == 14 || destination == 18)) {
            return true;
        }
        if ((source == 14) && (destination == 9 || destination == 13 || destination == 19 || destination == 8 || destination == 18)) {
            return true;
        }
        if ((source == 15) && (destination == 10 || destination == 16 || destination == 20)) {
            return true;
        }
        if ((source == 16) && (destination == 10 || destination == 11 || destination == 12 || destination == 15
                || destination == 17 || destination == 20 || destination == 21 || destination == 22)) {
            return true;
        }
        if ((source == 17) && (destination == 12 || destination == 16 || destination == 18 || destination == 22)) {
            return true;
        }
        if ((source == 18) && (destination == 12 || destination == 13 || destination == 14 || destination == 17
                || destination == 19 || destination == 22 || destination == 23 || destination == 24)) {
            return true;
        }
        if ((source == 19) && (destination == 14 || destination == 18 || destination == 24)) {
            return true;
        }
        if ((source == 20) && (destination == 15 || destination == 16 || destination == 21)) {
            return true;
        }
        if ((source == 21) && (destination == 20 || destination == 16 || destination == 22)) {
            return true;
        }
        if ((source == 22) && (destination == 21 || destination == 17 || destination == 23 || destination == 16
                || destination == 18)) {
            return true;
        }
        if ((source == 23) && (destination == 22 || destination == 18 || destination == 24)) {
            return true;
        }
        if ((source == 24) && (destination == 23 || destination == 18 || destination == 19)) {
            return true;
        }

        else
            return false;
    }

    public boolean Move(int source, int destination) {
        int i = 0;
        if ((source == 0) && (destination == 1 || destination == 6 || destination == 5)) {
            return true;
        }
        if ((source == 1) && (destination == 0 || destination == 6 || destination == 2)) {
            return true;
        }
        if ((source == 2)
                && (destination == 1 || destination == 3 || destination == 6 || destination == 7 || destination == 8)) {
            return true;
        }
        if ((source == 3) && (destination == 2 || destination == 4 || destination == 8)) {
            return true;
        }
        if ((source == 4) && (destination == 3 || destination == 8 || destination == 9)) {
            return true;
        }
        if ((source == 5) && (destination == 0 || destination == 6 || destination == 10)) {
            return true;
        }
        if ((source == 6) && (destination == 0 || destination == 1 || destination == 2 || destination == 5
                || destination == 7 || destination == 10 || destination == 11 || destination == 12)) {
            return true;
        }
        if ((source == 7) && (destination == 2 || destination == 6 || destination == 8 || destination == 12)) {
            return true;
        }
        if ((source == 8) && (destination == 2 || destination == 3 || destination == 4 || destination == 7
                || destination == 9 || destination == 12 || destination == 13 || destination == 14)) {
            return true;
        }
        if ((source == 9) && (destination == 4 || destination == 8 || destination == 14)) {
            return true;
        }
        if ((source == 10) && (destination == 5 || destination == 11 || destination == 15 || destination == 16
                || destination == 6)) {
            return true;
        }
        if ((source == 11) && (destination == 6 || destination == 10 || destination == 12 || destination == 16)) {
            return true;
        }
        if ((source == 12) && (destination == 6 || destination == 7 || destination == 8 || destination == 11
                || destination == 13 || destination == 16 || destination == 17 || destination == 18)) {
            return true;
        }
        if ((source == 13) && (destination == 8 || destination == 12 || destination == 14 || destination == 18)) {
            return true;
        }
        if ((source == 14) && (destination == 9 || destination == 13 || destination == 18 || destination == 19 || destination == 8 )) {
            return true;
        }
        if ((source == 15) && (destination == 10 || destination == 16 || destination == 20)) {
            return true;
        }
        if ((source == 16) && (destination == 10 || destination == 11 || destination == 12 || destination == 15
                || destination == 17 || destination == 20 || destination == 21 || destination == 22)) {
            return true;
        }
        if ((source == 17) && (destination == 12 || destination == 16 || destination == 18 || destination == 22)) {
            return true;
        }
        if ((source == 18) && (destination == 12 || destination == 13 || destination == 14 || destination == 17
                || destination == 19 || destination == 22 || destination == 23 || destination == 24)) {
            return true;
        }
        if ((source == 19) && (destination == 14 || destination == 18 || destination == 24)) {
            return true;
        }
        if ((source == 20) && (destination == 15 || destination == 16 || destination == 21)) {
            return true;
        }
        if ((source == 21) && (destination == 20 || destination == 16 || destination == 22)) {
            return true;
        }
        if ((source == 22) && (destination == 21 || destination == 17 || destination == 23 || destination == 16
                || destination == 18)) {
            return true;
        }
        if ((source == 23) && (destination == 22 || destination == 18 || destination == 24)) {
            return true;
        }
        if ((source == 24) && (destination == 23 || destination == 18 || destination == 19)) {
            return true;
        }
        // eating

        if (source == 0) {
            if (destination == 2 && row[1] == 2) {
                row[1] = 0;
                i++;
                return true;
            }
        }
        if (source == 0) {
            if (destination == 10 && row[5] == 2) {
                row[5] = 0;
                i++;
                return true;
            }
        }
        if (source == 0) {
            if (destination == 12 && row[6] == 2) {
                row[6] = 0;
                i++;
                return true;
            }
        }

        if (source == 1) {
            if (destination == 3 && row[2] == 2) {
                row[2] = 0;
                i++;
                return true;
            }
        }
        if (source == 1) {
            if (destination == 11 && row[6] == 2) {
                row[6] = 0;
                i++;
                return true;
            }
        }

        if (source == 2) {
            if (destination == 0 && row[1] == 2) {
                row[1] = 0;
                i++;
                return true;
            }
        }
        if (source == 2) {
            if (destination == 4 && row[3] == 2) {
                row[3] = 0;
                i++;
                return true;
            }
        }
        if (source == 2) {
            if (destination == 12 && row[7] == 2) {
                row[7] = 0;
                i++;
                return true;
            }
        }
        if (source == 2) {
            if (destination == 10 && row[6] == 2) {
                row[6] = 0;
                i++;
                return true;
            }
        }
        if (source == 2) {
            if (destination == 14 && row[8] == 2) {
                row[8] = 0;
                i++;
                return true;
            }
        }

        if (source == 3) {
            if (destination == 1 && row[2] == 2) {
                row[2] = 0;
                i++;
                return true;
            }
        }
        if (source == 3) {
            if (destination == 13 && row[8] == 2) {
                row[8] = 0;
                i++;
                return true;
            }
        }

        if (source == 4) {
            if (destination == 2 && row[3] == 2) {
                row[3] = 0;
                i++;
                return true;
            }
        }
        if (source == 4) {
            if (destination == 14 && row[9] == 2) {
                row[9] = 0;
                i++;
                return true;
            }
        }
        if (source == 4) {
            if (destination == 12 && row[8] == 2) {
                row[8] = 0;
                i++;
                return true;
            }
        }

        if (source == 5) {
            if (destination == 15 && row[10] == 2) {
                row[10] = 0;
                i++;
                return true;
            }
        }
        if (source == 5) {
            if (destination == 7 && row[6] == 2) {
                row[6] = 0;
                i++;
                return true;
            }
        }

        if (source == 6) {
            if (destination == 16 && row[11] == 2) {
                row[11] = 0;
                i++;
                return true;
            }
        }
        if (source == 6) {
            if (destination == 18 && row[12] == 2) {
                row[12] = 0;
                i++;
                return true;
            }
        }
        if (source == 6) {
            if (destination == 8 && row[7] == 2) {
                row[7] = 0;
                i++;
                return true;
            }
        }

        if (source == 7) {
            if (destination == 5 && row[6] == 2) {
                row[6] = 0;
                i++;
                return true;
            }
        }
        if (source == 7) {
            if (destination == 9 && row[8] == 2) {
                row[8] = 0;
                i++;
                return true;
            }
        }
        if (source == 7) {
            if (destination == 17 && row[12] == 2) {
                row[12] = 0;
                i++;
                return true;
            }
        }

        if (source == 8) {
            if (destination == 6 && row[7] == 2) {
                row[7] = 0;
                i++;
                return true;
            }
        }
        if (source == 8) {
            if (destination == 16 && row[12] == 2) {
                row[12] = 0;
                i++;
                return true;
            }
        }
        if (source == 8) {
            if (destination == 18 && row[13] == 2) {
                row[13] = 0;
                i++;
                return true;
            }
        }

        if (source == 9) {
            if (destination == 7 && row[8] == 2) {
                row[8] = 0;
                i++;
                return true;
            }
        }
        if (source == 9) {
            if (destination == 19 && row[14] == 2) {
                row[14] = 0;
                i++;
                return true;
            }
        }

        if (source == 10) {
            if (destination == 0 && row[5] == 2) {
                row[5] = 0;
                i++;
                return true;
            }
        }
        if (source == 10) {
            if (destination == 20 && row[15] == 2) {
                row[15] = 0;
                i++;
                return true;
            }
        }
        if (source == 10) {
            if (destination == 12 && row[11] == 2) {
                row[11] = 0;
                i++;
                return true;
            }
        }
        if (source == 10) {
            if (destination == 22 && row[16] == 2) {
                row[16] = 0;
                i++;
                return true;
            }
        }
        if (source == 10) {
            if (destination == 2 && row[6] == 2) {
                row[6] = 0;
                i++;
                return true;
            }
        }

        if (source == 11) {
            if (destination == 1 && row[6] == 2) {
                row[6] = 0;
                i++;
                return true;
            }
        }
        if (source == 11) {
            if (destination == 13 && row[12] == 2) {
                row[12] = 0;
                i++;
                return true;
            }
        }
        if (source == 11) {
            if (destination == 21 && row[16] == 2) {
                row[16] = 0;
                i++;
                return true;
            }
        }

        if (source == 12) {
            if (destination == 0 && row[6] == 2) {
                row[6] = 0;
                i++;
                return true;
            }
        }
        if (source == 12) {
            if (destination == 20 && row[16] == 2) {
                row[16] = 0;
                i++;
                return true;
            }
        }
        if (source == 12) {
            if (destination == 4 && row[8] == 2) {
                row[8] = 0;
                i++;
                return true;
            }
        }
        if (source == 12) {
            if (destination == 24 && row[18] == 2) {
                row[18] = 0;
                i++;
                return true;
            }
        }
        if (source == 12) {
            if (destination == 2 && row[7] == 2) {
                row[7] = 0;
                i++;
                return true;
            }
        }
        if (source == 12) {
            if (destination == 22 && row[17] == 2) {
                row[17] = 0;
                i++;
                return true;
            }
        }
        if (source == 12) {
            if (destination == 10 && row[11] == 2) {
                row[11] = 0;
                i++;
                return true;
            }
        }
        if (source == 12) {
            if (destination == 14 && row[13] == 2) {
                row[13] = 0;
                i++;
                return true;
            }
        }

        if (source == 13) {
            if (destination == 3 && row[8] == 2) {
                row[8] = 0;
                i++;
                return true;
            }
        }
        if (source == 13) {
            if (destination == 23 && row[18] == 2) {
                row[18] = 0;
                i++;
                return true;
            }
        }
        if (source == 13) {
            if (destination == 11 && row[12] == 2) {
                row[12] = 0;
                i++;
                return true;
            }
        }

        if (source == 14) {
            if (destination == 22 && row[18] == 2) {
                row[18] = 0;
                i++;
                return true;
            }
        }
        if (source == 14) {
            if (destination == 4 && row[9] == 2) {
                row[9] = 0;
                i++;
                return true;
            }
        }
        if (source == 14) {
            if (destination == 12 && row[13] == 2) {
                row[13] = 0;
                i++;
                return true;
            }
        }
        if (source == 14) {
            if (destination == 2 && row[8] == 2) {
                row[8] = 0;
                i++;
                return true;
            }
        }
        if (source == 14) {
            if (destination == 24 && row[19] == 2) {
                row[19] = 0;
                i++;
                return true;
            }
        }

        if (source == 15) {
            if (destination == 5 && row[10] == 2) {
                row[10] = 0;
                i++;
                return true;
            }
        }
        if (source == 15) {
            if (destination == 17 && row[16] == 2) {
                row[16] = 0;
                i++;
                return true;
            }
        }

        if (source == 16) {
            if (destination == 6 && row[11] == 2) {
                row[11] = 0;
                i++;
                return true;
            }
        }
        if (source == 16) {
            if (destination == 8 && row[12] == 2) {
                row[12] = 0;
                i++;
                return true;
            }
        }
        if (source == 16) {
            if (destination == 18 && row[17] == 2) {
                row[17] = 0;
                i++;
                return true;
            }
        }

        if (source == 17) {
            if (destination == 15 && row[16] == 2) {
                row[16] = 0;
                i++;
                return true;
            }
        }
        if (source == 17) {
            if (destination == 19 && row[18] == 2) {
                row[18] = 0;
                i++;
                return true;
            }
        }
        if (source == 17) {
            if (destination == 7 && row[12] == 2) {
                row[2] = 0;
                i++;
                return true;
            }
        }

        if (source == 18) {
            if (destination == 6 && row[12] == 2) {
                row[12] = 0;
                i++;
                return true;
            }
        }
        if (source == 18) {
            if (destination == 16 && row[17] == 2) {
                row[17] = 0;
                i++;
                return true;
            }
        }
        if (source == 18) {
            if (destination == 8 && row[13] == 2) {
                row[13] = 0;
                i++;
                return true;
            }
        }

        if (source == 19) {
            if (destination == 9 && row[14] == 2) {
                row[14] = 0;
                i++;
                return true;
            }
        }
        if (source == 19) {
            if (destination == 17 && row[18] == 2) {
                row[18] = 0;
                i++;
                return true;
            }
        }

        if (source == 20) {
            if (destination == 22 && row[21] == 2) {
                row[21] = 0;
                i++;
                return true;
            }
        }
        if (source == 20) {
            if (destination == 10 && row[15] == 2) {
                row[15] = 0;
                i++;
                return true;
            }
        }
        if (source == 20) {
            if (destination == 12 && row[16] == 2) {
                row[16] = 0;
                i++;
                return true;
            }
        }

        if (source == 21) {
            if (destination == 23 && row[22] == 2) {
                row[22] = 0;
                i++;
                return true;
            }
        }
        if (source == 21) {
            if (destination == 11 && row[16] == 2) {
                row[16] = 0;
                i++;
                return true;
            }
        }

        if (source == 22) {
            if (destination == 20 && row[21] == 2) {
                row[21] = 0;
                i++;
                return true;
            }
        }
        if (source == 22) {
            if (destination == 24 && row[23] == 2) {
                row[23] = 0;
                i++;
                return true;
            }
        }
        if (source == 22) {
            if (destination == 12 && row[17] == 2) {
                row[17] = 0;
                i++;
                return true;
            }
        }
        if (source == 22) {
            if (destination == 10 && row[16] == 2) {
                row[16] = 0;
                i++;
                return true;
            }
        }
        if (source == 22) {
            if (destination == 14 && row[18] == 2) {
                row[18] = 0;
                i++;
                return true;
            }
        }

        if (source == 23) {
            if (destination == 13 && row[18] == 2) {
                row[18] = 0;
                i++;
                return true;
            }
        }
        if (source == 23) {
            if (destination == 21 && row[22] == 2) {
                row[22] = 0;
                i++;
                return true;
            }
        }

        if (source == 24) {
            if (destination == 12 && row[18] == 2) {
                row[18] = 0;
                i++;
                return true;
            }
        }
        if (source == 24) {
            if (destination == 22 && row[23] == 2) {
                row[23] = 0;
                i++;
                return true;
            }
        }
        if (source == 24) {
            if (destination == 14 && row[19] == 2) {
                row[19] = 0;
                i++;
                return true;
            }
        }

        return false;
    }
}


