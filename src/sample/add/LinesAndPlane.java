package sample.add;

public class LinesAndPlane {

    double[] point;
    double[] line;

    public String eqPlaneByLineAndPoint(double[]pointLine)
    {
        double[] vectorLine = line;
        String row1 ="За умовою задачі, напрямний вектор заданої прямої S⃗={"+vectorLine[0]+"; "+vectorLine[1]+";" +vectorLine[2]+"}"+
                "лежить у шуканій площині Q. На заданій прямій лежить точка B("+pointLine[0]+"; "+pointLine[1]+"; "+
                pointLine[2]+"). \n";
        double [] vectorAM = {pointLine[0]-point[0],pointLine[1]-point[1],pointLine[2]-point[2]};
        String row2 ="Визначаємо вектор A⃗⃗В⃗={"+vectorAM[0]+"; "+vectorAM[1]+"; "+vectorAM[2]+"}. Обираємо на шуканій " +
                "площині біжучу точку C(x;y;z) і визначаємо вектор \n А⃗С⃗={x - "+String.format("%.2f",point[0])+"; y - "
                +String.format("%.2f",point[1])+"; z - "+String.format("%.2f",point[2])+"}\n";
        String  row3 = "Три веткори А⃗С⃗, A⃗⃗В⃗, S⃗ лежать в одній площині, тобто вони компланарні. За умовою компланарності " +
                "трьох векторів маємо:\n ";
        String  row4 = "|x-"+point[0]+"  y-"+point[1]+"  z-"+point[2]+"|\n"+
                "|  "+String.format("%.1f",vectorAM[0])+"     "+String.format("%.1f",vectorAM[1])+"      "+String.format("%.1f",vectorAM[2])+" | = 0\n"+
                "|  "+String.format("%.1f",vectorLine[0])+"     "+String.format("%.1f",vectorLine[1])+"      "+String.format("%.1f",vectorLine[2])+" |.\n";
        double det1 = vectorAM[1]*vectorLine[2]-vectorAM[2]*vectorLine[1];
        double det2 = -(vectorAM[0]*vectorLine[2]-vectorAM[2]*vectorLine[0]);
        double det3 = vectorAM[0]*vectorLine[1]-vectorAM[1]*vectorLine[0];
        String  row5 = "Розкладаємо визначник за елементами першого рядка. Дістаємо:"+
                String.format("%.3f",det1)+"(x-"+point[0]+") + "+String.format("%.3f",det2)+"(y-"+point[1]+") + "+
                String.format("%.3f",det3)+"(x-"+point[2]+") = 0 ⇒ \n" +
                det1+"x - "+String.format("%.3f",det1*point[0])+" + "+ det2+"y - "+String.format("%.3f",det2*point[1])+" + "
                + det3 +"z - "+String.format("%.3f",det3*point[2])+" = 0 ⇒ \n";
        String row6 = String.format("%.3f",det1)+"x + "+String.format("%.3f",det2)+"y + "+String.format("%.3f",det3) +"z + "+
                String.format("%.3f",-(det3*point[2]+det1*point[0]+det2*point[1]))+ " = 0 - шукане рівняння площини.";
        return row1+row2+row3+row4+row5+row6;
    }


