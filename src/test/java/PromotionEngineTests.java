import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import PricingEngine.AddedPromotionTypeCD;
import PricingEngine.FixedPromotionTypeA;
import PricingEngine.PricingEngine;
import PricingEngine.PromotionEngine;

public class PromotionEngineTests {
	
	@Test
	public void TestFinalPriceCase1()
	{
		PricingEngine pe=new PricingEngine("ABC");
		assertEquals(Long.valueOf(100),pe.calculateFinalPrice());		
	}
	
	@Test
	public void TestFinalPriceCase2()
	{
		PricingEngine pe=new PricingEngine("AAAAABBBBBC");
		assertEquals(Long.valueOf(370),pe.calculateFinalPrice());		
	}
	
	@Test
	public void TestFinalPriceCase3()
	{
		PricingEngine pe=new PricingEngine("AAABBBBBCD");
		assertEquals(Long.valueOf(280),pe.calculateFinalPrice());		
	}
	
	@Test
	public void TestPromotion()
	{
		PromotionEngine pe=new PromotionEngine();
		assertEquals(Long.valueOf(30),pe.calculatePromotion("ABCD"));
				
	}
	
	@Test
	public void TestCheckEligibilityCD()
	{
		AddedPromotionTypeCD fpa=new AddedPromotionTypeCD();
		assertFalse(fpa.checkEligibilty("ABC"));
				
	}
	@Test
	public void TestCheckEligibilityA()
	{
		FixedPromotionTypeA fpa=new FixedPromotionTypeA();
		assertFalse(fpa.checkEligibilty("ABC"));
				
	}
	

}
