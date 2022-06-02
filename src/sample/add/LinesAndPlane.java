package sample.add;

public class LinesAndPlane {

    double[] point;
    double[] line;

    public String makeEquationLineInSpaceByTwoPoints()
    {
        return "ф";
    }



    public String isParallelPlanes() {
        double [] plane1 = point;
        double [] plane2 = line;
        String row1 = "Площини α₁ і α₂ паралельні, якщо для їх нормальних векторів n⃗₁{А₁;В₁;С₁} i n⃗₂{A₂;B₂;C₂} є істинним співвідношення:"+
                "А₁/A₂ = В₁/B₂ = С₁/C₂. Підставляємо: \n";
        String row2 = plane1[0]+"/"+plane2[0]+" =? "+plane1[1]+"/"+plane2[1]+" =? "+plane1[2]+"/"+plane2[2]+"\n";
        String row3;
        double first = plane1[0]/plane2[0];
        double second = plane1[1]/plane2[1];
        double third = plane1[2]/plane2[2];
        if(first==second) {
            if(second==third)
                row3=String.format("%.4f",first)+" = "+String.format("%.4f",second)+" = "+String.format("%.4f",third)+
                        "⇒ задані площини паралельні";
            else
                row3=String.format("%.4f",first)+" = "+String.format("%.4f",second)+" ≠ "+String.format("%.4f",third)+
                        "⇒ задані площини НЕ паралельні";
        }
        else {
            if(second==third)
                row3=String.format("%.4f",first)+" ≠ "+String.format("%.4f",second)+" = "+String.format("%.4f",third)+
                        "  ⇒ задані площини НЕ паралельні";
            else
                row3=String.format("%.4f",first)+" ≠ "+String.format("%.4f",second)+" ≠ "+String.format("%.4f",third)+
                        "  ⇒ задані площини НЕ паралельні";
        }
        return row1+row2+row3;
    }

    public String isPerpendicularPlanes()
    {
        double [] plane1 = point;
        double [] plane2 = line;

        String row1 = "Площини α₁ і α₂ перпендикулярні, якщо скалярний добуток їх нормальних векторів дорівнює 0."+
                "Нехай n⃗₁{А₁;В₁;С₁} i n⃗₂{A₂;B₂;C₂}. α₁ ⊥ α₂ ⇔ АА₂ + ВВ₂ + СС₂ = 0. Підставляємо: \n";
        String row2 = plane1[0]+"∙"+plane2[0]+" + "+plane1[1]+"∙"+plane2[1]+" + "+plane1[2]+"∙"+plane2[2]+" =? 0\n";
        String row3 = plane1[0]*plane2[0]+" + "+plane1[1]*plane2[1]+" + "+plane1[2]*plane2[2]+" =? 0 \n";
        double scalar = plane1[0]*plane2[0]+plane1[1]*plane2[1]+plane1[2]*plane2[2];
        String row4;
        if(scalar==0)
            row4 = scalar+" = 0  ⇒ задані площини перпендикулярні";
        else
            row4 = scalar+" ≠ 0  ⇒ задані площини НЕ перпендикулярні";
        return row1+row2+row3+row4;
    }


    public String findDistanceBetweenPointAndPlane() {
        double[] plane=line;

        String row1 = "Відстань від точки А(х₀;y₀;z₀) до площини \uD835\uDEFC1 шукаємо за наступною формулою:\n";
        String row2 = "d = (Ax₀ + By₀ + Cz₀ +D)/√(A² + B² + C²). Підставляємо: \n";
        String row3 = "d = ("+plane[0]+"∙"+point[0]+" + "+plane[1]+"∙"+point[1]+" + "+plane[2]+"∙"+point[2]+" + "+plane[3]+")/√("+
                plane[0]+"² + "+plane[1]+"² + "+plane[2]+"²) =\n";
        String row4 = "= ("+ String.format("%.2f",plane[0]*point[0])+" + "+ String.format("%.2f",plane[1]*point[1])+
                " + " +String.format("%.2f",plane[2]*point[2])+" + "+String.format("%.2f",plane[3])+
                ")/√("+String.format("%.2f",plane[0]*plane[0])+"+"+String.format("%.2f",plane[1]*plane[1])+
                "+"+String.format("%.2f",plane[2]*plane[2])+") =\n";
        double d = (plane[0]*point[0]+plane[1]*point[1]+plane[2]*point[2]+plane[3])/Math.sqrt(plane[0]*plane[0]+plane[1]*plane[1]+plane[2]*plane[2]);
        String row5 = "= "+String.format("%.2f",plane[0]*point[0]+plane[1]*point[1]+plane[2]*point[2]+plane[3])+"/"+
                String.format("%.4f",Math.sqrt(plane[0]*plane[0]+plane[1]*plane[1]+plane[2]*plane[2]))+" = \n"+"= "+
                String.format("%.4f",d);
        return row1+row2+row3+row4+row5;
    }




