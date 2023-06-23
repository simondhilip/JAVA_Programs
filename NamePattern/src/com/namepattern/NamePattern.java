package com.namepattern;

public class NamePattern {
    public static void main(String[] args) {
    	printStringPattern();
    }

    private static void printStringPattern() {
    	int n=12;
    	int l=n-1;
    	int h=(n-1)/2;
    	int q=(n-1)/4;
    	int t=(3*n)/4;
    	
    	for(int r=0;r<n;r++){
    		
    		//Print Letter D
    		for(int c=0;c<n;c++){
    			if( c==0 || 
    					c==l && (r>q&&r<t)||
    							c==l-2 && (r==q-1||r==t+1)||
    									c==l-1 && (r==q||r==t)||
    							(r==0 && c<t)||
    							((r==l &&c<t))
    			   ){
    				System.out.print("D");
    				
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		System.out.print("    ");
    		
    		//Print Letter H
    		for (int c=0;c<n;c++){
    			if(c==0||c==l || r==h){
    				System.out.print("H");
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		
    		System.out.print("    ");
    		
    		//Print Letter I
    		for (int c=0;c<n;c++){
    			if(r==0||r==l || c==h){
    				System.out.print("I");
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		
    		System.out.print("    ");
    		
    		//Print Letter L
    		for (int c=0;c<n;c++){
    			if(c==0||r==l ){
    				System.out.print("L");
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		System.out.print("    ");
    		//Print Letter I
    		for (int c=0;c<n;c++){
    			if(r==0||r==l || c==h){
    				System.out.print("I");
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		
    		System.out.print("    ");
    		//Print Letter P
    		for (int c=0;c<n;c++){
    			if(c==0 ||
    					(r==0&&c<t) ||
    					(r==h&&c<t) ||
    					(c==n-1 &&(r==q||r==q+1))||
    					(c==n-2 &&(r==q-1||r==q+2))||
    					(c==n-3 &&(r==q-2||r==q+3))


    					){
    				System.out.print("P");
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		
    		System.out.print("    ");
    		System.out.print("    ");
    		System.out.print("    ");
    		
    		//Print Letter K
    		for (int c=0;c<n;c++){
    			if(c==0 || 
    					(r==h&&c<h)||
    					(r==h+1 &&c==h+1)||
    					(r==h+2 &&c==h+2) ||
    					(r==h+3 &&c==h+3) ||
    					(r==h+4 &&c==h+4) ||
    					(r==h+5 &&c==h+5) ||
    					(r==h-1 &&c==h+1) ||
    					(r==h-2 &&c==h+2) ||
    					(r==h-3 &&c==h+3) ||
    					(r==h-4 &&c==h+4) ||
    					(r==h-5 &&c==h+5) 

    					){
    				System.out.print("K");
    				
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		
    		System.out.print("    ");
    		
    		//Print Letter U
    		for (int c=0;c<n;c++){
    			if((r<t && c==0) ||
    					(r<t && c==l)||
    					(r==l&&c>q && c<t)||
    					(r==t+1&&c==q||r==t+1&&c==t) ||
    					(r==t&&c==q-1||r==t&&c==t+1) 


    					){
    				System.out.print("U");
    				
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		
    		System.out.print("    ");
    		
    		//Print Letter M
    		for (int c=0;c<n;c++){
    			if(c==0 || 
    					c==l ||
    					((c==r || c== n-r+1) && r<=n/2)

    					){
    				System.out.print("M");
    				
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		
    		System.out.print("    ");
    		
    		//Print Letter a
    		for (int c=0;c<n;c++){
    			if(c==0||c==l || r==h || r==0){
    				System.out.print("A");
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		
    		System.out.print("    ");
    		//Print Letter P
    		for (int c=0;c<n;c++){
    			if(c==0 ||
    					(r==0&&c<t) ||
    					(r==h&&c<t) ||
    					(c==n-1 &&(r==q||r==q+1))||
    					(c==n-2 &&(r==q-1||r==q+2))||
    					(c==n-3 &&(r==q-2||r==q+3))||
    					(r==h+1 &&(c==q)||r==h+2 &&(c==q+1)||r==h+3 &&(c==q+2)||r==h+4 &&(c==q+3)||r==h+5 &&(c==q+4)||r==h+6 &&(c==q+5))||
    					(r==l&&(c>t||c>t-1))



    					){
    				System.out.print("R");
    			}else{
    				System.out.print(" ");
    			}
    			
    		}
    		
    		System.out.print("    ");
    		
    		System.out.println("");
    		
    		
    	}
    }
}
