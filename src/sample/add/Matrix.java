package sample.add;

public class Matrix {

    public double[][] matrix;

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
                result+="               |";
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

        inverseMatrix[0][0]=matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1];
        inverseMatrix[1][0]=(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0])*(-1);
        inverseMatrix[2][0]=(matrix[1][0]*matrix[2][1]-matrix[1][0]*matrix[2][0]);
        inverseMatrix[0][1]=(matrix[0][1]*matrix[2][2]-matrix[0][2]*matrix[2][1])*(-1);
        inverseMatrix[1][1]=(matrix[0][0]*matrix[2][2]-matrix[0][2]*matrix[2][0]);
        inverseMatrix[2][1]=(matrix[0][0]*matrix[2][1]-matrix[0][2]*matrix[0][1])*(-1);
        inverseMatrix[0][2]=(matrix[0][1]*matrix[1][2]-matrix[0][2]*matrix[1][1]);
        inverseMatrix[1][2]=(matrix[0][0]*matrix[1][2]-matrix[0][2]*matrix[1][0])*(-1);
        inverseMatrix[2][2]=(matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0]);
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