    public String findAngleBetweenPlanes() {
        double[] plane1 = point;
        double[] plane2 = line;

        String row1 = "Кут між площинами шукаємо як θ={n⃗₁^n⃗₂}. Використовуючи скалярний добуток, маємо формулу:\n"+
         "cosθ = (A₁A₂ + B₁B₂ + C₁C₂)/(√(А₁² + В₁² + С₁²)√(А₂² + В₂² + С₂²))  ⇒\n";
        String row2 = "cosθ = ("+plane1[0]+"∙"+plane2[0]+"+"+plane1[1]+"∙"+plane2[1]+"+"+plane1[2]+"∙"+plane2[2]+")/"+
                "(√("+plane1[0]+"²+"+plane1[1]+"²+"+plane1[2]+"²)√("+plane2[0]+"²+"+plane2[1]+"²+"+plane2[2]+"²)) = \n";
        String row3 = "("+ String.format("%.2f",plane1[0]*plane2[0])+"+"+ String.format("%.2f",plane1[1]*plane2[1])+"+"+
                String.format("%.2f",plane1[2]*plane2[2])+")/(√"+
                String.format("%.2f",(plane1[0]*plane1[0]+plane1[1]*plane1[1]+plane1[2]*plane1[2]))+"√"+
                String.format("%.2f",(plane2[0]*plane2[0]+plane2[1]*plane2[1]+plane2[2]*plane2[2]))+") = \n";
        double cos = (plane1[0]*plane2[0]+plane1[1]*plane2[1]+plane1[2]*plane2[2])/Math.sqrt((plane1[0]*plane1[0]+plane1[1]*plane1[1]+plane1[2]*plane1[2])*
                (plane2[0]*plane2[0]+plane2[1]*plane2[1]+plane2[2]*plane2[2]));
        String row4 = String.format("%.2f",plane1[0]*plane2[0]+plane1[1]*plane2[1]+plane1[2]*plane2[2])+" / "+
                String.format("%.2f",Math.sqrt((plane1[0]*plane1[0]+plane1[1]*plane1[1]+plane1[2]*plane1[2])*
                (plane2[0]*plane2[0]+plane2[1]*plane2[1]+plane2[2]*plane2[2])))+" = "+ String.format("%,3f",cos)+"\n";
        String row5 = "θ = arcos"+String.format("%.3f",cos)+" = "+ String.format("%.3f",Math.acos(cos)/Math.PI)+"\uD835\uDF0B = "+
                (Math.acos(cos)/Math.PI)*180+"°";

        return row1+row2+row3+row4+row5;
    }

    public String makeEquationPlaneByPointAndVector() {
        double [] vector = line;
        String row1 = "Рівняння площини, що проходить через задану точку А(х₀;у₀;z₀) і має заданий нормальний вектор n⃗{A,B,C} : " +
                "A(x - x₀) + B(y - y₀) + C(z - z₀) = 0 .\n";
        String row2 = "Підставляємо: "+vector[0]+"(x - "+point[0]+") + "+vector[1]+"(y - "+point[1]+") + "+vector[2]+"(z - "+point[2]+
                ") = 0 ⇒\n"+"Шукане рівняння площини: ";
        String row3 = vector[0]+"x + "+vector[1]+"y + "+vector[2]+"z + "+
                String.format("%.3f",(-vector[0]*point[0]-vector[1]*point[1]-vector[2]*point[2]))+" = 0.";
        String result=row1+row2+row3;
        return result;
    }

