package org.gp.core;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostManager {

    /**
     * 计算一个目标资源需要的基本资源个数
     * */
    public static Map<String, Double> calcCost(
            Map<String, Double> targetEntityMap,
            List<DysonFormula> formulaList,
            List<String> ignoredFormula
    ){
        ignoredFormula = (ignoredFormula == null) ? new ArrayList<>() : ignoredFormula;
        Map<String, DysonFormula> entityAndFormulaMap = genFormulaMap(formulaList);
        if ( entityAndFormulaMap.isEmpty() ){
            System.out.println( "配方为空" );
            return new HashMap<>();
        }
        for ( String entityStr : targetEntityMap.keySet() ){
            if ( !entityAndFormulaMap.containsKey( entityStr ) ){
                System.out.println( String.format(
                        "无法找到 %s 的配方",
                        entityStr
                ) );
                return new HashMap<>();
            }
        }

        while (true){
            boolean isChanged = realCalc(targetEntityMap, entityAndFormulaMap,ignoredFormula);
            if ( !isChanged ){
                break;
            }
        }
        return targetEntityMap;
    }

    /**
     * 返回值：
     *      Boolean:                本轮迭代，是否有更新
     *      Map<String,Integer>:    返回结果
     * */
    private static boolean realCalc(
            Map<String, Double> targetEntityMap,
            Map<String, DysonFormula> entityAndFormulaMap,
            List<String> ignoredFormula
    ){
        boolean isChanged = false;
        List<String> entityStrList = new ArrayList<>(targetEntityMap.keySet());
        for ( String curTarget : entityStrList ){
            // 如果它属于忽略的合成、或者无配方，则直接跳过
            if ( ignoredFormula.contains( curTarget ) || !entityAndFormulaMap.containsKey( curTarget ) ){
                continue;
            }

            isChanged = true;
            Double count = targetEntityMap.get( curTarget );
            DysonFormula curFormula = entityAndFormulaMap.get( curTarget );

            for (DysonEntity curSourceEntity : curFormula.getSourceEntity()){
                String key = curSourceEntity.getEntity();
                double value = count * curSourceEntity.getCount() / curFormula.getTargetEntity().getCount();
                targetEntityMap.put(
                        key,
                        value + targetEntityMap.getOrDefault( key,0.0 )
                );
            }
            targetEntityMap.remove( curTarget );
        }
        return isChanged;
    }









    private static Map<String, DysonFormula> genFormulaMap(List<DysonFormula> formulaList ){
        Map<String, DysonFormula> map = new HashMap<>();
        for ( DysonFormula ff : formulaList ){
            map.put( ff.getTargetEntity().getEntity(),ff );
        }
        return map;
    }

}