    public String symmetricalPointAsForPlane()
    {
        double[]plane=line;
        String row1 = "Нехай Р - проекція точки А на задану площину. Тоді координати точки В, симетричної до А відносно \uD835\uDEFC1" +
                " знаходимо зі співвідношень: (хА+хВ)/2=хР, (yА+yВ)/2=yР, (zА+zВ)/2=zР. Тобто: xB=2xP-xA, yB=2yP-yA, zB=2zP-zA.\n";
        double t = -(line[0]*point[0]+line[1]*point[1]+line[2]*point[2]+plane[3])/(line[0]*line[0]+line[1]*line[1]+line[2]*line[2]);
        String  row2 = "Знайдемо координати точки Р як точки перетину прямої АВ і заданої площини. Напрямний вектор цієї прямої " +
                "колінеарний нормальному вектору \uD835\uDEFC1 і S⃗=n⃗={"+plane[0]+";"+plane[1]+";"+plane[2]+"}. \n" +
                "Будуємо праметричні рівняння прямої, що проходить через точку А перпендикулярно до площини: х="+plane[0]+"∙t + "+point[0]
                +", y="+plane[1]+"∙t + "+point[1]+", z="+plane[2]+"∙t + "+point[2]+". За формулою t=-(Ax₁+By₁+Cz₁+D)/(Al+Bm+Cp) " +
                "знаходимо t. Дістаємо: \n";
        String row3 ="t = -("+line[0]+"∙"+point[0]+"+"+line[1]+"∙"+point[1]+"+"+line[2]+"∙"+point[2]+"+"+line[3]+
                ")/("+line[0]+"∙"+line[0]+"+"+line[1]+"∙"+line[1]+"+"+line[2]+"∙"+line[2]+")="+String.format("%.3f",t)+"\n";
        double x = line[0]*t+point[0];
        double y = line[1]*t+point[1];
        double z = line[2]*t+point[2];
        String row4 = "Знаходимо координати точки Р: "+line[0]+"∙"+t+"+"+point[0]+"="+String.format("%.3f",x)+
            ", y="+line[1]+"∙"+t+"+"+point[1]+"="+String.format("%.3f",y)+", z="+line[2]+"∙"+t+"+"+point[2]+"="+String.format("%.3f",z)+
                " ⇒ P("+String.format("%.3f",x)+";"+String.format("%.3f",y)+";"+String.format("%.3f",z)+").\n";
        double xB = 2*x-point[0];
        double yB = 2*y-point[1];
        double zB = 2*z-point[2];
        String row5 = "Отже, хВ=2∙"+String.format("%.3f",x)+" - "+point[0]+", yB=2∙"+String.format("%.3f",y)+" - "+point[1]+
                ", zB=2∙"+String.format("%.3f",z)+" - "+point[2]+" ⇒ B("
                +String.format("%.3f",xB)+";"+String.format("%.3f",yB)+";"+String.format("%.3f",zB)+") - точка, симетрична точці А " +
                "відносно заданої площини.";
       return row1+row2+row3+row4+row5;
    }

    public String eqPLaneFromTwoParallelLines(LinesAndPlane obj)
    {
        double[] point1 = point;
        double[] vector1 =line;
        double[] point2 = obj.point;
        double[] vector2 = obj.line;
        if(!(vector1[0]/vector2[0]==vector1[1]/vector2[1]&&vector1[0]/vector2[0]==vector1[2]/vector2[2]))
        {
            return "Задані прямі не паралельні.";
        }
        double[] vectorM1M2 = new double[]{(point2[0] - point1[0]), point2[1] - point1[1], point2[2] - point1[2]};
        String row1 = "Перша пряма проходить через точку М₁("+point1[0]+";"+point1[1]+";"+point1[2]+"), друга через точку М₂("+
                point2[0]+";"+point2[1]+";"+point2[2]+"). Напрямний вектор цих прямих S⃗={"+vector1[0]+";"+vector1[1]+";"+vector1[2]+
                "}.\n";
        String row2 = "М₁⃗⃗⃗М₂={"+ String.format("%.1f",vectorM1M2[0])+";"+String.format("%.1f",vectorM1M2[1])+";"
                +String.format("%.1f",vectorM1M2[2])+"}. " + "Виберемо на шуканій площині Q точку М(x;y;z) і запишемо вектор М⃗М⃗₁⃗={x-"
                +point1[0]+";y-"+point1[1]+ ";z-"+point1[2]+
                "}. Три вектори S⃗, М₁⃗⃗⃗М₂, М⃗М⃗₁ лежать в одній площні, отже, вони компланарні. Тоді маємо:  \n";
        String  row3 = "|x-"+point1[0]+"  y-"+point1[1]+"  z-"+point1[2]+"|\n"+
                       "|  "+String.format("%.1f",vectorM1M2[0])+"     "+String.format("%.1f",vectorM1M2[1])+"      "+String.format("%.1f",vectorM1M2[2])+" | = 0\n"+
                        "|  "+String.format("%.1f",vector1[0])+"     "+String.format("%.1f",vector1[1])+"      "+String.format("%.1f",vector1[2])+" |.\n";
        double det1 = vectorM1M2[1]*vector1[2]-vectorM1M2[2]*vector1[1];
        double det2 = -(vectorM1M2[0]*vector1[2]-vectorM1M2[2]*vector1[0]);
        double det3 = vectorM1M2[0]*vector1[1]-vectorM1M2[1]*vector1[0];
        String  row4 = "Розкладаємо визначник за елементами першого рядка. Дістаємо:"+
                String.format("%.3f",det1)+"(x-"+point1[0]+") + "+String.format("%.3f",det2)+"(y-"+point1[1]+") + "+
                String.format("%.3f",det3)+"(x-"+point1[2]+") = 0 ⇒ \n" +
                det1+"x - "+String.format("%.3f",det1*point1[0])+" + "+ det2+"y - "+String.format("%.3f",det2*point1[1])+" + "
                + det3 +"z - "+String.format("%.3f",det3*point1[2])+" = 0 ⇒ \n";
        String row5 = String.format("%.3f",det1)+"x + "+String.format("%.3f",det2)+"y + "+String.format("%.3f",det3) +"z + "+
                String.format("%.3f",-(det3*point1[2]+det1*point1[0]+det2*point1[1]))+ " = 0 - шукане рівняння площини.";
        return row1+row2+row3+row4+row5;
    }

