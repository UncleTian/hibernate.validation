package com.lin.luo.tian.domain;

import javax.validation.GroupSequence;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import com.lin.luo.tian.checks.CarChecks;
import com.lin.luo.tian.checks.GasChecks;

@GroupSequence({GasChecks.class, CarChecks.class,RaceCar.class})
public class RaceCar {
	@NotNull
	private String type;
	@AssertTrue(message = "Race car should has a minimum speed of 200", groups = CarChecks.class)
	private boolean hasEnoughSpeed;
	@AssertTrue(message = "A race car must have enough gas before racing", groups = GasChecks.class)
	private boolean hasEnoughGas;

	public RaceCar(String type, boolean hasEnoughSpeed, boolean hasEnoughGas) {
		this.type = type;
		this.hasEnoughSpeed = hasEnoughSpeed;
		this.hasEnoughGas = hasEnoughGas;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isHasEnoughSpeed() {
		return hasEnoughSpeed;
	}

	public void setHasEnoughSpeed(boolean hasEnoughSpeed) {
		this.hasEnoughSpeed = hasEnoughSpeed;
	}

	public boolean isHasEnoughGas() {
		return hasEnoughGas;
	}

	public void setHasEnoughGas(boolean hasEnoughGas) {
		this.hasEnoughGas = hasEnoughGas;
	}

}
