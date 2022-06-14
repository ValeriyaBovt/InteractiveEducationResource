package sample.add;

public class Matrix {

    public double[][] matrix;

    public String KramerMethod(Matrix copy)
    {
        double [][] matrixCopy=copy.matrix;
        for(int i =0;i<3;i++)
        {
            for(int j =0;j<4;j++)
                matrixCopy[i][j]=matrix[i][j];
        }
        double det = Determinant3size();
        String row1 = "Шукаємо головний визначник:  "+ solveDeterminant3size()+".\n";
        if(Determinant2Size()==0)
            return row1+"Оскільки визначник дорівнює 0 система не може бути розв'язана таким методом (система не має розв'язків" +
                    " або має безліч розв'язків.";
        matrix[0][0]=matrix[0][3];
        matrix[1][0]=matrix[1][3];
        matrix[2][0]=matrix[2][3];
        double det1 = Determinant3size();
        matrix[0][0]=matrixCopy[0][0];
        matrix[1][0]=matrixCopy[1][0];
        matrix[2][0]=matrixCopy[2][0];
        String row2 = "      |"+matrix[0][3]+" "+matrix[0][1]+" "+ matrix[0][2]+"|\n"+
                      "Δ₁= |"+matrix[1][3]+" "+matrix[1][1]+" "+ matrix[1][2]+"| = "+det1+"\n"+
                      "      |"+matrix[2][3]+" "+matrix[2][1]+" "+ matrix[2][2]+"|\n";
        matrix[0][1]=matrix[0][3];
        matrix[1][1]=matrix[1][3];
        matrix[2][1]=matrix[2][3];
        double det2 = Determinant3size();
        matrix[0][1]=matrixCopy[0][1];
        matrix[1][1]=matrixCopy[1][1];
        matrix[2][1]=matrixCopy[2][1];
        String row3 = "      |"+matrix[0][0]+" "+matrix[0][3]+" "+ matrix[0][2]+"|\n"+
                "Δ₂= |"+matrix[1][0]+" "+matrix[1][3]+" "+ matrix[1][2]+"| = "+det2+"\n"+
                "      |"+matrix[2][0]+" "+matrix[2][3]+" "+ matrix[2][2]+"|\n";
        matrix[0][2]=matrix[0][3];
        matrix[1][2]=matrix[1][3];
        matrix[2][2]=matrix[2][3];
        double det3 = Determinant3size();
        matrix[0][2]=matrixCopy[0][2];
        matrix[1][2]=matrixCopy[1][2];
        matrix[2][2]=matrixCopy[2][2];
        String row4 = "      |"+matrix[0][0]+" "+matrix[0][1]+" "+ matrix[0][3]+"|\n"+
                "Δ₃= |"+matrix[1][0]+" "+matrix[1][1]+" "+ matrix[1][3]+"| = "+det3+"\n"+
                "      |"+matrix[2][0]+" "+matrix[2][1]+" "+ matrix[2][3]+"|\n";
        String row5 = "x₁=Δ₁/Δ="+det1+"/"+det+"="+String.format("%.3f",det1/det)+";     "+
                "x₂=Δ₂/Δ="+det2+"/"+det+"="+String.format("%.3f",det2/det)+";     "+
                "x₃=Δ₃/Δ="+det3+"/"+det+"="+String.format("%.3f",det3/det)+";     ";


        return row1+row2+row3+row4+row5;

    }


