package org.gp.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Tuple2<M,N> {
    private M c1;
    private N c2;
}
