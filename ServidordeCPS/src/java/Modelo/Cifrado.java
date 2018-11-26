/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Cifrado 
{
    int per1[]={57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,24,21,13,5,28,20,12,4};
    
    int per2[]={14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
    
    int rota[]={1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
    
    int ini[]={58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7};
    
    int expan[]={32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,31,32,1};
    
    int p[]={16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,2,8,24,14,32,27,3,9,19,13,30,6,22,11,4,25};
    
    int fin[]={40,8,48,16,56,24,64,32,39,7,47,15,55,23,63,31,38,6,46,14,54,22,62,30,37,5,45,13,53,21,61,29,36,4,44,12,52,20,60,28,35,3,43,11,51,19,59,27,34,2,42,10,50,18,58,26,33,1,41,9,49,17,57,25};
    
    int keys[][]=new int[16][48];
    
    int bloques[][][]={
                        {
                            {14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
                            {0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
                            {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
                            {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}
                        },
                        {
                            {15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
                            {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
                            {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
                            {13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}
                        },
                        {
                            {10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
                            {13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
                            {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
                            {1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}
                        },
                        {
                            {7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
                            {13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
                            {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
                            {3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}
                        },
                        {
                            {2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
                            {14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
                            {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
                            {11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}
                        },
                        {
                            {12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
                            {10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
                            {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},
                            {4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}
                        },
                        {
                            {4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
                            {13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
                            {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
                            {6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}
                        },
                        {
                            {13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},
                            {1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},
                            {7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},
                            {2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}
                        }
                    };
    
    public void Llaves()
    {
        int cont;
        String clave="1011001110001111000011111000001111000001111100001111000111001101";
        int cla[]=new int[56];
        int C[][]=new int[17][28];
        int D[][]=new int[17][28];
        int k[][]=new int[16][56];
        
        for(int i=0;i<56;i++)
        {
            cont = per1[i];
            cla[i]=(clave.charAt(cont-1));
        }
        
        for(int i=0;i<28;i++)
        {
            C[0][i]=cla[i];
            D[0][i]=cla[i+28];
        }

        for(int j=0;j<16;j++)
        {
            cont=rota[j];
            if(cont==1)
            {   
                int b1c=C[j][0];
                int b1d=D[j][0];
                for(int i=0;i<27;i++)
                {
                    C[j+1][i]=C[j][i+1]; 
                    D[j+1][i]=D[j][i+1];
                }
                C[j+1][27]=b1c;
                D[j+1][27]=b1d;
            }
            else
            {
                int b1c=C[j][0];
                int b2c=C[j][1];
                int b1d=D[j][0];
                int b2d=D[j][1];
                for(int i=0;i<26;i++)
                {
                    C[j+1][i]=C[j][i+2];
                    D[j+1][i]=D[j][i+2];
                }
                C[j+1][26]=b1c;
                C[j+1][27]=b2c;
                D[j+1][26]=b1d;
                D[j+1][27]=b2d;
            }
        }
        
        for(int j=0;j<16;j++)
        { 
            for(int i=0;i<56;i++)
            {
                if(i<=27)
                {
                    k[j][i]=C[j+1][i];
                }
                else
                {
                    k[j][i]=D[j+1][i-28];
                }
            }
        }
     
        for(int j=0;j<16;j++)
        {
            for(int i=0;i<48;i++)
            {
                cont = per2[i];
                keys[j][i]=k[j][cont-1];
            }
        }
    }
    
    public String cifra(String x)
    {
        String r;
        Cifrado pru= new Cifrado();
        String[] ci=pru.StringtoBin(x);
        pru.Llaves();
        String[] codi=new String[ci.length];
        for(int i=0;i<ci.length;i++)
        {
            codi[i]=pru.Cifrado(ci[i]);
            codi[i]=pru.Cifrado(codi[i]);
            codi[i]=pru.Cifrado(codi[i]);
        }
        r=pru.BintoString(codi);
        
        return r;
    }
    
    public String Cifrado(String dato)
    {
        int cont;
        char texto[]=new char[64];
        char L[][]=new char[18][32];
        char R[][]=new char[18][32];
        char LR[]=new char[64];
        char cifrado[]=new char[64];
        
        for(int i=0;i<64;i++)
        {
            cont = ini[i];
            texto[i]=(dato.charAt(cont-1));
        }
        
        for(int j=0;j<32;j++)
        {
            L[0][j]=texto[j];
            R[0][j]=texto[j+32];
        }
        
        for(int i=1;i<17;i++)
        {
            char Rexpa[]=new char[48];
            char KR[]=new char[48];
            char KL[]=new char[32];
            char B[][]=new char[8][4];
            char TB[]=new char[32];
            char S[][]=new char[8][6];
            char m[][]=new char[8][2];
            char n[][]=new char[8][4];
            int SB[]=new int[8];
            char PB[]=new char[32];
            
           
            for(int j=0;j<48;j++)
            {
                cont=expan[j];
                Rexpa[j]=R[i-1][cont-1];
                
                if(Rexpa[j]!=keys[i-1][j])
                {
                    KR[j]='1';
                }
                else 
                {
                    KR[j]='0';
                }
            }
            
            
            for(int j=0;j<8;j++)
            {
                int dm=0;
                int dn=0;
                
                for(int k=0;k<6;k++)
                {
                    S[j][k]=KR[(6*j)+k];
                  
                    if(k==0)
                    {
                        m[j][0]=S[j][k];
                    }
                    else
                    {
                        if(k==5)
                        {
                            m[j][1]=S[j][k];
                        }
                        else
                        {
                            n[j][k-1]=S[j][k];
                        }
                    }
                }
                
                
                for(int k=0;k<2;k++)
                {
                    if(Character.getNumericValue(m[j][k])==1)
                    {
                        dm+=(int)Math.pow(2,(2-1-k));
                    }
                }
                for(int k=0;k<4;k++)
                {
                    if(Character.getNumericValue(n[j][k])==1)
                    {
                        dn+=(int)Math.pow(2,(4-1-k));
                    }
                }
                 
                SB[j]=bloques[j][dm][dn];
                String BD=Integer.toBinaryString(SB[j]);
                int lon=4-BD.length();
                
                for (int k=0;k<lon;k++) 
                {
                    BD="0"+BD;
                }
                for(int k=0;k<4;k++)
                {
                    B[j][k]=BD.charAt(k);
                }
            }
            
            
            for(int j=0;j<8;j++)
            {
                for(int k=0;k<4;k++)
                {
                    TB[(4*j)+k]=B[j][k];
                }
            }
		
            
            for(int j=0;j<32;j++)
            {
                cont=p[j];
                PB[j]=TB[cont-1];
                if(PB[j]!=L[i-1][j])
                {
                    KL[j]='1';
                }  
                else
                {
                    KL[j]='0';
                }
                R[i][j]=KL[j];
                L[i][j]=R[i-1][j];
            }
        }
        R[17]=L[16];
        L[17]=R[16];
        
        for(int j=0;j<32;j++)
        {
            LR[j]=L[17][j];
            LR[j+32]=R[17][j];
        }
    
        for(int i=0;i<64;i++)
        {
            cont=fin[i];
            cifrado[i]=LR[cont-1];
        }
        String codigo="";
        for(int i=0;i<64;i++)
        {
            codigo+=cifrado[i];
        }
        return codigo;
    }
    
    public String deci(String x)
    {
        String[] decifra;
        String r;
        Cifrado pru=new Cifrado();
        decifra=pru.StringtoBin(x);
        pru.Llaves();
        String[] text=new String[decifra.length];
        for(int i=0;i<decifra.length;i++)
        {
            text[i]=pru.Decifrado(decifra[i]);
            text[i]=pru.Decifrado(text[i]);
            text[i]=pru.Decifrado(text[i]);
        }
        r=pru.BintoString(text);
                
        return r;
    }
    
    public String Decifrado(String dato)
    {
        int cont;
        char texto[]=new char[64];
        char L[][]=new char[18][32];
        char R[][]=new char[18][32];
        char LR[]=new char[64];
        char cifrado[]=new char[64];
        
        for(int i=0;i<64;i++)
        {
            cont = ini[i];
            texto[i]=(dato.charAt(cont-1));
        }
        
        for(int j=0;j<32;j++)
        {
            L[0][j]=texto[j];
            R[0][j]=texto[j+32];
        }
        
        for(int i=1;i<17;i++)
        {
            char Rexpa[]=new char[48];
            char KR[]=new char[48];
            char KL[]=new char[32];
            char B[][]=new char[8][4];
            char TB[]=new char[32];
            char S[][]=new char[8][6];
            char m[][]=new char[8][2];
            char n[][]=new char[8][4];
            int SB[]=new int[8];
            char PB[]=new char[32];
            
           
            for(int j=0;j<48;j++)
            {
                cont=expan[j];
                Rexpa[j]=R[i-1][cont-1];
                
                if(Rexpa[j]!=keys[16-i][j])
                {
                    KR[j]='1';
                }
                else 
                {
                    KR[j]='0';
                }
            }
            
            
            for(int j=0;j<8;j++)
            {
                int dm=0;
                int dn=0;
                
                for(int k=0;k<6;k++)
                {
                    S[j][k]=KR[(6*j)+k];
                  
                    if(k==0)
                    {
                        m[j][0]=S[j][k];
                    }
                    else
                    {
                        if(k==5)
                        {
                            m[j][1]=S[j][k];
                        }
                        else
                        {
                            n[j][k-1]=S[j][k];
                        }
                    }
                }
                
                
                for(int k=0;k<2;k++)
                {
                    if(Character.getNumericValue(m[j][k])==1)
                    {
                        dm+=(int)Math.pow(2,(2-1-k));
                    }
                }
                for(int k=0;k<4;k++)
                {
                    if(Character.getNumericValue(n[j][k])==1)
                    {
                        dn+=(int)Math.pow(2,(4-1-k));
                    }
                }
                 
                SB[j]=bloques[j][dm][dn];
                String BD=Integer.toBinaryString(SB[j]);
                int lon=4-BD.length();
                
                for (int k=0;k<lon;k++) 
                {
                    BD="0"+BD;
                }
                for(int k=0;k<4;k++)
                {
                    B[j][k]=BD.charAt(k);
                }
            }
            
            
            for(int j=0;j<8;j++)
            {
                for(int k=0;k<4;k++)
                {
                    TB[(4*j)+k]=B[j][k];
                }
            }
		
            
            for(int j=0;j<32;j++)
            {
                cont=p[j];
                PB[j]=TB[cont-1];
                if(PB[j]!=L[i-1][j])
                {
                    KL[j]='1';
                }  
                else
                {
                    KL[j]='0';
                }
                R[i][j]=KL[j];
                L[i][j]=R[i-1][j];
            }
        }
        R[17]=L[16];
        L[17]=R[16];
        
        for(int j=0;j<32;j++)
        {
            LR[j]=L[17][j];
            LR[j+32]=R[17][j];
        }
    
        for(int i=0;i<64;i++)
        {
            cont=fin[i];
            cifrado[i]=LR[cont-1];
        }
        String codigo="";
        for(int i=0;i<64;i++)
        {
            codigo+=cifrado[i];
        }
        return codigo;
    }
    
    public String BintoString(String[] data)
    {
        
        int[][] d = new int[data.length][8];
        char[][] c = new char[data.length][8];
        String r="";
        for(int i=0;i<data.length;i++)
        {
            for(int j=0;j<8;j++)
            {
                for(int k=0;k<8;k++)
                {
                    char xxx=data[i].charAt((8*j)+k);
                    int g=Character.getNumericValue(xxx);
                    if(g==1)
                    {
                        d[i][j]+=(int)Math.pow(2,(8-1-k));
                    }
                }
                
                c[i][j]=(char)(d[i][j]);
                r+=c[i][j];
                
            }   
            
        }
        
        return r;
    }
    
    public String[] StringtoBin(String data)
    {
        
        int lon=data.length();
        if((lon%8)!=0)
        {
            while((lon%8)!=0)
            {
                data=data+" ";
                lon=data.length();
            }
        }
        int lon2=(lon/8);
        String[] palabras=new String[lon2];
        for(int j=0;j<lon2;j++)
        {
            String r="";
            for(int i=0;i<8;i++)
            {
                int as = data.charAt((8*j)+i);
                String s;    
                s=Integer.toBinaryString(as);
                int ban=8-s.length();
                for(int k=0;k<ban;k++)
                {
                    s="0"+s;
                }
                r+=s;
            }  
            
            palabras[j]=r;
            
        }    
        return palabras;  
    }
  
}
