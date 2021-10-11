package org.gp.core;

import java.util.Arrays;
import java.util.List;

public class Toolkit {

    public static DysonEntity genEntity(double cost, String entity ){
        return new DysonEntity( cost,entity );
    }

    public static DysonFormula genFormula(DysonEntity targetEntity, double costSeconds, DysonEntity... sourceEntityArr ){
        List<DysonEntity> sourceList = Arrays.asList( sourceEntityArr );
        return new DysonFormula( targetEntity,costSeconds,sourceList );
    }

    

}
