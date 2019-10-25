package com.linhnguyen.demo.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.springframework.stereotype.Component;

@Component(value="uIUtil")
public class UIUtil {

	public String formatAmount(BigDecimal amount) {
		if (amount == null) {
			return "0";
		}

		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setGroupingSeparator(',');

		DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
		String formatAmount = formatter.format(amount.longValue());
		return formatAmount;
	}

}
