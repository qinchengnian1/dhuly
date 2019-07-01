package com.ecms.cums.core.util;

import java.math.BigDecimal;

public class WeightUtil {

	/**
	 * 计算计费重
	 *
	 * @author 宋士恩
	 * @param length
	 *            长
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param grossWeight
	 *            毛重
	 * @return
	 * @throws Exception
	 */
	public static BigDecimal mathChargeableWeight(BigDecimal length,
			BigDecimal width, BigDecimal height, BigDecimal grossWeight)
			throws Exception {
		BigDecimal chargeableWeight = null;
		BigDecimal value = (length.multiply(width).multiply(height)).divide(
				BigDecimal.valueOf(6000), 2, BigDecimal.ROUND_HALF_UP)
				.multiply(BigDecimal.valueOf(2.205));
		if (grossWeight.compareTo(value) == -1)
			chargeableWeight = value;
		if (grossWeight.compareTo(value) == 0)
			chargeableWeight = value;
		if (grossWeight.compareTo(value) == 1)
			chargeableWeight = grossWeight;
		return chargeableWeight;
	}
}
