**Test Suite:**

**Test Case: Calculate Total Price**
-   **Input**: String of SKUs representing items in the cart.
-   **Output**: Total price of all items in the cart.
	**Test Scenarios**:

1.  Empty cart: input is an empty string.
2.  Single item in the cart: input contains a single SKU.
3.  Multiple items in the cart: input contains multiple SKUs.
4.  Items in any order: input contains SKUs in any order.
5.  Items with special offers: input contains items with special offers.
6.  Items without special offers: input contains items with regular pricing only.
7.  Items with and without special offers: input contains a mix of items with and without special offers.
8.  Non-existing item: input contains SKU that is not available in the store.
9.  Large quantities of items: input contains a large number of items to check performance.

**Test Case: Scan Item**

-   **Input**: Single SKU representing an item.
-   **Output**: None (void method).
-   **Test Scenarios**:
    1.  Valid SKU: input is a valid SKU for an item available in the store.
    2.  Invalid SKU: input is not a valid SKU for any item in the store.
    3.  Special offers applied: input is an item with special offers and it's scanned multiple times to check if the special offers are applied correctly.
    4.  Regular pricing applied: input is an item with regular pricing only. 
    
**Test Case: Pricing Information**

-   **Input**: None.
-   **Output**: Pricing information for items in the store.
-   **Test Scenarios**:
    1.  Regular price: retrieve pricing information for an item with regular pricing.
    2.  Special offer: retrieve pricing information for an item with special offers.
    3.  Special offer with different quantities: retrieve pricing information for an item with special offers of different quantities.
    4.  No pricing information available: retrieve pricing information for an item not available in the store.
