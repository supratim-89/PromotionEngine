package PricingEngine;

public interface PromotionTypeFixedSKU {
String getDescription();
Long CalculatePromotion(String billeditemsku);
boolean checkEligibilty(String billeditemsku);
}