    public String eqPerpendicularPlaneToLine()
    {
        double[] vectorLine = line;
        String row1 = "Якщо пряма перпеникулярна до площини, то напрямний вектор S⃗ і нормальний вектор n⃗ площини колінеарні. " +
                "За умовою задачі S⃗={"+vectorLine[0]+";"+vectorLine[1]+";"+vectorLine[2]+"}. Тоді ⃗n=λS⃗ і n⃗=S⃗ при λ=1. " +
                "Використовуємо рівняння площини: А(х-х₁)+В(у-у₁)+С(z-z₁)=0, де n⃗={A;B;C}={"+vectorLine[0]+";"+vectorLine[1]+";"+vectorLine[2]+"}.\n";
        String row2 = "Дістаємо     "+vectorLine[0]+"(x-"+point[0]+") + "+vectorLine[1]+"(y-"+point[1]+") + "
                +vectorLine[2]+"(z-"+point[2]+") = 0 ⇒ "+vectorLine[0]+"x + "+ vectorLine[1]+"y + "+ vectorLine[2]+"z + "+
                String.format("%.3f", -(vectorLine[0]*point[0]+vectorLine[1]*point[1]+vectorLine[2]*point[2]))+
                "= 0 - шукане рівняння площини.";
        return  row1+row2;
    }



