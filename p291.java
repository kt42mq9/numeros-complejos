import java.text.DecimalFormat;
import java.util.Scanner;
class p291{
    public static void main(String[] args) {
        new programa();
    }
}
class programa{
    Scanner teclado;
    programa(){
        DecimalFormat ft1 = new DecimalFormat("#.#");
        float real, img;
        real=img=0;
        teclado=new Scanner(System.in);
        String variable="";
        boolean bandera=true;
        while(bandera){
            try {variable=teclado.nextLine();} 
            catch(Exception e){ bandera=false;}
            if (bandera) {
                String[] datos = variable.split(" ");
                complejo c1 = new complejo(datos[0],datos[1]);
                complejo c2 = new complejo(datos[2],datos[3]);
                switch(datos[datos.length-1]){
                    case "+":
                        real=c1.getReal()+c2.getReal();
                        img=c1.getImag()+c2.getImag();
                        System.out.println(obtResultado(Float.parseFloat(ft1.format(real)),Float.parseFloat(ft1.format(img))));
                    break;
                    case "-":
                        real=c1.getReal()-c2.getReal();
                        img=c1.getImag()-c2.getImag();
                        System.out.println(obtResultado(Float.parseFloat(ft1.format(real)),Float.parseFloat(ft1.format(img))));
                    break;
                    case "/":
                        float numero;
                        float[] complejo = new float[3];
                        numero=c2.getImag()*-1;
                        complejo[0]=c1.getReal()*c2.getReal()+c1.getImag()*numero*-1;
                        complejo[1]=c1.getReal()*numero+c1.getImag()*c2.getReal();
                        complejo[2]=c2.getReal()*c2.getReal()+c2.getImag()*numero*-1;
                        real=complejo[0]/complejo[2];
                        img=complejo[1]/complejo[2];
                        System.out.println(obtResultado(Float.parseFloat(ft1.format(real)),Float.parseFloat(ft1.format(img))));
                    break;
                    case "*":
                        real=c1.getReal()*c2.getReal()-c1.getImag()*c2.getImag();
                        img=c1.getReal()*c2.getImag()+c1.getImag()*c2.getReal();
                        System.out.println(obtResultado(Float.parseFloat(ft1.format(real)),Float.parseFloat(ft1.format(img))));
                }
                
            }
        }
    }

    public String obtResultado(float real, float img){
        String signo="";
        if(img>0)
            signo="+";
        else
            signo="-";
        if(img<0)
            img=img*-1;
        String resul=veriEntero(String.valueOf(real))+" "+signo+" "+veriEntero(String.valueOf(img))+"i";
        return resul;
    }

    public String veriEntero(String v){
        if(Integer.parseInt(String.valueOf(v.charAt(v.length()-1)))==0){
            int cont=0;
            String value="";
            while(cont<v.length()){
                if(!String.valueOf(v.charAt(cont)).equalsIgnoreCase(".")){
                    value+=String.valueOf(v.charAt(cont));
                    cont++;
                }
                else
                    cont=v.length();
            }
            return value;
        }
        return v;
    }
}

class complejo{
    private float imaginario;
    private float real;
    complejo(String real, String complej){
        this.real=Float.parseFloat(real);
        if(complej.length()==2){
            if(String.valueOf(complej.charAt(1)).equalsIgnoreCase("i"))
                this.imaginario=1;
        }
        else{
            complej=complej.replace("i","");
            this.imaginario=Float.parseFloat(complej);
        }
    }

    public float getReal(){
        return this.real;
    }

    public float getImag(){
        return this.imaginario;
    }
}