    public String matrixMethod()
    {
        String row1 = " Записуємо систему у матричному вигляді: AX=H, де\n"+
                "     |"+matrix[0][0]+" "+matrix[0][1]+" "+ matrix[0][2]+"|         |"+matrix[0][3]+"|        |x₁|\n"+
                "А=|"+matrix[1][0]+" "+matrix[1][1]+" "+ matrix[1][3]+"|,   H=|"+matrix[1][3]+"|,   X=|x₂|\n"+
                "     |"+matrix[2][0]+" "+matrix[2][1]+" "+ matrix[2][3]+"|         |"+matrix[2][3]+"|        |x₃|\n";
        String row2 = "1. Знаходимо "+solveDeterminant3size();
        double det = Determinant3size();
        if(det==0)
            return  row1+row2+".\nОскільки визначник дорівнює 0 система не може бути розв'язана таким методом (система не має розв'язків" +
                    " або має безліч розв'язків.";
        else row2+="≠0.\n";
        double[][] inverse = buildInverseMatrix3();
        String row3 = "2. Знаходимо А⁻¹, оскільки Х=А⁻¹Н. Маємо: (детальний розв'язок Матриці.Обернена матриця)\n"+
                printInverseMatrixSolve(inverse,3);
        String row4 = "Знаходимо А⁻¹H=X. Маємо:\n"+
                "                  ("+String.format("%.2f",inverse[0][0])+" "+String.format("%.2f",inverse[0][1])+" "+String.format("%.2f",inverse[0][2])+")("+matrix[0][3]+")           "+
                "("+String.format("%.2f",inverse[0][0]*matrix[0][3])+"+"+String.format("%.2f",inverse[0][1]*matrix[1][3])+"+"+String.format("%.2f",inverse[0][2]*matrix[2][3])+")"+
                "           ("+String.format("%.2f",inverse[0][0]*matrix[0][3]+inverse[0][1]*matrix[1][3]+inverse[0][2]*matrix[2][3])+")\n"+

                "A⁻¹ = ⅟"+det+"("+String.format("%.2f",inverse[1][0])+" "+String.format("%.2f",inverse[1][1])+" "+String.format("%.2f",inverse[1][2])+")("+matrix[1][3]+")=⅟"+Determinant3size()+
                "("+String.format("%.2f",inverse[1][0]*matrix[0][3])+"+"+String.format("%.2f",inverse[1][1]*matrix[1][3])+"+"+String.format("%.2f",inverse[1][2]*matrix[2][3])+")"+
               " = ⅟"+det+"("+String.format("%.2f",inverse[1][0]*matrix[0][3]+inverse[1][1]*matrix[1][3]+inverse[1][2]*matrix[2][3])+")\n"+

                "                  ("+String.format("%.2f",inverse[2][0])+" "+String.format("%.2f",inverse[2][1])+" "+String.format("%.2f",inverse[2][2])+")("+matrix[2][3]+")        "+
                "("+String.format("%.2f",inverse[2][0]*matrix[0][3])+"+"+String.format("%.2f",inverse[2][1]*matrix[1][3])+"+"+String.format("%.2f",inverse[2][2]*matrix[2][3])+")"+
                "           ("+String.format("%.2f",inverse[2][0]*matrix[0][3]+inverse[0][1]*matrix[2][3]+inverse[2][2]*matrix[2][3])+")\n";
        String row5 = "Отже, x₁=1/"+det+"∙"+String.format("%.2f",inverse[0][0]*matrix[0][3]+inverse[0][1]*matrix[1][3]+inverse[0][2]*matrix[2][3])+"="+String.format("%.2f",(inverse[0][0]*matrix[0][3]+inverse[0][1]*matrix[1][3]+inverse[0][2]*matrix[2][3])/det)+
                "; x₂=1/"+det+"∙"+String.format("%.2f",inverse[1][0]*matrix[0][3]+inverse[1][1]*matrix[1][3]+inverse[1][2]*matrix[2][3])+"="+String.format("%.2f",(inverse[1][0]*matrix[0][3]+inverse[1][1]*matrix[1][3]+inverse[1][2]*matrix[2][3])/det)+
                "; x₃=1/"+det+"∙"+String.format("%.2f",inverse[2][0]*matrix[0][3]+inverse[2][1]*matrix[1][3]+inverse[2][2]*matrix[2][3])+"="+String.format("%.2f",(inverse[2][0]*matrix[0][3]+inverse[2][1]*matrix[1][3]+inverse[2][2]*matrix[2][3])/det);



        return  row1+row2+row3+row4+row5;
    }