    public String findIntersectionPointBetweenPlaneAndLine(double [] pointLine)
    {
        double[] plane = point;
        double[] vectorLine = line;
        String row1 = "Запишемо рівняння заданої прямої у параметричному вигляді х="+vectorLine[0]+"∙t+"+pointLine[0]
                +", y="+vectorLine[1]+"∙t+"+pointLine[1] +", z="+vectorLine[2]+"∙t+"+pointLine[2]
                +". Підставимо до рівняння площини і отримаємо рівняння з однією змінною: \n";
        String row2 = plane[0]+"("+vectorLine[0]+"∙t+"+pointLine[0]+") + "+plane[1]+"("+vectorLine[1]+"t+"+pointLine[1]+") + "+
                plane[2]+"("+vectorLine[2]+"∙t+"+pointLine[2]+") + "+plane[3]+" = 0 ⇒ \n";
        String row3 = String.format("%.3f",plane[0]*vectorLine[0])+"∙t + "+String.format("%.3f",plane[0]*pointLine[0])+" + "+
                String.format("%.3f",plane[1]*vectorLine[1])+"∙t + "+String.format("%.3f",plane[1]*pointLine[1])+" + "+
                String.format("%.3f",plane[2]*vectorLine[2])+"∙t + "+String.format("%.3f",plane[2]*pointLine[2])+" + "+ plane[3]+" = 0 ⇒ \n";
        double t = -(plane[0]*vectorLine[0]+plane[1]*vectorLine[1]+plane[2]*vectorLine[2])/(plane[0]*pointLine[0]+plane[1]*pointLine[1]+plane[2]*pointLine[2]+plane[3]);
        String row4 = String.format("%.3f",plane[0]*vectorLine[0]+plane[1]*vectorLine[1]+plane[2]*vectorLine[2])+"∙t + "+
                String.format("%.3f",plane[0]*pointLine[0]+plane[1]*pointLine[1]+plane[2]*pointLine[2]+plane[3])+" = 0 ⇒ "+
                "t = "+String.format("%.3f",t)+".\n";
        double x = vectorLine[0]*t+pointLine[0];
        double y = vectorLine[1]*t+pointLine[1];
        double z = vectorLine[2]*t+pointLine[2];
        String  row5 = "Тоді х="+vectorLine[0]+"∙"+String.format("%.3f",t)+"+"+pointLine[0]+" = "+String.format("%.3f",x)
                +", y="+vectorLine[1]+"∙"+String.format("%.3f",t)+"+"+pointLine[1] +" = "+String.format("%.3f",y)
                +", z="+vectorLine[2]+"∙"+String.format("%.3f",t)+"+"+pointLine[2]+" = "+String.format("%.3f",z)+"\n";
        String row6 = "Отже, Р("+ String.format("%.3f",x)+";"+String.format("%.3f",y)+";"+String.format("%.3f",z)+") - шукана точка.";
        return row1+row2+row3+row4+row5+row6;

    }
    public String makeEquationPerpendicularLineToLineInSpace(double[] pointForLine)
    {
        String row1 = "Для того, щоб скласти рівняння перпендкулярної прямої, що проходить через точку" +
                ", знайдемо проекцію даної точки на задану пряму. (Детальний розв'язок у \"Знайти проекцію точки на пряму\").\n";
        double D=-(line[0]*point[0]+line[1]*point[1]+line[2]*line[2]);
        double t = -(line[0]*pointForLine[0]+line[1]*pointForLine[1]+line[2]*pointForLine[2]+D)/(line[0]*line[0]+line[1]*line[1]+line[2]*line[2]);
        double x = line[0]*t+pointForLine[0];
        double y = line[1]*t+pointForLine[1];
        double z = line[2]*t+pointForLine[2];
        String row2 = "Отже, Р("+String.format("%.3f",x)+";"+String.format("%.3f",y)+";"+String.format("%.3f",z)+") - проекція заданої точки А на задану пряму. ";
        String row3 = "Далі, складаємо рівняння прямої за двома точками.\n";
        line= new double[]{line[0] * t + pointForLine[0], line[1] * t + pointForLine[1], line[2] * t + pointForLine[2]};
        String row4 = makeEquationLineInSpaceByTwoPoints();
        return row1+row2+row3+row4;
    }
    public String findIntersectionPointBetweenTwoLinesInSpace(LinesAndPlane obj)
    {
        double[] point1 = point;
        double[] vector1 = line;
        double [] point2= obj.point;
        double [] vector2= obj.line;
        double[] vector = new double[3];
        for(int i=0;i<3;i++)
        {
            vector[i]=-(point1[i]-point2[i]);
        }
        Matrix matrix = new Matrix(new double[][]{vector1,vector2, vector});
        double det = matrix.Determinant3size();
        String row1="Для того, щоб знайти точку перетину прямих, потрібно, щоб ці прямі лежали в одній площині. " +
                "Напрямні вектори заданих прямих S⃗₁="+vector1[0]+";"+vector1[1]+";"+vector1[2]+"},S⃗₂="+vector2[0]+";"+vector2[1]+";"+vector2[2]+"}." +
                "Розглянемо ще вектор АВ, де А("+point1[0]+";"+point1[1]+";"+point1[2]+") - точка, що належить першій прямій, В("+
                +point2[0]+";"+point2[1]+";"+point2[2]+") - другій. Тоді А⃗В⃗={"+vector[0]+";"+vector[1]+";"+vector[2]+"}. За умовою" +
                " компланарності векторів маємо перевірити визначник. Дістаємо:\n";
        String row2 = "|"+vector1[0]+"  "+vector1[1]+"  "+vector1[2]+"|\n"+
                      "|"+vector2[0]+"  "+vector2[1]+"  "+vector2[2]+"|="+ det+".\n"+
                      "|"+vector[0]+"  "+ vector[1]+"  "+ vector[2]+"|        ";
        if(det!=0)
            return row1+row2+"Оскільки визначник не дорівнює нулю, то прямі не лежать в одній площині, а, отже не перетинаються";
        String row3 = "Отже, задані прямі перетинаються. Координати точки перетина повинні задовольняти рівняння обох прямих. " +
                "Запишемо їх у параметричному вигляді і розв'яжемо систему рівнянь: " +
                "x="+vector1[0]+"t₁+"+point1[0]+"; y="+vector1[1]+"t₁+"+point1[1]+"; z="+vector1[2]+"t₁+"+point1[2]+" i "+
                "x="+vector2[0]+"t₂+"+point2[0]+"; y="+vector2[1]+"t₂+"+point2[1]+"; z="+vector2[2]+"t₂+"+point2[2]+
                ". Прирівнюємо та обираємо два рівняння. Маємо рівняння: "+
                vector1[0]+"t₁-"+vector2[0]+"t₂="+(point2[0]-point1[0])+" та "+vector1[1]+"t₁-"+vector2[1]+"t₂="+(point2[1]-point1[1])+". ";
        double t2 = ((point2[1]-point1[1])*vector1[0]/vector1[1]-point2[0]+point1[0])/(vector2[0]-vector2[1]);
        double t1 = (point2[0]-point1[0]+vector2[0]*t2)/vector1[0];
        double x = vector1[0]*t1+point1[0];
        double y = vector1[1]*t1+point1[1];
        double z = vector1[2]*t1+point1[2];
        String row4 = "Отримуємо t₂="+String.format("%.3f",t2)+", a t₁="+String.format("%.3f",t1)+". Підставляємо t₁ у " +
                "параметричне рівняння першої прямої, або t₂ - до другої прямої: х="+
                vector1[0]+"∙"+String.format("%.3f",t1)+"+"+point1[0]+"="+String.format("%.3f",x)+
                "; y="+vector1[1]+"∙"+String.format("%.3f",t1)+"+"+point1[1]+"="+String.format("%.3f",y)+
                "; z="+vector1[2]+"∙"+String.format("%.3f",t1)+"+"+point1[2]+"="+String.format("%.3f",y);
        String row5 = "Отже, Р("+String.format("%.3f",x)+";"+String.format("%.3f",y)+";"+String.format("%.3f",y)+") - точка перетину заданих прямих";
        return row1+row2+row3+row4+row5;
    }

