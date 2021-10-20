package org.gp;

import org.gp.formula.AbsFormulaManager;
import org.gp.formula.impl.FormulaV0_8_22;

import java.util.*;

public class FormulaService {

    private static void calc( String targetEntity,Double targetCount,String ... specialEntity ){
        AbsFormulaManager manager = new FormulaV0_8_22();

        Map<String, Double> costMap = manager.calcCost(
                new HashMap<String, Double>() {{
                    put(targetEntity, targetCount);
                }},
                Arrays.asList( specialEntity )
        );
        for ( String entity : specialEntity ){
            System.out.println( String.format(
                    "special %s: \t%s",
                    entity,costMap.get( entity )
            ) );
        }
        System.out.println( "\n\n\n" );
        printCost( costMap );
    }

    private static void calcMatrix( String ... specialEntity ){
        AbsFormulaManager manager = new FormulaV0_8_22();

        Map<String, Double> costMap = manager.calcCost(
                new HashMap<String, Double>() {{
                    put("宇宙矩阵",4.0);
//                    put("引力矩阵",0.1);
                }},
                Arrays.asList( specialEntity )
        );
        for ( String entity : specialEntity ){
            System.out.println( String.format(
                    "special %s: \t%s",
                    entity,costMap.get( entity )
            ) );
        }
        System.out.println( "\n\n\n" );
        printCost( costMap );
    }


    public static void main(String[] args){
//        calc("小型运载火箭",60.0);
        calcMatrix( );
    }



    private static void printCost(Map<String, Double> costMap){
        ArrayList<Map.Entry<String, Double>> list = new ArrayList<>(costMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Double>>() {
            @Override
            public int compare(Map.Entry<String,Double> o1, Map.Entry<String,Double> o2) {
                return o1.getValue().compareTo( o2.getValue() );
            }
        });



        for ( Map.Entry<String,Double> entry : list ){
            System.out.println( String.format("%s: \t%s",entry.getKey(),entry.getValue()) );
        }
    }
}