    public String makeEquationLineByTwoPoints()
    {
        double[] A=point;
        double[] B = line;
        String result="";
        String row1 = "(x-"+A[0]+") / ("+B[0]+"-"+A[0]+") = (y"+"-"+A[1]+") / ("+B[1]+"-"+A[1]+") ⇒ "+
                "(x-"+A[0]+") / "+(B[0]-A[0])+" = (y"+"-"+A[1]+") / "+(B[1]-A[1])+";\n";
        String row2 = "Загальне рівняння прямої: "+(B[1]-A[1])+"x + "+(-(B[0]-A[0]))+"y + "+(-A[0]*(B[1]-A[1])+A[1]*(B[0]-A[0])) +" = 0";
        result=row1+row2;
        return result;
    }
    public String makeEquationPerpendicularLine()
    {
        String result;
        String row1 = "Знайдемо рівняння АN, що проходить через точку А і перпендикулярне до l₁. Пряма, що проходить через точку А і " +
                "перпендикулярна до прямої Ах+Ву+С=0, має напрямний вектор (А;В), тоді представляємо її у вигляді рівняння (х-х₀)/А=(у-у₀)/В.\n"+"Рівняння прямої:\n";
        String row2 = "(x - "+point[0]+")/"+line[0]+" = (y - "+point[1]+")/"+line[1]+"  ⇒  "+line[1]+"x + "+(-line[0])+"y + "+String.format("%.3f",(-line[1]*point[0]+line[0]*point[1]))+" = 0";
        result = row1+row2;
        return result;
    }
    public String makeEquationParallelLine()
    {
        String result="";
        double D= -(line[0]*point[0]+line[1]*point[1]);
        String row1="Оскільки прямі паралельні то коефіцієнти при невідомих в них пропорційні. Рівняння паралельної прямої матиме вигляд: "+
            line[0]+"x + "+line[1]+"y + D = 0. З умови проходження прямої через точку знаходимо невідому: \n";
        String row2=line[0]+"∙"+point[0]+" + "+line[1]+"∙"+point[1]+" + D = 0 ⇒ D = -"+line[0]*point[0] +" - "+line[1]*point[1]+" = "
                +D+"\n";
        String row3 = "Отримуємо рівняння прямої: "+line[0]+"x + "+line[1]+"y + "+D+" = 0";
        result=row1+row2+row3;
        return result;
    }
    public String findIntersectionPoint()
    {
        double[] line1 = point;
        double[] line2 = line;
        String result="";
        String row1 ="Розв'яжемо систему рівнянь, утворену з рівнянь прямих l₁ i l₂. Виражаємо х (або у) з обох рівнянь:\n";
        String row2="l₁: x = -("+line1[1]+"y + "+line1[2]+") / "+line1[0]+";   l₂: x = -("+line2[1]+"y + "+line2[2]+") / "+line2[0]+".   Прирівнюємо та знаходимо у:\n";
        double y = (line1[0]*line2[2]-line1[2]*line2[0])/(line1[1]*line2[0]-line2[1]*line1[0]);
        String row3="y = ("+line1[0]+"∙"+line2[2]+"-"+line2[0]+"∙"+line1[2]+") / ("+ line2[0]+"∙"+line1[1]+"-"+line1[0]+"∙"+line2[1]+") = "+ String.format("%.3f",y)+" .\n";
        double x = -(line1[1]*y+line1[2])/line1[0];
        String row4="Підставимо знайдений у до х з l₁: х = ("+line1[1]+"∙"+String.format("%.3f",y)+" + "+line1[2]+") / "+line1[0]+" = "+String.format("%.3f",(line1[1]*y+line1[2]))+" / "+line1[0]+" = "+String.format("%.3f",x)+"\n";
        String row5 = "Координати точки перетину прямих l₁ та l₂:  ("+String.format("%.3f",x)+" ; "+String.format("%.3f",y)+")";
        result=row1+row2+row3+row4+row5;
        return result;
    }
    public String findAngleBetweenLines() {
        double[] line1 = point;
        double[] line2 = line;
        String result;
        double k1 = -line1[0]/line1[1];
        double k2 = -line2[0]/line2[1];
        String row1 = "Тангенс кута між прямими l₁ i l₂ шукаємо за формулою: tgθ = (k₂-k₁)/(1+k₁k₂), де k₁=-A₁/B₁ k₂=-A₂/B₂. \n";
        String row2 = "Маємо k₁ = -"+line1[0]+"/"+line1[1]+" = "+k1+";     k₂ = -"+line2[0]+"/"+line2[1]+" = "+k2+" . ⇒\n";
        double tg = (k2-k1)/(1+k1*k2);
        String row3 = "tgθ = ("+k2+" - "+k1+")/(1 + "+k1+"∙"+k2+") = "+(k2-k1)+"/"+(1+k1*k2)+" = "+String.format("%.3f",tg)+" ⇒ ∠θ = arctg"+String.format("%.3f",tg)+" ≈ "
                +String.format("%.3f",Math.atan(tg)/Math.PI)+"π ≈ "+String.format("%.3f",Math.atan(tg)/Math.PI*180)+"°";
        result=row1+row2+row3;
        return result;
    }
    public String findDistanceBetweenPointAndLine()
    {
        String result;
        String row1 = "Маємо формулу для пошуку відстані від точки до прямої: d = (Aх₀ + Ву₀ + С)/√(А² + В²) ⇒ \n";
        String row2 = "d = ("+line[0]+"∙"+point[0]+" + "+line[1]+"∙"+point[1]+" + "+line[2]+") / √("+line[0]+"² + "+line[1]+"²) = "+
                (line[0]*point[0]+line[1]*point[1]+line[2])+" / "+String.format("%.3f",Math.sqrt(line[0]*line[0]+line[1]*line[1]))+" = \n";
       double d=(line[0]*point[0]+line[1]*point[1]+line[2])/Math.sqrt(line[0]*line[0]+line[1]*line[1]);
        String row3 = " = "+String.format("%.3f",d)+".";
        result = row1+row2+row3;
        return result;
    }



    public LinesAndPlane(double[] point, double[] line) {
        this.point = point;
        this.line = line;
    }

    public double[] getLine() {
        return line;
    }

    public void setLine(double[] line) {
        this.line = line;
    }

    public double[] getPoint() {
        return point;
    }


    public void setPoint(double[] point) {
        this.point = point;
    }

}
