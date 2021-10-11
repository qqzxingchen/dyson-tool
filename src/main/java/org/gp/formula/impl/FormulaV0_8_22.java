package org.gp.formula.impl;

import org.gp.core.DysonFormula;
import org.gp.formula.AbsFormulaManager;

import java.util.ArrayList;
import java.util.List;

public class FormulaV0_8_22 extends AbsFormulaManager {

    @Override
    public List<DysonFormula> getFormula() {
        List<DysonFormula> formulaList = new ArrayList<>();
        formulaList.addAll( genFinal() );
        formulaList.addAll( genMid() );
        return formulaList;
    }

    private static List<DysonFormula> genFinal(){
        List<DysonFormula> formulaList = new ArrayList<>();
        formulaList.add( G(
                G(1,"小型运载火箭"),
                6,
                G(2,"戴森球组件"),
                G(4,"氘核燃料棒"),
                G(2,"量子芯片")
        ) );
        return formulaList;
    }

    private static List<DysonFormula> genMid(){
        List<DysonFormula> formulaList = new ArrayList<>();
        formulaList.add( G(
                G(2,"塑料"),
                1,
                G(1,"煤"),
                G(20,"石油气")
        ) );
        return formulaList;
    }


}
