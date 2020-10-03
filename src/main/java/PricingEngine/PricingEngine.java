package PricingEngine;

import java.util.HashMap;

public class PricingEngine {
PromotionEngine pe;
String purchasestring;
public static HashMap<Character, Integer> PriceList=new HashMap<Character,Integer>();

static {
	PriceList.put('A', 50);PriceList.put('B', 30);PriceList.put('C', 20);PriceList.put('D', 15);
}

public PricingEngine(String purchasestring)
{
	PromotionEngine pe=new PromotionEngine();
	this.pe=pe;
	this.purchasestring=purchasestring;
}

public Long calculateFinalPrice()
{
	Long finalPrice=0L;
	Long countA=purchasestring.chars().filter(ch->ch=='A').count();
	Long countB=purchasestring.chars().filter(ch->ch=='B').count();
	Long countC=purchasestring.chars().filter(ch->ch=='C').count();
	Long countD=purchasestring.chars().filter(ch->ch=='D').count();
	finalPrice+=pe.calculatePromotion(purchasestring);

	if(finalPrice==0)
	{
		finalPrice+=countA*PricingEngine.PriceList.get('A');
		finalPrice+=countB*PricingEngine.PriceList.get('B');
		finalPrice+=countC*PricingEngine.PriceList.get('C');
		finalPrice+=countD*PricingEngine.PriceList.get('D');
	}
	else if(countC==0 || countD==0)
	{
		finalPrice+=countC*PricingEngine.PriceList.get('C');
		finalPrice+=countD*PricingEngine.PriceList.get('D');
		
	}
	
	return finalPrice;
}
}