    public String solveInverseMatrix3()
    {
        double[][] inverseMatrix=buildInverseMatrix3();
        String A11_1="A₁₁=|"+matrix[1][1]+" "+matrix[1][2]+"|="+String.format("%.2f",inverseMatrix[0][0])+"";
        String A11_2="        |"+matrix[2][1]+" "+matrix[2][2]+"|";

        String A12_1="А₁₂=-|"+matrix[1][0]+" "+matrix[1][2]+"|="+String.format("%.2f",inverseMatrix[0][1])+"";
        String A12_2="         |"+matrix[2][0]+" "+matrix[2][2]+"|";

        String A13_1="А₁₃=|"+matrix[1][0]+" "+matrix[1][1]+"|="+String.format("%.2f",inverseMatrix[0][2])+"";
        String A13_2="         |"+matrix[2][0]+" "+matrix[2][1]+"|";

        String A21_1="А₂₁=-|"+matrix[0][1]+" "+matrix[0][2]+"|="+String.format("%.2f",inverseMatrix[1][0])+"";
        String A21_2="         |"+matrix[2][1]+" "+matrix[2][2]+"|";

        String A22_1="А₂₂=|"+matrix[0][0]+" "+matrix[0][2]+"|="+String.format("%.2f",inverseMatrix[1][1])+"";
        String A22_2="         |"+matrix[2][0]+" "+matrix[2][2]+"|";

        String A23_1="А₂₃=-|"+matrix[0][0]+" "+matrix[0][1]+"|="+String.format("%.2f",inverseMatrix[1][2])+"";
        String A23_2="         |"+matrix[2][0]+" "+matrix[2][1]+"|";

        String A31_1="А₃₁=|"+matrix[0][1]+" "+matrix[0][2]+"|="+String.format("%.2f",inverseMatrix[2][0])+"";
        String A31_2="        |"+matrix[1][1]+" "+matrix[1][2]+"|";

        String A32_1="А₃₂=-|"+matrix[0][0]+" "+matrix[0][2]+"|="+String.format("%.2f",inverseMatrix[2][1])+"";
        String A32_2="         |"+matrix[1][0]+" "+matrix[1][2]+"|";

        String A33_1="А₃₃=|"+matrix[0][0]+" "+matrix[0][1]+"|="+String.format("%.2f",inverseMatrix[2][2])+"";
        String A33_2="        |"+matrix[1][0]+" "+matrix[1][1]+"|";


        String line1=A11_1+"   "+A12_1+"   "+A13_1+"\n";
        String line2=A11_2+"           "+A12_2+"          "+A13_2+"\n";

        String line3=A21_1+"   "+A22_1+"   "+A23_1+"\n";
        String line4=A21_2+"          "+A22_2+"           "+A23_2+"\n";

        String line5=A31_1+"   "+A32_1+"   "+A33_1+"\n";
        String line6=A31_2+"           "+A32_2+"           "+A33_2+"\n";



        return line1+line2+line3+line4+line5+line6;

    }

    public String printInverseMatrixSolve(double[][]a,int n)
    {
        String result="";
        for(int i=0;i<n;i++)
        {
            if(i==1)
                result+="A⁻¹ = ⅟"+Determinant3size()+"|";
            else
                result+="                   |";
            for(int j=0;j<n;j++)
            {
                result+=String.format("%.2f",a[i][j])+" ";
            }
            result+="|\n";
        }
        return result;
    }