    public String findDistanceBetweenPointAndLineInSpace(double[] pointLine){
        double[] vector=line;
        String row1 = "З рівняння прямої отримаємо: S⃗ = {"+vector[0]+";"+vector[1]+";"+vector[2]+"}, M("+
                pointLine[0]+";"+pointLine[1]+";"+pointLine[2]+") - точка, що належить прямій. Тоді вектор " +
                "А⃗М⃗={"+String.format("%.3f",(pointLine[0]-point[0]))+";"+String.format("%.3f",(pointLine[1]-point[1]))+";"+
                String.format("%.3f",(pointLine[2]-point[2]))+"}. Вважаємо, що вектор А⃗М⃗=а⃗, а вектор s⃗=b⃗. " +
                "Знайдемо для них векторний добуток:\n ";
        double[] newVector = new double[]{pointLine[0] - point[0], pointLine[1] - point[1], pointLine[2] - point[2]};
        CustomVector vector1 = new CustomVector(vector);
        CustomVector vector2 = new CustomVector(newVector);
        String row2 = vector1.vectorProduct(vector2)+". \n";
        double [] product = vector1.vectorProductDouble(vector2);
        String row3 = "d = |А⃗М⃗×s⃗|/|s⃗| = √("+String.format("%.3f",product[0])+"² + "+String.format("%.3f",product[1])+"² + "+String.format("%.3f",product[2])+"² )/√("+
                vector[0]+"² + "+vector[1]+"² + "+vector[2]+"² )= √"+
                String.format("%.3f",product[0]*product[0]+product[1]*product[1]+product[2]*product[2])+"/√"+
                String.format("%.3f",vector[0]*vector[0]+vector[1]*vector[1]+vector[2]*vector[2])+" = "+
                String.format("%.3f",Math.sqrt(product[0]*product[0]+product[1]*product[1]+product[2]*product[2]))+"/"+
                String.format("%.3f",Math.sqrt(vector[0]*vector[0]+vector[1]*vector[1]+vector[2]*vector[2]))+" = "+
                String.format("%.3f",Math.sqrt(product[0]*product[0]+product[1]*product[1]+product[2]*product[2])/
                        Math.sqrt(vector[0]*vector[0]+vector[1]*vector[1]+vector[2]*vector[2]));
        return row1+row2+row3;
    }

    public String makeEquationLineInSpaceByTwoPoints() {
        double[] point1=point;
        double[] point2 =line;
        String row1="Рівняння прямої, що проходить через дві задані точки А(x₁;y₁;z₁) і В(x₂;y₂;z₂), має наступний вигляд:" +
                " (x-x₁)/(x₂-x₁)=(y-y₁)/(y₂-y₁)=(z-z₁)/(z₂-z₁). ⇒ \n";
        String row2 = "(x-"+point1[0]+")/("+point2[0]+"-"+point1[0]+")=" +
                "(y-"+point1[1]+")/("+point2[1]+"-"+point1[1]+")=" +
                "(z-"+point1[2]+")/("+point2[2]+"-"+point1[2]+") ⇒ \n";
        String row3 = "(x-"+point1[0]+")/"+String.format("%.2f",(point2[0]-point1[0]))+"=" +
                "(y-"+point1[1]+")/"+String.format("%.2f",(point2[1]-point1[1]))+"=" +
                "(z-"+point1[2]+")/"+String.format("%.2f",(point2[2]-point1[2]))+" - шукане рівняння прямої.";
        return row1+row2+row3;
    }

