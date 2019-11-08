import java.text.SimpleDateFormat;  
import java.util.Date; 

class testJava {
    public static void main(String[] args) {

        Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
    String strDate= formatter.format(date);  
    System.out.println(strDate);  


    }
}