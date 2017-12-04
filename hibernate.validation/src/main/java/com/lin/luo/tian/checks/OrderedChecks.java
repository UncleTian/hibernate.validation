package com.lin.luo.tian.checks;

import javax.validation.GroupSequence;

@GroupSequence({ GasChecks.class, CarChecks.class })
public interface OrderedChecks {

}
