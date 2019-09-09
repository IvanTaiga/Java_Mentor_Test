package calculate;

import java.util.ArrayList;

//Класс, отвечающие за конвертацию из римских числе в арабские и из арабских в римские

public class Convert {

    public int romanToInt(String romanValue){

        int intValue=0;
        int last =0;

        ArrayList romanList = new ArrayList();
        for (int i =0; i<=1000;i++){
            romanList.add(i,"0");
        }

        romanList.set(1, "I");
        romanList.set(10, "X");
        romanList.set(100, "C");
        romanList.set(1000, "M");
        romanList.set(5, "V");
        romanList.set(50, "L");
        romanList.set(500, "D");

        for (int i = romanValue.length();i>0;i--){
            String category = romanValue.substring(i-1,i);
            int lastValue=romanList.indexOf(category);

            if (lastValue>=last){
                intValue+=lastValue;
            } else{
                intValue-=lastValue;
            }
            last = lastValue;
        }

        return intValue;
    }

    public String intToRoman(int value){

        String result="";

        while (value>0){
            if ((value/1000)>=1){
                result=result+"M";
                value=value-1000;
            }
            else if  ((value/500)>=1){
                result=result+"D";
                value=value-500;
            }
            else if ((value/100)>=1){
                result=result+"C";
                value=value-100;
            }
            else if ((value/50)>=1){
                result=result+"L";
                value=value-50;
            }
            else if ((value/10)>=1){
                result=result+"X";
                value=value-10;
            }
            else if ((value/10)<=1){
                switch ((value)) {
                    case 9:
                        result=result+"IX";
                        value=value-9;
                        break;
                    case 8:
                        result=result+"VIII";
                        value=value-8;
                        break;
                    case 7:
                        result=result+"VII";
                        value=value-7;
                        break;
                    case 6:
                        result=result+"VI";
                        value=value-6;
                        break;
                    case 5:
                        result=result+"V";
                        value=value-5;
                        break;
                    case 4:
                        result=result+"IV";
                        value=value-4;
                        break;
                    case 3:
                        result=result+"III";
                        value=value-3;
                        break;
                    case 2:
                        result=result+"II";
                        value=value-2;
                        break;
                    case 1:
                        result=result+"I";
                        value=value-1;
                        break;
                }
            }
        }
        return result;
    }
}
