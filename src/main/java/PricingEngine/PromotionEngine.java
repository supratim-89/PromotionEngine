package PricingEngine;



public class PromotionEngine {
	private FixedPromotionTypeA fixedpromoa;
	private FixedPromotionTypeB fixedpromob;
	private AddedPromotionTypeCD fixedpromocd;
	public PromotionEngine()
	{
		this.fixedpromoa=new FixedPromotionTypeA();
		this.fixedpromob=new FixedPromotionTypeB();
		this.fixedpromocd=new AddedPromotionTypeCD();
	}
public Long calculatePromotion(String purchasestring)
{
	
	Long priceafterpromo=0L;
	if(fixedpromoa.checkEligibilty(purchasestring))
	{
		priceafterpromo+=fixedpromoa.CalculatePromotion(purchasestring);
	}
	if(fixedpromob.checkEligibilty(purchasestring))
	{
		priceafterpromo+=fixedpromob.CalculatePromotion(purchasestring);
	}
	if(fixedpromocd.checkEligibilty(purchasestring))
	{
		priceafterpromo+=fixedpromocd.CalculatePromotion(purchasestring);
	}
	
	return priceafterpromo;
}
	

}