    public String makeEquationLineInSpaceByPointAndVector()
    {
        double[] vector = line;
        String row1 = "Канонічне рівняння прямої, що проходить через точку А(x₁;y₁;z₁) та має напрямний вектор S⃗{l;m;p}, має наступний вигляд: " +
                "(x-x₁)/l=(y-y₁)/m=(z-z₁)/p. ⇒ \n";
        String row2 = "(x-"+point[0]+")/"+vector[0]+"=" +
                "(y-"+point[1]+")/"+vector[1]+"=" +
                "(z-"+point[2]+")/"+vector[2]+" - шукане рівняння.";
        return row1+row2;
    }

    public String findProjectionPointOnLine(double [] pointForLine)
    {
        String row1="Проекція Р точки А на пряму - це основа перпендикуляра, опущеного із точки А на пряму. " +
                "Здана пряма має напрямний вектор S⃗{"+line[0]+";"+line[1]+";"+line[2]+"}. Нормальний вектор n⃗ площини, яка" +
                "перпендикулярна до заданої прямої, колінеарний вектору S⃗: S⃗||n⃗: n⃗=λS⃗, або n⃗=S⃗ при λ=1. Рівняння цієї площини буде мати вигляд:  ";
        double D=-(line[0]*point[0]+line[1]*point[1]+line[2]*line[2]);
        String row2 = line[0]+"(x-"+point[0]+")+"+line[1]+"(y-"+point[1]+")+"+line[2]+"(z-"+point[2]+")=0 або " +
                line[0]+"x + "+line[1]+"y + "+line[2]+"z + "+String.format("%.2f",D)+" = 0.\n";
        String row3 = "Знайдемо точку перетину заданої прямої (запишемо її рівняння в параметричному вигляді): " +
                "х="+line[0]+"t+"+pointForLine[0]+", y="+line[1]+"t+"+pointForLine[1]+", z="+line[2]+"t+"+pointForLine[2]+", і площини"+
                line[0]+"x + "+line[1]+"y + "+line[2]+"z + "+String.format("%.2f",D)+" = 0. ";
        String row4 = "Можна також використати формулу для знаходження параметра t=-(Ax₁+By₁+Cz₁+D)/(Al+Bm+Cp). Тоді \n";
        double t = -(line[0]*pointForLine[0]+line[1]*pointForLine[1]+line[2]*pointForLine[2]+D)/(line[0]*line[0]+line[1]*line[1]+line[2]*line[2]);
        String row5="t = -("+line[0]+"∙"+pointForLine[0]+"+"+line[1]+"∙"+pointForLine[1]+"+"+line[2]+"∙"+pointForLine[2]+"+"+String.format("%.2f",D)+
                ")/("+line[0]+"∙"+line[0]+"+"+line[1]+"∙"+line[1]+"+"+line[2]+"∙"+line[2]+")="+String.format("%.3f",t)+"\n";
        double x = line[0]*t+pointForLine[0];
        double y = line[1]*t+pointForLine[1];
        double z = line[2]*t+pointForLine[2];
        String row6 = "Підставляємо значення t у параматричне рівняння прямої і дістаємо    х="+line[0]+"∙"+t+"+"+pointForLine[0]+"="+String.format("%.3f",x)+
                ", y="+line[1]+"∙"+t+"+"+pointForLine[1]+"="+String.format("%.3f",y)+", z="+line[2]+"∙"+t+"+"+pointForLine[2]+"="+String.format("%.3f",z);
        String row7="\n"+"Маємо координати перетину прямої і площини, що проходить через задану точку, перпендикулярно до заданої прямої, " +
                "тобто Р("+String.format("%.3f",x)+"; "+String.format("%.3f",y)+"; "+String.format("%.3f",z)+") - проекція заданої точки А на задану пряму";

        return row1+row2+row3+row4+row5+row6+row7;
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
