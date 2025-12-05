-- 1. Categories
INSERT IGNORE INTO product_category (id, category_name, description)
VALUES
    (1, 'MOBILE', 'Mobile'),
    (2, 'LAPTOP', 'Laptops'),
    (3, 'ACCESSORY', 'Accessory');

-- 2. Products
INSERT IGNORE INTO product (id, product_name, brand_name, internal_name, description, introduction_date, sales_discontinuation_date)
VALUES
    (1, 'iPhone 15',         'Apple',   'IPHONE_15_BASE', 'Latest iPhone 15 base model', '2025-01-01', NULL),
    (2, 'Samsung Galaxy S23','Samsung', 'S23_BASE',       'Samsung flagship smartphone', '2025-01-10', NULL);

-- 3. Category membership (products → MOBILE)
INSERT IGNORE INTO product_category_member (id, product_id, product_category_id, from_date, thru_date)
VALUES
    (1, 1, 1, '2025-01-01', NULL),  -- iPhone 15 → MOBILE
    (2, 2, 1, '2025-01-10', NULL);  -- S23 → MOBILE

-- 4. Price types
INSERT IGNORE INTO product_price_type (id, name, description)
VALUES
    (1, 'DEFAULT_PRICE',   'Default selling price'),
    (2, 'DISCOUNT_PRICE',  'Discounted promotional price'),
    (3, 'WHOLESALE_PRICE', 'Wholesale / bulk buyer price');

-- 5. Product prices
INSERT IGNORE INTO product_price (id, product_id, product_price_type_id, currency_uom_id, price, from_date, thru_date)
VALUES
    -- iPhone 15 prices
    (1, 1, 1,  'INR', 79999.00, '2025-01-01', NULL),
    (2, 1, 2, 'INR', 74999.00, '2025-01-15', '2025-02-15'),

    -- Samsung S23
    (3, 2, 1,  'INR', 69999.00, '2025-01-10', NULL),
    (4, 2, 2, 'INR', 65999.00, '2025-02-01', '2025-02-28');

-- Inventory
INSERT IGNORE INTO inventory_item (id, product_id, quantity_on_hand_total, available_to_promise_total)
VALUES
    (1, 1, 45, 45),
    (2, 2, 33, 33);
