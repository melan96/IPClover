/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip_clover;

/**
 *
 * @author melandias
 */
public class IPC {
 
    
    //initialize IPC variables
    
   private int firstSegment;
   private int secondSegment;
   private int thirdSegment;
   private int fouthSegment;

    public IPC(int firstSegment, int secondSegment,int thirdSegment, int fourthSegment) {
        this.firstSegment = firstSegment;
        this.secondSegment = secondSegment;
        this.thirdSegment=thirdSegment;
        this.fouthSegment=fourthSegment;
    }
  
   public boolean checkValidityofInput(){
   
       if((this.firstSegment <=255)&&(this.secondSegment<=255)&&(this.thirdSegment <=255)&&(this.fouthSegment<=255)){
           return true;
       }else{
           return false;
       }
   }
   
   public String checkClass(){
   
       if(this.firstSegment<=127){
           return "A";
       }else if(this.firstSegment<=191){
           return "B";
       }else if(this.firstSegment<=223){
           return "C";
       }else if(this.firstSegment<=239){
           return "D";
       }else if(this.firstSegment<=255){
           return "E";
       }else{
           return "Wrong IP Address";
       }
   }
   
   public String checkSubnetMask(){
   
       if(checkClass()=="A"){
       return "255.0.0.0";
       }else if(checkClass()=="B"){
         return "255.255.0.0";
       }else if(checkClass()=="C"){
         return "255.255.255.0";
       }else{
           return "No SubnetMask Detected for CLASS D and E";
       }
   }
    
   public String displayIP(){
       return ""+this.firstSegment+""+this.secondSegment+"";
   }
    
   
   public void checkNetworkIDHostID(javax.swing.JTextField netID,javax.swing.JTextField hostID){
       
        if(checkClass()=="A"){
              netID.setText(""+this.firstSegment+" . ");
              hostID.setText((this.secondSegment+" . "+this.thirdSegment+" . "+this.fouthSegment));
       }else if(checkClass()=="B"){
               netID.setText((this.firstSegment+" . "+this.secondSegment));
              hostID.setText((this.thirdSegment+" . "+this.fouthSegment));
       }else if(checkClass()=="C"){
               netID.setText((this.firstSegment+" . "+this.secondSegment+" . "+this.thirdSegment));
              hostID.setText((""+this.fouthSegment+""));
       }else if(checkClass()=="D"){
              netID.setText((this.firstSegment+" . "+this.secondSegment+" . "+this.thirdSegment+" . "+this.fouthSegment));
              hostID.setText("");
       }else{
              netID.setText((""));
              hostID.setText("");
       }
   }
}