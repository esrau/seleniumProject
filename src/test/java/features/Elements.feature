@Elements
Feature: Elements Feature
  Background:
    * Navigate to  https://training.qastorming.com/
    * Check homepage SHOP NOW

  Scenario: Senaryo 1
    * Click SHOP NOW button from homepage SHOP NOW
    * Check product page Products
    * Click add to cart
    * Click Cart
    * Check first product
    * Send keys quantity 3
    * Update cart
    * Product price Assert
    * Remove product
    * Check to remove product Your cart is currently empty.

  Scenario: Senaryo 3
    * Click shop
    * Check product page Products
    * Open dropdown
    * Click three products
    * Change send keys product number
    * Update cart
    * Wait for 5
    * Open billing page
    * Fill billing page
    * Open basket
    * Remove products