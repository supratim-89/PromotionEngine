package PricingEngine;



public class FixedPromotionTypeA implements PromotionTypeFixedSKU {
	
	
	

	@Override
	public String getDescription() {
		
		return "Buy n items of a SKU for a Fixed Price:3A for 130";
	}
	
	 Long ApplyPromotionLogic(int unitPrice,Long totalFixedItem) {
		 System.out.println("A price is :"+((totalFixedItem%3)*unitPrice+(130*Math.floor(totalFixedItem/3))));
		 return (totalFixedItem%3)*unitPrice+(long)(130*Math.floor(totalFixedItem/3));
	}

	@Override
	public Long CalculatePromotion(String billeditemsku) {
		Long totalFixedItem=billeditemsku.chars().filter(ch->ch=='A').count();
		int unitPrice=PricingEngine.PriceList.get('A');
		//System.out.println("A count is :"+totalFixedItem);
		return this.ApplyPromotionLogic(unitPrice, totalFixedItem);
	}

	@Override
	public boolean checkEligibilty(String billeditemsku) {
		Long totalFixedItem=billeditemsku.chars().filter(ch->ch=='A').count();
		if (totalFixedItem>=3)
			return true;
		else
			return false;
	}

}
