package org.gp.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 配方
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DysonFormula {
    private DysonEntity targetEntity;
    private double costSeconds;
    private List<DysonEntity> sourceEntity;
}
