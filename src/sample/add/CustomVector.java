package sample.add;

public class CustomVector {
    double[] vector;


    public CustomVector(double[] vector) {
        this.vector = vector;
    }
    public double[][] mixedMatrixProduct(CustomVector otherVector1, CustomVector otherVector2)
    {
        double[] a = this.vector;
        double[] b = otherVector1.vector;
        double[] c = otherVector2.vector;

        double[][] matrix = {{a[0],a[1],a[2]},{b[0],b[1],b[2]},{c[0],c[1],c[2]}};
        return matrix;
    }
    public String mixedProduct(CustomVector otherVector1, CustomVector otherVector2)
    {
        double[][] mixedMatrix=mixedMatrixProduct(otherVector1,otherVector2);
        String line1 ="                |xᵃ⃑ yᵃ⃑ zᵃ⃑|    |"+mixedMatrix[0][0]+" "+mixedMatrix[0][1]+" "+mixedMatrix[0][2]+"|\n";
        String line2 ="a⃑∙(b⃑×c⃑)= |xᵇ⃑ yᵇ⃑ zᵇ⃑| = "+"|"+mixedMatrix[1][0]+" "+mixedMatrix[1][1]+" "+mixedMatrix[1][2]+"|\n";;
        String line3 ="                |xᶜ⃑ yᶜ⃑ zᶜ⃑ |    |"+mixedMatrix[2][0]+" "+mixedMatrix[2][1]+" "+mixedMatrix[2][2]+"|\n";;
        return line1+line2+line3;

    }
    public String vectorProduct(CustomVector otherVector)
    {   double[] a = this.vector;
        double[] b = otherVector.vector;
        double[] vectorProduct = vectorProductDouble(otherVector);
        String result="";
        String line1 ="                i⃑    j⃑   k⃑      "+"    i⃑          j⃑         k⃑  \n";
        String line2 ="(a⃑×b⃑)= |xa⃑ ya⃑ za⃑| = "+"|"+String.format("%.3f",a[0])+" "+String.format("%.3f",a[1])+" "+String.format("%.3f",a[2])+"| =\n";
        String line3 ="             |xb⃑ yb⃑ zb⃑|     |"+String.format("%.3f",b[0])+" "+String.format("%.3f",b[1])+" "+String.format("%.3f",b[2])+"|\n";
        String line4 =  "= i⃑("+String.format("%.3f",a[1])+"∙"+String.format("%.3f",b[2])+"-"+String.format("%.3f",a[2])+"∙"+String.format("%.3f",b[1])+
            ") - j⃑("+String.format("%.3f",a[0])+"∙"+String.format("%.3f",b[2])+"-"+String.format("%.3f",a[2])
                +"∙"+String.format("%.3f",b[0])+") + k⃑("+String.format("%.3f",a[0])+"∙"+String.format("%.3f",b[1])
                +"-"+String.format("%.3f",a[1])+"∙"+String.format("%.3f",b[0])+") = \n";
        String line5="= i⃑∙("+String.format("%.3f",vectorProduct[0])+") - j⃑∙("+String.format("%.3f",vectorProduct[1]*(-1))+") + k⃑∙("+String.format("%.3f",vectorProduct[2])+") = {"
                +String.format("%.3f",vectorProduct[0])+" ; " + String.format("%.3f",vectorProduct[1])+" ; "+String.format("%.3f",vectorProduct[2])+"}";
        return line1+line2+line3+line4+line5;
    }
    public double[] vectorProductDouble(CustomVector otherVector)
    {
        double[] a = this.vector;
        double[] b = otherVector.vector;
        double[] result={a[1]*b[2]-a[2]*b[1],(a[0]*b[2]-a[2]*b[0])*(-1),a[0]*b[1]-a[1]*b[0]};
        return result;
    }
    public String scalarProduct(CustomVector otherVector) {
        String step1="";
        String step2="";
        double[] a = this.vector;
        double[] b = otherVector.vector;
        for(int i=0;i<3;i++) {
            step1+=(a[i]+" ∙ "+b[i]);
            step2+=(a[i]*b[i])+"";
            if(i!=2){
                step1+=" + ";
                step2+=" + ";
            }
        }
        step1+=" =\n";
        step2+=" =";
        String finish = " "+scalarProductDouble(otherVector);
        return step1+" = "+step2+finish;
    }
    public double scalarProductDouble(CustomVector otherVector)
    {
        double[] a = this.vector;
        double[] b = otherVector.vector;
        return a[0]*b[0]+a[1]*b[1]+a[2]*b[2];

    }
    public String multiplyByNumber(double lambda)
    {
        String step1="(";
        String step2="= (";
        for(int i=0;i<3;i++) {
            step1+=(lambda+"×"+vector[i]);
            step2+=(lambda*vector[i]);
            if(i!=2){
                step1+=" ; ";
                step2+=" ; ";
            }
        }
        step1+=") =\n";
        step2+=")\n";
        return step1+step2;
    }

    public String isCollinearVectors(CustomVector otherVector)
    {
        double[] a=this.vector;
        double[] b =otherVector.vector;
        String step1 = a[0]+"/"+b[0]+"="+a[1]+"/"+b[1]+"="+a[2]+"/"+b[2]+"=\n";
        String step2 = a[0]/b[0]+"="+a[1]/b[1]+"="+a[2]/b[2]+"=\n";
        String step3="";
        if(a[0]/b[0]==a[1]/b[1]&&a[0]/b[0]==a[2]/b[2])
        {
            step3 = "a⃑∥b⃑";
        }
        else {
            step3="a⃑∦b⃑";
        }
        return step1+step2+step3;

    }
    public String lengthVector()
    {
        String step1="= √("+vector[0]+"² + "+vector[1]+"² + "+vector[2]+"²) = \n";
        String step2="= √("+vector[0]*vector[0]+" + "+vector[1]*vector[1]+" + "+vector[2]*vector[2]+") = \n";
        String step3="= √("+lengthOfVector()*lengthOfVector()+") = ";
        return step1+step2+step3+lengthOfVector();
    }
    public double lengthOfVector()
    {
        return Math.sqrt(vector[0]*vector[0]+vector[1]*vector[1]+vector[2]*vector[2]);
    }
    public String subtractionVectors(CustomVector otherVector)
    {
        String step1="(";
        String step2="(";
        double[] a = this.vector;
        double[] b = otherVector.vector;
        for(int i=0;i<3;i++)
        {
            step1+=(a[i]+" - "+b[i]);
            step2+=(a[i]-b[i])+"";
            if(i!=2){
                step1+=" ; ";
                step2+=" ; ";
            }
        }
        step1+=")";
        step2+=")";
        return step1+" = "+"\n"+" = "+step2;
    }
    public  String sumVectors(CustomVector otherVector)
    {
        String step1="(";
        String step2="(";
        double[] a = this.vector;
        double[] b = otherVector.vector;
        for(int i=0;i<3;i++)
        {
            step1+=(a[i]+" + "+b[i]);
            step2+=(a[i]+b[i])+"";
            if(i!=2){
                step1+=" ; ";
                step2+=" ; ";
            }
        }
        step1+=")";
        step2+=")";
        return step1+" = "+"\n"+" = "+step2;
    }


}
