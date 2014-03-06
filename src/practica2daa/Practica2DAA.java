/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2daa;

/**
 *
 * @author Asus
 */
public class Practica2DAA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vector ={234,9394,63466,43};
        int inicio=0;
        int finel=3;
        
        boolean [] resultado =digitosComunesDYV(vector, inicio, finel-1 );
        //boolean [] resultado =digitosComunesITE(vector);
        System.out.println("Los digitos comunes son: ");
        for (int h=0;h<10;h++){
            if (resultado[h]){
                System.out.println(h);
            }
        }
    }
    
        public static boolean[] digitosComunesDYV( int[] v, int ini, int fin ){
        
        //Caso base
        
        if (ini==fin){
            
            boolean[] resultado = new boolean [10];
            String num =Integer.toString(v[ini]);
            for (int j=0;j<num.length()-1;j++){
                System.out.println(num);
                resultado[Integer.parseInt(num.charAt(j))]=true;
                j++;
            }
            return resultado;
            
        }else{
            
           int medio =(ini+fin)/2;
            
           boolean[] r1=digitosComunesDYV(v, ini, medio);
           boolean[] r2=digitosComunesDYV (v, medio+1,fin);
           
           for (int k=0;k<10;k++){
               if(!(r1[k]) || !(r2[k])){
                   r1[k]=false;
               }
           }
           return r1;
        }
        
    }
    
    public static boolean[] digitosComunesITE( int[] v ){
        
        boolean[] resultado = new boolean [10];
        String num =Integer.toString(v[0]);
        int i=1;
        while (i<num.length()){
            resultado[num.charAt(i)]=true;
            i++;
        }
        for (int j=1;j<v.length;j++){
            num = Integer.toString(v[j]);
            boolean[] resultadoAux =new boolean [10];
            for (int k=0;k<num.length();k++){
                resultadoAux[num.charAt(k)]=true;
            }
            for (int l=0;l<10;l++){
               if(!(resultado[l]) || !(resultadoAux[l])){
                   resultado[l]=false;
               }
            }
        }
        return resultado;
    }
}
