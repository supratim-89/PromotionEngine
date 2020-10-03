package PricingEngine;



public class FixedPromotionTypeB implements PromotionTypeFixedSKU {

	@Override
	public String getDescription() {
		
		return "Buy n items of a SKU for a Fixed Price:2B for 45";
	}
	
	public Long ApplyPromotionLogic(int unitPrice,Long totalFixedItem) {
		//System.out.println("B price is :"+((totalFixedItem%2)*unitPrice+(45*Math.floor(totalFixedItem/2))));
		return ((totalFixedItem%2)*unitPrice+(long)(45*Math.floor(totalFixedItem/2)));
	}

	@Override
	public Long CalculatePromotion(String billeditemsku) {
		Long totalFixedItem=billeditemsku.chars().filter(ch->ch=='B').count();
		int unitPrice=PricingEngine.PriceList.get('B');
		return this.ApplyPromotionLogic(unitPrice, totalFixedItem);
	}

	@Override
	public boolean checkEligibilty(String billeditemsku) {
		Long totalFixedItem=billeditemsku.chars().filter(ch->ch=='B').count();
		if (totalFixedItem>=2)
			return true;
		else
			return false;
	}

}