    public double[][] buildInverseMatrix3()
    {
        double[][] inverseMatrix= new double[3][3];

        inverseMatrix[0][0]=matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1];//
        inverseMatrix[1][0]=(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0])*(-1);//
        inverseMatrix[2][0]=(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0]);//
        inverseMatrix[0][1]=(matrix[0][1]*matrix[2][2]-matrix[0][2]*matrix[2][1])*(-1);//
        inverseMatrix[1][1]=(matrix[0][0]*matrix[2][2]-matrix[0][2]*matrix[2][0]);//
        inverseMatrix[2][1]=(matrix[0][0]*matrix[2][1]-matrix[0][1]*matrix[2][0])*(-1);
        inverseMatrix[0][2]=(matrix[0][1]*matrix[1][2]-matrix[0][2]*matrix[1][1]);//
        inverseMatrix[1][2]=(matrix[0][0]*matrix[1][2]-matrix[0][2]*matrix[1][0])*(-1);//
        inverseMatrix[2][2]=(matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0]);//
        return  inverseMatrix;
    }

    public String addMatrix(int n, int m, double[][] B)
    {
        String solution1="";
        String solution2="";
        //double[][] result=addMatrixResult(n,m,B);
        for(int i=0;i<m;i++)
        {
            solution1+="| ";
            solution2+="| ";
            for(int j=0;j<n;j++)
            {
                solution1+=matrix[i][j]+" + "+B[i][j]+"  ";
                solution2+=(matrix[i][j]+B[i][j]);
            }
            solution1+=" |\n";
            solution2+=" |\n";
        }

        return solution1+ solution2;
    }

    public String multiplicationByNumber(int n, int m, double lambda)
    {
        String solution="\n";
        for(int i=0;i<m;i++)
        {
            solution+="| ";
            for(int j=0;j<n;j++)
            {
                solution += String.format("%.2f",matrix[i][j]*lambda)+" ";
            }
            solution+=" |\n";
        }

        return solution;
    }
    public String solveDeterminant2size() {
        double det = Determinant2Size();
       String solution = matrix[0][0]+"∙"+matrix[1][1]+" - "+matrix[0][1]+"∙"+matrix[1][0]+" = "
                +matrix[0][0]*matrix[1][1]+" - "+matrix[0][1]*matrix[1][0]+" = "+det;
        return "Δ="+solution;
    }
    public double Determinant2Size()
    {
        double det = matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
        return det;
    }
    public String solveDeterminant3size()
    {

        String solution1step = matrix[0][0]+"∙"+matrix[1][1]+"∙"+matrix[2][2]+" + "+matrix[0][2]+"∙"+matrix[1][0]+"∙"+matrix[2][1]+
                " + "+matrix[0][1]+"∙"+matrix[1][2]+"∙"+matrix[2][0]+" - "+matrix[0][2]+"∙"+matrix[1][1]+"∙"+matrix[2][0]+" - "+
                matrix[0][0]+"∙"+matrix[1][2]+"∙"+matrix[2][1]+" - "+matrix[0][1]+"∙"+matrix[1][0]+"∙"+matrix[2][2]+ " = ";
        String solution2step = matrix[0][0]*matrix[1][1]*matrix[2][2]+" + "+matrix[0][2]*matrix[1][0]*matrix[2][1]+
                " + "+matrix[0][1]*matrix[1][2]*matrix[2][0]+" - "+matrix[0][2]*matrix[1][1]*matrix[2][0]+" - "+
                matrix[0][0]*matrix[1][2]*matrix[2][1]+" - "+matrix[0][1]*matrix[1][0]*matrix[2][2]+ " = ";
        String result = ""+Determinant3size();
        return  "Δ = "+solution1step+solution2step+result;
    }
    public double Determinant3size()
    {
        double det = matrix[0][0]*matrix[1][1]*matrix[2][2]+ matrix[0][2]*matrix[1][0]*matrix[2][1]+
                matrix[0][1]*matrix[1][2]*matrix[2][0] - matrix[0][2]*matrix[1][1]*matrix[2][0]-
                matrix[0][0]*matrix[1][2]*matrix[2][1] - matrix[0][1]*matrix[1][0]*matrix[2][2];
        return det;
    }
    public String solveDeterminant4size()
    {
        String result;
        String step1="       |"+matrix[1][1]+" "+matrix[1][2]+" "+matrix[1][3]+"|           |"+matrix[1][0]+" "+matrix[1][2]+" "+matrix[1][3]+"|            |"+ matrix[1][0]+" "+matrix[1][1]+" "+matrix[1][3]+"|          |"+ matrix[1][0]+" "+matrix[1][1]+" "+matrix[1][2]+"|\n"+
                matrix[0][0]+"×|"+matrix[2][1]+" "+matrix[2][2]+" "+matrix[2][3]+"| - "+matrix[0][1]+"×|"+matrix[2][0]+" "+matrix[2][2]+" "+matrix[2][3]+"| + "+matrix[0][2]+"×|"+matrix[2][0]+" "+matrix[2][1]+" "+matrix[2][3]+"| - "+matrix[0][3]+"×|"+matrix[2][0]+" "+matrix[2][1]+" "+matrix[2][2]+"|\n"+
                "       |"+matrix[3][1]+" "+matrix[3][2]+" "+matrix[3][3]+"|           |"+matrix[3][0]+" "+matrix[3][2]+" "+matrix[3][3]+"|            |"+matrix[3][0]+" "+matrix[3][1]+" "+matrix[3][3]+"|          |"+matrix[3][0]+" "+matrix[3][1]+" "+matrix[3][2]+"|\n";
        double det1= matrix[3][3]*matrix[1][1]*matrix[2][2]+ matrix[1][3]*matrix[2][1]*matrix[3][2]+
                matrix[1][2]*matrix[2][3]*matrix[3][1] - matrix[1][3]*matrix[2][2]*matrix[3][1]-
                matrix[1][1]*matrix[2][3]*matrix[3][2] - matrix[1][2]*matrix[2][1]*matrix[3][3];
        double det2= matrix[1][0]*matrix[3][3]*matrix[2][2]+ matrix[1][3]*matrix[2][0]*matrix[3][2]+
                matrix[1][2]*matrix[2][3]*matrix[3][0] - matrix[1][3]*matrix[2][2]*matrix[3][0]-
                matrix[1][0]*matrix[2][3]*matrix[3][2] - matrix[1][2]*matrix[2][0]*matrix[3][3];
        double det3 = matrix[1][0]*matrix[2][1]*matrix[3][3]+ matrix[1][3]*matrix[2][0]*matrix[3][1]+
                matrix[1][1]*matrix[2][3]*matrix[3][0] - matrix[1][3]*matrix[2][1]*matrix[3][0]-
                matrix[1][0]*matrix[2][3]*matrix[3][1] - matrix[1][1]*matrix[2][0]*matrix[3][3];
        double det4 = matrix[1][0]*matrix[2][1]*matrix[3][2]+ matrix[1][2]*matrix[2][0]*matrix[3][1]+
                matrix[1][1]*matrix[2][2]*matrix[3][0] - matrix[1][2]*matrix[2][1]*matrix[3][0]-
                matrix[1][0]*matrix[2][2]*matrix[3][1] - matrix[1][1]*matrix[2][0]*matrix[3][2];
        String step2 = matrix[0][0]+"×"+det1+" - "+matrix[0][1]+"×"+det2+" + "+matrix[0][2]+"×"+det3+" - "+matrix[0][3]+"×"+det4;
        String step3 = matrix[0][0]*det1+" - "+matrix[0][1]*det2+" + "+matrix[0][2]*det3+" - "+matrix[0][3]*det4+" = \n";
        double det = matrix[0][0]*det1-matrix[0][1]*det2+matrix[0][2]*det3-matrix[0][3]*det4;
        result=step1+" = "+step2+" = "+step3+" = "+ det;
        return "Δ=\n"+result;
    }

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
}
