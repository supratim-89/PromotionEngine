package PricingEngine;

public class AddedPromotionTypeCD implements PromotionTypeFixedSKU {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Buy C and D: C+D=30";
	}
	
	 Long ApplyPromotionLogic(int unitPrice,Long totalFixedItem) {
			return (totalFixedItem%3)*unitPrice+130*totalFixedItem/3;
		}

	@Override
	public Long CalculatePromotion(String billeditemsku) {
		int totaladdeditem=0;
		Long calculatedCDPrice=0L;
		Long FixedItemC=billeditemsku.chars().filter(ch->ch=='C').count();
		Long FixedItemD=billeditemsku.chars().filter(ch->ch=='D').count();
		for( int i = 1; i <= FixedItemC || i <= FixedItemD; i++) {
	         if( FixedItemC%i == 0 && FixedItemD%i == 0 )
	        	 totaladdeditem = i;
	      }
		if(FixedItemC-totaladdeditem>0)
		{
			calculatedCDPrice=totaladdeditem*30+(FixedItemC-totaladdeditem)*20;
		}
		else if(FixedItemD-totaladdeditem>0)
		{
			calculatedCDPrice=totaladdeditem*30+(FixedItemD-totaladdeditem)*15;
		}
		else
			calculatedCDPrice=totaladdeditem*30L;
		return calculatedCDPrice;
	}

	@Override
	public boolean checkEligibilty(String billeditemsku) {
		Long FixedItemC=billeditemsku.chars().filter(ch->ch=='C').count();
		Long FixedItemD=billeditemsku.chars().filter(ch->ch=='D').count();
		if(FixedItemC+FixedItemD>=2)
		return true;
		else
		return false;
	}

}
